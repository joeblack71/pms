/**
 * 
 */
package com.myco.central.booking.dao.jdbc.sqlconstants;

/**
 * @author Developer
 *
 */
public final class SQLCityConstants {

	/** 4 parameters */
	public static final String CTRLPI_CITY =
		"{ call hotel.CTRLPI_CITY(?,?,?,?) }";
	/** 4 parameters */
	public static final String CTRLPU_CITY =
		"{ call hotel.CTRLPU_CITY(?,?,?,?) }";
	/** 1 parameters */
	public static final String CTRLPS_CITY =
		"{ call hotel.CTRLPS_CITY(?,?) }";
	/** 2 parameters */
	public static final String CTRLPD_CITY =
		"{ call hotel.CTRLPD_CITY(?,?); }";
	/** 1 parameters */
	public static final String CTRLPS_CITY_LIST =
		"{ call hotel.CTRLPS_CITY_LIST(?); }";

}
