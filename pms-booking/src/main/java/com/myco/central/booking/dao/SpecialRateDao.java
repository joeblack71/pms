package com.myco.central.booking.dao;

import java.util.List;

import com.myco.central.booking.exceptions.DaoException;
import com.myco.central.booking.model.SpecialRate;
import com.myco.central.commons.dao.GenericDao;

public interface SpecialRateDao extends GenericDao<SpecialRate,Long>{

	void addRoomTypeRate(Long hotelId, String roomType, Long rateId) throws DaoException;

	List<SpecialRate> search(Long hotelId, String description, String status) throws DaoException;
}