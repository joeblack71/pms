package reservations.service;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import junit.framework.TestCase;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.model.Customer;
import com.myco.central.reservations.service.CustomerService;
import com.myco.central.reservations.service.impl.CustomerServiceImpl;

public class TestCustomerService extends TestCase {
	private CustomerService customerService;

	public TestCustomerService(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		customerService = new CustomerServiceImpl();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testInsertCustomer() {
		fail("Not yet implemented");
	}

	public void testUpdateCustomer() {
		fail("Not yet implemented");
	}

	public void testGetItemCustomer() {
		fail("Not yet implemented");
	}

	public void testDeleteCustomer() {
		fail("Not yet implemented");
	}

	public void testGetSearchPatterns() {
		fail("Not yet implemented");
	}

	public void testListCustomer() {
		Customer filter = new Customer();
		
		List<DynaBean> list = null;
		
		filter.setHotelRegistration("1");
		filter.setLastName1("");

		try {
			list = customerService.list(filter);
		} catch (ServiceException ex) {
			System.out.println( ex.getCause() );
		}
		
		System.out.println(list.size());
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

}
