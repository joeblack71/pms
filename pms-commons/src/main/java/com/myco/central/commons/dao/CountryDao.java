package com.myco.central.commons.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.model.Country;

public interface CountryDao extends GenericDao<Country, Long> {

	List<Country> getAll(Map<String, Object> filter) throws DaoException;
}