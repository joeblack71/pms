/**
 * 
 */
package com.myco.central.constants;

/**
 * @author Developer
 *
 */
public final class SQLSourceTypeConstants {

	/** 4 parameters */
	public static final String CTRLPI_SOURCE_TYPE =
		"{ call hotel.CTRLPI_SOURCE_TYPE(?,?,?,?) }";
	/** 5 parameters */
	public static final String CTRLPU_SOURCE_TYPE =
		"{ call hotel.CTRLPU_SOURCE_TYPE(?,?,?,?,?) }";
	/** 2 parameters */
	public static final String CTRLPS_SOURCE_TYPE =
		"{ call hotel.CTRLPS_SOURCE_TYPE(?,?) }";
	/** 1 parameters */
	public static final String CTRLPD_SOURCE_TYPE =
		"{ call hotel.CTRLPD_SOURCE_TYPE(?); }";
	/** 2 parameters */
	public static final String CTRLPS_SOURCE_TYPE_LIST =
		"{ call hotel.CTRLPS_SOURCE_TYPE_LIST(?,?); }";

}
