package com.myco.central.commons.dao.hibernate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myco.central.commons.dao.CountryDao;
import com.myco.central.commons.model.Country;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"persistence.xml","pms-commons-data-test.xml"})
public class CountryDaoHibernateTest {

	@Autowired @Qualifier(value="pentho.commons.countryDao") CountryDao dao;
	
	@Test
	public void test() {
		Country filter = new Country();
		dao.search(filter);
	}

}
