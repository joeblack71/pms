package com.myco.central.reservations.web.form;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.myco.central.reservations.domain.Room;

public class RoomForm {
	private static final long serialVersionUID = 1L;
	
	private Room item;
	
	private List<DynaBean> items;
	
	public RoomForm() {
		this.item = new Room();
	}

	public Room getItem() {
		return item;
	}

	public void setItem(Room item) {
		this.item = item;
	}

	public List<DynaBean> getItems() {
		return items;
	}

	public void setItems(List<DynaBean> items) {
		this.items = items;
	}
	
}
