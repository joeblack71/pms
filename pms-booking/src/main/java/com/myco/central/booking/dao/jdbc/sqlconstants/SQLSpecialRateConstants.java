/**
 * 
 */
package com.myco.central.booking.dao.jdbc.sqlconstants;

/**
 * @author Developer
 *
 */
public final class SQLSpecialRateConstants {

	/** 12 parameters */
	public static final String CTRLPI_SPECIAL_RATE =
		"{ call hotel.CTRLPI_SPECIAL_RATE(?, ?,?,?,?,?,?,?,?,?,?, ?) }";

	/** 12 parameters */
	public static final String CTRLPU_SPECIAL_RATE =
		"{ call hotel.CTRLPU_SPECIAL_RATE(?,?,?,?,?,?,?,?,?,?, ?,?) }";

	/** 3 parameters */
	public static final String CTRLPS_SPECIAL_RATE =
		"{ call hotel.CTRLPS_SPECIAL_RATE(?,?,?) }";

	/** 2 parameters */
	public static final String CTRLPD_SPECIAL_RATE =
		"{ call hotel.CTRLPD_SPECIAL_RATE(?,?); }";

	/** 3 parameters */
	public static final String CTRLPS_SPECIAL_RATE_LIST =
		"{ call hotel.CTRLPS_SPECIAL_RATE_LIST(?,?,?); }";

}
