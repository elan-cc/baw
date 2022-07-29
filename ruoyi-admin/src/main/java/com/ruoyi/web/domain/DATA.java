package com.ruoyi.web.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DATA {
    private  ITEM  item;

    @JsonProperty("ITEM")
    public ITEM getItem() {
        return item;
    }

    public void setItem(ITEM item) {
        this.item = item;
    }
}
