package com.myco.central.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class LoginForm extends ActionForm{
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private String hotelId;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public void reset(ActionMapping arg0, HttpServletRequest arg1) {
		this.userName = null;
		this.password = null;
	}
	
}
