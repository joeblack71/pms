package reservations.dao;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.reservations.dao.SpecialRateDao;
import com.myco.central.reservations.dao.jdbc.SpecialRateDaoJdbc;

import junit.framework.TestCase;

public class TestSpecialRateDaoJdbc extends TestCase {
	private SpecialRateDao specialRateDao;

	public TestSpecialRateDaoJdbc(String name) {
		super(name);
		specialRateDao = new SpecialRateDaoJdbc();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSpecialRateDaoJdbc() {
		fail("Not yet implemented");
	}

	public void testInsertSpecialRate() {
		fail("Not yet implemented");
	}

	public void testUpdateSpecialRate() {
		fail("Not yet implemented");
	}

	public void testGetItemSpecialRate() {
		fail("Not yet implemented");
	}

	public void testDeleteSpecialRate() {
		fail("Not yet implemented");
	}

	public void testList() {
		List<DynaBean> list = null;

		String idHotel = "1";
		String description = "";
		String status = "";

		try {
			list = specialRateDao.list(idHotel, description, status);
		} catch (DaoException ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

	public void testAddRoomTypeRate() {
		fail("Not yet implemented");
	}

	public void testGetSpecialRoomRate() {
		fail("Not yet implemented");
	}

}
