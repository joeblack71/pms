package com.myco.central.commons.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.commons.model.Country;
import com.myco.central.util.Messages;

public class CountryServiceTest extends AbstractCommonsBaseTest {
	
	@Autowired
	private CountryService countryService;
	
	private Country country = getNewItem();

	@Test
	public void registerCountry() {
		String result = null;
		
		try {
			result = countryService.insert(country);
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(Messages.getString(""), result);
	}

	@Test
	public void updateCountry() {
		boolean result = false;

		try {
			country.setIdCountry(null);
			
			result = countryService.update(country);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull("*** No se inserto registro ***", result);
	}

	@Test
	public void searchCountry() {

		try {
			country = countryService.search(country);
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull("*** No se recupero registro ***", country);
	}

	@Test
	public void disableCountry() {
		boolean result = false;

		try {
			country.setIdCountry(null);

			result = countryService.delete(country);
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue("*** No se elimino registro ***", result);
	}

	@Test
	public void reportCountry() {
		List<Map<String, Object>> list = null;
		
		Country filter = new Country();

		try {
			list = countryService.select(filter);
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull("*** No se recuperaron registros ***", list);
	}

	/////////////////////
	/// Private interface
	/////////////////////

	private Country getNewItem() {
		Country country = new Country();

		country.setAbbreviation("");
		country.setCountryName("Testing");
		country.setNationality("N_ing");

		return country;
	}

}
