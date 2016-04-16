package com.myco.central.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.model.Address;
import com.myco.central.core.service.impl.SourceServiceImpl;
import com.myco.central.model.Source;

public class SourceServiceTest {
	private static Long sourceId;
	private SourceServiceImpl sourceService;

	public void DeleteSource() {
		Source source = getNewItem();
		try {
			source.setId(sourceId);
			sourceService.remove(source);
		} catch (ServiceException ex) {
			ex.getMessage();
		}

		//		assertTrue(TestConstantsMessages.FAIL_DELETE, result);
	}

	private Source getNewItem() {
		Source source = new Source();

		Address sourceAddress = new Address();

		source.setSourceName("ASIS TP S.A.");
		source.setCommercialName("ASIS");
		//source.setDocumentNumber("20134794617");

		source.setCategory("");

		sourceAddress.setStreetType("1"); // Avenue
		sourceAddress.setStreetName("MIGUEL DASSO"); // La Floresta
		sourceAddress.setStreetNumber("258"); // 135
		sourceAddress.setInterior("204"); // 135
		sourceAddress.setComplement("Block C"); // Dpto. 304
		sourceAddress.setCountry("1"); // Peru
		sourceAddress.setCity("LIMA");
		sourceAddress.setDistrict("1");
		sourceAddress.setZipCode("LIMA 28");

//		source.setAddress(sourceAddress);
//
//		source.setPhone1(new Phone(null, "2427799") );
//		source.setPhone2(new Phone(null, "3659988") );


		source.setHsDowRate(100.00);
		source.setHsEowRate(100.00);
		source.setLsDowRate(100.00);
		source.setLsEowRate(100.00);

		source.setSpecialRate(100.00); // ID
		// source.setCreditType("1");
		source.setHotelRegistration("01");
		source.setWebPage("");

		source.setSegmentId(1l); // ID
		source.setSourceType("4"); // ID
		source.setCategory("A");

		source.setCreatedBy("JO");
		source.setUpdatedBy("JO");
		source.setStatus("A");

		return source;
	}

	@Test
	public void InsertSource() {
		Source source = getNewItem();

		try {
			source.setDocumentNumber("20100970962");
			source.setSourceName("DORAL S.A.");
			source.setCommercialName("EL DORAL");
			sourceService.save(source);
		} catch (ServiceException ex) {
			ex.getMessage();
		}

		assertNotNull(sourceId);
		//assertEquals("", idSource);
	}

	public void searchSource() {
		Source source = null;

		try {
			source = sourceService.get(1l);
		} catch (ServiceException ex) {
			ex.getMessage();
		}

		assertNotNull(source);
		assertEquals("www.asistp.com.pe", source.getWebPage());
	}

	public void select() {
		Source source = getNewItem();

		List<Source> list = null;

		source.setHotelRegistration("");
		source.setSourceName("");
		source.setCommercialName("");
		source.setStatus("");

		try {
			list = sourceService.search(source);
		} catch (ServiceException ex) {
			ex.getMessage();
		}

		assertNotNull(list);
		assertTrue(list.size() > 0);
		assertEquals(2, list.size());
	}

	public void UpdateSource() {
		Source source = getNewItem();
		String result = null;

		try {
			source.setId(1l);
			source.setDocumentNumber("20100970962");
			source.setCommercialName("EL DORAL");
			source.setSegmentId(1l);
			source.setSourceType("2");
			source.setCategory("B");
			sourceService.update(source);
		} catch (ServiceException ex) {
			ex.getMessage();
		}

		assertNotNull(result);
	}

}
