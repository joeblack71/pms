package com.myco.central.service.impl;

import java.util.List;

import com.myco.central.dao.AuthenticationDaoJdbc;
import com.myco.central.dao.IAuthenticationDao;
import com.myco.central.model.Option;
import com.myco.central.model.User;
import com.myco.central.service.IAuthenticationService;

public class AuthenticationServiceImpl implements IAuthenticationService {
	private final IAuthenticationDao authenticationDao = new AuthenticationDaoJdbc();
	
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
