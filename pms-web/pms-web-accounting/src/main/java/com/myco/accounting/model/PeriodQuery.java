/*
 * ReceiptQuery.java
 *
 * Created on March 06, 2007, 10:00 AM
 */

package beans;

import java.sql.Date;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class PeriodQuery implements java.io.Serializable{

    private short  year;
    private short  month;
    private short  monthDay;

    /** Creates new RegVtsQry */
    public PeriodQuery() {
    }

    public short getYear() {
        return year;
    }
    public void setYear(short year) {
        this.year = year;
    }

    public short getMonth() {
        return month;
    }
    public void setMonth(short month) {
        this.month = month;
    }

    public short getMonthDay() {
        return monthDay;
    }
    public void setMonthDay(short monthDay) {
        this.monthDay = monthDay;
    }

}