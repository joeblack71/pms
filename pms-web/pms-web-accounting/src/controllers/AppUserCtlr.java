
package controllers;

import java.sql.*;
import java.util.ArrayList;


import beans.AppUser;
import dispatchers.ConProvider;
import dispatchers.AppUserDisp;

public class AppUserCtlr {

    /** Creates new UserCtlr */
    public AppUserCtlr() {
    }

    public static boolean validate(AppUser au){
        Connection c = ConProvider.getConnection();
        AppUserDisp aud = new AppUserDisp();
        aud.setConnection(c);
        aud.setAppUser(au);
        boolean flag = aud.validate();
        try {
       	    c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean insert(AppUser au){
        Connection c = ConProvider.getConnection();
        AppUserDisp aud = new AppUserDisp();
        aud.setConnection(c);
        aud.setAppUser(au);
        boolean flag = aud.insert();
        try {
       	    c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean update(AppUser au){
        Connection c = ConProvider.getConnection();
        AppUserDisp aud = new AppUserDisp();
        aud.setConnection(c);
        aud.setAppUser(au);
        boolean flag = aud.update();
        try {
            c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean delete(AppUser au){
        Connection c = ConProvider.getConnection();
        AppUserDisp aud = new AppUserDisp();
        aud.setConnection(c);
        aud.setAppUser(au);
        boolean flag = aud.delete();
        try {
            c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static ArrayList chargeAll(){
        Connection c = ConProvider.getConnection();
        AppUserDisp aud = new AppUserDisp();
        aud.setConnection(c);
        ArrayList list = aud.chargeAll();
        try {
            c.close();
        } catch (Exception e) {}
        return list;
    }

    public static ArrayList chargeOptions(AppUser au){
        Connection c = ConProvider.getConnection();
        AppUserDisp aud = new AppUserDisp();
        aud.setConnection(c);
        aud.setAppUser(au);
        ArrayList list = aud.chargeOptions();
        try {
            c.close();
        } catch (Exception e) {}
        return list;
    }

}
