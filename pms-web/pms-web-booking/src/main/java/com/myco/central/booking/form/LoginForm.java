package com.myco.central.web.form;


public class LoginForm {
	
	private String userName;
	private String password;
	private String idHotel;
	
	public LoginForm() {
	}
	
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
	
	public String getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(String hotelId) {
		this.idHotel = hotelId;
	}

	public void reset() {
		this.userName = null;
		this.password = null;
	}
	
}
