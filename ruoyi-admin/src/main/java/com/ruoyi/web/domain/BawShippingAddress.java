package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 收货地址对象 baw_shipping_address
 *
 * @author ruoyi
 * @date 2022-04-18
 */
public class BawShippingAddress extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 用户id */
    @Excel(name = "用户id")
    private Integer userId;

    /** 收货人 */
    @Excel(name = "收货人")
    private String receiver;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phone;

    /** 省份编码 */
    @Excel(name = "省份编码")
    private String provinceCode;

    /** 省份名称 */
    @Excel(name = "省份名称")
    private String provinceName;

    /** 城市编码 */
    @Excel(name = "城市编码")
    private String cityCode;

    /** 城市名称 */
    @Excel(name = "城市名称")
    private String cityName;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 标签 */
    @Excel(name = "标签")
    private String label;

    /** 是否默认(0：非默认；1：默认） */
    @Excel(name = "是否默认(0：非默认；1：默认）")
    private Integer isDefault;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getUserId()
    {
        return userId;
    }
    public void setReceiver(String receiver)
    {
        this.receiver = receiver;
    }

    public String getReceiver()
    {
        return receiver;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setProvinceCode(String provinceCode)
    {
        this.provinceCode = provinceCode;
    }

    public String getProvinceCode()
    {
        return provinceCode;
    }
    public void setProvinceName(String provinceName)
    {
        this.provinceName = provinceName;
    }

    public String getProvinceName()
    {
        return provinceName;
    }
    public void setCityCode(String cityCode)
    {
        this.cityCode = cityCode;
    }

    public String getCityCode()
    {
        return cityCode;
    }
    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public String getCityName()
    {
        return cityName;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setLabel(String label)
    {
        this.label = label;
    }

    public String getLabel()
    {
        return label;
    }
    public void setIsDefault(Integer isDefault)
    {
        this.isDefault = isDefault;
    }

    public Integer getIsDefault()
    {
        return isDefault;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("receiver", getReceiver())
            .append("phone", getPhone())
            .append("provinceCode", getProvinceCode())
            .append("provinceName", getProvinceName())
            .append("cityCode", getCityCode())
            .append("cityName", getCityName())
            .append("address", getAddress())
            .append("label", getLabel())
            .append("isDefault", getIsDefault())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
