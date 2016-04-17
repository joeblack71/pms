package com.myco.central.commons.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.util.Messages;

public class CustomerServiceTest extends AbstractCommonsBaseTest {
	
	@Autowired
	private CustomerService customerService;

	@Test
	public void insertCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void updateCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void searchCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void deleteCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void searchPatterns() {
		fail("Not yet implemented");
	}

	@Test
	public void reportCustomer() {
//		Customer filter = new Customer();
		
		List<Map<String, Object>> result = null;
		
		try {
			result = customerService.select(null);

		} catch (ServiceException ex) {
			System.out.println( ex.getCause() );
		}
		
		assertNotNull(Messages.getString("test.error.null_result"), result);
		assertTrue(Messages.getString("test.error.no_records"), result.size() > 0);
	}

}
