package com.myco.central.reservations.web.form;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.myco.central.commons.model.Source;

public class SourceForm {
	private static final long serialVersionUID = 1L;
	
	private Source item;
	
	private List<DynaBean> items;
	
	public SourceForm() {
		this.item = new Source();
	}

	public Source getItem() {
		return item;
	}

	public void setItem(Source item) {
		this.item = item;
	}

	public List<DynaBean> getItems() {
		return items;
	}

	public void setItems(List<DynaBean> items) {
		this.items = items;
	}
	
}
