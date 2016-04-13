
package com.myco.central.lists;

import java.util.ArrayList;

import com.myco.central.vo.SpecialRate;

public class RoomTypeRates extends ArrayList {

    public RoomTypeRates() {
        super();
    }

    public SpecialRate getRoomTypeRate(int i){
        return( (SpecialRate)get(i) );
    }
    
}