
package com.myco.central.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//import com.myco.central.vo.Availability;
import com.myco.central.vo.OccupationDay;

public class AvailabilityDAO {
	
	Log log = LogFactory.getLog(AvailabilityDAO.class);

    public AvailabilityDAO() {}

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
    public List<OccupationDay> chargeOccupationByType(String hotelId,
    		String startDate, String endDate, String period, String status)
	throws Exception,SQLException {
    	Connection con = ConProvider.getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	List<OccupationDay> list = new ArrayList<OccupationDay>();
        String QUERY = "SELECT tRoomType, dOccupationDay, COUNT(tRoomType)" +
                             " FROM occupation" +
                             " WHERE nHotelId = ? AND" +
                                   " dOccupationDay >= ? AND dOccupationDay <= ?" +
                                   " AND tStatus != 'X'" +
                             " GROUP BY tRoomType, dOccupationDay";
        int k = 1;

        try {
            pstmt = con.prepareStatement(QUERY);
            pstmt.setString(k++, hotelId);
            pstmt.setString(k++, startDate);
            pstmt.setString(k++, endDate);
            //pstmt.setString(k++, status);
            //log.info(pstmt+"\n");
            rs = pstmt.executeQuery();
            while( rs.next() ) {
                OccupationDay od = new OccupationDay();
                od.setRoomType(rs.getString(1));
                od.setOccupiedDay(rs.getDate(2));
                od.setOccupiedRooms(rs.getInt(3));
                list.add(od);
            }
        } catch (Exception e){ e.printStackTrace(); }
        
        return list;
    }

    /**
     * Charge a <code>List</code> object with occupation expected for
     * each day requested by a reservation.
     *
     * @param obd the list where occupation will be charged.
     */
    //TODO enviar parametros a traves de Availability
    public List<OccupationDay> chargeOccupationOnStay(String hotelId,
    		String roomType, String startDate, String endDate, String status)
    	throws Exception {
    	Connection con = ConProvider.getConnection();
    	//PreparedStatement pstmt = null;
        CallableStatement cstmt = null;
    	ResultSet rs = null;
    	
    	List<OccupationDay> list = new ArrayList<OccupationDay>();
        String qry = "SELECT tRoomType, dOccupationDay, COUNT(dOccupationDay)" +
                             " FROM occupation" +
                             " WHERE nHotelId = ? AND tRoomType = ? AND" +
                                   " dOccupationDay >= ? AND dOccupationDay < ?" +
                             " GROUP BY dOccupationDay";
        int k = 0;
        
        try {
            //PreparedStatement pstmt = con.prepareStatement(qry);
            cstmt = con.prepareCall("call sp_available_stay(?,?,?,?,?)");
            cstmt.setString(k++, hotelId);
            cstmt.setString(k++, roomType);
            cstmt.setString(k++, startDate);
            cstmt.setString(k++, endDate);
            cstmt.setString(k++, status);
            //System.out.println(cstmt+"\n");
            rs = cstmt.executeQuery();
            while( rs.next() ) {
                OccupationDay od = new OccupationDay();
                od.setRoomType(rs.getString(1));
                od.setOccupiedDay(rs.getDate(2));
                od.setOccupiedRooms(rs.getInt(3));
                list.add(od);
            }
        } catch (Exception e) { e.printStackTrace(); }
        
        return list;
    }

}