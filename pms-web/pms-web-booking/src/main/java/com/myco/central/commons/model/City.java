/*
 * Country.java
 *
 * Created on December 11, 2002, 7:42 PM
 */

package com.myco.central.commons.model;

import java.io.Serializable;

import com.myco.central.constants.CentralModuleConstants;

public class City implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String idCountry;
    private String idCity;
    private String cityDescription;
    private String abbreviation;

    /** Creates new City */
    public City() {
    	this.idCountry = CentralModuleConstants.BLANK;
    	this.idCity = CentralModuleConstants.BLANK;
    	this.cityDescription = CentralModuleConstants.BLANK;
    	this.abbreviation = CentralModuleConstants.BLANK;
    }

	public String getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(String countryId) {
		this.idCountry = countryId;
	}

	public String getIdCity() {
		return idCity;
	}

	public void setIdCity(String cityId) {
		this.idCity = cityId;
	}

	public String getCityDescription() {
		return cityDescription;
	}

	public void setCityDescription(String cityDescription) {
		this.cityDescription = cityDescription;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

}