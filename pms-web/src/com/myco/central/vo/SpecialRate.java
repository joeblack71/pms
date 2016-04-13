/*
 * RoomType.java
 *
 * Created on 18 de marzo de 2005, 02:54 PM
 */

package com.myco.central.vo;

import java.io.Serializable;

/**
 * @author Johnny Olivas
 */
public class SpecialRate implements Serializable {

    //private PropertyChangeSupport propertySupport;
	private static final long serialVersionUID = 1L;
	
	private short hotelId;
    private String roomType;
    private short  rateId;
    private String rateDescription;
    private float  dowHighSeasonRate;
    private float  eowHighSeasonRate;
    private float  dowLowSeasonRate;
    private float  eowLowSeasonRate;
    private String status;

    public SpecialRate() {
    }

    public short getHotelId() {
        return this.hotelId;
    }
    public void setHotelId(short hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomType() {
        return this.roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public short getRateId() {
        return this.rateId;
    }

    public void setRateId(short rateId) {
        this.rateId = rateId;
    }

    public String getRateDescription() {
        return this.rateDescription;
    }

    public void setRateDescription(String rateDescription) {
        this.rateDescription = rateDescription;
    }

    /** DAY of week HIGH Season Rate */
    public float getDowHighSeasonRate() {
        return this.dowHighSeasonRate;
    }
    
    public void setDowHighSeasonRate(float dowHighSeasonRate) {
        this.dowHighSeasonRate = dowHighSeasonRate;
    }

    /** END of week HIGH Season Rate */
    public float getEowHighSeasonRate() {
        return this.eowHighSeasonRate;
    }

    public void setEowHighSeasonRate(float eowHighSeasonRate) {
        this.eowHighSeasonRate = eowHighSeasonRate;
    }

    /** DAY of week LOW Season Rate */
    public float getDowLowSeasonRate() {
        return this.dowLowSeasonRate;
    }

    public void setDowLowSeasonRate(float dowLowSeasonRate) {
        this.dowLowSeasonRate = dowLowSeasonRate;
    }

    /** END of week LOW Season Rate */
    public float getEowLowSeasonRate() {
        return this.eowLowSeasonRate;
    }

    public void setEowLowSeasonRate(float eowLowSeasonRate) {
        this.eowLowSeasonRate = eowLowSeasonRate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}