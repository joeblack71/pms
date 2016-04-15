package com.myco.central.reservations.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.myco.central.commons.dao.CustomerDao;
import com.myco.central.commons.model.Customer;
import com.myco.central.constants.CentralModuleConstants;
import com.myco.central.reservations.service.AbstractCentralBaseTest;
import com.myco.central.util.MockFactoryCentralTest;
import com.myco.central.util.TestConstantsMessages;

public class CustomerDaoTest extends AbstractCentralBaseTest {

	private static CustomerDao customerDao;
	
	private static Customer customer = MockFactoryCentralTest.newCustomer();
	
	private static String idCustomer;

	@BeforeClass
	protected static void prepareTestContext() throws Exception {
		System.out.println("Preparing test context ...");
	}

	@Test
	public void insert() {

		try {
			idCustomer = customerDao.insert(customer);

		} catch(Exception e) {
			System.out.println( e.getCause() );
		}

		assertNotNull(TestConstantsMessages.FAIL_INSERT, idCustomer);
	}

	public void update() {
		String result = "";

		try {
			//customer.setIdCustomer(idCustomer);
			customer.setIdCustomer("11");
			customer.setDocumentType("1");
			customer.setDocumentNumber("88888888");
			
			result = customerDao.update(customer);

		} catch(Exception e) {
			System.out.println( e.getCause() );
		}

		assertEquals(CentralModuleConstants.ER_DUP_ENTRY, result);
	}

	public void search() {

		try {
			customer.setIdCustomer(idCustomer);
			//customer.setIdCustomer("1");
			//customer.setDocumentNumber("09549430");
			
			customer = customerDao.search(customer);
		} catch(Exception e) {
			System.out.println( e.getCause() );
		}

		assertEquals("PEREZ", customer.getLastName1());
	}

	public void delete() {
		boolean result = false;

		try {
			customer.setIdCustomer(idCustomer);
			
			result = customerDao.delete(customer);
		
		} catch(Exception e) {
			System.out.println( e.getCause() );
		}

		assertTrue(TestConstantsMessages.FAIL_DELETE, result);
	}

	public void select() {
		List<Map<String, Object>> list = null;

		try {
			list = customerDao.select(customer);
		
		} catch(Exception e) {
			System.out.println( e.getCause() );
		}

		assertNotNull(TestConstantsMessages.FAIL_SELECT, list);
	}

}
