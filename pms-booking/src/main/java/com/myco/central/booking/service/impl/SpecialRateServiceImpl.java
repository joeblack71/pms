
package com.myco.central.booking.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.booking.dao.SpecialRateDao;
import com.myco.central.booking.exceptions.DaoException;
import com.myco.central.booking.model.SpecialRate;
import com.myco.central.booking.service.SpecialRateService;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.impl.GenericServiceImpl;

public class SpecialRateServiceImpl extends GenericServiceImpl<SpecialRate> implements SpecialRateService {
	private static final Log LOGGER = LogFactory.getLog(SpecialRateServiceImpl.class);

	@Autowired
	private SpecialRateDao dao;

	@Override
	public void addRoomTypeRate(Long hotelId, String roomType, Long rateId)
			throws ServiceException {

		try {
			dao.addRoomTypeRate(hotelId, roomType, rateId);
		} catch (DaoException e) {
			LOGGER.info(String.format("%s", rateId), e);
			throw new ServiceException();
		}

	}

}