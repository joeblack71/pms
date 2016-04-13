
package com.mycom.booking.dispatchers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mycom.booking.beans.Reservation;
import com.mycom.booking.events.ReservationDataException;
import com.mycom.booking.libraries.DateManager;


public class ReservationDisp {

    private Connection con;
    private Reservation res;

    public ReservationDisp() {}

    public void setConnection(Connection con) {
        this.con = con;
    }

    public void setReservation(Reservation res) {
        this.res = res;
    }

    public boolean validate() {
        boolean flag = false;
        String QUERY = "SELECT * FROM reservation" +
                             " WHERE nHotelId = ? AND nReservation = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(QUERY);
            pstmt.setShort(1, res.getHotelId());
            pstmt.setInt(2, res.getReservation());
            //System.out.println(pstmt+"\n");
            ResultSet rs = pstmt.executeQuery();
            if ( rs.next() )
                flag = true;
        } catch (Exception e) { e.printStackTrace(); }
        return flag;
    }

    public boolean search() {
        boolean flag=false;
        String QUERY = "SELECT * FROM reservation" +
                             " WHERE nHotelId = ? AND nReservation = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(QUERY);
            pstmt.setShort(1, res.getHotelId());
            pstmt.setInt(2, res.getReservation());
            //System.out.println(pstmt+"\n");
            ResultSet rs = pstmt.executeQuery();
            if ( rs.next() ) {
                res.setStatus(rs.getString("tStatus"));
                res.setNights(rs.getShort("nNights"));
                res.setSourceId(rs.getShort("nSourceId"));
                res.setArrival(rs.getDate("dArrival"));
                res.setDeparture(rs.getDate("dDeparture"));
                res.setAdults(rs.getShort("nAdults"));
                res.setChildren(rs.getShort("nChildren"));
                res.setRoomType(rs.getString("tRoomType"));
                res.setQuantity(rs.getShort("nQuantity"));
                res.setRoomNumber(rs.getString("tRoomNumber"));
                res.setSourceId(rs.getShort("nSourceId"));
                res.setRoomRate(rs.getFloat("nRoomRate"));
                res.setTotal(rs.getFloat("nTotalRoom"));
                res.setPaymentType(rs.getShort("nPaymentType"));
                res.setLastname1(rs.getString("tLastName1"));
                res.setLastname2(rs.getString("tLastName2"));
                res.setFirstname(rs.getString("tFirstName"));
                res.setInstructions(rs.getString("tInstructions"));
                res.setMadeBy(rs.getString("tMadeBy"));
                res.setUpdatedBy(rs.getString("tUpdatedBy"));
                try { // TODO: take out after testing
                    res.setPaymentDue(rs.getDate("dPaymentDue"));
                    res.setMadeOn(rs.getString("dMadeOn"));
                    res.setUpdatedOn(rs.getString("dUpdatedOn"));
                } catch (SQLException ex) { }
                flag = true;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return flag;
    }

    public boolean insert() {
        boolean flag = false;
        String sql = "INSERT INTO reservation" +
                           " (nHotelId, tStatus, nNights, nSourceId, dArrival," +
                           " dDeparture, nAdults, nChildren, tRoomType, nQuantity," +
                           " tRoomNumber, nRoomRate, nTotalRoom, dPaymentDue," +
                           " nPaymentType, tLastname1, tLastname2, tFirstname, " +
                           " tInstructions, tMadeBy, tUpdatedBy, dMadeOn, dUpdatedOn)" +
                     " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),now())";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            //PreparedStatement pre = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setShort(1,   res.getHotelId());
            pre.setString(2,  res.getStatus());
            pre.setShort(3,   res.getNights());
            pre.setShort(4,   res.getSourceId());
            pre.setDate(5,    res.getArrival());
            pre.setDate(6,    res.getDeparture());
            pre.setShort(7,   res.getAdults());
            pre.setShort(8,   res.getChildren());
            pre.setString(9,  res.getRoomType());
            pre.setShort(10,  res.getQuantity());
            pre.setString(11, res.getRoomNumber());
            pre.setFloat(12,  res.getRoomRate());
            pre.setFloat(13,  res.getTotal());
            pre.setDate(14,   res.getPaymentDue());
            pre.setShort(15,  res.getPaymentType());
            pre.setString(16, res.getLastname1());
            pre.setString(17, res.getLastname2());
            pre.setString(18, res.getFirstname());
            pre.setString(19, res.getInstructions());
            pre.setString(20, res.getMadeBy());
            pre.setString(21, res.getUpdatedBy());
            //System.out.println(pre+"\n");
            int rowCount = pre.executeUpdate();
            setReservationNumber(pre);
            flag = true;
        } catch (Exception e) { e.printStackTrace(); }
        return flag;
    }

    private void setReservationNumber(PreparedStatement pre){
        int autoIncKeyFromApi = -1;
        try {
            ResultSet rs = pre.getGeneratedKeys();
            if ( rs.next() )
                autoIncKeyFromApi = rs.getInt(1);
            if ( autoIncKeyFromApi == -1 )
                 System.out.println("NO pudo recuperar llave generada");
            else 
                try {
                    res.setReservation( String.valueOf(autoIncKeyFromApi) );
                } catch (ReservationDataException ex) {
                    ex.printStackTrace();
                }
            rs.close();
            rs = null;
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
    
    public boolean update() {
        boolean flag = false;
        try {
            String sql = "UPDATE reservation SET" +
                               " tStatus=?, nNights=?, nSourceId=?," +
                               " dArrival=?, dDeparture=?, nAdults=?," +
                               " nChildren=?, tRoomType=?, nQuantity=?," +
                               " tRoomNumber=?,nRoomRate=?, nTotalRoom=?," +
                               " dPaymentDue=?, nPaymentType=?," +
                               " tLastName1=?, tLastName2=?, tFirstname=?," +
                               " tInstructions=?, tUpdatedBy=?" +
                         " WHERE nHotelId=? AND nReservation=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1,  res.getStatus());
            pre.setShort(2,   res.getNights());
            pre.setShort(3,   res.getSourceId());
            pre.setDate(4,    res.getArrival());
            pre.setDate(5,    res.getDeparture());
            pre.setShort(6,   res.getAdults()); 
            pre.setShort(7,   res.getChildren());
            pre.setString(8,  res.getRoomType());
            pre.setShort(9,   res.getQuantity());
            pre.setString(10, res.getRoomNumber());
            pre.setFloat(11,  res.getRoomRate());
            pre.setFloat(12,  res.getTotal());
            pre.setDate(13,   res.getPaymentDue() );
            pre.setShort(14,  res.getPaymentType() );
            pre.setString(15, res.getLastname1());
            pre.setString(16, res.getLastname2());
            pre.setString(17, res.getFirstname());
            pre.setString(18, res.getInstructions());
            pre.setString(19, res.getUpdatedBy());
            pre.setShort(20,  res.getHotelId()); /* Hotel ID */
            pre.setInt(21,    res.getReservation()); /* Reservation Number */
            //System.out.println(pre+"\n");
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){ e.printStackTrace(); }
        return flag;
    }

    public boolean delete() {
        boolean flag = false;
        try {
            String sql = "DELETE FROM reservation" +
                               " WHERE nHotelId=? AND nReservation=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setShort(1, res.getHotelId());
            pre.setInt(2,  res.getReservation());
            //System.out.println(pre+"\n");
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){ e.printStackTrace(); }
        return flag;
    }

    public List<Reservation> chargeAll() {
        List<Reservation> al = new ArrayList<Reservation>();
        String QUERY = "SELECT * FROM reservation";

        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while(rs.next()){
                al.add( chargeArrayList(rs) );
            }
        } catch (Exception e){ e.printStackTrace(); }

        return al;
    }

    public List<Reservation> chargeArrivals(String hotel, String occupationDay) {
        List<Reservation> al = new ArrayList<Reservation>();
        java.sql.Date dateOcc = DateManager.sqlDateValueOf(occupationDay);
        String QUERY = "SELECT * FROM reservation" +
                       " WHERE nHotelId = ? AND dArrival <= ? AND dDeparture >  ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(QUERY);
            pstmt.setInt(1, Short.parseShort(hotel) );
            pstmt.setDate(2,dateOcc);
            pstmt.setDate(3,dateOcc);
            System.out.println(pstmt);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                al.add( chargeArrayList(rs) );
            }
        } catch (Exception e){ e.printStackTrace(); }
        return al;
    }

    public List<Reservation> chargeByReservation(String hotel, String reservation) {
        List<Reservation> al = new ArrayList<Reservation>();
        String QUERY = "SELECT * FROM reservation" +
                             " WHERE nHotelId = ? AND nReservation >= ?" +
                                   " ORDER BY nReservation";
        try {
            PreparedStatement pstmt = con.prepareStatement(QUERY);
            pstmt.setInt(1,Short.parseShort(hotel));
            pstmt.setString(2,reservation);
            System.out.println(pstmt);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                al.add( chargeArrayList(rs) );
            }
        } catch (Exception e){ e.printStackTrace(); }
        return al;
    }

    public List<Reservation> chargeByLastName(String hotel, String lastname) {
        List<Reservation> al = new ArrayList<Reservation>();
        String QUERY = "SELECT * FROM reservation" +
                             " WHERE nHotelId = ? AND tLastName1 like ?" +
                                   " ORDER BY tLastName1";
        try {
            PreparedStatement pstmt = con.prepareStatement(QUERY);
            pstmt.setInt(1,Short.parseShort(hotel));
            pstmt.setString(2,lastname + "%");
            System.out.println(pstmt);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                al.add( chargeArrayList(rs) );
            }
        } catch (Exception e){ e.printStackTrace(); }

        return al;
    }

    public List<Reservation> chargeByArrival(String hotel, String arrival) {
        List<Reservation> al = new ArrayList<Reservation>();
        String QUERY = "SELECT * FROM reservation" +
                       " WHERE nHotelId = ? AND dArrival = ? ORDER BY dArrival";
        try {
            PreparedStatement pstmt = con.prepareStatement(QUERY);
            pstmt.setInt(1, Short.parseShort(hotel) );
            pstmt.setDate(2, DateManager.sqlDateValueOf(arrival) );
            System.out.println(pstmt);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                al.add( chargeArrayList(rs) );
            }
        } catch (Exception e){ e.printStackTrace(); }
        return al;
    }

    public List<Reservation> chargeByDeparture(String hotel, String departure) {
        List<Reservation> al = new ArrayList<Reservation>();
        String QUERY = "SELECT * FROM reservation" +
                       " WHERE nHotelId = ? AND dDeparture = ? ORDER BY dDeparture";
        try {
            PreparedStatement pstmt = con.prepareStatement(QUERY);
            pstmt.setInt(1, Short.parseShort(hotel) );
            pstmt.setDate(2, DateManager.sqlDateValueOf(departure) );
            System.out.println(pstmt);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                al.add( chargeArrayList(rs) );
            }
        } catch (Exception e){ e.printStackTrace(); }
        return al;
    }

    public List<Reservation> chargeByCreationDate(String hotel, String creationDate) {
        List<Reservation> al = new ArrayList<Reservation>();
        String QUERY = "SELECT * FROM reservation" +
                       " WHERE nHotelId = ? AND date(dMadeOn) = ? ORDER BY dMadeOn";
        try {
            PreparedStatement pstmt = con.prepareStatement(QUERY);
            pstmt.setInt(1, Short.parseShort(hotel) );
            pstmt.setDate(2, DateManager.sqlDateValueOf(creationDate) );
            System.out.println(pstmt);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                al.add( chargeArrayList(rs) );
            }
        } catch (Exception e){ e.printStackTrace(); }
        return al;
    }

  private Reservation chargeArrayList(ResultSet rs) {
      Reservation r = new Reservation();
      try {
        r.setHotelId(rs.getByte("nHotelId"));
        r.setReservation(rs.getString("nReservation"));
        r.setRoomType(rs.getString("tRoomType"));
        r.setQuantity(rs.getShort("nQuantity"));
        r.setRoomNumber(rs.getString("tRoomNumber"));
        r.setLastname1(rs.getString("tLastName1"));
        r.setLastname2(rs.getString("tLastName2"));
        r.setFirstname(rs.getString("tFirstname"));
        //r.setVipCode(rs.getString(8));
        r.setArrival(rs.getDate("dArrival"));
        r.setDeparture(rs.getDate("dDeparture"));
        r.setNights(rs.getShort("nNights"));
        r.setStatus(rs.getString("tStatus"));
        r.setRoomRate(rs.getFloat("nRoomRate"));
        r.setSourceId(rs.getShort("nSourceId"));
        r.setAdults(rs.getShort("nAdults"));
        r.setChildren(rs.getShort("nChildren"));
        r.setTotal(rs.getFloat("nTotalRoom"));
        r.setPaymentDue(rs.getDate("dPaymentDue"));
        r.setPaymentType(rs.getShort("nPaymentType"));
        r.setInstructions(rs.getString("tInstructions"));
        r.setMadeBy(rs.getString("tMadeBy"));
        r.setMadeOn(rs.getString("tMadeOn"));
        r.setUpdatedBy(rs.getString("tUpdatedBy"));
        r.setUpdatedOn(rs.getString("tUpdatedOn"));
        /*r.setExtraPerson(rs.getString(18));
        r.setCompany(rs.getString(21));
        r.setNationality(rs.getString(22));
        r.setFolios(rs.getString(24));*/
      } catch(Exception e) {}
      return r;
  }

}
