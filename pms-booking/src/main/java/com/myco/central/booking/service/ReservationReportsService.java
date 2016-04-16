package com.myco.central.booking.service;

import com.myco.central.booking.model.Reservation;

import java.util.List;

public interface ReservationReportsService {

	List<Reservation> listReservations(String idHotel, String pattern, String status) throws Exception;

}
