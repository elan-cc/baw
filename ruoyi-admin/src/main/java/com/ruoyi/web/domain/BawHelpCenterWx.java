package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 帮助中心对象 baw_help_center_wx
 *
 * @author ruoyi
 * @date 2022-04-22
 */
public class BawHelpCenterWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /** 问题分类（1：账号问题；2：发票问题） */
    @Excel(name = "问题分类")
    private Integer questionType;

    /** 分类描述 */
    @Excel(name = "分类描述")
    private String typeDescription;

    /** 问题标题 */
    @Excel(name = "问题标题")
    private String questionTitle;

    /** 问题内容 */
    @Excel(name = "问题内容")
    private String questionContent;

    /** 问题解答 */
    @Excel(name = "问题解答")
    private String questionSolving;

    /** 是否热门（1：账号问题；2：发票问题）*/
    @Excel(name = "是否热门")
    private Integer isHot;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setQuestionType(Integer questionType)
    {
        this.questionType = questionType;
    }

    public Integer getQuestionType()
    {
        return questionType;
    }
    public void setTypeDescription(String typeDescription)
    {
        this.typeDescription = typeDescription;
    }

    public String getTypeDescription()
    {
        return typeDescription;
    }
    public void setQuestionTitle(String questionTitle)
    {
        this.questionTitle = questionTitle;
    }

    public String getQuestionTitle()
    {
        return questionTitle;
    }
    public void setQuestionContent(String questionContent)
    {
        this.questionContent = questionContent;
    }

    public String getQuestionContent()
    {
        return questionContent;
    }
    public void setQuestionSolving(String questionSolving)
    {
        this.questionSolving = questionSolving;
    }

    public String getQuestionSolving()
    {
        return questionSolving;
    }
    public void setIsHot(Integer isHot)
    {
        this.isHot = isHot;
    }

    public Integer getIsHot()
    {
        return isHot;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("questionType", getQuestionType())
            .append("typeDescription", getTypeDescription())
            .append("questionTitle", getQuestionTitle())
            .append("questionContent", getQuestionContent())
            .append("questionSolving", getQuestionSolving())
            .append("isHot", getIsHot())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
