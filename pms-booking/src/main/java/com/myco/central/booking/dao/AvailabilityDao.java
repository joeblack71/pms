package com.myco.central.booking.dao;

import com.myco.central.booking.dto.AvailabilityFilterDto;
import com.myco.central.booking.dto.OccupationByTypeDto;
import com.myco.central.booking.exceptions.DaoException;

import java.util.List;

public interface AvailabilityDao {

	List<OccupationByTypeDto> getOccupationByType(AvailabilityFilterDto filter) throws DaoException;

	List<OccupationByTypeDto> getOccupationByRoom(AvailabilityFilterDto filter) throws DaoException;

	List<OccupationByTypeDto> getOccupationOnStay(AvailabilityFilterDto filter) throws DaoException;

}