package com.myco.central.commons.dao.springjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class ConnectionFactory {
	private static EntityManagerFactory entityManagerFactory;

	private ConnectionFactory() {}
	
	public static EntityManager getEntityManager(){
		if (entityManagerFactory == null){
			entityManagerFactory = Persistence.createEntityManagerFactory("pmspu");
		}
		return entityManagerFactory.createEntityManager();
	}

	public static void closeEntityManager() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
	}
}