package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品对象 baw_commodity_wx
 *
 * @author ruoyi
 * @date 2022-05-19
 */
public class BawCommodityWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /** 图片 */
    @Excel(name = "图片")
    private String picture;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String name;

    /** 分类id */
    @Excel(name = "分类id")
    private Integer classificationId;

    /** 轮播图 */
    @Excel(name = "轮播图")
    private String rotationMap;

    /** 简介 */
    @Excel(name = "简介")
    private String introduction;

    /** 价格 */
    @Excel(name = "价格")
    private String price;

    /** 库存 */
    @Excel(name = "库存")
    private Integer stock;

    /** 销量 */
    @Excel(name = "销量")
    private Integer sales;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatyTime;

    /** 销量 */
    @Excel(name = "规格")
    private Integer specifications;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setPicture(String picture)
    {
        this.picture = picture;
    }

    public String getPicture()
    {
        return picture;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setClassificationId(Integer classificationId)
    {
        this.classificationId = classificationId;
    }

    public Integer getClassificationId()
    {
        return classificationId;
    }
    public void setRotationMap(String rotationMap)
    {
        this.rotationMap = rotationMap;
    }

    public String getRotationMap()
    {
        return rotationMap;
    }
    public void setIntroduction(String introduction)
    {
        this.introduction = introduction;
    }

    public String getIntroduction()
    {
        return introduction;
    }
    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getPrice()
    {
        return price;
    }
    public void setStock(Integer stock)
    {
        this.stock = stock;
    }

    public Integer getStock()
    {
        return stock;
    }
    public void setSales(Integer sales)
    {
        this.sales = sales;
    }

    public Integer getSales()
    {
        return sales;
    }
    public void setCreatyTime(Date creatyTime)
    {
        this.creatyTime = creatyTime;
    }

    public Date getCreatyTime()
    {
        return creatyTime;
    }

    public Integer getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Integer specifications) {
        this.specifications = specifications;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("picture", getPicture())
            .append("name", getName())
            .append("classificationId", getClassificationId())
            .append("rotationMap", getRotationMap())
            .append("introduction", getIntroduction())
            .append("price", getPrice())
            .append("stock", getStock())
            .append("sales", getSales())
            .append("creatyTime", getCreatyTime())
            .append("specifications", getSpecifications())
            .toString();
    }
}
