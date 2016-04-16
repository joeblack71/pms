/**
 *
 */
package com.myco.central.booking.service;

import com.myco.central.booking.model.Reservation;
import com.myco.central.commons.exceptions.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * @author Devel
 *
 */
public interface ReservationManager {

	/**
	 * Cancel reservation
	 *
	 * @param reservation
	 * @return cancellation code
	 * @throws ServiceException
	 */
	long cancelReservation(Reservation reservation) throws ServiceException;

	List<Map<String, Object>> listReservation(Reservation reservation) throws ServiceException;

	boolean saveReservation(Reservation reservation) throws ServiceException;

	List<Map<String, Object>> searchReservation(Reservation reservation) throws ServiceException;

	boolean updateReservation(Reservation reservation) throws ServiceException;

}
