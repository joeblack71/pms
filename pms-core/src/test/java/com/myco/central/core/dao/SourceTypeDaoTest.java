package com.myco.central.core.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.myco.central.core.util.AbstractCoreBaseTest;
import com.myco.central.core.util.CoreMockFactoryTest;
import com.myco.central.model.SourceType;

public class SourceTypeDaoTest extends AbstractCoreBaseTest {
	private SourceTypeDao sourceTypeDao;
	private static Long sourceTypeId;

	SourceType sourceType = CoreMockFactoryTest.newSourceType();

	@Test
	public void insertSourceType() {
		
		SourceType persistedType = null;
		try {
			persistedType = sourceTypeDao.save(sourceType);
		} catch(Exception ex) {
			ex.getMessage();
		}
		
		assertNotNull(persistedType);
	}

	@Test
	public void updateSourceType() {
		SourceType result = null;
		
		try {
			sourceType.setSourceTypeId(sourceTypeId);
			result = sourceTypeDao.save(sourceType);
		} catch(Exception ex) {
			ex.getMessage();
		}
		
		assertNotNull(result);
	}

	@Test
	public void searchSourceType() {
		
		List<SourceType> list = null;
		try {
			sourceType.setSourceTypeId(sourceTypeId);
			list = sourceTypeDao.search(sourceType);
		} catch(Exception ex) {
			ex.getMessage();
		}
		
		assertNotNull(list);
	}

	@Test
	public void deleteSourceType() {

		try {
			sourceType.setSourceTypeId(sourceTypeId);
			sourceTypeDao.remove(sourceType);
		} catch(Exception ex) {
			ex.getMessage();
		}
		
//		assertTrue(result);
	}

	@Test
	public void listSourceType() {
		SourceType filter = new SourceType();
		
		List<SourceType> list = null;
		
		try {
			//filter.setDescription("");
			filter.setStatus("A");
			list = sourceTypeDao.search(filter);
		} catch(Exception ex) {
			ex.getMessage();
		}
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

}
