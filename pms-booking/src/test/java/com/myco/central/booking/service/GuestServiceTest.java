package com.myco.central.booking.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.myco.central.booking.model.Guest;
import com.myco.central.booking.service.impl.GuestServiceImpl;
import com.myco.central.booking.utils.AbstractBookingBaseTest;
import com.myco.central.booking.utils.Messages;

public class GuestServiceTest extends AbstractBookingBaseTest {
	private static Guest guest = new Guest();
	private static Long idReservation = 123456L;
	
	@BeforeClass
	public static void prepareContext() {
	}
	private GuestService guestService;

	@Test
	public void addGuest() throws Exception {
		try {
			guest.setReservationId(1l);

			guestService.save(guest);

		} catch(Exception e) {
			fail(Messages.getString("test.error.unexpected_exception"));
		}

//		assertTrue(Messages.getString("test.error.null_result"), result);
	}

	private Guest getNewItem() {
		Guest guest = new Guest();

		guest.setHotelId(1l);
		//guest.setIdReservation("123456");
		guest.setRoomNumber("0101");

		guest.setCustomerId(1l);
		guest.setCustomerNames("CHRISTIAN DEL VALLE");
		guest.setCustomerDocument("12345678");
		guest.setNationality("01"); //ID COUNTRY

		guest.setInstructions("");
		guest.setStatus("A");

		return guest;
	}

	@Test
	public void guestsInRoom() throws Exception {
		List<Guest> result = null;

		Long hotelId = 1l;

		try {
			guest.setReservationId(idReservation);

			result = guestService.getGuestsInRoom(hotelId, idReservation);

		} catch(Exception e) {

		}

		assertNotNull(Messages.getString("test.error.null_result"), result);
	}

	@Test
	public void removeGuest() throws Exception {
		try {
			guest.setReservationId(idReservation);

			guestService.remove(guest);

		} catch(Exception e) {
			fail(Messages.getString("test.error.unexpected_exception"));
		}

//		assertTrue(Messages.getString("test.error.null_result"), result);
	}

	@Test
	public void selectGuest() throws Exception {
		List<Guest> result = null;

		//		try {
		//			result = guestService.select(params);
		//
		//		} catch(Exception e) {
		//			fail(Messages.getString("test.error.unexpected_exception"));
		//		}

		assertNotNull(Messages.getString("test.error.null_result"), result);
	}

	protected void setUp() throws Exception {
		guestService = new GuestServiceImpl();

		guest.setHotelId(1l);
		//guest.setIdReservation("123456");
		guest.setRoomNumber("0101");

		guest.setCustomerId(1l);
		guest.setCustomerNames("CHRISTIAN DEL VALLE");
		guest.setCustomerDocument("12345678");
		guest.setNationality("01"); //ID COUNTRY

		guest.setInstructions("");
		guest.setStatus("A");
	}

	public void testDeleteGuest() {
		Guest guest = getNewItem();

		try {
			guest.setReservationId(idReservation);
			guestService.remove(guest);
		} catch(Exception e) {

		}

//		assertTrue("No se elimino registro", result);
	}

	public void testInsertGuest() {
		Guest guest = getNewItem();

		try {
			guest.setReservationId(idReservation);
			guestService.save(guest);
		} catch(Exception e) {

		}

//		assertTrue("No se inserto registro", result);
	}

	public void testListGuestsInRoom() {
		Guest guest = getNewItem();
		List<Guest> list = null;

		Long idHotel = 1l;

		try {
			guest.setReservationId(idReservation);
			list = guestService.getGuestsInRoom(idHotel, idReservation);
		} catch(Exception e) {

		}

		assertNotNull("No se recuperaron registros para nro. reserva", list);
	}
}