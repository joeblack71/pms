package com.myco.central.commons.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.ModuleService;
import com.myco.central.reservations.service.AbstractCentralBaseTest;
import com.myco.central.util.ContextAttributes;

public class ModuleServiceTest extends AbstractCentralBaseTest {
	
	@Autowired
	private ModuleService moduleService;

	@Test
	public void loadContextAttributes() {
		ContextAttributes ca = null;

		try {
			ca = moduleService.getContextAttributes();
		
		} catch (ServiceException ex) {
			ex.printStackTrace();
		}

		//assertTrue(ca.getHotels().size() > 0);
		assertTrue(ca.getCities().size() > 0);
		assertTrue(ca.getCountries().size() > 0);
		assertTrue(ca.getDocumentTypes().size() > 0);
		assertTrue(ca.getTitles().size() > 0);
		assertTrue(ca.getVipStatusselect().size() > 0);
		assertTrue(ca.getSourceTypes().size() > 0);
		assertTrue(ca.getSegments().size() > 0);
		assertTrue(ca.getSpecialRates().size() > 0);
		//System.out.println("size:"+ca.getSpecialRates().size());
	}

}
