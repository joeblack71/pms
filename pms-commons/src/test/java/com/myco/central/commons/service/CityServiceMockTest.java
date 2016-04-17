package com.myco.central.commons.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.commons.dao.CityDao;
import com.myco.central.commons.model.City;
import com.myco.central.commons.service.impl.CityServiceImpl;

public class CityServiceMockTest {

    GenericService<City> cityService;
    @Autowired
    CityDao mockDao;

    @Test
    public void cityInvalidSearch() throws Exception {
        new City();

        //		expect(mockDao.search(city)).andReturn(returnCity);
        //
        //		replay(mockDao);
        //		assertNull("ERROR CITY IS NOT NULL !!", cityService.search(city));
        //		verify(mockDao);

    }

    @Test
    public void cityValidSearch() throws Exception {
        new City();
        new City();

        //		expect(mockDao.search(city)).andReturn(returnCity);
        //
        //		replay(mockDao);
        //		assertNotNull("ERROR CITY NULL !!", cityService.search(city));
        //		verify(mockDao);

    }

    @Before
    public void prepareMock() throws Exception{
        cityService = new CityServiceImpl();
        //		mockDao = createMock(CityDao.class);
    }

}
