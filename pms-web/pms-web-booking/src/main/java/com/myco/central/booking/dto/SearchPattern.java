
package com.myco.central.web.booking.vo;

public class SearchPattern {

    private String partyId;
    private String patternValue;
    private String status;

    public SearchPattern() {
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPartyId() {
		return partyId;
	}

	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}

	public String getPatternValue() {
		return patternValue;
	}

	public void setPatternValue(String patternValue) {
		this.patternValue = patternValue;
	}

}