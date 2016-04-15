package reservations.service;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import junit.framework.TestCase;

import com.myco.central.model.Rate;
import com.myco.central.reservations.service.RateService;
import com.myco.central.reservations.service.impl.RateServiceImpl;

public class TestRateService extends TestCase {
	private RateService rateService;
	private static String idRate;

	public TestRateService(String name) {
		super(name);
		rateService = new RateServiceImpl();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	////////////////////
	/// Testing methods
	////////////////////
	
	public void testInsertRate() {
		Rate rate = getNewItem();
		
		try {
			idRate = rateService.insert(rate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull("No se inserto registro", idRate);
	}

	public void testUpdateRate() {
		Rate rate = getNewItem();
		boolean result = false;
		
		try {
			rate.setIdSpecialRate(idRate);
			result = rateService.update(rate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue("No se actualizo registro", result);
	}

	public void testGetItemRate() {
		Rate rate = getNewItem();
		
		try {
			rate.setIdSpecialRate(idRate);
			rate = rateService.getItem(rate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull("No se recupero registro", rate);
	}

	public void testDeleteRate() {
		Rate rate = getNewItem();
		boolean result = false;
		
		try {
			rate.setIdSpecialRate(idRate);
			result = rateService.delete(rate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue("No se inserto registro", result);
	}

	public void testList() {
		Rate filter = getNewItem();
		List<DynaBean> list = null;

		try {
			list = rateService.list(filter);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

	/////////////////////
	/// Private interface
	/////////////////////
	
	private Rate getNewItem() {
		Rate rate = new Rate();
		
		rate.setIdHotel("01");
		rate.setIdRoomType("1");
		rate.setIdPeriod("1");
		rate.setRoomValue("50");
		rate.setMadeBy("JO.");
		rate.setStatus("A");
		
		return rate;
	}
}
