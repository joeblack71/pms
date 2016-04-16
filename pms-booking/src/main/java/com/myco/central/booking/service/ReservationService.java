package com.myco.central.booking.service;

import java.sql.Connection;
import java.util.List;

import com.myco.central.booking.model.Guest;
import com.myco.central.booking.model.Reservation;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.GenericService;

public interface ReservationService extends GenericService<Reservation> {

	List<Guest> getReservationGuests(Connection conn, String idHotel, String idReservation) throws ServiceException;

	void saveReservationInfo(Reservation res) throws ServiceException;
}