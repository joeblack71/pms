
package com.mycom.booking.lists;

import java.util.ArrayList;

import com.mycom.booking.beans.RoomRate;


public class RoomTypeRates extends ArrayList {

    public RoomTypeRates() {
        super();
    }

    public RoomRate getRoomTypeRate(int i){
        return( (RoomRate)get(i) );
    }
    
}