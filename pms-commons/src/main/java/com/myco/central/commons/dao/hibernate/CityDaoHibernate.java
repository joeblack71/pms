package com.myco.central.commons.dao.hibernate;

import com.myco.central.commons.model.City;

public class CityDaoHibernate extends OldGenericDaoHibernate<City, Long> {

	public CityDaoHibernate(Class<City> persistentClass) {
		super(persistentClass);
	}

}
