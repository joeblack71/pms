package com.myco.central.reservations.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.GenericDao;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.reservations.domain.RoomType;

public interface RoomTypeDao extends GenericDao {

	public String insert(RoomType roomType) throws DaoException;

	public boolean update(RoomType roomType) throws DaoException;

	public RoomType search(Map<String, Object> params) throws DaoException;

	public boolean delete(RoomType roomType) throws DaoException;

	public List<RoomType> select(Map<String, Object> params) throws DaoException;

}