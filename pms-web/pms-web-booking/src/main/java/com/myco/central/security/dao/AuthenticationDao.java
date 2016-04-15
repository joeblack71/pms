package com.myco.central.security.dao;


import java.util.List;

import com.myco.central.commons.model.Option;
import com.myco.central.commons.model.User;

public interface AuthenticationDao {

	public boolean authenticateUser(User user);

	/**
	 * TODO: Implement
	 * @param user
	 * @return
	 */
	public List<Option> getUserOptions(String user);

}