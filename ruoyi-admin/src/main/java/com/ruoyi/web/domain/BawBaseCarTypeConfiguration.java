package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车型信息对象 baw_base_car_type_configuration
 *
 * @author ruoyi
 * @date 2022-01-20
 */
public class BawBaseCarTypeConfiguration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 车型配置编码 */
    @Excel(name = "车型配置编码")
    private String carConfigCode;

    /** 车型配置中文名称 */
    @Excel(name = "车型配置中文名称")
    private String carConfigCn;

    /** 车辆品牌编码 */
    @Excel(name = "车辆品牌编码")
    private String carBrandCode;

    /** 车型编码 */
    @Excel(name = "车型编码")
    private String carTypeCode;

    /** 状态：0-禁用，1-启用 */
    @Excel(name = "状态：0-禁用，1-启用")
    private String isEnable;

    /** 车身色编码 */
    @Excel(name = "车身色编码")
    private String carColorCode;

    /** 车身内饰色 */
    @Excel(name = "车身内饰色")
    private String carIncolorCode;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setCarConfigCode(String carConfigCode)
    {
        this.carConfigCode = carConfigCode;
    }

    public String getCarConfigCode()
    {
        return carConfigCode;
    }
    public void setCarConfigCn(String carConfigCn)
    {
        this.carConfigCn = carConfigCn;
    }

    public String getCarConfigCn()
    {
        return carConfigCn;
    }
    public void setCarBrandCode(String carBrandCode)
    {
        this.carBrandCode = carBrandCode;
    }

    public String getCarBrandCode()
    {
        return carBrandCode;
    }
    public void setCarTypeCode(String carTypeCode)
    {
        this.carTypeCode = carTypeCode;
    }

    public String getCarTypeCode()
    {
        return carTypeCode;
    }
    public void setIsEnable(String isEnable)
    {
        this.isEnable = isEnable;
    }

    public String getIsEnable()
    {
        return isEnable;
    }
    public void setCarColorCode(String carColorCode)
    {
        this.carColorCode = carColorCode;
    }

    public String getCarColorCode()
    {
        return carColorCode;
    }
    public void setCarIncolorCode(String carIncolorCode)
    {
        this.carIncolorCode = carIncolorCode;
    }

    public String getCarIncolorCode()
    {
        return carIncolorCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carConfigCode", getCarConfigCode())
            .append("carConfigCn", getCarConfigCn())
            .append("carBrandCode", getCarBrandCode())
            .append("carTypeCode", getCarTypeCode())
            .append("isEnable", getIsEnable())
            .append("carColorCode", getCarColorCode())
            .append("carIncolorCode", getCarIncolorCode())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
