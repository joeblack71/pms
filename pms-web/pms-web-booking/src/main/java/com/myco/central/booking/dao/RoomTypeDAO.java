
package com.myco.central.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.myco.central.lists.RoomTypeList;
import com.myco.central.vo.RoomType;

public class RoomTypeDAO {

    RoomTypeList roomTypeList = null;

    public RoomTypeDAO() {
    }
   
    public void setRoomTypeList(RoomTypeList roomTypeList) {
        this.roomTypeList = roomTypeList;
    }

    public RoomType search(String hotelId, String roomTypeId){
    	Connection conn = ConProvider.getConnection();
    	
        RoomType roomType = null;
    	
        String qry = "SELECT * FROM roomtype" +
                       " WHERE nHotelId = ? AND tRoomType=?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(qry);
            pstmt.setString(1, hotelId);
            pstmt.setString(2, roomTypeId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                roomType.setDescription(rs.getString(3));
                roomType.setRackRate(rs.getFloat(4));
                roomType.setTotalRooms(rs.getShort(5));
                roomType.setAvailableRooms(rs.getShort(6));
                roomType.setBlockedRooms(rs.getShort(7));
                roomType.setStatus(rs.getString(8));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return roomType;
    }

    public boolean insert(RoomType roomType){
    	Connection conn = ConProvider.getConnection();
        PreparedStatement ps = null;
    	
        String sql = "INSERT INTO roomtypes("
        		+ "tHotel, tRoomType, "
        		+ "tDescription, nRackrate, nTotalRooms,"
        		+ "nAvailableRooms, nBlockedRooms,"
        		+ "status) VALUES(?,?,?,?,?,?,?,?)";
        boolean flag = false;

        try{
            ps = conn.prepareStatement(sql);
            ps.setShort(1, roomType.getHotelId());
            ps.setString(2, roomType.getRoomType());
            ps.setString(3, roomType.getDescription());
            ps.setFloat(4,  roomType.getRackRate());
            ps.setShort(5,  roomType.getTotalRooms());
            ps.setString(6, roomType.getStatus());
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean update(RoomType roomType){
    	Connection conn = ConProvider.getConnection();
        PreparedStatement ps = null;

        String sql = "UPDATE roomtypes SET"
		        + " tDescription=?, nRackRate=?,"
		        + " nTotalrooms=?, nAvailableRooms,"
		        + " nBlockedRooms, tStatus=? WHERE tHotel=? AND roomtype=?";
        boolean flag = false;

        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, roomType.getDescription());
            ps.setFloat(2,  roomType.getRackRate());
            ps.setShort(3,  roomType.getTotalRooms());
            ps.setShort(4,  roomType.getAvailableRooms());
            ps.setShort(5,  roomType.getBlockedRooms());
            ps.setString(6, roomType.getStatus());
            ps.setShort(7, roomType.getHotelId());
            ps.setString(8, roomType.getRoomType());
            ps.executeUpdate();
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delete(String hotelId, String roomType){
    	Connection conn = ConProvider.getConnection();
        PreparedStatement ps = null;

        String sql = "DELETE FROM roomtypes"
    		+ " WHERE tHotel=?, roomtype=?";
    	boolean flag = false;
    	
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, hotelId);
            ps.setString(2, roomType);
            ps.executeUpdate();
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public List<RoomType> getRoomTypes() {
    	Connection conn = ConProvider.getConnection();
        ResultSet rs = null;

        RoomType rt = null;
        List<RoomType> al = new ArrayList<RoomType>();
        String sql = "SELECT * FROM roomtype";

        try {
            rs = conn.createStatement().executeQuery(sql);
            while( rs.next() ) {
                rt = new RoomType();
                rt.setHotelId(rs.getShort(1));
                rt.setRoomType(rs.getString(2));
                rt.setDescription(rs.getString(3));
                rt.setRackRate(rs.getFloat(4));
                rt.setTotalRooms(rs.getShort(5));
                rt.setAvailableRooms(rs.getShort(6));
                rt.setBlockedRooms(rs.getShort(7));
                rt.setStatus(rs.getString(8));
                al.add(rt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return al;
    }

    /*public String[] getRoomTypes(){
        System.out.println("call to getRoomTypes()");
        /*String[] arrRoomTypes = new String[10];
        int i = 0;
        try{
            String sql = "SELECT roomtype FROM roomtypes ORDER BY roomtype";
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                //RoomType rT = new RoomType();
                //rT.setRoomType(rs.getString("roomtype"));
                arrRoomTypes[i++] = rs.getString("roomtype");
                //rT.setTotalRooms(rs.getShort("totalrooms"));
                //rT.setStatus(rs.getString("status"));
            }
            if(i <= 9){
                for(int j = i; j <= 9; j++)
                    arrRoomTypes[j] = new String("");
            }
        }catch (Exception e){
            System.out.println("Error Dispatcher");
            e.printStackTrace();
        }
        return arrRoomTypes;
    }*/

    public String[] getAvailability(){
    	Connection conn = ConProvider.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String[] arrRoomTypes = new String[10];
        String sql = "SELECT nights FROM roomtype WHERE arrival = '2005-09-05'";
        int i = 0;

        try{
            rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                //RoomType rT = new RoomType();
                //rT.setRoomType(rs.getString("roomtype"));
                arrRoomTypes[i++] = rs.getString("tRoomType");
                //rT.setTotalRooms(rs.getShort("totalrooms"));
                //rT.setStatus(rs.getString("status"));
            }
            if(i <= 9){
                for(int j = i; j <= 9; j++)
                    arrRoomTypes[j] = new String("");
            }
        }catch (Exception e){
            System.out.println("Error Dispatcher");
            e.printStackTrace();
        }
        return arrRoomTypes;
    }

    public void chargeAll(String hotel) {
    	Connection conn = ConProvider.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM  roomtype";
        
        try {
            rs = conn.createStatement().executeQuery(sql);
            while ( rs.next() ) {
                RoomType c = new RoomType();
                c.setHotelId( rs.getShort("nHotelId") );
                c.setRoomType( rs.getString("tRoomType") );
                c.setDescription( rs.getString("tDescription") );
                c.setRackRate( rs.getFloat("nRackRate") );
                c.setTotalRooms( rs.getShort("nTotalRooms") );
                c.setAvailableRooms( rs.getShort("nAvailableRooms") );
                c.setBlockedRooms( rs.getShort("nBlockedRooms") );
                roomTypeList.add(c);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}