package com.myco.central.reservations.web.form;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.myco.central.reservations.domain.SpecialRate;

public class SpecialRateForm {
	private static final long serialVersionUID = 1L;
	
	private SpecialRate item;
	
	private List<DynaBean> items;
	
	public SpecialRateForm() {
		this.item = new SpecialRate();
	}

	public List<DynaBean> getItems() {
		return items;
	}

	public void setItems(List<DynaBean> items) {
		this.items = items;
	}

	public SpecialRate getItem() {
		return item;
	}

	public void setItem(SpecialRate item) {
		this.item = item;
	}
	
}
