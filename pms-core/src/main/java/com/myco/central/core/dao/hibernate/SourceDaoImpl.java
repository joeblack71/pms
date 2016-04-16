package com.myco.central.core.dao.hibernate;

import com.myco.central.commons.dao.hibernate.GenericDaoHibernate;
import com.myco.central.core.dao.SourceDao;
import com.myco.central.model.Source;

public class SourceDaoImpl extends GenericDaoHibernate<Source,Long> implements SourceDao {

	public SourceDaoImpl() {
		super(Source.class);
	}

}
