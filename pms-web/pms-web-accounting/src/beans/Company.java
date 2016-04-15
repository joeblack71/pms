/*
 * Company.java
 *
 * Created on October 26, 2006, 9:08 AM
 */

package beans;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class Company extends Entity {

    private short  hotelId;
    private String segment;
    private double creditLimit;

    /** Creates new Company */
    public Company() {
        super();
        this.segment     = "";
        this.creditLimit = 0;
    }

    public short getHotelId() {
        return hotelId;
    }
    public void setHotelId(short _hotelId) {
        this.hotelId = _hotelId;
    }

    public String getSegment() {
        return segment;
    }
    public void setSegment(String _segment) {
        this.segment = _segment;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
    public void setCreditLimit(double _creditLimit) {
        this.creditLimit = _creditLimit;
    }

}
