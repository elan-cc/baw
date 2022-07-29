package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.StringJoiner;

/**
 * 经销商城市对象 baw_citys
 *
 * @author ruoyi
 * @date 2021-12-15
 */
public class BawCitys extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /** 省份 */
    @Excel(name = "省份编码")
    private String provinceCode;
    /** 省份 */
    @Excel(name = "省份")
    private String province;
    /** 城市 */
    @Excel(name = "城市编码")
    private String cityCode;
    /** 城市 */
    @Excel(name = "城市")
    private String city;
    /** 城市 */
    @Excel(name = "区县编码")
    private String countyCode;
    /** 城市 */
    @Excel(name = "区县")
    private String countyTown;
    /** 禁用 */
    @Excel(name = "禁用")
    private Integer isDisable;

    /** 删除 */
    private Integer isDelete;

    /** 添加用户 */
    private String addUser;

    /** 添加时间 */
    @Excel(name = "添加时间")
    private Integer addDate;
    /**城市名称拼音（用于小程序检索）*/
    private String cityPinYin;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
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
    public void setIsDisable(Integer isDisable)
    {
        this.isDisable = isDisable;
    }

    public Integer getIsDisable()
    {
        return isDisable;
    }
    public void setIsDelete(Integer isDelete)
    {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete()
    {
        return isDelete;
    }
    public void setAddUser(String addUser)
    {
        this.addUser = addUser;
    }

    public String getAddUser()
    {
        return addUser;
    }
    public void setAddDate(Integer addDate)
    {
        this.addDate = addDate;
    }

    public Integer getAddDate()
    {
        return addDate;
    }

    public String getCityPinYin() {
        return cityPinYin;
    }

    public void setCityPinYin(String cityPinYin) {
        this.cityPinYin = cityPinYin;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public String getCountyTown() {
        return countyTown;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public void setCountyTown(String countyTown) {
        this.countyTown = countyTown;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BawCitys.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("provinceCode='" + provinceCode + "'")
                .add("province='" + province + "'")
                .add("cityCode='" + cityCode + "'")
                .add("city='" + city + "'")
                .add("countyCode='" + countyCode + "'")
                .add("countyTown='" + countyTown + "'")
                .add("isDisable=" + isDisable)
                .add("isDelete=" + isDelete)
                .add("addUser='" + addUser + "'")
                .add("addDate=" + addDate)
                .add("cityPinYin='" + cityPinYin + "'")
                .toString();
    }
}
