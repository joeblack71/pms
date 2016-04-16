package com.myco.central.commons.dao.hibernate;

import com.myco.central.commons.dao.CountryDao;
import com.myco.central.commons.model.Country;

public class CountryDaoHibernate extends GenericDaoHibernate<Country, Long> implements CountryDao {

	public CountryDaoHibernate() {
		super(Country.class);
	}

}
