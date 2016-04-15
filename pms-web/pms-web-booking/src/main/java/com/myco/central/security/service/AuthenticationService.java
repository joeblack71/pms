package com.myco.central.security.service;

import java.util.List;

import com.myco.central.commons.model.Option;
import com.myco.central.commons.model.User;

public interface AuthenticationService {

	public boolean authenticateUser(User appUser);

	public List<Option> getUserOptions(String user);

}