package com.myco.central.web.booking.form;

import java.util.List;
import java.util.Map;

public class SourceListForm {
    private List<Map<String,String>> list;

    public SourceListForm() {
    }

    public List<Map<String,String>> getList() {
        return list;
    }

    public void setList(List<Map<String,String>> list) {
        this.list = list;
    }

}
