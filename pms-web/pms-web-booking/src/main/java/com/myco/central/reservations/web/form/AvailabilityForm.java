package com.myco.central.reservations.web.form;

import java.util.List;

import org.apache.commons.beanutils.DynaBean;

import com.myco.central.reservations.web.vo.AvailabilityFilter;

public class AvailabilityForm {
	private static final long serialVersionUID = 1L;
	
	private AvailabilityFilter filter;
	
	private List<DynaBean> hotels;
	private List<DynaBean> roomTypes;
	private List<DynaBean> periodTypes;
	
	public AvailabilityForm() {
		filter = new AvailabilityFilter();
	}
	
	public AvailabilityFilter getFilter() {
		return filter;
	}

	public void setFilter(AvailabilityFilter filter) {
		this.filter = filter;
	}

	public List<DynaBean> getHotels() {
		return hotels;
	}

	public void setHotels(List<DynaBean> hotels) {
		this.hotels = hotels;
	}

	public List<DynaBean> getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(List<DynaBean> roomTypes) {
		this.roomTypes = roomTypes;
	}

	public List<DynaBean> getPeriodTypes() {
		return periodTypes;
	}

	public void setPeriodTypes(List<DynaBean> periodTypes) {
		this.periodTypes = periodTypes;
	}

	//@Override
	/*public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		//this.filter = null;
	}*/

}
