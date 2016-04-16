package com.myco.central.web.booking.form;

import java.util.List;
import java.util.Map;

import com.myco.central.model.Room;

public class RoomForm {
    private Room item;

    private List<Map<String,String>> items;

    public RoomForm() {
        this.item = new Room();
    }

    public Room getItem() {
        return item;
    }

    public List<Map<String,String>> getItems() {
        return items;
    }

    public void setItem(Room item) {
        this.item = item;
    }

    public void setItems(List<Map<String,String>> items) {
        this.items = items;
    }

}
