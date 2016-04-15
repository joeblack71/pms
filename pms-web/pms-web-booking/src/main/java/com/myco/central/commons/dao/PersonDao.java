package com.myco.central.commons.dao;

import java.sql.ResultSet;

import com.myco.central.commons.model.Person;

public interface PersonDao extends GenericDao {

	public boolean insert(Person person) throws Exception;

	public boolean update(Person person) throws Exception;

	public boolean validate(Person person) throws Exception;

	public boolean remove(Person person) throws Exception;

	public ResultSet chargeAll(String hotel, String pattern)
			throws Exception;

}