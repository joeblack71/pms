
//import java.sql.Date;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

import beans.OccupationDay;
import libraries.DateManager;
import lists.OccupationByDays;

public class AvailabilityArray {

    private static final short WEEK_COLS = 7;
    private static final short MONTH_COLS = 12;
    private static final short QUARTER_COLS = 8;
    private static final short YEAR_COLS = 5;

    // TODO: roomTypes debe ser cargado en el objeto "llamador"
    private String[] roomTypes = {"ES","SJ"};

    private java.sql.Date[] daysOcc;
    private int[][]         roomsOcc=null;
    private int[]           totalDayOcc=null;
    private String[][]      availability=null;

    private int dayIndex;

    public AvailabilityArray(String startDate, String period) {
        daysOcc     = new java.sql.Date[getPeriodDays(period)];
        roomsOcc    = new int[roomTypes.length][daysOcc.length + 1];
        totalDayOcc = new int[daysOcc.length + 1];
        /* se adicionan dos campos mas para la cabecera y el pie (total) */
        availability = new String[roomTypes.length + 2][getPeriodDays(period) + 2];
        
        Calendar cal = Calendar.getInstance();
        java.sql.Date sqlDate = DateManager.getSqlDateValueOf(startDate);
        cal.setTimeInMillis( sqlDate.getTime() );
        for ( int i=0; i < daysOcc.length; i++ ) {
            daysOcc[i] = new java.sql.Date( cal.getTimeInMillis() );
            cal.add(cal.DAY_OF_MONTH, 1);
        }
    }

    /**
     * Carga los elementos de cada arreglo
     *
     * @param list
     */
    public void chargeRoomsOccupation(ArrayList list) {
        OccupationDay ad = new OccupationDay();
/* revisa cada elemento de la lista */
        for ( int idx=0; idx < list.size(); idx++ ) {
            ad = (OccupationDay)list.get(idx);
/* ubica el tipo de habitacion */
            for ( int i=0; i < roomTypes.length; i++ ) {
                //System.out.println(i+" "+ad.getRoomType());
                if ( roomTypes[i].equals( ad.getRoomType() ) ) {
/* una vez determinado el tipo de habitacion, ubica el dia  */
                    for( int j=0; j < daysOcc.length; j++ ) {
                        //System.out.println(j+" "+ad.getOccupiedDay()+" "+ad.getOccupiedRooms());
                        if ( daysOcc[j].equals( ad.getOccupiedDay() ) ) {
                            roomsOcc[i][j] = ad.getOccupiedRooms();
/* acumula el total por dia */
                            totalDayOcc[j] += ad.getOccupiedRooms();
                            break;
                        }
                    }
                }
            //break;
            }
        }
     }
    
    /**
     * Returns a <code>String</code> matrix to AvailabilityServlet
     *
     */
    public String[][] getAvailabilityArray() {
        int totalRoomType=0, totalHotel=0;
        int avaColLength = availability[0].length;
        /* Charge Room Types */
        for ( int i=0; i < roomTypes.length; i++ )
            availability[i+1][0] = roomTypes[i];
        /* Charge Occupied Date */
        for ( int i=0, idx=dayIndex; i < avaColLength - 2 && idx < daysOcc.length; i++,idx++)
            availability[0][i+1] = DateManager.convertSqlDateToString( daysOcc[idx] );
        /* Charge Occupied Rooms */
        for ( int i=0; i < availability.length - 2; i++ ) {
            for ( int j=0,idx=dayIndex; j < avaColLength - 2 && idx < roomsOcc[0].length; j++,idx++ ) {
                availability[i+1][j+1] = String.valueOf(roomsOcc[i][idx]);
                totalRoomType += roomsOcc[i][idx];
            }
            availability[i+1][avaColLength - 1]
                          = String.valueOf(totalRoomType);
            totalHotel += totalRoomType;
            totalRoomType = 0;
        }
        /* Charge Occupied Rooms by Day */
        for ( int i=0,idx=dayIndex; i < avaColLength - 2 && idx < totalDayOcc.length; i++,idx++ ) {
            availability[availability.length - 1][i+1] = String.valueOf(totalDayOcc[idx]);
            dayIndex = idx;
        }
        availability[availability.length - 1][avaColLength - 1]
                    = String.valueOf(totalHotel);

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