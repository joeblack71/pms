/*
 * Country.java
 *
 * Created on December 11, 2002, 7:42 PM
 */

package com.mycom.booking.beans;

import java.io.Serializable;

/**
 *
 * @author  instructor
 * @version
 */
public class BussinessSource implements Serializable{

    private short  countryId;
    private String countryName;
    private String abbreviation;
    private String nationality;

    /** Creates new Country */
    public BussinessSource() {
    }

    public short getCountryId() {
        return countryId;
    }
    public void setCountryId(short _countryId) {
        this.countryId = _countryId;
    }

    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String _countryName) {
        this.countryName = _countryName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
    public void setAbbreviation(String _abbreviation) {
        this.abbreviation = _abbreviation;
    }

    public String getNationality() {
        return nationality;
    }
    public void setNationality(String _nationality) {
        this.nationality = _nationality;
    }

}