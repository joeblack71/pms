package com.myco.central.core.dao;

import java.util.List;

import com.myco.central.commons.dao.GenericDao;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.model.BaseAuditable;
import com.myco.central.model.RoomType;

public interface RoomTypeDao extends GenericDao<RoomType, Long>{
	List<RoomType> customizedList(BaseAuditable roomType) throws DaoException;
}