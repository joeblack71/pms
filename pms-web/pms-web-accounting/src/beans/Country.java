/*
 * Country.java
 *
 * Created on December 11, 2002, 7:42 PM
 */

package beans;

import java.io.Serializable;

/**
 *
 * @author  instructor
 * @version
 */
public class Country implements Serializable{

    private int    countryCode;
    private String description;
    private String abbreviation;
    private String nationality;

    /** Creates new Country */
    public Country() {
    }

    public int getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(int _countryCode) {
        this.countryCode = _countryCode;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String _description) {
        this.description = _description;
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