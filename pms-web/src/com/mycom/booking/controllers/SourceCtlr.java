
package com.mycom.booking.controllers;

import java.sql.*;

import com.mycom.booking.beans.Company;
import com.mycom.booking.dispatchers.CompanyDisp;
import com.mycom.booking.dispatchers.ConProvider;


public class SourceCtlr {

    /**
     * Creates new CompanyCtlr
     */
    public SourceCtlr() {}

    public static boolean search(Company co) {
        Connection c = ConProvider.getConnection();
        CompanyDisp cd = new CompanyDisp();
        cd.setConnection(c);
        cd.setCompany(co);
        boolean flag = cd.search();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean insert(Company co) {
        Connection c = ConProvider.getConnection();
        CompanyDisp cd = new CompanyDisp();
        cd.setConnection(c);
        cd.setCompany(co);
        boolean flag = cd.insert();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean update(Company co) {
        Connection c = ConProvider.getConnection();
        CompanyDisp cd = new CompanyDisp();
        cd.setConnection(c);
        cd.setCompany(co);
        boolean flag = cd.update();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean delete(Company co) {
        Connection c = ConProvider.getConnection();
        CompanyDisp cd = new CompanyDisp();
        cd.setConnection(c);
        cd.setCompany(co);
        boolean flag = cd.delete();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

}
