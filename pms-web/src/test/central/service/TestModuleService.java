package reservations.service;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.model.ContextAttributes;
import com.myco.central.reservations.service.ModuleService;
import com.myco.central.reservations.service.impl.ModuleServiceImpl;

import servletunit.struts.MockStrutsTestCase;

public class TestModuleService extends MockStrutsTestCase {
	private ModuleService moduleService;

	public TestModuleService(String name) {
		super(name);
		moduleService = new ModuleServiceImpl();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetContextAttributes() {
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
		assertTrue(ca.getVipStatusList().size() > 0);
		assertTrue(ca.getSourceTypes().size() > 0);
		assertTrue(ca.getSegments().size() > 0);
		assertTrue(ca.getSpecialRates().size() > 0);
		//System.out.println("size:"+ca.getSpecialRates().size());
	}

}
