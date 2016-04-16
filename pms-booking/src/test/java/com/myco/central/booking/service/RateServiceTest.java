package com.myco.central.booking.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.myco.central.booking.model.Rate;
import com.myco.central.booking.utils.AbstractBookingBaseTest;

public class RateServiceTest extends AbstractBookingBaseTest {
	private RateService rateService;
	private static Long rateId;

	@Test
	public void insertRate() {
		Rate rate = getNewItem();
		
		try {
			rateService.save(rate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull("No se inserto registro", rateId);
	}

	public void updateRate() {
		Rate rate = getNewItem();
		boolean result = false;
		
		try {
			rate.setSpecialRateId(rateId);
			rateService.update(rate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue("No se actualizo registro", result);
	}

	public void searchRate() {
		Rate rate = getNewItem();
		
		List<Rate> list = null;
		try {
			rate.setSpecialRateId(rateId);
			list = rateService.search(rate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull("No se recupero registro", list);
	}

	public void DeleteRate() {
		Rate rate = getNewItem();
		boolean result = false;
		
		try {
			rate.setSpecialRateId(rateId);
			rateService.remove(rate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue("No se inserto registro", result);
	}

	public void select() {
		Rate filter = getNewItem();
		List<Rate> list = null;

		try {
			list = rateService.search(filter);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

	private Rate getNewItem() {
		Rate rate = new Rate();
		
		rate.setHotelId(1l);
		rate.setRoomTypeId(1l);
		rate.setPeriodId(1l);
		rate.setRoomValue(50.00);
		rate.setCreatedBy("JO.");
		rate.setStatus("A");
		
		return rate;
	}
}
