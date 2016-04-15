
package com.myco.central.commons.service.impl;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.SourceDao;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.model.Source;
import com.myco.central.commons.service.SourceService;
import com.myco.central.constants.CentralModuleConstants;

public class SourceServiceImpl extends GenericServiceImpl implements SourceService {
	private SourceDao sourceDao;

	public void setSourceDao(SourceDao sourceDao) {
	}

	public SourceDao getSourceDao() {
		return sourceDao;
	}

	public SourceServiceImpl() {}

	////////////////////
	/// Implementatation
	////////////////////
	
    public String insert(Source source) throws ServiceException {
    	String idSource = null;

    	try {
        	idSource = sourceDao.insert(source);
        } catch (DaoException ex) {
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return idSource;
    }

    public String update(Source source) throws ServiceException {
    	String result = null;

    	try {
        	result = sourceDao.update(source);
        } catch (DaoException ex) {
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }
        
		return result;
    }

    public Source search(Source filter) throws ServiceException {
    	Source source = null;

        try{
        	source = sourceDao.search(filter);
        } catch (DaoException ex) {
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return source;
    }

    public boolean delete(Source source) throws ServiceException {
    	boolean result = false;

    	try{
        	result = sourceDao.delete(source);
        } catch (DaoException ex) {
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return result;
    }

    public List<Map<String, Object>> select(Source filter)
    throws ServiceException {
        List<Map<String, Object>> list = null;

        try {
        	list = sourceDao.select(filter);
        } catch (DaoException ex) {
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }
        
        return list; 
    }

}