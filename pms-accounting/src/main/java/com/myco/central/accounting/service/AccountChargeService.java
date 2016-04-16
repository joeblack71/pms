package com.myco.central.accounting.service;

import java.util.List;

import com.myco.central.accounting.model.AccountCharge;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.GenericService;

public interface AccountChargeService extends GenericService<AccountCharge> {

	List<AccountCharge> search(Long hotelIdRegistration, Long customerId, Long billId) throws ServiceException;

}