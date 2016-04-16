package com.myco.central.booking.service;

import java.util.List;

import com.myco.central.booking.model.SpecialRate;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.GenericService;

public interface PeriodService extends GenericService<SpecialRate> {

	void addRoomTypeRate(Long hotelId, String roomType, Long rateId) throws ServiceException;

	List<SpecialRate> getPeriodSelected(Long hotelId, String pattern) throws ServiceException;

	List<String> getPeriodTypes() throws ServiceException;

	SpecialRate getSpecialRate(Long hotelId, Long specialRateId) throws ServiceException;

}