package com.myco.central.commons.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.model.SourceType;

public interface SourceTypeDao extends GenericDao {

	public String insert(SourceType sourceType) throws DaoException;

	public boolean update(SourceType sourceType) throws DaoException;

	public SourceType search(SourceType filter) throws DaoException;

	public boolean delete(SourceType sourceType) throws DaoException;

	public List<Map<String, Object>> select(SourceType filter) throws DaoException;

}