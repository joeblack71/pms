
package com.mycom.booking.dispatchers;

import java.sql.*;
import java.util.ArrayList;

import com.mycom.booking.beans.AppUser;
import com.mycom.booking.beans.MenuOption;


public class AppUserDisp {

    private AppUser    appUser;
    private Connection connection;

    public AppUserDisp() {
    }

    public AppUser getAppUser() {
        return appUser;
    }
    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean validate() {
        boolean flag=false;
        String sql = "SELECT * FROM module_user" +
                           " WHERE nHotelId = '" + appUser.getHotelId() + "' AND" +
                                 " tLogin = '" + appUser.getLogin() + "' AND" +
                                 " tPassword = '" + appUser.getPassword() + "'";
        //System.out.println(sql);
        try {
            ResultSet rs = connection.createStatement().executeQuery(sql);
            if ( rs.next() ) {
                appUser.setUserId( rs.getShort("nUserId") );
                appUser.setFirstname( rs.getString("tFirstname") );
                appUser.setLastname( rs.getString("tLastname") );
                appUser.setDepartment( rs.getString("tDepartment") );
                appUser.setStatus( rs.getShort("nStatus") );
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insert() {
        boolean flag = false;
        try {
            String sql = "INSERT INTO" +
                               " module_user(tLogin, tPassword," +
                                        " tFirstname, tLastname," +
                                        " tDepartment, nStatus)" +
                                        " values(?,?,?,?,?,?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, appUser.getLogin());
            pre.setString(2, appUser.getPassword());
            pre.setString(3, appUser.getFirstname());
            pre.setString(4, appUser.getLastname());
            pre.setString(5,appUser.getDepartment());
            pre.setShort(6,appUser.getStatus());
            pre.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean update() {
        boolean flag = false;
        try {
            String sql = "UPDATE module_user SET tPassword=?," +
                               " tFirstname=?, tLastname=?," +
                               " tDepartment=?,  nStatus=?" +
                               " WHERE tLogin=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, appUser.getPassword());
            pre.setString(2, appUser.getFirstname());
            pre.setString(3, appUser.getLastname());
            pre.setString(4, appUser.getDepartment());
            pre.setShort(5, appUser.getStatus());
            pre.setString(6, appUser.getLogin());
            pre.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delete() {
        boolean flag = false;
        try {
            String sql = "DELETE FROM module_user WHERE tLogin=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, appUser.getLogin());
            pre.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList chargeAll() {
        ArrayList list = new ArrayList();
        String sql = "SELECT * FROM module_user";
        try {
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while( rs.next() ) {
                AppUser u = new AppUser();
                u.setUserId(rs.getShort("nUserId"));
                u.setLogin(rs.getString("tLogin"));
                u.setPassword(rs.getString("tPassword"));
                u.setFirstname(rs.getString("tFirstname"));
                u.setLastname(rs.getString("tLastname"));
                u.setDepartment(rs.getString("tDepartment"));
                u.setStatus(rs.getShort("nStatus"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList chargeOptions() {
        ArrayList list = new ArrayList();
        String sql = "SELECT uo.nOptionId, tDescription, tResourceName," +
                           " bPopupWindow, tImageOption" +
                           " FROM  user_option AS uo, menu_option AS mo" +
                           " WHERE uo.nUserId='" + appUser.getUserId() + "' AND" +
                                 " uo.nOptionId = mo.nOptionId";
        //System.out.println(sql);
	try {
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while( rs.next() ) {
                MenuOption mo = new MenuOption();
                mo.setOptionId( rs.getShort(1) );
                mo.setDescription( rs.getString(2) );
                mo.setURI( rs.getString(3) );
                mo.setPopup( rs.getBoolean(4) );
                mo.setImage( rs.getString(5) );
                //mo.setTitle( rs.getString(6) );
                list.add(mo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}