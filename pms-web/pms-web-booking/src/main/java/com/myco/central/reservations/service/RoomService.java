package com.myco.central.reservations.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.GenericService;
import com.myco.central.reservations.domain.Room;

public interface RoomService extends GenericService {

	public String insert(Room room) throws ServiceException;

	public boolean update(Room room) throws ServiceException;

	public Room search(Room filter) throws ServiceException;

	public boolean delete(Room room) throws ServiceException;

	public List<Map<String, Object>> select(Room filter) throws ServiceException;

}