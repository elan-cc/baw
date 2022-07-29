package com.ruoyi.web.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 活动对象 baw_activity_wx
 *
 * @author ruoyi
 * @date 2022-03-17
 */
public class BawActivityWx extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 省份编码
     */
    private String provinceCode;

    /**
     * 省份名称
     */
    @Excel(name = "省份名称")
    private String provinceName;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 城市名称
     */
    @Excel(name = "城市名称")
    private String cityName;

    /**
     * 活动标题
     */
    @Excel(name = "活动标题")
    private String activityTitle;

    /**
     * 活动描述
     */
    private String activityDescribe;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "开始时间")
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "结束时间")
    private Date endTime;

    /**
     * 是否启用
     */
    @Excel(name = "是否启用")
    private Integer isAble;

    /**
     * 活动类型
     */
    @Excel(name = "活动类型")
    private Integer activityType;

    /**
     * 浏览数
     */
    @Excel(name = "浏览数")
    private Integer viewsCount;

    /**
     * 点赞数
     */
    @Excel(name = "点赞数")
    private Integer likesCount;

    /**
     * 缩略图
     */
    private String thumbnail;

    /**
     * 评论数量
     */
    @Excel(name = "评论数量")
    private Integer contentCount;
    /**
     * 是否点赞
     */
    private Boolean isLike;

    /**
     * 活动状态(0:未开始,1:进行中,2:已结束
     */
    @Excel(name = "活动状态(0:未开始,1:进行中,2:已结束")
    private Integer activityState;


    /**
     * 是否删除（0：未删除，1：已删除
     */
    @Excel(name = "是否删除（0：未删除，1：已删除")
    private Integer isDeleted;


    /**
     * 经销商编码
     */
    @Excel(name = "经销商编码")
    private String  dealershopCode;




    public String getDealershopCode() {
        return dealershopCode;
    }

    public void setDealershopCode(String dealershopCode) {
        this.dealershopCode = dealershopCode;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }


    public Integer getActivityState() {
        return activityState;
    }

    public void setActivityState(Integer activityState) {
        this.activityState = activityState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getActivityTitle() {
        return activityTitle;
    }


    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getActivityDescribe() {
        return activityDescribe;
    }

    public void setActivityDescribe(String activityDescribe) {
        this.activityDescribe = activityDescribe;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getIsAble() {
        return isAble;
    }

    public void setIsAble(Integer isAble) {
        this.isAble = isAble;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Integer getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getContentCount() {
        return contentCount;
    }

    public void setContentCount(Integer contentCount) {
        this.contentCount = contentCount;
    }

    public Boolean getIsLike() {
        return isLike;
    }

    public void setIsLike(Boolean isLike) {
        this.isLike = isLike;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("provinceCode", getProvinceCode())
                .append("provinceName", getProvinceName())
                .append("cityCode", getCityCode())
                .append("cityName", getCityName())
                .append("activityTitle", getActivityTitle())
                .append("activityDescribe", getActivityDescribe())
                .append("createTime", getCreateTime())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("isAble", getIsAble())
                .append("activityType", getActivityType())
                .append("viewsCount", getViewsCount())
                .append("likesCount", getLikesCount())
                .append("thumbnail", getThumbnail())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("contentCount", getContentCount())
                .append("activityState", getActivityState())
                .append("isDeleted", getIsDeleted())
                .append("dealershopCode", getDealershopCode())
                .toString();
    }
}
