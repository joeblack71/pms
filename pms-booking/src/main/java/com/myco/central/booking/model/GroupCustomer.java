/*
 * GroupCustomer.java
 *
 * Created on Febrery 15, 2007, 11:55 AM
 * Last Modification:
 *
 */

package com.myco.central.booking.model;

import javax.persistence.Entity;

import com.myco.central.model.BaseAuditable;

@Entity
public class GroupCustomer extends BaseAuditable {

	private static final long serialVersionUID = 1L;
	
	private Long groupId;
    private String firstNames;
    private String lastName1;
	private Long reservationNumber;

	public GroupCustomer() {
	}

	public Long getGroupId() {
		return groupId;
	}

	public String getFirstNames() {
		return firstNames;
	}

	public String getLastName1() {
		return lastName1;
	}

	public Long getReservationNumber() {
		return reservationNumber;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}

	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}

	public void setReservationNumber(Long reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

}
