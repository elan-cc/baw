package com.ruoyi.web.domain;

import java.util.Date;
import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 预约试驾微信端对象 baw_test_drive_wx
 *
 * @author ruoyi
 * @date 2022-03-10
 */
public class BawTestDriveWx extends BaseEntity
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
    @Excel(name = "性别",readConverterExp = "1=先生,2=女士")
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
    @Excel(name = "删除")
    private Integer isDelete;

    /** 添加时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date addDate;

    /** 预约时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "预约时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateCode;

    /** 来源 */
    @Excel(name = "来源")
    private String sourceCode;
    /** 用户id */
    private Integer userId;
    /** 预约状态（0：待试驾；1：待评论；2：已完成；3：已取消） */
    private Integer status;
    /** 预约类型（1：预约试驾；2：预约维修；3：预约保养） */
    private Integer appointmentType;


    public Integer getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(Integer appointmentType) {
        this.appointmentType = appointmentType;
    }

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
    public void setAddDate(Date addDate)
    {
        this.addDate = addDate;
    }

    public Date getAddDate()
    {
        return addDate;
    }
    public void setDateCode(Date dateCode)
    {
        this.dateCode = dateCode;
    }

    public Date getDateCode()
    {
        return dateCode;
    }
    public void setSourceCode(String sourceCode)
    {
        this.sourceCode = sourceCode;
    }

    public String getSourceCode()
    {
        return sourceCode;
    }
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BawTestDriveWx.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("realname='" + realname + "'")
                .add("mobile='" + mobile + "'")
                .add("sex=" + sex)
                .add("carSeries='" + carSeries + "'")
                .add("carSeriesCode='" + carSeriesCode + "'")
                .add("carType='" + carType + "'")
                .add("carTypeCode='" + carTypeCode + "'")
                .add("province='" + province + "'")
                .add("provinceCode='" + provinceCode + "'")
                .add("city='" + city + "'")
                .add("cityCode='" + cityCode + "'")
                .add("dealer='" + dealer + "'")
                .add("dealerCode='" + dealerCode + "'")
                .add("isDelete=" + isDelete)
                .add("addDate=" + addDate)
                .add("dateCode=" + dateCode)
                .add("sourceCode='" + sourceCode + "'")
                .add("userId=" + userId)
                .add("status=" + status)
                .add("appointmentType=" + appointmentType)
                .toString();
    }
}
