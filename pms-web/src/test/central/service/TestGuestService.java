package reservations.service;

import java.util.List;
import java.util.Map;

import com.myco.central.model.Guest;
import com.myco.central.reservations.service.GuestService;
import com.myco.central.reservations.service.impl.GuestServiceImpl;

import junit.framework.TestCase;

public class TestGuestService extends TestCase {
	private GuestService guestService;
	private static String idReservation = "123456";

	public TestGuestService(String name) {
		super(name);
		guestService = new GuestServiceImpl();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testInsertGuest() {
		Guest guest = getNewItem();
		boolean result = false;
		
		try {
			guest.setIdReservation(idReservation);
			result = guestService.insert(guest);
		} catch(Exception e) {
			
		}
		
		assertTrue("No se inserto registro", result);
	}

	public void testDeleteGuest() {
		Guest guest = getNewItem();
		boolean result = false;
		
		try {
			guest.setIdReservation(idReservation);
			result = guestService.delete(guest);
		} catch(Exception e) {
			
		}
		
		assertTrue("No se elimino registro", result);
	}

	public void testList() {
		List<Guest> list = null;
		
		String idHotel = "01";
		String status = "";
		
		try {
			list = guestService.list(null);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		assertNotNull("No se recuperaron registros", list);
	}

	public void testListGuestsInRoom() {
		Guest guest = getNewItem();
		Map<String, Guest> list = null;
		
		String idHotel = "01";
		
		try {
			guest.setIdReservation(idReservation);
			list = guestService.listGuestsInRoom(idHotel, idReservation);
		} catch(Exception e) {
			
		}
		
		assertNotNull("No se recuperaron registros para nro. reserva", list);
	}

	//////////////////////
	/// Private interface
	//////////////////////
	
	private Guest getNewItem() {
		Guest guest = new Guest();
		
		guest.setIdHotel("01");
		//guest.setIdReservation("123456");
		guest.setRoomNumber("0101");

		guest.setIdCustomer("01");
		guest.setCustomerNames("CHRISTIAN DEL VALLE");
		guest.setCustomerDocument("12345678");
		guest.setNationality("01"); //ID COUNTRY

		guest.setInstructions("");
		guest.setStatus("A");
		
		return guest;
	}
}
