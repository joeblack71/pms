package reservations.service;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import junit.framework.TestCase;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.constants.TestConstantsMessages;
import com.myco.central.model.Room;
import com.myco.central.reservations.service.RoomService;
import com.myco.central.reservations.service.impl.RoomServiceImpl;

public class TestRoomService extends TestCase {

	private RoomService roomService;
	private static String idRoom;

	public TestRoomService(String name) {
		super(name);
		roomService = new RoomServiceImpl();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	////////////////////
	/// Testing methods
	////////////////////

	public void testInsertRoom() {
		Room room = getNewRoom();
		
		try {
			idRoom = roomService.insert(room);
		} catch (ServiceException ex) {
        	System.out.println( ex.getMessage() );
		}
		
		assertNotNull(TestConstantsMessages.FAIL_INSERT, idRoom);
		//assertEquals("53", idRoom);
	}

	public void testUpdateRoom() {
		Room room = getNewRoom();
		boolean result = false;

		try {
			room.setIdRoom(idRoom);
			room.setRoomNumber("ZZZZ");
			result = roomService.update(room);
		} catch (ServiceException ex) {
        	System.out.println( ex.getMessage() );
		}

		assertTrue(TestConstantsMessages.FAIL_UPDATE, result);
	}

	public void testGetItemRoom() {
		Room filter = getNewRoom();
		Room room = null;
		
		try {
			filter.setIdRoom(idRoom);
			room = roomService.getItem(filter);
		} catch (ServiceException ex) {
        	System.out.println( ex.getMessage() );
		}
		
		assertEquals("ZZZZ", room.getRoomNumber());
	}

	public void testDeleteRoom() {
		Room filter = getNewRoom();
		boolean result = false;
		
		try {
			filter.setIdRoom(idRoom);
			result = roomService.delete(filter);
		} catch (ServiceException ex) {
        	System.out.println( ex.getMessage() );
		}
		
		assertTrue(result);
	}

	public void testList() {
		Room filter = getNewRoom();
		List<DynaBean> list = null;
		
		try {
			//filter.setIdRoomType("01");
			filter.setRoomStatus("*");
			list = roomService.list(filter);
		} catch (ServiceException ex) {
        	System.out.println( ex.getMessage() );
		}
		
		assertTrue(list.size() > 0);
	}

	////////////////////
	///private interface
	////////////////////

	private Room getNewRoom() {
		Room room = new Room();

		room.setIdHotel("01");
		room.setIdRoomType("03");
		room.setRoomNumber("9999");
		room.setLocation("Piso 9");
		room.setDescription("Hbtn. doble c/Vista Interna");
		room.setRoomRate("50.00");
		room.setBedsCapacity("2");
		room.setRoomStatus("A");
		room.setIdReservation("");
		room.setConnectedRoom("");
		room.setHkStatus("");
		room.setMadeBy("JO.");

		return room;
	}

}
