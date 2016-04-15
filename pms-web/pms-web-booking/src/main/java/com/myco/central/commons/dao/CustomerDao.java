package com.myco.central.commons.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.model.Customer;

public interface CustomerDao extends GenericDao {


    public String insert(Customer cust) throws DaoException;
	
    public String update(Customer cust) throws DaoException;
	
	public Customer search(Customer filter) throws DaoException;

	public boolean delete(Customer cust) throws DaoException;

	/**
	 * Retorna una lista con los clientes registrados por este hotel.  
	 * @param filter criterios de búsqueda
	 * @throws DaoException
	 */
	public List<Map<String, Object>> select(Customer filter) throws DaoException;

}