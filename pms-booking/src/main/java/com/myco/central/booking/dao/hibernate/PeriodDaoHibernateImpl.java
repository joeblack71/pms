package com.myco.central.booking.dao.hibernate;

import java.util.List;

import com.myco.central.booking.dao.PeriodDao;
import com.myco.central.booking.model.SpecialRate;
import com.myco.central.commons.dao.hibernate.GenericDaoHibernate;
import com.myco.central.commons.exceptions.DaoException;

public class PeriodDaoHibernateImpl extends GenericDaoHibernate<SpecialRate, Long> implements PeriodDao {

	public PeriodDaoHibernateImpl(Class<SpecialRate> persistentClass) {
		super(persistentClass);
	}

	@Override
	public List<SpecialRate> getPeriodSelected(Long hotelId, String pattern) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpecialRate getSpecialRate(Long hotelId, Long specialRateId) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRoomTypeRate(Long hotelId, String roomType, Long rateId) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SpecialRate> search(SpecialRate specialRate) {
		// TODO Auto-generated method stub
		return null;
	}

}
