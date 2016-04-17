package com.myco.central.commons.dao.hibernate;

import com.myco.central.commons.model.Catalog;

public class CatalogDaoHibernate extends GenericDaoHibernate<Catalog, Long> {

	public CatalogDaoHibernate(Class<Catalog> catalog) {
		super(catalog);
	}

}
