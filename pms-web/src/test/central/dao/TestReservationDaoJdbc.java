package reservations.dao;

import java.util.ArrayList;

import com.myco.central.constants.TestConstantsMessages;
import com.myco.central.model.Guest;
import com.myco.central.model.Reservation;
import com.myco.central.reservations.dao.ReservationDao;
import com.myco.central.reservations.dao.jdbc.ReservationDaoJdbc;

import junit.framework.TestCase;

public class TestReservationDaoJdbc extends TestCase {
	
	private ReservationDao reservationDao;
	private static String idReservation;

	public TestReservationDaoJdbc(String name) {
		super(name);
		reservationDao = new ReservationDaoJdbc();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testInsertReservation() {
		Reservation item = getNewReservation();

		try {
			item.setStatus("M");
	        item.setArrival("15/02/2009");
	        item.setDeparture("16/02/2009");
			idReservation = reservationDao.insert(item);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_INSERT, idReservation);
	}

	public void testUpdateReservation() {
		Reservation item = getNewReservation();
		boolean result = false;

		try {
			//item.setIdHotel("01");
			item.setIdReservation(idReservation);
			//item.setIdReservation("5160");
			item.setGuestInstructions("Successfull update verify");
			result = reservationDao.update(item);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue(TestConstantsMessages.FAIL_UPDATE, result);
	}

	public void testGetReservation() {
		Reservation item = getNewReservation();

		try {
			item.setIdReservation(idReservation);
			item = reservationDao.get(item);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_SELECT, item);
	}

	public void testDeleteReservation() {
		Reservation item = getNewReservation();
		boolean result = false;

		try {
			item.setIdReservation(idReservation);
			//item.setIdReservation("");
			result = reservationDao.delete(item);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue(TestConstantsMessages.FAIL_DELETE, result);
	}

	//////////////////////
	// Private interface
	//////////////////////
	
	private Reservation getNewReservation() {
		Reservation item = new Reservation();

		item.setIdHotel("1");
		item.setType("I");
		item.setIdReservation("");
        item.setArrival("15/02/2008");
        item.setDeparture("16/02/2008");
        item.setNights("1");
        item.setFlight("LAN-535");
        item.setAdults("1");
        item.setChildren("0");
        item.setQuantity("1");
        item.setStatus("T");
        item.setIdSource("9999");
        item.setContactName("Contacto...");
        item.setRoomType("1");
        item.setIdPackage("");
        item.setRoomNumber("1");
        item.setRoomRate("150.50");
        item.setTotal("150.50");
        item.setPaymentDue("10/02/2008");
        item.setPaymentType("01");
        item.setVoucher("99999");
        item.setMadeBy("JO.");
        item.setUpdatedBy("JO.");
        item.setHotelInstructions("Hotel instructions ...");
        item.setGuestInstructions("Guest instructions ...");
        item.setGuests(new ArrayList<Guest>());

        return item;
	}
}
