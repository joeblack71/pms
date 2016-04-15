package reservations.dao;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.myco.central.constants.CentralModuleConstants;
import com.myco.central.constants.TestConstantsMessages;
import com.myco.central.model.Address;
import com.myco.central.model.Customer;
import com.myco.central.model.Phone;
import com.myco.central.reservations.dao.CustomerDao;
import com.myco.central.reservations.dao.jdbc.CustomerDaoJdbc;

import junit.framework.TestCase;

public class TestCustomerDao extends TestCase {

	private static CustomerDao customerDao;
	private static String idCustomer;

	public TestCustomerDao(String name) {
		super(name);
		customerDao = new CustomerDaoJdbc();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	////////////////////
	/// Testing methods
	////////////////////
	
	public void testInsert() {
		Customer customer = getNewCustomer();

		try {
			idCustomer = customerDao.insert(customer);
		} catch(Exception e) {
			System.out.println( e.getCause() );
		}

		assertNotNull(TestConstantsMessages.FAIL_INSERT, idCustomer);
	}

	public void testUpdate() {
		Customer customer = getNewCustomer();
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

	public void testGetItem() {
		Customer customer = getNewCustomer();

		try {
			customer.setIdCustomer(idCustomer);
			//customer.setIdCustomer("1");
			//customer.setDocumentNumber("09549430");
			customer = customerDao.getItem(customer);
		} catch(Exception e) {
			System.out.println( e.getCause() );
		}

		assertEquals("PEREZ", customer.getLastName1());
	}

	public void testDelete() {
		Customer customer = getNewCustomer();
		boolean result = false;

		try {
			customer.setIdCustomer(idCustomer);
			result = customerDao.delete(customer);
		} catch(Exception e) {
			System.out.println( e.getCause() );
		}

		assertTrue(TestConstantsMessages.FAIL_DELETE, result);
	}

	public void testList() {
		Customer filter = getNewCustomer();
		List<DynaBean> list = null;

		try {
			list = customerDao.list(filter);
		} catch(Exception e) {
			System.out.println( e.getCause() );
		}

		assertNotNull(TestConstantsMessages.FAIL_SELECT_LIST, list);
	}

	////////////////////
	//Private interface
	////////////////////

	private Customer getNewCustomer() {
		Customer cust = new Customer();
		Address custAddress = new Address();

		//cust.setIdCustomer("");
		cust.setLastName1("PEREZ");
		cust.setLastName2("");
		cust.setFirstName("JOSE");
		cust.setTitle("MR.");

		custAddress.setStreetType("1"); // Avenue
		custAddress.setStreetName(""); // La Floresta
		custAddress.setStreetNumber(""); // 135
		custAddress.setComplement(""); // Dpto. 304
		custAddress.setCountry("1"); // Peru
		custAddress.setCity("");
		custAddress.setDistrict("");
		custAddress.setZipCode("");
		
		cust.setAddress(custAddress);

        cust.setPhone1(new Phone(null, "2427799") );
        cust.setPhone2(new Phone(null, "3659988") );
        cust.setPhone3(new Phone(null, "998565486") );

		cust.setEmails("algo@dominio.com");

		cust.setDocumentNumber("");
		cust.setDocumentType("");

		cust.setIdSource("");

		cust.setVipStatus("");
		cust.setBirthDate("");
		cust.setHotelRegistration("01");
		cust.setNationality("");
		cust.setOccupation("");
		cust.setPreferredHotel("");
		cust.setPreferredRoom("");
		cust.setRequests("");

		cust.setMadeBy("");
		cust.setStatus("");
		
		return cust;
	}

}
