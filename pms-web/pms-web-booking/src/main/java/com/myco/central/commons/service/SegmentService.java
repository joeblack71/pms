package com.myco.central.commons.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.model.Segment;

public interface SegmentService extends GenericService {

	public String insert(Segment segment) throws ServiceException;

	public boolean update(Segment segment) throws ServiceException;

	public Segment search(Segment filter) throws ServiceException;

	public boolean delete(Segment segment) throws ServiceException;

	public List<Map<String, Object>> select(Segment segment) throws ServiceException;

}