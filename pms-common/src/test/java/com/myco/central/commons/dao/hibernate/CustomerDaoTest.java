package com.myco.central.commons.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.myco.central.commons.dao.CustomerDao;
import com.myco.central.commons.model.Customer;
import com.myco.central.commons.service.AbstractCommonsBaseTest;
import com.myco.central.commons.util.CommonsMockFactoryTest;
import com.myco.central.commons.util.TestConstantsMessages;

public class CustomerDaoTest extends AbstractCommonsBaseTest {

	private static CustomerDao customerDao;
	
	private static Customer customer = CommonsMockFactoryTest.newCustomer();
	
	private static Customer persistedCustomer;

	@BeforeClass
	protected static void prepareTestContext() throws Exception {
		System.out.println("Preparing test context ...");
	}

	@Test
	public void insert() {
		persistedCustomer = customerDao.save(customer);
		assertNotNull(TestConstantsMessages.FAIL_INSERT, persistedCustomer);
	}

	@Test
	public void persistDuplicatedCustomer() {
		@SuppressWarnings("unused")
		Customer persistedCustomer;

		try {
			customer.setId(11l);
			customer.setDocumentType("1");
			customer.setDocumentNumber("88888888");
			
			persistedCustomer = customerDao.save(customer);

		} catch(Exception e) {
			System.out.println( e.getCause() );
		}

		//TODO assert result
//		assertEquals(CentralModuleConstants.ER_DUP_ENTRY, persistedCustomer);
	}

	@Test
	public void search() {
		customer = customerDao.get(1L);

		assertEquals("PEREZ", customer.getLastName());
	}

	@Test
	public void remove() {
		customer.setId(1L);
		customerDao.remove(customer);

//		TODO add assertion
//		assertTrue(TestConstantsMessages.FAIL_DELETE, result);
	}

	public void select() {
		List<Customer> list = null;

		try {
			list = customerDao.search(customer);
		
		} catch(Exception e) {
			System.out.println( e.getCause() );
		}

		assertNotNull(TestConstantsMessages.FAIL_SELECT, list);
	}

}
