package com.myco.central.commons.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.model.City;

public interface CityDao extends GenericDao {

	public String insert(City city) throws DaoException;

	public boolean update(City city) throws DaoException;

	public City search(City filter) throws DaoException;

	public boolean delete(City city) throws DaoException;

	public List<Map<String, Object>> select(City filter) throws DaoException;

}