
package com.myco.central.reservations.service.impl;

import java.util.List;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.impl.GenericServiceImpl;
import com.myco.central.constants.CentralModuleConstants;
import com.myco.central.reservations.dao.RoomTypeDao;
import com.myco.central.reservations.domain.RoomType;
import com.myco.central.reservations.service.RoomTypeService;

public class RoomTypeServiceImpl extends GenericServiceImpl implements RoomTypeService {
	private RoomTypeDao roomTypeDao;

    public RoomTypeDao getRoomTypeDao() {
		return roomTypeDao;
	}

	public void setRoomTypeDao(RoomTypeDao roomTypeDao) {
	}

	public RoomTypeServiceImpl() {}
   
	/////////////////////
	/// Implementation
	/////////////////////
	
    public String insert(RoomType roomType) throws ServiceException {
		String idRoomType = null;

		try{
        	if (isValidRoomType(roomType) ) {
        		idRoomType = roomTypeDao.insert(roomType);
        	}
        } catch (DaoException ex) {
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return idRoomType;
    }

    public boolean update(RoomType roomType) throws ServiceException {
    	boolean result = false;

        try{
        	result = roomTypeDao.update(roomType);
        } catch (DaoException ex) {
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return result;
    }

    public RoomType search(RoomType roomType) throws ServiceException {
    	RoomType roomTypeOut = null;
    	
//        try{
//        	roomTypeOut = roomTypeDao.search(roomType);
//        } catch (DaoException ex) {
//        	log.info( ex.getMessage() );
//        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
//        }

        return roomTypeOut;
    }

    public boolean delete(RoomType roomType) throws ServiceException {
    	boolean result = false;
    	
        try{
        	result = roomTypeDao.delete(roomType);
        } catch (DaoException ex) {
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return result;
    }

    public List<RoomType> select(RoomType roomType) throws ServiceException {
        List<RoomType> list = null;
        
//        try {
//        	if (isValidRoomType(roomType) ) {
//        		list = roomTypeDao.select(roomType);
//        	}
//        } catch (DaoException ex) {
//        	log.info( ex.getMessage() );
//        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
//        }
        
        return list;
    }

	//////////////////////
	/// Private interface
	//////////////////////

	private boolean isValidRoomType(RoomType roomType) {
//		String idHotel = roomType.getIdHotel();
//		String codeRoomType = roomType.getRoomType();
		
		boolean result = true;

//		if ( StringUtils.isEmpty(idHotel) 
//			 || StringUtils.isEmpty(codeRoomType) ) {
//			result = false;
//		}

		/*if ( idHotel != null && idHotel.length() > 0 
			 && codeRoomType != null && codeRoomType.length() > 0 ) {
			result = true;
		}*/
		
		return result;
	}

}