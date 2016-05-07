/**
 *
 */
package com.myco.central.commons.dao.hibernate;

import com.myco.central.commons.exceptions.SearchException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Extend this interface if you want typesafe (no casting necessary) DAO's for your
 * domain objects.
 *
 * @param <T> a type variable
 * @param <K> the primary key for that type
 */
public interface OldGenericDao<T, K extends Serializable> {

    /**
     * Checks for existence of an object of type T using the id arg.
     * @param id the id of the entity
     * @return - true if it exists, false if it doesn't
     */
    boolean exists(K id);

    /**
     * Find a list of records by using a named query
     * @param queryName query name of the named query
     * @param queryParams a map of the query names and the values
     * @return a list of the records found
     */
    List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams);

    /**
     * Generic method to get an object based on class and identifier. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if
     * nothing is found.
     *
     * @param id the identifier (primary key) of the object to get
     * @return a populated object
     * @see org.springframework.orm.ObjectRetrievalFailureException
     */
    T get(K id);

    /**
     * Generic method used to get all objects of a particular type. This
     * is the same as lookup up all rows in a table.
     * @return List of populated objects
     */
    List<T> getAll();

    /**
     * Gets all records without duplicates.
     * <p>Note that if you use this method, it is imperative that your model
     * classes correctly implement the hashcode/equals methods</p>
     * @return List of populated objects
     */
    List<T> getAllDistinct();

    /**
     * Generic method to regenerate full text index of the persistent class T
     */
    void reindex();

    /**
     * Generic method to regenerate full text index of all indexed classes
     * @param async true to perform the reindexing asynchronously
     */
    void reindexAll(boolean async);

    /**
     * Generic method to delete an object
     * @param id the identifier (primary key) of the object to remove
     */
    void remove(K id);

    /**
     * Generic method to delete an object
     * @param object the object to remove
     */
    void remove(T object);

    /**
     * Generic method to save an object - handles both update and insert.
     * @param object the object to save
     * @return the persisted object
     */
    T save(T object);

    /**
     * Gets all records that match a search term. "*" will get them all.
     * @param searchTerm the term to search for
     * @return the matching records
     * @throws SearchException
     */
    List<T> search(String searchTerm) throws SearchException;

    /**
     * Gets all records that match the filter.
     * @param filter
     * @return
     * @throws SearchException
     */
    List<T> search(T filter) throws SearchException;
}