package com.myco.central.web.booking.form;

import com.myco.central.booking.model.SpecialRate;

import java.util.List;
import java.util.Map;

public class SpecialRateForm {
    private SpecialRate item;

    private List<Map<String,String>> items;

    public SpecialRateForm() {
        this.item = new SpecialRate();
    }

    public SpecialRate getItem() {
        return item;
    }

    public List<Map<String,String>> getItems() {
        return items;
    }

    public void setItem(SpecialRate item) {
        this.item = item;
    }

    public void setItems(List<Map<String,String>> items) {
        this.items = items;
    }

}
