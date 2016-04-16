package com.myco.central.core.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.myco.central.core.util.AbstractCoreBaseTest;
import com.myco.central.core.util.CoreMockFactoryTest;
import com.myco.central.core.util.TestConstantsMessages;
import com.myco.central.model.Room;

public class RoomDaoTest extends AbstractCoreBaseTest {

	private RoomDao roomDao;
	private static Long roomId;
	
	private static Room room = CoreMockFactoryTest.newRoom();

	@Test
	public void InsertRoom() {
		Room persistedRoom = null;
		try {
			persistedRoom = roomDao.save(room);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_INSERT, persistedRoom);
	}

	@Test
	public void testUpdateRoom() {
		Room result = null;
		
		try {
			room.setId(roomId);
			result = roomDao.save(room);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_UPDATE, result);
	}

	@Test
	public void testGetRoom() {
		
		try {
			room = roomDao.get(61l);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertEquals("9999", room.getRoomNumber());
	}

	@Test
	public void testDeleteRoom() {
		boolean result = false;
		
		try {
			room.setId(roomId);
			roomDao.remove(room);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue(TestConstantsMessages.FAIL_DELETE, result);
	}

	@Test
	public void testselect() {
		List<Room> list = null;

		try {
			list = roomDao.search("patern");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_SELECT, list);
	}

}
