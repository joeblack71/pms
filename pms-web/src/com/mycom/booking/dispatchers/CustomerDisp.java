
package com.mycom.booking.dispatchers;

import java.sql.*;
import java.util.ArrayList;

import com.mycom.booking.beans.*;


public class CustomerDisp {

    private Connection con;
    private Customer cust;

    public CustomerDisp() {}

    public Connection getConnection() {
        return con;
    }
    public void setConnection(Connection con) {
        this.con = con;
    }

    public Customer getCustomer() {
        return cust;
    }
    public void setCustomer(Customer customer) {
        this.cust = customer;
    }

    public boolean validate() {
        boolean flag = false;
        String sql = "SELECT * FROM customer" +
                           " WHERE nHotelId = " + cust.getHotelId() + " AND" +
                                 " tDocumentNumber = " + cust.getDocumentNumber();
        //System.out.println(sql);
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            if ( rs.next() ) {
                cust.setLastname1(rs.getString("tLastName1"));
                cust.setLastname2(rs.getString("tLastName2"));
                cust.setFirstname(rs.getString("tFirstNames"));
                cust.setCustomerId(rs.getShort("nCustomerId"));
                //cust.setNationality(rs.getShort("nNationality"));
                cust.setAddress1(rs.getString("tAddress1"));
                cust.setAddress2(rs.getString("tAddress2"));
                cust.setDistrict(rs.getString("tDistrict"));
                cust.setCity(rs.getString("tCity"));
                //cust.setCountryId(rs.getShort("nCountryId"));
                cust.setZipCode(rs.getString("tZipCode"));
                cust.setPhone1(rs.getInt("tPhone1"));
                cust.setPhone2(rs.getInt("tPhone2"));
                cust.setEmail(rs.getString("tEmail"));
                cust.setSource(rs.getString("tSource"));
                cust.setContact(rs.getBoolean("bContact"));
                cust.setVipStatus(rs.getShort("nVipStatus"));
                cust.setDocumentType(rs.getShort("nDocumentType"));
                cust.setDocumentNumber(rs.getString("tDocumentNumber"));
                /*cust.setCreditCardCia(rs.getString("tCreditCardCo"));
                cust.setCreditCardNumber(rs.getString("nCreditCardNumber"));
                cust.setCreditCardExpiration(rs.getString("dCreditCardExpiration"));
                 */
                cust.setRequests(rs.getString("tRequests"));
                /*cust.setPreferredHotel(rs.getString("tEmail"));
                cust.setPreferredRoom(rs.getString("tEmail"));
                cust.setMaritalStatus(rs.getString("tEmail"));
                cust.setFutureReservation(rs.getString("tEmail"));
                 */
                cust.setMadeBy(rs.getString("tMadeBy"));
                cust.setMadeOn(rs.getDate("dMadeOn"));
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insert() {
        boolean flag = false;
        String sql = "INSERT INTO customer(" +
                           " nHotelId, nDocumentType, tDocumentNumber," +
                           " tLastName1, tLastName2, tFirstNames, nNationality," +
                           " tAddress1, tAddress2, tDistrict, tCity, nCountryId," +
                           " tPhone1, tPhone2, tEmail, tSource, bContact," +
                           " tRequests)" +
                           " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setShort(1,  cust.getHotelId() );
            pre.setShort(2,  cust.getDocumentType() );
            pre.setString(3, cust.getDocumentNumber() );
            pre.setString(4, cust.getLastname1() );
            pre.setString(5, cust.getLastname2() );
            pre.setString(6, cust.getFirstname() );
            pre.setShort(7, cust.getNationality() );
            pre.setString(8, cust.getAddress1() );
            pre.setString(9, cust.getAddress2() );
            pre.setString(10, cust.getDistrict() );
            pre.setString(11, cust.getCity() );
            pre.setShort(12, cust.getCountryId() );
            pre.setInt(13, cust.getPhone1() );
            pre.setInt(14, cust.getPhone2() );
            pre.setString(15, cust.getEmail() );
            pre.setString(16, cust.getSource() );
            pre.setBoolean(17, cust.getContact() );
            pre.setString(18, cust.getRequests() );
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
        String sql = "UPDATE customer SET" +
                           " tLastName1=?, tLastName2=?, tFirstNames=?, nNationality=?," +
                           " tAddress1=?, tAddress2=?, tDistrict=?, tCity=?," +
                           " nCountryId=?, tPhone1=?, tPhone2=?, tEmail=?," +
                           " nDocumentType=?, tSource=?, bContact=?, tRequests=?" +
                           " WHERE nHotelId=? AND tDocumentNumber=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, cust.getLastname1() );
            pre.setString(2, cust.getLastname2() );
            pre.setString(3, cust.getFirstname() );
            pre.setShort(4, cust.getNationality() );
            pre.setString(5, cust.getAddress1() );
            pre.setString(6, cust.getAddress2() );
            pre.setString(7, cust.getDistrict() );
            pre.setString(8, cust.getCity() );
            pre.setShort(9, cust.getCountryId() );
            pre.setInt(10, cust.getPhone1() );
            pre.setInt(11, cust.getPhone2() );
            pre.setString(12, cust.getEmail() );
            pre.setShort(13, cust.getDocumentType() );
            pre.setString(14, cust.getSource() );
            pre.setBoolean(15, cust.getContact() );
            pre.setString(16, cust.getRequests() );
            pre.setShort(17, cust.getHotelId() );
            pre.setString(18, cust.getDocumentNumber() );
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
        String sql = "DELETE FROM customer" +
                     " WHERE tDocumentType=? AND tDocumentNumber=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            //pre.setShort(1, cust.getDocumentType() );
            pre.setString(2, cust.getDocumentNumber() );
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList chargeAll(String hotel) {
        ResultSet rs = null;
        ArrayList list = new ArrayList();
        String sql = "SELECT * FROM  customer";
        try {
            rs = con.createStatement().executeQuery(sql);
            while ( rs.next() ) {
                Customer c = new Customer();
                c.setLastname1( rs.getString("tLastname1") );
                c.setFirstname( rs.getString("tFirstnames") );
                list.add(c);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public ResultSet chargeSome(String hotel, String pattern) {
        ResultSet rs = null;
        String sql = "SELECT * FROM  customer" +
                           " WHERE tLastName1 like '" + pattern + "%'";
        try {
            rs = con.createStatement().executeQuery(sql);
        } catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

}