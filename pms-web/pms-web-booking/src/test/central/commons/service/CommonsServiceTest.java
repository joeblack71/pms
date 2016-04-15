package com.myco.central.commons.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.util.Messages;

public class CommonsServiceTest extends AbstractCommonsBaseTest {

	@Autowired
	private CommonsService commonsService;

	@Test
	public void getHotels() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void getRoomTypes() throws Exception {
		List<Map<String, Object>> list = null;

		try {
			list = commonsService.getRoomTypes(null);
		
		} catch (Exception ex) {
			fail(Messages.getString("test.error.unexpected_exception"));
		}
		
		assertTrue(Messages.getString("test.error.no_records"), list.size() > 0);
	}

	@Test
	public void getRoomNumbers() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void getPeriodTypes() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void getPaymentTypes() throws Exception {
		fail("Not yet implemented");
	}

	/*public static TestSuite suite() {
		TestSuite suite = new TestSuite();

		suite.addTest( new CommonsServiceTest("GetRoomTypes") );

		return suite ;
	}*/

}

