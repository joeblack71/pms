package com.myco.central.web.booking.form;

import java.util.List;
import java.util.Map;

import com.myco.central.model.Source;

public class SourceForm {
    private Source item;

    private List<Map<String,String>> items;

    public SourceForm() {
        this.item = new Source();
    }

    public Source getItem() {
        return item;
    }

    public List<Map<String,String>> getItems() {
        return items;
    }

    public void setItem(Source item) {
        this.item = item;
    }

    public void setItems(List<Map<String,String>> items) {
        this.items = items;
    }

}
