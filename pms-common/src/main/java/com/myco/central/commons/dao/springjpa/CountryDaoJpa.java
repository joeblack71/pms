package com.myco.central.commons.dao.springjpa;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.model.Country;

public class CountryDaoJpa {
	// private static final Log LOGGER =
	// LogFactory.getLogger(CountryDaoJpa.class);

	public void createCountry(Country country) {
		EntityManager em = ConnectionFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(country);
		em.getTransaction().commit();
		em.close();
		ConnectionFactory.closeEntityManager();
	}

	public Country findCountry(Long pk) {
		EntityManager em = ConnectionFactory.getEntityManager();
		Country country = em.find(Country.class, pk);
		em.close();
		ConnectionFactory.closeEntityManager();
		return country;
	}

	public void updateCountry(Country country) {
		EntityManager em = ConnectionFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(country);
		em.getTransaction().commit();
		em.close();
		ConnectionFactory.closeEntityManager();
	}

	public List<Country> getAll() throws DaoException {
		EntityManager em = ConnectionFactory.getEntityManager();
		
		em.getTransaction().begin();
		
//		List<Country> list = em.createQuery("select c from Country c").getResultList();
		CriteriaQuery<Country> cq = em.getCriteriaBuilder().createQuery(Country.class);
		List<Country> list = null;
		if (cq != null) {
			Root<Country> country = cq.from(Country.class);
			cq.select(country);
			TypedQuery<Country> q = em.createQuery(cq);
			list = q.getResultList();
		}
		
		em.getTransaction().commit();
		em.close();
		return list;
	}
	
	public static void main(String []args) {
		CountryDaoJpa dao = new CountryDaoJpa();
		dao.createCountry(getNewCountry());
		// Country foundedCountry = dao.findCountry(1l);
		// System.out.println(foundedCountry);
		// dao.updateCountry(getUpdatedCountry(foundedCountry));

		// CountryDaoJpa jpa = new CountryDaoJpa();
		// try {
		// jpa.getAll();
		// } catch (DaoException e) {
		// LOGGER.info(e);
		// }
	}

	private static Country getNewCountry() {
		Country country = new Country("NewCountry2", "CTR");
		country.setCreated(LocalDateTime.now());
		country.setCreatedBy("PMS");
		country.setLastUpdate(LocalDateTime.now());
		country.setUpdatedBy("PMS");
		country.setStatus("A");
		return country;
	}

	private static Country getUpdatedCountry(Country country) {
		Country updatedCountry = new Country();
		// BeanUtils.copyProperties(country, updatedCountry);
		updatedCountry.setLastUpdate(country.getCreated());
		updatedCountry.setUpdatedBy(country.getCreatedBy());
		updatedCountry.setStatus("A");
		return updatedCountry;
	}

}
