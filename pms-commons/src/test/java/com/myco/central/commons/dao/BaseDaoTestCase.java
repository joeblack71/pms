package com.myco.central.commons.dao;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for running DAO tests.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * @author jgarcia (updated: migrate to hibernate 4; moved from compass-search to hibernate-search
 */
/*@ContextConfiguration(locations = { "classpath:/applicationContext-resources.xml", "classpath:/applicationContext-dao.xml",
        "classpath*:/applicationContext.xml", "classpath:**"/applicationContext*.xml" })*/
public abstract class BaseDaoTestCase /*extends AbstractTransactionalJUnit4SpringContextTests*/ {
	// @Autowired
    private SessionFactory sessionFactory;

    /**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
	protected final Logger log = LoggerFactory.getLogger(getClass().getSimpleName());
    /**
     * ResourceBundle loaded from src/test/resources/${package.name}/ClassName.properties (if exists)
     */
    protected ResourceBundle rb;

    /**
     * Default constructor - populates "rb" variable if properties file exists for the class in
     * src/test/resources.
     */
    public BaseDaoTestCase() {
        // Since a ResourceBundle is not required for each class, just
        // do a simple check to see if one exists
        String className = this.getClass().getName();

        try {
            rb = ResourceBundle.getBundle(className);
        }
        catch (MissingResourceException mre) {
            log.trace("No resource bundle found for: " + className);
        }
    }

    /**
     * Flush search indexes, to be done after a reindex() or reindexAll() operation
     */
    public void flushSearchIndexes() {
		@SuppressWarnings("unused")
		Session currentSession = sessionFactory.getCurrentSession();
		// final FullTextSession fullTextSession =
		// Search.getFullTextSession(currentSession);
		// fullTextSession.flushToIndexes();
    }

    /**
     * Utility method to populate a javabean-style object with values
     * from a Properties file
     *
     * @param obj the model object to populate
     * @return Object populated object
     * @throws Exception if BeanUtils fails to copy properly
     */
    protected Object populate(final Object obj) throws Exception {
        // loop through all the beans methods and set its properties from its .properties file
        Map<String, String> map = new HashMap<String, String>();

        for (Enumeration<String> keys = rb.getKeys(); keys.hasMoreElements();) {
            String key = keys.nextElement();
            map.put(key, rb.getString(key));
        }

		// BeanUtils.copyProperties(obj, map);

        return obj;
    }
}
