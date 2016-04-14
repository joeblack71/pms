package reservations.service;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.reservations.service.AvailabilityService;
import com.myco.central.reservations.service.impl.AvailabilityServiceImpl;

import junit.framework.TestCase;

public class TestAvailabilityService extends TestCase {
	private AvailabilityService availabilityService;

	public TestAvailabilityService(String name) {
		super(name);
		availabilityService = new AvailabilityServiceImpl();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

/*
	public void testChargeOccupationByType() {
		fail("Not yet implemented");
	}

	public void testChargeOccupationOnStay() {
		fail("Not yet implemented");
	}
*/

	public void testGetFlashStatus() {
		List<DynaBean> list = null;

		try {
			list = availabilityService.listFlashStatus("1", "1", "01/01/2009");
		} catch (ServiceException ex) {
			fail();
		}
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

}
