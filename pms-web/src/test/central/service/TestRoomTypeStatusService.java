package reservations.service;

import java.util.List;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.model.RoomTypeStatus;
import com.myco.central.reservations.service.RoomTypeStatusService;
import com.myco.central.reservations.service.RoomTypeStatusServiceImpl;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestRoomTypeStatusService extends TestCase {
	private RoomTypeStatusService roomTypeStatusService;

	public TestRoomTypeStatusService(String name) {
		super(name);
		roomTypeStatusService = new RoomTypeStatusServiceImpl();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testInsertRoomTypeStatus() {
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

		try {
			result = roomTypeStatusService.insert(rts);
		} catch (ServiceException ex) {
			fail();
		}
		
		assertNotNull(result);
		
	}

	public void testList() {
		List<RoomTypeStatus> list = null;
		RoomTypeStatus rts = new RoomTypeStatus();

		try {
			rts.setIdHotel("1");
			rts.setIdRoomType("1");
			rts.setStatusDay("2009-01-08");

			list = roomTypeStatusService.list(rts);
		} catch (ServiceException ex) {
			fail();
		}
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

	public static TestSuite suite() {
		TestSuite suite = new TestSuite();

		suite .addTest( new TestRoomTypeStatusService("testList") );

		return suite;
	}

}
