package com.myco.central.reservations.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.reservations.domain.Room;
import com.myco.central.util.TestConstantsMessages;

public class RoomServiceTest extends AbstractCentralBaseTest {

	private RoomService roomService;
	private static String idRoom;

	@Test
	public void InsertRoom() {
		Room room = getNewRoom();
		
		try {
			idRoom = roomService.insert(room);
		} catch (ServiceException ex) {
        	System.out.println( ex.getMessage() );
		}
		
		assertNotNull(TestConstantsMessages.FAIL_INSERT, idRoom);
		//assertEquals("53", idRoom);
	}

	public void UpdateRoom() {
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

	public void searchRoom() {
		Room filter = getNewRoom();
		Room room = null;
		
		try {
			filter.setIdRoom(idRoom);
			room = roomService.search(filter);
		} catch (ServiceException ex) {
        	System.out.println( ex.getMessage() );
		}
		
		assertEquals("ZZZZ", room.getRoomNumber());
	}

	public void DeleteRoom() {
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

	public void select() {
		Room filter = getNewRoom();
		List<Map<String, Object>> list = null;
		
		try {
			//filter.setIdRoomType("01");
			filter.setRoomStatus("*");
			list = roomService.select(filter);
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
