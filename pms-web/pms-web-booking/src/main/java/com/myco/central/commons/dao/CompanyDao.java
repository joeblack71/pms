package com.myco.central.commons.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.model.Company;

public interface CompanyDao extends GenericDao {

	public String insert(Company company) throws Exception;

	public boolean update(Company company) throws Exception;

	public Company search(Company company) throws Exception;

	public boolean delete(Company company) throws Exception;

	public List<Map<String, Object>> select(String idHotel, String status) throws Exception;

}