package com.myco.central.commons.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

import com.myco.central.commons.model.Country;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"persistence.xml","pms-commons-data-test.xml"})
public class CountryDaoHibernateTest {
	private SessionFactory sessionFactory;

	// @Autowired @Qualifier(value="pentho.commons.countryDao") CountryDao dao;
	
	public void setup() throws Exception {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	@Test
	public void addCountry() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new Country("Perú", "PER"));
		session.save(new Country("Argentina", "ARG"));
		session.getTransaction().commit();
		session.close();
	}

	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getCountries() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List result = session.createQuery("from Country").list();
		for (Country country : (List<Country>) result) {
			System.out.println(country);
		}
		session.getTransaction().commit();
		session.close();
	}
}
