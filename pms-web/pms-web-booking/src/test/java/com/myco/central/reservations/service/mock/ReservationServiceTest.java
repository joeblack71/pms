/**
 * 
 */
package com.myco.central.reservations.service.mock;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.myco.central.reservations.dao.ReservationDao;
import com.myco.central.reservations.domain.Reservation;
import com.myco.central.reservations.service.impl.ReservationServiceImpl;

/**
 * @author Devel
 *
 */
@ContextConfiguration(locations={"central-service-test.xml"})
public class ReservationServiceTest {

	private static ReservationServiceImpl reservationService;
	private static ReservationDao mockDao;

	@BeforeClass
	public static void prepareMock() throws Exception{
		reservationService = new ReservationServiceImpl();
		mockDao = createMock(ReservationDao.class);		
		
		reservationService.setReservationDao(mockDao);
	}

	@Ignore @Test
	public void insert() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore @Test
	public void update() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void search() throws Exception{
		Reservation reservation = new Reservation();		
		Reservation returnReservation = new Reservation();		

		expect(mockDao.search(reservation)).andReturn(returnReservation);

		replay(mockDao);
		assertNotNull("ERROR RESERVATION NULL !!", reservationService.search(reservation));
		verify(mockDao);
	}

	@Ignore @Test
	public void delete() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore @Test
	public void select() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore @Test
	public void saveReservationInfo() {
		fail("Not yet implemented"); // TODO
	}

	@Ignore @Test
	public void getReservationGuests() {
		fail("Not yet implemented"); // TODO
	}

}
