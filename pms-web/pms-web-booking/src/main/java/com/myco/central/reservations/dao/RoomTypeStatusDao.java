package com.myco.central.reservations.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.GenericDao;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.reservations.domain.RoomTypeStatus;

public interface RoomTypeStatusDao extends GenericDao {

	public String insert(RoomTypeStatus roomTypeStatus) throws DaoException;

	public boolean update(RoomTypeStatus roomTypeStatus) throws DaoException;

	public RoomTypeStatus search(RoomTypeStatus filter) throws DaoException;

	public boolean delete(RoomTypeStatus roomTypeStatus) throws DaoException;

	public List<RoomTypeStatus> select(RoomTypeStatus roomTypeStatus) throws DaoException;

	public List<Map<String,Object>> verifyAvailability(Map<String, Object> params);

}