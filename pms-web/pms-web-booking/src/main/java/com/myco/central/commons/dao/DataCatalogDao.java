package com.myco.central.commons.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.model.DataCatalog;

public interface DataCatalogDao extends GenericDao {

	public String insert(DataCatalog item) throws DaoException;

	public boolean update(DataCatalog item) throws DaoException;

	public DataCatalog search(Map<String, Object> filter) throws DaoException;

	public boolean delete(DataCatalog item) throws DaoException;

	public List<Map<String, Object>> select(Map<String, Object> filter) throws DaoException;

}
