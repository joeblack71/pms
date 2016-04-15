/*
 * CustomerQuery.java
 *
 * Created on October 26, 2006, 9:08 AM
 */

package beans;

import java.io.Serializable;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class CustomerQuery implements Serializable{

    private short  hotelId;
    private String field;
    private String pattern;
    private String customerType;

    /** Creates new CustomerQuery */
    public CustomerQuery() {
        String SPACES = "";
        this.pattern      = SPACES;
        this.customerType = SPACES;
    }

    public short getHotelId() {
        return hotelId;
    }
    public void setHotelId(short hotelId) {
        this.hotelId = hotelId;
    }

    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }

    public String getPattern() {
        return pattern;
    }
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getCustomerType() {
        return customerType;
    }
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

}
