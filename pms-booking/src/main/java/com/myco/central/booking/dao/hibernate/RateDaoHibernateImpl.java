package com.myco.central.booking.dao.hibernate;

import com.myco.central.booking.dao.RateDao;
import com.myco.central.booking.model.Rate;
import com.myco.central.commons.dao.hibernate.GenericDaoHibernate;

public class RateDaoHibernateImpl extends GenericDaoHibernate<Rate,Long> implements RateDao {

	public RateDaoHibernateImpl(Class<Rate> persistentClass) {
		super(persistentClass);
	}
}
