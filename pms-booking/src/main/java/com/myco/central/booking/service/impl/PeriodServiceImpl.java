
package com.myco.central.booking.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.booking.dao.PeriodDao;
import com.myco.central.booking.dao.jdbc.AvailabilityDaoJdbcImpl;
import com.myco.central.booking.model.SpecialRate;
import com.myco.central.booking.service.PeriodService;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.impl.GenericServiceImpl;

public class PeriodServiceImpl extends GenericServiceImpl<SpecialRate> implements PeriodService {
	private static final Log logger = LogFactory.getLog(AvailabilityDaoJdbcImpl.class);

	@Autowired
	private PeriodDao periodDao;

	@Override
	public void addRoomTypeRate(Long hotelId, String roomType, Long rateId)
			throws ServiceException {
		try {
			periodDao.addRoomTypeRate(hotelId, roomType, rateId);
		} catch (DaoException e) {
			logger.info(e);
			throw new ServiceException();
		}
	}

	@Override
	public List<SpecialRate> getPeriodSelected(Long hotelId, String pattern)
			throws ServiceException {
		List<SpecialRate> list = new ArrayList<>();

		try {
			list = periodDao.getPeriodSelected(hotelId, pattern);
		} catch (DaoException e) {
			logger.info(e);
			throw new ServiceException();
		}

		return list;
	}

	@Override
	public List<String> getPeriodTypes() throws ServiceException {
		// TODO Auto-generated method stub
		return Collections.emptyList();
	}

	@Override
	public SpecialRate getSpecialRate(Long hotelId, Long specialRateId)
			throws ServiceException {
		SpecialRate sr = null;

		try {
			sr = periodDao.getSpecialRate(hotelId, specialRateId);
		} catch (DaoException e) {
			logger.info(e);
			throw new ServiceException();
		}

		return sr;
	}

}