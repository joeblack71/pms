/*
 * DocumentType.java
 *
 * Created on April 1, 2007, 11:00 PM
 */

package com.myco.central.vo;

/**
 *
 * @author  instructor
 * @version
 */
public class PaymentType {

    private short  paymentType;
    private String description;

    /** Creates new PaymentType */
    public PaymentType() {
    }

    public short getPaymentType() {
        return paymentType;
    }
    public void setPaymentType(short paymentType) {
        this.paymentType = paymentType;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
