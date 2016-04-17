package com.myco.central.commons.dao.hibernate;

import com.myco.central.commons.model.Company;

public class CompanyDaoHibernate extends GenericDaoHibernate<Company, Long> {

	public CompanyDaoHibernate(Class<Company> persistentClass) {
		super(persistentClass);
	}
}
