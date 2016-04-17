package com.myco.central.commons.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.model.Address;
import com.myco.central.commons.model.Phone;
import com.myco.central.commons.model.Source;
import com.myco.central.commons.service.SourceService;
import com.myco.central.reservations.service.AbstractCentralBaseTest;
import com.myco.central.util.TestConstantsMessages;

public class SourceServiceTest extends AbstractCentralBaseTest {
	private SourceService sourceService;
	private static String idSource;

	@Test
	public void InsertSource() {
		Source source = getNewItem();

		try {
			source.setDocumentNumber("20100970962");
			source.setSourceName("DORAL S.A.");
			source.setCommercialName("EL DORAL");
			idSource = sourceService.insert(source);
		} catch (ServiceException ex) {
			ex.getMessage();
		}
		
		assertNotNull(idSource);
		//assertEquals("", idSource);
	}

	public void UpdateSource() {
		Source source = getNewItem();
		String result = null;

		try {
			//source.setIdSource(idSource);
			source.setIdSource("10");
			source.setDocumentNumber("20100970962");
			source.setCommercialName("EL DORAL");
			source.setSegment("2"); // ID
			source.setSourceType("2"); // ID
			source.setCategory("B");
			result = sourceService.update(source);
		} catch (ServiceException ex) {
			ex.getMessage();
		}
		
		assertNotNull(result);
		assertEquals("OK", result);
	}

	public void searchSource() {
		Source filter = getNewItem();
		Source source = null;

		try {
			//filter.setIdSource(idSource);
			filter.setIdSource("9");
			source = sourceService.search(filter);
		} catch (ServiceException ex) {
			ex.getMessage();
		}
		
		assertNotNull(source);
		assertEquals("www.asistp.com.pe", source.getWebPage());
	}

	public void DeleteSource() {
		Source source = getNewItem();
		boolean result = false;

		try {
			source.setIdSource(idSource);
			source.setIdSource("10");
			result = sourceService.delete(source);
		} catch (ServiceException ex) {
			ex.getMessage();
		}
		
		assertTrue(TestConstantsMessages.FAIL_DELETE, result);
	}

	public void select() {
		Source source = getNewItem();

		List<Map<String, Object>> list = null;

		source.setHotelRegistration("");
		source.setSourceName("");
		source.setCommercialName("");
		source.setStatus("");

		try {
			list = sourceService.select(source);
		} catch (ServiceException ex) {
			ex.getMessage();
		}
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
		assertEquals(2, list.size());
	}

	/////////////////////
	///Private interface
	/////////////////////
	
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
		
		source.setAddress(sourceAddress);

        source.setPhone1(new Phone(null, "2427799") );
        source.setPhone2(new Phone(null, "3659988") );


		source.setHsDowRate("");
		source.setHsEowRate("");
		source.setLsDowRate("");
		source.setLsEowRate("");
		
		source.setSpecialRate("01"); // ID
		source.setCreditType("1");
		source.setHotelRegistration("01");
		source.setWebPage("");

		source.setSegment("1"); // ID
		source.setSourceType("4"); // ID
		source.setCategory("A");

		source.setMadeBy("JO");
		source.setUpdatedBy("JO");
		source.setStatus("A");
		
		return source;
	}
	
}
