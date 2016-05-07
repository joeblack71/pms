package com.myco.central.commons.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myco.central.commons.dao.GenericDao;

/**
 * This class serves as the Base class for all other DAOs - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * 
 * @param <T>
 *            a type variable
 * @param <K>
 *            the primary key for that type
 */
public class GenericDaoHibernate<T, K extends Serializable> implements GenericDao<T, K> {
    /**
	 * Log variable for all child classes.
	 */
	protected final Logger logger = LoggerFactory.getLogger(getClass());

    private Class<T> persistentClass;

	private final EntityManager entityManager = PersistenceManager.INSTANCE.getEntityManager();

	/**
	 * Constructor that takes in a class to see which type of entity to persist.
	 * Use this constructor when subclassing.
	 *
	 * @param persistentClass
	 *            the class type you'd like to persist
	 */
    public GenericDaoHibernate(final Class<T> persistentClass) {
        this.setPersistentClass(persistentClass);
    }

    @Override
	public T find(K id) {
		T persistedClass = entityManager.find(persistentClass, id);
		return persistedClass;
	}

	@Override
	public List<T> getAll() {
		CriteriaQuery<T> criteria = entityManager.getCriteriaBuilder().createQuery(persistentClass);
		criteria.select(criteria.from(persistentClass));
		return entityManager.createQuery(criteria).getResultList();
	}

	@Override
	public List<T> getAll(String pattern) {
		// TODO Auto-generated method stub
		return getAll();
	}

	@Override
	public void remove(T type) {
		entityManager.getTransaction().begin();
		entityManager.remove(type);
		entityManager.getTransaction().commit();
	}

	@Override
	public void save(T type) {
		entityManager.getTransaction().begin();
		entityManager.persist(type);
		entityManager.getTransaction().commit();
	}

	@Override
	public void update(T type) {
		entityManager.getTransaction().begin();
		entityManager.merge(type);
		entityManager.getTransaction().commit();
	}

	@Override
	public void releaseEntityManager() {
		entityManager.close();
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

}
