package com.myco.central.commons.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.model.Company;

public interface CompanyService extends GenericService {

	public String insert(Company company) throws Exception;

	public boolean update(Company company) throws Exception;

	public Company search(Company company) throws Exception;

	public boolean delete(Company company) throws Exception;

	public List<Map<String, Object>> select(Map<String, Object> params) 
		throws Exception;

}