/*
 * VerifyAttribute.java
 *
 * Created on 22 de junio de 2007, 12:27
 *
 * Verify if an attribute value is correct. It means, that this 
 * have a value on accord with the attribute type.
 */

package com.mycom.booking.libraries;

/**
 *
 * @author Developer
 */
public class VerifyAttribute {
    
    /** Creates a new instance of VerifyAttribute */
    public VerifyAttribute() {
    }
    
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(Exception ex) { return false; }
        return true;
    }
    
}
