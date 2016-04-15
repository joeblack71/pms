
package com.myco.central.commons.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.CityDao;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.model.City;
import com.myco.central.commons.service.CityService;
import com.myco.central.constants.CentralModuleConstants;

public class CityServiceImpl extends GenericServiceImpl implements CityService {
	private CityDao cityDao;

	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	public CityServiceImpl() {}
   
    public String insert(City city) throws ServiceException{
        String idCity = null;

        try {
        	idCity = cityDao.insert(city);
        } catch (DaoException ex){
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_DAO_EXCEPTION);
        }

        return idCity;
    }

    public boolean update(City city) throws ServiceException {
        boolean result = false;

        try {
        	result = cityDao.update(city);
        } catch (DaoException ex){
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_DAO_EXCEPTION);
        }

        return result;
    }

    public City search(City filter) throws ServiceException {
    	City city = null;

        try {
        	city = cityDao.search(filter);
        } catch (DaoException ex){
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_DAO_EXCEPTION);
        }

        return city;
    }

    public boolean delete(City city)
    throws ServiceException {
        boolean result = false;

        try {
        	result = cityDao.delete(city);
        } catch (DaoException ex){
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_DAO_EXCEPTION);
        }

        return result;
    }

    public List<Map<String, Object>> select(City filter)
    throws ServiceException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        try {
        	list = cityDao.select(filter);
        } catch (DaoException ex){
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_DAO_EXCEPTION);
        }

        return list;
    }

	public List<Map<String, Object>> select(Map<String, Object> params)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}