
package com.mycom.booking.dispatchers;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;

import com.mycom.booking.beans.Reservation;
import com.mycom.booking.beans.ReservationGuest;


public class ReservationGuestDisp {

    private Reservation res;
    private ReservationGuest rgst;
    private Connection con;

    public ReservationGuestDisp() {
    }
   
    public Connection getConnection() {
        return con;
    }
    
    public void setConnection(Connection con) {
        this.con = con;
    }

    public void setReservation(Reservation res) {
        this.res = res;
    }
    
    public ReservationGuest getReservationGuest() {
        return rgst;
    }

    public void setReservationGuest(ReservationGuest rgst) {
        this.rgst = rgst;
    }
    
    public boolean validate() {
        boolean flag=false;
        String QUERY = "SELECT * FROM reservation_guest" +
                             " WHERE nHotelId = ? AND nReservationNumber=?";
        try {
            PreparedStatement pstmt = con.prepareStatement(QUERY);
            pstmt.setShort(1,rgst.getHotelId());
            pstmt.setInt(2,rgst.getReservationNumber());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                rgst.setCustomerId( rs.getShort(3) );
                rgst.setCustomerDocument( rs.getString(4) );
                rgst.setCustomerName( rs.getString(5) );
                flag = true;
            }
        } catch (Exception e) { e.printStackTrace(); }
        
        return flag;
    }

    public boolean insert() {
        boolean flag = false;
        try {
            String sql = "INSERT INTO reservation_guest" +
                               " ( nHotelId, nReservationNumber," +
                               " nCustomerId, tCustomerDocument," +
                               " tCustomerName)" +
                               " VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setShort(1, rgst.getHotelId() );
            ps.setInt(2, rgst.getReservationNumber() );
            ps.setShort(3, rgst.getCustomerId() );
            ps.setString(4, rgst.getCustomerDocument() );
            ps.setString(5, rgst.getCustomerName() );
            //System.out.println(ps);
            ps.executeUpdate();
            flag = true;
        } catch (Exception e) { e.printStackTrace(); }
        
        return flag;
    }

    public boolean update() {
        boolean flag = false;
        try {
            String sql = "UPDATE reservation_guest SET" +
                               " nCustomerId = ?, nCustomerDocument = ?" +
                               " nCustomerName" +
                               " WHERE nHotelId = ? AND nReservationNumber = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rgst.getCustomerId());
            ps.setString(2,  rgst.getCustomerDocument());
            ps.setInt(3,  rgst.getReservationNumber());
            ps.setShort(4,  rgst.getHotelId());
            ps.setString(5,  rgst.getCustomerName());
            //System.out.println(ps);
            ps.executeUpdate();
            flag = true;
        } catch (Exception e) { e.printStackTrace(); }
        
        return flag;
    }

    public boolean delete() {
        boolean flag = false;
        try {
            String sql = "DELETE FROM reservation_guest" +
                               " WHERE nHotelId = ? AND nReservationNumber = ? AND" +
                                     " nCustomerId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setShort(1, rgst.getHotelId());
            ps.setInt(2, rgst.getReservationNumber());
            ps.setShort(3, rgst.getCustomerId());
            ps.executeUpdate();
            flag = true;
        } catch (Exception e){ e.printStackTrace(); }
        
        return flag;
    }

    public ArrayList chargeAll() {
        ArrayList al = new ArrayList();
        String sql = "SELECT * FROM reservation_guest";
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while( rs.next() ) {
                ReservationGuest rg = new ReservationGuest();
                rg.setHotelId( rs.getShort(1) );
                rg.setReservationNumber( rs.getInt(2) );
                rg.setCustomerId( rs.getShort(3) );
                rg.setCustomerDocument( rs.getString(4) );
                rg.setCustomerName( rs.getString(5) );
                al.add(rg);
            }
        } catch (Exception e) { e.printStackTrace(); }
        
        return al;
    }

    public void chargeGuests() {
        Hashtable guests = new Hashtable();
        String QUERY = "SELECT * FROM reservation_guest" +
                             " WHERE nHotelId = ? AND nReservationNumber = ?" +
                             " ORDER BY tCustomerName";
        try {
            PreparedStatement pstmt = con.prepareStatement(QUERY);
            pstmt.setShort(1, res.getHotelId() );
            pstmt.setInt(2, res.getReservation() );
            ResultSet rs = pstmt.executeQuery();
            ReservationGuest rg = null;
            while( rs.next() ) {
                rg = new ReservationGuest();
                rg.setHotelId( rs.getShort("nHotelId") );
                rg.setReservationNumber( rs.getShort("nReservationNumber") );
                rg.setCustomerId( rs.getShort("nCustomerId") );
                rg.setCustomerDocument( rs.getString("tCustomerDocument") );
                rg.setCustomerName( rs.getString("tCustomername") );
                //rg.setStatus(' ');
                guests.put( new Short( rg.getCustomerId() ), rg );
            }
            res.setGuests(guests);
        } catch (Exception e) { e.printStackTrace(); }
    }

}