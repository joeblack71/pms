package com.myco.central.reservations.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.GenericDao;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.reservations.domain.SpecialRate;

public interface SpecialRateDao extends GenericDao {

    public String insert(SpecialRate rate) throws DaoException;

	public boolean update(SpecialRate rate) throws DaoException;

	public SpecialRate search(SpecialRate filter) throws DaoException;

	public boolean delete(SpecialRate item) throws DaoException;

	public List<Map<String, Object>> select(String idHotel,	String description, String status)
	throws DaoException;

	public void addRoomTypeRate(String idHotel, String roomType,
			String idRate) throws DaoException;

}