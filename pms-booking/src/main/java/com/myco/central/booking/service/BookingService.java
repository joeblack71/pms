package com.myco.central.booking.service;

import java.util.List;
import java.util.Map;

import com.myco.central.booking.dto.AvailabilityFilterDto;
import com.myco.central.booking.dto.OccupationByTypeDto;
import com.myco.central.booking.dto.OccupationDto;
import com.myco.central.booking.dto.PeriodFilterDto;
import com.myco.central.commons.exceptions.ServiceException;

public interface BookingService {

	List<OccupationByTypeDto> loadOccupationByStay(OccupationDto filter) throws ServiceException;

	List<Map<String, Object>> loadFlashStatus(OccupationDto filter) throws ServiceException;

	OccupationDto loadOccupation(PeriodFilterDto filter) throws ServiceException;

	List<OccupationByTypeDto> loadOccupationByType(OccupationDto filter) throws ServiceException;

	boolean checkRoomAvailability(AvailabilityFilterDto mapRequestToAvailabilityFilter);

}