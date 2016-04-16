package com.myco.central.commons.dto;

/**
 *
 * @author  jolivas
 * @version
 */
public class CountryDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private String name;
    private String abbreviation;
    private String nationality;

	public String getCountryName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
    public void setAbbreviation(String abbr) {
        this.abbreviation = abbr;
    }

    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}