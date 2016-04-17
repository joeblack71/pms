package reservations.service;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.myco.central.model.Segment;
import com.myco.central.reservations.service.SegmentService;
import com.myco.central.reservations.service.impl.SegmentServiceImpl;

import junit.framework.TestCase;

public class TestSegmentServiceImpl extends TestCase {
	private SegmentService segmentService;
	private static String idSegment;

	public TestSegmentServiceImpl(String name) {
		super(name);
		segmentService = new SegmentServiceImpl();
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
	
	public void testInsertSegment() {
		Segment segment = getNewItem();

		try {
			idSegment = segmentService.insert(segment);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(idSegment);
		//assertEquals("11",idSegment);
	}

	public void testUpdateSegment() {
		Segment segment = getNewItem();
		boolean result = false;

		try {
			segment.setIdSegment(idSegment);
			segment.setDescription("Updated");
			result = segmentService.update(segment);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue("*** No se actualizo registro ***", result);
	}

	public void testGetItemSegment() {
		Segment filter = getNewItem();
		Segment segment = null;

		try {
			filter.setIdSegment(idSegment);
			segment = segmentService.getItem(filter);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(segment);
		//assertEquals("BANK & FINANCIAL", segment.getDescription());
	}

	public void testDeleteSegment() {
		Segment segment = getNewItem();
		boolean result = false;

		try {
			segment.setIdSegment(idSegment);
			//segment.setIdSegment("01");
			result = segmentService.delete(segment);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		//assertTrue("*** No se elimino registro ***", result);
		assertEquals(true, result);
	}

	public void testList() {
		Segment filter = getNewItem();

		List<DynaBean> list = null;

		try {
			//filter.setStatus("A");
			filter.setDescription("");
			list = segmentService.list(filter);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

	/////////////////////
	/// Private interface
	/////////////////////

	private Segment getNewItem() {
		Segment item = new Segment();

		item.setIdHotel("01");
		item.setIdSource("001");
		item.setDescription("Segment_1");
		item.setMadeBy("JO");
		item.setUpdatedBy("JO");
		item.setStatus("A");

		return item;
	}

}
