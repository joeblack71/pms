/**
 * 
 */
package com.myco.central.constants;

/**
 * @author Developer
 *
 */
public final class CentralModuleConstants {

	////////////////////
	/// Generics
	////////////////////
	
	public static final String BLANK = "";

	// MODULE ATTRIBUTES
	public static final String SESSION_ATTRIBUTES = "sessionAttributes";
	public static final String CONTEXT_ATTRIBUTES = "contextAttributes";

	// TRANSACTIONS
	/**{@value "I"} */
	public static final String INSERT_RECORD = "I";
	/**{@value "U"} */
	public static final String UPDATE_RECORD = "U";
	/**{@value "D"} */
	public static final String DELETE_RECORD = "D";

	/**{@value "N"} */
	public static final String NEW_RESERVATION_GUEST = "N";
	/**{@value "*"} */
	public static final String REMOVED_RESERVATION_GUEST = "*";

	/**{@value "DI"} */
	public static final String DISABLED_INSERT = "true";

	// Identificador de tablas genericas
	/**{@value "1"} */
	public static final String TABLE_DOCUMENT_TYPES = "1";
	/**{@value "2"} */
	public static final String TABLE_TITLES = "2";
	/**{@value "3"} */
	public static final String TABLE_RESERVATION_STATUS = "3";
	/**{@value "4"} */
	public static final String TABLE_STREET_TYPES = "4";
	
	// HOTEL ACCOUNTS
	public static final String CREDIT_ACCOUNT = "C";
	public static final String DEBIT_ACCOUNT = "D";

	// GENERICS
	/**{@value "A"} */
	public static final String ACTIVE_STATUS = "A";
	/**{@value "A"} */
	public static final String PENDENT_STATUS = "P";

	// RESERVATIONS
	/** {@value 1} */
	public static final short WEEKLY = 1;
	/** {@value 2} */
	public static final short MONTHLY = 2;
	/** {@value 3} */
	public static final short QUARTERLY = 3;
	/** {@value 4} */
	public static final short HALF_YEARLY = 4;
	/** {@value 5} */
	public static final short YEARLY = 5;

	// EXCEPTION MESSAGES
	
	public static final String SUCCESSFUL_OPERATION = "OK";
	public static final String ER_DUP_ENTRY = "23000";

	public static final String MESSAGE_DAO_EXCEPTION = "Data access exception";

	public static final String MESSAGE_SERVICE_EXCEPTION = "Service exception";

	// PERIOD DAYS
	
	public static final int WEEK = 7;
	public static final int MONTH = 30;
	public static final int QUARTER = 4;

}
