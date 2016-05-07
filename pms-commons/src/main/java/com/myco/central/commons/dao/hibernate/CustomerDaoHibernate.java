package com.myco.central.commons.dao.hibernate;

import com.myco.central.commons.dao.CustomerDao;
import com.myco.central.commons.model.Customer;

public class CustomerDaoHibernate extends GenericDaoHibernate<Customer, Long> implements CustomerDao {

	public CustomerDaoHibernate(Class<Customer> persistentClass) {
		super(persistentClass);
	}

}
