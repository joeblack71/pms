
package lib;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class FormatReservationDates {

    public void FormatReservationDates() {
    }

    public static java.sql.Date getSqlDateFormat(String strDateFormat){
        java.sql.Date sqlDateFormat = null;
        SimpleDateFormat sdf1 = new SimpleDateFormat("ddMMyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDate=null;

        if ( strDateFormat.length() == 6) {
          try{
            utilDate = sdf1.parse(strDateFormat);
          }catch(Exception e){}
        }

        if ( strDateFormat.length() == 10) {
          try{
            utilDate = sdf2.parse(strDateFormat);
          }catch(Exception e){}
        }

        sqlDateFormat = new java.sql.Date(utilDate.getTime());
        return sqlDateFormat;
    }

}
