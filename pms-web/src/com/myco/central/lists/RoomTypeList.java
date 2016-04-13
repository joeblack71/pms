
package com.myco.central.lists;

import java.util.ArrayList;

import com.myco.central.vo.RoomType;

public class RoomTypeList extends ArrayList {

    public RoomTypeList() {
        super();
    }

    public RoomType getRoomType(int i){
        return( (RoomType)get(i) );
    }
    
}