
package dispatchers;

import java.sql.*;
import java.util.ArrayList;

import beans.AvailabilityQry;
import beans.AvailabilityDay;

public class DisAvailability {

    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet  rs=null;
    private ArrayList  al=null;

    private AvailabilityQry availabilityQry;

    public DisAvailability(){}

    public Connection getConnection(){
        return con;
    }
    public void setConnection(Connection con){
        this.con = con;
    }

    /*public AvailabilityQry getAvailabilityQry(){
        return availabilityQry;
    }*/
    public void setAvailabilityQry(AvailabilityQry availabilityQry){
        this.availabilityQry = availabilityQry;
    }

    public ArrayList getAvailabilityRooms(){
        al = new ArrayList();
/** This query must be changed by another one what
 can resume occupability for all hotels.
**/
        String QUERY = "SELECT tRoomType, dOccupationDay, count(tRoomType)" +
                       "       FROM occupation" +
                       "       WHERE nHotel = ? AND" +
                       "             dOccupationDay >= ? AND dOccupationDay <= ?" +
                       "       GROUP BY tRoomType, dOccupationDay";
        try{
            pstmt = con.prepareStatement(QUERY);
            pstmt.setInt(1,availabilityQry.getHotel());
            pstmt.setDate(2,availabilityQry.getStartDate());
            pstmt.setDate(3,availabilityQry.getEndDate());
            //pstmt.setString(4,availabilityQry.getStatus());
            //System.out.println(pstmt);
            rs = pstmt.executeQuery();
            while(rs.next()){
                AvailabilityDay a = new AvailabilityDay();
                a.setRoomType(rs.getString(1));
                a.setOccupiedDay(rs.getDate(2));
                a.setOccupiedRooms(rs.getInt(3));
                al.add(a);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return al;
    }

    public ArrayList getOccupationDays(){
        ArrayList al = new ArrayList();
        String QUERY = "SELECT tRoomType, dOccupationDay, COUNT(dOccupationDay)" +
                       "  FROM occupation" +
                       " WHERE nHotel = ? AND tRoomType = ? AND" +
                             " dOccupationDay >= ? AND dOccupationDay < ?" +
                       " GROUP BY dOccupationDay";
        try{
            PreparedStatement pstmt = con.prepareStatement(QUERY);
            pstmt.setInt(1,availabilityQry.getHotel());
            pstmt.setString(2,availabilityQry.getRoomType());
            pstmt.setDate(3,availabilityQry.getStartDate());
            pstmt.setDate(4,availabilityQry.getEndDate());
            //System.out.println(pstmt+"\n");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
              AvailabilityDay a = new AvailabilityDay();
              a.setRoomType(rs.getString(1));
              a.setOccupiedDay(rs.getDate(2));
              a.setOccupiedRooms(rs.getInt(3));
              al.add(a);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return al;
    }

}