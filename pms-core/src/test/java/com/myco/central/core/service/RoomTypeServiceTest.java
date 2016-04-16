package com.myco.central.core.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.core.util.AbstractCoreBaseTest;
import com.myco.central.model.RoomType;

public class RoomTypeServiceTest extends AbstractCoreBaseTest {
	private static final Log LOGGER = LogFactory.getLog(RoomTypeServiceTest.class);

	@Autowired
	private RoomTypeService roomTypeService;

	private RoomType getNewRoomType() {
		RoomType roomType = new RoomType();

		roomType.setHotelId(1l);
		roomType.setCode("DB");
		roomType.setDescription("Doble");
		roomType.setRackRate(50.00d);
		roomType.setTotalRooms(50);
		roomType.setAvailableRooms(50);
		roomType.setBlockedRooms(0);
		roomType.setStatus("");

		return roomType;
	}

	@Test
	public void getRoomType() {
		RoomType roomType = null;
		try {
			roomType = roomTypeService.get(1l);
		} catch (ServiceException ex) {
			LOGGER.info(ex);
		}

		assertNotNull("STANDARD", roomType.getDescription());
	}

	private RoomType getUpdatedRoomType() {
		RoomType roomType = getNewRoomType();
		roomType.setHotelId(1l);
		roomType.setCode("EX");
		roomType.setDescription("EXECUTIVE");
		roomType.setRackRate(60.00);
		roomType.setTotalRooms(10);
		roomType.setAvailableRooms(10);
		roomType.setBlockedRooms(0);
		roomType.setStatus("A");
		roomType.setCreatedBy("JO");
		return roomType;
	}

	@Test
	public void remove() {
		try {
			roomTypeService.remove(getUpdatedRoomType());
		} catch (ServiceException ex) {
			LOGGER.info(ex);
		}

		// assertTrue("*** No se elimino registro: " + persistedRoomType +
		// "***", result);
	}

	@Test
	public void saveNewRoomType() {
		try {
			roomTypeService.save(getNewRoomType());
		} catch (ServiceException e) {
			LOGGER.info(e);
		}
	}

	@Test
	public void searchByFilter() {
		List<RoomType> list = null;

		try {
			RoomType filter = getNewRoomType();
			filter.setStatus("");
			list = roomTypeService.search(filter);
		} catch (ServiceException ex) {
			LOGGER.info(ex);
		}

		assertTrue(!list.isEmpty());
	}

	@Test
	public void updateRoomType() {

		try {
			RoomType roomType = getNewRoomType();
			roomType.setCode("NT");
			roomType.setDescription("STANDARD");
			roomTypeService.save(roomType);
		} catch (ServiceException ex) {
			LOGGER.info(ex);
		}

//		TODO add assertion
	}

	@Test
	public void verifyRoomTypesByHotel() {
		List<RoomType> list = null;

		try {
			list = roomTypeService.getAll();
		} catch (ServiceException ex) {
			LOGGER.info(ex);
		}

		assertTrue(list.size() > 0);
	}
}
