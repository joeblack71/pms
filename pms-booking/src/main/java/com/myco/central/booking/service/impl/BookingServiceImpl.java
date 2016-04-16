
package com.myco.central.booking.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.booking.dao.OccupationDao;
import com.myco.central.booking.dto.AvailabilityFilterDto;
import com.myco.central.booking.dto.OccupationByTypeDto;
import com.myco.central.booking.dto.OccupationDto;
import com.myco.central.booking.dto.PeriodFilterDto;
import com.myco.central.booking.exceptions.DaoException;
import com.myco.central.booking.service.BookingService;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.utils.DateUtils;
import com.myco.central.core.dao.RoomTypeDao;
import com.myco.central.model.RoomType;

public class BookingServiceImpl implements BookingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Autowired
	private OccupationDao occupationDao;
	@Autowired
	private RoomTypeDao roomTypeDao;

	@Override
	public List<OccupationByTypeDto> loadOccupationByType(OccupationDto filter)
			throws ServiceException {
		List<OccupationByTypeDto> list = null;

		try {
			list = occupationDao.getOccupationByType(filter);
		} catch (DaoException e){ 
			LOGGER.info("", e);
			throw new ServiceException();
		}

		return list;
	}

	@Override
	public List<OccupationByTypeDto> loadOccupationByStay(OccupationDto filter)
			throws ServiceException {
		List<OccupationByTypeDto> list = null;

		try {
			occupationDao.getOccupationByStay(filter);

		} catch (DaoException e) { 
			LOGGER.info("", e);
			throw new ServiceException();
		}

		return list;
	}

	@Override
	public List<Map<String, Object>> loadFlashStatus(OccupationDto filter) throws ServiceException {
		List<Map<String, Object>> list = null;

		try {
			list = occupationDao.getFlashStatus(filter);

		} catch (DaoException e) {
			LOGGER.info("", e);
			throw new ServiceException();
		}

		return list;
	}

	@Override
	public OccupationDto loadOccupation(PeriodFilterDto filter) throws ServiceException {
		OccupationDto occupation = new OccupationDto(filter.getHotelId());

		List<OccupationByTypeDto> list = null;
		List<RoomType> roomTypes = null;

		List<LocalDate> occupationDates = DateUtils.getAllDatesInPeriod(filter.getStartDate(), filter.getPeriod());
		// String[][] availability = null;

		int[] totalOccupationDays = new int[occupationDates.size() + 1];
		int[][] roomsOcc = null;

		LocalDate startDate = filter.getStartDate();
		Period period = filter.getPeriod();

		try {
			roomTypes = roomTypeDao.getAll();
			roomsOcc = new int[roomTypes.size()][occupationDates.size() + 1];
			// availability = new String[roomTypes.size() +
			// 2][occupationDates.size() + 2];

			OccupationDto occupationFilter = new OccupationDto(1L, 1L, 101L, LocalDate.now(), LocalDate.now());
			occupationFilter.setEndDate(DateUtils.addUnitsToDate(startDate, period));

			list = occupationDao.getOccupationByType(occupationFilter);

// Moved to AvailabilityView
//			chargeRoomsByDays(list, occupationDates, roomsOcc, totalOccupationDays, roomTypes);

			for ( int i=0; i < roomsOcc.length; i++ ) { // Totalize types
				for ( int j=0; j < roomsOcc[0].length - 1; j++ )
					roomsOcc[i][roomsOcc[0].length - 1] += roomsOcc[i][j];
			}

			for ( int i=0; i < totalOccupationDays.length - 1; i++ ) // Totalize days
				totalOccupationDays[totalOccupationDays.length - 1] += totalOccupationDays[i];

// Moved to AvailabilityView
//			availability = chargeAvailabilityMatrix(occupationDates, availability,
//					roomTypes, roomsOcc, totalOccupationDays);
		} catch (DaoException e) {
			LOGGER.info("", e);
			throw new ServiceException();
		}

		return occupation;
	}

	@Override
	public boolean checkRoomAvailability(AvailabilityFilterDto mapRequestToAvailabilityFilter) {
		// TODO Auto-generated method stub
		return false;
	}

}