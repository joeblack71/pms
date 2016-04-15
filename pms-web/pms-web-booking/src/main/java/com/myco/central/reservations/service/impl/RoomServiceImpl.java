
package com.myco.central.reservations.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.exceptions.MissingDataException;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.impl.GenericServiceImpl;
import com.myco.central.constants.CentralModuleConstants;
import com.myco.central.reservations.dao.RoomDao;
import com.myco.central.reservations.domain.Room;
import com.myco.central.reservations.service.RoomService;

public class RoomServiceImpl extends GenericServiceImpl implements RoomService {
	private RoomDao roomDao;

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	public RoomServiceImpl() {}

	///////////////////
	/// Implementation
	///////////////////
	
    public String insert(Room room) throws ServiceException {
        String idRoom = null;

        try {
			if ( isValidRoomInsert(room) ) {
				idRoom = roomDao.insert(room);
			}
		} catch (MissingDataException mdex) {
        	log.info( mdex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        } catch (DaoException ex){
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return idRoom;
    }

    public boolean update(Room room) throws ServiceException {
        boolean result = false;

        try {
			if ( isValidRoomUpdate(room) ) {
        		result = roomDao.update(room);
			}
		} catch (MissingDataException mdex) {
        	log.info( mdex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        } catch (DaoException ex){
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return result;
    }

    public Room search(Room filter) throws ServiceException {
    	Room room = null;

        try {
        	room = roomDao.search(filter);
        } catch (DaoException ex){
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return room;
    }

    public boolean delete(Room room) throws ServiceException {
        boolean result = false;

        try {
        	result = roomDao.delete(room);
        } catch (DaoException ex){
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return result;
    }

    public List<Map<String, Object>> select(Room filter) throws ServiceException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        try {
        	list = roomDao.select(filter);
        } catch (DaoException ex){
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return list;
    }


	//////////////////////
	/// Private interface
	//////////////////////

	private boolean isValidRoomInsert(Room room) throws MissingDataException {
		boolean result = false;

//		String idHotel = room.getIdHotel();
//		String idRoomType = room.getIdRoomType();
//		String roomNumber = room.getRoomNumber();

		/*room.setIdRoom("");
		room.setRoomNumber("0101");
		room.setDescription("DOBLE");
		room.setLocation("");
		room.setIdRoom("");
		room.setBedsCapacity("");
		room.setRoomRate("");
		room.setAssignedReservation("0");
		room.setConnectedRoom("");
		room.setRoomStatus("A");
		room.setHkStatus("");*/

//		if ( StringUtils.isBlank(idHotel)
//			 || StringUtils.isBlank(idRoomType)
//			 || StringUtils.isBlank(roomNumber) ) {
//			throw new MissingDataException("Neither idHotel or idRoomType or roomNumber is blank !!");
//		} else {
//			result = true;
//		}
//
//		if ( !StringUtils.isNumeric(idHotel)
//			 || !StringUtils.isNumeric(idRoomType) ) {
//			throw new MissingDataException("Neither idHotel or idRoomType is not numeric !!");
//		} else {
//			result = true;
//		}

		return result;
	}

	private boolean isValidRoomUpdate(Room room) throws MissingDataException {
		boolean result = false;

//		String idHotel = room.getIdHotel();
//		String idRoom = room.getIdRoom();
//		String idRoomType = room.getIdRoomType();
//		String roomNumber = room.getRoomNumber();
//
//		if ( StringUtils.isBlank(idHotel)
//			 || StringUtils.isBlank(idRoom)
//			 || StringUtils.isBlank(idRoomType)
//			 || StringUtils.isBlank(roomNumber) ) {
//			throw new MissingDataException("Neither idHotel or idRoom or idRoomType or roomNumber is blank !!");
//		} else {
//			result = true;
//		}
//
//		if ( !StringUtils.isNumeric(idHotel)
//			 || !StringUtils.isNumeric(idRoom)
//			 || !StringUtils.isNumeric(idRoomType) ) {
//			throw new MissingDataException("Neither idHotel or idRoom or idRoomType is not numeric !!");
//		} else {
//			result = true;
//		}

		return result;
	}

}