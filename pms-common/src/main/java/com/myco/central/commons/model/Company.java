/*
 * Company.java
 *
 * Created on October 26, 2006, 9:08 AM
 */

package com.myco.central.commons.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
@Entity
public class Company extends Party {
	private static final long serialVersionUID = 1L;

	private String firmName;
    private String commercialName;
    private String taxIdNumber; // PERU=RUC
    private Set<Address> address;

    //    private Set<Phone> phones;
    private String webPage;

    //    private List<Segment> segment;
    private String sourceId; // source of bussiness
    private List<Contact> contact;

    /** Creates new Company */
    public Company() {
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    public Set<Address> getAddress() {
        return address;
    }

    public String getCommercialName() {
        return commercialName;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    public List<Contact> getContact() {
        return contact;
    }

    public String getFirmName() {
        return firmName;
    }

    public String getSourceId() {
        return sourceId;
    }

    public String getTaxIdNumber() {
        return taxIdNumber;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    public void setCommercialName(String commercialName) {
        this.commercialName = commercialName;
    }

    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setTaxIdNumber(String taxIdNumber) {
        this.taxIdNumber = taxIdNumber;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

}
