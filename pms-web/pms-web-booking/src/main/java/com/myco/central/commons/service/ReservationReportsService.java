package com.myco.central.commons.service;

import java.util.List;

import com.myco.central.reservations.domain.Reservation;

public interface ReservationReportsService {

	public List<Reservation> listReservations(String idHotel, String pattern, String status) throws Exception;

}
