
package com.myco.central.reservations.web.vo;

import com.myco.central.constants.CentralModuleConstants;
import com.myco.central.util.DateUtils;

public class AvailabilityFilter {

    private String idHotel;
    private String startDate;
    private String endDate;
    private String roomType;
    private String period;
    private String status;

    public AvailabilityFilter() {
    	this.period = String.valueOf(CentralModuleConstants.WEEKLY);
    	this.startDate = DateUtils.getStringCurrentDate();
    }

	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getStatus() {
        return status;
    }

	public void setStatus(String status) {
        this.status = status;
    }

}