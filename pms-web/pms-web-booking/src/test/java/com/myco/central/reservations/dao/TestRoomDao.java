package reservations.dao;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.myco.central.constants.TestConstantsMessages;
import com.myco.central.model.Room;
import com.myco.central.reservations.dao.RoomDao;
import com.myco.central.reservations.dao.jdbc.RoomDaoJdbc;

import junit.framework.TestCase;

public class TestRoomDao extends TestCase {

	private RoomDao roomDao;
	private static String idRoom;
	
	public TestRoomDao(String name) {
		super(name);
		roomDao = new RoomDaoJdbc();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testInsertRoom() {
		Room room = getNewRoom();
		
		try {
			idRoom = roomDao.insert(room);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_INSERT, idRoom);
	}

	public void testUpdateRoom() {
		Room room = getNewRoom();
		boolean result = false;
		
		try {
			room.setIdRoom(idRoom);
			result = roomDao.update(room);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue(TestConstantsMessages.FAIL_UPDATE, result);
	}

	public void testGetRoom() {
		Room room = getNewRoom();
		
		try {
			//room.setIdRoom(idRoom);
			room.setIdRoom("61");
			room = roomDao.getItem(room);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertEquals("9999", room.getRoomNumber());
	}

	public void testDeleteRoom() {
		Room room = getNewRoom();
		boolean result = false;
		
		try {
			room.setIdRoom(idRoom);
			result = roomDao.delete(room);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue(TestConstantsMessages.FAIL_DELETE, result);
	}

	public void testList() {
		List<DynaBean> list = null;

		String idHotel = "01";
		String roomType = "";
		String roomStatus = "";
		
		try {
			list = roomDao.list(null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_SELECT_LIST, list);
	}

	/*public void testGetRoomStatusList() {
		fail("Not yet implemented");
	}*/

	////////////////////
	///private interface
	////////////////////

	private Room getNewRoom() {
		Room room = new Room();

		room.setIdHotel("01");
		room.setIdRoomType("DB");
		room.setRoomNumber("0101");
		room.setDescription("DOBLE");
		room.setLocation("");
		room.setIdRoom("");
		room.setBedsCapacity("");
		room.setRoomRate("");
		room.setIdReservation("0");
		room.setConnectedRoom("");
		room.setRoomStatus("A");
		room.setHkStatus("");

		return room;
	}

}
