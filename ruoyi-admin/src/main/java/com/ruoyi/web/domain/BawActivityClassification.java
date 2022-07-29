package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 活动分类对象 baw_activity_classification
 *
 * @author ruoyi
 * @date 2022-05-25
 */
public class BawActivityClassification extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String classificationName;

    /** 创建日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cearteTime;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createBy;

    /** 排序*/
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
    public void setClassificationName(String classificationName)
    {
        this.classificationName = classificationName;
    }

    public String getClassificationName()
    {
        return classificationName;
    }
    public void setCearteTime(Date cearteTime)
    {
        this.cearteTime = cearteTime;
    }

    public Date getCearteTime()
    {
        return cearteTime;
    }
    public void setCraeteBy(String craeteBy)
    {
        this.createBy = craeteBy;
    }

    public String getCraeteBy()
    {
        return createBy;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("classificationName", getClassificationName())
            .append("cearteTime", getCearteTime())
            .append("craeteBy", getCraeteBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("orderNum", getOrderNum())
            .toString();
    }
}
