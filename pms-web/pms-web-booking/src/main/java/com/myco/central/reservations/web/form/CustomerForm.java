package com.myco.central.reservations.web.form;

import com.myco.central.commons.model.Customer;

public class CustomerForm {
	private static final long serialVersionUID = 1L;
	
	private Customer cust;
	
	public CustomerForm() {
	    this.cust = new Customer();
	}
	
	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

}
