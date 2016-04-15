package com.myco.central.commons.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.model.Country;

public interface CountryDao extends GenericDao {

	public String insert(Country country) throws DaoException;

	public boolean update(Country country) throws DaoException;

	public Country search(Country filter) throws DaoException;

	public boolean delete(Country country) throws DaoException;

	public List<Map<String, Object>> select(Country filter) throws DaoException;

}