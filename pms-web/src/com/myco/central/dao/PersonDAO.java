
package com.myco.central.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.myco.central.vo.Person;

public class PersonDAO {

    private Connection con;
    private Person person;

    public PersonDAO() {}

    public Connection getConnection() {
        return con;
    }
    public void setConnection(Connection _con) {
        this.con = _con;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person _person) {
        this.person = _person;
    }

    public boolean validate() {
        boolean flag=false;
        try {
            String sql = "SELECT *" +
                               " FROM person" +
                               " WHERE tDocumentType ='" + person.getDocumentType() + "'" +
                               "       tDocumentNumber ='" + person.getDocumentNumber() + "'";
            ResultSet rs = con.createStatement().executeQuery(sql);
            if(rs.next()){
                person.setLastname1(rs.getString("tLastName1"));
                person.setLastname2(rs.getString("tLastName2"));
                person.setFirstname(rs.getString("tFirstNames"));
                person.setAddress1(rs.getString("tAddress1"));
                person.setAddress2(rs.getString("tAddress2"));
                person.setDistrict(rs.getString("tDistrict"));
                person.setCity(rs.getString("tCity"));
                //person.setCountryId(rs.getShort("tCountry"));
                person.setZipCode(rs.getString("tZipCode"));
                //person.setPhone1(rs.getShort("tPhone1"));
                //person.setPhone2(rs.getShort("tPhone2"));
                person.setEmail(rs.getString("tEmail"));
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insert() {
        boolean flag = false;
        try {
            String sql = "INSERT INTO" +
                               " person(tDocumentType,tDocumentNumber," +
                               "        tLastName1,tLastName2,tFirstNames," +
                               "        tAddress1,tAddress2,tDistrict,tCity,tCountry," +
                               "        tPhone1,tPhone2,tEmail)" +
                               " VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pre = con.prepareStatement(sql);
            //pre.setShort(1, person.getDocumentType() );
            pre.setString(2, person.getDocumentNumber() );
            pre.setString(3, person.getLastname1() );
            pre.setString(4, person.getLastname2() );
            pre.setString(5, person.getFirstname() );
            pre.setString(6, person.getAddress1() );
            pre.setString(7, person.getAddress2() );
            pre.setString(8, person.getDistrict() );
            pre.setString(9, person.getCity() );
            //pre.setShort(10, person.getCountryId() );
            //pre.setInt(11, person.getPhone1() );
            //pre.setInt(12, person.getPhone2() );
            pre.setString(13, person.getEmail() );
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean update() {
        boolean flag = false;
        try {
            String sql = "UPDATE person SET" +
                               " tLastName1=?,tLastName2=?,tFirstNames=?," +
                               " tAddress1=?,tAddress2=?,tDistrict=?,tCity=?,tCountry=?," +
                               " tPhone1=?, tPhone2=?, tEmail=?" +
                               " WHERE tDocumentType=? AND tDocumentNumber=?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, person.getLastname1() );
            pre.setString(2, person.getLastname2() );
            pre.setString(3, person.getFirstname() );
            pre.setString(4, person.getAddress1() );
            pre.setString(5, person.getAddress2() );
            pre.setString(6, person.getDistrict() );
            pre.setString(7, person.getCity() );
            //pre.setShort(8, person.getCountryId() );
            //pre.setInt(9, person.getPhone1() );
            //pre.setInt(10, person.getPhone2() );
            pre.setString(11, person.getEmail() );
            //pre.setShort(12, person.getDocumentType() );
            pre.setString(13, person.getDocumentNumber() );
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
            String sql = "DELETE FROM person" +
                         " WHERE tDocumentType=? AND tDocumentNumber=?";
            PreparedStatement pre = con.prepareStatement(sql);
            //pre.setShort(1, person.getDocumentType() );
            pre.setString(2, person.getDocumentNumber() );
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public ResultSet chargeAll(String hotel, String pattern) {
        ResultSet rs = null;
        String sql = "SELECT * FROM  person" +
                           " WHERE tLastName1 like '" + pattern + "%'";
        try {
            rs = con.createStatement().executeQuery(sql);
        } catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }

}