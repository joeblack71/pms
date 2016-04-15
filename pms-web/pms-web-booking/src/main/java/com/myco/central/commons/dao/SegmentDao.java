package com.myco.central.commons.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.model.Segment;

public interface SegmentDao extends GenericDao {

	public String insert(Segment segment) throws DaoException;

	public boolean update(Segment segment) throws DaoException;

	public Segment search(Segment filter) throws DaoException;

	public boolean delete(Segment segment) throws DaoException;

	public List<Map<String, Object>> select(Segment filter) throws DaoException;

}