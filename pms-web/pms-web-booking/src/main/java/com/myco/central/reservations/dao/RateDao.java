package com.myco.central.reservations.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.GenericDao;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.reservations.domain.Rate;

public interface RateDao extends GenericDao {

	public String insert(Rate rate) throws DaoException;

	public boolean update(Rate rate) throws DaoException;

	public Rate search(Rate filter) throws DaoException;

	public boolean delete(Rate rate) throws DaoException;

	public List<Map<String, Object>> select(Rate filter) throws DaoException;

}