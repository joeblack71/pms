package com.myco.central.accounting.dao;

import java.util.List;

import com.myco.central.accounting.model.AccountCharge;
import com.myco.central.commons.dao.GenericDao;

public interface AccountChargeDao extends GenericDao {

	public boolean getBean(AccountCharge accountCharge) throws Exception;

	public boolean remove(AccountCharge accountCharge) throws Exception;

    public List<AccountCharge> getAccountCharges(String idHotelRegistration,
    		String idCustomer, String idBill) throws Exception;
}
