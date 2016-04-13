
package com.myco.central.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.myco.central.lists.Companies;
import com.myco.central.vo.Company;

public class CompanyDAO {

    public CompanyDAO() {}

    public Company getCompany() {
        Connection con = ConProvider.getConnection();
        ResultSet rs = null;
    	Company co = null;
        String sql = "SELECT * FROM company" +
                           " WHERE nRUCNumber = " + co.getRucNumber();

        try {
            rs = con.createStatement().executeQuery(sql);
            if ( rs.next() ) {
            	co = new Company();
	            co.setCompanyId( rs.getShort("nCompanyId") );
	            co.setFirmName( rs.getString("tFirmName") );
	            co.setCommercialName( rs.getString("tCommercialName") );
	            co.setRucNumber( rs.getString("nRUCNumber") );
	            co.setAddress( rs.getString("tAddress") );
	            co.setDistrict( rs.getString("nDistrictId") );
	            co.setCity( rs.getString("nCityId") );
	            co.setCountry( rs.getString("nCountryId") );
	            co.setZipCode( rs.getString("tZipCode") );
	            co.setPhone1( rs.getString("nPhone1") );
	            co.setPhone2( rs.getString("nPhone2") );
	            co.setSegment( rs.getString("nSegmentId") );
	            co.setSourceId( rs.getString("nSourceId") );
	            co.setSpecialRate( rs.getString("nSpecialRate") );
	            co.setContact( rs.getString("tContact") );
	            co.setEmailContact( rs.getString("tEmailContact") );
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        } finally {
        	//DAO.closeSQLObjects(rs,stmt,conn);
        }
        

        return co;
    }

    public boolean insert() {
        Connection con = ConProvider.getConnection();
    	Company co = null;
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
            pre.setString(1, co.getFirmName() );
            pre.setString(2, co.getCommercialName() );
            pre.setLong(3, co.getRucNumber() );
            pre.setString(4, co.getAddress() );
            pre.setShort(5, co.getDistrict() );
            pre.setShort(6, co.getCity() );
            pre.setInt(7, co.getCountry() );
            pre.setString(8, co.getZipCode() );
            pre.setInt(9, co.getPhone1() );
            pre.setInt(10, co.getPhone2() );
            pre.setShort(11, co.getSegment() );
            pre.setShort(12, co.getSourceId() );
            pre.setShort(13, co.getSpecialRate() );
            pre.setString(14, co.getContact() );
            pre.setString(15, co.getEmailContact() );
            pre.setString(16, co.getMadeBy() );
            pre.executeUpdate();
            setCompanyId(pre, co);
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    private void setCompanyId(PreparedStatement pre, Company co){
        int autoIncKeyFromApi = -1;
        try {
            ResultSet rs = pre.getGeneratedKeys();
            if ( rs.next() )
                autoIncKeyFromApi = rs.getInt(1);
            if ( autoIncKeyFromApi == -1 )
                 System.out.println("NO pudo recuperar llave generada");
            else co.setCompanyId((short)autoIncKeyFromApi);
            rs.close();
            rs = null;
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
    
    public boolean update() {
        Connection con = ConProvider.getConnection();
    	Company co = null;
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
            pre.setString(1, co.getFirmName() );
            pre.setString(2, co.getCommercialName() );
            pre.setString(3, co.getAddress() );
            pre.setShort(4, co.getDistrict() );
            pre.setShort(5, co.getCity() );
            pre.setInt(6, co.getCountry() );
            pre.setString(7, co.getZipCode() );
            pre.setInt(8, co.getPhone1() );
            pre.setInt(9, co.getPhone2() );
            //pre.setString(11, cia.getWebPage() );
            pre.setInt(10, co.getSegment() );
            pre.setInt(11, co.getSourceId() );
            pre.setShort(12, co.getSpecialRate() );
            pre.setString(13, co.getContact() );
            pre.setString(14, co.getEmailContact() );
            pre.setString(15, co.getMadeBy() );
            pre.setLong(16, co.getRucNumber() );
            //System.out.println(pre);
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delete() {
        Connection con = ConProvider.getConnection();
    	Company co = null;
        boolean flag = false;
        String sql = "DELETE FROM company" +
                           " WHERE nRUCNumber=?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setLong(1, co.getRucNumber() );
            pre.executeUpdate();
            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public Companies getCompanies(String pattern) {
        Connection con = ConProvider.getConnection();
        ResultSet rs = null;
    	Companies cias = new Companies();
        String sql = "SELECT * FROM company";
        sql = ( pattern == null || pattern.equals("") ) ? sql :
              sql + " WHERE tFirmName like '" + pattern + "%'";
        try {
            rs = con.createStatement().executeQuery(sql);
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
                    ex.printStackTrace();
                }
                cias.add(c);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return cias; 
    }

    public void getCompanies(String pattern, short hotelId, String roomType) {
        Connection con = ConProvider.getConnection();
        ResultSet rs = null;
    	//Company co = null;
    	Companies cias = null;
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
            rs = con.createStatement().executeQuery(qry);
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