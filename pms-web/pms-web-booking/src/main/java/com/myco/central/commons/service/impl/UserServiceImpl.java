
package com.myco.central.commons.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.UserDao;
import com.myco.central.commons.model.User;
import com.myco.central.commons.model.UserMenu;
import com.myco.central.commons.service.UserService;


public class UserServiceImpl extends GenericServiceImpl implements UserService {
	private UserDao userDao;

    public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserServiceImpl() {
    }

    public boolean remove(User user) throws Exception {
        boolean result = false;

        try {
        	userDao.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }

        return result;
    }

    public boolean validate(User au) throws Exception {
        boolean result = false;

        try {
        	userDao.validate(au);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
        
        return result;
    }

    public List<User> select(java.util.Map<String, Object> params) throws Exception {
    	List<User> list = null;

        try {
        	list = userDao.select(params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }

        return list;
    }

    public UserMenu getUserMenu(User user) throws Exception {
    	UserMenu userMenu = null;

        try {
        	userMenu = userDao.search(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }

        return userMenu;
    }
    
    public List<Map<String, Object>> getUserOptions(String idUser)
    	throws Exception {
    	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    	
        try {
        	list = userDao.getUserMenus(idUser);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }

        return list;
    }

}