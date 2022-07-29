package com.ruoyi.web.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ITEM {
    private String ZSTATUSTXT;

    //品牌英文名称
    private String ZSTATUSRE;

    //品牌中文名称
    private String ZMMCX;


    //门店信息同步接口返回字段
    private String DLR_CODE;
    private String KUNNR;
    private String ZTYPE;
    private String ZMESSAGE;
    private String ZDATE;
    private String ZTIME;

    public ITEM() {
    }


    @JsonProperty("ZSTATUSTXT")
    public String getZSTATUSTXT() {
        return ZSTATUSTXT;
    }

    public void setZSTATUSTXT(String ZSTATUSTXT) {
        this.ZSTATUSTXT = ZSTATUSTXT;
    }
    @JsonProperty("ZSTATUSRE")
    public String getZSTATUSRE() {
        return ZSTATUSRE;
    }

    public void setZSTATUSRE(String ZSTATUSRE) {
        this.ZSTATUSRE = ZSTATUSRE;
    }
    @JsonProperty("ZMMCX")
    public String getZMMCX() {
        return ZMMCX;
    }

    public void setZMMCX(String ZMMCX) {
        this.ZMMCX = ZMMCX;
    }
    @JsonProperty("DLR_CODE")
    public String getDLR_CODE() {
        return DLR_CODE;
    }

    public void setDLR_CODE(String DLR_CODE) {
        this.DLR_CODE = DLR_CODE;
    }
    @JsonProperty("KUNNR")
    public String getKUNNR() {
        return KUNNR;
    }

    public void setKUNNR(String KUNNR) {
        this.KUNNR = KUNNR;
    }
    @JsonProperty("ZTYPE")
    public String getZTYPE() {
        return ZTYPE;
    }

    public void setZTYPE(String ZTYPE) {
        this.ZTYPE = ZTYPE;
    }
    @JsonProperty("ZMESSAGE")
    public String getZMESSAGE() {
        return ZMESSAGE;
    }

    public void setZMESSAGE(String ZMESSAGE) {
        this.ZMESSAGE = ZMESSAGE;
    }
    @JsonProperty("ZDATE")
    public String getZDATE() {
        return ZDATE;
    }

    public void setZDATE(String ZDATE) {
        this.ZDATE = ZDATE;
    }
    @JsonProperty("ZTIME")
    public String getZTIME() {
        return ZTIME;
    }

    public void setZTIME(String ZTIME) {
        this.ZTIME = ZTIME;
    }
}
