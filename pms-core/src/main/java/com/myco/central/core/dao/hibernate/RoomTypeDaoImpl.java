package com.myco.central.core.dao.hibernate;

import java.util.List;

import com.myco.central.commons.dao.hibernate.GenericDaoHibernate;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.core.dao.RoomTypeDao;
import com.myco.central.model.BaseAuditable;
import com.myco.central.model.RoomType;

public class RoomTypeDaoImpl extends GenericDaoHibernate<RoomType,Long> implements RoomTypeDao {

	public RoomTypeDaoImpl() {
		super(RoomType.class);
	}

	@Override
	public List<RoomType> customizedList(BaseAuditable roomType) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
