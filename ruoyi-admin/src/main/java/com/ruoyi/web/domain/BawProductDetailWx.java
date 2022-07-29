package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品手册详情对象 baw_product_detail_wx
 *
 * @author ruoyi
 * @date 2022-05-27
 */
public class BawProductDetailWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 产品手册id */
    @Excel(name = "产品手册id")
    private Integer manualId;

    /** 标题 */
    @Excel(name = "标题")
    private String tittle;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 排序 */
    @Excel(name = "排序")
    private Integer orderNum;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setManualId(Integer manualId)
    {
        this.manualId = manualId;
    }

    public Integer getManualId()
    {
        return manualId;
    }
    public void setTittle(String tittle)
    {
        this.tittle = tittle;
    }

    public String getTittle()
    {
        return tittle;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setOrderNum(Integer orderNum)
    {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum()
    {
        return orderNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("manualId", getManualId())
            .append("tittle", getTittle())
            .append("content", getContent())
            .append("orderNum", getOrderNum())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
