package com.myco.central.commons.dao.hibernate;

import com.myco.central.commons.model.DataCatalog;

public class DataCatalogDaoHibernate extends OldGenericDaoHibernate<DataCatalog, Long> {

	public DataCatalogDaoHibernate(Class<DataCatalog> dataCatalog) {
		super(dataCatalog);
	}

}
