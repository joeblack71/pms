package com.myco.central.accounting.service;

import java.util.List;

import com.myco.central.accounting.model.RoomAccount;
import com.myco.central.commons.service.GenericService;

public interface RoomAccountService extends GenericService<RoomAccount> {

	List<RoomAccount> search(Long hotelId, Long customerId, Long billId) throws Exception;
}
