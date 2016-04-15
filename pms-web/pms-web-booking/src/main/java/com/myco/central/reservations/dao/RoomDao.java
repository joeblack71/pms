package com.myco.central.reservations.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.GenericDao;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.reservations.domain.Room;

public interface RoomDao extends GenericDao {

	public String insert(Room room) throws DaoException;

	public boolean update(Room room) throws DaoException;

	public Room search(Room filter) throws DaoException;

	public boolean delete(Room room) throws DaoException;

	public List<Map<String, Object>> select(Room filter) throws DaoException;

}