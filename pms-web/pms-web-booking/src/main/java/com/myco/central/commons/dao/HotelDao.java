package com.myco.central.commons.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.model.Hotel;

public interface HotelDao extends GenericDao {

	public String insert(Hotel hotel) throws DaoException;

	public String update(Hotel hotel) throws DaoException;

	public String search(Hotel filter) throws DaoException;

	public String delete(Hotel hotel) throws DaoException;

	public List<Map<String, Object>> select(Hotel filter) throws DaoException;

}
