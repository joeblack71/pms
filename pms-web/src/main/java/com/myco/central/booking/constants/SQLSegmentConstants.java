/**
 * 
 */
package com.myco.central.constants;

/**
 * @author Developer
 *
 */
public final class SQLSegmentConstants {

	/** 6 parameters */
	public static final String CTRLPI_SEGMENT =
		"{ call hotel.CTRLPI_SEGMENT(?,?,?,?,?,?) }";
	/** 6 parameters */
	public static final String CTRLPU_SEGMENT =
		"{ call hotel.CTRLPU_SEGMENT(?,?,?,?,?,?) }";
	/** 2 parameters */
	public static final String CTRLPS_SEGMENT =
		"{ call hotel.CTRLPS_SEGMENT(?,?) }";
	/** 2 parameters */
	public static final String CTRLPD_SEGMENT =
		"{ call hotel.CTRLPD_SEGMENT(?,?); }";
	/** 3 parameters */
	public static final String CTRLPS_SEGMENT_LIST =
		"{ call hotel.CTRLPS_SEGMENT_LIST(?,?,?); }";

}
