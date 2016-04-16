
package dispatchers;

import java.sql.*;
import java.util.ArrayList;

import beans.*;

public class DMSalesReportDisp extends SalesReportDisp {

    public DMSalesReportDisp() { }

    public ArrayList getSalesByPeriod(String hotel) {
        ArrayList rbpList = new ArrayList();
        String sql = "SELECT fFecha, md.tDocumento, tRazonSocial," +
                           " nNeto, j1.nPrecioImpuesto as nIGV," +
                           " j2.nPrecioImpuesto as nService, nVenta," +
                           " tMoneda, nTipoCambio" +
                           " FROM mdocumento as md" +
                                " LEFT JOIN timpuestomdocumento AS j1 ON" +
                                " md.tDocumento = j1.tDocumento AND j1.tCodigoImpuesto = 1" +
                                " LEFT JOIN timpuestomdocumento AS j2 ON" +
                                " md.tDocumento = j2.tDocumento AND j2.tCodigoImpuesto = 2" +
                           " WHERE md.tHotel ='"     + qry.getHotelId()  + "' AND" +
                                 " year(fFecha) ='"  + qry.getPeriod() + "' AND" +
                                 " month(fFecha) ='" + qry.getMonth()  + "'" +
                           " ORDER BY fFecha ASC" ;
        //System.out.println(sql);
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while ( rs.next() ) {
                Receipt r = new Receipt();
                r.setIssueDate( rs.getDate(1) );
                //r.setReceiptType( rs.getShort("tDocumento") );
                //r.setReceiptSerial( rs.getShort("tDocumento") );
                r.setCorrelative( rs.getShort(2) ); // must fail, tDocumento is Char
                r.setEntityName( rs.getString(3) );
                r.setNet( rs.getDouble(4) );
                r.setTax1( rs.getDouble(5) );
                r.setService( rs.getDouble(6) );
                r.setReceiptTotal( rs.getDouble(7) );
                r.setMoney( rs.getString(8) );
                r.setExchange( rs.getDouble(9) );
                rbpList.add(r);
            }
        } catch (Exception e) { e.printStackTrace(); }

        return rbpList;
    }

    // Todo: test
    public ArrayList getSalesByCustomer(String hotel){
        ArrayList rbcList = new ArrayList();
        String sql = "SELECT md.tHotel, fFecha, md.tDocumento," +
                           " nNeto, j1.nPrecioImpuesto AS igv," +
                           " j2.nPrecioImpuesto AS srv, nVenta," +
                           " tMoneda, nTipoCambio" +
                           " FROM   mdocumento AS md" +
                           " LEFT JOIN timpuestomdocumento AS j1 ON" +
                           "      md.tDocumento = j1.tDocumento AND j1.tCodigoImpuesto = 1" +
                           " LEFT JOIN timpuestomdocumento AS j2 ON" +
                           "      md.tDocumento = j2.tDocumento AND j2.tCodigoImpuesto = 2" +
                           " WHERE tCodigoTributario = '" + qry.getCustomerDoc() + "'" +
                           " ORDER BY md.tHotel ASC, fFecha ASC" ;
        //System.out.println(sql);
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while ( rs.next() ) {
                CustomerProduction cp = new CustomerProduction();
                cp.setHotelId( rs.getShort(1) );
                cp.setPeriod( rs.getString(2) );
                cp.setCustomerId( rs.getString(3) );
                cp.setCustomerName( rs.getString(4) );
                cp.setNetTotal( rs.getDouble(5) );
                cp.setTax1Total( rs.getDouble(6) );
                cp.setTax2Total( rs.getDouble(7) );
                cp.setProduction( rs.getDouble(8) );
                rbcList.add(cp);
            }
        } catch (Exception e){ e.printStackTrace(); }
        return rbcList;
    }

    /* Todo: modificar 'sql' */
    public ArrayList getCustomerProduction(String company) {
        ArrayList cpList = new ArrayList();
        //String BLANKS = "";
        String sql = "SELECT md.tHotel,fFecha,md.tDocumento," +
                     "       round(nNeto,2),round(j1.nPrecioImpuesto,2)as igv," +
                     "       round(j2.nPrecioImpuesto,2) as srv,round(nVenta,2)," +
                     "       tMoneda,round(nTipoCambio,3)" +
                     "FROM   mdocumento as md" +
                     "       LEFT JOIN timpuestomdocumento AS j1 ON" +
                     "       md.tDocumento = j1.tDocumento AND j1.tCodigoImpuesto = 1" +
                     "       LEFT JOIN timpuestomdocumento AS j2 ON" +
                     "       md.tDocumento = j2.tDocumento AND j2.tCodigoImpuesto = 2" +
                     "       WHERE tCodigoTributario = '" + qry.getCustomerDoc() + "'" +
                     "ORDER BY md.tHotel ASC,fFecha ASC" ;
        //System.out.println("\n"+sql+"\n");
        ResultSet rs = null;
        try {
            rs = con.createStatement().executeQuery(sql);
            while ( rs.next() ) {
                CustomerProduction cp = new CustomerProduction();
                cp.setHotelId( rs.getShort(1) );
                cp.setPeriod( rs.getString(2) );
                cp.setCustomerId( rs.getString(3) );
                cp.setCustomerName( rs.getString(4) );
                cp.setNetTotal( rs.getDouble(5) );
                cp.setTax1Total( rs.getDouble(6) );
                cp.setTax2Total( rs.getDouble(7) );
                cp.setProduction( rs.getDouble(8) );
                cpList.add(cp);
            }
        } catch (Exception e) { e.printStackTrace(); }

        return cpList;
    }

}