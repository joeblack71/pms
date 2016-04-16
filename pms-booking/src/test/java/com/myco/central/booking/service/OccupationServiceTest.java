package com.myco.central.booking.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.booking.dto.OccupationDto;
import com.myco.central.booking.utils.AbstractBookingBaseTest;
import com.myco.central.booking.utils.Messages;
import com.myco.central.commons.exceptions.ServiceException;

public class OccupationServiceTest extends AbstractBookingBaseTest {

	@Autowired
	private BookingService occupationService;


	@Test
	public void flashStatus() {
		OccupationDto filter = new OccupationDto(null, null, null, null, null);
		List<Map<String, Object>> list = null;
		try {
			list = occupationService.loadFlashStatus(filter);

		} catch (ServiceException ex) {
			fail(Messages.getString("test.error.unexpected_exception"));
		}

		assertNotNull(Messages.getString("test.error.null_result"), list);
		assertTrue(Messages.getString("test.error.unexpected_result"), list.size() > 0);
	}

	@Test
	public void occupationByType() {
		fail("Not yet implemented");
	}

	@Test
	public void occupationOnStay() {
		fail("Not yet implemented");
	}

	@Test
	public void occupationStatus() {
		//		String[][] result = null;

		//		try {
		//			result = occupationService.getOccupation(params);
		//
		//		} catch (ServiceException ex) {
		//			fail(Messages.getString("test.error.unexpected_exception"));
		//		}

		//		assertNotNull(Messages.getString("test.error.null_result"), result);
		//		assertTrue(Messages.getString("test.error.unexpected_result"), result.length > 0);
	}

}
