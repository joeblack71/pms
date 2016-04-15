
package com.myco.central.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.myco.central.lists.OccupationByDays;
import com.myco.central.vo.OccupationDay;
import com.myco.central.vo.RoomType;

public class AvailabilityArray {

    private static final short WEEK_COLS = 7;
    private static final short MONTH_COLS = 12;
    private static final short QUARTER_COLS = 8;
    private static final short YEAR_COLS = 5;

    public AvailabilityArray(String period) {
    }

    /**
     * Carga los elementos de cada arreglo
     *
     * @param list
     */
    public String[][] chargeRoomsOccupation(List<OccupationDay> list,
    		java.sql.Date sqlDate, String period, List<RoomType> roomTypes) {
        java.sql.Date[] daysOcc = null;
        int[] totalDayOcc = null;
        int[][] roomsOcc = null;
        String[][] availability = null;
        
        daysOcc      = new java.sql.Date[getPeriodDays(period)];
        totalDayOcc  = new int[daysOcc.length + 1];
        availability = new String[roomTypes.size() + 2][daysOcc.length + 2];
        roomsOcc 	 = new int[roomTypes.size()][daysOcc.length + 1];
        
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis( sqlDate.getTime() );
        for ( int i=0; i < daysOcc.length; i++ ) { // Charges header
            daysOcc[i] = new java.sql.Date( cal.getTimeInMillis() );
            cal.add(cal.DAY_OF_MONTH, 1);
        }

        chargeRoomsByDays(list, daysOcc, roomsOcc, totalDayOcc, roomTypes);
        
        for ( int i=0; i < roomsOcc.length; i++ ) { // Totalize types
            for ( int j=0; j < roomsOcc[0].length - 1; j++ ) 
                roomsOcc[i][roomsOcc[0].length - 1] += roomsOcc[i][j];
        }
        
        for ( int i=0; i < totalDayOcc.length - 1; i++ ) // Totalize days
            totalDayOcc[totalDayOcc.length - 1] += totalDayOcc[i];
        
        availability = chargeAvailabilityMatrix(daysOcc, availability,
        		roomTypes, roomsOcc, totalDayOcc);
        
        return availability;
     }

    public void chargeRoomsByDays(List<OccupationDay> list,
    		java.sql.Date[] daysOcc, int[][] roomsOcc, int[] totalDayOcc,
    		List<RoomType> roomTypes) {
        Iterator<OccupationDay> days = list.iterator();
        OccupationDay od = new OccupationDay();
        while ( days.hasNext() ) {
            od = (OccupationDay)days.next();
            for ( int i=0; i < roomTypes.size(); i++ ) { // Iterates types
                if ( (roomTypes.get(i)).getRoomType().equals( od.getRoomType() ) ) {
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
     * @param daysOcc 
     */
    public String[][] chargeAvailabilityMatrix(java.sql.Date[] daysOcc,
    		String[][] availability, List<RoomType> roomTypes, int[][] roomsOcc,
    		int[] totalDayOcc) {
    	
        for ( int i=1,j=0; j < daysOcc.length; i++, j++) // Charges occupation dates
            availability[0][i] = DateManager.sqlDateToString( daysOcc[j] );

        for ( int i=1,j=0; j < roomTypes.size(); i++, j++ ) // Charges room types
            availability[i][0] = roomTypes.get(j).getRoomType();

        for ( int i=1,k=0; k < roomsOcc.length; i++,k++ ) { // Charges occupied rooms
            for ( int j=1,l=0; l < roomsOcc[0].length; j++,l++ )
                availability[i][j] = String.valueOf( roomsOcc[k][l] );
        }

        for ( int i=1,j=0; j < totalDayOcc.length; i++,j++ ) // Charges total occupied rooms
            availability[availability.length - 1][i] = String.valueOf( totalDayOcc[j] );
        
        return availability;
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