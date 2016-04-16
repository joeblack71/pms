
package com.myco.central.web.util;

import java.util.List;
import java.util.Map;

import com.myco.central.model.RoomType;

public class SessionAttributes {

    private String idHotel;
    private String idUser;
    private String userInitials;
    
    private List<Map<String, Object>> rateList;

    private List<RoomType> roomTypes;

    /** Creates new SessionAttributes */
    public SessionAttributes() {
    }

	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getUserInitials() {
		return userInitials;
	}

	public void setUserInitials(String userInitials) {
		this.userInitials = userInitials;
	}

	public List<RoomType> getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(List<RoomType> roomTypes) {
		this.roomTypes = roomTypes;
	}

	public List<Map<String, Object>> getRateselect() {
		return rateList;
	}

	public void setRateselect(List<Map<String, Object>> rateList) {
		this.rateList = rateList;
	}

}