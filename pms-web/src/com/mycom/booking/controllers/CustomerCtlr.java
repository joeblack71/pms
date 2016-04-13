
package com.mycom.booking.controllers;

import java.sql.*;

import com.mycom.booking.beans.Customer;
import com.mycom.booking.dispatchers.ConProvider;
import com.mycom.booking.dispatchers.CustomerDisp;


public class CustomerCtlr {

    /**
     * Creates new CustomerCtlr
     */
    public CustomerCtlr() {}

    public static boolean validate(Customer g) {
        Connection c = ConProvider.getConnection();
        CustomerDisp dg = new CustomerDisp();
        dg.setConnection(c);
        dg.setCustomer(g);
        boolean flag = dg.validate();
        try {
            c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean insert(Customer g) {
        Connection c = ConProvider.getConnection();
        CustomerDisp dg = new CustomerDisp();
        dg.setConnection(c);
        dg.setCustomer(g);
        boolean flag = dg.insert();
        try {
            c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean update(Customer g) {
        Connection c = ConProvider.getConnection();
        CustomerDisp dg = new CustomerDisp();
        dg.setConnection(c);
        dg.setCustomer(g);
        boolean flag = dg.update();
        try {
            c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean delete(Customer g) {
        Connection c = ConProvider.getConnection();
        CustomerDisp dg = new CustomerDisp();
        dg.setConnection(c);
        dg.setCustomer(g);
        boolean flag = dg.delete();
        try {
            c.close();
        } catch (Exception e) {}
        return flag;
    }

}
