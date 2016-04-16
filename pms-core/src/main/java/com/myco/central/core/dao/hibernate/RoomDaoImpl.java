package com.myco.central.core.dao.hibernate;

import com.myco.central.commons.dao.hibernate.GenericDaoHibernate;
import com.myco.central.core.dao.RoomDao;
import com.myco.central.model.Room;

public class RoomDaoImpl extends GenericDaoHibernate<Room,Long> implements RoomDao {

	public RoomDaoImpl() {
		super(Room.class);
	}

}
