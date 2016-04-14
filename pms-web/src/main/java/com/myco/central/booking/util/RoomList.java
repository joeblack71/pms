
package com.mycom.booking.lists;

import java.util.ArrayList;

import com.mycom.booking.beans.Room;


public class RoomList extends ArrayList {

    public RoomList() {
        super();
    }

    public Room getRoom(int i){
        return( (Room)get(i) );
    }
    
}