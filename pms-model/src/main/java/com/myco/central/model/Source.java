package com.myco.central.model;

import java.util.List;

import javax.persistence.Entity;

import com.myco.central.commons.model.Address;
import com.myco.central.commons.model.Contact;
import com.myco.central.commons.model.Phone;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
@Entity
public class Source extends BaseAuditable {

	private static final long serialVersionUID = 1L;

	private Long sourceId;
    private String documentNumber;
    private String sourceName;
    private String commercialName;
	private Long segmentId;
    private String sourceType; // Company - Travel Agency - ONG ..
    private String category;
	private boolean credit;
	private Double specialRate;
    // Extracted from special rate. Used on reservation.jsp
	private Double hsDowRate;
	private Double hsEowRate;
	private Double lsDowRate;
	private Double lsEowRate;
    private String hotelRegistration;
    private String status;
    private List<Phone> phones;
    private String webPage;
    private List<Address> addresses;
    private Contact contact;

	public Source() {
	}

	public Long getSourceId() {
		return sourceId;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public String getSourceName() {
		return sourceName;
	}

	public String getCommercialName() {
		return commercialName;
	}

	public Long getSegmentId() {
		return segmentId;
	}

	public String getSourceType() {
		return sourceType;
	}

	public String getCategory() {
		return category;
	}

	public boolean isCredit() {
		return credit;
	}

	public Double getSpecialRate() {
		return specialRate;
	}

	public Double getHsDowRate() {
		return hsDowRate;
	}

	public Double getHsEowRate() {
		return hsEowRate;
	}

	public Double getLsDowRate() {
		return lsDowRate;
	}

	public Double getLsEowRate() {
		return lsEowRate;
	}

	public String getHotelRegistration() {
		return hotelRegistration;
	}

	public String getStatus() {
		return status;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public String getWebPage() {
		return webPage;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public Contact getContact() {
		return contact;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public void setCommercialName(String commercialName) {
		this.commercialName = commercialName;
	}

	public void setSegmentId(Long segmentId) {
		this.segmentId = segmentId;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCredit(boolean credit) {
		this.credit = credit;
	}

	public void setSpecialRate(Double specialRate) {
		this.specialRate = specialRate;
	}

	public void setHsDowRate(Double hsDowRate) {
		this.hsDowRate = hsDowRate;
	}

	public void setHsEowRate(Double hsEowRate) {
		this.hsEowRate = hsEowRate;
	}

	public void setLsDowRate(Double lsDowRate) {
		this.lsDowRate = lsDowRate;
	}

	public void setLsEowRate(Double lsEowRate) {
		this.lsEowRate = lsEowRate;
	}

	public void setHotelRegistration(String hotelRegistration) {
		this.hotelRegistration = hotelRegistration;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public void setWebPage(String webPage) {
		this.webPage = webPage;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
