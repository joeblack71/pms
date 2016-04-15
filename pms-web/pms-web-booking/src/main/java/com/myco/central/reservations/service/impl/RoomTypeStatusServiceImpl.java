package com.myco.central.reservations.service.impl;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.reservations.dao.RoomTypeStatusDao;
import com.myco.central.reservations.domain.FlashStatusBean;
import com.myco.central.reservations.domain.RoomTypeStatus;
import com.myco.central.reservations.service.RoomTypeStatusService;

public class RoomTypeStatusServiceImpl implements RoomTypeStatusService {

	private RoomTypeStatusDao roomTypeStatusDao;

	public String insert(RoomTypeStatus roomTypeStatus) throws ServiceException {

		try {
			roomTypeStatusDao.insert(null);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean update(RoomTypeStatus roomTypeStatus)
			throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public RoomTypeStatus search(RoomTypeStatus roomTypeStatus)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(RoomTypeStatus roomTypeStatus)
			throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<RoomTypeStatus> select(RoomTypeStatus roomTypeStatus)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public FlashStatusBean flashStatus(RoomTypeStatus roomTypeStatus)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateFlashStatus(FlashStatusBean bean) throws ServiceException {
		// TODO Auto-generated method stub

	}

	////////
	
	public void setRoomTypeStatusDao(RoomTypeStatusDao roomTypeStatusDao) {
		this.roomTypeStatusDao = roomTypeStatusDao;
	}

	public boolean verifyAvailability(Map<String,Object> reservationData)
			throws ServiceException {
		boolean result = false;

		List<Map<String,Object>> list = roomTypeStatusDao.verifyAvailability(reservationData);

		if (list != null) {
			result = true;
		}
				
		return result;
	}

}
