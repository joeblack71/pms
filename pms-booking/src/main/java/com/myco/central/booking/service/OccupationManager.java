/**
 *
 */
package com.myco.central.booking.service;

import com.myco.central.commons.exceptions.ServiceException;

import java.util.Map;

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
	boolean checkAvailability(Map<String, Object> params)
			throws ServiceException;

	/**
	 * TODO
	 * @param params
	 * @return
	 * @throws ServiceException
	 */
	boolean checkOccupation(Map<String, Object> params)
			throws ServiceException;

	/**
	 * TODO
	 * @param params
	 * @return
	 * @throws ServiceException
	 */
	boolean updateOccupation(Map<String, Object> params)
			throws ServiceException;

}
