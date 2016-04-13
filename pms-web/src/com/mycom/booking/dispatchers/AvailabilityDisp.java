
package com.mycom.booking.dispatchers;

import java.sql.*;
import java.util.ArrayList;

import com.mycom.booking.beans.AvailabilityQry;
import com.mycom.booking.beans.OccupationDay;
import com.mycom.booking.libraries.DateManager;
import com.mycom.booking.lists.OccupationByDays;


public class AvailabilityDisp {

    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet  rs=null;
    //private ArrayList  al=null;

    private AvailabilityQry aq;

    public AvailabilityDisp() {}

    /*public Connection getConnection() {
        return con;
    }*/
    public void setConnection(Connection con) {
        this.con = con;
    }

    public void setAvailabilityQry(AvailabilityQry aq) {
        this.aq = aq;
    }

    /** 
     * Charge a <code>List</code> object with occupation expected for
     * each <b>room type</b> in an specific period.
     * 
     * @param obd the list where occupation will be charged.
     *
     * TODO:
     * 1. Crear metodos que entreguen ocupacion mensual, anual, etc.
     * 2. Resume occupability for all hotels.
     * 3. Manejar query de acuerdo al periodo solicitado (group by)
     */
    public void chargeOccupationByType(OccupationByDays obd) {
        String QUERY = "SELECT tRoomType, dOccupationDay, COUNT(tRoomType)" +
                             " FROM occupation" +
                             " WHERE nHotelId = ? AND" +
                                   " dOccupationDay >= ? AND dOccupationDay <= ?" +
                                   " AND tStatus != 'X'" +
                             " GROUP BY tRoomType, dOccupationDay";
        try {
            pstmt = con.prepareStatement(QUERY);
            pstmt.setInt(1,aq.getHotelId());
            pstmt.setDate(2, aq.getStartDate() );
            pstmt.setDate(3, aq.getEndDate() );
            //pstmt.setString(4,aq.getStatus());
            System.out.println(pstmt+"\n");
            rs = pstmt.executeQuery();
            while( rs.next() ) {
                OccupationDay od = new OccupationDay();
                od.setRoomType(rs.getString(1));
                od.setOccupiedDay(rs.getDate(2));
                od.setOccupiedRooms(rs.getInt(3));
                obd.add(od);
            }
        } catch (Exception e){ e.printStackTrace(); }
    }

    /**
     * Charge a <code>List</code> object with occupation expected for
     * each day requested by a reservation.
     *
     * @param obd the list where occupation will be charged.
     */
    public void chargeOccupationOnStay(OccupationByDays obd) {
        String QUERY = "SELECT tRoomType, dOccupationDay, COUNT(dOccupationDay)" +
                             " FROM occupation" +
                             " WHERE nHotelId = ? AND tRoomType = ? AND" +
                                   " dOccupationDay >= ? AND dOccupationDay < ?" +
                             " GROUP BY dOccupationDay";
        try {
            //PreparedStatement pstmt = con.prepareStatement(QUERY);
            CallableStatement cstmt = con.prepareCall("call sp_available_stay(?,?,?,?)");
            cstmt.setInt(1,aq.getHotelId());
            cstmt.setString(2,aq.getRoomType());
            cstmt.setDate(3, aq.getStartDate() );
            cstmt.setDate(4, aq.getEndDate() );
            //System.out.println(cstmt+"\n");
            ResultSet rs = cstmt.executeQuery();
            while( rs.next() ) {
                OccupationDay od = new OccupationDay();
                od.setRoomType(rs.getString(1));
                od.setOccupiedDay(rs.getDate(2));
                od.setOccupiedRooms(rs.getInt(3));
                obd.add(od);
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

}