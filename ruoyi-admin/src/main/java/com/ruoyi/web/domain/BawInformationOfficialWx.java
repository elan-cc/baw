package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 官方资讯/精彩推荐对象 baw_information_official_wx
 *
 * @author ruoyi
 * @date 2022-04-19
 */
public class BawInformationOfficialWx extends BaseEntity
{
    private static final Long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 标题 */
    @Excel(name = "标题")
    private String infoTitle;

    /** 图片 */
    @Excel(name = "图片")
    private String infoPicture;

    /** 描述 */
    @Excel(name = "描述")
    private String infoDescribe;

    /** 内容 */
    @Excel(name = "内容")
    private String infoContent;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date infoReleaseTime;

    /** 焦点 */
    @Excel(name = "焦点")
    private Integer infoFocus;

    /** 文章启用 */
    @Excel(name = "文章启用")
    private Integer infoArticleEnable;

    /** 评论启用 */
    @Excel(name = "评论启用")
    private Integer infoCommentEnable;

    /** 来源 */
    @Excel(name = "来源")
    private String infoSource;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Integer infoLikesNumber;

    /** 浏览数 */
    @Excel(name = "浏览数")
    private Integer infoViewsCount;


    /** 是否删除 */
    @Excel(name = "是否删除")
    private Integer infoIsDelete;
    /** 类型 */
    @Excel(name = "类型")
    private Integer type;
    /** 分享数量 */
    @Excel(name = "分享数量")
    private Integer shareCount;


    /**
     * 是否点赞
     */
    private Boolean isLike;

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setInfoTitle(String infoTitle)
    {
        this.infoTitle = infoTitle;
    }

    public String getInfoTitle()
    {
        return infoTitle;
    }
    public void setInfoPicture(String infoPicture)
    {
        this.infoPicture = infoPicture;
    }

    public String getInfoPicture()
    {
        return infoPicture;
    }
    public void setInfoDescribe(String infoDescribe)
    {
        this.infoDescribe = infoDescribe;
    }

    public String getInfoDescribe()
    {
        return infoDescribe;
    }
    public void setInfoContent(String infoContent)
    {
        this.infoContent = infoContent;
    }

    public String getInfoContent()
    {
        return infoContent;
    }
    public void setInfoReleaseTime(Date infoReleaseTime)
    {
        this.infoReleaseTime = infoReleaseTime;
    }

    public Date getInfoReleaseTime()
    {
        return infoReleaseTime;
    }
    public void setInfoFocus(Integer infoFocus)
    {
        this.infoFocus = infoFocus;
    }

    public Integer getInfoFocus()
    {
        return infoFocus;
    }
    public void setInfoArticleEnable(Integer infoArticleEnable)
    {
        this.infoArticleEnable = infoArticleEnable;
    }

    public Integer getInfoArticleEnable()
    {
        return infoArticleEnable;
    }
    public void setInfoCommentEnable(Integer infoCommentEnable)
    {
        this.infoCommentEnable = infoCommentEnable;
    }

    public Integer getInfoCommentEnable()
    {
        return infoCommentEnable;
    }
    public void setInfoSource(String infoSource)
    {
        this.infoSource = infoSource;
    }

    public String getInfoSource()
    {
        return infoSource;
    }
    public void setInfoLikesNumber(Integer infoLikesNumber)
    {
        this.infoLikesNumber = infoLikesNumber;
    }

    public Integer getInfoLikesNumber()
    {
        return infoLikesNumber;
    }
    public Integer getInfoViewsCount() {
        return infoViewsCount;
    }

    public void setInfoViewsCount(Integer infoViewsCount) {
        this.infoViewsCount = infoViewsCount;
    }
    public Integer getInfoIsDelete() {
        return infoIsDelete;
    }

    public void setInfoIsDelete(Integer infoIsDelete) {
        this.infoIsDelete = infoIsDelete;
    }
    public Boolean getIsLike() {
        return isLike;
    }

    public void setIsLike(Boolean like) {
        isLike = like;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("infoTitle", getInfoTitle())
            .append("infoPicture", getInfoPicture())
            .append("infoDescribe", getInfoDescribe())
            .append("infoContent", getInfoContent())
            .append("infoReleaseTime", getInfoReleaseTime())
            .append("infoFocus", getInfoFocus())
            .append("infoArticleEnable", getInfoArticleEnable())
            .append("infoCommentEnable", getInfoCommentEnable())
            .append("infoSource", getInfoSource())
            .append("infoLikesNumber", getInfoLikesNumber())
            .append("infoViewsCount", getInfoViewsCount())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("infoIsDelete", getInfoIsDelete())
            .append("type", getType())
            .append("shareCount", getShareCount())
            .toString();
    }
}
