package com.myco.central.security.service.impl;

import java.util.List;

import com.myco.central.commons.model.Option;
import com.myco.central.commons.model.User;
import com.myco.central.security.dao.AuthenticationDao;
import com.myco.central.security.dao.jdbc.AuthenticationDaoJdbc;
import com.myco.central.security.service.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService {
	private final AuthenticationDao authenticationDao = new AuthenticationDaoJdbc();
	
	public AuthenticationServiceImpl() {}

	public boolean authenticateUser(User user) {
		boolean result = false;
		
		try {
			result = authenticationDao.authenticateUser(user);
		} catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<Option> getUserOptions(String user) {
		List<Option> list = null;
		
		try {
			authenticationDao.getUserOptions(user);
		} catch(Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
