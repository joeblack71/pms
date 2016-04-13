
package com.myco.central.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.myco.central.vo.Guest;

public class GuestDAO {

    public GuestDAO() {
    }

    /*
     * TODO probar la eficiencia del uso de ArrayList vs Hashtable
     */
    public ArrayList<Guest> getReservationGuests(String hotelId,
    		String reservationNumber)
    throws SQLException {

    	Connection conn = ConProvider.getConnection(); 
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Guest guest = null;
		ArrayList<Guest> guests = new ArrayList<Guest>();
		String sql = "SELECT * FROM reservation_guest" +
                             " WHERE nHotelId = ? AND nReservationNumber=?";
		int k=0;
		
        try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(k++, hotelId);
			pstmt.setString(k++, reservationNumber);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				guest = new Guest();  
			    guest.setCustomerId( rs.getString(3) );
			    guest.setCustomerDocument( rs.getString(4) );
			    guest.setCustomerNames( rs.getString(5) );
			    guests.add(guest);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        return guests;
    }

    public boolean addReservationGuest(Guest guest) {
    	Connection conn = ConProvider.getConnection(); 
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO reservation_guest("
			+ "nHotelId, nReservationNumber, nCustomerId,"
			+ "tCustomerDocument,tCustomerName) VALUES(?,?,?,?,?)";

        boolean flag = false;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, guest.getHotelId() );
            pstmt.setString(2, guest.getReservationNumber() );
            pstmt.setString(3, guest.getCustomerId() );
            pstmt.setString(4, guest.getCustomerDocument() );
            pstmt.setString(5, guest.getCustomerNames() );
            //System.out.println(ps);
            pstmt.executeUpdate();
            flag = true;
        } catch (Exception e) { e.printStackTrace(); }
        
        return flag;
    }

    public boolean update(Guest guest) {
    	Connection conn = ConProvider.getConnection(); 
        boolean flag = false;

        try {
            String sql = "UPDATE reservation_guest SET" +
                               " nCustomerId = ?, nCustomerDocument = ?" +
                               " nCustomerName" +
                               " WHERE nHotelId = ? AND nReservationNumber = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, guest.getCustomerId());
            ps.setString(2,  guest.getCustomerDocument());
            ps.setString(3,  guest.getReservationNumber());
            ps.setString(4,  guest.getHotelId());
            ps.setString(5,  guest.getCustomerNames());
            //System.out.println(ps);
            ps.executeUpdate();
            flag = true;
        } catch (Exception e) { e.printStackTrace(); }
        
        return flag;
    }

    public boolean delete() {
    	Connection conn = ConProvider.getConnection(); 
        boolean flag = false;
		Guest guest = null;
        try {
            String sql = "DELETE FROM reservation_guest" +
                               " WHERE nHotelId = ? AND nReservationNumber = ? AND" +
                                     " nCustomerId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, guest.getHotelId());
            ps.setString(2, guest.getReservationNumber());
            ps.setString(3, guest.getCustomerId());
            ps.executeUpdate();
            flag = true;
        } catch (Exception e){ e.printStackTrace(); }
        
        return flag;
    }

    public ArrayList<Guest> getAllGuests(String hotelId) {
    	Connection conn = ConProvider.getConnection(); 
		Guest guest = null;
		ArrayList<Guest> al = new ArrayList<Guest>();
        String sql = "SELECT * FROM reservation_guest";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while( rs.next() ) {
                guest = new Guest();
                guest.setHotelId( rs.getString(1) );
                guest.setReservationNumber( rs.getString(2) );
                guest.setCustomerId( rs.getString(3) );
                guest.setCustomerDocument( rs.getString(4) );
                guest.setCustomerNames( rs.getString(5) );
                al.add(guest);
            }
        } catch (Exception e) { e.printStackTrace(); }
        
        return al;
    }

    public HashMap<String, Guest> chargeGuests(String hotelId, String reservationNumber) {
    	Connection conn = ConProvider.getConnection(); 
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Guest rg = null;
        
        HashMap<String, Guest> guests
        		= new HashMap<String, Guest>();
        String sql = "SELECT * FROM reservation_guest" +
                             " WHERE nHotelId = ? AND nReservationNumber = ?" +
                             " ORDER BY tCustomerName";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, hotelId);
            pstmt.setString(2, reservationNumber );
            rs = pstmt.executeQuery();
            while( rs.next() ) {
                rg = new Guest();
                rg.setHotelId( rs.getString("nHotelId") );
                rg.setReservationNumber( rs.getString("nReservationNumber") );
                rg.setCustomerId( rs.getString("nCustomerId") );
                rg.setCustomerDocument( rs.getString("tCustomerDocument") );
                rg.setCustomerNames( rs.getString("tCustomername") );
                rg.setStatus("");
                guests.put(String.valueOf( rg.getCustomerId() ), rg);
            }
        } catch (Exception e) { e.printStackTrace(); }
        
        return guests;
    }

}