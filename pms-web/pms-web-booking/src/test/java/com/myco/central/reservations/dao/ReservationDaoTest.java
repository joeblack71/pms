package com.myco.central.reservations.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.myco.central.reservations.domain.Reservation;
import com.myco.central.reservations.service.AbstractCentralBaseTest;
import com.myco.central.util.MockFactoryCentralTest;
import com.myco.central.util.TestConstantsMessages;

public class ReservationDaoTest extends AbstractCentralBaseTest {
	
	private ReservationDao reservationDao;
	private static String idReservation;

	Reservation resv = MockFactoryCentralTest.newReservation();

	@Test
	public void insertReservation() {

		try {
			resv.setStatus("M");
	        resv.setArrival("15/02/2009");
	        resv.setDeparture("16/02/2009");
			idReservation = reservationDao.insert(resv);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_INSERT, idReservation);
	}

	@Test
	public void updateReservation() {
		boolean result = false;

		try {
			//item.setIdHotel("01");
			resv.setIdReservation(idReservation);
			//item.setIdReservation("5160");
			resv.setGuestInstructions("Successfull update verify");
			result = reservationDao.update(resv);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue(TestConstantsMessages.FAIL_UPDATE, result);
	}

	@Test
	public void getReservation() {

		try {
			resv.setIdReservation(idReservation);
			resv = reservationDao.search(resv);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(TestConstantsMessages.FAIL_SELECT, resv);
	}

	@Test
	public void deleteReservation() {
		boolean result = false;

		try {
			resv.setIdReservation(idReservation);
			//item.setIdReservation("");
			result = reservationDao.delete(resv);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue(TestConstantsMessages.FAIL_DELETE, result);
	}

}
