package com.myco.central.commons.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.web.util.ContextAttributes;
import com.myco.central.web.util.ModuleServiceImpl;
import com.myco.central.web.utils.AbstractWebBaseTest;

public class ModuleServiceTest extends AbstractWebBaseTest {
	
	@Autowired
	private ModuleServiceImpl moduleService;

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
