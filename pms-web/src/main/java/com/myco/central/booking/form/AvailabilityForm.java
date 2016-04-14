package com.myco.central.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.myco.central.vo.Availability;

public class AvailabilityForm extends ActionForm {
	private static final long serialVersionUID = 1L;
	
	private Availability item;
	
	public AvailabilityForm() {
		item = new Availability();
	}
	
	public Availability getItem() {
		return item;
	}

	public void setItem(Availability item) {
		this.item = item;
	}
	
	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		this.item = null;
	}

}
