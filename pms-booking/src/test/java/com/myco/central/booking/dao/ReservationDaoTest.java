package com.myco.central.booking.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import com.myco.central.booking.model.Reservation;
import com.myco.central.booking.utils.AbstractBookingBaseTest;
import com.myco.central.booking.utils.BookingMockFactoryTest;
import com.myco.central.booking.utils.TestConstantsMessages;

public class ReservationDaoTest extends AbstractBookingBaseTest {
	
	private ReservationDao reservationDao;
	private static Long reservationId;

	Reservation resv = BookingMockFactoryTest.newReservation();

	@Test
	public void insertReservation() {

		Reservation persisted = null;
		try {
			resv.setStatus("M");
			resv.setArrival(new Date());
			resv.setDeparture(new Date());
			persisted = reservationDao.save(resv);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_INSERT, persisted);
	}

	@Test
	public void updateReservation() {
		Reservation result = null;

		try {
			resv.setHotelId(1l);
			resv.setReservationId(reservationId);
			//item.setIdReservation("5160");
			resv.setGuestInstructions("Successfull update verify");
			result = reservationDao.save(resv);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_UPDATE, result);
	}

	@Test
	public void getReservation() {

		try {
			resv.setReservationId(reservationId);
			resv = reservationDao.get(1l);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_SELECT, resv);
	}

	@Test
	public void deleteReservation() {
		try {
			resv.setReservationId(reservationId);
			reservationDao.remove(resv);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
//		assertTrue(TestConstantsMessages.FAIL_DELETE, result);
	}

}
