package com.myco.central.commons.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.reservations.domain.HotelAccount;

public interface CommonsDao extends GenericDao {

	/**
	 * Devuelve la lista de hoteles pertencientes a la cadena
	 * @param idHotel
	 * @return
	 * @throws Exception TODO
	 */
	public List<Map<String, Object>> getHotels() throws Exception;

	public List<Map<String, Object>> getRoomTypes(String idHotel) throws Exception;

	public List<Map<String, Object>> getRoomNumbers(String idHotel,
			String roomType) throws DaoException, SQLException;

	public List<Map<String, Object>> getPeriodTypes() throws Exception;

	public List<Map<String, Object>> getPaymentTypes(
			List<HotelAccount> paymentTypes) throws Exception;

}