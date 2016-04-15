
package com.myco.central.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myco.central.constants.CentralModuleConstants;

/**
 * <B>Formats Dates used by programs</B>
 */
public class DateUtils {
	protected final Log log = LogFactory.getLog( getClass() );
    
    public static final int DATE_FORMAT_DDMM = 0;
    public static final int DATE_FORMAT_DDMMYY = 2;
    public static final int DATE_FORMAT_DDMMYYYY = 4;

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

        String ns = s.replace("/","");
        ns = ns.replace("-","");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat();
            switch ( ns.length() ) {
                case  6: sdf.applyPattern("ddMMyy"); break;
                case  8: sdf.applyPattern("ddMMyyyy"); break;
                //case 10: sdf.applyPattern("ddMMyyyy"); break;
            }
            java.util.Date utilDate = sdf.parse(ns);
            sqlDateValue = new java.sql.Date( utilDate.getTime() );
        } catch(Exception e) {
            System.out.println("DateFormater: Error en formato de fecha !!");
        }

        return sqlDateValue;
    }

    /**
     * Formats a <code>java.sql.Date</code> in the date escape format <code>"dd/MM/yy"</code>
     *
     * @param  dateInMillis <code>java.sql.Date</code> object.
     * @return a formatted <code>String</code> representation of the date gave.
     *
     */
    public static String sqlDateToString(long dateInMillis) {
        String stringDate = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            stringDate = sdf.format( new Date(dateInMillis) );
        } catch (Exception e) {}

        return stringDate;
    }

    /**
     * Formats a date in a date escape format
     *
     * @param  dateInMillis date in milliseconds
     * @param  dateFormat 0="dd/MM", 2="dd/MM/yy", 4="dd/MM/yyyy"
     * 
     * @return a formatted <code>String</code> representation of the date gave.
     *
     */
    public static String sqlDateToString(long dateInMillis, int dateFormat) {
        String stringDate = null;
        
        SimpleDateFormat sdf = null;

        switch(dateFormat) {
        	case 0: sdf = new SimpleDateFormat("dd/MM"); break;
        	case 2: sdf = new SimpleDateFormat("dd/MM/yy"); break;
        	case 4: sdf = new SimpleDateFormat("dd/MM/yyyy"); break;
        	default: new SimpleDateFormat("dd/MM/yyyy"); break;
        }
        
        try {
            stringDate = sdf.format( new Date(dateInMillis) );
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
            System.out.println("DateFormater: Error en formato de hora !!");
        }
        
        return sqlTimeFormat;
    }

    /**
     * Add days to startDay
     */
    public static String addDaysToDate(String s, short period) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis( sqlDateValueOf(s).getTime() );

        int amount = 0;

        switch( period ){
            case CentralModuleConstants.WEEKLY: amount = 7; break;
            case CentralModuleConstants.MONTHLY: amount = 30; break;
            case CentralModuleConstants.QUARTERLY: amount = 90; break;
            case CentralModuleConstants.HALF_YEARLY: amount = 180; break;
            case CentralModuleConstants.YEARLY: amount = 360; break;
            default: amount = 7; break;
        }
        cal.add(Calendar.DAY_OF_MONTH, amount);

        return sqlDateToString( cal.getTimeInMillis(), 4); //FIXME cambiar 4 por param.
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

    /** Convierte un string con formato "yyyy-mm-dd" a formato "dd/mm/yy"
     */
    public static String formatStringDate(String s) {
    	StringBuffer buffer = new StringBuffer();

    	buffer.append("string: ");
    	buffer.append(s);

    	//log.info(buffer.toString());

    	java.util.Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat();

        String newString = null;

        try {
            sdf.applyPattern("yyyy-MM-dd");
            date = sdf.parse(s);
            newString = sqlDateToString(date.getTime(), DATE_FORMAT_DDMMYY); 
        } catch(Exception e) {
        	e.printStackTrace();
            System.out.println("DateFormater: error en conversion de cadena");
        }

        //log.info("newString: " + newString);

        return newString;
    }

	public static Date[] getPeriodDays(String s) {
    	Date[] dates = null;
		
    	short period = CentralModuleConstants.WEEKLY;
        int columns = 0;

        try {
        	if ( s.length() > 0 ) {
				period = Short.parseShort(s);
        	}
			
        	switch( period ){
			    case CentralModuleConstants.WEEKLY: columns = AppConstants.DAYS; break;
			    case CentralModuleConstants.MONTHLY: columns = AppConstants.MONTHS; break;
			    case CentralModuleConstants.QUARTERLY: columns = AppConstants.QUARTERS; break;
			    case CentralModuleConstants.HALF_YEARLY: columns = AppConstants.HALF_YEAR; break;
			    case CentralModuleConstants.YEARLY: columns = AppConstants.YEARS; break;
			    default: columns = AppConstants.DAYS; break;
			}
			
        	dates = new java.sql.Date[columns];
		
        } catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
        
        /*Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis( sqlDate.getTime() );
        for ( int i=0; i < daysOcc.length; i++ ) { // Charges header
            daysOcc[i] = new java.sql.Date( cal.getTimeInMillis() );
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }*/

        return dates;
    }

}
