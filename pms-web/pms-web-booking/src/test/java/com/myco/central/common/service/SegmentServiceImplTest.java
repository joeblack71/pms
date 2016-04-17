package com.myco.central.commons.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.commons.model.Segment;
import com.myco.central.util.Messages;

public class SegmentServiceImplTest extends AbstractCommonsBaseTest {

	@Autowired
	private SegmentService segmentService;

	private static String idSegment;

	@Test
	public void insertSegment() {
//		Segment segment = getNewItem();

		try {
			idSegment = segmentService.insert(null);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(Messages.getString("test.error.null_result"), idSegment);
		//assertEquals("11",idSegment);
	}

	public void updateSegment() {
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

	public void searchSegment() {
		Segment filter = getNewItem();
		Segment segment = null;

		try {
			filter.setIdSegment(idSegment);
			segment = segmentService.search(filter);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		assertNotNull(segment);
		//assertEquals("BANK & FINANCIAL", segment.getDescription());
	}

	public void deleteSegment() {
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

	public void select() {
		Segment filter = getNewItem();

		List<Map<String, Object>> list = null;

		try {
			//filter.setStatus("A");
			filter.setDescription("");
			list = segmentService.select(filter);
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
