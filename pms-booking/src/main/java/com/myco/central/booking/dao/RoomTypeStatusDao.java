package com.myco.central.booking.dao;

import java.util.List;

import com.myco.central.booking.dto.AvailabilityFilterDto;
import com.myco.central.booking.exceptions.DaoException;
import com.myco.central.booking.model.RoomTypeStatus;
import com.myco.central.commons.dao.GenericDao;

public interface RoomTypeStatusDao extends GenericDao<RoomTypeStatus,Long> {

	List<RoomTypeStatus> verifyAvailability(AvailabilityFilterDto filter) throws DaoException;
}