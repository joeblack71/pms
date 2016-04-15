package com.myco.central.commons.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.UtilitiesDao;

public interface UtilitiesService {

	public void setUtilitiesDao(UtilitiesDao utilitiesDao);

	public void insert(Map<String, Object> item) throws Exception;

	public void update(Map<String, Object> item) throws Exception;

	public void delete(Map<String, Object> item) throws Exception;

	public List<Map<String, Object>> select(String idModule, String idTable)
			throws Exception;

	//TODO: move to an specific class
	public List<Map<String, Object>> getRateselect() throws Exception;

	public List<Map<String, Object>> getCreditAccountselect(String idHotel,
			String accountType, String status) throws Exception;

	public List<Map<String, Object>> getCheckTypeselect() throws Exception;

}