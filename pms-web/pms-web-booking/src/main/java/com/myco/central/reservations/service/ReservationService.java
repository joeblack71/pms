package com.myco.central.reservations.service;

import java.sql.Connection;
import java.util.List;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.GenericService;
import com.myco.central.reservations.domain.Guest;
import com.myco.central.reservations.domain.Reservation;
import com.myco.central.reservations.web.vo.ReservationFilter;

public interface ReservationService extends GenericService {

	public String insert(Reservation resv) throws ServiceException;

	public boolean update(Reservation resv) throws ServiceException;

	public Reservation search(Reservation filter) throws ServiceException;

	public boolean delete(Reservation resv) throws ServiceException;

	public List<Reservation> select(ReservationFilter filter) throws ServiceException;

	public void saveReservationInfo(Reservation res) throws ServiceException;

	public List<Guest> getReservationGuests(Connection conn,
			String idHotel, String idReservation) throws ServiceException;

}