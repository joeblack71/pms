package reservations.service;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.myco.central.constants.TestConstantsMessages;
import com.myco.central.model.City;
import com.myco.central.reservations.service.CityService;
import com.myco.central.reservations.service.impl.CityServiceImpl;

import junit.framework.TestCase;

public class TestCityService extends TestCase {
	private CityService cityService;
	private static String idCity;

	public TestCityService(String name) {
		super(name);
		cityService = new CityServiceImpl();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testInsertCity() {
		City city = getNewItem();
		
		try {
			idCity = cityService.insert(city);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_INSERT, idCity);
	}

	public void testUpdateCity() {
		City city = getNewItem();
		boolean result = false;
		
		try {
			city.setIdCity(idCity);
			result = cityService.update(city);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue(TestConstantsMessages.FAIL_UPDATE, result);
	}

	public void testGetItemCity() {
		City city = getNewItem();
		
		try {
			city.setIdCity(idCity);
			city = cityService.getItem(city);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_SELECT, city);
	}

	public void testDeleteCity() {
		City city = getNewItem();
		boolean result = false;
		
		try {
			city.setIdCity(idCity);
			result = cityService.delete(city);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_DELETE, result);
	}

	public void testListString() {
		String idCountry = "01";
		List<DynaBean> list = null;
		
		try {
			list = cityService.list(null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_SELECT_LIST, list);
	}

	/////////////////////
	/// Private interface
	/////////////////////
	
	private City getNewItem() {
		City city = new City();

		city.setIdCountry("01");
		city.setCityDescription("LIMA");
		city.setAbbreviation("LIMA");

		return city ;
	}

}
