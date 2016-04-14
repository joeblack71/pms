
package com.mycom.booking.lists;

import java.util.ArrayList;

import com.mycom.booking.beans.Company;


public class Companies extends ArrayList {

    public Companies() {
        super();
    }

    public Company getCompany(int i){
        return( (Company)get(i) );
    }
    
}