package com.myco.central.commons.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.myco.central.commons.model.Country;

public class CountryDaoJpaTest {

	private EntityManagerFactory entityManagerFactory;

	public void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("pmspu");
	}

	@Test
	public void save() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(new Country("Test1", "t1"));
		em.persist(new Country("Test2", "t2"));
		em.getTransaction().commit();
		em.close();
	}

}
