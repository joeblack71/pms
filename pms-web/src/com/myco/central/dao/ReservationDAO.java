
package com.myco.central.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myco.central.events.ReservationDataException;
import com.myco.central.util.DateManager;
import com.myco.central.vo.Reservation;

public class ReservationDAO {
	
	Log log = LogFactory.getLog(ReservationDAO.class);

    private Connection con;
    private Reservation res;

    public ReservationDAO() {}

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

    public Reservation getReservation(String idHotel, String idReservation) {

    	Connection con = ConProvider.getConnection();
    	
        Reservation res = null;
        String qry = "SELECT * FROM reservation"
        	+ " WHERE nHotelId = ? AND nReservation = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(qry);
            pstmt.setString(1, idHotel);
            pstmt.setString(2, idReservation);
            ResultSet rs = pstmt.executeQuery();
            if ( rs.next() ) {
            	res = new Reservation();
            	res.setHotelId(rs.getShort("nHotelid"));
            	res.setReservation(rs.getString("nReservation"));
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
                res.setHotelInstructions(rs.getString("tInstructions"));
                res.setMadeBy(rs.getString("tMadeBy"));
                res.setUpdatedBy(rs.getString("tUpdatedBy"));
                try { // TODO: take out after testing
                    res.setPaymentDue(rs.getDate("dPaymentDue"));
                    res.setMadeOn(rs.getString("dMadeOn"));
                    res.setUpdatedOn(rs.getString("dUpdatedOn"));
                } catch (SQLException ex) {
                	log.info(ex.getMessage());
                }
                
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }

        return res;
    }

    public void insert(Reservation res) throws SQLException {
        Connection con = ConProvider.getConnection();
        PreparedStatement pre = null;
        String sql = "INSERT INTO reservation" +
                           " (nHotelId, tStatus, nNights, nSourceId, dArrival," +
                           " dDeparture, nAdults, nChildren, tRoomType, nQuantity," +
                           " tRoomNumber, nRoomRate, nTotalRoom, dPaymentDue," +
                           " nPaymentType, tLastname1, tLastname2, tFirstname, " +
                           " tInstructions, tMadeBy, tUpdatedBy, dMadeOn, dUpdatedOn)" +
                     " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),now())";
        int k=1;
        int rowCount=0;
        try {
            pre = con.prepareStatement(sql);
            //PreparedStatement pre = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            pre.setShort(k++,   res.getHotelId());
            pre.setString(k++,  res.getStatus());
            pre.setShort(k++,   res.getNights());
            pre.setShort(k++,   res.getSourceId());
            pre.setDate(k++,    res.getArrival());
            pre.setDate(k++,    res.getDeparture());
            pre.setShort(k++,   res.getAdults());
            pre.setShort(k++,   res.getChildren());
            pre.setString(k++,  res.getRoomType());
            pre.setShort(k++,  res.getQuantity());
            pre.setString(k++, res.getRoomNumber());
            pre.setFloat(k++,  res.getRoomRate());
            pre.setFloat(k++,  res.getTotal());
            pre.setDate(k++,   res.getPaymentDue());
            pre.setShort(k++,  res.getPaymentType());
            pre.setString(k++, res.getLastname1());
            pre.setString(k++, res.getLastname2());
            pre.setString(k++, res.getFirstname());
            pre.setString(k++, res.getHotelInstructions());
            pre.setString(k++, res.getMadeBy());
            pre.setString(k++, res.getUpdatedBy());

            rowCount = pre.executeUpdate();
            setReservationNumber(pre);

        } catch (Exception e) {
        	e.printStackTrace();
        }
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
    
    public void update(Reservation res) throws SQLException{
        Connection con = ConProvider.getConnection();
        PreparedStatement pre = null;
        String sql = "UPDATE reservation SET" +
                           " tStatus=?, nNights=?, nSourceId=?," +
                           " dArrival=?, dDeparture=?, nAdults=?," +
                           " nChildren=?, tRoomType=?, nQuantity=?," +
                           " tRoomNumber=?,nRoomRate=?, nTotalRoom=?," +
                           " dPaymentDue=?, nPaymentType=?," +
                           " tLastName1=?, tLastName2=?, tFirstname=?," +
                           " tInstructions=?, tUpdatedBy=?" +
                     " WHERE nHotelId=? AND nReservation=?";
        int k=1;

        try {
            pre = con.prepareStatement(sql);

            pre.setString(k++,  res.getStatus());
            pre.setShort(k++,   res.getNights());
            pre.setShort(k++,   res.getSourceId());
            pre.setDate(k++,    res.getArrival());
            pre.setDate(k++,    res.getDeparture());
            pre.setShort(k++,   res.getAdults()); 
            pre.setShort(k++,   res.getChildren());
            pre.setString(k++,  res.getRoomType());
            pre.setShort(k++,   res.getQuantity());
            pre.setString(k++, res.getRoomNumber());
            pre.setFloat(k++,  res.getRoomRate());
            pre.setFloat(k++,  res.getTotal());
            pre.setDate(k++,   res.getPaymentDue() );
            pre.setShort(k++,  res.getPaymentType() );
            pre.setString(k++, res.getLastname1());
            pre.setString(k++, res.getLastname2());
            pre.setString(k++, res.getFirstname());
            pre.setString(k++, res.getHotelInstructions());
            pre.setString(k++, res.getUpdatedBy());
            pre.setShort(k++,  res.getHotelId()); /* Hotel ID */
            pre.setInt(k++,    res.getReservation()); /* Reservation Number */

            pre.executeUpdate();
        } catch(Exception ex) {
        	ex.printStackTrace();
        } /*finally {
        	DAO.closeSQLObjects(rs, cstm, conn);
        }*/
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

    public static ArrayList getReportByPattern(int field, String pattern) {
        Connection c = ConProvider.getConnection();
        ReservationDAO rdisp = new ReservationDAO();
        rdisp.setConnection(c);
        ArrayList records = null;
        switch( field ) {
            case 1: records = rdisp.chargeByLastName("1",pattern); break;
            case 2: records = rdisp.chargeByArrival("1",pattern); break;
            case 3: records = rdisp.chargeByDeparture("1",pattern); break;
            case 4: records = rdisp.chargeByReservation("1",pattern); break;
            case 5: records = rdisp.chargeByCreationDate("1",pattern); break;
        }
        try { c.close();
        } catch (Exception e) {}
        return records;
    }

    public ArrayList<Reservation> getReservationList(String hotelId) {
    	Connection con = ConProvider.getConnection();
    	
        ArrayList<Reservation> al = new ArrayList<Reservation>();
        String qry = "SELECT * FROM reservation"
        	+ " WHERE nHotelId = " + hotelId;

        try {
            ResultSet rs = con.createStatement().executeQuery(qry);
            while( rs.next() ) {
                al.add( chargeArrayList(rs) );
            }
        } catch (Exception e){ e.printStackTrace(); }
        
        return al;
    }

    public ArrayList chargeArrivals(String hotel, String occupationDay) {
        ArrayList al = new ArrayList();
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

    public ArrayList chargeByReservation(String hotel, String reservation) {
        ArrayList al = new ArrayList();
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

    public ArrayList chargeByLastName(String hotel, String lastname) {
        ArrayList al = new ArrayList();
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

    public ArrayList chargeByArrival(String hotel, String arrival) {
        ArrayList al = new ArrayList();
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

    public ArrayList chargeByDeparture(String hotel, String departure) {
        ArrayList al = new ArrayList();
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

    public ArrayList chargeByCreationDate(String hotel, String creationDate) {
        ArrayList al = new ArrayList();
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
        r.setHotelInstructions(rs.getString("tInstructions"));
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
