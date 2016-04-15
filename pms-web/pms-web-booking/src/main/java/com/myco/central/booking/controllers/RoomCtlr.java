
package com.mycom.booking.controllers;

import java.sql.*;

import com.mycom.booking.beans.Room;
import com.mycom.booking.dispatchers.ConProvider;
import com.mycom.booking.dispatchers.RoomDisp;


public class RoomCtlr {

    /**
     * Creates new RoomCtlr
     */
    public RoomCtlr() {}

    public static boolean search(Room r) {
        Connection c = ConProvider.getConnection();
        RoomDisp rd = new RoomDisp();
        rd.setConnection(c);
        rd.setRoom(r);
        boolean flag = rd.search();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean insert(Room r) {
        Connection c = ConProvider.getConnection();
        RoomDisp rd = new RoomDisp();
        rd.setConnection(c);
        rd.setRoom(r);
        boolean flag = rd.insert();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean update(Room r) {
        Connection c = ConProvider.getConnection();
        RoomDisp rd = new RoomDisp();
        rd.setConnection(c);
        rd.setRoom(r);
        boolean flag = rd.update();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean delete(Room r) {
        Connection c = ConProvider.getConnection();
        RoomDisp rd = new RoomDisp();
        rd.setConnection(c);
        rd.setRoom(r);
        boolean flag = rd.delete();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

}
