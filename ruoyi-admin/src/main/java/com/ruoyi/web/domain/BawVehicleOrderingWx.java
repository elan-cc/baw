package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车辆订购管理对象 baw_vehicle_ordering_wx
 *
 * @author ruoyi
 * @date 2022-06-07
 */
public class BawVehicleOrderingWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /** 车系code */
    @Excel(name = "车系code")
    private String carSeriesCode;

    /** 车系名称 */
    @Excel(name = "车系名称")
    private String carSeriesName;

    /** 车型code */
    @Excel(name = "车型code")
    private String modelCode;

    /** 车型名称 */
    @Excel(name = "车型名称")
    private String modelName;

    /** 颜色 */
    @Excel(name = "颜色")
    private String color;
    /** 颜色 */
    @Excel(name = "颜色id")
    private String colorId;
    /** 色值 */
    @Excel(name = "色值")
    private String colorValue;

    /** 订购价格 */
    @Excel(name = "订购价格")
    private Integer price;
    /** 价格 */
    @Excel(name = "厂家指导价")
    private Integer guidancePrice;

    /** 图片 */
    @Excel(name = "图片")
    private String picture;

    public String getColorId() {
        return colorId;
    }

    public Integer getGuidancePrice() {
        return guidancePrice;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public void setGuidancePrice(Integer guidancePrice) {
        this.guidancePrice = guidancePrice;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setCarSeriesCode(String carSeriesCode)
    {
        this.carSeriesCode = carSeriesCode;
    }

    public String getCarSeriesCode()
    {
        return carSeriesCode;
    }
    public void setCarSeriesName(String carSeriesName)
    {
        this.carSeriesName = carSeriesName;
    }

    public String getCarSeriesName()
    {
        return carSeriesName;
    }
    public void setModelCode(String modelCode)
    {
        this.modelCode = modelCode;
    }

    public String getModelCode()
    {
        return modelCode;
    }
    public void setModelName(String modelName)
    {
        this.modelName = modelName;
    }

    public String getModelName()
    {
        return modelName;
    }
    public void setColor(String color)
    {
        this.color = color;
    }

    public String getColor()
    {
        return color;
    }
    public void setColorValue(String colorValue)
    {
        this.colorValue = colorValue;
    }

    public String getColorValue()
    {
        return colorValue;
    }
    public void setPrice(Integer price)
    {
        this.price = price;
    }

    public Integer getPrice()
    {
        return price;
    }
    public void setPicture(String picture)
    {
        this.picture = picture;
    }

    public String getPicture()
    {
        return picture;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carSeriesCode", getCarSeriesCode())
            .append("carSeriesName", getCarSeriesName())
            .append("modelCode", getModelCode())
            .append("modelName", getModelName())
            .append("color", getColor())
            .append("colorId", getColorId())
            .append("colorValue", getColorValue())
            .append("price", getPrice())
            .append("guidancePrice", getGuidancePrice())
            .append("picture", getPicture())
            .toString();
    }
}
