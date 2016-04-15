package com.myco.central.reservations.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.GenericDao;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.reservations.domain.Guest;

public interface GuestDao extends GenericDao {

	public boolean insert(Guest guest) throws DaoException;

	public boolean delete(Guest guest) throws DaoException;

	public List<Guest> select(Guest filter) throws DaoException;

	public Map<String, Guest> listGuestsInRoom(String idHotel,
			String idReservation) throws DaoException;

}