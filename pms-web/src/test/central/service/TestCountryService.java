package reservations.service;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.myco.central.model.Country;
import com.myco.central.reservations.service.CountryService;
import com.myco.central.reservations.service.impl.CountryServiceImpl;

import junit.framework.TestCase;

public class TestCountryService extends TestCase {
	private CountryService countryService;
	private static String idCountry;

	public TestCountryService(String name) {
		super(name);
		countryService = new CountryServiceImpl();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testInsertCountry() {
		Country country = getNewItem();

		try {
			idCountry = countryService.insert(country);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull("*** No se inserto registro ***", idCountry);
	}

	public void testUpdateCountry() {
		Country country = getNewItem();
		boolean result = false;

		try {
			country.setIdCountry(idCountry);
			result = countryService.update(country);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull("*** No se inserto registro ***", result);
	}

	public void testGetItemCountry() {
		Country country = getNewItem();

		try {
			country = countryService.getItem(country);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull("*** No se recupero registro ***", country);
	}

	public void testDeleteCountry() {
		Country country = getNewItem();
		boolean result = false;

		try {
			country.setIdCountry(idCountry);
			result = countryService.delete(country);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue("*** No se elimino registro ***", result);
	}

	public void testListString() {
		List<DynaBean> list = null;
		Country filter = new Country();

		try {
			list = countryService.list(filter);
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

		country.setAbbreviation("test");
		country.setCountryName("Testing");
		country.setNationality("N_testing");

		return country;
	}

}
