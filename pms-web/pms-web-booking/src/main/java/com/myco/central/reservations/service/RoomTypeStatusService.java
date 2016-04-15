package com.myco.central.reservations.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.GenericService;
import com.myco.central.reservations.domain.FlashStatusBean;
import com.myco.central.reservations.domain.RoomTypeStatus;

public interface RoomTypeStatusService extends GenericService {

	public String insert(RoomTypeStatus roomTypeStatus) throws ServiceException;

	public boolean update(RoomTypeStatus roomTypeStatus) throws ServiceException;

	public RoomTypeStatus search(RoomTypeStatus roomTypeStatus) throws ServiceException;

	public boolean delete(RoomTypeStatus roomTypeStatus) throws ServiceException;

	public List<RoomTypeStatus> select(RoomTypeStatus roomTypeStatus) throws ServiceException;

	public FlashStatusBean flashStatus(RoomTypeStatus roomTypeStatus) throws ServiceException;

	public boolean verifyAvailability(Map<String,Object> reservationData) throws ServiceException;

	public void updateFlashStatus(FlashStatusBean bean) throws ServiceException;

}