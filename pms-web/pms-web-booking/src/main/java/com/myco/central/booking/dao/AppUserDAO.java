
package com.myco.central.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.myco.central.vo.AppUser;
import com.myco.central.vo.MenuOption;

public class AppUserDAO {

    public AppUserDAO() {
    }

    public boolean validate(AppUser au) throws Exception {
        Connection conn = ConProvider.getAuthConnection();
        ResultSet rs = null;
        String sql = "SELECT * FROM module_user"
        	+ " WHERE nHotelId = '" + au.getHotelId() + "' AND"
        	+ " tLogin = '" + au.getLogin() + "' AND"
        	+ " tPassword = '" + au.getPassword() + "'";
        boolean status = false;

        try {
            rs = conn.createStatement().executeQuery(sql);
            if ( rs.next() ) {
                au.setUserId( rs.getShort("nUserId") );
                au.setFirstname( rs.getString("tFirstname") );
                au.setLastname( rs.getString("tLastname") );
                au.setDepartment( rs.getString("tDepartment") );
                au.setStatus( rs.getShort("nStatus") );
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
       	    conn.close();
        }
        
        return status;
    }

    public boolean insert(AppUser au) throws Exception {
        Connection conn = ConProvider.getAuthConnection();
        String sql = "INSERT INTO"
        	+ " module_user(tLogin, tPassword,"
        	+ " tFirstname, tLastname,"
        	+ " tDepartment, nStatus)"
        	+ " values(?,?,?,?,?,?)";
        
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, au.getLogin());
            pre.setString(2, au.getPassword());
            pre.setString(3, au.getFirstname());
            pre.setString(4, au.getLastname());
            pre.setString(5,au.getDepartment());
            pre.setShort(6,au.getStatus());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
       	    conn.close();
        }
        
        return true; //TODO change return value
    }

    public boolean update(AppUser au) throws Exception {
        Connection conn = ConProvider.getAuthConnection();
        String sql = "UPDATE module_user SET tPassword=?,"
        	+ " tFirstname=?, tLastname=?,"
        	+ " tDepartment=?,  nStatus=?"
        	+ " WHERE tLogin=?";
        
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, au.getPassword());
            pre.setString(2, au.getFirstname());
            pre.setString(3, au.getLastname());
            pre.setString(4, au.getDepartment());
            pre.setShort(5, au.getStatus());
            pre.setString(6, au.getLogin());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
       	    conn.close();
        }
        
        return true; //TODO change return value
    }

    public boolean delete(AppUser au) throws Exception {
        Connection conn = ConProvider.getAuthConnection();
        String sql = "DELETE FROM module_user WHERE tLogin=?";
        
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, au.getLogin());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
       	    conn.close();
        }
        
        return true; //TODO change return value
    }

    public List chargeAll() throws Exception {
        Connection conn = ConProvider.getAuthConnection();
        ResultSet rs = null;

        ArrayList list = new ArrayList();
        String sql = "SELECT * FROM module_user";
        
        try {
            rs = conn.createStatement().executeQuery(sql);
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
        } finally {
       	    conn.close();
        }
        
        return list; //TODO change return value
    }

    public List chargeOptions(AppUser au) throws Exception {
        Connection conn = ConProvider.getAuthConnection();
        ResultSet rs = null;
        ArrayList list = new ArrayList();
        String sql = "SELECT uo.nOptionId, tDescription, tResourceName,"
        	+ " bPopupWindow, tImageOption"
        	+ " FROM  user_option AS uo, menu_option AS mo"
        	+ " WHERE uo.nUserId='" + au.getUserId() + "' AND"
        	+ " uo.nOptionId = mo.nOptionId";

        try {
            rs = conn.createStatement().executeQuery(sql);
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
        } finally {
       	    conn.close();
        }
        
        return list; //TODO change return value
    }

}