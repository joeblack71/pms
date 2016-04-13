/*
 * Person.java
 *
 * Created on October 26, 2006, 9:08 AM
 * Last Modification: 15/02/07 11:50 AM
 *
 */

package com.myco.central.vo;

import java.sql.Date;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class Person {

    private String firstname;
    private String lastname1;
    private String lastname2;
    private short  documentType;   // Passport, DNI, Carnet, etc.
    private String documentNumber;
    private String title;          // Sr., Sra., Dr., Etc.
    private Date   birthDate;
    private short  nationality;
    private String occupation;
    private String address1;
    private String address2;
    private String district;
    private String city;
    private short  countryId;      // Residence countryId
    private String zipCode;        // ZIP code
    private int    phone1;
    private int    phone2;
    private String email;

    /** Creates new Person */
    public Person() {
        String SPACES = "";
        firstname  = SPACES;
        lastname1  = SPACES;
        lastname2  = SPACES;
        documentNumber = SPACES;
        title      = SPACES;
        occupation = SPACES;
        address1   = SPACES;
        address2   = SPACES;
        district   = SPACES;
        city       = SPACES;
        zipCode    = SPACES;
        email      = SPACES;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname1() {
        return lastname1;
    }
    public void setLastname1(String lastname1) {
        this.lastname1 = lastname1;
    }

    public String getLastname2() {
        return lastname2;
    }
    public void setLastname2(String lastname2) {
        this.lastname2 = lastname2;
    }

    public short getDocumentType() {
        return documentType;
    }
    public void setDocumentType(short documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }
    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public short getNationality() {
        return nationality;
    }
    public void setNationality(short nationality) {
        this.nationality = nationality;
    }

    public String getOccupation() {
        return occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public short getCountryId() {
        return countryId;
    }
    public void setCountryId(short country) {
        this.countryId = country;
    }

    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getPhone1() {
        return phone1;
    }
    public void setPhone1(int phone1) {
        this.phone1 = phone1;
    }

    public int getPhone2() {
        return phone2;
    }
    public void setPhone2(int phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
