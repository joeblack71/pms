/**
 * 
 */
package com.myco.central.booking.dao.jdbc.sqlconstants;

/**
 * @author Developer
 *
 */
public final class SQLCustomerConstants {

	/** 28 parameters */
	public static final String CTRLPI_CUSTOMER =
		"{ call hotel.CTRLPI_CUSTOMER(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?) }";
	/** 28 parameters */
	public static final String CTRLPU_CUSTOMER =
		"{ call hotel.CTRLPU_CUSTOMER(?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?) }";
	/** 4 parameters */
	public static final String CTRLPS_CUSTOMER =
		"{ call hotel.CTRLPS_CUSTOMER(?,?,?,?) }";
	/** 2 parameters */
	public static final String CTRLPD_CUSTOMER =
		"{ call hotel.CTRLPD_CUSTOMER(?,?); }";
	/** 2 parameters */
	public static final String CTRLPS_CUSTOMER_LIST =
		"{ call hotel.CTRLPS_CUSTOMER_LIST(?,?); }";

}

