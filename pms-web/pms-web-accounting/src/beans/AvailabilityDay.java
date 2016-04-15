/*
 * Availability.java
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
public class AvailabilityDay {

    private int    hotel;
    private String roomType;
    private Date   occupiedDay;
    private int    occupiedRooms;
    //private String status;

    /** Creates new Empresa */
    public AvailabilityDay() {
    }

    public int getHotel() {
        return hotel;
    }
    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Date getOccupiedDay() {
        return occupiedDay;
    }
    public void setOccupiedDay(Date occupiedDay) {
        this.occupiedDay = occupiedDay;
    }

    public int getOccupiedRooms() {
        return occupiedRooms;
    }
    public void setOccupiedRooms(int occupiedRooms) {
        this.occupiedRooms = occupiedRooms;
    }

    /*public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }*/

}
