
package com.mycom.booking.controllers;

import java.sql.*;
import java.util.ArrayList;

import com.mycom.booking.beans.AppUser;
import com.mycom.booking.dispatchers.AppUserDisp;
import com.mycom.booking.dispatchers.ConProvider;



public class AppUserCtlr {

    /** Creates new UserCtlr */
    public AppUserCtlr() {
    }

    public static boolean validate(AppUser au){
        Connection c = ConProvider.getAuthConnection();
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
        Connection c = ConProvider.getAuthConnection();
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
        Connection c = ConProvider.getAuthConnection();
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
        Connection c = ConProvider.getAuthConnection();
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
        Connection c = ConProvider.getAuthConnection();
        AppUserDisp aud = new AppUserDisp();
        aud.setConnection(c);
        ArrayList list = aud.chargeAll();
        try {
            c.close();
        } catch (Exception e) {}
        return list;
    }

    public static ArrayList chargeOptions(AppUser au){
        Connection c = ConProvider.getAuthConnection();
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
