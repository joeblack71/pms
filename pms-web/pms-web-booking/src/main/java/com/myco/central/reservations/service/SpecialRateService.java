package com.myco.central.reservations.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.GenericService;
import com.myco.central.reservations.dao.SpecialRateDao;
import com.myco.central.reservations.domain.SpecialRate;

public interface SpecialRateService extends GenericService {

	public void setSpecialRateDao(SpecialRateDao specialRateDao);

	public String insert(SpecialRate specialRate) throws ServiceException;

	public boolean update(SpecialRate specialRate) throws ServiceException;

	public SpecialRate search(SpecialRate filter) throws ServiceException;

	public boolean delete(SpecialRate specialRate) throws ServiceException;

	public List<Map<String, Object>> select(String idHotel, String pattern, String status)
	throws ServiceException;

	public void addRoomTypeRate(String idHotel, String roomType,
			String idRate) throws ServiceException;

}