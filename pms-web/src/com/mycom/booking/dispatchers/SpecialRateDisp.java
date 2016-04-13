
package com.mycom.booking.dispatchers;

import java.sql.*;
import java.util.ArrayList;

import com.mycom.booking.beans.RoomRate;
import com.mycom.booking.lists.RoomTypeRates;


public class SpecialRateDisp {

    private Connection con;
    private RoomRate rate;
    private RoomTypeRates rates;

    public SpecialRateDisp() {}

    public void setConnection(Connection con) {
        this.con = con;
    }

    public void setRoomTypeRate(RoomRate source) {
        this.rate = source;
    }

    public void setRoomTypeRates(RoomTypeRates rates){
        this.rates = rates;
    }
    
    public boolean search() {
        boolean flag = false;
        String sql = "SELECT * FROM special_rate" +
                           " WHERE nHotelId = " + rate.getHotelId() + " AND" +
                                 " tRoomType = '" + rate.getRoomType() + "' AND" +
                                 " nRateId = " + rate.getRateId();
        System.out.println(sql);
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            if ( rs.next() ) {
                rate.setDowHighSeasonRate( rs.getFloat("nHighDowRate") );
                rate.setEowHighSeasonRate( rs.getFloat("nHighEowRate") );
                rate.setDowLowSeasonRate( rs.getFloat("nLowDowRate") );
                rate.setEowLowSeasonRate( rs.getFloat("nLowEowRate") );
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insert() {
        boolean flag = false;
        String sql = "INSERT INTO special_rate(" +
                           " nHotelId, tRoomType, nRateId, nHighDowRate," +
                           " nHighEowRate, nLowDowRate, nLowEowRate)" +
                           " VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setShort(1,  rate.getHotelId() );
            pre.setString(2, rate.getRoomType() );
            pre.setShort(3,  rate.getRateId() );
            pre.setFloat(4,  rate.getDowHighSeasonRate() );
            pre.setFloat(5,  rate.getEowHighSeasonRate() );
            pre.setFloat(6,  rate.getDowLowSeasonRate() );
            pre.setFloat(7,  rate.getEowLowSeasonRate() );
            //System.out.println(pre);
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean update() {
        boolean flag = false;
        String sql = "UPDATE special_rate SET" +
                           " nHighDowRate=?, nHighEowRate=?" +
                           " nLowDowRate=?, nLowEowRate=?" +
                           " WHERE nHotelId=? AND tRoomType=? AND nRateId=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setFloat(1,  rate.getDowHighSeasonRate() );
            pre.setFloat(2,  rate.getEowHighSeasonRate() );
            pre.setFloat(3,  rate.getDowLowSeasonRate() );
            pre.setFloat(4,  rate.getEowLowSeasonRate() );
            pre.setShort(5,  rate.getHotelId() );
            pre.setString(6, rate.getRoomType() );
            pre.setShort(7,  rate.getRateId() );
            //System.out.println(pre);
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delete() {
        boolean flag = false;
        String sql = "DELETE FROM special_rate" +
                           " WHERE nHotelId=? AND tRoomType=? AND nRateId=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setShort(1,  rate.getHotelId() );
            pre.setString(2, rate.getRoomType() );
            pre.setShort(3,  rate.getRateId() );
            //System.out.println(pre);
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /*public boolean getSpecialRate() {
        boolean flag = false;
        String sql = "SELECT FROM special_rate" +
                           " WHERE nHotelId=? AND tRoomType=? AND nRateId=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setShort(1,  rate.getHotelId() );
            pre.setString(2, rate.getRoomType() );
            pre.setShort(3,  rate.getRateId() );
            //System.out.println(pre);
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }*/

    public void chargeAll(String pattern) {
        //TODO: Add pattern to query
        String sql = "SELECT sr.nHotelId, rt.tDescription, sr.nRateId, r.tDescription," +
                           " nHighDowRate, nHighEowRate, nLowDowRate, nLowEowRate" +
                           " FROM special_rate as sr, roomtype as rt, rate as r" +
                           " WHERE sr.nhotelid = r.nhotelId AND" +
                           " sr.nRateId = r.nRateId AND sr.tRoomType = rt.troomtype";
        System.out.println(sql);
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while ( rs.next() ) {
                RoomRate r = new RoomRate();
                r.setHotelId( rs.getShort(1) );
                r.setRoomType( rs.getString(21) );
                r.setRateId( rs.getShort(3) );
                r.setRateDescription( rs.getString(4) );
                r.setDowHighSeasonRate( rs.getFloat(5) );
                r.setEowHighSeasonRate( rs.getFloat(6) );
                r.setDowLowSeasonRate( rs.getFloat(7) );
                r.setEowLowSeasonRate( rs.getFloat(8) );
                rates.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}