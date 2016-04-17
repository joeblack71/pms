package reservations.service;

import java.util.List;

import junit.framework.TestCase;

import com.myco.central.model.RoomType;
import com.myco.central.reservations.service.RoomTypeService;
import com.myco.central.reservations.service.impl.RoomTypeServiceImpl;

public class TestRoomTypeService extends TestCase {
	private RoomTypeService roomTypeService;
	private static String idRoomType;

	public TestRoomTypeService(String name) {
		super(name);
		roomTypeService = new RoomTypeServiceImpl();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/////////////////////
	/// Testing methods
	/////////////////////
	
	public void testInsertRoomType() {
		RoomType roomType = getNewRoomType();

		roomType.setIdHotel("01"); // 01
		roomType.setRoomType("EX"); // EX
		roomType.setDescription("EXECUTIVE"); // EXECUTIVE
		roomType.setRackRate("60"); // 50.00
		roomType.setTotalRooms("10");
		roomType.setAvailableRooms("10"); // DEFAULT igual a total rooms
		roomType.setBlockedRooms("0"); // DEFAULT 0
		roomType.setStatus("A");
		roomType.setMadeBy("JO");

		try {
			idRoomType = roomTypeService.insert(roomType);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(idRoomType);
	}

	public void testUpdateRoomType() {
		RoomType roomType = getNewRoomType();
		boolean result = false;

		try {
			roomType.setIdRoomType(idRoomType);
			roomType.setDescription("STANDARD");
			result = roomTypeService.update(roomType);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue("*** No se actualizo registro: " + idRoomType +  "***", result);
	}

	public void testGetRoomType() {
		RoomType roomType = getNewRoomType();

		try {
			roomType.setIdRoomType(idRoomType);
			roomType = roomTypeService.get(roomType);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertEquals("STANDARD", roomType.getDescription());
	}

	public void testDeleteRoomType() {
		RoomType roomType = getNewRoomType();
		boolean result = false;

		try {
			roomType.setIdRoomType(idRoomType);
			result = roomTypeService.delete(roomType);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue("*** No se elimino registro: " + idRoomType +  "***", result);
	}

	public void testList() {
		RoomType roomType = getNewRoomType();
		List<RoomType> list = null;

		try {
			roomType.setStatus("");
			list = roomTypeService.list(roomType);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue(list.size() > 0);
	}

	////////////////////
	///Private interface
	////////////////////

	private RoomType getNewRoomType() {
		RoomType roomType = new RoomType();
		
		roomType.setIdHotel("01");
		roomType.setRoomType("DB");
		roomType.setDescription("Doble");
		roomType.setRackRate("50.00");
		roomType.setTotalRooms("");
		roomType.setAvailableRooms("");
		roomType.setBlockedRooms("");
		roomType.setStatus("");

		return roomType;
	}
}
