
package dispatchers;

import java.sql.*;
import java.util.ArrayList;

import beans.*;

public class ProviderDisp {

    private Connection  con;
    private Provider    prv;

    public ProviderDisp() {
    }

    public Connection getConnection() {
        return con;
    }
    public void setConnection(Connection con) {
        this.con = con;
    }

    public Provider getProvider() {
        return prv;
    }
    public void setProvider(Provider prv) {
        this.prv = prv;
    }

    public boolean validate() {
        boolean flag=false;
        String QUERY = "SELECT tProviderName FROM provider" +
                             " WHERE nHotelId =" + prv.getHotelId() + " AND" +
                                   " nProviderRUC ='" + prv.getEntityDoc() + "'";
        System.out.println(QUERY);
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            if ( rs.next() ) {
                prv.setEntityName( rs.getString(1) );
                /*prv.setAddress1(rs.getString("tAddress1"));
                prv.setCountry(rs.getString("tCountry"));
                prv.setPhone1(rs.getString("tPhone1"));
                prv.setPhone2(rs.getString("tPhone2"));
                prv.setContact(rs.getString("tContact"));*/
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
                             " provide(nHotel,tCustomerId,tDescription," +
                             "tAddress1,tCountry,tPhone1,tFax,tContact)" +
                             " VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(QUERY);
            pre.setShort(1,prv.getHotelId());
            pre.setString(2,prv.getEntityDoc());
            pre.setString(3,prv.getEntityName());
            pre.setString(4,prv.getAddress1());
            pre.setString(5,prv.getCountry());
            pre.setString(6,prv.getPhone1());
            pre.setString(7,prv.getFax());
            pre.setString(8,prv.getContact());
            System.out.println(pre);
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean update() {
        boolean flag = false;
        String QUERY = "UPDATE provide SET" +
                             " tEntityName=?,tAddress1=?,tCountry=?," +
                             "tPhone1=?,tFax=?,tContact=?" +
                             " WHERE nHotel=? AND tCustomerId=?";
        try {
            PreparedStatement pre = con.prepareStatement(QUERY);
            pre.setString(1,prv.getEntityName());
            pre.setString(2,prv.getAddress1());
            pre.setString(3,prv.getCountry());
            pre.setString(4,prv.getPhone1());
            pre.setString(5,prv.getFax());
            pre.setString(6,prv.getContact());
            pre.setShort(7,prv.getHotelId());
            pre.setString(8,prv.getEntityDoc());
            System.out.println(pre);
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
            String QUERY = "DELETE FROM provide" +
                                 " WHERE nHotel=? AND tCustomerId=?";
            PreparedStatement pre = con.prepareStatement(QUERY);
            pre.setShort(1, prv.getHotelId());
            pre.setString(2, prv.getEntityDoc());
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

}