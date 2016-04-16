/*
 * PaymentType.java
 *
 * Created on Febrery 22, 2007, 5:15 PM
 */

package beans;

import java.io.Serializable;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class PaymentType implements Serializable {

    private int    paymentType;
    private String description;

    /** Creates new PaymentType */
    public PaymentType() {
    }

    public int getPaymentType() {
        return paymentType;
    }
    public void setPaymentType(int _paymentType) {
        this.paymentType = _paymentType;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
