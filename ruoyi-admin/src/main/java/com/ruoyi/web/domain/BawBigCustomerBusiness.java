package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 大客户业务对象 baw_big_customer_business
 * 
 * @author ruoyi
 * @date 2021-12-10
 */
public class BawBigCustomerBusiness extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String realname;

    /** 手机 */
    @Excel(name = "手机")
    private String mobile;

    /** 性别 */
    @Excel(name = "性别")
    private Integer sex;

    /** 购车用途 */
    @Excel(name = "购车用途")
    private String buycarUse;

    /** 购车数量 */
    @Excel(name = "购车数量")
    private Integer buycarNum;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String companyName;

    /** 意向车系 */
    @Excel(name = "意向车系")
    private String carSeries;

    /** 意向车型 */
    @Excel(name = "意向车型")
    private String carType;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 删除 */
    private Integer isDelete;

    /** 添加时间 */
    private Integer addDate;

    /** 添加时间 */
    @Excel(name = "添加时间")
    private String addDateFormat;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setRealname(String realname) 
    {
        this.realname = realname;
    }

    public String getRealname() 
    {
        return realname;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setSex(Integer sex) 
    {
        this.sex = sex;
    }

    public Integer getSex() 
    {
        return sex;
    }
    public void setBuycarUse(String buycarUse) 
    {
        this.buycarUse = buycarUse;
    }

    public String getBuycarUse() 
    {
        return buycarUse;
    }
    public void setBuycarNum(Integer buycarNum) 
    {
        this.buycarNum = buycarNum;
    }

    public Integer getBuycarNum() 
    {
        return buycarNum;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setCarSeries(String carSeries) 
    {
        this.carSeries = carSeries;
    }

    public String getCarSeries() 
    {
        return carSeries;
    }
    public void setCarType(String carType) 
    {
        this.carType = carType;
    }

    public String getCarType() 
    {
        return carType;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setIsDelete(Integer isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete() 
    {
        return isDelete;
    }
    public void setAddDate(Integer addDate) 
    {
        this.addDate = addDate;
    }

    public Integer getAddDate() 
    {
        return addDate;
    }

    public void setAddDateFormat(String addDateFormat)
    {
        this.addDateFormat = addDateFormat;
    }

    public String getAddDateFormat()
    {
        return addDateFormat;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("realname", getRealname())
            .append("mobile", getMobile())
            .append("sex", getSex())
            .append("buycarUse", getBuycarUse())
            .append("buycarNum", getBuycarNum())
            .append("companyName", getCompanyName())
            .append("carSeries", getCarSeries())
            .append("carType", getCarType())
            .append("province", getProvince())
            .append("city", getCity())
            .append("isDelete", getIsDelete())
            .append("addDate", getAddDate())
            .toString();
    }
}
