/*
 * RoomType.java
 *
 * Created on 18 de marzo de 2005, 02:54 PM
 */

package beans;

import java.io.Serializable;

import java.beans.*;

/**
 * @author Standard
 */
public class RoomType extends Object implements Serializable {

    //private PropertyChangeSupport propertySupport;

    private String hotel;
    private String roomType;
    private String description;
    private short  totalRooms;
    private short  availableRooms;
    private short  blockedRooms;
    private float  rackRate;
    private String status;

    public RoomType() {
        //propertySupport = new PropertyChangeSupport(this);
    }

    public String getHotel() {
        return this.hotel;
    }
    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getRoomType() {
        return this.roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public short getTotalRooms() {
        return this.totalRooms;
    }
    public void setTotalRooms(short totalRooms) {
        this.totalRooms = totalRooms;
    }

    public short getAvailableRooms() {
        return this.availableRooms;
    }
    public void setAvailableRooms(short availableRooms) {
        this.availableRooms = availableRooms;
    }

    public short getBlockedRooms() {
        return this.blockedRooms;
    }
    public void setBlockedRooms(short blockedRooms) {
        this.blockedRooms = blockedRooms;
    }

    public float getRackRate() {
        return this.rackRate;
    }
    public void setRackRate(float rackRate) {
        this.rackRate = rackRate;
    }

    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}