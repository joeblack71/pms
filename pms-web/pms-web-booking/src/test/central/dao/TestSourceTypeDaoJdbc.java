package reservations.dao;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.myco.central.model.SourceType;
import com.myco.central.reservations.dao.SourceTypeDao;
import com.myco.central.reservations.dao.SourceTypeDaoJdbc;

import junit.framework.TestCase;

public class TestSourceTypeDaoJdbc extends TestCase {
	private SourceTypeDao sourceTypeDao;
	private static String idSourceType;

	public TestSourceTypeDaoJdbc(String name) {
		super(name);
		sourceTypeDao = new SourceTypeDaoJdbc();
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
	
	public void testInsertSourceType() {
		SourceType sourceType = getNewSourceType();
		
		try {
			idSourceType = sourceTypeDao.insert(sourceType);
		} catch(Exception ex) {
			ex.getMessage();
		}
		
		assertNotNull(idSourceType);
	}

	public void testUpdateSourceType() {
		SourceType sourceType = getNewSourceType();
		
		boolean result = false;
		
		try {
			sourceType.setIdSourceType(idSourceType);
			result = sourceTypeDao.update(sourceType);
		} catch(Exception ex) {
			ex.getMessage();
		}
		
		assertTrue(result);
	}

	public void testGetItemSourceType() {
		SourceType sourceType = null;
		SourceType filter = getNewSourceType();
		
		try {
			filter.setIdSourceType(idSourceType);
			sourceType = sourceTypeDao.getItem(filter);
		} catch(Exception ex) {
			ex.getMessage();
		}
		
		assertNotNull(sourceType);
	}

	public void testDeleteSourceType() {
		SourceType sourceType = getNewSourceType();
		
		boolean result = false;

		try {
			sourceType.setIdSourceType(idSourceType);
			result = sourceTypeDao.delete(sourceType);
		} catch(Exception ex) {
			ex.getMessage();
		}
		
		assertTrue(result);
	}

	public void testListSourceType() {
		SourceType filter = new SourceType();
		
		List<DynaBean> list = null;
		
		try {
			//filter.setDescription("");
			filter.setStatus("A");
			list = sourceTypeDao.list(filter);
		} catch(Exception ex) {
			ex.getMessage();
		}
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}

	/////////////////////
	///Private interface
	/////////////////////
	
	private SourceType getNewSourceType() {
		SourceType bean = new SourceType();

		bean.setDescription("TESTING");
		bean.setAbbreviation("TEST");
		bean.setStatus("A");
		bean.setMadeBy("JO.");

		return bean;
	}


}
