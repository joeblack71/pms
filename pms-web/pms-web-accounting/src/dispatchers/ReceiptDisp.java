
package dispatchers;

import java.sql.*;
import java.util.ArrayList;

import beans.*;

public class ReceiptDisp {

    private Connection con = null;
    private Receipt    rec = null;

    private String SALE_RECEIPT = "receipt", PURCHASE_RECEIPT = "purchase";
    private String tableName  = null, entityDoc=null, entityName=null,
                   serviceRate = "", prepareValue = "";

    public ReceiptDisp() { }

    public Connection getConnection() {
        return con;
    }
    public void setConnection(Connection con) {
        this.con = con;
    }

    public Receipt getReceipt() {
        return rec;
    }
    public void setReceipt(Receipt _rec) {
        this.rec = _rec;
    }

    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
        if ( tableName.equals(SALE_RECEIPT) ) {
            entityDoc  = "tCustomerDoc";
            entityName = "tCustomerName";
        } else {
            entityDoc    = "nProviderRUC";
            entityName   = "tProviderName";
            serviceRate  = ", nServiceRate";
            prepareValue = ",?";
        }
    }

    public boolean validate() {
        boolean flag=false;
        String QUERY = "SELECT * FROM " + tableName +
                             " WHERE nHotelId ='" + rec.getHotelId()       + "' AND" +
                             " nReceiptType ='"   + rec.getReceiptType()   + "' AND" +
                             " nReceiptSerial ='" + rec.getReceiptSerial() + "' AND" +
                             " nCorrelative ='"   + rec.getCorrelative()   + "'";
        //System.out.println(QUERY);
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            if ( rs.next() ) {
                try {
                    rec.setIssueDate(rs.getDate("dIssueDate"));
                    rec.setPaymentDate(rs.getDate("dPaymentDate"));
                } catch (SQLException e) {}
                rec.setEntityId(rs.getString(entityDoc));
                rec.setEntityName(rs.getString(entityName));
                rec.setNet(rs.getDouble("nNet"));
                rec.setTax1(rs.getDouble("nTax1"));
                rec.setService(rs.getDouble("nService"));
                rec.setReceiptTotal(rs.getDouble("nReceiptTotal"));
                rec.setExempt(rs.getBoolean("bExempt"));
                rec.setApplyService(rs.getBoolean("bApplyService"));
                if ( tableName.equals(PURCHASE_RECEIPT) ) {
                    rec.setServicePercent(rs.getDouble("nServiceRate"));
                }
                rec.setPaymentType(rs.getShort("nPaymentType"));
                rec.setMoney(rs.getString("tMoney"));
                rec.setExchange(rs.getDouble("nExchangeRate"));
                rec.setStatus(rs.getString("tStatus"));
                rec.setMadeBy(rs.getString("tMadeBy"));
                rec.setUpdatedBy(rs.getString("tUpdatedBy"));
                try {
                    rec.setMadeOn(rs.getString("dMadeOn"));
                    rec.setUpdatedOn(rs.getString("dUpdatedOn"));
                } catch (SQLException e) {}
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insert() {
        boolean flag = false;

        String QUERY = "INSERT INTO " + tableName + 
                             "(nHotelId, nReceiptType, nReceiptSerial, nCorrelative," +
                             " dissueDate, dPaymentDate, " + entityDoc + ", " + entityName + "," +
                             " nNet, bExempt, nTax1, bApplyService, nService, " +
                             " nReceiptTotal, nPaymentType, tMoney, nExchangeRate," +
                             " tMadeBy, dMadeOn, tUpdatedBy, dUpdatedOn, tStatus" + serviceRate + ")" +
                             " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW(),?,NOW(),?" + prepareValue + ")";
        try {
            PreparedStatement pre = con.prepareStatement(QUERY);
            pre.setShort(1,rec.getHotelId());
            pre.setShort(2,rec.getReceiptType());
            pre.setShort(3,rec.getReceiptSerial());
            pre.setInt(4,rec.getCorrelative());
            pre.setDate(5,rec.getIssueDate());
            pre.setDate(6,rec.getPaymentDate());
            pre.setString(7,rec.getEntityId());
            pre.setString(8,rec.getEntityName());
            pre.setDouble(9,rec.getNet());
            pre.setBoolean(10,rec.isExempt());
            pre.setDouble(11,rec.getTax1());
            pre.setBoolean(12,rec.isApplyService());
            pre.setDouble(13,rec.getService());
            pre.setDouble(14,rec.getReceiptTotal());
            pre.setShort(15,rec.getPaymentType());
            pre.setString(16,rec.getMoney());
            pre.setDouble(17,rec.getExchange());
            pre.setString(18,rec.getMadeBy());
            //pre.setString(19,rec.getMadeOn());
            pre.setString(19,rec.getUpdatedBy());
            //pre.setString(20,rec.getUpdatedOn());
            pre.setString(20,rec.getStatus());
            if ( tableName.equals(PURCHASE_RECEIPT) )
                pre.setDouble(21,rec.getServicePercent());
            //System.out.println(pre);
            pre.executeUpdate();
            flag = true;
        } catch (Exception e)    { e.printStackTrace(); }
        return flag;
    }

    public boolean update() {
        boolean flag = false;
        String PURCHASE_FIELD = ( tableName.equals(PURCHASE_RECEIPT) ) ? ", nServiceRate=?" : "";
        String QUERY = "UPDATE "  + tableName + " SET " +
                             " dIssueDate=?, dPaymentDate=?," + entityDoc + "=?," +
                               entityName + "=?, nNet=round(?,2), bExempt=?, nTax1=round(?,2)," +
                             " bApplyService=?, nService=round(?,2), nReceiptTotal=round(?,2)," +
                             " nPaymentType=?, tMoney=?, nExchangeRate=?," +
                             " tUpdatedBy=?, dUpdatedOn=NOW(), tStatus=?" + PURCHASE_FIELD +
                             " WHERE nHotelId=? AND" +
                                   " nReceiptType=? AND nReceiptSerial=? AND nCorrelative=?";
        try {
            PreparedStatement pre = con.prepareStatement(QUERY);
            pre.setDate(1,rec.getIssueDate());
            pre.setDate(2,rec.getPaymentDate());
            pre.setString(3,rec.getEntityId());
            pre.setString(4,rec.getEntityName());
            pre.setDouble(5,rec.getNet());
            pre.setBoolean(6,rec.isExempt());
            pre.setDouble(7,rec.getTax1());
            pre.setBoolean(8,rec.isApplyService());
            pre.setDouble(9,rec.getService());
            pre.setDouble(10,rec.getReceiptTotal());
            pre.setShort(11,rec.getPaymentType());
            pre.setString(12,rec.getMoney());
            pre.setDouble(13,rec.getExchange());
            pre.setString(14,rec.getUpdatedBy());
            pre.setString(15,rec.getStatus());
            if ( tableName.equals(PURCHASE_RECEIPT) ) {
                pre.setDouble(16,rec.getServicePercent()); // Aditional field
                pre.setShort(17,rec.getHotelId());
                pre.setShort(18,rec.getReceiptType());
                pre.setShort(19,rec.getReceiptSerial());
                pre.setInt(20,rec.getCorrelative());
            } else {
                pre.setShort(16,rec.getHotelId());
                pre.setShort(17,rec.getReceiptType());
                pre.setShort(18,rec.getReceiptSerial());
                pre.setInt(19,rec.getCorrelative());
            }
            System.out.println(pre);
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean cancel() {
        boolean flag = false;
        try {
            String QUERY = "UPDATE " + tableName + " SET tStatus = '*'" +
                             " WHERE nHotelId=? AND" +
                             " nReceiptType=? AND nReceiptSerial=? AND nCorrelative=?";
            PreparedStatement pre = con.prepareStatement(QUERY);
            pre.setShort(1,rec.getHotelId());
            pre.setShort(2,rec.getReceiptType());
            pre.setShort(3,rec.getReceiptSerial());
            pre.setInt(4,rec.getCorrelative());
            //System.out.println(pre);
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
            String QUERY = "DELETE FROM " + tableName +
                             " WHERE nHotelId=? AND" +
                             " nReceiptType=? AND nReceiptSerial=? AND nCorrelative=?";
            PreparedStatement pre = con.prepareStatement(QUERY);
            pre.setShort(1,rec.getHotelId());
            pre.setShort(2,rec.getReceiptType());
            pre.setShort(3,rec.getReceiptSerial());
            pre.setInt(4,rec.getCorrelative());
            //System.out.println(pre);
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

}