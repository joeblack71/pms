package com.myco.central.reservations.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.reservations.domain.OccupationDay;

public interface OccupationService {

	public List<OccupationDay> chargeOccupationByType(Map<String, Object> params) 
		throws Exception;

	//TODO enviar parametros a traves de Availability
	public List<OccupationDay> chargeOccupationOnStay(Map<String, Object> params)
		throws Exception;

	/**
	 * Retorna una lista con informacion del estado de las habitaciones del hotel
	 * @param params TODO
	 * @return una lista de objetos Map<String, Object> con el estado de las habitaciones 
	 * @throws ServiceException
	 */
	public List<Map<String, Object>> flashStatus(Map<String, Object> params) 
		throws ServiceException;

	public String[][] getOccupation(Map<String, Object> params)
		throws ServiceException;

}