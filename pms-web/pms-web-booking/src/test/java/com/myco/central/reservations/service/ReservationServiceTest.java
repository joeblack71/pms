/**
 * 
 */
package com.myco.central.reservations.service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.reservations.domain.Reservation;
import com.myco.central.util.Messages;

/**
 * @author Devel
 *
 */
public class ReservationServiceTest extends AbstractCentralBaseTest {

	@Autowired
	private ReservationService reservationService;

	@BeforeClass
	public static void prepareTestContext() throws Exception{
		System.out.println(Messages.getString("test.error.preparing_context"));

	}

	@Ignore @Test
	public void insert() {
		fail("Not yet implemented"); // TODO //$NON-NLS-1$
	}

	@Ignore @Test
	public void update() {
		fail("Not yet implemented"); // TODO //$NON-NLS-1$
	}

	@Test
	public void search() throws Exception{
		Reservation params = new Reservation();		
		Reservation result = null;
		
		result = reservationService.search(params);

		assertNotNull(Messages.getString("test.error.null_record"), result);
	}

	@Ignore @Test
	public void delete() {
		fail("Not yet implemented"); // TODO //$NON-NLS-1$
	}

	@Ignore @Test
	public void select() {
		fail("Not yet implemented"); // TODO //$NON-NLS-1$
	}

	@Ignore @Test
	public void saveReservationInfo() {
		fail("Not yet implemented"); // TODO //$NON-NLS-1$
	}

	@Ignore @Test
	public void getReservationGuests() {
		fail("Not yet implemented"); // TODO //$NON-NLS-1$
	}

	
}
