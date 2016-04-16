package com.myco.central.booking.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.booking.dto.OccupationByTypeDto;
import com.myco.central.booking.dto.OccupationDto;
import com.myco.central.booking.exceptions.DaoException;

/* TODO
* 1. Crear metodos que entreguen ocupacion mensual, anual, etc.
* 2. Resume occupability for all hotels.
* 3. Manejar query de acuerdo al periodo solicitado (group by)
*/
public interface OccupationDao {

	/**
	 * Charge a <code>List</code> object with occupation expected for
	 * each <b>room type</b> in an specific period.
	 * @param params TODO
	 * @param obd the list where occupation will be charged.
	 */
	List<OccupationByTypeDto> getOccupationByType(OccupationDto filter) throws DaoException;

	/**
	 * Retrieves the occupation expected for an specific period on a specific hotel 
	 * and an specific room type
	 * @param params
	 * @return
	 * @throws DaoException
	 */
	List<OccupationByTypeDto> getOccupationByStay(OccupationDto filter) throws DaoException;

	List<Map<String, Object>> getFlashStatus(OccupationDto filter) throws DaoException;

}