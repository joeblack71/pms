package com.myco.central.reservations.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.myco.central.reservations.domain.Rate;

public class RateServiceTest extends AbstractCentralBaseTest {
	private RateService rateService;
	private static String idRate;

	@Test
	public void InsertRate() {
		Rate rate = getNewItem();
		
		try {
			idRate = rateService.insert(rate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull("No se inserto registro", idRate);
	}

	public void UpdateRate() {
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

	public void searchRate() {
		Rate rate = getNewItem();
		
		try {
			rate.setIdSpecialRate(idRate);
			rate = rateService.search(rate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull("No se recupero registro", rate);
	}

	public void DeleteRate() {
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

	public void select() {
		Rate filter = getNewItem();
		List<Map<String, Object>> list = null;

		try {
			list = rateService.select(filter);
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
