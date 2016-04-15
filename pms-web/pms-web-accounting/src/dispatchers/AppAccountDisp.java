
package dispatchers;

import java.sql.*;
import java.util.ArrayList;

import beans.*;

public class AppAccountDisp {

    private Connection  con = null;
    private AppAccount acc = null;

    public AppAccountDisp() {
    }

    public Connection getConnection() {
        return con;
    }
    public void setConnection(Connection _con) {
        this.con = _con;
    }

    public AppAccount getAppAccount() {
        return acc;
    }
    public void setAppAccount(AppAccount _acc) {
        this.acc = _acc;
    }

    public boolean validate() {
        boolean flag=false;
        return flag;
    }

    public boolean insert() {
        boolean flag=false;
        return flag;
    }

    public boolean update() {
        boolean flag=false;
        return flag;
    }

    public boolean delete() {
        boolean flag=false;
        return flag;
    }

    public ArrayList getAllAccount(){
        ArrayList al=new ArrayList();
        String QUERY = "SELECT * FROM account";
        try{
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while(rs.next()){
              AppAccount a = new AppAccount();
              a.setItemId(rs.getShort(1));
              a.setDescription(rs.getString(2));
              a.setAbbreviation(rs.getString(3));
              a.setAccountType(rs.getString(4));
              al.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return al;
    }

}