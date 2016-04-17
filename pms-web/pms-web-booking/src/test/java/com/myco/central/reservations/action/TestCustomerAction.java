package reservations.action;

import com.myco.central.web.reservations.form.CustomerListForm;

import servletunit.struts.MockStrutsTestCase;

public class TestCustomerAction extends MockStrutsTestCase {

	public TestCustomerAction(String name) {
		super(name);
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

	public void testCustomerEdit() {

		setRequestPathInfo("/customerEdit");
		//addRequestParameter("idHotel","1");
		addRequestParameter("idCustomer","1");
		addRequestParameter("documentNumber","");
		actionPerform();

		//assertEquals("OLIVAS", ((CustomerForm)getActionForm()).getItem().getLastName1());
		verifyNoActionMessages();
		//verifyActionMessages( new String[] {"mess.value"} );
		//verifyForward("success");
	}

	public void testCustomerUpdate() {

		setRequestPathInfo("/customerUpdate");
		setParameters();
		addRequestParameter("item.idCustomer","26"); // update
		addRequestParameter("item.address.streetName", "La Floresta");
		actionPerform();

		//assertEquals("OLIVAS", ((CustomerForm)getActionForm()).getItem().getLastName1());
		verifyNoActionMessages();
		//verifyActionMessages( new String[] {"mess.value"} );
		//verifyForward("success");
	}

	public void testCustomerList() {

		setRequestPathInfo("/customerList");
		addRequestParameter("filter.idHotel","1");
		addRequestParameter("filter.pattern","B");
		actionPerform();

		verifyForward("success");
		assertTrue( ((CustomerListForm)getActionForm()).getCustomers().size() > 0);
	}

	////////////////////////
	/// Private interface
	////////////////////////

	private void setParameters() {
		addRequestParameter("item.idCustomer",""); // insert
		//addRequestParameter("item.idHotel","1");

		addRequestParameter("item.lastName1", "PEREZ");
		addRequestParameter("item.lastName2", "");
		addRequestParameter("item.firstName", "JUAN");
		addRequestParameter("item.title", "1"); // SPEC grabar id o descripcion (e.g. MR.)

		addRequestParameter("item.address.streetType", "1"); // Avenue
		addRequestParameter("item.address.streetName", "La Floresta");
		addRequestParameter("item.address.streetNumber", "135");
		addRequestParameter("item.address.interior", "Dpto. 406");
		addRequestParameter("item.address.complement", "Block D");
		addRequestParameter("item.address.locality", "Camacho"); // Urb. Camacho
		addRequestParameter("item.address.reference", "Alt. grifo Shell");
		addRequestParameter("item.address.country", "1"); // PERU
		addRequestParameter("item.address.city", "LIMA");
		addRequestParameter("item.address.district", "La Molina");
		addRequestParameter("item.address.zipCode", "L33");

		addRequestParameter("item.phone1.number", "3655284");
		addRequestParameter("item.phone2.number", "3658745");
		addRequestParameter("item.phone3.number", "998455628");
		
		addRequestParameter("item.emails", "algo@dominio.com");

		addRequestParameter("item.documentNumber", "05875942");
		addRequestParameter("item.documentType", "1"); // DNI

		addRequestParameter("item.idSource", "123456"); // SPEC

		addRequestParameter("item.vipStatus", "2");
		addRequestParameter("item.birthdate", "11/06/2008"); // FIXME graba 0000-00-00
		addRequestParameter("item.hotelRegistration", "1");
		addRequestParameter("item.nationality", "1"); // PERUANO
		addRequestParameter("item.occupation", "1");
		addRequestParameter("item.requests", "Cama Queen");

		addRequestParameter("item.madeBy", "JO.");
		addRequestParameter("item.status", "A");
	}

}
