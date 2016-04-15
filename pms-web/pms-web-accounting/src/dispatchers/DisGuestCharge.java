
package dispatchers;

import java.sql.*;
import java.util.ArrayList;

import beans.GuestCharge;

public class DisGuestCharge {

    private Connection con;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet  rs = null;

    private GuestCharge guestCharge;

    public DisGuestCharge() {}

    public Connection getConnection() {
        return con;
    }
    public void setConnection(Connection con) {
        this.con = con;
    }

    public GuestCharge getGuestCharge() {
        return guestCharge;
    }
    public void setGuestCharge(GuestCharge guestCharge) {
        this.guestCharge = guestCharge;
    }

    public boolean validate(){
        boolean flag=false;
        String QUERY = "SELECT dDateCharge,nAccount,nQuantity,nAmount,tCashier" +
                       " FROM guest_charge" +
                       " WHERE nHotel = ? AND nGuestCharge = ? AND nFolio = ?";
        try{
            PreparedStatement pstmt = con.prepareStatement(QUERY);
            pstmt.setByte(1, guestCharge.getHotel());
            pstmt.setString(2, guestCharge.getRoomNumber());
            pstmt.setInt(3, guestCharge.getFolio());
            //System.out.println(pstmt+"\n");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                guestCharge.setDateCharge(rs.getDate(1));
                guestCharge.setAccount(rs.getInt(2));
                guestCharge.setQuantity(rs.getShort(3));
                guestCharge.setAmount(rs.getFloat(4));
                guestCharge.setCashier(rs.getString(5));
                flag = true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insert(){
        boolean flag = false;
        String sql = "INSERT INTO guest_charge" +
                           " (nHotel,tRoomNumber,nFolio" +
                           "  dDateCharge,nAccount,nQuantity,nAmount,tCashier" +
                     " VALUES(?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pre = con.prepareStatement(sql);
            pstmt.setByte(1,guestCharge.getHotel());
            pstmt.setString(2,guestCharge.getRoomNumber());
            pstmt.setInt(3,guestCharge.getFolio());
            pre.setDate(4,guestCharge.getDateCharge());
            pre.setInt(5,guestCharge.getAccount());
            pre.setShort(6,guestCharge.getQuantity());
            pre.setFloat(7,guestCharge.getAmount());
            pstmt.setString(8,guestCharge.getCashier());
            //System.out.println(pre+"\n");
            pre.executeUpdate();
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean update(){
        boolean flag = false;
        try{
            String sql = "UPDATE guest_charge SET" +
                               " dDateCharge=?, nAccount=?, nQuantity=?, " +
                               " nAmount=?, tCashier=?" +
                         " WHERE nHotel=? AND nRoomNumber=? AND nFolio=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setDate(1,guestCharge.getDateCharge());
            pre.setInt(2,guestCharge.getAccount());
            pre.setShort(3,guestCharge.getQuantity());
            pre.setFloat(4,guestCharge.getAmount());
            pstmt.setString(5,guestCharge.getCashier());
            pstmt.setByte(6,guestCharge.getHotel());
            pstmt.setString(7,guestCharge.getRoomNumber());
            pstmt.setInt(8,guestCharge.getFolio());
            //System.out.println(pre+"\n");
            pre.executeUpdate();
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delete(){
        boolean flag = false;
        try{
            String sql = "DELETE FROM guest_charge" +
                               " WHERE nHotel=? AND nRoomNumber=? AND nFolio=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setByte(1, guestCharge.getHotel());
            pre.setString(2,  guestCharge.getRoomNumber());
            pstmt.setInt(3, guestCharge.getFolio());
            //System.out.println(pre+"\n");
            pre.executeUpdate();
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList chargeAll(){
        ArrayList al = new ArrayList();
        String QUERY = "SELECT * FROM guest_charge";
        try{
            rs = stmt.executeQuery(QUERY);
            while(rs.next()){
                chargeArrayList(rs, al);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return al;
    }

    public ArrayList chargeGuestCharges(String hotel, String room, String folio){
        ArrayList al = new ArrayList();
        String QUERY = "SELECT * FROM guest_charge" +
                       " WHERE nHotel = ? AND tRoomNumber = ? AND nFolio = ?";
        try{
            pstmt = con.prepareStatement(QUERY);
            pstmt.setByte(1,Byte.parseByte(hotel));
            pstmt.setString(2,room);
            pstmt.setInt(3,Integer.parseInt(folio));
            rs = pstmt.executeQuery();
            while(rs.next()){
                chargeArrayList(rs, al);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return al;
    }

  private void chargeArrayList(ResultSet rs, ArrayList al) {
      GuestCharge gch = new GuestCharge();
      try {
        gch.setHotel(rs.getByte(1));
        gch.setRoomNumber(rs.getString(2));
        gch.setFolio(rs.getInt(3));
        gch.setDateCharge(rs.getDate(4));
        gch.setAccount(rs.getInt(5));
        gch.setQuantity(rs.getShort(6));
        gch.setAmount(rs.getFloat(7));
        gch.setCashier(rs.getString(8));
      } catch(Exception e) {}

      al.add(gch);
  }

}