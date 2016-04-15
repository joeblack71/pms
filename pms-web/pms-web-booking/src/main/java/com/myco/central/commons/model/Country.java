/*
 * Country.java
 *
 * Created on December 11, 2002, 7:42 PM
 */

package com.myco.central.commons.model;

import java.io.Serializable;

import com.myco.central.constants.CentralModuleConstants;

/**
 *
 * @author  instructor
 * @version
 */
public class Country implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String idCountry;
    private String countryName;
    private String abbreviation;
    private String nationality;

    /** Creates new Country */
    public Country() {
    	this.idCountry = CentralModuleConstants.BLANK;
    	this.countryName = CentralModuleConstants.BLANK;
    	this.abbreviation = CentralModuleConstants.BLANK;
    	this.nationality = CentralModuleConstants.BLANK;
    }

    public String getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(String idCountry) {
		this.idCountry = idCountry;
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