package com.myco.central.reservations.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.myco.central.commons.dao.SourceTypeDao;
import com.myco.central.commons.model.SourceType;
import com.myco.central.reservations.service.AbstractCentralBaseTest;
import com.myco.central.util.MockFactoryCentralTest;

public class SourceTypeDaoTest extends AbstractCentralBaseTest {
	private SourceTypeDao sourceTypeDao;
	private static String idSourceType;

	SourceType sourceType = MockFactoryCentralTest.newSourceType();

	@Test
	public void insertSourceType() {
		
		try {
			idSourceType = sourceTypeDao.insert(sourceType);
		} catch(Exception ex) {
			ex.getMessage();
		}
		
		assertNotNull(idSourceType);
	}

	@Test
	public void updateSourceType() {
		boolean result = false;
		
		try {
			sourceType.setIdSourceType(idSourceType);
			result = sourceTypeDao.update(sourceType);
		} catch(Exception ex) {
			ex.getMessage();
		}
		
		assertTrue(result);
	}

	@Test
	public void searchSourceType() {
		
		try {
			sourceType.setIdSourceType(idSourceType);
			sourceType = sourceTypeDao.search(sourceType);
		} catch(Exception ex) {
			ex.getMessage();
		}
		
		assertNotNull(sourceType);
	}

	@Test
	public void deleteSourceType() {
		boolean result = false;

		try {
			sourceType.setIdSourceType(idSourceType);
			result = sourceTypeDao.delete(sourceType);
		} catch(Exception ex) {
			ex.getMessage();
		}
		
		assertTrue(result);
	}

	@Test
	public void listSourceType() {
		SourceType filter = new SourceType();
		
		List<Map<String, Object>> list = null;
		
		try {
			//filter.setDescription("");
			filter.setStatus("A");
			list = sourceTypeDao.select(filter);
		} catch(Exception ex) {
			ex.getMessage();
		}
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

}
