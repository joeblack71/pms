package com.myco.central.commons.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.model.Source;

public interface SourceDao extends GenericDao {

	/**
	 * 
	 * @param source el objeto que sera almacenado en bbdd
	 * @return el id generado para el objeto insertado
	 * @throws DaoException
	 */
	public String insert(Source source) throws DaoException;

	public String update(Source source) throws DaoException;

	public Source search(Source filter) throws DaoException;

	public boolean delete(Source source) throws DaoException;

	public List<Map<String, Object>> select(Source filter) throws DaoException;

}