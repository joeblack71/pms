/*
 * Company.java
 *
 * Created on October 26, 2006, 9:08 AM
 */

package com.mycom.booking.beans;

import com.mycom.booking.events.CompanyDataException;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class Company {
    private short  companyId;
    private long   rucNumber;
    private String firmName;
    private String commercialName;
    private String address;
    private short  country;
    private short  district;
    private short  city;
    private String zipCode;
    private int    phone1;
    private int    phone2;
    private int    fax;
    private String webPage;
    private short  segment;
    private short  sourceId;
    private short  specialRate;
    // Extracted from special rate. Used on reservation.jsp
        private float  hsDowRate;
        private float  hsEowRate;
        private float  lsDowRate;
        private float  lsEowRate;
    private String contact;
    private String emailContact;
    private String madeBy;
    private String madeOn;

    /** Creates new Company */
    public Company() {
    }

    public short getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(short companyId) {
        this.companyId = companyId;
    }

    public String getFirmName() {
        return firmName;
    }
    public void setFirmName(String firmName) throws CompanyDataException {
        if ( firmName.equals("") )
            throw new CompanyDataException("Nombre de la empresa en blanco !!");
        this.firmName = firmName;
    }

    public String getCommercialName() {
        return this.commercialName;
    }

    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }

    public long getRucNumber() {
        return this.rucNumber;
    }

    public void setRucNumber(String rucNumber) throws CompanyDataException {
        if ( rucNumber.equals("") )
            throw new CompanyDataException("RUC en blanco !!");
        this.rucNumber = Long.parseLong(rucNumber);
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) throws CompanyDataException {
        if ( firmName.equals("") )
            throw new CompanyDataException("Direccion en blanco !!");
        this.address = address;
    }

    public short getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) throws CompanyDataException {
        this.district = Short.parseShort(district);
    }

    public short getCity() {
        return this.city;
    }

    public void setCity(String city) throws CompanyDataException {
        this.city = Short.parseShort(city);
    }

    public short getCountry() {
        return country;
    }
    
    public void setCountry(String country) throws CompanyDataException {
        this.country = Short.parseShort(country);
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getPhone1() {
        return phone1;
    }
    
    public void setPhone1(String phone1) throws CompanyDataException {
        this.phone1 = Integer.parseInt(phone1);
    }

    public int getPhone2() {
        return this.phone2;
    }

    public void setPhone2(String phone2) throws CompanyDataException {
        this.phone2 = Integer.parseInt(phone2);
    }

    public int getFax() {
        return fax;
    }
    public void setFax(String fax) throws CompanyDataException {
        this.fax = Integer.parseInt(fax);
    }

    public String getWebPage() {
        return this.webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public short getSegment() {
        return this.segment;
    }

    public void setSegment(String segment) throws CompanyDataException {
        this.segment = Short.parseShort(segment);
    }

    public short getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(String sourceId) throws CompanyDataException {
        this.sourceId = Short.parseShort(sourceId);
    }

    public short getSpecialRate() {
        return this.specialRate;
    }

    public void setSpecialRate(String specialRate) throws CompanyDataException {
        this.specialRate = Short.parseShort(specialRate);
    }

    public float getHsDowRate() {
        return this.hsDowRate;
    }

    public void setHsDowRate(float hsDowRate) {
        this.hsDowRate = hsDowRate;
    }

    public float getHsEowRate() {
        return this.hsEowRate;
    }

    public void setHsEowRate(float hsEowRate) {
        this.hsEowRate = hsEowRate;
    }

    public float getLsDowRate() {
        return this.lsDowRate;
    }

    public void setLsDowRate(float lsDowRate) {
        this.lsDowRate = lsDowRate;
    }

    public float getLsEowRate() {
        return this.lsEowRate;
    }

    public void setLsEowRate(float lsEowRate) {
        this.lsEowRate = lsEowRate;
    }
    public String getContact() {
        return contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmailContact() {
        return this.emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public String getMadeBy() {
        return this.madeBy;
    }

    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

    public String getMadeOn() {
        return this.madeOn;
    }

    public void setMadeOn(String madeOn) {
        this.madeOn = madeOn;
    }

}
