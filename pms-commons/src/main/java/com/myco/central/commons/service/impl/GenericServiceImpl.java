package com.myco.central.commons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.commons.dao.GenericDao;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.GenericService;

public abstract class GenericServiceImpl<T> implements GenericService<T> {

	@Autowired
	private GenericDao<T,Long> dao;
	
	@Override
	public T get(Long id) throws ServiceException {
		return dao.get(id);
	}

	@Override
	public List<T> getAll() throws ServiceException {
		return dao.getAll();
	}

	@Override
	public void save(T t) throws ServiceException {
		dao.save(t);
	}

	@Override
	public void remove(T t) throws ServiceException {
		dao.remove(t);
	}

	@Override
	public void remove(Long id) throws ServiceException {
		dao.remove(id);
	}

	@Override
	public List<T> search(T t) throws ServiceException {
		return dao.search(t);
	}

	@Override
	public List<T> search(String pattern) throws ServiceException {
		return dao.search(pattern);
	}

	@Override
	public void update(T t) throws ServiceException {
		dao.save(t);
	}

}
