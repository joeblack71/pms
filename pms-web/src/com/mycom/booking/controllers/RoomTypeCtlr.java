
package com.mycom.booking.controllers;

import java.sql.*;

import com.mycom.booking.beans.RoomType;
import com.mycom.booking.dispatchers.ConProvider;
import com.mycom.booking.dispatchers.RoomTypeDisp;


public class RoomTypeCtlr {

    /**
     * Creates new RoomRateCtlr
     */
    public RoomTypeCtlr() {}

    public static boolean search(RoomType rt) {
        Connection c = ConProvider.getConnection();
        RoomTypeDisp rtd = new RoomTypeDisp();
        rtd.setConnection(c);
        rtd.setRoomType(rt);
        boolean flag = rtd.search();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean insert(RoomType rt) {
        Connection c = ConProvider.getConnection();
        RoomTypeDisp rtd = new RoomTypeDisp();
        rtd.setConnection(c);
        rtd.setRoomType(rt);
        boolean flag = rtd.insert();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean update(RoomType rt) {
        Connection c = ConProvider.getConnection();
        RoomTypeDisp rtd = new RoomTypeDisp();
        rtd.setConnection(c);
        rtd.setRoomType(rt);
        boolean flag = rtd.update();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean delete(RoomType rt) {
        Connection c = ConProvider.getConnection();
        RoomTypeDisp rtd = new RoomTypeDisp();
        rtd.setConnection(c);
        rtd.setRoomType(rt);
        boolean flag = rtd.delete();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

}
