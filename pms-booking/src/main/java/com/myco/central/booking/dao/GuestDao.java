package com.myco.central.booking.dao;

import java.util.List;

import com.myco.central.booking.exceptions.DaoException;
import com.myco.central.booking.model.Guest;
import com.myco.central.commons.dao.GenericDao;

public interface GuestDao extends GenericDao<Guest,Long> {

	List<Guest> getGuestsInRoom(Long hotelId, Long reservationId) throws DaoException;
}