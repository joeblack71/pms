/*
 * ReceiptStatus.java
 *
 * Created on Febrary 22, 2007, 9:00 PM
 */

package beans;

import java.io.Serializable;

/**
 *
 * @author  instructor
 * @version
 */
public class ReceiptStatus implements Serializable {

    private String receiptStatus;
    private String description;

    /** Creates new ReceiptStatus */
    public ReceiptStatus() {
    }

    public String getReceiptStatus() {
        return receiptStatus;
    }
    public void setReceiptStatus(String _receiptStatus) {
        this.receiptStatus = _receiptStatus;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
