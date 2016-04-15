package com.myco.central.accounting.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.GenericDao;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.reservations.domain.HotelAccount;

public interface HotelAccountDao extends GenericDao {

	public String insert(HotelAccount hotelAccount) throws DaoException;

	public boolean update(HotelAccount hotelAccount) throws DaoException;

	public HotelAccount search(HotelAccount filter) throws DaoException;

	public boolean delete(HotelAccount hotelAccount) throws DaoException;

	public List<Map<String, Object>> select(HotelAccount filter) throws DaoException;

}
