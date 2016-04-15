/*
 * Room.java
 *
 * Created on 31 de julio de 2007, 11:54 AM
 */

package com.myco.central.reservations.domain;

/**
 * @author Johnny Olivas
 */
public class Room {

    private String idHotel;
    private String idRoom;
    private String idRoomType;
    private String roomNumber;
    private String description;
    private String location;
    /** How many beds can be put in the room */
    private String bedsCapacity;
    private String roomRate;
    /** Reservation that is holding locked the room */
    private String idReservation;
    /** A room that has connection with this room */
    private String connectedRoom;
    /** House keeping status */
    private String hkStatus;
    /** Vacant, Occupied, Blocked, etc. */
    private String roomStatus;
    private String madeOn;
    private String madeBy;
    private String updatedBy;
    private String lastUpdate;

    public Room() {
    }

    public String getIdRoomType() {
        return this.idRoomType;
    }
    
    public void setIdRoomType(String roomType) {
        this.idRoomType = roomType;
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

    public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

	public String getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(String idRoom) {
		this.idRoom = idRoom;
	}

	public String getBedsCapacity() {
		return bedsCapacity;
	}

	public void setBedsCapacity(String bedsCapacity) {
		this.bedsCapacity = bedsCapacity;
	}

	public String getRoomRate() {
		return roomRate;
	}

	public void setRoomRate(String roomRate) {
		this.roomRate = roomRate;
	}

	public String getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(String assignedReservation) {
		this.idReservation = assignedReservation;
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

	public String getMadeOn() {
		return madeOn;
	}

	public void setMadeOn(String madeOn) {
		this.madeOn = madeOn;
	}

	public String getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}