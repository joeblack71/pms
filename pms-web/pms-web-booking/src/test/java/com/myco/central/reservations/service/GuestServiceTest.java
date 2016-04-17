package com.myco.central.reservations.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.reservations.domain.Guest;
import com.myco.central.util.Messages;

public class GuestServiceTest extends AbstractCentralBaseTest {
	
	@Autowired
	private GuestService guestService;

	private Map<String, Object> params;

	private static Guest guest = new Guest();

	private static String idReservation = "123456";

	@BeforeClass
	public static void prepareContext() {
		
		guest.setIdHotel("01");
		//guest.setIdReservation("123456");
		guest.setRoomNumber("0101");

		guest.setIdCustomer("01");
		guest.setCustomerNames("CHRISTIAN DEL VALLE");
		guest.setCustomerDocument("12345678");
		guest.setNationality("01"); //ID COUNTRY

		guest.setInstructions("");
		guest.setStatus("A");
	}

	@Test
	public void addGuest() throws Exception {
		boolean result = false;
		
		try {
			guest.setIdReservation(null);

			result = guestService.insert(guest);
		
		} catch(Exception e) {
			fail(Messages.getString("test.error.unexpected_exception"));
		}
		
		assertTrue(Messages.getString("test.error.null_result"), result);
	}

	@Test
	public void removeGuest() throws Exception {
		boolean result = false;
		
		try {
			guest.setIdReservation(idReservation);
			
			result = guestService.delete(guest);
		
		} catch(Exception e) {
			fail(Messages.getString("test.error.unexpected_exception"));
		}
		
		assertTrue(Messages.getString("test.error.null_result"), result);
	}

	@Test
	public void selectGuest() throws Exception {
		List<Guest> result = null;
		
		try {
			result = guestService.select(params);
		
		} catch(Exception e) {
			fail(Messages.getString("test.error.unexpected_exception"));
		}
		
		assertNotNull(Messages.getString("test.error.null_result"), result);
	}

	@Test
	public void guestsInRoom() throws Exception {
		Map<String, Guest> result = null;
		
		String idHotel = "01";
		
		try {
			guest.setIdReservation(idReservation);
			
			result = guestService.listGuestsInRoom(idHotel, idReservation);
		
		} catch(Exception e) {
			
		}
		
		assertNotNull(Messages.getString("test.error.null_result"), result);
	}

}