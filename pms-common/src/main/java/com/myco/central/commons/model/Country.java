/*
 * Country.java
 *
 * Created on December 11, 2002, 7:42 PM
 */

package com.myco.central.commons.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author jolivas
 * @version
 */
@Entity
@Table(name = "country")
public class Country extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private String abbreviation;
	private String nationality;
	private String timeZone;
	// private Set<City> cities;

	public Country() {
	}

	public Country(String name, String abbr) {
		this.name = name;
		this.abbreviation = abbr;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	/*
	 * @OneToMany(cascade = CascadeType.ALL, mappedBy = "country") public
	 * Set<City> getCities() { return cities; }
	 */

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public String getNationality() {
		return nationality;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setAbbreviation(String abbr) {
		this.abbreviation = abbr;
	}

	/*
	 * public void setCities(Set<City> cities) { this.cities = cities; }
	 */

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	@Override
	public String toString() {
		return "Country [name=" + this.name + ", description=" + this.description + ", abbreviation="
				+ this.abbreviation + ", nationality=" + this.nationality + ", timeZone=" + this.timeZone + ", cities="
				/* + this.cities */ + "]";
	}

}