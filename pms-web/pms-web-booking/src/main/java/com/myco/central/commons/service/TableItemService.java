package com.myco.central.commons.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.model.Catalog;

public interface TableItemService extends GenericService {

	public String insert(Catalog item) throws ServiceException;

	public boolean update(Catalog item) throws ServiceException;

	public Catalog search(Catalog filter) throws ServiceException;

	public boolean delete(Catalog item) throws ServiceException;

	public List<Map<String, Object>> select(Catalog filter) throws ServiceException;

}
