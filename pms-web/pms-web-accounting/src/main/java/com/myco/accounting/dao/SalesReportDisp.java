
package dispatchers;

import java.sql.*;
import java.util.ArrayList;

import beans.*;

public class SalesReportDisp {

    protected Connection   con=null;
    protected Receipt      rec=null;
    protected ReceiptQuery qry=null;

    public SalesReportDisp() { }

    public Connection getConnection() {
        return con;
    }
    public void setConnection(Connection con) {
        this.con = con;
    }

    public Receipt getReceipt() {
        return rec;
    }
    public void setReceipt(Receipt rec) {
        this.rec = rec;
    }

    public ReceiptQuery getReceiptQuery() {
        return qry;
    }
    public void setReceiptQuery(ReceiptQuery qry) {
        this.qry  = qry;
    }

    /** Return a List with all "Sales Receipt" issued in an
    * specific period. Generally this is requested by the
    * "Sales Register" report.
    */
    public ArrayList getSalesByPeriod() {
        ArrayList rbpList = new ArrayList();
        String monthDay = ( qry.getMonthDay() != 0 )
            ? " AND day(dIssueDate) = " + String.valueOf( qry.getMonthDay() ) : "";
        String sql = "SELECT nReceiptType, nReceiptSerial, nCorrelative," +
                           " dIssueDate, dPaymentDate, tCustomerDoc, tCustomerName," +
                           " nNet, nTax1, nService, nReceiptTotal, bExempt," +
                           " tMoney, nExchangeRate, tStatus" +
                           " FROM (SELECT * FROM receipt" +
                                  " WHERE nHotelId    = " + qry.getHotelId()  + " AND" +
                                  " year(dIssueDate)  = " + qry.getPeriod() + " AND" +
                                  " month(dIssueDate) = " + qry.getMonth()  + monthDay +
                                  " ) AS r" +
                                //" LEFT JOIN company AS c ON r.tCustomerDoc = c.nCompanyRUC" +
                           " ORDER BY dIssueDate,nCorrelative" ;
        System.out.println("\n"+sql+"\n");
        ResultSet rs = null;
        try {
            rs = con.createStatement().executeQuery(sql);
            while ( rs.next() ) {
                Receipt r = new Receipt();
                r.setReceiptType( rs.getShort(1) );
                r.setReceiptSerial( rs.getShort(2) );
                r.setCorrelative( rs.getInt(3) );
                r.setIssueDate( rs.getDate(4) );
                r.setPaymentDate( rs.getDate(5) );
                r.setEntityId( rs.getString(6) );
                r.setEntityName( rs.getString(7) );
                r.setNet( rs.getDouble(8) );
                r.setTax1( rs.getDouble(9) );
                r.setService( rs.getDouble(10) );
                r.setReceiptTotal( rs.getDouble(11) );
                r.setExempt( rs.getBoolean(12) );
                r.setMoney( rs.getString(13) );
                r.setExchange( rs.getDouble(14) );
                r.setStatus( rs.getString(15) );
                rbpList.add(r);
            }
        } catch (Exception e) { e.printStackTrace(); }

        return rbpList;
    }

    /** Return a List with all "Sales Receipt" issued in an
    * specific Date. Basically used by "Sales Receipt Register".
    */
    public ArrayList getSalesByDate(boolean issueDate) {
        ArrayList rbpList = new ArrayList();
        String dateField = (issueDate) ? "dIssueDate" : "dPaymentDate" ;
        String QUERY = "SELECT nReceiptType, nReceiptSerial, nCorrelative," +
                             " dIssueDate, tCustomerName" +
                             " FROM  receipt" +
                             " WHERE nHotelId = "    + qry.getHotelId() + " AND " +
                                     dateField + " >= '" + qry.getQueryDate() + "'" +
                             " ORDER BY nCorrelative limit 20";
        //System.out.println(QUERY);
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while ( rs.next() ) {
                Receipt r = new Receipt();
                r.setReceiptType( rs.getShort(1) );
                r.setReceiptSerial( rs.getShort(2) );
                r.setCorrelative( rs.getInt(3) );
                r.setIssueDate( rs.getDate(4) );
                r.setEntityName( rs.getString(5) );
                rbpList.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rbpList;
    }

    /** Return a List with all "Sales Receipt" issued for an
    * specific Customer. Used by "Customer Production" report.
    */
    public ArrayList getSalesByCustomerDoc() {
        ArrayList rbcList = new ArrayList();
        String strwhere = ( qry.getPeriod() == 0 )
                          ? " WHERE tCustomerDoc LIKE '" + qry.getCustomerDoc() + "%'"
                          : " WHERE tCustomerDoc LIKE '" + qry.getCustomerDoc() + "%'" +
                                  " AND year(dIssueDate) = " + qry.getPeriod();
        String QUERY = "SELECT * FROM  receipt" + strwhere +
                           " ORDER BY dIssueDate ASC, nCorrelative" ;
        System.out.println(QUERY);
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while ( rs.next() ) {
                Receipt rec = new Receipt();
                rec.setHotelId( rs.getShort("nHotelId") );
                rec.setReceiptType( rs.getShort("nReceiptType") );
                rec.setReceiptSerial( rs.getShort("nReceiptSerial") );
                rec.setCorrelative( rs.getInt("nCorrelative"));
                rec.setIssueDate( rs.getDate("dIssueDate") );
                rec.setPaymentDate( rs.getDate("dPaymentDate") );
                rec.setEntityId( rs.getString("tCustomerDoc") );
                rec.setEntityName( rs.getString("tCustomerName") );
                rec.setNet( rs.getDouble("nNet") );
                rec.setExempt( rs.getBoolean("bExempt") );
                rec.setTax1( rs.getDouble("nTax1") );
                rec.setApplyService( rs.getBoolean("bApplyService") );
                rec.setService( rs.getDouble("nService") );
                rec.setReceiptTotal( rs.getDouble("nReceiptTotal") );
                rec.setPaymentType( rs.getShort("nPaymentType") );
                rec.setMoney( rs.getString("tMoney") );
                rec.setExchange( rs.getDouble("nExchangeRate") );
                rec.setStatus( rs.getString("tStatus") );
                rec.setMadeBy( rs.getString("tMadeBy") );
                rec.setMadeOn( rs.getString("dMadeOn") );
                rec.setUpdatedBy( rs.getString("tUpdatedBy") );
                rec.setUpdatedOn( rs.getString("dUpdatedOn") );
                rbcList.add(rec);
            }
        } catch (SQLException sqle) {
              sqle.printStackTrace();
        } catch (Exception e){
              e.printStackTrace();
        }
        return rbcList;
   }

    public ArrayList getSalesByCustomerName() {
        ArrayList rbcList = new ArrayList();
        String QUERY = "SELECT * FROM  receipt" +
                             " WHERE tCustomerName like '" + qry.getCustomerName() + "%'" +
                             " ORDER BY tCustomerName" ;
        System.out.println(QUERY);
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while ( rs.next() ) {
                Receipt rec = new Receipt();
                rec.setHotelId( rs.getShort("nHotelId") );
                rec.setReceiptType( rs.getShort("nReceiptType") );
                rec.setReceiptSerial( rs.getShort("nReceiptSerial") );
                rec.setCorrelative( rs.getInt("nCorrelative"));
                rec.setIssueDate( rs.getDate("dIssueDate") );
                rec.setPaymentDate( rs.getDate("dPaymentDate") );
                rec.setEntityId( rs.getString("tCustomerDoc") );
                rec.setEntityName( rs.getString("tCustomerName") );
                rec.setNet( rs.getDouble("nNet") );
                rec.setTax1( rs.getDouble("nTax1") );
                rec.setService( rs.getDouble("nService") );
                rec.setReceiptTotal( rs.getDouble("nReceiptTotal") );
                rec.setExempt( rs.getBoolean("bExempt") );
                rec.setApplyService( rs.getBoolean("bApplyService") );
                rec.setPaymentType( rs.getShort("nPaymentType") );
                rec.setMoney( rs.getString("tMoney") );
                rec.setExchange( rs.getDouble("nExchangeRate") );
                rec.setStatus( rs.getString("tStatus") );
                rec.setMadeBy( rs.getString("tMadeBy") );
                rec.setMadeOn( rs.getString("dMadeOn") );
                rec.setUpdatedBy( rs.getString("tUpdatedBy") );
                rec.setUpdatedOn( rs.getString("dUpdatedOn") );
                rbcList.add(rec);
            }
        } catch (SQLException sqle) {
              sqle.printStackTrace();
        } catch (Exception e){
              e.printStackTrace();
        }
        return rbcList;
   }

    /** Return a List with "Sales Summarized" by Customer
    * in an specific period. Mainly used by "Production by Customer"
    * report.
    */
    public ArrayList getCustomerProduction() {
        ArrayList cpList = new ArrayList();
        //String BLANKS = "";
        String month = ( qry.getMonth() != 0 )
                       ? " month(dIssueDate) = " + String.valueOf( qry.getMonth() ) + " AND ": "";
        String monthDay = ( qry.getMonthDay() != 0 )
                       ? " day(dIssueDate) = " + String.valueOf( qry.getMonthDay() ) + " AND ": "";
        String sql = "SELECT period, customerId, tCustomerName," +
                           " net_total, tax1_total, tax2_total, production" +
                           " FROM (SELECT year(dIssueDate) AS period," +
                                      " tCustomerDoc as customerId, tCustomerName," +
                                      " SUM(nNet)  AS net_Total," +
                                      " SUM(nTax1) AS tax1_Total," +
                                      " SUM(nService) AS tax2_Total," +
                                      " SUM(nReceiptTotal) AS production" +
                                      " FROM receipt" +
	                              " WHERE nHotelId ="    + qry.getHotelId() + " AND" +
                                      " year(dIssueDate) ="  + qry.getPeriod()  + " AND" +
                                        month + monthDay + " tCustomerDoc != ''" + 
                                " GROUP BY tCustomerDoc ) AS r" +
                           //" LEFT JOIN company AS c ON r.customerId = c.nCompanyRUC" +
                           " WHERE production > " + qry.getProduction() +
                           " ORDER BY production DESC" ;
        //System.out.println("\n"+sql+"\n");
        ResultSet rs = null;
        try {
            rs = con.createStatement().executeQuery(sql);
            while ( rs.next() ) {
                CustomerProduction cp = new CustomerProduction();
                //cp.setHotelId( rs.getString("hotel") );
                cp.setPeriod( rs.getString(1) );
                cp.setCustomerId( rs.getString(2) );
                cp.setCustomerName( rs.getString(3) );
                cp.setNetTotal( rs.getDouble(4) );
                cp.setTax1Total( rs.getDouble(5) );
                cp.setTax2Total( rs.getDouble(6) );
                cp.setProduction( rs.getDouble(7) );
                cpList.add(cp);
            }
        } catch (Exception e) { e.printStackTrace(); }

        return cpList;
    }

}