package com.ruoyi.web.domain;

import com.ruoyi.common.annotation.Excel;

public class InItem {
    //品牌编码
    private String carBrandCode;

    //品牌英文名称
    private String carBrandEn;

   //品牌中文名称
    private String carBrandCn;

    private String isEnable;

    public String getCarBrandCode() {
        return carBrandCode;
    }

    public void setCarBrandCode(String carBrandCode) {
        this.carBrandCode = carBrandCode;
    }

    public String getCarBrandEn() {
        return carBrandEn;
    }

    public void setCarBrandEn(String carBrandEn) {
        this.carBrandEn = carBrandEn;
    }

    public String getCarBrandCn() {
        return carBrandCn;
    }

    public void setCarBrandCn(String carBrandCn) {
        this.carBrandCn = carBrandCn;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
}
