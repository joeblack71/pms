
package com.myco.central.lists;

import java.util.ArrayList;

import com.myco.central.vo.Room;

public class RoomList extends ArrayList {

    public RoomList() {
        super();
    }

    public Room getRoom(int i){
        return( (Room)get(i) );
    }
    
}