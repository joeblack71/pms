package com.myco.central.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.model.Option;
import com.myco.central.model.User;
import com.myco.central.model.UserMenu;

public class UserDao implements IUserDao {

	public boolean validate(User item) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(User item) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public UserMenu search(User item) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> select(Map<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map<String, Object>> getUserMenus(String idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Option> getUserOptions(String idUser) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
