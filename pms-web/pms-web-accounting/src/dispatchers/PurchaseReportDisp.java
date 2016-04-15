
package dispatchers;

import java.sql.*;
import java.util.ArrayList;

import beans.*;

public class PurchaseReportDisp {

    protected Connection   con=null;
    protected Receipt      rec=null;
    protected ReceiptQuery qry=null;

    public PurchaseReportDisp() { }

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

    /** Return a List with all "Purchase Receipt" issued in an
    * specific period. Mainly used by "Purchase Register" report.
    */
    public ArrayList getPurchaseByPeriod(boolean purchaseRegister) {
        ArrayList rbpList = new ArrayList();
        String dateField = ( purchaseRegister ) ? "dPaymentDate" : "dIssueDate";
        String monthDay = ( qry.getMonthDay() != 0 )
            ? " AND day(dIssueDate) = " + String.valueOf( qry.getMonthDay() ) : "";
        String sql = "SELECT nReceiptType, nReceiptSerial, nCorrelative," +
                           " dIssueDate, dPaymentDate, p.nProviderRUC, p.tProviderName," +
                           " nNet, nTax1, nService, nReceiptTotal, bExempt," +
                           " tMoney, nExchangeRate, tStatus" +
                           " FROM (SELECT * FROM purchase" +
                                  " WHERE nHotelId = " + qry.getHotelId() + " AND" +
                                  " year(" + dateField + ")  = " + qry.getPeriod()  + " AND" +
                                  " month(" + dateField + ") = " + qry.getMonth() + monthDay +
                                  " ) AS p" +
                                " LEFT JOIN provider AS pv ON p.nProviderRUC = pv.nProviderRUC" +
                           " ORDER BY dIssueDate, nCorrelative" ;
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
                //r.setAnotherTax( rs.getBoolean(12) );
                r.setMoney( rs.getString(13) );
                r.setExchange( rs.getDouble(14) );
                r.setStatus( rs.getString(15) );
                rbpList.add(r);
            }
        } catch (Exception e) { e.printStackTrace(); }

        return rbpList;
    }

    public ArrayList getPurchaseByDate(){
        ArrayList rbpList = new ArrayList();
        String QUERY = "SELECT nReceiptType, nReceiptSerial, nCorrelative" +
                             " dIssueDate, tProviderName" +
                             " FROM  purchase" +
                             " WHERE nHotelId = "    + qry.getHotelId() + " AND" +
                                   " dIssueDate = '" + qry.getQueryDate() + "'" +
                             " ORDER BY dIssueDate ASC, nCorrelative";
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

    public ArrayList getPurchaseByProvider() {
        ArrayList rbcList = new ArrayList();
        String strwhere = ( qry.getPeriod() == 0 )
                          ? " WHERE nProviderRUC = '" + qry.getCustomerDoc() + "'"
                          : " WHERE nProviderRUC = '" + qry.getCustomerDoc() + "'" +
                                  " AND year(dIssued) = " + qry.getPeriod();
        String QUERY = "SELECT * FROM  purchase" + strwhere +
                           " ORDER BY dIssueDate ASC, nCorrelative" ;
        //System.out.println(QUERY);
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
                rec.setEntityId( rs.getString("nProviderRUC") );
                rec.setEntityName( rs.getString("tProviderName") );
                rec.setExempt( rs.getBoolean("bExempt") );
                rec.setApplyService( rs.getBoolean("bApplyService") );
                rec.setNet( rs.getDouble("nNet") );
                rec.setTax1( rs.getDouble("nTax1") );
                rec.setService( rs.getDouble("nService") );
                rec.setReceiptTotal( rs.getDouble("nTotalReceipt") );
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

    public ArrayList getPurchaseByProduct() {
        ArrayList rbcList = new ArrayList();
        String strwhere = ( qry.getPeriod() == 0 )
                          ? " WHERE nProviderRUC = '" + qry.getCustomerDoc() + "'"
                          : " WHERE nProviderRUC = '" + qry.getCustomerDoc() + "'" +
                                  " AND year(dIssued) = " + qry.getPeriod();
        String QUERY = "SELECT * FROM  purchase" + strwhere +
                           " ORDER BY dIssueDate ASC, nCorrelative" ;
        //System.out.println(QUERY);
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
                rec.setEntityId( rs.getString("nProviderRUC") );
                rec.setEntityName( rs.getString("tProviderName") );
                rec.setNet( rs.getDouble("nNet") );
                rec.setTax1( rs.getDouble("nTax1") );
                rec.setService( rs.getDouble("nService") );
                rec.setReceiptTotal( rs.getDouble("nTotalReceipt") );
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

    public ArrayList getConsumptionRanking() {
        ArrayList cpList = new ArrayList();
        //String BLANKS = "";
        String sql = "SELECT period, providerId, providerName," +
                           " net_total, tax1_total, tax2_total, production" +
                           " FROM (SELECT year(dIssueDate) AS period," +
                                      " nProviderRUC as providerId," +
                                      " p.tProviderName AS providerName," +
                                      " SUM(nNet)  AS net_Total," +
                                      " SUM(nTax1) AS tax1_Total," +
                                      " SUM(nService) AS tax2_Total," +
                                      " SUM(nReceiptTotal) AS production" +
                                      " FROM purchase" +
	                              " WHERE nHotelId ="       + qry.getHotelId() + " AND" +
                                      " year(dIssueDate) ="  + qry.getPeriod()  + " AND" +
                                      /*" month(dIssueDate) =" + qry.getMonth() + " AND" +
                                      " day(dIssueDate)   =" + qry.getDayMonth() + " AND" +*/
                                      " p.nProviderRUC != ''" + //BLANKS + "'" +
                                " GROUP BY p.nProviderRUC ) AS p" +
                           " LEFT JOIN provider AS pv ON r.providerId = p.nProviderRUC" +
                           " ORDER BY production DESC" ;
        System.out.println("\n"+sql+"\n");
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