package com.myco.central.booking.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.booking.dto.AvailabilityFilterDto;
import com.myco.central.booking.model.RoomTypeStatus;
import com.myco.central.booking.utils.AbstractBookingBaseTest;

public class RoomTypeStatusServiceTest extends AbstractBookingBaseTest {
	@Autowired
	private RoomTypeStatusService roomTypeStatusService;

	@Ignore
	public void insertRoomTypeStatus() throws ParseException {
		RoomTypeStatus rtStatus = new RoomTypeStatus();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String result = null;

		rtStatus.setHotelId(1l);
		rtStatus.setRoomTypeId(1l);
		rtStatus.setStatusDay(sdf.parse("15/02/2009"));
		rtStatus.setReservationType("I");

		rtStatus.setConfirmedRooms(1);
		rtStatus.setBlockedRooms(0);
		rtStatus.setMaintenanceRooms(0);
		rtStatus.setTentativeRooms(0);

		rtStatus.setOccupiedRooms(10);

		/*try {
			result = roomTypeStatusService.insert(rts);
		} catch (ServiceException ex) {
			fail();
		}*/

		assertNotNull(result);

	}

	@Ignore
	public void search() {
		List<RoomTypeStatus> list = null;
		new RoomTypeStatus();

		/*try {
			rts.setIdHotel("1");
			rts.setIdRoomType("1");
			rts.setStatusDay("2009-01-08");

			list = roomTypeStatusService.select(rts);
		} catch (ServiceException ex) {
			fail();
		}*/

		assertNotNull(list);
		//		assertTrue(list.size() > 0);
	}

	@Test
	public void verifyAvailability() throws Exception{
		List<RoomTypeStatus> result = null;

		//		List<Map<String, Object>> list = MockFactoryCentralTest.retrieveReservationsData(null);
		AvailabilityFilterDto filter = new AvailabilityFilterDto();

		filter.setRoomType("MT");
		filter.setStartDate(LocalDate.now());
		filter.setEndDate(LocalDate.now());

		//mock impl.
		//		RoomTypeStatusDao mockDao = createMock(RoomTypeStatusDao.class);
		//		expect(mockDao.verifyAvailability(map)).andReturn(list);
		//		replay(mockDao);
		// end mock impl.

		try {
			result = roomTypeStatusService.verifyAvailability(filter);
		} catch (Exception ex) {
			fail("Exception");
		}

		assertTrue("There isn't availability rooms :(", result.isEmpty());
	}

	/*public static TestSuite suite() {
		TestSuite suite = new TestSuite();

		suite.addTest( new RoomTypeStatusServiceTest("List") );

		return suite;
	}*/

}
