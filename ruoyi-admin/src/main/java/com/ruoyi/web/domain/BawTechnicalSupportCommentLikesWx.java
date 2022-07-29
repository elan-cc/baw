package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 技术支持评论点赞对象 baw_technical_support_comment_likes_wx
 * 
 * @author ruoyi
 * @date 2022-04-20
 */
public class BawTechnicalSupportCommentLikesWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 用户id */
    @Excel(name = "用户id")
    private Integer userId;

    /** 技术评论id */
    @Excel(name = "技术评论id")
    private Integer techcommentId;

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
    public void setTechcommentId(Integer techcommentId) 
    {
        this.techcommentId = techcommentId;
    }

    public Integer getTechcommentId() 
    {
        return techcommentId;
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
            .append("techcommentId", getTechcommentId())
            .append("likesTime", getLikesTime())
            .toString();
    }
}
