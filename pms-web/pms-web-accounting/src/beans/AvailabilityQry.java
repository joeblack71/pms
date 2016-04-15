/*
 * AvailabilityQry.java
 *
 * Created on December 23, 2006, 11:44 AM
 */

package beans;

import java.sql.Date;
/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class AvailabilityQry {

    private int    hotel;
    private Date   startDate;
    private Date   endDate;
    private String roomType;
    private String roomNumber;
    private short    quantity;
    private String status;

    /** Creates new Empresa */
    public AvailabilityQry() {
    }

    public int getHotel() {
        return hotel;
    }
    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public short getQuantity() {
        return quantity;
    }
    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
