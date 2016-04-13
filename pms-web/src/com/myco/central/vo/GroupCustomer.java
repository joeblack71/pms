/*
 * GroupCustomer.java
 *
 * Created on Febrery 15, 2007, 11:55 AM
 * Last Modification:
 *
 */

package com.myco.central.vo;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class GroupCustomer implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String groupId;
    private String firstNames;
    private String lastName1;
    private String reservationNumber;

    /**
     * Creates new GroupCustomer
     */
    public GroupCustomer() {
    }

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getFirstNames() {
		return firstNames;
	}

	public void setFirstNames(String firstNames) {
		this.firstNames = firstNames;
	}

	public String getLastName1() {
		return lastName1;
	}

	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

}
