
package com.myco.central.commons.service.impl;

import java.sql.ResultSet;

import com.myco.central.commons.dao.PersonDao;
import com.myco.central.commons.model.Person;
import com.myco.central.commons.service.PersonService;

public class PersonServiceImpl extends GenericServiceImpl implements PersonService {

    private PersonDao personDao;

    public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
	}

	public PersonServiceImpl() {}

    public boolean validate(Person person) {
        boolean result = false;

        try {
        	result = personDao.validate(person);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean insert(Person person) {
        boolean result = false;

        try {
        	result = personDao.validate(person);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean update(Person person) {
        boolean result = false;

        try {
        	result = personDao.update(person);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean delete(Person person) {
        boolean result = false;

        try {
        	result = personDao.remove(person);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public ResultSet chargeAll(String hotel, String pattern) {
        ResultSet rs = null;

        try {
        	rs = personDao.chargeAll(hotel, pattern);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }

}