package com.myco.central.commons.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myco.central.commons.dao.CommonsDao;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.constants.CentralModuleConstants;
import com.myco.central.reservations.domain.HotelAccount;

public final class CommonsDaoJdbc extends GenericDaoJdbc implements CommonsDao {
	Log log = LogFactory.getLog(CommonsDaoJdbc.class);
	
	public List<Map<String, Object>> getHotels() throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> item = null;
		// TODO: traer desde bbdd
		String[][] hotels = {
				{"1","Unidad Hotelera 1"},
				{"2","Unidad Hotelera 2"}
		};
		
		for (int i=0; i < hotels.length; i++) {
			item = new HashMap<String, Object>();
			item.put("value",hotels[i][0]);
			item.put("label",hotels[i][1]);
			list.add(item);
		}
		
		return list;
	}

	public List<Map<String, Object>> getRoomTypes(String idHotel) throws Exception {
        //Connection conn = DAO.getConnection();
        Connection conn = ConProvider.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> item = null;

        final String SQL = "SELECT RTYPP_ID_ROOMTYPE, RTYPC_DESCRIPTION"
        				 +  " FROM HOTEL.CTRLT_ROOMTYPE"
        				 + " WHERE MAINP_ID_HOTEL = ?";
        short k = 1;

        try {
        	pstm = conn.prepareStatement(SQL);
        	pstm.setString(k++, idHotel);
        	rs = pstm.executeQuery();
            while ( rs.next() ) {
                item = new HashMap<String, Object>();
                item.put("value", rs.getString(1) );
                item.put("label", rs.getString(2) );
                list.add(item);
            }
        } catch (Exception e){
        	e.printStackTrace();
        } finally {
        	DAO.closeSQLObjects(rs, pstm, conn);
        }

        return list;
	}

	public List<Map<String, Object>> getRoomNumbers(String idHotel, String roomType)
	throws DaoException, SQLException {
        Connection conn = DAO.getConnection();
        //Connection conn = ConProvider.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> item = null;

        final String SQL = "SELECT nIdRoom, tRoomNumber"
        				 +  " FROM hotel.room"
        				 + " WHERE nIdHotel = ?"
                      	 +   " AND nIdRoomType = ?"
                      	 +   " AND tRoomStatus like 'V'";
        short k = 1;

        try {
        	pstm = conn.prepareStatement(SQL);
        	pstm.setString(k++, idHotel);
        	pstm.setString(k++, roomType);
        	rs = pstm.executeQuery();
            while ( rs.next() ) {
                item = new HashMap<String, Object>();
                item.put("value", rs.getString(1) );
                item.put("label", rs.getString(2) );
                list.add(item);
            }
        } catch (Exception e){
        	e.printStackTrace();
        } finally {
        	DAO.closeSQLObjects(rs, pstm, conn);
        }

        return list;
	}

	public List<Map<String, Object>> getPeriodTypes() throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> item = null;
		// TODO: traer desde bbdd
		String[][] roomTypes = {
				{String.valueOf(CentralModuleConstants.WEEKLY),"Weekly"},
				{String.valueOf(CentralModuleConstants.MONTHLY),"Monthly"},
				{String.valueOf(CentralModuleConstants.QUARTERLY),"Quarterly"},
				{String.valueOf(CentralModuleConstants.HALF_YEARLY),"Half_yearly"},
				{String.valueOf(CentralModuleConstants.YEARLY),"Yearly"},
		};
		
		for (int i=0; i < roomTypes.length; i++) {
			item = new HashMap<String, Object>();
			item.put("value",roomTypes[i][0]);
			item.put("label",roomTypes[i][1]);
			list.add(item);
		}
		
		return list;
	}

	public List<Map<String, Object>> getPaymentTypes(List<HotelAccount> paymentTypes) throws Exception {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> item = null;
		
		for (HotelAccount account: paymentTypes) {
			if (account.getAccountType().equals("P")) { //TODO crear constante
				item = new HashMap<String, Object>();
				item.put("value", account.getIdAccount());
				item.put("label", account.getDescription());
				list.add(item);
			}
		}
		
		return list;
	}
}
