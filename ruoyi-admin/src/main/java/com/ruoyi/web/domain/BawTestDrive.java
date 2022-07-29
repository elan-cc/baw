package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 预约试驾对象 baw_test_drive
 *
 * @author ruoyi
 * @date 2021-12-10
 */
public class BawTestDrive extends BaseEntity
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

    /** 车系 */
    @Excel(name = "车系")
    private String carSeries;

    /** 车系编码 */
    @Excel(name = "车系编码")
    private String carSeriesCode;

    /** 车型 */
    @Excel(name = "车型")
    private String carType;

    /** 车型编码 */
    @Excel(name = "车型编码")
    private String carTypeCode;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 省份编码 */
    @Excel(name = "省份编码")
    private String provinceCode;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 城市编码 */
    @Excel(name = "城市编码")
    private String cityCode;

    /** 经销商 */
    @Excel(name = "经销商")
    private String dealer;

    /** 经销商编码 */
    @Excel(name = "经销商编码")
    private String dealerCode;

    /** 删除 */
    private Integer isDelete;

    /** 添加时间 */
    private Integer addDate;

    /** 添加时间 */
    @Excel(name = "添加时间")
    private String addDateFormat;
    /** 接收时间 */
    @Excel(name = "添加时间")
    private Date receivingTime;

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
    public void setCarSeries(String carSeries)
    {
        this.carSeries = carSeries;
    }

    public String getCarSeries()
    {
        return carSeries;
    }
    public void setCarSeriesCode(String carSeriesCode)
    {
        this.carSeriesCode = carSeriesCode;
    }

    public String getCarSeriesCode()
    {
        return carSeriesCode;
    }
    public void setCarType(String carType)
    {
        this.carType = carType;
    }

    public String getCarType()
    {
        return carType;
    }
    public void setCarTypeCode(String carTypeCode)
    {
        this.carTypeCode = carTypeCode;
    }

    public String getCarTypeCode()
    {
        return carTypeCode;
    }
    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getProvince()
    {
        return province;
    }
    public void setProvinceCode(String provinceCode)
    {
        this.provinceCode = provinceCode;
    }

    public String getProvinceCode()
    {
        return provinceCode;
    }
    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCity()
    {
        return city;
    }
    public void setCityCode(String cityCode)
    {
        this.cityCode = cityCode;
    }

    public String getCityCode()
    {
        return cityCode;
    }
    public void setDealer(String dealer)
    {
        this.dealer = dealer;
    }

    public String getDealer()
    {
        return dealer;
    }
    public void setDealerCode(String dealerCode)
    {
        this.dealerCode = dealerCode;
    }

    public String getDealerCode()
    {
        return dealerCode;
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

    public Date getReceivingTime() {
        return receivingTime;
    }

    public void setReceivingTime(Date receivingTime) {
        this.receivingTime = receivingTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("realname", getRealname())
            .append("mobile", getMobile())
            .append("sex", getSex())
            .append("carType", getCarType())
            .append("carTypeCode", getCarTypeCode())
            .append("province", getProvince())
            .append("provinceCode", getProvinceCode())
            .append("city", getCity())
            .append("cityCode", getCityCode())
            .append("dealer", getDealer())
            .append("dealerCode", getDealerCode())
            .append("isDelete", getIsDelete())
            .append("addDate", getAddDate())
            .append("receivingTime", getReceivingTime())
            .toString();
    }
}
