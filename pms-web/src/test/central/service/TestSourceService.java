package reservations.service;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.constants.TestConstantsMessages;
import com.myco.central.model.Address;
import com.myco.central.model.Phone;
import com.myco.central.model.Source;
import com.myco.central.reservations.service.SourceService;
import com.myco.central.reservations.service.impl.SourceServiceImpl;

import junit.framework.TestCase;

public class TestSourceService extends TestCase {
	private SourceService sourceService;
	private static String idSource;

	public TestSourceService(String name) {
		super(name);
		sourceService = new SourceServiceImpl();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	//////////////////////
	/// Testing method
	//////////////////////
	
	public void testInsertSource() {
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

	public void testUpdateSource() {
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

	public void testGetItemSource() {
		Source filter = getNewItem();
		Source source = null;

		try {
			//filter.setIdSource(idSource);
			filter.setIdSource("9");
			source = sourceService.getItem(filter);
		} catch (ServiceException ex) {
			ex.getMessage();
		}
		
		assertNotNull(source);
		assertEquals("www.asistp.com.pe", source.getWebPage());
	}

	public void testDeleteSource() {
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

	public void testList() {
		Source source = getNewItem();

		List<DynaBean> list = null;

		source.setHotelRegistration("");
		source.setSourceName("");
		source.setCommercialName("");
		source.setStatus("");

		try {
			list = sourceService.list(source);
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
