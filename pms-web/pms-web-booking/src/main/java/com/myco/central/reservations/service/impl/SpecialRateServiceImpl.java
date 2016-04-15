
package com.myco.central.reservations.service.impl;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.impl.GenericServiceImpl;
import com.myco.central.reservations.dao.SpecialRateDao;
import com.myco.central.reservations.domain.SpecialRate;
import com.myco.central.reservations.service.SpecialRateService;

public class SpecialRateServiceImpl extends GenericServiceImpl implements SpecialRateService {
	private SpecialRateDao specialRateDao;

    public SpecialRateServiceImpl() {}

	public void setSpecialRateDao(SpecialRateDao specialRateDao) {
		this.specialRateDao = specialRateDao;
	}

	public String insert(SpecialRate specialRate) throws ServiceException {
		String idSpecialRate = null;	

		try {
	    	idSpecialRate = specialRateDao.insert(specialRate);
	    } catch (DaoException e) {
	        e.printStackTrace();
	        throw new ServiceException();
	    }

		return idSpecialRate;
	}

	public boolean update(SpecialRate specialRate) throws ServiceException {
	    boolean result = false;

	    try {
	    	result = specialRateDao.update(specialRate);
	    } catch (DaoException e) {
	        e.printStackTrace();
	        throw new ServiceException();
	    }

		return result;
	}

	public SpecialRate search(SpecialRate filter) throws ServiceException {
		SpecialRate specialRate = null;
	
	    try {
	    	specialRate = specialRateDao.search(filter);
	    } catch (DaoException e) {
	        e.printStackTrace();
	        throw new ServiceException();
	    }
	    
	    return specialRate;
	}

	public boolean delete(SpecialRate specialRate)	throws ServiceException {
		boolean result = false; 

		try {
	    	result = specialRateDao.delete(specialRate);
	    } catch (DaoException e) {
	        e.printStackTrace();
	        throw new ServiceException();
	    }

	    return result;
	}

	public List<Map<String, Object>> select(String idHotel, String pattern, String status)
    throws ServiceException{
        List<Map<String, Object>> list = null;

        try {
        	list = specialRateDao.select(idHotel, null, pattern);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException();
        }
        
        return list;
    }
    
    public void addRoomTypeRate(String idHotel, String roomType, String idRate)
    throws ServiceException {

    	try {
        	specialRateDao.addRoomTypeRate(idHotel, roomType, idRate);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException();
        }

    }

}