/**
 *
 */
package com.myco.central.booking.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.booking.model.Reservation;
import com.myco.central.booking.utils.AbstractBookingBaseTest;

/**
 * @author Devel
 *
 */
public class ReservationServiceTest extends AbstractBookingBaseTest {

	@BeforeClass
	public static void prepareTestContext() throws Exception{
		System.out.println("Messages.getString(\"test.error.preparing_context\")");

	}

	@Autowired
	private ReservationService reservationService;

	@Ignore @Test
	public void delete() {
		fail("Not yet implemented"); // TODO //$NON-NLS-1$
	}

	@Ignore @Test
	public void getReservationGuests() {
		fail("Not yet implemented"); // TODO //$NON-NLS-1$
	}

	@Ignore @Test
	public void insert() {
		fail("Not yet implemented"); // TODO //$NON-NLS-1$
	}

	@Ignore @Test
	public void saveReservationInfo() {
		fail("Not yet implemented"); // TODO //$NON-NLS-1$
	}

	@Test
	public void search() throws Exception{
		Reservation params = new Reservation();
		List<Reservation> result = null;

		result = reservationService.search(params);

		assertNotNull("Messages.getString(\"test.error.null_record\")", result);
	}

	@Ignore @Test
	public void select() {
		fail("Not yet implemented"); // TODO //$NON-NLS-1$
	}

	@Ignore @Test
	public void update() {
		fail("Not yet implemented"); // TODO //$NON-NLS-1$
	}


}
