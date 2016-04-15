package com.myco.central.reservations.service;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.reservations.dao.RoomTypeStatusDao;
import com.myco.central.reservations.domain.RoomTypeStatus;
import com.myco.central.util.MockFactoryCentralTest;

public class RoomTypeStatusServiceTest extends AbstractCentralBaseTest {
	@Autowired
	private RoomTypeStatusService roomTypeStatusService;

	@Ignore
	public void InsertRoomTypeStatus() {
		RoomTypeStatus rts = new RoomTypeStatus();

		String result = null;

		rts.setIdHotel("1");
		rts.setIdRoomType("1");
		rts.setStatusDay("15/02/2009");
		rts.setReservationType("I");

		rts.setTotalRooms("10");

		rts.setConfirmedRooms("1");
		rts.setLockedRooms("0");
		rts.setMaintenanceRooms("0");
		rts.setTentativeRooms("0");

		rts.setAvailableRooms("-1");

		/*try {
			result = roomTypeStatusService.insert(rts);
		} catch (ServiceException ex) {
			fail();
		}*/
		
		assertNotNull(result);
		
	}

	@Ignore
	public void select() {
		List<RoomTypeStatus> list = null;
		RoomTypeStatus rts = new RoomTypeStatus();

		/*try {
			rts.setIdHotel("1");
			rts.setIdRoomType("1");
			rts.setStatusDay("2009-01-08");

			list = roomTypeStatusService.select(rts);
		} catch (ServiceException ex) {
			fail();
		}*/
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

	@Test
	public void verifyAvailability() throws Exception{
		boolean result = false;

		List<Map<String, Object>> list = MockFactoryCentralTest.retrieveReservationsData(null);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("roomType", "MT");
		map.put("fromDate", new Date());
		map.put("toDate", new Date());

		//mock impl.
		RoomTypeStatusDao mockDao = createMock(RoomTypeStatusDao.class);
		expect(mockDao.verifyAvailability(map)).andReturn(list);
		replay(mockDao);
		// end mock impl.

		try {
			result = roomTypeStatusService.verifyAvailability(map);
		} catch (Exception ex) {
			fail("Exception");
		}
		
		assertTrue("There isn't availability rooms :(",result);
	}
	
	/*public static TestSuite suite() {
		TestSuite suite = new TestSuite();

		suite.addTest( new RoomTypeStatusServiceTest("List") );

		return suite;
	}*/

}
