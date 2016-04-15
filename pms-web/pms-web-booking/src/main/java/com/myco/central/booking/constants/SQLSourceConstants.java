/**
 * 
 */
package com.myco.central.constants;

/**
 * @author Developer
 *
 */
public final class SQLSourceConstants {

	/** 25 parameters */
	public static final String CTRLPI_SOURCE =
		"{ call hotel.CTRLPI_SOURCE(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?) }";
	/** 25 parameters */
	public static final String CTRLPU_SOURCE =
		"{ call hotel.CTRLPU_SOURCE(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?) }";
	/** 3 parameters */
	public static final String CTRLPS_SOURCE =
		"{ call hotel.CTRLPS_SOURCE(?,?,?) }";
	/** 2 parameters */
	public static final String CTRLPD_SOURCE =
		"{ call hotel.CTRLPD_SOURCE(?); }";
	/** 4 parameters */
	public static final String CTRLPS_SOURCE_LIST =
		"{ call hotel.CTRLPS_SOURCE_LIST(?,?,?,?); }";

}
