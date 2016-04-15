package com.myco.central.reservations.web.form;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

public class RoomStatusForm {
	private static final long serialVersionUID = 1L;
	
	private List<DynaBean> rooms;
	
	public RoomStatusForm() {
	}

	public List<DynaBean> getRooms() {
		return rooms;
	}

	public void setRooms(List<DynaBean> rooms) {
		this.rooms = rooms;
	}

}
