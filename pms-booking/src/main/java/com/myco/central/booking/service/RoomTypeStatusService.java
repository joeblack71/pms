package com.myco.central.booking.service;

import java.util.List;

import com.myco.central.booking.dto.AvailabilityFilterDto;
import com.myco.central.booking.dto.FlashStatusDto;
import com.myco.central.booking.model.RoomTypeStatus;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.GenericService;

public interface RoomTypeStatusService extends GenericService<RoomTypeStatus> {

	FlashStatusDto flashStatus(RoomTypeStatus roomTypeStatus) throws ServiceException;

	void updateFlashStatus(FlashStatusDto bean) throws ServiceException;

	List<RoomTypeStatus> verifyAvailability(AvailabilityFilterDto filter) throws ServiceException;

}