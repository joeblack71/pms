package com.myco.central.accounting.service;

import java.util.List;

import com.myco.central.accounting.model.AccountCharge;
import com.myco.central.commons.service.GenericService;

public interface AccountChargeService extends GenericService {

	public List<AccountCharge> select(String idHotelRegistration,
			String idCustomer, String idBill) throws Exception;
	
}