package com.myco.central.commons.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.commons.model.Option;
import com.myco.central.commons.model.User;
import com.myco.central.commons.model.UserMenu;

public interface UserDao extends GenericDao {

	public boolean validate(User item) throws Exception;

	public boolean delete(User item) throws Exception;

	public UserMenu search(User item) throws Exception;

	public List<User> select(Map<String, Object> params) throws Exception;

	/** TODO: Recuperar los menus autorizados para el usuario  */
	public List<Map<String, Object>> getUserMenus(String idUser);

	public List<Option> getUserOptions(String idUser) throws Exception;

}