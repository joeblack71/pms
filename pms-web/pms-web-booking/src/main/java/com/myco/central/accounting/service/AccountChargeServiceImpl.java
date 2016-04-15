package com.myco.central.accounting.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myco.central.accounting.dao.AccountChargeDao;
import com.myco.central.accounting.model.AccountCharge;
import com.myco.central.commons.service.impl.GenericServiceImpl;

public class AccountChargeServiceImpl extends GenericServiceImpl implements AccountChargeService {
    
    Log log = LogFactory.getLog(AccountChargeServiceImpl.class);
    
    private AccountChargeDao accountChargeDao;

    /* Spring use */
    public void setAccountChargeDao(AccountChargeDao accountChargeDao) {
		this.accountChargeDao = accountChargeDao;
	}

	public AccountChargeServiceImpl() {
	}

	public List<AccountCharge> select(String idHotelRegistration,
    		String idCustomer, String idBill) throws Exception {
        
        List<AccountCharge> list = null;

        try {
        	list = accountChargeDao.getAccountCharges(idHotelRegistration, idCustomer, idBill);
        } catch(Exception e) {
        	e.printStackTrace();
        	throw new Exception();
        }

        return list;
    }

}