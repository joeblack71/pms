/*
 * ReceiptType.java
 *
 * Created on December 11, 2002, 7:42 PM
 */

package beans;

import java.io.Serializable;

/**
 *
 * @author  instructor
 * @version
 */
public class ReceiptType implements Serializable {

    private int    receiptType;
    private String description;

    /** Creates new ReceiptType */
    public ReceiptType() {
    }

    public int getReceiptType() {
        return receiptType;
    }
    public void setReceiptType(int _receiptType) {
        this.receiptType = _receiptType;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
