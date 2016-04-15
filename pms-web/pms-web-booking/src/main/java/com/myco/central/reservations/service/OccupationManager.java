/**
 * 
 */
package com.myco.central.reservations.service;

import java.util.Map;

import com.myco.central.commons.exceptions.ServiceException;

/**
 * @author Devel
 *
 */
public interface OccupationManager {

	/**
	 * TODO
	 * @param params
	 * @return
	 * @throws ServiceException
	 */
	public boolean checkAvailability(Map<String, Object> params) 
		throws ServiceException;

	/**
	 * TODO
	 * @param params
	 * @return
	 * @throws ServiceException
	 */
	public boolean checkOccupation(Map<String, Object> params) 
		throws ServiceException;

	/**
	 * TODO
	 * @param params
	 * @return
	 * @throws ServiceException
	 */
	public boolean updateOccupation(Map<String, Object> params) 
	throws ServiceException;

}
