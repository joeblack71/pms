package com.myco.central.commons.dao.hibernate;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.myco.central.commons.dao.CountryDao;
import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.model.Country;

public class CountryDaoHibernate extends GenericDaoHibernate<Country, Long> implements CountryDao {

	public CountryDaoHibernate() {
		super(Country.class);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Country> getAll(final Map<String, Object> filter) throws DaoException {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery cq = cb.createQuery(Country.class);
		Root country = cq.from(Country.class);
		cq.select(country);
		Query q = getEntityManager().createQuery(cq);
		List list = q.getResultList();
		getEntityManager().close();

		return list;
	}

}
