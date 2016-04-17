package reservations;

import reservations.dao.TestReservationDaoJdbc;
import reservations.service.TestAvailabilityService;
import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;

public class TestAll {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for test.reservations");

		//$JUnit-BEGIN$
		for(int i=1; i <= 1; i++) { // Add only one record
			suite.addTest(new TestReservationDaoJdbc("testInsertReservation"));
		}

		//suite.addTest(new TestAvailabilityService("testGetFlashStatus"));
		//$JUnit-END$

		return suite;
	}

}
