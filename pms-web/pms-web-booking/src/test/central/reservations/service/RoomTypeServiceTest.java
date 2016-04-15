package com.myco.central.reservations.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.myco.central.reservations.domain.RoomType;

public class RoomTypeServiceTest extends AbstractCentralBaseTest {
	private RoomTypeService roomTypeService;
	private static String idRoomType;

	@Test
	public void InsertRoomType() {
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

	public void UpdateRoomType() {
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

	public void GetRoomType() {
		RoomType roomType = getNewRoomType();

		try {
			roomType.setIdRoomType(idRoomType);
			roomType = roomTypeService.search(roomType);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertEquals("STANDARD", roomType.getDescription());
	}

	public void DeleteRoomType() {
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

	public void select() {
		RoomType roomType = getNewRoomType();
		List<RoomType> list = null;

		try {
			roomType.setStatus("");
			list = roomTypeService.select(roomType);
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
