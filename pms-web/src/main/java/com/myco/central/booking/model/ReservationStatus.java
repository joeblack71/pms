
package com.mycom.booking.beans;

public class ReservationStatus {

    private String status;
    private String description;

    /**
     * Creates new ReservationStatus
     */
    public ReservationStatus() {
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}