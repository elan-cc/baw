package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.StringJoiner;

/**
 * 活动报名对象 baw_activity_registration_wx
 *
 * @author ruoyi
 * @date 2022-03-17
 */
public class BawActivityRegistrationWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 邮箱 */
    private String email;

    /** 名 */
    @Excel(name = "姓名")
    private String name;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 城市编码 */
    @Excel(name = "城市编码")
    private String cityCode;

    /**城市名称*/
    @Excel(name = "城市名称")
    private String cityName;

    /** 经销商编码 */
    // @Excel(name = "经销商编码")
    private String dealerCode;

    /** 备注 */
    private String remarks;

    /** 活动id */
    // @Excel(name = "活动id")
    private Integer activityId;

    /** 用户id */
    private Integer userId;
    /**微信头像url*/
    private String avatar;
    /**微信名称*/
    // @Excel(name = "微信名称")
    private String wxName;
    
    
    /** 经销商 */
    @Excel(name = "经销商")
    private String dealerCodeName;
    
    /** 活动名称 */
    @Excel(name = "活动名称")
    private String activityName;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /**城市名称*/
    private String city;


    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setCityCode(String cityCode)
    {
        this.cityCode = cityCode;
    }

    public String getCityCode()
    {
        return cityCode;
    }
    public void setDealerCode(String dealerCode)
    {
        this.dealerCode = dealerCode;
    }

    public String getDealerCode()
    {
        return dealerCode;
    }
    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getRemarks()
    {
        return remarks;
    }
    public void setActivityId(Integer activityId)
    {
        this.activityId = activityId;
    }

    public Integer getActivityId()
    {
        return activityId;
    }
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getUserId()
    {
        return userId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }
    
    public String getDealerCodeName() {
        return dealerCodeName;
    }
    
    public void setDealerCodeName(String dealerCodeName) {
        this.dealerCodeName = dealerCodeName;
    }
    
    public String getActivityName() {
        return activityName;
    }
    
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
    
    @Override
    public String toString() {
        return new StringJoiner(", ", BawActivityRegistrationWx.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("email='" + email + "'")
                .add("name='" + name + "'")
                .add("phone='" + phone + "'")
                .add("cityCode='" + cityCode + "'")
                .add("cityName='" + cityName + "'")
                .add("dealerCode=" + dealerCode)
                .add("remarks='" + remarks + "'")
                .add("activityId=" + activityId)
                .add("userId=" + userId)
                .add("avatar='" + avatar + "'")
                .add("wxName='" + wxName + "'")
                .add("city='" + city + "'")
                .toString();
    }
}
