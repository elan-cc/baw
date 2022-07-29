package com.ruoyi.web.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReceiveMainbrandResponse {
    private RESPONSE response; //接收数据集合

    @JsonProperty("RESPONSE")
    public RESPONSE getResponse() {
        return response;
    }

    public void setResponse(RESPONSE response) {
        this.response = response;
    }
}
