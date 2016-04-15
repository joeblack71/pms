package reservations.service;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.myco.central.reservations.service.CommonsService;
import com.myco.central.reservations.service.impl.CommonsServiceImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestCommonsService extends TestCase {

	private CommonsService commonsService;

	public TestCommonsService(String name) {
		super(name);
		commonsService = new CommonsServiceImpl(); 
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetHotels() {
		fail("Not yet implemented");
	}

	public void testGetRoomTypes() {
		List<DynaBean> list = null;

		try {
			list = commonsService.getRoomTypes("1");
		} catch (Exception ex) {
			fail();
		}
		
		assertTrue(list.size() > 0);
	}

	public void testGetRoomNumbers() {
		fail("Not yet implemented");
	}

	public void testGetPeriodTypes() {
		fail("Not yet implemented");
	}

	public void testGetPaymentTypes() {
		fail("Not yet implemented");
	}

	public static TestSuite suite() {
		TestSuite suite = new TestSuite();

		suite.addTest( new TestCommonsService("testGetRoomTypes") );

		return suite ;
	}

}

