
package com.mycom.booking.controllers;

import java.sql.*;

import com.mycom.booking.beans.RoomRate;
import com.mycom.booking.dispatchers.ConProvider;
import com.mycom.booking.dispatchers.SpecialRateDisp;


public class SpecialRateCtlr {

    /**
     * Creates new SpecialRateCtlr
     */
    public SpecialRateCtlr() {}

    public static boolean search(RoomRate co) {
        Connection c = ConProvider.getConnection();
        SpecialRateDisp cd = new SpecialRateDisp();
        cd.setConnection(c);
        cd.setRoomTypeRate(co);
        boolean flag = cd.search();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean insert(RoomRate co) {
        Connection c = ConProvider.getConnection();
        SpecialRateDisp cd = new SpecialRateDisp();
        cd.setConnection(c);
        cd.setRoomTypeRate(co);
        boolean flag = cd.insert();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean update(RoomRate co) {
        Connection c = ConProvider.getConnection();
        SpecialRateDisp cd = new SpecialRateDisp();
        cd.setConnection(c);
        cd.setRoomTypeRate(co);
        boolean flag = cd.update();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

    public static boolean delete(RoomRate co) {
        Connection c = ConProvider.getConnection();
        SpecialRateDisp cd = new SpecialRateDisp();
        cd.setConnection(c);
        cd.setRoomTypeRate(co);
        boolean flag = cd.delete();
        try { c.close();
        } catch (Exception e) {}
        return flag;
    }

}
