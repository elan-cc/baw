package com.ruoyi.web.domain;

import io.swagger.models.auth.In;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品分类对象 baw_commodity_classify_wx
 *
 * @author ruoyi
 * @date 2022-05-11
 */
public class BawCommodityClassifyWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String name;

    /** 父节点id */
    @Excel(name = "父节点id")
    private Integer parentId;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Integer commodityCount;
    /** 商品数量 */
    @Excel(name = "商品数量")
    private Integer zero;

    public Integer getZero() {
        return zero;
    }

    public void setZero(Integer zero) {
        this.zero = zero;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setParentId(Integer parentId)
    {
        this.parentId = parentId;
    }

    public Integer getParentId()
    {
        return parentId;
    }
    public void setCommodityCount(Integer commodityCount)
    {
        this.commodityCount = commodityCount;
    }

    public Integer getCommodityCount()
    {
        return commodityCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("parentId", getParentId())
            .append("commodityCount", getCommodityCount())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("zero", getZero())
            .toString();
    }
}
