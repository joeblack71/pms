package com.myco.central.accounting.service.impl;

import java.util.List;

import com.myco.central.accounting.model.RoomAccount;
import com.myco.central.accounting.service.RoomAccountService;
import com.myco.central.commons.service.impl.GenericServiceImpl;

public class RoomAccountServiceImpl extends GenericServiceImpl<RoomAccount> implements RoomAccountService {

	@Override
	public List<RoomAccount> search(Long hotelId, Long customerId, Long billId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
