package com.myco.central.accounting.service.impl;

import java.util.List;

import com.myco.central.accounting.model.AccountCharge;
import com.myco.central.accounting.service.AccountChargeService;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.impl.GenericServiceImpl;

public class AccountChargeServiceImpl extends GenericServiceImpl<AccountCharge> implements AccountChargeService {

	@Override
	public List<AccountCharge> search(Long hotelIdRegistration, Long customerId, Long billId) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}