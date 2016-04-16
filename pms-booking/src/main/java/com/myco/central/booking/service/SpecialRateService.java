package com.myco.central.booking.service;

import com.myco.central.booking.model.SpecialRate;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.GenericService;

public interface SpecialRateService extends GenericService<SpecialRate> {

	void addRoomTypeRate(Long hotelId, String roomType, Long rateId) throws ServiceException;
}