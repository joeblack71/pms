package com.myco.central.commons.service;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.model.City;
import com.myco.central.commons.service.impl.CityServiceImpl;

import junit.framework.TestCase;

public class CityServiceTest extends TestCase {
    private CityServiceImpl cityService;

    public CityServiceTest(String name) {
        super(name);
        cityService = new CityServiceImpl();
    }

    private City getNewItem() {
        City city = new City();

        city.setId(1l);
        city.setName("LIMA");
        city.setAbbreviation("LIMA");

        return city;
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testDeleteCity() {
        City city = getNewItem();
        boolean result = false;

        try {
            city.setId(1l);
            cityService.remove(city);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        assertNotNull("FAIL_DELETE", result);
    }

    public void testGetItemCity() {
        City city = getNewItem();

        try {
            city.setId(1l);
            //			city = cityService.getItem(city);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        assertNotNull("FAIL_SELECT", city);
    }

    public void testInsertCity() {
        City city = getNewItem();

        String id = null;
            try {
				cityService.save(city);
			} catch (ServiceException e) {
				e.printStackTrace();
			}

        assertNotNull("fail insert", id);
    }

    public void testListString() {
        try {
            //			list = cityService.list(null);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        //		assertNotNull(TestConstantsMessages.FAIL_SELECT_LIST, list);
    }

    /////////////////////
    /// Private interface
    /////////////////////

    public void testUpdateCity() {
        City city = getNewItem();
        boolean result = false;

        try {
            city.setId(1l);
            cityService.update(city);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        assertTrue("FAIL_UPDATE", result);
    }

}
