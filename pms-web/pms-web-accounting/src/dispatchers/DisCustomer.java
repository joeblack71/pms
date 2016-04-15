
package dispatchers;

import java.sql.*;

import beans.Customer;
import listas.ListaPersonas;

public class DisCustomer {

    private Connection con;
    private ResultSet  rs = null;

    private Customer    customer;

    public DisCustomer() {
    }

    public Connection getConnection() {
        return con;
    }
    public void setConnection(Connection con) {
        this.con = con;
    }

    public Customer getPersona() {
        return customer;
    }
    public void setPersona(Customer customer) {
        this.customer = customer;
    }

    public boolean validar(){
        boolean flag=false;
        try{
            String sql = "SELECT apepat,apemat,nombre,dircli,phone,fax,contact" +
                         " FROM customer" +
                         " WHERE codhot ='" + customer.getHotel()    + "'" +
                         "       clidoc ='" + customer.getDocument() + "'";
            ResultSet rs = con.createStatement().executeQuery(sql);
            if(rs.next()){
                customer.setLastname(rs.getString("apepat"));
                customer.setMiddlename(rs.getString("apemat"));
                customer.setFirstname(rs.getString("nombre"));
                customer.setAddress(rs.getString("dircli"));
                customer.setCountry(rs.getString("country"));
                customer.setPhone(rs.getString("phone"));
                customer.setFax(rs.getString("fax"));
                customer.setContact(rs.getString("contact"));
                flag = true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insertar(){
        boolean flag = false;
        try{
            String sql = "INSERT INTO" +
                         " customer(codhot,clidoc,apepat,apemat," +
                         " nombre,dircli,country,phone,fax,contact)" +
                         " VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1,customer.getHotel());
            pre.setString(2, customer.getDocument());
            pre.setString(3, customer.getLastname());
            pre.setString(4, customer.getMiddlename());
            pre.setString(5, customer.getFirstname());
            pre.setString(6, customer.getAddress());
            pre.setString(7, customer.getCountry());
            pre.setString(8, customer.getPhone());
            pre.setString(9, customer.getFax());
            pre.setString(10, customer.getContact());
            pre.executeUpdate();
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean modificar(){
        boolean flag = false;
        try{
            String sql = "UPDATE customer SET" +
                         " apepat=?,apemat=?,nombre=?,dircli=?," +
                         " country=?,phone=?,fax=?,contact=?" +
                         " WHERE codhot=? AND clidoc=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, customer.getLastname());
            pre.setString(2, customer.getMiddlename());
            pre.setString(3, customer.getFirstname());
            pre.setString(4, customer.getAddress());
            pre.setString(5, customer.getCountry());
            pre.setString(6, customer.getPhone());
            pre.setString(7, customer.getFax());
            pre.setString(8, customer.getContact());
            pre.setInt(9,customer.getHotel());
            pre.setString(10, customer.getDocument());
            pre.executeUpdate();
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean eliminar(){
        boolean flag = false;
        try{
            String sql = "DELETE FROM customer" +
                         " WHERE codhot=? AND clidoc=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, customer.getHotel());
            pre.setString(2, customer.getDocument());
            pre.executeUpdate();
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public ResultSet cargarTodos(String hotel, String pattern){
        String sql = "SELECT clidoc,apepat,apemat,nombre," +
                     "       dircli,country,phone,fax,contact" +
                     " FROM  customer" +
                     " WHERE codhot ='" + hotel + "'" + " AND" +
                     "       apepat like '" + pattern + "%'";
        try{
            rs = con.createStatement().executeQuery(sql);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

}