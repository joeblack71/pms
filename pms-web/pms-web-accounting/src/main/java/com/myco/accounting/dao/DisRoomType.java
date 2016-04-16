
package dispatchers;

import java.sql.*;
import java.util.ArrayList;

import beans.RoomType;
//import lists.*;

public class DisRoomType {

    private RoomType roomType;
    private Connection con;

    public DisRoomType() {
    }
   
    public RoomType getRoomType() {
        return roomType;
    }
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
    
    public Connection getConnection() {
        return con;
    }
    public void setConnection(Connection con) {
        this.con = con;
    }

    public boolean validate(){
        boolean flag=false;
        String QUERY = "SELECT * FROM roomtype" +
                       " WHERE tHotel = ? AND tRoomType=?";
        try{
            PreparedStatement pstmt = con.prepareStatement(QUERY);
            pstmt.setString(1,roomType.getHotel());
            pstmt.setString(2,roomType.getRoomType());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                roomType.setDescription(rs.getString(3));
                roomType.setRackRate(rs.getFloat(4));
                roomType.setTotalRooms(rs.getShort(5));
                roomType.setAvailableRooms(rs.getShort(6));
                roomType.setBlockedRooms(rs.getShort(7));
                roomType.setStatus(rs.getString(8));
                flag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insert(){
        boolean flag = false;
        try{
            String sql = "INSERT INTO roomtypes(tHotel, tRoomType," +
                                    " tDescription, nRackrate, nTotalRooms," +
                                    " nAvailableRooms, nBlockedRooms," +
                                    " status)" +
                         " VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, roomType.getHotel());
            ps.setString(2, roomType.getRoomType());
            ps.setString(3, roomType.getDescription());
            ps.setFloat(4,  roomType.getRackRate());
            ps.setShort(5,  roomType.getTotalRooms());
            ps.setString(6, roomType.getStatus());
            ps.executeUpdate();
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean update(){
        boolean flag = false;
        try{
            String sql = "UPDATE roomtypes SET" +
                               " tDescription=?, nRackRate=?," +
                               " nTotalrooms=?, nAvailableRooms," +
                               " nBlockedRooms, tStatus=?" +
                         " WHERE tHotel=? AND roomtype=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, roomType.getDescription());
            ps.setFloat(2,  roomType.getRackRate());
            ps.setShort(3,  roomType.getTotalRooms());
            ps.setShort(4,  roomType.getAvailableRooms());
            ps.setShort(5,  roomType.getBlockedRooms());
            ps.setString(6, roomType.getStatus());
            ps.setString(7, roomType.getHotel());
            ps.setString(8, roomType.getRoomType());
            ps.executeUpdate();
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delete(){
        boolean flag = false;
        try{
            String sql = "DELETE FROM roomtypes" +
                         " WHERE tHotel, roomtype=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, roomType.getRoomType());
            ps.executeUpdate();
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList chargeAll(){
        ArrayList al = new ArrayList();
        String sql = "SELECT * FROM roomtype";
        try{
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                RoomType rt = new RoomType();
                rt.setHotel(rs.getString(1));
                rt.setRoomType(rs.getString(2));
                rt.setDescription(rs.getString(3));
                rt.setRackRate(rs.getFloat(4));
                rt.setTotalRooms(rs.getShort(5));
                rt.setAvailableRooms(rs.getShort(6));
                rt.setBlockedRooms(rs.getShort(7));
                rt.setStatus(rs.getString(8));
                al.add(rt);
            }
        }catch (Exception e){
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
        String[] arrRoomTypes = new String[10];
        int i = 0;
        try{
            String sql = "SELECT nights FROM roomtype WHERE arrival = '2005-09-05'";
            ResultSet rs = con.createStatement().executeQuery(sql);
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

}