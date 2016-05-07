package com.myco.central.commons.dao.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.myco.central.commons.dao.hibernate.CountryDaoHibernate;
import com.myco.central.commons.model.Country;

public class CountryDaoJpaTest {

	private static CountryDaoHibernate dao;
	private static final Country FAKE_COUNTRY;
	private Country country;

	static {
		FAKE_COUNTRY = new Country("TEST_COUNTRY", "TEST");
		FAKE_COUNTRY.setCreated(LocalDateTime.now());
		FAKE_COUNTRY.setCreatedBy("PMS");
		FAKE_COUNTRY.setLastUpdate(LocalDateTime.now());
		FAKE_COUNTRY.setUpdatedBy("PMS");
		FAKE_COUNTRY.setStatus("A");
	}

	@BeforeClass
	public static void setupClass() throws Exception {
		dao = new CountryDaoHibernate();
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		dao.releaseEntityManager();
	}

	@Before
	public void setup() {
		country = getNewCountry();
	}

	@After
	public void tearDown() {
		country = null;
	}

	@Test
	public void find() {
		country = dao.find(1l);
		assertNotNull(country);
		assertEquals("PERU", country.getName());
	}

	@Test
	public void findAll() {
		List<Country> result = dao.getAll();
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

	@Test
	public void save() {
		country = getNewCountry("NewCountry", "NC");
		dao.save(country);
		assertNotNull(country.getId());
	}

	@Test
	public void update() {
		modifyCountry(country);
		dao.update(country);
		assertEquals("Updated country", country.getDescription());
	}

	private static Country getNewCountry() {
		return getNewCountry("DefaultCountry", "abv");
	}

	private static Country getNewCountry(String name, String abbr) {
		Country country = new Country(name, abbr);
		country.setDescription("New country..");
		country.setCreated(LocalDateTime.now());
		country.setCreatedBy("PMS");
		country.setLastUpdate(LocalDateTime.now());
		country.setUpdatedBy("PMS");
		country.setStatus("A");
		return country;
	}

	private static void modifyCountry(Country country) {
		country.setDescription("Updated country");
		country.setLastUpdate(country.getCreated());
		country.setUpdatedBy(country.getCreatedBy());
		country.setStatus("A");
	}

}
