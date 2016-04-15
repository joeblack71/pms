package com.myco.central.commons.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.model.Country;

public interface CountryService extends GenericService {

	public String insert(Country country) throws ServiceException;

	public boolean update(Country country) throws ServiceException;

	public Country search(Country filter) throws ServiceException;

	public boolean delete(Country country) throws ServiceException;

	public List<Map<String, Object>> select(Country filter) throws ServiceException;

}