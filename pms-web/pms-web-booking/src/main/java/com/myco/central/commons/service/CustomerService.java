package com.myco.central.commons.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.model.Customer;

public interface CustomerService extends GenericService {

	public String insert(Customer customer) throws ServiceException;

	public String update(Customer customer) throws ServiceException;

	public Customer search(Customer filter) throws ServiceException;

	public boolean delete(Customer customer) throws ServiceException;

	/**
	 * Retorna una lista con los clientes registrados por este hotel.  
	 * @param filter criterios de búsqueda
	 * @throws ServiceException
	 */
	public List<Map<String, Object>> select(Customer filter) throws ServiceException;

}