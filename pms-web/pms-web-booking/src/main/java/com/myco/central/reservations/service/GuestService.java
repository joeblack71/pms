package com.myco.central.reservations.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.GenericService;
import com.myco.central.reservations.domain.Guest;

public interface GuestService extends GenericService {

	/* SPEC Definir si se debe grabar el id del cliente o un secuencial  
	 */
	public boolean insert(Guest guest) throws ServiceException;

	public boolean update(Guest guest) throws ServiceException;

	public boolean search(Guest guest) throws ServiceException;

	public boolean delete(Guest guest) throws ServiceException;

	public List<Guest> select(Map<String, Object> params) throws Exception;

	public Map<String, Guest> listGuestsInRoom(String idHotel,
			String idReservation) throws ServiceException;

}