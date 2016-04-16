package com.myco.central.core.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.core.util.AbstractCoreBaseTest;
import com.myco.central.model.Room;

public class RoomServiceTest extends AbstractCoreBaseTest {
	private static final Log LOGGER = LogFactory.getLog(RoomServiceTest.class);

	@Autowired
	private RoomService roomService;

	@Test
	public void removeRoom() {
		boolean result = false;

		try {
			Room filter = getNewRoom();
			filter.setId(1l);
			roomService.remove(filter);
		} catch (ServiceException ex) {
			LOGGER.info(ex);
		}

		assertTrue(result);
	}

	@Test
	public void saveRoom() {
		try {
			roomService.save(getNewRoom());
		} catch (ServiceException ex) {
			LOGGER.info(ex);
		}

		// assertNotNull("FAIL_INSERT", idRoom);
	}

	@Test
	public void searchRoomByValidPattern() {
		List<Room> rooms = null;

		try {
			String pattern = "";
			rooms = roomService.search(pattern);
		} catch (ServiceException ex) {
			LOGGER.info(ex);
		}

		assertTrue("ZZZZ", !rooms.isEmpty());
	}

	@Test
	public void updateRoom() {
		try {
			Room room = getNewRoom();
			room.setId(1l);
			room.setRoomNumber("ZZZZ");
			roomService.update(room);
		} catch (ServiceException ex) {
			LOGGER.info(ex);
		}

		// assertTrue("FAIL_UPDATE", result);
	}

	private Room getNewRoom() {
		Room room = new Room();

		room.setHotelId(1l);
		room.setRoomTypeId(3l);
		room.setRoomNumber("9999");
		room.setLocation("Piso 9");
		room.setDescription("Hbtn. doble c/Vista Interna");
		room.setRoomRate(50.00);
		room.setBedsCapacity(2);
		room.setRoomStatus("A");
		room.setReservationId(1l);
		room.setConnectedRoom("");
		room.setHkStatus("");
		room.setCreatedBy("JOC");

		return room;
	}

}
