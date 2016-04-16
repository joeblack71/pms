package com.myco.central.commons.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long id;
    private String type; // office, factory, warehouse, etc
    private String country; // Peru - residence
    private String city; // Lima
    private String district; // San Borja
    private String locality; // Urb. Los Naranjos
    private String zipCode; // Lima 32
    private String streetType; // Av.
    private String streetName; // Las Artes
    private String streetNumber;// 896
    private String interior; // Dpto. 302
    private String complement; // Block 'A'
    private String reference; // "Alt. grifo Shell"
    private Company company;

    public String getCity() {
        return city;
    }

    @ManyToOne
    @JoinColumn(name = "companyId")
    public Company getCompany() {
        return company;
    }

    public String getComplement() {
        return complement;
    }

    public String getCountry() {
        return country;
    }

    public String getDistrict() {
        return district;
    }

    @Override
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public String getInterior() {
        return interior;
    }

    public String getLocality() {
        return locality;
    }

    /**
     * @return the person
     */
    //    @ManyToOne
    //    @JoinColumn(name = "personId")
    //    public Person getPerson() {
    //        return person;
    //    }

    public String getReference() {
        return reference;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetType() {
        return streetType;
    }

    public String getType() {
        return type;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
	public void setId(Long id) {
        this.id = id;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    //    public void setPerson(Person person) {
    //        this.person = person;
    //    }
    //
    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
