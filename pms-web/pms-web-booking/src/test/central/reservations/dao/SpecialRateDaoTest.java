package com.myco.central.reservations.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.reservations.service.AbstractCentralBaseTest;

public class SpecialRateDaoTest extends AbstractCentralBaseTest {
	private SpecialRateDao specialRateDao;

	@Test
	public void insertSpecialRate() {
		fail("Not yet implemented");
	}

	@Test
	public void updateSpecialRate() {
		fail("Not yet implemented");
	}

	@Test
	public void searchSpecialRate() {
		fail("Not yet implemented");
	}

	@Test
	public void deleteSpecialRate() {
		fail("Not yet implemented");
	}

	@Test
	public void select() {
		List<Map<String, Object>> list = null;

		String idHotel = "1";
		String description = "";
		String status = "";

		try {
			list = specialRateDao.select(idHotel, description, status);
		} catch (DaoException ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

	@Test
	public void addRoomTypeRate() {
		fail("Not yet implemented");
	}

	@Test
	public void getSpecialRoomRate() {
		fail("Not yet implemented");
	}

}
