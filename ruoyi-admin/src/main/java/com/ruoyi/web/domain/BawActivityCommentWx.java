package com.ruoyi.web.domain;

import java.util.Date;
import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 活动评论对象 baw_activity_comment_wx
 *
 * @author ruoyi
 * @date 2022-03-17
 */
public class BawActivityCommentWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 头像URL */
    @Excel(name = "头像URL")
    private String avatar;

    /** 用户名 */
    @Excel(name = "用户名")
    private String name;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Integer likesCount;

    /** 父节点id */
    @Excel(name = "父节点id")
    private Integer parentId;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String content;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date creatyTime;

    /** 活动id */
    @Excel(name = "活动id")
    private Integer activityId;

    /** 用户id */
    @Excel(name = "用户id")
    private Integer userId;
    /**回复数量*/
    private Integer replyCount;
    /**是否点赞*/
    private Boolean isLike;
    
    private Boolean isOpen = false;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setLikesCount(Integer likesCount)
    {
        this.likesCount = likesCount;
    }

    public Integer getLikesCount()
    {
        return likesCount;
    }
    public void setParentId(Integer parentId)
    {
        this.parentId = parentId;
    }

    public Integer getParentId()
    {
        return parentId;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setCreatyTime(Date creatyTime)
    {
        this.creatyTime = creatyTime;
    }

    public Date getCreatyTime()
    {
        return creatyTime;
    }
    public void setActivityId(Integer activityId)
    {
        this.activityId = activityId;
    }

    public Integer getActivityId()
    {
        return activityId;
    }
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getUserId()
    {
        return userId;
    }
    
    public Integer getReplyCount() {
        return replyCount;
    }
    
    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }
    
    public Boolean getIsLike() {
        return isLike;
    }
    
    public void setIsLike(Boolean isLike) {
        this.isLike = isLike;
    }
    
    public Boolean getIsOpen() {
        return isOpen;
    }
    
    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    @Override
    public String toString() {
        return new StringJoiner(", ", BawActivityCommentWx.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("avatar='" + avatar + "'")
                .add("name='" + name + "'")
                .add("likesCount=" + likesCount)
                .add("parentId=" + parentId)
                .add("content='" + content + "'")
                .add("creatyTime=" + creatyTime)
                .add("activityId=" + activityId)
                .add("userId=" + userId)
                .add("replyCount=" + replyCount)
                .add("isLike=" + isLike)
                .add("isOpen=" + isOpen)
                .toString();
    }
}
