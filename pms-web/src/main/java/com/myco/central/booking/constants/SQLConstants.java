/**
 * 
 */
package com.myco.central.constants;

/**
 * @author Developer
 *
 */
public final class SQLConstants {

	public static final String SQL_LAST_INSERTED_ID =
		"SELECT LAST_INSERT_ID()";

	public static final String SQL_CHARGE_ARRIVALS = // TODO change to SP
    	"SELECT * FROM reservation"
	  + " WHERE nIdHotel  = ?"
	  + "   AND dArrival  <= STR_TO_DATE(?, '%d/%m/%Y'),"
	  + "   AND dDeparture > STR_TO_DATE(?, '%d/%m/%Y')";

    public static final String SQL_CHARGE_BY_RESERVATIONS = // TODO change to SP
        "SELECT * FROM reservation" +
        " WHERE nIdHotel = ?" +
        "   AND nReservation >= ?" +
        " ORDER BY nReservation";

    public static final String SQL_CHARGE_BY_LAST_NAME = // TODO change to SP
    	"SELECT * FROM reservation" +
        " WHERE nIdHotel = ?" +
          " AND tLastName1 like ?" +
        " ORDER BY tLastName1";

    public static final String SQL_CHARGE_BY_ARRIVAL = // TODO change to SP
    	"SELECT * FROM reservation" +
        " WHERE nIdHotel = ?" +
        "   AND dArrival = STR_TO_DATE(?,'%d/%m/%Y')" +
        " ORDER BY dArrival";

    public static final String SQL_CHARGE_BY_DEPARTURE = // TODO change to SP
    	"SELECT * FROM reservation" +
        " WHERE nIdHotel = ?" +
        "   AND dDeparture = ?" +
        " ORDER BY STR_TO_DATE(?,'%d/%m/%Y')";

    public static final String SQL_CHARGE_BY_CREATION_DATE = // TODO change to SP
    	"SELECT * FROM reservation"
      + " WHERE nIdHotel = ? "
	  + "   AND date(dMadeOn) = ?"
	  + " ORDER BY dMadeOn";

	//////////////////
	//// GUESTS
	//////////////////
	
	/** 5 parameters */
	public static final String SPI_GUEST =
		"{ call CMSP_GUEST_INSERT(?,?,?,?,?); ";
	/** 2 parameters */
	public static final String SPG_GUEST =
		"{ call CMSP_RESERVATION_GET(?,?); }";
	/** 2 parameters */
	public static final String SPD_GUEST =
		"{ call CMSP_GUEST_DELETE(?,?) }";
	/** 3 parameters */
	public static final String SPS_GUEST =
		"{ call CMSP_RESERVATION_GUEST_LIST(?,?,?); }";
	
	public static final String SQL_GET_ALL_GUESTS =
		"SELECT * FROM reservation_guest";}
