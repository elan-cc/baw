package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.StringJoiner;

/**
 * 门店信息对象 baw_base_dealershop
 *
 * @author ruoyi
 * @date 2022-01-20
 */
public class BawBaseDealershop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** crm客户代码 */
    private String dlrCode;

    /** SAP客户代码 */
    private String kunnr;

    /** 客户简称 */
    private String buSort1;

    /** 客户全称 */
    @Excel(name = "客户全称")
    private String nameOrg1;

    /** 客户代码 */
    private String eikto;

    /** 经度 */
    @Excel(name = "经度")
    private String lng;

    /** 维度 */
    @Excel(name = "纬度")
    private String lat;

    /** 状态：0-禁用，1-启用 */
    private String isEnable;

    /** 上线状态 0-未上线，1-已上线 */
    private String onlineFlag;

    /** 建店状态 0-停业 1-营业 2-在建 3-取消 4-整改 */
    private String dlrStatus;

    /** 门店类别:A-加盟店,O-直营店 */
    private String zdlrType;

    /** 专营店类别:A-服务中心,D-交付中心,W-4S店 */
    private String orgType;

    /** 门店地址 */
    private String street;

    /** 邮编 */
    private String postCode1;

    /** 省代码 */
    private String region;

    /** 市代码 */
    private String cityc;

    /** 县代码 */
    private String counc;

    /** 大区 */
    private String bzirk;

    /** 销售办事处 */
    private String vkbur;

    /** 门店联系人 */
    private String adext;

    /** 门店联系人电话 */
    private String mobNumber;

    /** 门店热线电话 */
    private String telNumber;

    /** 门店邮箱 */
    private String smtpAddr;

    /** 门店传真 */
    private String faxNumber;
    /** 距离 */
    private Integer distance;

    /** 门店经营车系 */
    private String storeCar;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setDlrCode(String dlrCode)
    {
        this.dlrCode = dlrCode;
    }

    public String getDlrCode()
    {
        return dlrCode;
    }
    public void setKunnr(String kunnr)
    {
        this.kunnr = kunnr;
    }

    public String getKunnr()
    {
        return kunnr;
    }
    public void setBuSort1(String buSort1)
    {
        this.buSort1 = buSort1;
    }

    public String getBuSort1()
    {
        return buSort1;
    }
    public void setNameOrg1(String nameOrg1)
    {
        this.nameOrg1 = nameOrg1;
    }

    public String getNameOrg1()
    {
        return nameOrg1;
    }
    public void setEikto(String eikto)
    {
        this.eikto = eikto;
    }

    public String getEikto()
    {
        return eikto;
    }
    public void setLng(String lng)
    {
        this.lng = lng;
    }

    public String getLng()
    {
        return lng;
    }
    public void setLat(String lat)
    {
        this.lat = lat;
    }

    public String getLat()
    {
        return lat;
    }
    public void setIsEnable(String isEnable)
    {
        this.isEnable = isEnable;
    }

    public String getIsEnable()
    {
        return isEnable;
    }
    public void setOnlineFlag(String onlineFlag)
    {
        this.onlineFlag = onlineFlag;
    }

    public String getOnlineFlag()
    {
        return onlineFlag;
    }
    public void setDlrStatus(String dlrStatus)
    {
        this.dlrStatus = dlrStatus;
    }

    public String getDlrStatus()
    {
        return dlrStatus;
    }
    public void setZdlrType(String zdlrType)
    {
        this.zdlrType = zdlrType;
    }

    public String getZdlrType()
    {
        return zdlrType;
    }
    public void setOrgType(String orgType)
    {
        this.orgType = orgType;
    }

    public String getOrgType()
    {
        return orgType;
    }
    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getStreet()
    {
        return street;
    }
    public void setPostCode1(String postCode1)
    {
        this.postCode1 = postCode1;
    }

    public String getPostCode1()
    {
        return postCode1;
    }
    public void setRegion(String region)
    {
        this.region = region;
    }

    public String getRegion()
    {
        return region;
    }
    public void setCityc(String cityc)
    {
        this.cityc = cityc;
    }

    public String getCityc()
    {
        return cityc;
    }
    public void setCounc(String counc)
    {
        this.counc = counc;
    }

    public String getCounc()
    {
        return counc;
    }
    public void setBzirk(String bzirk)
    {
        this.bzirk = bzirk;
    }

    public String getBzirk()
    {
        return bzirk;
    }
    public void setVkbur(String vkbur)
    {
        this.vkbur = vkbur;
    }

    public String getVkbur()
    {
        return vkbur;
    }
    public void setAdext(String adext)
    {
        this.adext = adext;
    }

    public String getAdext()
    {
        return adext;
    }
    public void setMobNumber(String mobNumber)
    {
        this.mobNumber = mobNumber;
    }

    public String getMobNumber()
    {
        return mobNumber;
    }
    public void setTelNumber(String telNumber)
    {
        this.telNumber = telNumber;
    }

    public String getTelNumber()
    {
        return telNumber;
    }
    public void setSmtpAddr(String smtpAddr)
    {
        this.smtpAddr = smtpAddr;
    }

    public String getSmtpAddr()
    {
        return smtpAddr;
    }
    public void setFaxNumber(String faxNumber)
    {
        this.faxNumber = faxNumber;
    }

    public String getFaxNumber()
    {
        return faxNumber;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getStoreCar() {
        return storeCar;
    }

    public void setStoreCar(String storeCar) {
        this.storeCar = storeCar;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BawBaseDealershop.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("dlrCode='" + dlrCode + "'")
                .add("kunnr='" + kunnr + "'")
                .add("buSort1='" + buSort1 + "'")
                .add("nameOrg1='" + nameOrg1 + "'")
                .add("eikto='" + eikto + "'")
                .add("lng='" + lng + "'")
                .add("lat='" + lat + "'")
                .add("isEnable='" + isEnable + "'")
                .add("onlineFlag='" + onlineFlag + "'")
                .add("dlrStatus='" + dlrStatus + "'")
                .add("zdlrType='" + zdlrType + "'")
                .add("orgType='" + orgType + "'")
                .add("street='" + street + "'")
                .add("postCode1='" + postCode1 + "'")
                .add("region='" + region + "'")
                .add("cityc='" + cityc + "'")
                .add("counc='" + counc + "'")
                .add("bzirk='" + bzirk + "'")
                .add("vkbur='" + vkbur + "'")
                .add("adext='" + adext + "'")
                .add("mobNumber='" + mobNumber + "'")
                .add("telNumber='" + telNumber + "'")
                .add("smtpAddr='" + smtpAddr + "'")
                .add("faxNumber='" + faxNumber + "'")
                .add("distance=" + distance)
                .add("storeCar=" + storeCar)
                .toString();
    }
}
