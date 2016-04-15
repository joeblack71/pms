
package com.myco.central.commons.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myco.central.commons.dao.UtilitiesDao;
import com.myco.central.commons.dao.jdbc.UtilitiesDaoJdbc;
import com.myco.central.commons.service.UtilitiesService;

public class UtilitiesServiceImpl implements UtilitiesService {
	Log log = LogFactory.getLog( getClass() );
	
	private UtilitiesDao utilitiesDao = new UtilitiesDaoJdbc();

    public void setUtilitiesDao(UtilitiesDao utilitiesDao) {
		this.utilitiesDao = utilitiesDao;
	}

	public UtilitiesServiceImpl() {
    }

    public void insert(Map<String, Object> item) throws Exception {

    	try {
        	utilitiesDao.insert(item);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception();
		}
        
    }

    public void update(Map<String, Object> item) throws Exception {

    	try {
        	utilitiesDao.update(item);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception();
		}
        
    }

    public void delete(Map<String, Object> item) throws Exception {

    	try {
        	utilitiesDao.delete(item);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception();
		}

    }

    
    public List<Map<String, Object>> select(String idModule, String idTable)
    throws Exception {

		List<Map<String, Object>> list = null;
		
        try {
        	list = utilitiesDao.searchselect(idModule, idTable);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception();
		}
        
        return list;
    }

    //TODO: move to an specific class
    public List<Map<String, Object>> getRateselect() throws Exception {
		List<Map<String, Object>> list = null;
		
        try {
        	list = utilitiesDao.getRateselect();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception();
		}
    	
    	return list;
    }

    public List<Map<String, Object>> getCreditAccountselect(String idHotel,
    		String accountType, String status)
    throws Exception {
		List<Map<String, Object>> list = null;
		
        try {
        	list = utilitiesDao.getCreditAccountselect(idHotel, accountType, status);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception();
		}

    	return list;
    }

    public List<Map<String, Object>> getCheckTypeselect() throws Exception {
		List<Map<String, Object>> list = null;
		
        try {
        	list = utilitiesDao.getCheckTypeselect();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
    	
    	return list;
    }

}