
package com.myco.central.reservations.service.impl;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.impl.GenericServiceImpl;
import com.myco.central.constants.CentralModuleConstants;
import com.myco.central.reservations.dao.GuestDao;
import com.myco.central.reservations.domain.Guest;
import com.myco.central.reservations.service.GuestService;

public class GuestServiceImpl extends GenericServiceImpl implements GuestService {

	private GuestDao guestDao;

    public GuestDao getGuestDao() {
		return guestDao;
	}

	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}

	public GuestServiceImpl() {
    }

    public boolean insert(Guest guest) throws ServiceException {
    	boolean result = false;

    	try {
    		result = guestDao.insert(guest);
        
    	} catch (DaoException ex) {
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return result;
    }

    public boolean delete(Guest guest) throws ServiceException {
    	boolean result = false;

    	try {
    		result = guestDao.delete(guest);

    	} catch (DaoException ex) {
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }
        
		return result;
    }

    public List<Guest> select(Map<String, Object> params) throws Exception {
    	List<Guest> list = null;

    	try {
    		list = guestDao.select(null);
        
    	} catch (DaoException ex) {
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }
        
        return list;
    }

    public Map<String, Guest> listGuestsInRoom(String idHotel,
    		String idReservation) throws ServiceException {
    	Map<String, Guest> map = null;
    	
    	try {
    		map = guestDao.listGuestsInRoom(idHotel, idReservation);
        
    	} catch (DaoException ex) {
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }
        
        return map;
    }

	public boolean update(Guest guest) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean search(Guest guest) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}