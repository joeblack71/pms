package com.myco.central.accounting.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.GenericDao;

public interface RoomAccountDao extends GenericDao {

	/**
	 * Retorna una lista con ls cuentas aperturadas en una habitacion  
	 */
	public List<Map<String, Object>> select(String idHotel,
			String idCustomer, String idBill) throws Exception;

}