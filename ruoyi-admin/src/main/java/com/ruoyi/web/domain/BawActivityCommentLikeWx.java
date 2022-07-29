package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评论点赞记录对象 baw_activity_comment_like_wx
 *
 * @author ruoyi
 * @date 2022-03-18
 */
public class BawActivityCommentLikeWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 用户id */
    @Excel(name = "用户id")
    private Integer userId;

    /** 活动id */
    @Excel(name = "评论id")
    private Integer commentId;

    /** 点赞时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "点赞时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date likeTime;

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
    public void setCommentId(Integer commentId)
    {
        this.commentId = commentId;
    }

    public Integer getCommentId()
    {
        return commentId;
    }
    public void setLikeTime(Date likeTime)
    {
        this.likeTime = likeTime;
    }

    public Date getLikeTime()
    {
        return likeTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("commentId", getCommentId())
            .append("likeTime", getLikeTime())
            .toString();
    }
}
