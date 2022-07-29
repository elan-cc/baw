package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 活动点赞记录对象 baw_activity_like_wx
 * 
 * @author ruoyi
 * @date 2022-03-18
 */
public class BawActivityLikeWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 用户id */
    @Excel(name = "用户id")
    private Integer userId;

    /** 活动id */
    @Excel(name = "活动id")
    private Integer activityId;

    /** 点赞时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "点赞时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date likesTime;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setUserId(Integer userId) 
    {
        this.userId = userId;
    }

    public Integer getUserId() 
    {
        return userId;
    }
    public void setActivityId(Integer activityId) 
    {
        this.activityId = activityId;
    }

    public Integer getActivityId() 
    {
        return activityId;
    }
    public void setLikesTime(Date likesTime) 
    {
        this.likesTime = likesTime;
    }

    public Date getLikesTime() 
    {
        return likesTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("activityId", getActivityId())
            .append("likesTime", getLikesTime())
            .toString();
    }
}
