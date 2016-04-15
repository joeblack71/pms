package com.myco.central.reservations.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.GenericService;
import com.myco.central.reservations.domain.Rate;

public interface RateService extends GenericService {

	public String insert(Rate rate) throws ServiceException;

	public boolean update(Rate rate) throws ServiceException;

	public Rate search(Rate filter) throws ServiceException;

	public boolean delete(Rate rate) throws ServiceException;

	public List<Map<String, Object>> select(Rate rate) throws ServiceException;

}