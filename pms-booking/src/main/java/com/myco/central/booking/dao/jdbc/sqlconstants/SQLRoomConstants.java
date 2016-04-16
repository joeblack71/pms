/**
 * 
 */
package com.myco.central.booking.dao.jdbc.sqlconstants;

/**
 * @author Developer
 *
 */
public final class SQLRoomConstants {

	/** 13 parameters */
	public static final String CTRLPI_ROOM =
		"{ call hotel.CTRLPI_ROOM(?,?,?,?,?,?,?,?,?,?, ?,?,?) }";
	/** 13 parameters */
	public static final String CTRLPU_ROOM =
		"{ call hotel.CTRLPU_ROOM(?,?,?,?,?,?,?,?,?,?, ?,?,?) }";
	/** 3 parameters */
	public static final String CTRLPS_ROOM =
		"{ call hotel.CTRLPS_ROOM(?,?) }";
	/** 2 parameters */
	public static final String CTRLPD_ROOM =
		"{ call hotel.CTRLPD_ROOM(?,?); }";
	/** 2 parameters */
	public static final String CTRLPS_ROOM_LIST =
		"{ call hotel.CTRLPS_ROOM_LIST(?,?,?); }";

    public static final String SQL_INSERT = // TODO change to SP
    	"INSERT INTO room(" +
        " nHotelId, tRoomType, tRoomNumber," +
        " tDescription, tLocation, nRoomRate, nMaxBeds," +
        " tConnectRoom, nReservation, tRoomStatus," +
        " tHKStatus )" +
		" VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    public static final String SQL_UPDATE = // TODO change to SP
    	"UPDATE roomrack SET" +
        " tDescription = ?, tLocation = ?, nRoomRate = ?," +
        " nMaxBeds = ?, tConnectRoom = ?, nReservation = ?" +
        " tRoomStatus = ?, tHKStatus = ?" +
  		" WHERE nHotelId = ? AND tRoomType = ? AND tRoomNumber = ?";

    public static final String SQL_GET = // TODO change to SP
	    "DELETE FROM customer" +
	    " WHERE tDocumentType=? AND tDocumentNumber=?";

    public static final String SQL_DELETE = // TODO change to SP
    	"DELETE FROM roomrack" +
        " WHERE nHotelId = ? AND tRoomType = ? AND" +
              " tRoomNumber = ?";

    public static final String SQL_LIST = // TODO change to SP
    	"SELECT nIdHotel, nIdRoom, tRoomType,"
		 +       " tRoomNumber, tLocation, tDescription,"
		 +       " nRoomRate, nMaxBeds, tRoomConnection,"
		 +       " nIdReservation, tRoomStatus, tHKStatus"
		 +  " FROM hotel.room"
		 + " WHERE nIdHotel = ?"
     	 +   " AND tRoomType like ?"
     	 +   " AND tRoomStatus like ?";

    public static final String SQL_LIST_STATUS = // TODO change to SP
    	"SELECT r.nIdHotel, nIdRoom, "
		 +       " tRoomNumber, concat(tlastname1, ', ', tFirstNames)"
		 +  " FROM hotel.room r"
		 +       " left join hotel.reservation_guest rg"
		 +		 " on r.nIdReservation = rg.nIdReservation" 
		 +       " left join hotel.customer c"
		 +		 " on rg.nIdCustomer = c.nIdCustomer" 
		 + " WHERE r.nIdHotel = ?"
     	 +   " AND tRoomType like ?"
     	 +   " AND tRoomStatus like ?";
}
