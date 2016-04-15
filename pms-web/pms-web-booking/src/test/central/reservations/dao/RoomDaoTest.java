package com.myco.central.reservations.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.myco.central.reservations.domain.Room;
import com.myco.central.reservations.service.AbstractCentralBaseTest;
import com.myco.central.util.MockFactoryCentralTest;
import com.myco.central.util.TestConstantsMessages;

public class RoomDaoTest extends AbstractCentralBaseTest {

	private RoomDao roomDao;
	private static String idRoom;
	
	private static Room room = MockFactoryCentralTest.newRoom();

	@Test
	public void InsertRoom() {
		
		try {
			idRoom = roomDao.insert(room);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_INSERT, idRoom);
	}

	@Test
	public void testUpdateRoom() {
		boolean result = false;
		
		try {
			room.setIdRoom(idRoom);
			result = roomDao.update(room);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue(TestConstantsMessages.FAIL_UPDATE, result);
	}

	@Test
	public void testGetRoom() {
		
		try {
			//room.setIdRoom(idRoom);
			room.setIdRoom("61");
			room = roomDao.search(room);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertEquals("9999", room.getRoomNumber());
	}

	@Test
	public void testDeleteRoom() {
		boolean result = false;
		
		try {
			room.setIdRoom(idRoom);
			result = roomDao.delete(room);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue(TestConstantsMessages.FAIL_DELETE, result);
	}

	@Test
	public void testselect() {
		List<Map<String, Object>> list = null;

		try {
			list = roomDao.select(null);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_SELECT, list);
	}

}
