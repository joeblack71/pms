
package com.mycom.booking.lists;

import java.util.ArrayList;

import com.mycom.booking.beans.RoomType;


public class RoomTypeList extends ArrayList {

    public RoomTypeList() {
        super();
    }

    public RoomType getRoomType(int i){
        return( (RoomType)get(i) );
    }
    
}