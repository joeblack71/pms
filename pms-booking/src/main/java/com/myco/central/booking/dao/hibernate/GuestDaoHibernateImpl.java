package com.myco.central.booking.dao.hibernate;

import java.util.List;

import com.myco.central.booking.dao.GuestDao;
import com.myco.central.booking.exceptions.DaoException;
import com.myco.central.booking.model.Guest;
import com.myco.central.commons.dao.hibernate.GenericDaoHibernate;

public class GuestDaoHibernateImpl extends GenericDaoHibernate<Guest, Long> implements GuestDao {

	public GuestDaoHibernateImpl() {
		super(Guest.class);
	}

	@Override
	public List<Guest> getGuestsInRoom(Long hotelId, Long reservationId) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
}
