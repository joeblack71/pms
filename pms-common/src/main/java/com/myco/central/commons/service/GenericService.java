package com.myco.central.commons.service;

import java.util.List;

import com.myco.central.commons.exceptions.ServiceException;

public interface GenericService<T> {
	T get(Long id) throws ServiceException;

	List<T> getAll() throws ServiceException;

	void remove(Long id) throws ServiceException;

	void remove(T t) throws ServiceException;

	void save(T t) throws ServiceException;

	List<T> search(String pattern) throws ServiceException;

	List<T> search(T t) throws ServiceException;

	void update(T t) throws ServiceException;

}