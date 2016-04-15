package com.myco.central.commons.service;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.util.ContextAttributes;

public interface ModuleService {

	public ContextAttributes getContextAttributes() throws ServiceException;

}