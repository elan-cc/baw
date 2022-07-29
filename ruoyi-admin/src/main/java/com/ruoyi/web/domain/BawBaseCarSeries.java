package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车系信息对象 baw_base_car_series
 *
 * @author ruoyi
 * @date 2022-01-20
 */
public class BawBaseCarSeries extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 车系编码 */
    @Excel(name = "车系编码")
    private String carSeriesCode;

    /** 车系英文名称 */
    @Excel(name = "车系英文名称")
    private String carSeriesEn;

    /** 车系中文名称 */
    @Excel(name = "车系中文名称")
    private String carSeriesCn;

    /** 品牌编码 */
    @Excel(name = "品牌编码")
    private String carBrandCode;

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
    public void setCarSeriesCode(String carSeriesCode)
    {
        this.carSeriesCode = carSeriesCode;
    }

    public String getCarSeriesCode()
    {
        return carSeriesCode;
    }
    public void setCarSeriesEn(String carSeriesEn)
    {
        this.carSeriesEn = carSeriesEn;
    }

    public String getCarSeriesEn()
    {
        return carSeriesEn;
    }
    public void setCarSeriesCn(String carSeriesCn)
    {
        this.carSeriesCn = carSeriesCn;
    }

    public String getCarSeriesCn()
    {
        return carSeriesCn;
    }
    public void setCarBrandCode(String carBrandCode)
    {
        this.carBrandCode = carBrandCode;
    }

    public String getCarBrandCode()
    {
        return carBrandCode;
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
            .append("carSeriesCode", getCarSeriesCode())
            .append("carSeriesEn", getCarSeriesEn())
            .append("carSeriesCn", getCarSeriesCn())
            .append("carBrandCode", getCarBrandCode())
            .append("isEnable", getIsEnable())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
