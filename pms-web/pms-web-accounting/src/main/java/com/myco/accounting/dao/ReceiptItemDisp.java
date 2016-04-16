
package dispatchers;

import java.sql.*;
import java.util.ArrayList;

import beans.*;

public class ReceiptItemDisp {

    private Connection  con = null;
    private ReceiptItem ri = null;

    public ReceiptItemDisp() { }

    public Connection getConnection() {
        return con;
    }
    public void setConnection(Connection con) {
        this.con = con;
    }

    public ReceiptItem getReceiptItem() {
        return ri;
    }
    public void setReceiptItem(ReceiptItem _ri) {
        this.ri = _ri;
    }

    public boolean validate() {
        boolean flag=false;
        String QUERY = "SELECT * FROM receipt_detail" +
                             " WHERE nHotelId ='" + ri.getHotelId() + "' AND" +
                             " nReceiptType ='"   + ri.getReceiptType() + "' AND" +
                             " nReceiptSerial ='" + ri.getReceiptSerial() + "' AND" +
                             " nCorrelative ='"   + ri.getCorrelative() + "'";
        //System.out.println(QUERY);
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            if ( rs.next() ) {
                ri.setChargeDate(rs.getString("dChargeDate"));
                ri.setItemId(rs.getInt("nItemId"));
                ri.setQuantity(rs.getShort("nQuantity"));
                ri.setPrice(rs.getDouble("nPrice"));
                ri.setTotalCharge(rs.getDouble("nTotalCharge"));
                ri.setStatus(rs.getString("tStatus"));
                ri.setOperatorInitials(rs.getString("tOperator"));
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insert() {
        boolean flag = false;
        String QUERY = "INSERT INTO" +
                             " receipt_detail(nHotelId," +
                             "nReceiptType,nReceiptSerial,nCorrelative,nItemId," +
                             "dChargeDate,nQuantity,nPrice,nTotalCharge," +
                             "tStatus,tOperator)" +
                             " VALUES( ?,?,?,?,?,?,?,?,?,?,? )";
        try {
            PreparedStatement pre = con.prepareStatement(QUERY);
            pre.setShort(1,ri.getHotelId());
            pre.setShort(2,ri.getReceiptType());
            pre.setShort(3,ri.getReceiptSerial());
            pre.setInt(4,ri.getCorrelative());
            pre.setInt(5,ri.getItemId());
            pre.setString(6,ri.getChargeDate());
            pre.setShort(7,ri.getQuantity());
            pre.setDouble(8,ri.getPrice());
            pre.setDouble(9,ri.getTotalCharge());
            pre.setString(10,ri.getStatus());
            pre.setString(11,ri.getOperatorInitials());
            System.out.println(pre);
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean update() {
        boolean flag = false;
        String QUERY = "UPDATE receipt_detail SET" +
                             " dChargeDate=?,nQuantity=?,nPrice=?,nTotalCharge=?," +
                             " tStatus=?,tOperator=?" +
                             " WHERE nHotelId=? AND" +
                             " nReceiptType=? AND nReceiptSerial=? AND nCorrelative=?" +
                             " nItemId=?";
        try {
            PreparedStatement pre = con.prepareStatement(QUERY);
            pre.setString(1,ri.getChargeDate());
            pre.setShort(2,ri.getQuantity());
            pre.setDouble(3,ri.getPrice());
            pre.setDouble(4,ri.getTotalCharge());
            pre.setString(5,ri.getStatus());
            pre.setString(6,ri.getOperatorInitials());
            pre.setShort(7,ri.getHotelId());
            pre.setShort(8,ri.getReceiptType());
            pre.setShort(9,ri.getReceiptSerial());
            pre.setInt(10,ri.getCorrelative());
            pre.setInt(11,ri.getItemId());
            System.out.println(pre);
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean correct() {
        boolean flag = false;
        try {
            String QUERY = "UPDATE receipt_detail SET tStatus = ?" +
                             " WHERE nHotelId=? AND" +
                             " nReceiptType=? AND nReceiptSerial=? AND nCorrelative=?" +
                             " AND nItemId=?";
            PreparedStatement pre = con.prepareStatement(QUERY);
            pre.setString(1,ri.getStatus());
            pre.setShort(2,ri.getHotelId());
            pre.setShort(3,ri.getReceiptType());
            pre.setShort(4,ri.getReceiptSerial());
            pre.setInt(5,ri.getCorrelative());
            pre.setInt(6,ri.getItemId());
            System.out.println(pre);
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delete() {
        boolean flag = false;
        try {
            String QUERY = "DELETE FROM receipt_detail" +
                             " WHERE nHotelId=? AND" +
                             " nReceiptType=? AND nReceiptSerial=? AND nCorrelative=?" +
                             " AND nItemId=?";
            PreparedStatement pre = con.prepareStatement(QUERY);
            pre.setShort(1,ri.getHotelId());
            pre.setShort(2,ri.getReceiptType());
            pre.setShort(3,ri.getReceiptSerial());
            pre.setInt(4,ri.getCorrelative());
            pre.setInt(5,ri.getItemId());
            System.out.println(pre);
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /* Detalle de cuentas asociadas a un comprobante*/
    public ArrayList getReceiptDetail(){
        ArrayList al = new ArrayList();
        String QUERY = "SELECT * FROM receipt_detail" +
                             " WHERE nHotelId =" + ri.getHotelId() + " AND" +
                             " nReceiptType =" + ri.getReceiptType() + " AND" +
                             " nReceiptSerial =" + ri.getReceiptSerial() + " AND" +
                             " nCorrelative =" + ri.getCorrelative();
        System.out.println(QUERY);
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while ( rs.next() ) {
                ReceiptItem rd = new ReceiptItem();
                rd.setChargeDate( rs.getString("dChargeDate") );
                rd.setQuantity(rs.getShort("nQuantity"));
                rd.setPrice(rs.getDouble("nPrice"));
                rd.setTotalCharge(rs.getDouble("nTotalCharge"));
                rd.setStatus( rs.getString("tStatus") );
                rd.setOperatorInitials( rs.getString("tOperator") );
                al.add(rd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return al;
    }

    /* Movimiento de cuenta en un determinado dia */
    public ArrayList getAccountDetailDay(){
        ArrayList al = new ArrayList();
        String QUERY = "SELECT * FROM receipt_detail" +
                             " WHERE nHotelId =" + ri.getHotelId() + " AND" +
                             " dChargeDate =" + ri.getChargeDate() + " AND" +
                             " nItemId =" + ri.getItemId();
        System.out.println(QUERY);
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            while ( rs.next() ) {
                ReceiptItem rd = new ReceiptItem();
                rd.setReceiptType( rs.getShort("nReceiptType") );
                rd.setReceiptSerial( rs.getShort("nReceiptSerial") );
                rd.setCorrelative( rs.getInt("nCorrelative") );
                rd.setQuantity( rs.getShort("nQuantity") );
                rd.setPrice( rs.getDouble("nPrice") );
                rd.setTotalCharge( rs.getDouble("nTotalCharge") );
                rd.setStatus( rs.getString("tStatus") );
                rd.setOperatorInitials( rs.getString("tOperator") );
                al.add(rd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return al;
    }
}