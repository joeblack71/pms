/*
 * Search.java
 *
 * Created on 12 de mayo de 2007, 15:19
 */

package com.myco.central.web.booking.vo;

import java.io.Serializable;

/**
 * @author Developer
 */
public class Search implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
    private String sampleField;
    private String sampleValue;

    public Long getId() {
        return id;
    }

    public String getSampleField() {
        return this.sampleField;
    }

    public String getSampleValue() {
        return this.sampleValue;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSampleField(String fieldName) {
        this.sampleField = fieldName;
    }

    public void setSampleValue(String sampleValue) {
        this.sampleValue = sampleValue;
    }

}
