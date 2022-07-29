package com.ruoyi.web.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HEAD {
    /**
     * 省份
     */
    private String ERRORINFO;
    /**
     * 城市
     */
    private String ERRORCODE;
    /**
     * 城市
     */
    private String COMMENTS;

    /**
     * 城市
     */
    private String SUCCESSCOUNT;

    /**
     * 城市
     */
    private String TRANSACTIONID;
    /**
     * 城市
     */
    private String RESULT;

    @JsonProperty("ERRORINFO")
    public String getERRORINFO() {
        return ERRORINFO;
    }

    public void setERRORINFO(String ERRORINFO) {
        this.ERRORINFO = ERRORINFO;
    }
    @JsonProperty("ERRORCODE")
    public String getERRORCODE() {
        return ERRORCODE;
    }

    public void setERRORCODE(String ERRORCODE) {
        this.ERRORCODE = ERRORCODE;
    }
    @JsonProperty("COMMENTS")
    public String getCOMMENTS() {
        return COMMENTS;
    }

    public void setCOMMENTS(String COMMENTS) {
        this.COMMENTS = COMMENTS;
    }
    @JsonProperty("SUCCESSCOUNT")
    public String getSUCCESSCOUNT() {
        return SUCCESSCOUNT;
    }

    public void setSUCCESSCOUNT(String SUCCESSCOUNT) {
        this.SUCCESSCOUNT = SUCCESSCOUNT;
    }
    @JsonProperty("TRANSACTIONID")
    public String getTRANSACTIONID() {
        return TRANSACTIONID;
    }

    public void setTRANSACTIONID(String TRANSACTIONID) {
        this.TRANSACTIONID = TRANSACTIONID;
    }
    @JsonProperty("RESULT")
    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }
}
