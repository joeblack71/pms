/**
 * 
 */
package com.myco.central.commons.utils;

import java.time.Period;

/**
 * @author Developer
 *
 */
public final class PMSConstants {

	public static final String BLANK = "";

	/**{@value "N"} */
	public static final String NEW_RESERVATION_GUEST = "N";
	/**{@value "*"} */
	public static final String REMOVED_RESERVATION_GUEST = "*";

	// CATALOG'S ID
	/**{@value "1"} */
	public static final String TABLE_DOCUMENT_TYPES = "1";
	/**{@value "2"} */
	public static final String TABLE_TITLES = "2";
	/**{@value "3"} */
	public static final String TABLE_RESERVATION_STATUS = "3";
	/**{@value "4"} */
	public static final String TABLE_STREET_TYPES = "4";
	
	// EXCEPTION MESSAGES
	public static final String SUCCESSFUL_OPERATION = "OK";
	public static final String ER_DUP_ENTRY = "23000";

	public static final String DAO_EXCEPTION_MESSAGE = "Data access exception";
	public static final String SERVICE_EXCEPTION_MESSAGE = "Service exception";

	public static final Period ONE_QUARTER = Period.ofMonths(3);
	public static final Period ONE_SEMESTER = Period.ofMonths(6);
	public static final Period ONE_YEAR = Period.ofYears(1);

	private PMSConstants() {
	}

}
