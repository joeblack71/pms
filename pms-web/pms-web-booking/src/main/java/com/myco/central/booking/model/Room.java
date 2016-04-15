/*
 * Room.java
 *
 * Created on 31 de julio de 2007, 11:54 AM
 */

package com.mycom.booking.beans;

/**
 * @author Johnny Olivas
 */
public class Room {

    private short  hotelId;
    private String roomType;
    private String roomNumber;
    private String description;
    private String location;
    private short  bedsCapacity;
    private float  roomRate;
    private int    assignedReservation;
    private String connectedRoom;
    private String hkStatus;
    private String roomStatus;

    public Room() {
    }

    public short getHotelId() {
        return this.hotelId;
    }
    
    public void setHotelId(short hotel) {
        this.hotelId = hotel;
    }

    public String getRoomType() {
        return this.roomType;
    }
    
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public short getBedsCapacity() {
        return this.bedsCapacity;
    }

    public void setBedsCapacity(short bedsCapacity) {
        this.bedsCapacity = bedsCapacity;
    }

    public float getRoomRate() {
        return this.roomRate;
    }
    
    public void setRoomRate(float roomRate) {
        this.roomRate = roomRate;
    }

    public int getAssignedReservation() {
        return this.assignedReservation;
    }

    public void setAssignedReservation(int assignedReservation) {
        this.assignedReservation = assignedReservation;
    }

    public String getConnectedRoom() {
        return this.connectedRoom;
    }

    public void setConnectedRoom(String connectedRoom) {
        this.connectedRoom = connectedRoom;
    }

    public String getRoomStatus() {
        return this.roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }


    public String getHkStatus() {
        return this.hkStatus;
    }

    public void setHkStatus(String hkStatus) {
        this.hkStatus = hkStatus;
    }

}