/**
 * 
 */
package com.myco.central.reservations.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.reservations.domain.Reservation;
import com.myco.central.reservations.service.ReservationManager;
import com.myco.central.reservations.service.ReservationService;

/**
 * @author Devel
 *
 */
@Service
public class ReservationManagerImpl implements ReservationManager {
	
	private ReservationService reservationService;

	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	/* (non-Javadoc)
	 * @see com.myco.central.reservations.service.ReservationManager#saveReservation(com.myco.central.model.Reservation)
	 */
	public boolean saveReservation(Reservation reservation)
			throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.myco.central.reservations.service.ReservationManager#updateReservation(com.myco.central.model.Reservation)
	 */
	public boolean updateReservation(Reservation reservation)
			throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.myco.central.reservations.service.ReservationManager#cancelReservation(com.myco.central.model.Reservation)
	 */
	public long cancelReservation(Reservation reservation)
			throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.myco.central.reservations.service.ReservationManager#searchReservation(com.myco.central.model.Reservation)
	 */
	public List<Map<String, Object>> searchReservation(Reservation reservation)
			throws ServiceException {
		
		reservationService.search(null);
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.myco.central.reservations.service.ReservationManager#listReservation(com.myco.central.model.Reservation)
	 */
	public List<Map<String, Object>> listReservation(Reservation reservation)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
