package com.myco.central.reservations.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.GenericDao;
import com.myco.central.reservations.domain.SpecialRate;

public interface PeriodDao extends GenericDao {

	public void insert(SpecialRate specialRate) throws Exception;

	public void update(SpecialRate specialRate) throws Exception;

	public List<Map<String, Object>> getPeriodselect(String idHotel, String pattern)
		throws Exception;

	public SpecialRate getSpecialRate(String idHotel, String idSpecialRate) 
		throws Exception;

	public void remove(SpecialRate specialRate) throws Exception;

	public void addRoomTypeRate(String idHotel, String roomType, String idRate)
		throws Exception;

}