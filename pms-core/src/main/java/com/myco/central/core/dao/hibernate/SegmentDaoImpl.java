package com.myco.central.core.dao.hibernate;

import com.myco.central.commons.dao.hibernate.GenericDaoHibernate;
import com.myco.central.core.dao.SegmentDao;
import com.myco.central.model.Segment;

public class SegmentDaoImpl extends GenericDaoHibernate<Segment,Long> implements SegmentDao {

	public SegmentDaoImpl() {
		super(Segment.class);
	}

}
