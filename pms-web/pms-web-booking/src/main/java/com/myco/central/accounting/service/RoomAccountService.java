package com.myco.central.accounting.service;

import java.util.List;
import java.util.Map;

import com.myco.central.accounting.dao.RoomAccountDao;
import com.myco.central.commons.service.GenericService;

public interface RoomAccountService extends GenericService {

	public void setRoomAccountDao(RoomAccountDao roomAccountDao);

	public List<Map<String, Object>> select(String idHotel, String idCustomer,
			String idBill) throws Exception;

}