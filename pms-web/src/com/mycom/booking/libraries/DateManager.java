
package com.mycom.booking.libraries;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import com.mycom.booking.events.DateFormatException;


/**
 * <B>Formats Dates used by programs</B>
 */
public class DateManager {

    private static final short WEEK     =   7;
    private static final short MONTH    =  30;
    private static final short QUARTER  = 120;
    private static final short SEMESTER = 180;
    private static final short YEAR     = 360;

    /**
     * Create a new Date Manager
     */
    public void DateManager() {}

    /**
     * Converts a date format string into a <code>java.sql.Date</code> object.
     * 
     * @param s a <code>String</code> object representing a date in one of
     *        the format: ddMMYY, dd/MM/yy or dd/MM/yyyy
     * @return a <code>java.sql.Date</code> object representing the given date.
     *         'null' if 's' is not a well-formed string then return .
     */
    public static java.sql.Date sqlDateValueOf(String s) {
        java.sql.Date sqlDateValue = null;

        String ns = s.replace("/",""); ns = ns.replace("-","");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat();
            switch ( ns.length() ) {
                case  6: sdf.applyPattern("ddMMyy"); break;
                case  8: sdf.applyPattern("ddMMyyyy"); break;
            }
            java.util.Date utilDate = sdf.parse(ns);
            sqlDateValue = new java.sql.Date( utilDate.getTime() );
        } catch(Exception e) {
            System.out.println("DateManager: Error en formato de fecha !!");
        }

        return sqlDateValue;
    }

    /**
     * Formats a <code>java.sql.Date</code> in the date escape format <code>"dd/MM/yy"</code>
     *
     * @param  d <code>java.sql.Date</code> object.
     * @return a formatted <code>String</code> representation of the date gave.
     *
     */
    public static String sqlDateToString(java.sql.Date d) {
        String stringDate = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        try {
            stringDate = sdf.format( new Date( d.getTime() ) );
        } catch (Exception e) {}

        return stringDate;
    }

    /**
     * Returns a <code>java.sql.Date</code> object with the current date.
     *
     * @return a <code>java.sql.Date</code> object with the current date.
     */
    public static java.sql.Date getCurrentDate() {
        return new java.sql.Date( new Date().getTime() );
    }
    
    /**
     * Retrieves the current date in a string in the "dd/MM/yy" format.
     *
     * @return a <code>String</code> with the current date.
     */
    public static String getStringCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        return sdf.format( new Date() );
    }

    public static java.sql.Time getCurrentTime() {
        return new java.sql.Time( new Date().getTime() );
    }
    
    public static String getStringCurrentTime(java.sql.Time sqlTime) {
        return sqlTime.toString();
    }
    
    public static java.sql.Time sqlTimeValueOf(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        java.sql.Time sqlTimeFormat = null;

        String ns = s.replace(":",""); ns = s.replace(".","");
        try {
            switch ( ns.length() ) {
                case  2: sdf.applyPattern("hh"); break;
                case  4: sdf.applyPattern("hhmm"); break;
                case  6: sdf.applyPattern("hhmmss"); break;
            }
            java.util.Date utilDate = sdf.parse(ns);
            sqlTimeFormat = new java.sql.Time( utilDate.getTime() );
        } catch(Exception e) {
            System.out.println("DateManager: Error en formato de hora !!");
        }
        
        return sqlTimeFormat;
    }

    /**
     * Add days to startDay
     */
    public static String addDaysToDate(String s, short period) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis( sqlDateValueOf(s).getTime() );

        switch( period ){
            case 1:  cal.add(cal.DAY_OF_MONTH, WEEK); break;
            case 2:  cal.add(cal.DAY_OF_MONTH, MONTH); break;
            case 3:  cal.add(cal.DAY_OF_MONTH, QUARTER); break;
            case 4:  cal.add(cal.DAY_OF_MONTH, SEMESTER); break;
            case 5:  cal.add(cal.DAY_OF_MONTH, YEAR); break;
            default: cal.add(cal.DAY_OF_MONTH, WEEK); break;
        }

        return sqlDateToString( new java.sql.Date( cal.getTimeInMillis() ) );
    }

    /** Devuelve un arreglo de años, cuyo primer elemento es el parametro
     * recibido y el ultimo el añoa actual
     */
    public static String getYearPeriod(java.sql.Date initialYear) {
        /*String[] acctPeriods = null;
        java.sql.Date finishYear = Calendar.getInstance().getYear();
        java.sql.Date actualYear = initialYear;
        int i = 0;
        while ( actualYear <= finishYear ) {
            acctPeriods[i++] = actualYear;
            actualYear = cal.add(actualYear,1);
        }
        return acctPeriods;*/
        return "2007,2006,2005";
    }

}
