package com.myco.central.commons.dao.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myco.central.commons.dao.GenericDao;
import com.myco.central.commons.exceptions.SearchException;

import javassist.bytecode.analysis.Analyzer;

/**
 * This class serves as the Base class for all other DAOs - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * <p/>
 * @param <T> a type variable
 * @param <K> the primary key for that type
 */
public class GenericDaoHibernate<T, K extends Serializable> implements GenericDao<T, K> {
    /**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
	protected final Logger log = LoggerFactory.getLogger(getClass());
    private Class<T> persistentClass;
    @Resource
    private SessionFactory sessionFactory;
    @SuppressWarnings("unused")
    private Analyzer defaultAnalyzer;

    /**
     * Constructor that takes in a class to see which type of entity to persist.
     * Use this constructor when subclassing.
     *
     * @param persistentClass the class type you'd like to persist
     */
    public GenericDaoHibernate(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        //        defaultAnalyzer = new StandardAnalyzer(Version.LUCENE_35);
    }

    /**
     * Constructor that takes in a class and sessionFactory for easy creation of DAO.
     *
     * @param persistentClass the class type you'd like to persist
     * @param sessionFactory  the pre-configured Hibernate SessionFactory
     */
    public GenericDaoHibernate(final Class<T> persistentClass, SessionFactory sessionFactory) {
        this.persistentClass = persistentClass;
        this.sessionFactory = sessionFactory;
        //        defaultAnalyzer = new StandardAnalyzer(Version.LUCENE_35);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean exists(K id) {
        Session sess = getSession();
        IdentifierLoadAccess byId = sess.byId(persistentClass);
        T entity = (T) byId.load(id);
        return entity != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
        Session sess = getSession();
        Query namedQuery = sess.getNamedQuery(queryName);

        for (String s : queryParams.keySet()) {
            namedQuery.setParameter(s, queryParams.get(s));
        }

        return namedQuery.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public T get(K id) {
        Session sess = getSession();
        IdentifierLoadAccess byId = sess.byId(persistentClass);
        T entity = (T) byId.load(id);

        if (entity == null) {
            log.warn("Uh oh, '" + this.persistentClass + "' object with id '" + id + "' not found...");
			// throw new ObjectRetrievalFailureException(this.persistentClass,
			// id);
        }

        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        Session sess = getSession();
        return sess.createCriteria(persistentClass).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> getAllDistinct() {
        Collection<T> result = new LinkedHashSet<T>(getAll());
        return new ArrayList<T>(result);
    }

    public Session getSession() throws HibernateException {
        Session sess = getSessionFactory().getCurrentSession();
        if (sess == null) {
            sess = getSessionFactory().openSession();
        }
        return sess;
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reindex() {
        //        HibernateSearchTools.reindex(persistentClass, getSessionFactory().getCurrentSession());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reindexAll(boolean async) {
        //        HibernateSearchTools.reindexAll(async, getSessionFactory().getCurrentSession());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(K id) {
        Session sess = getSession();
        IdentifierLoadAccess byId = sess.byId(persistentClass);
        @SuppressWarnings("unchecked")
        T entity = (T) byId.load(id);
        sess.delete(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(T object) {
        Session sess = getSession();
        sess.delete(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public T save(T object) {
        Session sess = getSession();
        return (T) sess.merge(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> search(String searchTerm) throws SearchException {
        //        Session sess = getSession();
        //        FullTextSession txtSession = Search.getFullTextSession(sess);
        //
        //        org.apache.lucene.search.Query qry;
        //        try {
        //            qry = HibernateSearchTools.generateQuery(searchTerm, this.persistentClass, sess, defaultAnalyzer);
        //        }
        //        catch (ParseException ex) {
        //            throw new SearchException(ex);
        //        }
        //        org.hibernate.search.FullTextQuery hibQuery = txtSession.createFullTextQuery(qry, this.persistentClass);
        //        return hibQuery.list();
        return null; //TODO implement
    }

	@Override
	public List<T> search(T filter) throws SearchException {
		// TODO implement
		return getAll();
	}

	// @Autowired
	// @Required
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
