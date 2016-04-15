package com.myco.central.commons.service.impl;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.CommonsDao;
import com.myco.central.commons.service.CommonsService;
import com.myco.central.reservations.domain.HotelAccount;

public final class CommonsServiceImpl extends GenericServiceImpl implements CommonsService {
	private CommonsDao commonsDao;
	
	public CommonsDao getCommonsDao() {
		return commonsDao;
	}

	public void setCommonsDao(CommonsDao commonsDao) {
		this.commonsDao = commonsDao;
	}

	public List<Map<String, Object>> getHotels() throws Exception {
		List<Map<String, Object>> list = null;

		try {
			list = commonsDao.getHotels();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Map<String, Object>> getRoomTypes(String idHotel) throws Exception {
		StringBuffer sb = new StringBuffer();

		sb.append("idHotel: ");
		sb.append(idHotel);

		log.info( sb.toString() );

		List<Map<String, Object>> list = null;
		
		try {
			list = commonsDao.getRoomTypes(idHotel);
		} catch(Exception e) {
			e.printStackTrace();
		}

		log.info( "Registros recuperados: " + list.size() );

		return list;
	}

	public List<Map<String, Object>> getRoomNumbers(String idHotel, String roomType)
	throws Exception {
		List<Map<String, Object>> list = null;
		
		try {
			list = commonsDao.getRoomNumbers(idHotel, roomType);
		} catch(Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Map<String, Object>> getPeriodTypes() throws Exception {
		List<Map<String, Object>> list = null;
		
		try {
			list = commonsDao.getPeriodTypes();
		} catch(Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Map<String, Object>> getPaymentTypes(List<HotelAccount> paymentTypes) throws Exception {
		List<Map<String, Object>> list = null;
		
		try {
			list = commonsDao.getPaymentTypes(paymentTypes);
		} catch(Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
