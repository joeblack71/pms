/*
 * Search.java
 *
 * Created on 12 de mayo de 2007, 15:19
 */

package com.myco.central.commons.model;

/**
 * @author Developer
 */
public class Search {
    
    private short  hotelId;
    private String sampleField;
    private String sampleValue;

    public Search() {
    }

    public short getHotelId() {
        return this.hotelId;
    }

    public void setHotelId(short hotelId) {
        this.hotelId = hotelId;
    }
    
    public String getSampleField() {
        return this.sampleField;
    }

    public void setSampleField(String fieldName) {
        this.sampleField = fieldName;
    }

    public String getSampleValue() {
        return this.sampleValue;
    }

    public void setSampleValue(String sampleValue) {
        this.sampleValue = sampleValue;
    }

}
