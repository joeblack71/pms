/**
 * 
 */
package com.myco.central.booking.dao.jdbc.sqlconstants;

/**
 * @author Developer
 *
 */
public final class SQLCountryConstants {

	/** 4 parameters */
	public static final String CTRLPI_COUNTRY =
		"{ call hotel.CTRLPI_COUNTRY(?,?,?,?) }";
	/** 4 parameters */
	public static final String CTRLPU_COUNTRY =
		"{ call hotel.CTRLPU_COUNTRY(?,?,?,?) }";
	/** 1 parameters */
	public static final String CTRLPS_COUNTRY =
		"{ call hotel.CTRLPS_COUNTRY(?) }";
	/** 1 parameters */
	public static final String CTRLPD_COUNTRY =
		"{ call hotel.CTRLPD_COUNTRY(?); }";
	/** 1 parameters */
	public static final String CTRLPS_COUNTRY_LIST =
		"{ call hotel.CTRLPS_COUNTRY_LIST(?); }";

}
