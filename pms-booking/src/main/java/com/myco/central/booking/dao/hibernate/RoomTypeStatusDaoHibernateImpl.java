package com.myco.central.booking.dao.hibernate;

import java.util.List;

import com.myco.central.booking.dao.RoomTypeStatusDao;
import com.myco.central.booking.dto.AvailabilityFilterDto;
import com.myco.central.booking.exceptions.DaoException;
import com.myco.central.booking.model.RoomTypeStatus;
import com.myco.central.commons.dao.hibernate.GenericDaoHibernate;

public class RoomTypeStatusDaoHibernateImpl extends GenericDaoHibernate<RoomTypeStatus, Long> implements RoomTypeStatusDao {

	public RoomTypeStatusDaoHibernateImpl(Class<RoomTypeStatus> persistentClass) {
		super(persistentClass);
	}

	@Override
	public List<RoomTypeStatus> verifyAvailability(AvailabilityFilterDto filter) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}