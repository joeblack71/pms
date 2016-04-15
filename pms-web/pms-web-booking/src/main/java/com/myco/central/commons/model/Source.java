/*
 * Company.java
 *
 * Created on October 26, 2006, 9:08 AM
 */

package com.myco.central.commons.model;

import com.myco.central.reservations.domain.Contact;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class Source {
    private String idSource;
    private String documentNumber;
    private String sourceName;
    private String commercialName;
    private String segment;
    private String sourceType; // Company - Travel Agency - ONG ..
    private String category;
    private String creditType; // has credit yes or no
    private String specialRate;
    // Extracted from special rate. Used on reservation.jsp
    private String hsDowRate;
    private String hsEowRate;
    private String lsDowRate;
    private String lsEowRate;
    private String hotelRegistration;
    private String madeBy;
    private String madeOn;
    private String updatedBy;
    private String lastUpdate;
    private String status;
    private Phone phone1;
    private Phone phone2;
    private Phone fax;
    private String webPage;
    private Address address;
    private Contact contact;

	/** Creates new Company */
    public Source() {
        this.address = new Address();
        this.phone1 = new Phone();
        this.phone2 = new Phone();
    }


    public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public String getIdSource() {
		return idSource;
	}

	public void setIdSource(String idSource) {
		this.idSource = idSource;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getCommercialName() {
		return commercialName;
	}

	public void setCommercialName(String commercialName) {
		this.commercialName = commercialName;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSourceType() {
		return sourceType;
	}


	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHotelRegistration() {
		return hotelRegistration;
	}

	public void setHotelRegistration(String hotelRegistration) {
		this.hotelRegistration = hotelRegistration;
	}

	public String getCreditType() {
		return creditType;
	}

	public void setCreditType(String creditType) {
		this.creditType = creditType;
	}

	public Phone getPhone1() {
		return phone1;
	}

	public void setPhone1(Phone phone1) {
		this.phone1 = phone1;
	}

	public Phone getPhone2() {
		return phone2;
	}

	public void setPhone2(Phone phone2) {
		this.phone2 = phone2;
	}

	public Phone getFax() {
		return fax;
	}

	public void setFax(Phone fax) {
		this.fax = fax;
	}

}
