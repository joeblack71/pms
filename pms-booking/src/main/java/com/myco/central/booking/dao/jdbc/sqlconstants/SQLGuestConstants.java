/**
 * 
 */
package com.myco.central.booking.dao.jdbc.sqlconstants;

/**
 * @author Developer
 *
 */
public final class SQLGuestConstants {

	/** 24 parameters */
	public static final String CTRLPI_GUEST =
		"{ call hotel.CTRLPI_GUEST(?,?,?,?) }";
	/** 25 parameters */
	public static final String CTRLPU_GUEST =
		"{ call hotel.CTRLPU_GUEST(?,?,?,?) }";
	/** 3 parameters */
	public static final String CTRLPS_GUEST =
		"{ call hotel.CTRLPS_GUEST(?,?,?) }";
	/** 2 parameters */
	public static final String CTRLPD_GUEST =
		"{ call hotel.CTRLPD_GUEST(?,?); }";
	/** 2 parameters */
	public static final String CTRLPS_GUEST_LIST =
		"{ call hotel.CTRLPS_GUEST_LIST(?,?); }";

    public static final String SQL_INSERT = // TODO change to SP
    	" INSERT INTO customer("
		 + " tLastName1, tLastName2, tFirstNames, tBirthDate,"
		 + " nIdNationality, tTitle, nDocumentType,	tDocumentNumber,"
		 + " tAddress1, tAddress2, tDistrict, tCity, nIdCountry,"
		 + " tZipCode, nPhone1, nPhone2, nMovilPhone, tEmail,"
		 + " tOccupation, nVipStatus, tRequests, nHotelRegistration,"
		 + " tMadeBy, dMadeOn )"
	 	 + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP());";

    public static final String SQL_UPDATE = // TODO change to SP
   	 "UPDATE customer SET"
		   + "       tLastName1=?, tLastName2=?, tFirstNames=?,"
		   + " 		 dBirthDate=str_to_date(?, get_format(DATE,'ISO') ), nIdNationality=?, nTitle=?,"
		   + " 		 nDocumentType=?, tDocumentNumber=?,"
		   + " 		 tAddress1=?, tAddress2=?, tDistrict=?, tCity=?, nIdCountry=?,"
		   + " 		 tZipCode=?, nPhone1=?, nPhone2=?, nMovilPhone=?, tEmail=?,"
		   + " 		 tOccupation=?, nVipStatus=?, tRequests=?,"
		   + " 		 tMadeBy=?, tStatus=?"
		   + " WHERE nIdCustomer=?";

    public static final String SQL_DELETE = // TODO change to SP
	    "DELETE FROM customer" +
	    " WHERE tDocumentType=? AND tDocumentNumber=?";
}

