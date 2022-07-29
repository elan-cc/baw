package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车辆品牌信息对象 baw_base_mainbrand
 *
 * @author ruoyi
 * @date 2022-01-20
 */
public class BawBaseMainbrand extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 品牌编码 */
    @Excel(name = "品牌编码")
    private String carBrandCode;

    /** 品牌英文名称 */
    @Excel(name = "品牌英文名称")
    private String carBrandEn;

    /** 品牌中文名称 */
    @Excel(name = "品牌中文名称")
    private String carBrandCn;

    /** 状态 */
    @Excel(name = "状态")
    private String isEnable;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setCarBrandCode(String carBrandCode)
    {
        this.carBrandCode = carBrandCode;
    }

    public String getCarBrandCode()
    {
        return carBrandCode;
    }
    public void setCarBrandEn(String carBrandEn)
    {
        this.carBrandEn = carBrandEn;
    }

    public String getCarBrandEn()
    {
        return carBrandEn;
    }
    public void setCarBrandCn(String carBrandCn)
    {
        this.carBrandCn = carBrandCn;
    }

    public String getCarBrandCn()
    {
        return carBrandCn;
    }
    public void setIsEnable(String isEnable)
    {
        this.isEnable = isEnable;
    }

    public String getIsEnable()
    {
        return isEnable;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carBrandCode", getCarBrandCode())
            .append("carBrandEn", getCarBrandEn())
            .append("carBrandCn", getCarBrandCn())
            .append("isEnable", getIsEnable())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
