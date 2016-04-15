package com.myco.central.commons.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.model.Hotel;

public interface HotelService extends GenericService {

	public String insert(Hotel hotel) throws ServiceException;

	public String update(Hotel hotel) throws ServiceException;

	public String search(Hotel filter) throws ServiceException;

	public String delete(Hotel hotel) throws ServiceException;

	public List<Map<String, Object>> select(Hotel filter) throws ServiceException;

}
