/*
 * Provider.java
 *
 * Created on October 26, 2006, 9:08 AM
 */

package beans;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class Provider extends Entity {

    private short  hotelId;
    private double creditLimit;

    /** Creates new Provider */
    public Provider() {
        super();
        this.creditLimit = 0;
    }

    public short getHotelId() {
        return hotelId;
    }
    public void setHotelId(short _hotelId) {
        this.hotelId = _hotelId;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
    public void setCreditLimit(double _creditLimit) {
        this.creditLimit = _creditLimit;
    }

}
