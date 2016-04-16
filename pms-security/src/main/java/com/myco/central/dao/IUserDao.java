package com.myco.central.dao;

import java.util.List;
import java.util.Map;

import com.myco.central.model.Option;
import com.myco.central.model.User;
import com.myco.central.model.UserMenu;

public interface IUserDao extends IGenericDao {

	public boolean validate(User item) throws Exception;

	public boolean delete(User item) throws Exception;

	public UserMenu search(User item) throws Exception;

	public List<User> select(Map<String, Object> params) throws Exception;

	/** TODO: Recuperar los menus autorizados para el usuario  */
	public List<Map<String, Object>> getUserMenus(String idUser);

	public List<Option> getUserOptions(String idUser) throws Exception;

}