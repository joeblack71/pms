
package com.myco.central.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.myco.central.lists.RoomList;
import com.myco.central.vo.Room;

public class RoomDAO {

    RoomList roomList = new RoomList();

    public RoomDAO() {
    }
   
    public void setRoomList(RoomList roomList) {
        this.roomList = roomList;
    }

    public Room search(String hotelId, String roomType, String roomNumber) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Room room = null;

        String qry = "SELECT * FROM roomrack" +
                             " WHERE nHotelId = ? AND tRoomType = ? AND" +
                                   " tRoomNumber = ?";
        int k = 0;
        
        try {
            pstmt = con.prepareStatement(qry);
            pstmt.setShort( k++,room.getHotelId() );
            pstmt.setString( k++,room.getRoomType() );
            pstmt.setString( k++,room.getRoomNumber() );
            rs = pstmt.executeQuery();
            System.out.println(pstmt);
            if(rs.next()){
            	room = new Room();
                room.setDescription( rs.getString("tDescription") );
                room.setLocation( rs.getString("tLocation") );
                room.setRoomRate( rs.getShort("nRoomRate") );
                room.setBedsCapacity( rs.getShort("nMaxBeds") );
                room.setConnectedRoom( rs.getString("tConnectRoom") );
                room.setAssignedReservation( rs.getInt("nReservation") );
                room.setRoomStatus( rs.getString("tRoomStatus") );
                room.setHkStatus( rs.getString("tHKStatus") );
            }
        } catch (Exception e) { e.printStackTrace(); }

        return room;
    }

    public boolean insert(Room room) {
        Connection con = null;
        PreparedStatement pstmt = null;

        boolean flag = false;
        try {
            String sql = "INSERT INTO roomrack(" +
                                    " nHotelId, tRoomType, tRoomNumber," +
                                    " tDescription, tLocation, nRoomRate, nMaxBeds," +
                                    " tConnectRoom, nReservation, tRoomStatus," +
                                    " tHKStatus )" +
                         " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setShort(1, room.getHotelId());
            pstmt.setString(2, room.getRoomType());
            pstmt.setString(3, room.getRoomNumber());
            pstmt.setString(4, room.getDescription());
            pstmt.setString(5, room.getLocation());
            pstmt.setFloat(6,  room.getRoomRate());
            pstmt.setShort(7,  room.getBedsCapacity());
            pstmt.setString(8, room.getConnectedRoom());
            pstmt.setInt(9, room.getAssignedReservation());
            pstmt.setString(10, room.getRoomStatus());
            pstmt.setString(11, room.getHkStatus());
            pstmt.executeUpdate();
            flag = true;
        } catch (Exception e) { e.printStackTrace(); }
        
        return flag;
    }

    public boolean update(Room room) {
        Connection con = null;
        PreparedStatement pstmt = null;

        boolean flag = false;
        try {
            String sql = "UPDATE roomrack SET" +
                               " tDescription = ?, tLocation = ?, nRoomRate = ?," +
                               " nMaxBeds = ?, tConnectRoom = ?, nReservation = ?" +
                               " tRoomStatus = ?, tHKStatus = ?" +
                         " WHERE nHotelId = ? AND tRoomType = ? AND tRoomNumber = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, room.getDescription());
            ps.setString(2, room.getLocation());
            ps.setFloat(3,  room.getRoomRate());
            ps.setShort(4,  room.getBedsCapacity());
            ps.setString(5, room.getConnectedRoom());
            ps.setInt(6, room.getAssignedReservation());
            ps.setString(7, room.getRoomStatus());
            ps.setString(8, room.getHkStatus());
            ps.setShort(9, room.getHotelId());
            ps.setString(10, room.getRoomType());
            ps.setString(11, room.getRoomNumber());
            ps.executeUpdate();
            flag = true;
        } catch (Exception e) { e.printStackTrace(); }

        return flag;
    }

    public boolean delete(String hotelId, String roomType, String roomNumber) {
        Connection con = null;
        PreparedStatement pstmt = null;

        boolean flag = false;
        try {
            String sql = "DELETE FROM roomrack" +
                                    " WHERE nHotelId = ? AND tRoomType = ? AND" +
                                          " tRoomNumber = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString( 1, hotelId);
            ps.setString( 2, roomType);
            ps.setString( 3, roomNumber);
            ps.executeUpdate();
            flag = true;
        } catch (Exception e) { e.printStackTrace(); }

        return flag;
    }

    public void chargeAll(String hotelId, String roomType) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM roomrack" +
                           " WHERE nHotelId = " + hotelId;
        if ( !roomType.equals("") )
            sql = sql + " AND tRoomType = " + roomType;
        System.out.println(sql);
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while ( rs.next() ) {
                Room r = new Room();
                r.setHotelId( rs.getShort("nHotelId") );
                r.setRoomType( rs.getString("tRoomType") );
                r.setRoomNumber( rs.getString("tRoomNumber") );
                r.setDescription( rs.getString("tDescription") );
                r.setLocation( rs.getString("tLocation") );
                r.setAssignedReservation( rs.getShort("nMaxBeds") );
                r.setRoomRate( rs.getFloat("nRoomRate") );
                r.setAssignedReservation( rs.getInt("nReservation") );
                r.setConnectedRoom( rs.getString("tConnectRoom") );
                r.setRoomStatus( rs.getString("tRoomStatus") );
                r.setHkStatus( rs.getString("tHKStatus") );
                roomList.add(r);
            }
        } catch (Exception e){ e.printStackTrace(); }

    }

}