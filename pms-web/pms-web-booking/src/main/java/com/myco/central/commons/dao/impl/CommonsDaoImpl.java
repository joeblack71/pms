package com.myco.central.commons.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.CommonsDao;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.reservations.domain.HotelAccount;

public class CommonsDaoImpl implements CommonsDao {

	public List<Map<String, Object>> getHotels() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map<String, Object>> getRoomTypes(String idHotel)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map<String, Object>> getRoomNumbers(String idHotel,
			String roomType) throws DaoException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map<String, Object>> getPeriodTypes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map<String, Object>> getPaymentTypes(
			List<HotelAccount> paymentTypes) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
