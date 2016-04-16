package com.myco.central.dao;


import java.util.List;

import com.myco.central.model.Option;
import com.myco.central.model.User;

public interface IAuthenticationDao {

	public boolean authenticateUser(User user);

	/**
	 * TODO: Implement
	 * @param user
	 * @return
	 */
	public List<Option> getUserOptions(String user);

}