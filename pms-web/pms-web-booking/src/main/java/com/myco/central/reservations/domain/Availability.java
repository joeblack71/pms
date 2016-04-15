/*
 * Availability.java
 *
 * Created on December 23, 2006, 11:44 AM
 */

package com.myco.central.reservations.domain;

import java.sql.Date;
import java.util.Calendar;

import com.myco.central.commons.exceptions.AvailabilityQueryException;
import com.myco.central.util.DateUtils;

/**
 *
 * @author  Developer
 * @version
 */
public class Availability {

	/** value <b>7</b> */
    private static final short DAYS = 7;
    /** value <b>12</b> */
    private static final short MONTHS = 12;
    /** value <b>8</b> */
    private static final short QUARTERS = 8;
    /** value <b>4</b> */
    private static final short YEARS = 4;

    private String hotelId;
    private Date   startDate;
    private Date   endDate;
    private String roomType;
    private String roomNumber;
    private String period;
    private short  roomTypeAvailability;
    private short  quantity;
    private Date   oldArrival;
    private Date   oldDeparture;
    private short reservationRooms;

    private String status;

    /** Creates new Availability */
    public Availability() {
        hotelId = "1";
        startDate = DateUtils.getCurrentDate();
        roomType = "";
        roomNumber = "";
        period = "";
        roomTypeAvailability = 0;
        quantity = 0;
        reservationRooms = 0;
    }

    public String getPeriod() {
        return period;
    }
    
    public void setPeriod(String period) {
        this.period = period;
    }

    public Date getStartDate() {
        return startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
        this.endDate = calculateEndDate();
    }

    public void setStartDate(String startDate) throws AvailabilityQueryException {
        this.startDate = DateUtils.sqlDateValueOf(startDate);
        if ( this.startDate == null || this.startDate.equals("") )
            throw new AvailabilityQueryException("Invalid start date !!");
        this.endDate = calculateEndDate();
    }

    private Date calculateEndDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis( this.startDate.getTime() );
        try {
            switch( Short.parseShort( getPeriod() ) ){
                case 1:  cal.add(Calendar.DAY_OF_MONTH, DAYS); break;
                case 2:  cal.add(Calendar.MONTH, MONTHS); break;
                case 3:  cal.add(Calendar.MONTH, QUARTERS * 3); break;
                case 4:  cal.add(Calendar.YEAR, YEARS); break;
                default: cal.add(Calendar.DAY_OF_MONTH, DAYS); break;
            }
        } catch (Exception ex) {}

        return new Date( cal.getTimeInMillis() );
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
    
    public void setQuantity(String quantity) throws AvailabilityQueryException {
        this.quantity = Short.parseShort(quantity);
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public short getRoomTypeAvailability() {
        return this.roomTypeAvailability;
    }

    public void setRoomTypeAvailability(short roomTypeAvailability) {
        this.roomTypeAvailability = roomTypeAvailability;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOldArrival() {
        return oldArrival;
    }

    public void setOldArrival(Date oldArrival) {
        this.oldArrival = oldArrival;
    }

    public Date getOldDeparture() {
        return oldDeparture;
    }

    public void setOldDeparture(Date oldDeparture) {
        this.oldDeparture = oldDeparture;
    }

    public short getReservationRooms() {
        return this.reservationRooms;
    }

    public void setReservationRooms(short reservationRooms) {
        this.reservationRooms = reservationRooms;
    }

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

}