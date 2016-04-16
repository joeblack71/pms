package com.myco.central.commons.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "CONTACT")
public class Contact extends Person {
    private String notes;
    private Company company;

	public Contact() {
	}

    @ManyToOne
    @JoinColumn(name = "companyId")
    public Company getCompany() {
        return company;
    }

    public String getNotes() {
        return notes;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
