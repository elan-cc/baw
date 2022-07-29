package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 技术支持评论对象 baw_technical_support_comment_wx
 * 
 * @author ruoyi
 * @date 2022-04-20
 */
public class BawTechnicalSupportCommentWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatyTime;

    /** 技术id */
    @Excel(name = "技术id")
    private Integer techId;

    /** 用户id */
    @Excel(name = "用户id")
    private Integer userId;

    /** 回复数量 */
    @Excel(name = "回复数量")
    private Integer replyCount;

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
    public void setTechId(Integer techId) 
    {
        this.techId = techId;
    }

    public Integer getTechId() 
    {
        return techId;
    }
    public void setUserId(Integer userId) 
    {
        this.userId = userId;
    }

    public Integer getUserId() 
    {
        return userId;
    }
    public void setReplyCount(Integer replyCount) 
    {
        this.replyCount = replyCount;
    }

    public Integer getReplyCount() 
    {
        return replyCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("avatar", getAvatar())
            .append("name", getName())
            .append("likesCount", getLikesCount())
            .append("parentId", getParentId())
            .append("content", getContent())
            .append("creatyTime", getCreatyTime())
            .append("techId", getTechId())
            .append("userId", getUserId())
            .append("replyCount", getReplyCount())
            .toString();
    }
}
