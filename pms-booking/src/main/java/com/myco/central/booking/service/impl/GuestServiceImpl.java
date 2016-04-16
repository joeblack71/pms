
package com.myco.central.booking.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myco.central.booking.model.Guest;
import com.myco.central.booking.service.GuestService;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.impl.GenericServiceImpl;

public class GuestServiceImpl extends GenericServiceImpl<Guest> implements GuestService {
	private static final Log logger = LogFactory.getLog(GuestServiceImpl.class);

	@Override
	public List<Guest> getGuestsInRoom(Long hotelId, Long reservationId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}