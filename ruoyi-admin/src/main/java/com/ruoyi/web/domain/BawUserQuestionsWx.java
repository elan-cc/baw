package com.ruoyi.web.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 用户提问对象 baw_user_questions_wx
 *
 * @author ruoyi
 * @date 2022-04-20
 */
public class BawUserQuestionsWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /** 图片 */
    @Excel(name = "图片")
    private String picture;

    /** 反馈问题类型(0:车辆，1:销售，2:售后，3:线上体验) */
    @Excel(name = "反馈问题类型")
    private Integer feedbackQuestions;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 电话 */
    @Excel(name = "电话")
    private String telephone;

    /** 用户id */
    @Excel(name = "用户id")
    private Integer userId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createTime;

    /** 回复 */
    @Excel(name = "回复")
    private String reply;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 回复人 */
    @Excel(name = "回复人")
    private String respondent;

    /** 回复时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "回复时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date replyTime;

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRespondent() {
        return respondent;
    }

    public void setRespondent(String respondent) {
        this.respondent = respondent;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

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
    public void setFeedbackQuestions(Integer feedbackQuestions)
    {
        this.feedbackQuestions = feedbackQuestions;
    }

    public Integer getFeedbackQuestions()
    {
        return feedbackQuestions;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getTelephone()
    {
        return telephone;
    }
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getUserId()
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("picture", getPicture())
            .append("feedbackQuestions", getFeedbackQuestions())
            .append("content", getContent())
            .append("name", getName())
            .append("telephone", getTelephone())
            .append("userId", getUserId())
            .append("createTime", getCreateTime())
            .append("reply", getReply())
            .append("remarks", getRemarks())
            .append("respondent", getRespondent())
            .append("replyTime", getReplyTime())
            .toString();
    }
}
