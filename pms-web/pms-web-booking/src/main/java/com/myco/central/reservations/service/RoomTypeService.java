package com.myco.central.reservations.service;

import java.util.List;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.GenericService;
import com.myco.central.reservations.domain.RoomType;

public interface RoomTypeService extends GenericService {

	public String insert(RoomType roomType) throws ServiceException;

	public boolean update(RoomType roomType) throws ServiceException;

	public RoomType search(RoomType roomType) throws ServiceException;

	public boolean delete(RoomType roomType) throws ServiceException;

	public List<RoomType> select(RoomType roomType) throws ServiceException;

}