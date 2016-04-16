
package com.myco.central.booking.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myco.central.booking.dao.ReservationDao;
import com.myco.central.booking.exceptions.DaoException;
import com.myco.central.booking.model.Guest;
import com.myco.central.booking.model.Reservation;
import com.myco.central.booking.service.ReservationService;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.impl.GenericServiceImpl;
import com.myco.central.commons.utils.PMSConstants;

@Service
public class ReservationServiceImpl extends GenericServiceImpl<Reservation> implements ReservationService {
	private static final Log logger = LogFactory.getLog(ReservationServiceImpl.class);
	
	@Autowired
	private ReservationDao reservationDao;

	@Override
	public List<Guest> getReservationGuests(Connection conn,
			String idHotel,	String idReservation) throws ServiceException {
		List<Guest> list = new ArrayList<Guest>();

		try {
        	list = reservationDao.getReservationGuests(idHotel, idReservation);
        } catch (DaoException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void saveReservationInfo(Reservation res) throws ServiceException {
		try {
			reservationDao.saveReservationInfo(res);
		} catch (DaoException ex){
        	logger.info(ex);
			throw new ServiceException(PMSConstants.SERVICE_EXCEPTION_MESSAGE);
		}
	}

}
