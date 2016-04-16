package com.myco.central.booking.dao.hibernate;

import java.util.List;

import com.myco.central.booking.dao.ReservationDao;
import com.myco.central.booking.exceptions.DaoException;
import com.myco.central.booking.model.Guest;
import com.myco.central.booking.model.Reservation;
import com.myco.central.commons.dao.hibernate.GenericDaoHibernate;

public class ReservationDaoHibernateImpl extends GenericDaoHibernate<Reservation, Long> implements ReservationDao {

	public ReservationDaoHibernateImpl(Class<Reservation> persistentClass) {
		super(persistentClass);
	}

	public void saveReservationInfo(Reservation resv) throws DaoException {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Guest> getReservationGuests(String idHotel, String idReservation) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
}
