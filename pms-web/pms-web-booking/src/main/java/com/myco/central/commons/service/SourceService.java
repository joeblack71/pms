package com.myco.central.commons.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.model.Source;

public interface SourceService extends GenericService {

	public String insert(Source source) throws ServiceException;

	public String update(Source source) throws ServiceException;

	public Source search(Source filter) throws ServiceException;

	public boolean delete(Source source) throws ServiceException;

	public List<Map<String, Object>> select(Source filter) throws ServiceException;

}