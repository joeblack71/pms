
package com.mycom.booking.dispatchers;

import java.sql.*;
import java.util.ArrayList;

import com.mycom.booking.beans.Room;
import com.mycom.booking.lists.RoomList;


public class RoomDisp {

    private Connection con;
    private Room room;
    private RoomList roomList;

    public RoomDisp() {
    }
   
    public Connection getConnection() {
        return con;
    }
    
    public void setConnection(Connection con) {
        this.con = con;
    }

    public Room getRoom() {
        return room;
    }
    
    public void setRoom(Room room) {
        this.room = room;
    }

    public void setRoomList(RoomList roomList) {
        this.roomList = roomList;
    }

    public boolean search() {
        boolean flag=false;
        String QUERY = "SELECT * FROM roomrack" +
                             " WHERE nHotelId = ? AND tRoomType = ? AND" +
                                   " tRoomNumber = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(QUERY);
            pstmt.setShort( 1,room.getHotelId() );
            pstmt.setString( 2,room.getRoomType() );
            pstmt.setString( 3,room.getRoomNumber() );
            ResultSet rs = pstmt.executeQuery();
            System.out.println(pstmt);
            if(rs.next()){
                room.setDescription( rs.getString("tDescription") );
                room.setLocation( rs.getString("tLocation") );
                room.setRoomRate( rs.getShort("nRoomRate") );
                room.setBedsCapacity( rs.getShort("nMaxBeds") );
                room.setConnectedRoom( rs.getString("tConnectRoom") );
                room.setAssignedReservation( rs.getInt("nReservation") );
                room.setRoomStatus( rs.getString("tRoomStatus") );
                room.setHkStatus( rs.getString("tHKStatus") );
                flag = true;
            }
        } catch (Exception e) { e.printStackTrace(); }

        return flag;
    }

    public boolean insert() {
        boolean flag = false;
        try {
            String sql = "INSERT INTO roomrack(" +
                                    " nHotelId, tRoomType, tRoomNumber," +
                                    " tDescription, tLocation, nRoomRate, nMaxBeds," +
                                    " tConnectRoom, nReservation, tRoomStatus," +
                                    " tHKStatus )" +
                         " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setShort(1, room.getHotelId());
            ps.setString(2, room.getRoomType());
            ps.setString(3, room.getRoomNumber());
            ps.setString(4, room.getDescription());
            ps.setString(5, room.getLocation());
            ps.setFloat(6,  room.getRoomRate());
            ps.setShort(7,  room.getBedsCapacity());
            ps.setString(8, room.getConnectedRoom());
            ps.setInt(9, room.getAssignedReservation());
            ps.setString(10, room.getRoomStatus());
            ps.setString(11, room.getHkStatus());
            ps.executeUpdate();
            flag = true;
        } catch (Exception e) { e.printStackTrace(); }
        
        return flag;
    }

    public boolean update() {
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

    public boolean delete() {
        boolean flag = false;
        try {
            String sql = "DELETE FROM roomrack" +
                                    " WHERE nHotelId = ? AND tRoomType = ? AND" +
                                          " tRoomNumber = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setShort( 1, room.getHotelId() );
            ps.setString( 2, room.getRoomType() );
            ps.setString( 3, room.getRoomNumber() );
            ps.executeUpdate();
            flag = true;
        } catch (Exception e) { e.printStackTrace(); }

        return flag;
    }

    public void chargeAll(String hotelId, String roomType) {
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