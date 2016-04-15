
package com.myco.stay.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.LazyDynaBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//import com.myco.central.dao.IntRoomDAO;
//import com.myco.central.vo.Customer;

public class AccountChargeDAO {
    
    Log log = LogFactory.getLog(AccountChargeDAO.class);

    public AccountChargeDAO() {}

    //TODO habilitar busqueda por otros campos
    /**
     * Retorna una lista con los clientes registrados por este hotel.  
     */
    public List<DynaBean> getCustomerList(String idHotel,
	    String field, String pattern) throws Exception {
    	Connection conn = DAO.getConnection();
    	CallableStatement cstm = null;
        ResultSet rs = null;

        List<DynaBean> list = new ArrayList<DynaBean>();
        final String SQL = "{ call CMSP_CUSTOMER_LIST(?,?); }";
        short k = 1;

        try {
        	cstm = conn.prepareCall(SQL);
        	cstm.setString(k++, idHotel);
        	//cstm.setString(k++, field);
        	cstm.setString(k++, pattern);
            rs = cstm.executeQuery();
            while ( rs.next() ) {
                DynaBean c = new LazyDynaBean();
                k = 1;

                c.set("idCustomer", 	rs.getString(k++) );
                c.set("customerNames", 	rs.getString(k++) );
                c.set("birthdate", 		rs.getString(k++) );
                c.set("idNationality", 	rs.getString(k++) );
                c.set("desNationality", rs.getString(k++) );
                c.set("title", 			rs.getString(k++) );
                c.set("documentType",   rs.getString(k++) );
                c.set("documentNumber", rs.getString(k++) );
                c.set("address1", 		rs.getString(k++) );
                c.set("address2", 		rs.getString(k++) );
                c.set("district", 		rs.getString(k++) );
                c.set("city", 			rs.getString(k++) );
                c.set("idCountry", 		rs.getString(k++) );
                c.set("zipCode", 		rs.getString(k++) );
                c.set("phones", 		rs.getString(k++) );
                c.set("email", 			rs.getString(k++) );
                c.set("occupation", 	rs.getString(k++) );
                c.set("vipStatus", 		rs.getString(k++) );
                c.set("requests", 		rs.getString(k++) );
                c.set("hotelRegistration",
                						rs.getString(k++) );
                c.set("madeBy", 		rs.getString(k++) );
                // c.set("madeOn", 		rs.getString(k++) ); // TODO controlar fechas nulas

                list.add(c);
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        } finally {
        	DAO.closeSQLObjects(rs, cstm, conn);
        }
        return list;
    }

    /*public Customer getCustomer(String idCustomer, String documentNumber,
    		String idHotelRegistration) throws Exception {
        Connection conn = DAO.getConnection();
        CallableStatement cstm = null;
        ResultSet rs = null;
        
        Customer c = null;

        String sql = "{ call CMSP_CUSTOMER_GET(?,?,?) }";
        short k = 1;

        try {
        	cstm = conn.prepareCall(sql);
        	cstm.setString(k++, idCustomer);
        	cstm.setString(k++, documentNumber);
        	cstm.setString(k++, idHotelRegistration);
        	k = 1;

        	rs = cstm.executeQuery();
            if ( rs.next() ) {
            	c = new Customer();
            	c.setIdCustomer( rs.getString(k++) );

            	c.setLastname1( rs.getString(k++) );
                c.setLastname2( rs.getString(k++) );
                c.setFirstname( rs.getString(k++) );
                c.setBirthDate( rs.getString(k++) );
                c.setNationality( rs.getString(k++) );

                c.setTitle( rs.getString(k++) );
                c.setDocumentType( rs.getString(k++) );
                c.setDocumentNumber( rs.getString(k++) );

                c.setAddress1( rs.getString(k++) );
                c.setAddress2( rs.getString(k++) );
                c.setDistrict( rs.getString(k++) );
                c.setCity( rs.getString(k++) );
                c.setIdCountry( rs.getString(k++) );
                c.setZipCode( rs.getString(k++) );

                c.setPhone1( rs.getString(k++) );
                c.setPhone2( rs.getString(k++) );
                c.setMovilPhone( rs.getString(k++) );
                c.setEmail( rs.getString(k++) );

                c.setOccupation( rs.getString(k++) );
                c.setVipStatus( rs.getString(k++) );
                c.setRequests( rs.getString(k++) );

                c.setHotelRegistration( rs.getString(k++) );
                c.setMadeBy( rs.getString(k++) );
                c.setMadeOn( rs.getString(k++) );
                c.setStatus( rs.getString(k++) );

                /*cust.setPreferredHotel(rs.getString(k++));
                cust.setPreferredRoom(rs.getString(k++));
                cust.setMaritalStatus(rs.getString(k++));
                cust.setFutureReservation(rs.getString(k++));
                cust.setCreditCardCia( rs.getString(k++) );
                cust.setCreditCardNumber( rs.getString(k++) );
                cust.setCreditCardExpiration( rs.getString(k++) );*/
            /*}
        } catch(Exception e) {
        	e.printStackTrace();
        	throw new Exception();
        } finally {
            DAO.closeSQLObjects(rs, cstm, conn);
        }
        
        return c;
    }*/

    /*public void insert(Customer c) throws Exception {
        Connection conn = DAO.getConnection();
        //CallableStatement cstm = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        //String sql = "{ call CMSP_CUSTOMER_INSERT(?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
        final String SQL = " INSERT INTO customer("
						 + " tLastName1, tLastName2, tFirstNames, tBirthDate,"
						 + " nIdNationality, tTitle, nDocumentType,	tDocumentNumber,"
						 + " tAddress1, tAddress2, tDistrict, tCity, nIdCountry,"
						 + " tZipCode, nPhone1, nPhone2, nMovilPhone, tEmail,"
						 + " tOccupation, nVipStatus, tRequests, nHotelRegistration,"
						 + " tMadeBy, dMadeOn )"
					 	 + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP());";
        short k = 1;

        try {
            pstm = conn.prepareCall(SQL);
            //pstm.registerOutParameter(k++, java.sql.Types.INTEGER ); // for callable
            
            pstm.setString(k++, c.getLastname1() );
            pstm.setString(k++, c.getLastname2() );
            pstm.setString(k++, c.getFirstname() );
            pstm.setString(k++, c.getBirthDate() );

            pstm.setString(k++, c.getNationality() );
            pstm.setString(k++, c.getTitle() );
            pstm.setString(k++, c.getDocumentType() );
            pstm.setString(k++, c.getDocumentNumber() );

            pstm.setString(k++, c.getAddress1() );
            pstm.setString(k++, c.getAddress2() );
            pstm.setString(k++, c.getDistrict() );
            pstm.setString(k++, c.getCity() );
            pstm.setString(k++, c.getIdCountry() );

            pstm.setString(k++, c.getZipCode() );
            pstm.setString(k++, c.getPhone1() );
            pstm.setString(k++, c.getPhone2() );
            pstm.setString(k++, c.getMovilPhone() );
            pstm.setString(k++, c.getEmail() );

            pstm.setString(k++, c.getOccupation() );
            pstm.setString(k++, c.getVipStatus() );
            pstm.setString(k++, c.getRequests() );
            pstm.setString(k++, c.getHotelRegistration() );

            pstm.setString(k++, c.getMadeBy() );

            if ( pstm.executeUpdate() > 0 ) {
                rs = pstm.getGeneratedKeys();
                if ( rs.next() ) {
                	c.setIdCustomer( String.valueOf( rs.getInt(1) ) );
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        } finally {
        	DAO.closeSQLObjects(null, pstm, conn);
        }
    }*/

    /*public void update(Customer c) throws Exception {
        Connection conn = DAO.getConnection();
        final String SQL = //TODO include birth date
        	 "UPDATE customer SET"
		   + "       tLastName1=?, tLastName2=?, tFirstNames=?,"
		   + " 		 dBirthDate=str_to_date(?, get_format(DATE,'ISO') ), nIdNationality=?, nTitle=?,"
		   + " 		 nDocumentType=?, tDocumentNumber=?,"
		   + " 		 tAddress1=?, tAddress2=?, tDistrict=?, tCity=?, nIdCountry=?,"
		   + " 		 tZipCode=?, nPhone1=?, nPhone2=?, nMovilPhone=?, tEmail=?,"
		   + " 		 tOccupation=?, nVipStatus=?, tRequests=?,"
		   + " 		 tMadeBy=?, tStatus=?"
		   + " WHERE nIdCustomer=?";
        short k = 1;

        try {
            PreparedStatement cstm = conn.prepareStatement(SQL);
            cstm.setString(k++, c.getLastname1() );
            cstm.setString(k++, c.getLastname2() );
            cstm.setString(k++, c.getFirstname() );

            cstm.setString(k++, c.getBirthDate() );
            cstm.setString(k++, c.getNationality() );
            cstm.setString(k++, c.getTitle() );

            cstm.setString(k++, c.getDocumentType() );
            cstm.setString(k++, c.getDocumentNumber() );

            cstm.setString(k++, c.getAddress1() );
            cstm.setString(k++, c.getAddress2() );
            cstm.setString(k++, c.getDistrict() );
            cstm.setString(k++, c.getCity() );
            cstm.setString(k++, c.getIdCountry() );

            cstm.setString(k++, c.getZipCode() );
            cstm.setString(k++, c.getPhone1() );
            cstm.setString(k++, c.getPhone2() );
            cstm.setString(k++, c.getMovilPhone() );
            cstm.setString(k++, c.getEmail() );

            cstm.setString(k++, c.getOccupation() );
            cstm.setString(k++, c.getVipStatus() );
            cstm.setString(k++, c.getRequests() );

            cstm.setString(k++, c.getMadeBy() );
            cstm.setString(k++, c.getStatus() );

            cstm.setString(k++, c.getIdCustomer() );

            cstm.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        } finally {
        	DAO.closeSQLObjects(null, null, conn);
        }

    }*/

    public void delete(String hotelId, String customerId) throws Exception {
        Connection conn = DAO.getConnection();
        //Customer c = null;
        String sql = "DELETE FROM customer" +
                     " WHERE tDocumentType=? AND tDocumentNumber=?";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //pre.setShort(1, cust.getDocumentType() );
            //pre.setString(2, c.getDocumentNumber() );
            pre.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        } finally {
        	DAO.closeSQLObjects(null, null, conn);
        }
    }

    protected String getPattern(String field, String value) {
		String pattern = null;
		
		if ( field.equals("lastname") ) {
		    pattern = "tLastname1 like '" + value + "%'";
		}
		if ( field.equals("firstname") ) {
		    pattern = "tFirstnames like '" + value + "%'";
		}
		if ( field.equals("document") ) {
		    pattern = "tDocumentNumber like '" + value + "%'";
		}
		if ( field.equals("source") ) {
		    pattern = "tSource like '" + value + "%'";
		}
		if ( field.equals("nationality") ) {
		    pattern = "nNationality =" + value;
		}
		
		return pattern;			
    }

    /**
     * Retorna una lista con los criterios que pueden utilizarse
     * para la busqueda de clientes 
     * @return
     */
    public List<DynaBean> getPatternFields() {
		List<DynaBean> list = new ArrayList<DynaBean>();
		DynaBean item = null;
		
		item = new LazyDynaBean();
		item.set("value", "lastname");
		item.set("label", "Last Names");
		list.add(item);
		
		item = new LazyDynaBean();
		item.set("value", "firstname");
		item.set("label", "First Names");
		list.add(item);
		
		item = new LazyDynaBean();
		item.set("value", "document");
		item.set("label", "Document");
		list.add(item);
		
		item = new LazyDynaBean();
		item.set("value", "nationality");
		item.set("label", "Nationality");
		list.add(item);
		
		item = new LazyDynaBean();
		item.set("value", "source");
		item.set("label", "Source / Company");
		list.add(item);
		
		return list;
	
    }
    
}