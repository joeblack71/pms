
package dispatchers;

import java.sql.*;
import java.util.ArrayList;

import beans.*;

public class CompanyDisp {

    private Connection  con;
    private Company     cia;

    public CompanyDisp() {
    }

    public Connection getConnection() {
        return con;
    }
    public void setConnection(Connection _con) {
        this.con = _con;
    }

    public Company getCompany() {
        return cia;
    }
    public void setCompany(Company _cia) {
        this.cia = _cia;
    }

    public boolean validate() {
        boolean flag=false;
        String QUERY = "SELECT * FROM company" +
                             " WHERE nHotelId =" + cia.getHotelId() + " AND" +
                                   " nCompanyRUC ='" + cia.getEntityDoc() + "'";
        //System.out.println(QUERY);
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            if ( rs.next() ) {
                cia.setEntityName(rs.getString("tCompanyName"));
                cia.setAddress1(rs.getString("tAddress1"));
                cia.setCountry(rs.getString("nCountryId"));
                cia.setPhone1(rs.getString("nPhone1"));
                cia.setFax(rs.getString("nFax"));
                cia.setContact(rs.getString("tContact"));
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insert() {
        boolean flag = false;
        String QUERY = "INSERT INTO" +
                             " company(nHotel,tCustomerId,tDescription," +
                             "tAddress1,tCountry,tPhone1,tFax,tContact)" +
                             " VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(QUERY);
            pre.setShort(1,cia.getHotelId());
            pre.setString(2,cia.getEntityDoc());
            pre.setString(3,cia.getEntityName());
            pre.setString(4,cia.getAddress1());
            pre.setString(5,cia.getCountry());
            pre.setString(6,cia.getPhone1());
            pre.setString(7,cia.getFax());
            pre.setString(8,cia.getContact());
            //System.out.println(pre);
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean update() {
        boolean flag = false;
        String QUERY = "UPDATE company SET" +
                             " tEntityName=?,tAddress1=?,tCountry=?," +
                             "tPhone1=?,tFax=?,tContact=?" +
                             " WHERE nHotelId=? AND tCustomerId=?";
        try {
            PreparedStatement pre = con.prepareStatement(QUERY);
            pre.setString(1,cia.getEntityName());
            pre.setString(2,cia.getAddress1());
            pre.setString(3,cia.getCountry());
            pre.setString(4,cia.getPhone1());
            pre.setString(5,cia.getFax());
            pre.setString(6,cia.getContact());
            pre.setShort(7,cia.getHotelId());
            pre.setString(8,cia.getEntityDoc());
            //System.out.println(pre);
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delete() {
        boolean flag = false;
        try {
            String QUERY = "DELETE FROM company" +
                                 " WHERE nHotelId=? AND tCustomerId=?";
            PreparedStatement pre = con.prepareStatement(QUERY);
            pre.setShort(1, cia.getHotelId());
            pre.setString(2, cia.getEntityDoc());
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

}