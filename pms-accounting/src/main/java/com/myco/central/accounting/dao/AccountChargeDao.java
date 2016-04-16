package com.myco.central.accounting.dao;

import java.util.List;

import com.myco.central.accounting.model.AccountCharge;
import com.myco.central.commons.dao.GenericDao;
import com.myco.central.commons.exceptions.DaoException;

public interface AccountChargeDao extends GenericDao<AccountCharge, Long> {

	public List<AccountCharge> getAccountCharges(Long hotelId,
			Long customerId, Long billId) throws DaoException;

}
