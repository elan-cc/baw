package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品手册对象 baw_product_manual
 *
 * @author ruoyi
 * @date 2022-05-10
 */
public class BawProductManual extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /** 车辆名称 */
    @Excel(name = "车辆名称")
    private String carName;

    /** 图片 */
    @Excel(name = "图片")
    private String picture;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatyTime;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 浏览数量 */
    @Excel(name = "浏览数量")
    private Integer browseQuantity;

    /** 分享数量 */
    @Excel(name = "分享数量")
    private Integer analysisQuantity;

    /** 点赞数量 */
    @Excel(name = "点赞数量")
    private Integer likesQuantity;

    private Boolean isList;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setCarName(String carName)
    {
        this.carName = carName;
    }

    public String getCarName()
    {
        return carName;
    }
    public void setPicture(String picture)
    {
        this.picture = picture;
    }

    public String getPicture()
    {
        return picture;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setCreatyTime(Date creatyTime)
    {
        this.creatyTime = creatyTime;
    }

    public Date getCreatyTime()
    {
        return creatyTime;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setBrowseQuantity(Integer browseQuantity)
    {
        this.browseQuantity = browseQuantity;
    }

    public Integer getBrowseQuantity()
    {
        return browseQuantity;
    }
    public void setAnalysisQuantity(Integer analysisQuantity)
    {
        this.analysisQuantity = analysisQuantity;
    }

    public Integer getAnalysisQuantity()
    {
        return analysisQuantity;
    }
    public void setLikesQuantity(Integer likesQuantity)
    {
        this.likesQuantity = likesQuantity;
    }

    public Integer getLikesQuantity()
    {
        return likesQuantity;
    }

    public Boolean getIsList() {
        return isList;
    }

    public void setIsList(Boolean isList) {
        this.isList = isList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carName", getCarName())
            .append("picture", getPicture())
            .append("title", getTitle())
            .append("creatyTime", getCreatyTime())
            .append("content", getContent())
            .append("browseQuantity", getBrowseQuantity())
            .append("analysisQuantity", getAnalysisQuantity())
            .append("likesQuantity", getLikesQuantity())
            .append("isList", getIsList())
            .toString();
    }
}
