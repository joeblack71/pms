package com.myco.central.reservations.dao;

import java.util.List;

import com.myco.central.commons.dao.GenericDao;
import com.myco.central.commons.exceptions.DaoException;

import com.myco.central.reservations.domain.Reservation;
import com.myco.central.reservations.web.vo.ReservationFilter;

public interface ReservationDao extends GenericDao {

	/** Insert a reservation 
	 * @throws DaoException TODO*/
	public String insert(Reservation resv) throws DaoException;

	/** Update a reservation 
	 * @throws DaoException TODO*/
	public boolean update(Reservation resv) throws DaoException;

	/** Get a reservation 
	 * @throws DaoException TODO*/
	public Reservation search(Reservation filter) throws DaoException;

	/** Delete a reservation 
	 * @throws DaoException TODO*/
	public boolean delete(Reservation resv) throws DaoException;

	public List<Reservation> select(Reservation filter) throws DaoException;

	public List<Reservation> select(ReservationFilter filter) throws DaoException;

	/** Decide what operation to do for table update 
	 * @throws DaoException TODO*/
	public void saveReservationInfo(Reservation resv) throws DaoException;

}