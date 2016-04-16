package com.myco.central.web.booking.form;

import java.util.List;
import java.util.Map;

public class RoomStatusForm {
    private List<Map<String,String>> rooms;

    public RoomStatusForm() {
    }

    public List<Map<String,String>> getRooms() {
        return rooms;
    }

    public void setRooms(List<Map<String,String>> rooms) {
        this.rooms = rooms;
    }

}
