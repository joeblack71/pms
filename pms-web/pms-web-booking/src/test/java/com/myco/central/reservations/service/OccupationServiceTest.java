package com.myco.central.reservations.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.util.Messages;

public class OccupationServiceTest extends AbstractCentralBaseTest {
	
	@Autowired
	private OccupationService occupationService;

	private Map<String, Object> params = new HashMap<String, Object>();

	@Test
	public void occupationByType() {
		fail("Not yet implemented");
	}

	@Test
	public void occupationOnStay() {
		fail("Not yet implemented");
	}

	@Test
	public void flashStatus() {
		List<Map<String, Object>> list = null;

		try {
			list = occupationService.flashStatus(params);
		
		} catch (ServiceException ex) {
			fail(Messages.getString("test.error.unexpected_exception"));
		}
		
		assertNotNull(Messages.getString("test.error.null_result"), list);
		assertTrue(Messages.getString("test.error.unexpected_result"), list.size() > 0);
	}

	@Test
	public void occupationStatus() {
		String[][] result = null;

		try {
			result = occupationService.getOccupation(params);
		
		} catch (ServiceException ex) {
			fail(Messages.getString("test.error.unexpected_exception"));
		}
		
		assertNotNull(Messages.getString("test.error.null_result"), result);
		assertTrue(Messages.getString("test.error.unexpected_result"), result.length > 0);
	}

}
