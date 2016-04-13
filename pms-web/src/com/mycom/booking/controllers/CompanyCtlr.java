
package com.mycom.booking.controllers;

import java.sql.*;

import com.mycom.booking.beans.Company;
import com.mycom.booking.dispatchers.CompanyDisp;
import com.mycom.booking.dispatchers.ConProvider;
import com.mycom.booking.lists.Companies;


public class CompanyCtlr {

    Companies cias;
    
    /**
     * Creates new CompanyCtlr
     */
    public CompanyCtlr() {}

    public void setCompanyList(Companies cias) {
        this.cias = cias;
    }
    
    public static boolean validate(Company co) {
        Connection c = ConProvider.getConnection();
        CompanyDisp cd = new CompanyDisp();
        cd.setConnection(c);
        cd.setCompany(co);
        boolean flag = cd.validate();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

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

    public void chargeAll(String pattern) {
        Connection c = ConProvider.getConnection();
        CompanyDisp cd = new CompanyDisp();
        cd.setConnection(c);
        cd.setCompanies(cias);
        cd.chargeAll(pattern);
        try { c.close();
        } catch (Exception e) {}
        //return flag;
    }

    // Used when is need to know room rate (reservation.jsp)
    public void chargeAll(String pattern, short hotelId, String roomType) {
        Connection c = ConProvider.getConnection();
        CompanyDisp cd = new CompanyDisp();
        cd.setConnection(c);
        cd.setCompanies(cias);
        cd.chargeAll(pattern, hotelId, roomType);
        try { c.close();
        } catch (Exception e) {}
        //return flag;
    }

}
