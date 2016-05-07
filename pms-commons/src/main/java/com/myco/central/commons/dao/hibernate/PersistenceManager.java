package com.myco.central.commons.dao.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum PersistenceManager {
	INSTANCE;
	EntityManagerFactory emf;

	private PersistenceManager() {
		emf = Persistence.createEntityManagerFactory("pmspu");
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void close() {
		emf.close();
	}

}
