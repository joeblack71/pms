
package dispatchers;

import java.sql.*;
import java.util.ArrayList;

import beans.AppUser;
import beans.MenuOption;

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
        String sql = "SELECT * FROM app_user" +
                           " WHERE tLogin='" + appUser.getLogin() + "'" +
                           " AND tPassword='" + appUser.getPassword() + "'";
        //System.out.println(sql);
        try {
            ResultSet rs = connection.createStatement().executeQuery(sql);
            if ( rs.next() ) {
                appUser.setUserId( rs.getShort("nUserId") );
                appUser.setFirstname( rs.getString("tFirstName") );
                appUser.setLastname( rs.getString("tLastName") );
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
                               " app_user(tLogin, tPassword," +
                                        " tFirstname, tLastname," +
                                        " tDepartment, nStatus)" +
                                        " values(?,?,?,?,?,?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, appUser.getLogin());
            pre.setString(2, appUser.getPassword());
            pre.setString(3, appUser.getFirstname());
            pre.setString(4, appUser.getLastname());
            pre.setString(5, appUser.getDepartment());
            pre.setShort(6, appUser.getStatus());
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
            String sql = "UPDATE app_user SET" +
                               " tPassword=?, tFirstname=?, tLastname=?," +
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
            String sql = "DELETE FROM app_user WHERE tLogin=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setShort(1, appUser.getUserId());
            pre.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList chargeAll() {
        ArrayList list = new ArrayList();
        String sql = "SELECT * FROM app_user";
        try {
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while( rs.next() ) {
                AppUser u = new AppUser();
                u.setUserId(rs.getShort("tUserId"));
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
        String sql = "SELECT uo.nMenuId, uo.nOptionId, tDescription," +
                           " tResourceName, nOutputType, tResourceInfo, tImageOption" +
                           " FROM  user_option AS uo, menu_option AS mo" +
                           " WHERE uo.nUserId='" + appUser.getUserId() + "' AND" +
                                 " uo.nMenuId = mo.nMenuId AND uo.nOptionId = mo.nOptionId";
        //System.out.println(sql);
	try {
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while( rs.next() ) {
                MenuOption mo = new MenuOption();
                mo.setMenuId( rs.getShort(1) );
                mo.setOptionId( rs.getShort(2) );
                mo.setDescription( rs.getString(3) );
                mo.setResourceName( rs.getString(4) );
                mo.setOutputType( rs.getShort(5) );
                mo.setImageOption( rs.getString(6) );
                mo.setResourceInfo( rs.getString(7) );
                list.add(mo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}