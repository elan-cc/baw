package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Map;
import java.util.StringJoiner;

/**
 * 车型配置参数对象 baw_base_car_config_param
 *
 * @author ruoyi
 * @date 2022-03-11
 */
public class BawBaseCarConfigParam extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Integer id;
    /** 车系编号(对应baw_base_car_series) */
    @Excel(name = "车系编号")
    private String carSeriesCode;
    /**车型编码*/
    @Excel(name = "车型编码")
    private String  carTypeCode;
    /** 车型配置编码(手动录入) */
    @Excel(name = "车型配置编码")
    private String carConfigCode;



    /** 参数名code，Java代码配置code */
    // @Excel(name = "参数名code，Java代码配置code")
    private String paramCode;

    /** 参数名，Java代码配置code，如车长，宽，高等 */
    @Excel(name = "配置名称")
    private String paramName;

    /** 参数值 */
    @Excel(name = "配置信息")
    private String paramValue;

    /** 车型分类id */
    // @Excel(name = "车型分类")
    private Integer configGroupId;
    /** 车型分类id */
     @Excel(name = "车型分类")
    private String configGroup;
    /** 排序 */
    @Excel(name = "排序")
    private Integer orderNum;



    public String getConfigGroup() {
        return configGroup;
    }

    public void setConfigGroup(String configGroup) {
        this.configGroup = configGroup;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

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

    public void setCarSeriesCode(String carSeriesCode)
    {
        this.carSeriesCode = carSeriesCode;
    }
    public String getCarSeriesCode()
    {
        return carSeriesCode;
    }

    public void setParamCode(String paramCode)
    {
        this.paramCode = paramCode;
    }
    public String getParamCode()
    {
        return paramCode;
    }

    public void setParamName(String paramName)
    {
        this.paramName = paramName;
    }
    public String getParamName()
    {
        return paramName;
    }

    public void setParamValue(String paramValue)
    {
        this.paramValue = paramValue;
    }
    public String getParamValue()
    {
        return paramValue;
    }

    public Integer getConfigGroupId() {
        return configGroupId;
    }

    public void setConfigGroupId(Integer configGroupId) {
        this.configGroupId = configGroupId;
    }

    public String getCarTypeCode() {
        return carTypeCode;
    }

    public void setCarTypeCode(String carTypeCode) {
        this.carTypeCode = carTypeCode;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "[", "]")
                .add("id=" + id)
                .add("carConfigCode='" + carConfigCode + "'")
                .add("carSeriesCode='" + carSeriesCode + "'")
                .add("paramCode='" + paramCode + "'")
                .add("paramName='" + paramName + "'")
                .add("paramValue='" + paramValue + "'")
                .add("configGroupId=" + configGroupId)
                .add("configGroup=" + configGroup)
                .add("orderNum=" + orderNum)
                .add("carTypeCode=" + carTypeCode)
                .toString();
    }
}
