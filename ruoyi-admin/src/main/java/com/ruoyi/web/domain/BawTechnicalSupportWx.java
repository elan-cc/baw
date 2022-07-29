package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 技术支持对象 baw_technical_support_wx
 * 
 * @author ruoyi
 * @date 2022-04-20
 */
public class BawTechnicalSupportWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 标题 */
    @Excel(name = "标题")
    private String techTitle;

    /** 图片 */
    private String techPicture;

    /** 描述 */
    @Excel(name = "描述")
    private String techDescribe;

    /** 内容 */
    private String techContent;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date techReleaseTime;

    /** 板块（1：产品说明，2：官方维修，3：用户提问 */
    @Excel(name = "板块", readConverterExp = "板块（1：产品说明，2：官方维修，3：用户提问")
    private Integer techPlate;

    /** 文章启用（0：启用，1：禁用 */
    @Excel(name = "文章启用", readConverterExp = "文章启用（0：启用，1：禁用")
    private Integer techArticleEnable;

    /** 评论启用（0：启用，1：禁用 */
    @Excel(name = "评论启用", readConverterExp = "评论启用（0：启用，1：禁用")
    private Integer techCommentEnable;

    /** 来源 */
    private String techSource;

    /** 浏览数 */
    @Excel(name = "浏览数")
    private Integer techViewsCount;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Integer techLikesNumber;

    /** 是否删除(0：存在，1：删除 */
    private Integer techIsDelete;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setTechTitle(String techTitle) 
    {
        this.techTitle = techTitle;
    }

    public String getTechTitle() 
    {
        return techTitle;
    }
    public void setTechPicture(String techPicture) 
    {
        this.techPicture = techPicture;
    }

    public String getTechPicture() 
    {
        return techPicture;
    }
    public void setTechDescribe(String techDescribe) 
    {
        this.techDescribe = techDescribe;
    }

    public String getTechDescribe() 
    {
        return techDescribe;
    }
    public void setTechContent(String techContent) 
    {
        this.techContent = techContent;
    }

    public String getTechContent() 
    {
        return techContent;
    }
    public void setTechReleaseTime(Date techReleaseTime) 
    {
        this.techReleaseTime = techReleaseTime;
    }

    public Date getTechReleaseTime() 
    {
        return techReleaseTime;
    }
    public void setTechPlate(Integer techPlate) 
    {
        this.techPlate = techPlate;
    }

    public Integer getTechPlate() 
    {
        return techPlate;
    }
    public void setTechArticleEnable(Integer techArticleEnable) 
    {
        this.techArticleEnable = techArticleEnable;
    }

    public Integer getTechArticleEnable() 
    {
        return techArticleEnable;
    }
    public void setTechCommentEnable(Integer techCommentEnable) 
    {
        this.techCommentEnable = techCommentEnable;
    }

    public Integer getTechCommentEnable() 
    {
        return techCommentEnable;
    }
    public void setTechSource(String techSource) 
    {
        this.techSource = techSource;
    }

    public String getTechSource() 
    {
        return techSource;
    }
    public void setTechViewsCount(Integer techViewsCount) 
    {
        this.techViewsCount = techViewsCount;
    }

    public Integer getTechViewsCount() 
    {
        return techViewsCount;
    }
    public void setTechLikesNumber(Integer techLikesNumber) 
    {
        this.techLikesNumber = techLikesNumber;
    }

    public Integer getTechLikesNumber() 
    {
        return techLikesNumber;
    }
    public void setTechIsDelete(Integer techIsDelete) 
    {
        this.techIsDelete = techIsDelete;
    }

    public Integer getTechIsDelete() 
    {
        return techIsDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("techTitle", getTechTitle())
            .append("techPicture", getTechPicture())
            .append("techDescribe", getTechDescribe())
            .append("techContent", getTechContent())
            .append("techReleaseTime", getTechReleaseTime())
            .append("techPlate", getTechPlate())
            .append("techArticleEnable", getTechArticleEnable())
            .append("techCommentEnable", getTechCommentEnable())
            .append("techSource", getTechSource())
            .append("techViewsCount", getTechViewsCount())
            .append("techLikesNumber", getTechLikesNumber())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("techIsDelete", getTechIsDelete())
            .toString();
    }
}
