/**
 * 
 */
package com.myco.central.reservations.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.reservations.domain.Reservation;

/**
 * @author Devel
 *
 */
public interface ReservationManager {

	public boolean saveReservation(Reservation reservation) throws ServiceException; 

	public boolean updateReservation(Reservation reservation) throws ServiceException; 

	/**
	 * Cancel reservation
	 * 
	 * @param reservation
	 * @return cancellation code
	 * @throws ServiceException
	 */
	public long cancelReservation(Reservation reservation) throws ServiceException; 

	public List<Map<String, Object>> searchReservation(Reservation reservation) throws ServiceException; 

	public List<Map<String, Object>> listReservation(Reservation reservation) throws ServiceException; 

}
