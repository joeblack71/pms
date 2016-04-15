/**
 * 
 */
package com.myco.central.constants;

/**
 * @author Developer
 *
 */
public final class SQLReservationConstants {

	/** 23 parameters */
	public static final String CTRLPI_RESERVATION =
		"{ call CTRLPI_RESERVATION(?,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?); }";
	/** 19 parameters */
	public static final String CTRLPU_RESERVATION =
		"{ call hotel.CTRLPU_RESERVATION(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?); }";
	/** 2 parameters */
	public static final String CTRLPS_RESERVATION =
		"{ call CTRLPS_RESERVATION(?,?); }";
	/** 2 parameters */
	public static final String CTRLPD_RESERVATION =
		"{ call CTRLPD_RESERVATION(?,?); }";
	/** 2 parameters */
	public static final String CTRLPS_RESERVATION_LIST =
		"{call CTRLPS_RESERVATION_LIST(?,?)}";

	//// Guest service
	/** 3 parameters */
	public static final String SP_RESERVATION_GUEST_LIST =
		"{ call CMSP_RESERVATION_GUEST_LIST(?,?,?); }";

	/** 2 parameters */
	public static final String SP_RESERVATION_GUEST_DELETE =
		"{ call CMSP_GUEST_DELETE(?,?) }";

	/** 3 parameters */
	public static final String SP_RESERVATION_GUEST_UPDATE =
		"{ call CMSP_GUEST_INSERT(?,?,?) }";

}
