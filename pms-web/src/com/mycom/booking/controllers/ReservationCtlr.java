
package com.mycom.booking.controllers;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mycom.booking.beans.Reservation;
import com.mycom.booking.dispatchers.ConProvider;
import com.mycom.booking.dispatchers.ReservationDisp;


public class ReservationCtlr {

    /**
     * Creates new ReservationCtlr
     */
    public ReservationCtlr() {}

    public static boolean validate(Reservation r) {
        Connection c = ConProvider.getConnection();
        ReservationDisp rdisp = new ReservationDisp();
        rdisp.setConnection(c);
        rdisp.setReservation(r);
        boolean flag = rdisp.validate();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean search(Reservation r) {
        Connection c = ConProvider.getConnection();
        ReservationDisp rdisp = new ReservationDisp();
        rdisp.setConnection(c);
        rdisp.setReservation(r);
        boolean flag = rdisp.search();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean insert(Reservation r) {
        Connection c = ConProvider.getConnection();
        ReservationDisp rdisp = new ReservationDisp();
        rdisp.setConnection(c);
        rdisp.setReservation(r);
        boolean flag = rdisp.insert();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean update(Reservation r) {
        Connection c = ConProvider.getConnection();
        ReservationDisp rdisp = new ReservationDisp();
        rdisp.setConnection(c);
        rdisp.setReservation(r);
        boolean flag = rdisp.update();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean delete(Reservation r) {
        Connection c = ConProvider.getConnection();
        ReservationDisp rdisp = new ReservationDisp();
        rdisp.setConnection(c);
        rdisp.setReservation(r);
        boolean flag = rdisp.delete();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public List<Reservation> getReportByPattern(int field, String pattern) {
        Connection c = ConProvider.getConnection();
        ReservationDisp rdisp = new ReservationDisp();
        rdisp.setConnection(c);
        List<Reservation> records = null;

        switch( field ) {
            case 1: records = rdisp.chargeByLastName("1",pattern); break;
            case 2: records = rdisp.chargeByArrival("1",pattern); break;
            case 3: records = rdisp.chargeByDeparture("1",pattern); break;
            case 4: records = rdisp.chargeByReservation("1",pattern); break;
            case 5: records = rdisp.chargeByCreationDate("1",pattern); break;
        }
        try { c.close();
        } catch (Exception e) {}

        return records;
    }

}
