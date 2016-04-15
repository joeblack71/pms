
package dispatchers;

import java.sql.*;
import java.util.ArrayList;

import beans.*;

public class BankTransactionDisp {

    private Connection  con;
    private BankTransaction bt;

    public BankTransactionDisp() {
    }

    public void setConnection(Connection con) {
        this.con = con;
    }

    public BankTransaction getBankTransaction() {
        return bt;
    }
    public void setBankTransaction(BankTransaction bt) {
        this.bt = bt;
    }

    public boolean validate() {
        boolean flag=false;
        String QUERY = "SELECT * FROM transaction" +
                             " WHERE nBankId = " + bt.getBankId() + " AND" +
                             " nAccountNumber = " + bt.getAccountNumber() + " AND" +
                             " nTransactionNumber = " + bt.getTransactionNumber();
        System.out.println(QUERY);
        try {
            ResultSet rs = con.createStatement().executeQuery(QUERY);
            if ( rs.next() ) {
                bt.setTransactionDate( rs.getString("dTransactionDate") );
                bt.setTransactionType( rs.getString("tTransactionType") );
                bt.setTransactionWay( rs.getShort("nTransactionWay") );
                bt.setDocumentNumber( rs.getInt("nDocumentNumber") );
                bt.setTransactionAmount(rs.getDouble("nTransactionAmount") );
                bt.setITFTransaction(rs.getDouble("nITFTransaction") );
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insert() {
        boolean flag = false;
        String QUERY = "INSERT INTO transaction" +
                             " ( nBankId, nAccountNumber, nTransactionNumber," +
                             " dTransactionDate, tTransactionType, nTransactionWay," +
                             " nDocumentNumber, nTransactionAmount, nITFTransaction )" +
                             " VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(QUERY);
            pstmt.setShort(1, bt.getBankId() );
            pstmt.setLong(2, bt.getAccountNumber() );
            pstmt.setInt(3, bt.getTransactionNumber() );
            pstmt.setString(4, bt.getTransactionDate() );
            pstmt.setString(5, bt.getTransactionType() );
            pstmt.setShort(6, bt.getTransactionWay() );
            pstmt.setInt(7, bt.getDocumentNumber() );
            pstmt.setDouble(8, bt.getTransactionAmount() );
            pstmt.setDouble(9, bt.getITFTransaction() );
            System.out.println(pstmt);
            pstmt.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean update() {
        boolean flag = false;
        String QUERY = "UPDATE transaction SET" +
                             " dTransactionDate = ?,tTransactionType = ?," +
                             " nTransactionWay = ?, nDocumentNumber = ?," +
                             " nTransactionAmount = ?, nITFTransaction = ?" +
                             " WHERE nBankId = ? AND nAccountNumber = ? AND " +
                                   " nTransactionNumber = ?";
        try {
            PreparedStatement pstmt = con.prepareStatement(QUERY);
            pstmt.setString(1, bt.getTransactionDate() );
            pstmt.setString(2, bt.getTransactionType() );
            pstmt.setShort(3, bt.getTransactionWay() );
            pstmt.setInt(4, bt.getDocumentNumber() );
            pstmt.setDouble(5, bt.getTransactionAmount() );
            pstmt.setDouble(6, bt.getITFTransaction() );
            pstmt.setShort(7, bt.getBankId() );
            pstmt.setLong(8, bt.getAccountNumber() );
            pstmt.setInt(9, bt.getTransactionNumber() );
            //System.out.println(pstmt);
            pstmt.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delete() {
        boolean flag = false;
        try {
            String QUERY = "DELETE FROM transaction" +
                                 " WHERE nBankId = ? AND nAccountNumber = ? AND " +
                                       " nTransactionnumber = ?";
            PreparedStatement pstmt = con.prepareStatement(QUERY);
            pstmt.setShort(1, bt.getBankId() );
            pstmt.setLong(2, bt.getAccountNumber() );
            pstmt.setInt(3, bt.getTransactionNumber() );
            pstmt.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

}