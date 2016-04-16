package com.myco.central.core.dao.hibernate;

import com.myco.central.commons.dao.hibernate.GenericDaoHibernate;
import com.myco.central.core.dao.HotelDao;
import com.myco.central.model.Hotel;

public class HotelDaoImpl extends GenericDaoHibernate<Hotel,Long> implements HotelDao {

	public HotelDaoImpl() {
		super(Hotel.class);
	}

}
