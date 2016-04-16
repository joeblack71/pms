package com.myco.central.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.core.util.AbstractCoreBaseTest;
import com.myco.central.core.util.Messages;
import com.myco.central.model.Segment;
@Ignore
public class SegmentServiceTest extends AbstractCoreBaseTest {

	@Autowired
	private SegmentService segmentService;

	private static Long segmentId;

	@Test
	public void insertSegment() {
		try {
			segmentService.save(new Segment());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
//		TODO update assertion
		assertNotNull(Messages.getString("test.error.null_result"), segmentId);
		assertEquals("11", segmentId);
	}

	public void updateSegment() {
		Segment segment = getNewItem();
		boolean result = false;

		try {
			segment.setId(segmentId);
			segment.setDescription("Updated");
			segmentService.update(segment);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertTrue("*** No se actualizo registro ***", result);
	}

	public void getSegment() {
		Segment segment = null;

		try {
			segment = segmentService.get(1l);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(segment);
		assertEquals("BANK & FINANCIAL", segment.getDescription());
	}

	public void deleteSegment() {
		Segment segment = getNewItem();
		boolean result = false;

		try {
			segment.setId(segmentId);
			//segment.setIdSegment("01");
			segmentService.remove(segment);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		//assertTrue("*** No se elimino registro ***", result);
		assertEquals(true, result);
	}

	public void select() {
		Segment filter = getNewItem();

		List<Segment> list = null;

		try {
			//filter.setStatus("A");
			filter.setDescription("");
			list = segmentService.search(filter);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

	private Segment getNewItem() {
		Segment item = new Segment();

		item.setHotelId(1l);
		item.setSourceId(1l);
		item.setDescription("Segment_1");
		item.setCreatedBy("JO");
		item.setUpdatedBy("JO");
		item.setStatus("A");

		return item;
	}

}
