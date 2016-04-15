
package com.myco.central.commons.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.SegmentDao;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.model.Segment;
import com.myco.central.commons.service.SegmentService;
import com.myco.central.constants.CentralModuleConstants;

public class SegmentServiceImpl extends GenericServiceImpl implements SegmentService {
	private SegmentDao segmentDao;

	public void setSegmentDao(SegmentDao segmentDao) {
		this.segmentDao = segmentDao;
	}

	public SegmentDao getSegmentDao() {
		return segmentDao;
	}

	public SegmentServiceImpl() {
	}

	///////////////////
	/// Implementation
	///////////////////

    public String insert(Segment segment) throws ServiceException{
        String idSource = null;

        try {
        	idSource = segmentDao.insert(segment);
        } catch (DaoException e){
        	log.info( e.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return idSource;
    }

    public boolean update(Segment segment) throws ServiceException {
        boolean result = false;

        try {
        	result = segmentDao.update(segment);
        } catch (DaoException e){
        	log.info( e.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return result;
    }

    public Segment search(Segment filter) throws ServiceException {
    	Segment segment = null;

        try {
        	segment = segmentDao.search(filter);
        } catch (DaoException e){
        	log.info( e.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return segment;
    }

    public boolean delete(Segment segment) throws ServiceException {
        boolean result = false;

        try {
        	result = segmentDao.delete(segment);
        } catch (DaoException e){
        	log.info( e.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return result;
    }

    public List<Map<String, Object>> select(Segment segment) throws ServiceException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        try {
        	list = segmentDao.select(segment);
        } catch (DaoException e){
        	log.info( e.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return list;
    }

}