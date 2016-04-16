package com.myco.central.booking.dao;

import java.util.List;

import com.myco.central.booking.exceptions.DaoException;
import com.myco.central.booking.model.Guest;
import com.myco.central.booking.model.Reservation;
import com.myco.central.commons.dao.GenericDao;

public interface ReservationDao extends GenericDao<Reservation,Long> {

	void saveReservationInfo(Reservation resv) throws DaoException;

	List<Guest> getReservationGuests(String idHotel, String idReservation) throws DaoException;
}