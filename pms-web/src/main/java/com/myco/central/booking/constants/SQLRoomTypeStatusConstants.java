/**
 * 
 */
package com.myco.central.constants;

/**
 * @author Developer
 *
 */
public final class SQLRoomTypeStatusConstants {

	/** 12 parameters */
	public static final String CTRLPI_ROOMTYPE_STATUS =
		"{ call hotel.CTRLPI_ROOMTYPE_STATUS(?,?,?,?,?,?,?,?,?,?, ?) }";
	/** 28 parameters */
	public static final String CTRLPU_ROOMTYPE_STATUS =
		"{ call hotel.CTRLPU_ROOMTYPE_STATUS(?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?) }";
	/** 4 parameters */
	public static final String CTRLPS_ROOMTYPE_STATUS =
		"{ call hotel.CTRLPS_ROOMTYPE_STATUS(?,?,?,?) }";
	/** 2 parameters */
	public static final String CTRLPD_ROOMTYPE_STATUS =
		"{ call hotel.CTRLPD_ROOMTYPE_STATUS(?,?); }";
	/** 2 parameters */
	public static final String CTRLPS_ROOMTYPE_STATUS_LIST =
		"{ call hotel.CTRLPS_ROOMTYPE_STATUS_LIST(?,?,?,?); }";

}

