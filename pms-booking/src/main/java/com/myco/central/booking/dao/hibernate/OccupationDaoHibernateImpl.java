package com.myco.central.booking.dao.hibernate;

import java.util.List;
import java.util.Map;

import com.myco.central.booking.dao.OccupationDao;
import com.myco.central.booking.dto.OccupationByTypeDto;
import com.myco.central.booking.dto.OccupationDto;
import com.myco.central.booking.exceptions.DaoException;

public class OccupationDaoHibernateImpl implements OccupationDao {

	@Override
	public List<OccupationByTypeDto> getOccupationByType(OccupationDto filter) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OccupationByTypeDto> getOccupationByStay(OccupationDto filter) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getFlashStatus(OccupationDto filter) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
}
