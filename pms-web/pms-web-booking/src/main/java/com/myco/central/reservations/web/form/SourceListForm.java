package com.myco.central.reservations.web.form;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

public class SourceListForm {
	private static final long serialVersionUID = 1L;
	
	private List<DynaBean> list;
	
	public SourceListForm() {
	}

	public List<DynaBean> getList() {
		return list;
	}

	public void setList(List<DynaBean> list) {
		this.list = list;
	}

}
