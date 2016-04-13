
package com.mycom.booking.dispatchers;

import java.sql.*;
import java.util.ArrayList;

import com.mycom.booking.beans.Company;
import com.mycom.booking.lists.Companies;


public class CompanyDisp {

    private Connection con;
    private Company cia;
    private Companies cias;

    public CompanyDisp() {}

    public void setConnection(Connection con) {
        this.con = con;
    }

    public void setCompany(Company cia) {
        this.cia = cia;
    }

    public void setCompanies(Companies cias){
        this.cias = cias;
    }

    public boolean validate() {
        boolean flag = false;
        String sql = "SELECT * FROM company" +
                           " WHERE nRUCNumber = " + cia.getRucNumber();
        //System.out.println(sql);
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            if ( rs.next() )
                flag = true;
        } catch (Exception e) {}
        return flag;
    }

    public boolean search() {
        boolean flag = false;
        String sql = "SELECT * FROM company" +
                           " WHERE nRUCNumber = " + cia.getRucNumber() + " OR" +
                                 " nCompanyId = " + cia.getCompanyId();
        System.out.println(sql);
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            if ( rs.next() ) {
                cia.setCompanyId( rs.getShort("nCompanyId") );
                cia.setFirmName( rs.getString("tFirmName") );
                cia.setCommercialName( rs.getString("tCommercialName") );
                cia.setRucNumber( rs.getString("nRUCNumber") );
                cia.setAddress( rs.getString("tAddress") );
                cia.setDistrict( rs.getString("nDistrictId") );
                cia.setCity( rs.getString("nCityId") );
                cia.setCountry( rs.getString("nCountryId") );
                cia.setZipCode( rs.getString("tZipCode") );
                cia.setPhone1( rs.getString("nPhone1") );
                cia.setPhone2( rs.getString("nPhone2") );
                cia.setSegment( rs.getString("nSegmentId") );
                cia.setSourceId( rs.getString("nSourceId") );
                cia.setSpecialRate( rs.getString("nSpecialRate") );
                cia.setContact( rs.getString("tContact") );
                cia.setEmailContact( rs.getString("tEmailContact") );
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean insert() {
        boolean flag = false;
        String sql = "INSERT INTO company(" +
                           " nCompanyId, tFirmName, tCommercialName," +
                           " nRUCNumber, tAddress, nDistrictId, nCityId," +
                           " nCountryId, tZipCode, nPhone1, nPhone2," +
                           " nSegmentId, nSourceId, tContact, nSpecialRate," +
                           " tEmailContact, tMadeBy)" +
                           " VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, cia.getFirmName() );
            pre.setString(2, cia.getCommercialName() );
            pre.setLong(3, cia.getRucNumber() );
            pre.setString(4, cia.getAddress() );
            pre.setShort(5, cia.getDistrict() );
            pre.setShort(6, cia.getCity() );
            pre.setInt(7, cia.getCountry() );
            pre.setString(8, cia.getZipCode() );
            pre.setInt(9, cia.getPhone1() );
            pre.setInt(10, cia.getPhone2() );
            pre.setShort(11, cia.getSegment() );
            pre.setShort(12, cia.getSourceId() );
            pre.setShort(13, cia.getSpecialRate() );
            pre.setString(14, cia.getContact() );
            pre.setString(15, cia.getEmailContact() );
            pre.setString(16, cia.getMadeBy() );
            //System.out.println(pre);
            pre.executeUpdate();
            setCompanyId(pre);
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    private void setCompanyId(PreparedStatement pre){
        int autoIncKeyFromApi = -1;
        try {
            ResultSet rs = pre.getGeneratedKeys();
            if ( rs.next() )
                autoIncKeyFromApi = rs.getInt(1);
            if ( autoIncKeyFromApi == -1 )
                 System.out.println("NO pudo recuperar llave generada");
            else cia.setCompanyId((short)autoIncKeyFromApi);
            rs.close();
            rs = null;
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
    
    public boolean update() {
        boolean flag = false;
        String sql = "UPDATE company SET" +
                           " tFirmName=?, tCommercialName=?," +
                           " tAddress=?, nDistrictId=?, nCityId=?, nCountryId=?," +
                           " tZipCode=?, nPhone1=?, nPhone2=?," +
                           " nSegmentId=?, nSourceId=?, nSpecialRate=?, tContact=?," +
                           " tEmailContact=?, tMadeBy=?" +
                           " WHERE nRUCNumber=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, cia.getFirmName() );
            pre.setString(2, cia.getCommercialName() );
            pre.setString(3, cia.getAddress() );
            pre.setShort(4, cia.getDistrict() );
            pre.setShort(5, cia.getCity() );
            pre.setInt(6, cia.getCountry() );
            pre.setString(7, cia.getZipCode() );
            pre.setInt(8, cia.getPhone1() );
            pre.setInt(9, cia.getPhone2() );
            //pre.setString(11, cia.getWebPage() );
            pre.setInt(10, cia.getSegment() );
            pre.setInt(11, cia.getSourceId() );
            pre.setShort(12, cia.getSpecialRate() );
            pre.setString(13, cia.getContact() );
            pre.setString(14, cia.getEmailContact() );
            pre.setString(15, cia.getMadeBy() );
            pre.setLong(16, cia.getRucNumber() );
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
        String sql = "DELETE FROM company" +
                           " WHERE nRUCNumber=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setLong(1, cia.getRucNumber() );
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public void chargeAll(String pattern) {
        String sql = "SELECT * FROM company";
        sql = ( pattern.equals("") ) ? sql :
              sql + " WHERE tFirmName like '" + pattern + "%'";
        System.out.println(sql);
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while ( rs.next() ) {
                Company c = new Company();
                c.setCompanyId( rs.getShort("nCompanyId") );
                c.setFirmName( rs.getString("tFirmName") );
                c.setCommercialName( rs.getString("tCommercialName") );
                c.setRucNumber( rs.getString("nRUCNumber") );
                c.setAddress( rs.getString("tAddress") );
                c.setDistrict( rs.getString("nDistrictId") );
                c.setCity( rs.getString("nCityId") );
                c.setCountry( rs.getString("nCountryId") );
                c.setZipCode( rs.getString("tZipCode") );
                c.setPhone1( rs.getString("nPhone1") );
                c.setPhone2( rs.getString("nPhone2") );
                c.setWebPage( rs.getString("tWEBPage") );
                c.setSegment( rs.getString("nSegmentId") );
                c.setSourceId( rs.getString("nSourceId") );
                c.setSpecialRate( rs.getString("nSpecialRate") );
                c.setContact( rs.getString("tContact") );
                c.setMadeBy( rs.getString("tMadeBy") );
                try {
                    c.setMadeOn( rs.getString("dMadeOn") );
                } catch (SQLException ex) { 
                    System.out.println( ex.getMessage() + "," + ex.getSQLState() ); }
                cias.add(c);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void chargeAll(String pattern, short hotelId, String roomType) {
        /*SELECT  nCompanyId, tFirmName, nRUCNumber,
                nSegmentId, nSourceId, nSpecialRate,
                nHighDowRate, nHighEowRate,
                nLowDowRate, nLowEowRate, tContact
                FROM company as c, special_rate as sr
                WHERE 	tFirmName like '%' AND
                        sr.nHotelId = 1 AND
                        sr.tRoomType = 'ES' AND
                        c.nSpecialRate = sr.nRateId;*/
        String qry = "SELECT nCompanyId, tFirmName, nRUCNumber, nSegmentId," +
                           " nSourceId, nSpecialRate, nHighDowRate, nHighEowRate," +
                           " nLowDowRate, nLowEowRate, tContact" +
                           " FROM company as c, special_rate as sr" +
                           " WHERE tFirmName like '" + pattern + "%' AND" +
                                 " sr.nHotelId = " + hotelId + " AND" +
                                 " sr.tRoomType = '" + roomType + "' AND" +
                                 " c.nSpecialRate = sr.nRateId";
        System.out.println(qry);
        try {
            ResultSet rs = con.createStatement().executeQuery(qry);
            while ( rs.next() ) {
                Company c = new Company();
                c.setCompanyId( rs.getShort(1) );
                c.setFirmName( rs.getString(2) );
                c.setRucNumber( rs.getString(3) );
                c.setSegment( rs.getString(4) );
                c.setSourceId( rs.getString(5) );
                c.setSpecialRate( rs.getString(6) );
                c.setHsDowRate( rs.getFloat(7) );
                c.setHsEowRate( rs.getFloat(8) );
                c.setLsDowRate( rs.getFloat(9) );
                c.setLsEowRate( rs.getFloat(10) );
                c.setContact( rs.getString(11) );
                cias.add(c);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}