
package com.myco.central.web.vo;

public class CommonFilterVo {

    private String idHotel;
    private String fieldPattern;
    private String pattern;
    private String status;

    public CommonFilterVo() {
    	this.idHotel = "";
    	this.pattern = "";
    }

	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}

	public String getFieldPattern() {
		return fieldPattern;
	}

	public void setFieldPattern(String fieldPattern) {
		this.fieldPattern = fieldPattern;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}