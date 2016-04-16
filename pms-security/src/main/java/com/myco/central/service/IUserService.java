package com.myco.central.service;

import java.util.List;
import java.util.Map;

import com.myco.central.model.User;
import com.myco.central.model.UserMenu;

public interface IUserService {

	public boolean remove(User user) throws Exception;

	public boolean validate(User user) throws Exception;

	public UserMenu getUserMenu(User user) throws Exception;

	public List<Map<String, Object>> getUserOptions(String idUser) throws Exception;

}