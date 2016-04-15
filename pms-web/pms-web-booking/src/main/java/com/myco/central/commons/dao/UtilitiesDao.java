package com.myco.central.commons.dao;

import java.util.List;
import java.util.Map;

public interface UtilitiesDao {

	public List<Map<String, Object>> searchselect(String idModule, String idTable)
			throws Exception;

	public void insert(Map<String, Object> item) throws Exception;

	public void update(Map<String, Object> item) throws Exception;

	public void delete(Map<String, Object> item) throws Exception;

	//TODO: move to an specific class
	public List<Map<String, Object>> getRateselect() throws Exception;

	public List<Map<String, Object>> getCreditAccountselect(String idHotel,
			String accountType, String status) throws Exception;

	public List<Map<String, Object>> getCheckTypeselect();

}