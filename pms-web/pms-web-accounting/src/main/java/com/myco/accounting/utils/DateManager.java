
package libraries;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * <B>Formats Dates used by programs</B>
 */
public class DateManager {

    /**
     * Create a new Date Manager
     */
    public void DateManager() {}

    /**
     * Converts a String value to a java.sql.Date
     * @param strDateFormat A String of the format: ddMMYY, dd/MM/yy or dd/MM/yyyy
     * @return A java.sql.Date value. If 'strDateFormat' is not a well-formed string then return 'null'.
     */
    public static java.sql.Date getSqlDateFormat(String strDateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        java.sql.Date sqlDateFormat = null;

        boolean validLenghtDate = true;
        switch ( strDateFormat.length() ) {
            case  6: sdf.applyPattern("ddMMyy"); break;
            case  8: sdf.applyPattern("dd/MM/yy"); break;
            case 10: sdf.applyPattern("dd/MM/yyyy"); break;
            default: validLenghtDate = false;
        }
        
        if ( validLenghtDate ) {
            try {
                java.util.Date utilDate = sdf.parse(strDateFormat);
                sqlDateFormat = new java.sql.Date( utilDate.getTime() );
            } catch(Exception e) { e.printStackTrace(); }
        }
        
        return sqlDateFormat;
    }

    /**
     * Returns a String with a java.sql.format
     * @return An String with actual Date
     */
    public static String getValidDateFormat() {
        String validDateFormat=null;
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
        Calendar cal = Calendar.getInstance();
        validDateFormat = sdf.format( cal.getTimeInMillis() );
        return validDateFormat;
    }

    public static String formatDate(java.sql.Date sqlDate) {
        //System.out.println(sqlDate);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = sdf.format(sqlDate.getTime());
        return formattedDate;
    }

    public static String[] getAccountingPeriods(java.sql.Date initialYear) {
        String[] acctPeriods = null;
        /*Calendar cal = Calendar.getInstance();
        java.sql.Date finishYear = cal.getYear();
        java.sql.Date actualYear = initialYear;
        int i = 0;
        while ( actualYear <= finishYear ) {
            acctPeriods[i++] = actualYear;
            actualYear = cal.add(actualYear,1);
        }*/
        return acctPeriods;
    }

    public static String getSqlFormat(String strDateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        String sqlFormat = null;

        boolean validLenghtDate = true;
        switch ( strDateFormat.length() ) {
            case  6: sdf.applyPattern("ddMMyy"); break;
            case  8: sdf.applyPattern("dd/MM/yy"); break;
            case 10: sdf.applyPattern("dd/MM/yyyy"); break;
            default: validLenghtDate = false;
        }

        if ( validLenghtDate ) {
            try {
                java.util.Date utilDate = sdf.parse(strDateFormat);
                sdf.applyPattern("yyyy-MM-dd");
                sqlFormat = sdf.format(utilDate);
            } catch (Exception e) { e.printStackTrace(); }
        }
        
        return sqlFormat;
    }

    public static String getDomesticFormat(String sqlDateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String domesticFormat = null;

        try {
            java.util.Date utilDate = sdf.parse(sqlDateFormat);
            sdf.applyPattern("dd/MM/yy");
            domesticFormat = sdf.format(utilDate);
        } catch (Exception e) { e.printStackTrace(); }

        return domesticFormat;
    }

    public static java.sql.Date getSqlDateToday() {
        //Calendar realTime = Calendar.getInstance();
        java.sql.Date sqlDateToday = new java.sql.Date( Calendar.getInstance().getTimeInMillis() );
        return sqlDateToday;
    }
    
    public static java.sql.Time getSqlTimeNow() {
        //Calendar realTime = Calendar.getInstance();
        java.sql.Time sqlTimeNow = new java.sql.Time( Calendar.getInstance().getTimeInMillis() );
        return sqlTimeNow;
    }
    
    public static String getStringTime(java.sql.Time sqlTime) {
        String stringTime = sqlTime.toString();
        return stringTime;
    }
    
    public static java.sql.Time getSqlTimeFormat(String strTimeFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        java.sql.Time sqlTimeFormat = null;

        boolean validLenghtTime = true;
        switch ( strTimeFormat.length() ) {
            case  2: sdf.applyPattern("hh"); break;
            case  4: sdf.applyPattern("hhmm"); break;
            case  5: sdf.applyPattern("hh:mm"); break;
            case  6: sdf.applyPattern("hhmmss"); break;
            case  8: sdf.applyPattern("hh:mm:ss"); break;
            default: validLenghtTime = false;
        }
        
        if ( validLenghtTime ) {
            try {
                java.util.Date utilDate = sdf.parse(strTimeFormat);
                sqlTimeFormat = new java.sql.Time( utilDate.getTime() );
            } catch(Exception e) { e.printStackTrace(); }
        }
        
        return sqlTimeFormat;
    }

}
