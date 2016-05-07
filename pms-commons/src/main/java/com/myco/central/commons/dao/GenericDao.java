/**
 *
 */
package com.myco.central.commons.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Extend this interface if you want typesafe (no casting necessary) DAO's for
 * your domain objects.
 *
 * @param <T>
 *            a type variable
 * @param <K>
 *            the primary key for that type
 */
public interface GenericDao<T, K extends Serializable> {

    /**
     * Checks for existence of an object of type T using the id arg.
     * @param id the id of the entity
     * @return - true if it exists, false if it doesn't
     */
	T find(K id);

	List<T> getAll();

	List<T> getAll(String pattern);

	void releaseEntityManager();

	void remove(T type);

	void save(T type);

	void update(T type);
}