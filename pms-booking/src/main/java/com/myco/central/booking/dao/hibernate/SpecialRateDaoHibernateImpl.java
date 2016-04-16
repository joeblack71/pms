package com.myco.central.booking.dao.hibernate;

import java.util.List;

import com.myco.central.booking.dao.SpecialRateDao;
import com.myco.central.booking.exceptions.DaoException;
import com.myco.central.booking.model.SpecialRate;
import com.myco.central.commons.dao.hibernate.GenericDaoHibernate;

public class SpecialRateDaoHibernateImpl extends GenericDaoHibernate<SpecialRate, Long> implements SpecialRateDao {

	public SpecialRateDaoHibernateImpl(Class<SpecialRate> persistentClass) {
		super(persistentClass);
	}

	@Override
	public void addRoomTypeRate(Long hotelId, String roomType, Long rateId) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SpecialRate> search(Long hotelId, String description, String status) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
}
