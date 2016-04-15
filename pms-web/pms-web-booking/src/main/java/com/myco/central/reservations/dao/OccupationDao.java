package com.myco.central.reservations.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.GenericDao;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.reservations.domain.OccupationDay;

public interface OccupationDao extends GenericDao {

	/** 
	 * Charge a <code>List</code> object with occupation expected for
	 * each <b>room type</b> in an specific period.
	 * @param params TODO
	 * @param obd the list where occupation will be charged.
	 *
	 * TODO:
	 * 1. Crear metodos que entreguen ocupacion mensual, anual, etc.
	 * 2. Resume occupability for all hotels.
	 * 3. Manejar query de acuerdo al periodo solicitado (group by)
	 */
	public List<OccupationDay> chargeOccupationByType(Map<String, Object> params)
		throws Exception, SQLException;

	/**
	 * Charge a <code>List</code> object with occupation expected for
	 * each day requested by a reservation.
	 * @param params TODO
	 * @param obd the list where occupation will be charged.
	 */
	//TODO enviar parametros a traves de Availability
	public List<OccupationDay> chargeOccupationOnStay(Map<String, Object> params)
		throws Exception;

	public List<Map<String, Object>> getFlashStatus(Map<String, Object> params) 
		throws DaoException;
}