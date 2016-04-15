
package com.myco.central.reservations.service.impl;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.impl.GenericServiceImpl;
import com.myco.central.constants.CentralModuleConstants;
import com.myco.central.reservations.dao.RateDao;
import com.myco.central.reservations.domain.Rate;
import com.myco.central.reservations.service.RateService;

public class RateServiceImpl extends GenericServiceImpl implements RateService {
	public RateDao getRateDao() {
		return rateDao;
	}

	private RateDao rateDao;

	public void setRateDao(RateDao rateDao) {
	}

	public RateServiceImpl() {}
   
    public String insert(Rate rate) throws ServiceException {
        String idSource = null;

        try {
        	idSource = rateDao.insert(rate);
        } catch (DaoException ex) {
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return idSource;
    }

    public boolean update(Rate rate) throws ServiceException {
        boolean result = false;

        try {
        	result = rateDao.update(rate);
        } catch (DaoException ex) {
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return result;
    }

    public Rate search(Rate filter) throws ServiceException {
    	Rate rate = null;

        try {
        	rate = rateDao.search(filter);
        } catch (DaoException ex) {
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return rate;
    }

    public boolean delete(Rate rate) throws ServiceException {
        boolean result = false;

        try {
        	result = rateDao.delete(rate);
        } catch (DaoException ex){
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return result;
    }

    public List<Map<String, Object>> select(Rate rate) throws ServiceException {
        List<Map<String, Object>> list = null;

        try {
        	list = rateDao.select(rate);
        } catch (DaoException ex){
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return list;
    }

}