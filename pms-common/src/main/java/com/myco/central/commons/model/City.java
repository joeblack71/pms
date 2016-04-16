/*
 * Country.java
 *
 * Created on December 11, 2002, 7:42 PM
 */

package com.myco.central.commons.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class City extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String name;
    private String code;
    private String abbreviation;
    private Country country;

    /** Creates new City */
    public City() {
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getCode() {
        return code;
    }

    @ManyToOne
    public Country getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

}