package com.myco.central.service;

import java.util.List;

import com.myco.central.model.Option;
import com.myco.central.model.User;

public interface IAuthenticationService {

	public boolean authenticateUser(User appUser);

	public List<Option> getUserOptions(String user);

}	