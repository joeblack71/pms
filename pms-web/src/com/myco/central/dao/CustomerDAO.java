
package com.myco.central.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.myco.central.vo.Customer;

public class CustomerDAO {

    public CustomerDAO() {}

    public boolean validate() {
        Connection con = ConProvider.getConnection();
        Customer c = null;
        boolean flag = false;
        String sql = "SELECT * FROM customer" +
                           " WHERE nHotelId = " + c.getHotelId() + " AND" +
                                 " tDocumentNumber = " + c.getDocumentNumber();
        //System.out.println(sql);
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            if ( rs.next() ) {
            	c = new Customer();
                c.setLastname1(rs.getString("tLastName1"));
                c.setLastname2(rs.getString("tLastName2"));
                c.setFirstname(rs.getString("tFirstNames"));
                c.setCustomerId(rs.getShort("nCustomerId"));
                //cust.setNationality(rs.getShort("nNationality"));
                c.setAddress1(rs.getString("tAddress1"));
                c.setAddress2(rs.getString("tAddress2"));
                c.setDistrict(rs.getString("tDistrict"));
                c.setCity(rs.getString("tCity"));
                //cust.setCountryId(rs.getShort("nCountryId"));
                c.setZipCode(rs.getString("tZipCode"));
                c.setPhone1(rs.getInt("tPhone1"));
                c.setPhone2(rs.getInt("tPhone2"));
                c.setEmail(rs.getString("tEmail"));
                c.setSource(rs.getString("tSource"));
                c.setContact(rs.getBoolean("bContact"));
                c.setVipStatus(rs.getShort("nVipStatus"));
                c.setDocumentType(rs.getShort("nDocumentType"));
                c.setDocumentNumber(rs.getString("tDocumentNumber"));
                /*cust.setCreditCardCia(rs.getString("tCreditCardCo"));
                cust.setCreditCardNumber(rs.getString("nCreditCardNumber"));
                cust.setCreditCardExpiration(rs.getString("dCreditCardExpiration"));
                 */
                c.setRequests(rs.getString("tRequests"));
                /*cust.setPreferredHotel(rs.getString("tEmail"));
                cust.setPreferredRoom(rs.getString("tEmail"));
                cust.setMaritalStatus(rs.getString("tEmail"));
                cust.setFutureReservation(rs.getString("tEmail"));
                 */
                c.setMadeBy(rs.getString("tMadeBy"));
                c.setMadeOn(rs.getDate("dMadeOn"));
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insert(Customer c) {
        Connection con = ConProvider.getConnection();
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
            pre.setShort(1,  c.getHotelId() );
            pre.setShort(2,  c.getDocumentType() );
            pre.setString(3, c.getDocumentNumber() );
            pre.setString(4, c.getLastname1() );
            pre.setString(5, c.getLastname2() );
            pre.setString(6, c.getFirstname() );
            pre.setShort(7, c.getNationality() );
            pre.setString(8, c.getAddress1() );
            pre.setString(9, c.getAddress2() );
            pre.setString(10, c.getDistrict() );
            pre.setString(11, c.getCity() );
            pre.setShort(12, c.getCountryId() );
            pre.setInt(13, c.getPhone1() );
            pre.setInt(14, c.getPhone2() );
            pre.setString(15, c.getEmail() );
            pre.setString(16, c.getSource() );
            pre.setBoolean(17, c.getContact() );
            pre.setString(18, c.getRequests() );
            System.out.println(pre);
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean update(Customer c) {
        Connection con = ConProvider.getConnection();
        boolean flag = false;
        String sql = "UPDATE customer SET" +
                           " tLastName1=?, tLastName2=?, tFirstNames=?, nNationality=?," +
                           " tAddress1=?, tAddress2=?, tDistrict=?, tCity=?," +
                           " nCountryId=?, tPhone1=?, tPhone2=?, tEmail=?," +
                           " nDocumentType=?, tSource=?, bContact=?, tRequests=?" +
                           " WHERE nHotelId=? AND tDocumentNumber=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, c.getLastname1() );
            pre.setString(2, c.getLastname2() );
            pre.setString(3, c.getFirstname() );
            pre.setShort(4, c.getNationality() );
            pre.setString(5, c.getAddress1() );
            pre.setString(6, c.getAddress2() );
            pre.setString(7, c.getDistrict() );
            pre.setString(8, c.getCity() );
            pre.setShort(9, c.getCountryId() );
            pre.setInt(10, c.getPhone1() );
            pre.setInt(11, c.getPhone2() );
            pre.setString(12, c.getEmail() );
            pre.setShort(13, c.getDocumentType() );
            pre.setString(14, c.getSource() );
            pre.setBoolean(15, c.getContact() );
            pre.setString(16, c.getRequests() );
            pre.setShort(17, c.getHotelId() );
            pre.setString(18, c.getDocumentNumber() );
            System.out.println(pre);
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delete(String hotelId, String customerId) {
        Connection con = ConProvider.getConnection();
        Customer c = null;
        boolean flag = false;
        String sql = "DELETE FROM customer" +
                     " WHERE tDocumentType=? AND tDocumentNumber=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            //pre.setShort(1, cust.getDocumentType() );
            pre.setString(2, c.getDocumentNumber() );
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public ArrayList<Customer> getCustomerList(String hotel) {
    	Connection con = ConProvider.getConnection();
        ResultSet rs = null;
        ArrayList<Customer> list = new ArrayList<Customer>();
        String sql = "SELECT * FROM  customer WHERE nHotelId = " + hotel;
        
        try {
            rs = con.createStatement().executeQuery(sql);
            while ( rs.next() ) {
                Customer c = new Customer();
                c.setLastname1( rs.getString("tLastname1") );
                c.setFirstname( rs.getString("tFirstnames") );
                c.setFirstname(rs.getString("tFirstNames"));
                c.setCustomerId(rs.getShort("nCustomerId"));
                c.setNationality(rs.getShort("nNationality"));
                c.setPhone1(rs.getInt("tPhone1"));
                c.setSource(rs.getString("tSource"));
                c.setVipStatus(rs.getShort("nVipStatus"));
                c.setDocumentType(rs.getShort("nDocumentType"));
                c.setDocumentNumber(rs.getString("tDocumentNumber"));
                list.add(c);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList chargeAll(String hotel) {
        Connection con = ConProvider.getConnection();
        ResultSet rs = null;

        Customer c = new Customer();
        ArrayList list = new ArrayList();
        String sql = "SELECT * FROM  customer";
        try {
            rs = con.createStatement().executeQuery(sql);
            while ( rs.next() ) {
                c = new Customer();
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
        Connection con = ConProvider.getConnection();
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