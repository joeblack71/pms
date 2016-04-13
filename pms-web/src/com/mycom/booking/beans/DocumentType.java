/*
 * DocumentType.java
 *
 * Created on December 11, 2002, 7:42 PM
 */

package com.mycom.booking.beans;

import java.io.Serializable;

/**
 *
 * @author  instructor
 * @version
 */
public class DocumentType implements Serializable {

    private short  documentType;
    private String description;

    /** Creates new DocumentType */
    public DocumentType() {
    }

    public short getDocumentType() {
        return documentType;
    }
    public void setDocumentType(short _documentType) {
        this.documentType = _documentType;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
