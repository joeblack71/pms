package com.myco.central.commons.service;

import java.sql.ResultSet;

import com.myco.central.commons.dao.PersonDao;
import com.myco.central.commons.model.Person;

public interface PersonService extends GenericService {

	public void setPersonDao(PersonDao personDao);

	public boolean validate(Person person);

	public boolean insert(Person person);

	public boolean update(Person person);

	public boolean delete(Person person);

	public ResultSet chargeAll(String hotel, String pattern);

}