package com.myco.central.reservations.service.mock;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import org.junit.Before;
import org.junit.Test;

import com.myco.central.commons.dao.CityDao;
import com.myco.central.commons.model.City;
import com.myco.central.commons.service.impl.CityServiceImpl;

public class CityServiceMockTest {

	CityServiceImpl cityService;
	CityDao mockDao;

	@Before
	public void prepareMock() throws Exception{
		cityService = new CityServiceImpl();
		mockDao = createMock(CityDao.class);		
		
		cityService.setCityDao(mockDao);
	}

	@Test
	public void cityValidSearch() throws Exception {
		City city = new City();		
		City returnCity = new City();		

		expect(mockDao.search(city)).andReturn(returnCity);

		replay(mockDao);
		assertNotNull("ERROR CITY NULL !!", cityService.search(city));
		verify(mockDao);
		
	}

	@Test
	public void cityInvalidSearch() throws Exception {
		City city = new City();		
		City returnCity = null;		

		expect(mockDao.search(city)).andReturn(returnCity);

		replay(mockDao);
		assertNull("ERROR CITY IS NOT NULL !!", cityService.search(city));
		verify(mockDao);
		
	}

}
