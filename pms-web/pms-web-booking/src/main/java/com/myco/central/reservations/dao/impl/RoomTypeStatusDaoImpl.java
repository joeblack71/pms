package com.myco.central.reservations.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.reservations.dao.RoomTypeStatusDao;
import com.myco.central.reservations.domain.RoomTypeStatus;

public class RoomTypeStatusDaoImpl implements RoomTypeStatusDao {

	public String insert(RoomTypeStatus roomTypeStatus) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(RoomTypeStatus roomTypeStatus) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	public RoomTypeStatus search(RoomTypeStatus filter) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(RoomTypeStatus roomTypeStatus) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<RoomTypeStatus> select(RoomTypeStatus roomTypeStatus)
			throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map<String,Object>> verifyAvailability(Map<String, Object> params) {
		List<Map<String, Object>> list = null;

		list =  new ArrayList<Map<String,Object>>(); // TODO implement logic
		
		return list;
	}

}
