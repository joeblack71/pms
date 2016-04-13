
package com.mycom.booking.libraries;

import java.util.*;
import java.text.SimpleDateFormat;

import com.mycom.booking.beans.OccupationDay;
import com.mycom.booking.libraries.DateManager;
import com.mycom.booking.lists.OccupationByDays;


public class AvailabilityArray {

    private static final short WEEK_COLS = 7;
    private static final short MONTH_COLS = 12;
    private static final short QUARTER_COLS = 8;
    private static final short YEAR_COLS = 5;

    // TODO: roomTypes debe ser cargado en el objeto "llamador"
    private String[] roomTypes = {"ES","SJ"};

    private OccupationByDays obd;
    private java.sql.Date[] daysOcc;
    private int[][]         roomsOcc=null;
    private int[]           totalDayOcc=null;
    public String[][]       availability=null;

    private int dayIndex;

    public void setOccupationByDays(OccupationByDays obd) {
        this.obd = obd;
    }
    
    public String[][] getMatrix() {
        return availability;
    }
    
    public void setMatrix(String[][] availability) {
        this.availability = availability;
    }
    
    public AvailabilityArray(String period) {
        daysOcc      = new java.sql.Date[getPeriodDays(period)];
        roomsOcc     = new int[roomTypes.length][daysOcc.length + 1];
        totalDayOcc  = new int[daysOcc.length + 1];

        availability = new String[roomTypes.length + 2][daysOcc.length + 2];
    }

    /**
     * Carga los elementos de cada arreglo
     *
     * @param list
     */
    public void chargeRoomsOccupation(java.sql.Date sqlDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis( sqlDate.getTime() );
        for ( int i=0; i < daysOcc.length; i++ ) { // Charges header
            daysOcc[i] = new java.sql.Date( cal.getTimeInMillis() );
            cal.add(cal.DAY_OF_MONTH, 1);
        }

        chargeRoomsByDays();
        
        for ( int i=0; i < roomsOcc.length; i++ ) { // Totalize types
            for ( int j=0; j < roomsOcc[0].length - 1; j++ ) 
                roomsOcc[i][roomsOcc[0].length - 1] += roomsOcc[i][j];
        }
        
        for ( int i=0; i < totalDayOcc.length - 1; i++ ) // Totalize days
            totalDayOcc[totalDayOcc.length - 1] += totalDayOcc[i];
        
        chargeAvailabilityMatrix();
     }

    public void chargeRoomsByDays() {
        Iterator days = obd.iterator();
        OccupationDay od = new OccupationDay();
        while ( days.hasNext() ) {
            od = (OccupationDay)days.next();
            for ( int i=0; i < roomTypes.length; i++ ) { // Iterates types
                if ( roomTypes[i].equals( od.getRoomType() ) ) {
                    for( int j=0; j < daysOcc.length; j++ ) { // Iterates dates
                        if ( daysOcc[j].equals( od.getOccupiedDay() ) ) {
                            roomsOcc[i][j] = od.getOccupiedRooms();
                            totalDayOcc[j] += od.getOccupiedRooms(); // Acumulates totals
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }

    /**
     */
    public void chargeAvailabilityMatrix() {
        for ( int i=1,j=0; j < daysOcc.length; i++, j++) // Charges occupation dates
            availability[0][i] = DateManager.sqlDateToString( daysOcc[j] );

        for ( int i=1,j=0; j < roomTypes.length; i++, j++ ) // Charges room types
            availability[i][0] = roomTypes[j];

        for ( int i=1,k=0; k < roomsOcc.length; i++,k++ ) { // Charges occupied rooms
            for ( int j=1,l=0; l < roomsOcc[0].length; j++,l++ )
                availability[i][j] = String.valueOf( roomsOcc[k][l] );
        }

        for ( int i=1,j=0; j < totalDayOcc.length; i++,j++ ) // Charges total occupied rooms
            availability[availability.length - 1][i] = String.valueOf( totalDayOcc[j] );
    }

    private int getPeriodDays(String s) {
        int columns=0;

        short period = Short.parseShort(s);
        switch( period ){
            case 1:  columns = WEEK_COLS; break; // A WEEK
            case 2:  columns = MONTH_COLS; break; // A MONTH
            case 3:  columns = QUARTER_COLS; break; // A QUARTER = 12 WEEKS
            case 4:  columns = YEAR_COLS; break; // 12 MONTHS
            default: columns = WEEK_COLS; break; // A WEEK
        }
        
        return columns;
    }

}