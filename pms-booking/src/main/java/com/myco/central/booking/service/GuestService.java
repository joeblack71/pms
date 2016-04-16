package com.myco.central.booking.service;

import java.util.List;

import com.myco.central.booking.model.Guest;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.GenericService;

public interface GuestService extends GenericService<Guest> {

	List<Guest> getGuestsInRoom(Long hotelId, Long reservationId) throws ServiceException;
}