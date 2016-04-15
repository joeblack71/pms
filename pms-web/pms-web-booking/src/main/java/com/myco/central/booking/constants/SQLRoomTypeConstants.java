/**
 * 
 */
package com.myco.central.constants;

/**
 * @author Developer
 *
 */
public final class SQLRoomTypeConstants {

	/** 8 parameters */
	public static final String CTRLPI_ROOMTYPE =
		"{ call hotel.CTRLPI_ROOMTYPE(?,?,?,?,?,?,?,?,?) }";
	/** 7 parameters */
	public static final String CTRLPU_ROOMTYPE =
		"{ call hotel.CTRLPU_ROOMTYPE(?,?,?,?,?,?,?,?,?); }";
	/** 3 parameters */
	public static final String CTRLPS_ROOMTYPE =
		"{ call hotel.CTRLPS_ROOMTYPE(?,?,?) }";
	/** 2 parameters */
	public static final String CTRLPD_ROOMTYPE =
		"{ call hotel.CTRLPD_ROOMTYPE(?,?); }";
	/** 1 parameters */
	public static final String CTRLPS_ROOMTYPE_LIST =
		"{ call hotel.CTRLPS_ROOMTYPE_LIST(?,?); }";

}

