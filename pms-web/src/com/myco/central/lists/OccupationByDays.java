
package com.myco.central.lists;

import java.util.ArrayList;

import com.myco.central.vo.OccupationDay;

public class OccupationByDays extends ArrayList {

    public OccupationByDays() {
        super();
    }

    public OccupationDay getOccupationDay(int i){
        return( (OccupationDay)get(i) );
    }
    
}