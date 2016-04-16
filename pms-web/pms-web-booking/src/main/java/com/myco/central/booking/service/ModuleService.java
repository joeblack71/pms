package com.myco.central.web.util;

import com.myco.central.commons.exceptions.ServiceException;

public interface ModuleService {

	ContextAttributes getContextAttributes() throws ServiceException;

}