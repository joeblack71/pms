/*
 * Company.java
 *
 * Created on October 26, 2006, 9:08 AM
 */

package com.myco.central.commons.model;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class Company {
    private String idCompany;
    private String rucNumber;
    private String firmName;
    private String commercialName;
    private String address;
    private String country;
    private String district;
    private String city;
    private String zipCode;
    private String phone1;
    private String phone2;
    private String fax;
    private String webPage;
    private String segment;
    private String sourceId;
    private String specialRate;
    // Extracted from special rate. Used on reservation.jsp
    private String hsDowRate;
    private String hsEowRate;
    private String lsDowRate;
    private String lsEowRate;
    //
    private String contact;
    private String emailContact;
    private String madeBy;
    private String madeOn;
    private String updatedBy;
    private String lastUpdate;
    private String status;

    /** Creates new Company */
    public Company() {
    }

	public String getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(String companyId) {
		this.idCompany = companyId;
	}

	public String getRucNumber() {
		return rucNumber;
	}

	public void setRucNumber(String rucNumber) {
		this.rucNumber = rucNumber;
	}

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public String getCommercialName() {
		return commercialName;
	}

	public void setCommercialName(String commercialName) {
		this.commercialName = commercialName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebPage() {
		return webPage;
	}

	public void setWebPage(String webPage) {
		this.webPage = webPage;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getSpecialRate() {
		return specialRate;
	}

	public void setSpecialRate(String specialRate) {
		this.specialRate = specialRate;
	}

	public String getHsDowRate() {
		return hsDowRate;
	}

	public void setHsDowRate(String hsDowRate) {
		this.hsDowRate = hsDowRate;
	}

	public String getHsEowRate() {
		return hsEowRate;
	}

	public void setHsEowRate(String hsEowRate) {
		this.hsEowRate = hsEowRate;
	}

	public String getLsDowRate() {
		return lsDowRate;
	}

	public void setLsDowRate(String lsDowRate) {
		this.lsDowRate = lsDowRate;
	}

	public String getLsEowRate() {
		return lsEowRate;
	}

	public void setLsEowRate(String lsEowRate) {
		this.lsEowRate = lsEowRate;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmailContact() {
		return emailContact;
	}

	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}

	public String getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}

	public String getMadeOn() {
		return madeOn;
	}

	public void setMadeOn(String madeOn) {
		this.madeOn = madeOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
