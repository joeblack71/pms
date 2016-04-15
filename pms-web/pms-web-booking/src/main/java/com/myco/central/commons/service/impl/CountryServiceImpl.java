
package com.myco.central.commons.service.impl;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.CountryDao;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.model.Country;
import com.myco.central.commons.service.CountryService;
import com.myco.central.constants.CentralModuleConstants;

public class CountryServiceImpl extends GenericServiceImpl implements CountryService {
	
	private CountryDao countryDao;

	public String insert(Country country) throws ServiceException {
        String idCountry = null;

        try {
        	idCountry = countryDao.insert(country);
        } catch (DaoException ex){
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return idCountry;
    }

    public boolean update(Country country) throws ServiceException {
        boolean flag = false;

        try {
        	countryDao.update(country);
        } catch (DaoException ex){
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return flag;
    }

    public Country search(Country filter)
    throws ServiceException {
    	Country country = null;

        try {
        	country = countryDao.search(filter);
        } catch (DaoException ex){
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return country;
    }

    public boolean delete(Country country)
    throws ServiceException {
        boolean result = false;

        try {
        	result = countryDao.delete(country);
        } catch (DaoException ex){
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return result;
    }

    public List<Map<String, Object>> select(Country filter)
    throws ServiceException {
        List<Map<String, Object>> list = null;

        try {
        	list = countryDao.select(filter);
        } catch (DaoException ex){
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return list;
    }

    public void setCountryDao(CountryDao countryDao) {
		this.countryDao = countryDao;
	}

}