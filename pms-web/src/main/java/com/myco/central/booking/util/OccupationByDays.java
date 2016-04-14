
package com.mycom.booking.lists;

import java.util.ArrayList;

import com.mycom.booking.beans.OccupationDay;


public class OccupationByDays extends ArrayList {

    public OccupationByDays() {
        super();
    }

    public OccupationDay getOccupationDay(int i){
        return( (OccupationDay)get(i) );
    }
    
}