package com.myco.central.commons.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.model.City;

public interface CityService extends GenericService {

	public String insert(City city) throws ServiceException;

	public boolean update(City city) throws ServiceException;

	public City search(City filter) throws ServiceException;

	public boolean delete(City city) throws ServiceException;

	public List<Map<String, Object>> select(Map<String, Object> params) throws ServiceException;

}