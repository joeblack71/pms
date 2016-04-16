package com.myco.central.accounting.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.accounting.model.RoomAccount;
import com.myco.central.commons.dao.GenericDao;
import com.myco.central.commons.exceptions.DaoException;

public interface RoomAccountDao extends GenericDao<RoomAccount, Long> {

	/**
	 * Retorna una lista con ls cuentas aperturadas en una habitacion  
	 */
	public List<Map<String, Object>> search(Long hotelId, Long customerId, Long billId) throws DaoException;
}