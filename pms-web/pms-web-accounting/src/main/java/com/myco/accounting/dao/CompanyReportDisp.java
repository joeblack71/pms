
package dispatchers;

import java.sql.*;
import java.util.ArrayList;

import beans.*;

public class CompanyReportDisp {

    private Connection    con;
    private CustomerQuery qry;

    public CompanyReportDisp() {
    }

    public Connection getConnection() {
        return con;
    }
    public void setConnection(Connection _con) {
        this.con = _con;
    }

    public CustomerQuery getCustomerQuery() {
        return qry;
    }
    public void setCustomerQuery(CustomerQuery _qry) {
        this.qry = _qry;
    }

    public ArrayList getAllCompanies() {
        ArrayList companyList = new ArrayList();
        String QUERY = "SELECT * FROM  company" +
                           " WHERE nHotelId =" + qry.getHotelId();
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while ( rs.next() ) {
                Company c = new Company();
                c.setEntityDoc( rs.getString("nCompanyRUC") );
                c.setEntityName( rs.getString("tCompanyName") );
                c.setAddress1( rs.getString("tAddress1") );
                c.setPhone1( rs.getString("nPhone1") );
                companyList.add(c);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return companyList;
    }

    public ArrayList getCompanyPattern() {
        ArrayList companyList = new ArrayList();
        String fieldName = ( qry.getField().equals("customerName") )
                           ? "tCompanyName" : "nCompanyRUC" ;
        String QUERY = "SELECT * FROM company" +
                             " WHERE nHotelId = " + qry.getHotelId() + " AND " +
                                     fieldName + " LIKE '" + qry.getPattern() + "%'" +
                             " ORDER BY tCompanyName";
        //System.out.println(QUERY);
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while ( rs.next() ) {
                Company c = new Company();
                c.setHotelId( rs.getShort("nHotelId") );
                c.setEntityDoc( rs.getString("nCompanyRUC") );
                c.setEntityName( rs.getString("tCompanyName") );
                c.setAddress1( rs.getString("tAddress1") );
                c.setPhone1( rs.getString("nPhone1") );
                companyList.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return companyList;
    }

    public ArrayList getCompanyPattern(String hotel) { // Only for "DERRAMA"
        ArrayList companyList = new ArrayList();
        String QUERY = "SELECT tCodigoTributario,tRazonSocialCompania," +
                             "       tDireccion,tTelefono1,tFax1" +
                             " FROM  tcompania" +
                             " WHERE tRazonSocialCompania LIKE '" + qry.getPattern() + "%'";
        //System.out.println(QUERY);
        try{
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while ( rs.next() ) {
                Company c = new Company();
                c.setEntityDoc( rs.getString("nCompanyRUC") );
                c.setEntityName( rs.getString("tCompanyName") );
                c.setAddress1( rs.getString("tAddress1") );
                c.setPhone1( rs.getString("nPhone1") );
                companyList.add(c);
            }    
        }catch (Exception e){
            e.printStackTrace();
        }

        return companyList;
    }

}