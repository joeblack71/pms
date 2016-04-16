package com.myco.central.booking.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.booking.dao.RoomTypeStatusDao;
import com.myco.central.booking.dto.AvailabilityFilterDto;
import com.myco.central.booking.dto.FlashStatusDto;
import com.myco.central.booking.exceptions.DaoException;
import com.myco.central.booking.model.RoomTypeStatus;
import com.myco.central.booking.service.RoomTypeStatusService;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.impl.GenericServiceImpl;

public class RoomTypeStatusServiceImpl extends GenericServiceImpl<RoomTypeStatus> implements RoomTypeStatusService {
	private static final Log LOGGER = LogFactory.getLog(RoomTypeStatusService.class);

	@Autowired
	private RoomTypeStatusDao dao;

	@Override
	public void updateFlashStatus(FlashStatusDto bean) throws ServiceException {
		final int A_WEEK = 7;

		bean.setActualCol(bean.getActualCol() + A_WEEK);
	}

	@Override
	public List<RoomTypeStatus> verifyAvailability(AvailabilityFilterDto filter)
			throws ServiceException {
		List<RoomTypeStatus> availability = Collections.emptyList();
		try {
			availability = dao.verifyAvailability(filter);
		} catch (DaoException e) {
			LOGGER.info(e);
		}
		return availability;
	}

	@Override
	public FlashStatusDto flashStatus(RoomTypeStatus roomTypeStatus) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
