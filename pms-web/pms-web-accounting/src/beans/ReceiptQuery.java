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
public class ReceiptQuery implements java.io.Serializable{

    private short  hotelId;
    private String field;
    private String customerDoc;
    private Date   queryDate;
    private String customerName;
    private short  period;
    private short  month;
    private short  monthDay;
    private int    production;

    /** Creates new RegVtsQry */
    public ReceiptQuery() {
    }

    public short getHotelId() {
        return hotelId;
    }
    public void setHotelId(short hotelId) {
        this.hotelId = hotelId;
    }

    public String getCustomerDoc() {
        return customerDoc;
    }
    public void setCustomerDoc(String customerId) {
        this.customerDoc = customerId;
    }

    /** Este campo se utiliza en consultas donde los criterios
     * pueden ser multiples. Este campo contendra el nombre del
     * criterio utilizado en la consulta.
     */
    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }

    /** Used by receipt_search.jsp
     */
    public Date getQueryDate() {
        return queryDate;
    }
    public void setQueryDate(Date queryDate) {
        this.queryDate = queryDate;
    }

    /** Used by receipt_search.jsp
     */
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public short getPeriod() {
        return period;
    }
    public void setPeriod(short period) {
        this.period = period;
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

    public int getProduction() {
        return production;
    }
    public void setProduction(int amount) {
        this.production = amount;
    }

}