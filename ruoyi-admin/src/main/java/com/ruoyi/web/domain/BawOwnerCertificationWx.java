package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 车主认证对象 baw_owner_certification_wx
 *
 * @author ruoyi
 * @date 2022-06-13
 */
public class BawOwnerCertificationWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /** 底盘号 */
    @Excel(name = "底盘号")
    private String chassis;

    /** 用户id*/
    private  Integer userId;

    /** 创建时间*/
    private Date creatyTime;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setChassis(String chassis)
    {
        this.chassis = chassis;
    }

    public String getChassis()
    {
        return chassis;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreatyTime() {
        return creatyTime;
    }

    public void setCreatyTime(Date creatyTime) {
        this.creatyTime = creatyTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("chassis", getChassis())
            .append("userId", getUserId())
            .append("creatyTime", getCreatyTime())
            .toString();
    }
}
