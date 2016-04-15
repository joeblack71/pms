package com.myco.central.commons.service;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.model.User;
import com.myco.central.commons.model.UserMenu;

public interface UserService extends GenericService {

	public boolean remove(User user) throws Exception;

	public boolean validate(User user) throws Exception;

	public UserMenu getUserMenu(User user) throws Exception;

	public List<Map<String, Object>> getUserOptions(String idUser) throws Exception;

}