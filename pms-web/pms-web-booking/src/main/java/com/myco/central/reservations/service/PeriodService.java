package com.myco.central.reservations.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.service.GenericService;
import com.myco.central.reservations.dao.PeriodDao;
import com.myco.central.reservations.domain.SpecialRate;

public interface PeriodService extends GenericService {

	public void insert(SpecialRate rate) throws Exception;

	public void update(SpecialRate rate) throws Exception;

	public SpecialRate getSpecialRate(String idHotel,
			String idSpecialRate) throws Exception;

	public void remove(SpecialRate specialRaet)
			throws Exception;

	public void setPeriodDao(PeriodDao periodDao);

	public List<Map<String, Object>> getPeriodselect(String idHotel, String pattern)
			throws Exception;

	public void addRoomTypeRate(String idHotel, String roomType,
			String idRate) throws Exception;

}