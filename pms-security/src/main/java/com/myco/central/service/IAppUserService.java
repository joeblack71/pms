package com.myco.central.service;

import java.sql.Connection;
import java.util.List;

import com.myco.central.model.AppUser;
import com.myco.central.model.UserMenu;

public interface IAppUserService {

	public boolean remove(AppUser au) throws Exception;

	public boolean validate(AppUser au) throws Exception;

	public UserMenu getUserMenu(AppUser user) throws Exception;

	public List getUserMenus(Connection con, String idUser)
			throws Exception;

	public UserMenu chargeMenuOptions(Connection con, String idUser,
			UserMenu menu) throws Exception;

}