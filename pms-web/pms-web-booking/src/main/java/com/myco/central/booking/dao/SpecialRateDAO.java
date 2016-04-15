
package com.myco.central.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.myco.central.lists.RoomTypeRates;
import com.myco.central.vo.SpecialRate;

public class SpecialRateDAO {

    public SpecialRateDAO() {}

    public SpecialRate search(String hotelId, String roomType, String rateId) {
        Connection con = ConProvider.getConnection();
        ResultSet rs = null;
        SpecialRate rate = null;
        String sql = "SELECT * FROM special_rate" +
                           " WHERE nHotelId = " + hotelId + " AND" +
                                 " tRoomType = '" + roomType + "' AND" +
                                 " nRateId = " + rateId;

        try {
            rs = con.createStatement().executeQuery(sql);
            if ( rs.next() ) {
            	rate = new SpecialRate();
                rate.setDowHighSeasonRate( rs.getFloat("nHighDowRate") );
                rate.setEowHighSeasonRate( rs.getFloat("nHighEowRate") );
                rate.setDowLowSeasonRate( rs.getFloat("nLowDowRate") );
                rate.setEowLowSeasonRate( rs.getFloat("nLowEowRate") );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rate;
    }

    public boolean insert(SpecialRate rate) {
        boolean flag = false;
        Connection con = ConProvider.getConnection();
        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = "INSERT INTO special_rate(" +
                           " nHotelId, tRoomType, nRateId, nHighDowRate," +
                           " nHighEowRate, nLowDowRate, nLowEowRate)" +
                           " VALUES(?,?,?,?,?,?,?)";
        try {
            pre = con.prepareStatement(sql);
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

    public boolean update(SpecialRate rate) {
        boolean flag = false;
        Connection con = ConProvider.getConnection();
        PreparedStatement pre = null;
        String sql = "UPDATE special_rate SET" +
                           " nHighDowRate=?, nHighEowRate=?" +
                           " nLowDowRate=?, nLowEowRate=?" +
                           " WHERE nHotelId=? AND tRoomType=? AND nRateId=?";
        try {
            pre = con.prepareStatement(sql);
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

    public boolean delete(String hotelId, String roomType, String rateId) {
        boolean flag = false;
        Connection con = ConProvider.getConnection();
        PreparedStatement pre = null;
        String sql = "DELETE FROM special_rate" +
                           " WHERE nHotelId=? AND tRoomType=? AND nRateId=?";
        try {
            pre = con.prepareStatement(sql);
            pre.setString(1,  hotelId );
            pre.setString(2, roomType );
            pre.setString(3,  rateId );
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

    public RoomTypeRates getRoomRates(String pattern) {
        RoomTypeRates rates = new RoomTypeRates();
        Connection con = ConProvider.getConnection();
        PreparedStatement pre = null;
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
                SpecialRate r = new SpecialRate();
                r.setHotelId( rs.getShort(1) );
                r.setRoomType( rs.getString(2) );
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
        
        return rates;
    }

}