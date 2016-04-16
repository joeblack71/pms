package com.myco.central.core.dao.hibernate;

import com.myco.central.commons.dao.hibernate.GenericDaoHibernate;
import com.myco.central.core.dao.SourceTypeDao;
import com.myco.central.model.SourceType;

public class SourceTypeDaoImpl extends GenericDaoHibernate<SourceType,Long> implements SourceTypeDao {

	public SourceTypeDaoImpl() {
		super(SourceType.class);
	}

}
