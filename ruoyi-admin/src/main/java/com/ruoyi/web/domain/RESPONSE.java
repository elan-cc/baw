package com.ruoyi.web.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RESPONSE {
    private HEAD Head; //接收数据集合
    private DATA Data; //接收数据集合
    @JsonProperty("HEAD")
    public HEAD getHead() {
        return Head;
    }

    public void setHead(HEAD head) {
        Head = head;
    }
    @JsonProperty("DATA")
    public DATA getData() {
        return Data;
    }

    public void setData(DATA data) {
        Data = data;
    }
}
