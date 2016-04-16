package com.myco.central.accounting.service;

import java.util.List;

import com.myco.central.accounting.model.AccountType;
import com.myco.central.accounting.model.HotelAccount;
import com.myco.central.commons.exceptions.ServiceException;

public interface HotelAccountService {
	List<HotelAccount> getHotelAccounts(Long hotelId, AccountType accountType) throws ServiceException;

}
