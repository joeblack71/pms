package com.myco.central.booking.dao;

import java.util.List;

import com.myco.central.booking.model.SpecialRate;
import com.myco.central.commons.dao.GenericDao;
import com.myco.central.commons.exceptions.DaoException;

public interface PeriodDao extends GenericDao<SpecialRate,Long> {

	void addRoomTypeRate(Long hotelId, String roomType, Long rateId) throws DaoException;

	List<SpecialRate> getPeriodSelected(Long hotelId, String pattern) throws DaoException;

	SpecialRate getSpecialRate(Long hotelId, Long specialRateId) throws DaoException;

	List<SpecialRate> search(SpecialRate specialRate);

}