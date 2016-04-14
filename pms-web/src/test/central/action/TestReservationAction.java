package reservations.action;

import java.util.List;

import servletunit.struts.MockStrutsTestCase;

public class TestReservationAction extends MockStrutsTestCase {

	public TestReservationAction(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		setConfigFile("WEB-INF/struts-config-central.xml");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testReservationList() {
		fail("Not yet implemented");
	}

	public void testReservationEdit() {
		fail("Not yet implemented");
	}

	public void testReservationSearch() {
		fail("Not yet implemented");
	}

	public void testReservationUpdate() {
		setRequestPathInfo("/reservationUpdate");
		setParameters();
		addRequestParameter("item.arrival", "16/12/2008");
		addRequestParameter("item.departure", "17/12/2008");
		addRequestParameter("item.nights", "1");
		addRequestParameter("item.roomType", "1");
		addRequestParameter("item.quantity", "1");
		actionPerform();

		//assertEquals("OLIVAS", ((CustomerForm)getActionForm()).getItem().getLastName1());
		verifyNoActionMessages();
		//verifyActionMessages( new String[] {"mess.value"} );
		//verifyForward("success");
	}

	public void testReservationDelete() {
		fail("Not yet implemented");
	}

	public void testReservationAddGuest() {
		fail("Not yet implemented");
	}

	public void testReservationRemoveGuest() {
		fail("Not yet implemented");
	}

	public void testReloadGuests() {
		fail("Not yet implemented");
	}

	public void testGetRoomRate() {
		fail("Not yet implemented");
	}

	/////////////////////
	/// private interface
	/////////////////////
	
	private void setParameters() {
		addRequestParameter("item.idHotel", "1");
		addRequestParameter("item.idReservation", "");
		addRequestParameter("item.type", "I"); // Individual
		addRequestParameter("item.arrival", "15/12/2008");
		addRequestParameter("item.departure", "20/12/2008");
		addRequestParameter("item.nights", "6");
		addRequestParameter("item.flight", "LAN635");
		addRequestParameter("item.adults", "2");
		addRequestParameter("item.children", "");
		addRequestParameter("item.roomType", "1");
		addRequestParameter("item.idPackage", "");
		addRequestParameter("item.quantity", "3");
		addRequestParameter("item.roomNumber", "");
		addRequestParameter("item.vipCode", "2");
		addRequestParameter("item.voucher", "");
		addRequestParameter("item.roomRate", "65.00");
		addRequestParameter("item.total", "130.00");
		addRequestParameter("item.paymentDue", "08/12/2008");
		addRequestParameter("item.paymentType", "21");
		addRequestParameter("item.idSource", "FR9999"); // FULL RATE
		addRequestParameter("item.sourceName", "");
		addRequestParameter("item.contactName", "JONAS ESPOSITO");
		addRequestParameter("item.hotelInstructions", "");
		addRequestParameter("item.guestInstructions", "");
		addRequestParameter("item.status", "T");
		addRequestParameter("item.madeBy", "JO");
		addRequestParameter("item.updatedBy", "JO");
	}
	
}
