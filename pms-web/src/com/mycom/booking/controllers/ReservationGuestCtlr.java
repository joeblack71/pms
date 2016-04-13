
package com.mycom.booking.controllers;

import java.sql.*;
import java.util.ArrayList;

import com.mycom.booking.beans.Reservation;
import com.mycom.booking.beans.ReservationGuest;
import com.mycom.booking.dispatchers.ConProvider;
import com.mycom.booking.dispatchers.ReservationGuestDisp;


public class ReservationGuestCtlr {

    /**
     * Creates new ReservationCtlr
     */
    public ReservationGuestCtlr() {}

    public static boolean validate(ReservationGuest rg) {
        Connection c = ConProvider.getConnection();
        ReservationGuestDisp rgdisp = new ReservationGuestDisp();
        rgdisp.setConnection(c);
        rgdisp.setReservationGuest(rg);
        boolean flag = rgdisp.validate();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean insert(ReservationGuest rg) {
        Connection c = ConProvider.getConnection();
        ReservationGuestDisp rgdisp = new ReservationGuestDisp();
        rgdisp.setConnection(c);
        rgdisp.setReservationGuest(rg);
        boolean flag = rgdisp.insert();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean update(ReservationGuest rg) {
        Connection c = ConProvider.getConnection();
        ReservationGuestDisp rgdisp = new ReservationGuestDisp();
        rgdisp.setConnection(c);
        rgdisp.setReservationGuest(rg);
        boolean flag = rgdisp.update();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean delete(ReservationGuest rg) {
        Connection c = ConProvider.getConnection();
        ReservationGuestDisp rgdisp = new ReservationGuestDisp();
        rgdisp.setConnection(c);
        rgdisp.setReservationGuest(rg);
        boolean flag = rgdisp.delete();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    /**
     * Get all guests registered in a reservation.
     */
    public static void chargeGuests(Reservation res) {
        Connection c = ConProvider.getConnection();
        ReservationGuestDisp rgdisp = new ReservationGuestDisp();
        rgdisp.setConnection(c);
        rgdisp.setReservation(res);
        rgdisp.chargeGuests();

        try { c.close();
        } catch (Exception e) {}
    }

}
