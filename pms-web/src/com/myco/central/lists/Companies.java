
package com.myco.central.lists;

import java.util.ArrayList;

import com.myco.central.vo.Company;

public class Companies extends ArrayList<Company> {

	private static final long serialVersionUID = 1L;

	public Companies() {
        super();
    }

    public Company getCompany(int i){
        return( (Company)get(i) );
    }
    
}