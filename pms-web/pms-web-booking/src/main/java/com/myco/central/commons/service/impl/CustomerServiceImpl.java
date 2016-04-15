
package com.myco.central.commons.service.impl;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.CustomerDao;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.model.Customer;
import com.myco.central.commons.service.CustomerService;
import com.myco.central.constants.CentralModuleConstants;

public class CustomerServiceImpl extends GenericServiceImpl implements CustomerService {
    public CustomerDao getCustomerDao() {
		return customerDao;
	}

	private CustomerDao customerDao;

    public CustomerServiceImpl() {
    }

    /////////////////////
    /// Implementation
    /////////////////////

	public String insert(Customer c) throws ServiceException {
		String idCustomer = null;

		try {
        	idCustomer = customerDao.insert(c);
        } catch (DaoException ex){
            log.info( ex.getMessage() );
            throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }
        
        return idCustomer;
    }

    public String update(Customer c) throws ServiceException {
    	String daoResult = null;

    	//boolean result = false;

        try {
        	daoResult = customerDao.update(c);
        	if ( !daoResult.equals(CentralModuleConstants.SUCCESSFUL_OPERATION) 
        		 && !daoResult.equals(CentralModuleConstants.ER_DUP_ENTRY) ) {
        			throw new DaoException(CentralModuleConstants.MESSAGE_DAO_EXCEPTION);
        	}
        } catch (DaoException ex){
            log.info( ex.getMessage() );
            throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }
        
        return daoResult;
    }

    public Customer search(Customer filter) throws ServiceException {
        Customer customer = null;

        try {
        	customer = customerDao.search(filter);
        } catch (DaoException ex){
            log.info( ex.getMessage() );
            throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }
        
        return customer;
    }

    public boolean delete(Customer customer) throws ServiceException {
    	boolean result = false;

        try {
        	result = customerDao.delete(customer);
        } catch (DaoException ex){
            log.info( ex.getMessage() );
            throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return result;
    }

    public List<Map<String, Object>> select(Customer filter) throws ServiceException {
        List<Map<String, Object>> list = null;

        try {
            list = customerDao.select(filter);
        } catch (DaoException ex){
            log.info( ex.getMessage() );
            throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return list;
	}

    //// Dependency Injection
    
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

}