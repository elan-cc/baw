package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车型信息对象 baw_base_car_type
 *
 * @author ruoyi
 * @date 2022-01-20
 */
public class BawBaseCarType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 车型编码 */
    @Excel(name = "车型编码")
    private String carTypeCode;

    /** 车型英文名称 */
    @Excel(name = "车型英文名称")
    private String carTypeEn;

    /** 车型中文名称 */
    @Excel(name = "车型中文名称")
    private String carTypeCn;

    /** 车系编码 */
    @Excel(name = "车系编码")
    private String carSeriesCode;

    /** 状态：0-禁用，1-启用 */
    @Excel(name = "状态：0-禁用，1-启用")
    private String isEnable;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setCarTypeCode(String carTypeCode)
    {
        this.carTypeCode = carTypeCode;
    }

    public String getCarTypeCode()
    {
        return carTypeCode;
    }
    public void setCarTypeEn(String carTypeEn)
    {
        this.carTypeEn = carTypeEn;
    }

    public String getCarTypeEn()
    {
        return carTypeEn;
    }
    public void setCarTypeCn(String carTypeCn)
    {
        this.carTypeCn = carTypeCn;
    }

    public String getCarTypeCn()
    {
        return carTypeCn;
    }
    public void setCarSeriesCode(String carSeriesCode)
    {
        this.carSeriesCode = carSeriesCode;
    }

    public String getCarSeriesCode()
    {
        return carSeriesCode;
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
            .append("carTypeCode", getCarTypeCode())
            .append("carTypeEn", getCarTypeEn())
            .append("carTypeCn", getCarTypeCn())
            .append("carSeriesCode", getCarSeriesCode())
            .append("isEnable", getIsEnable())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
