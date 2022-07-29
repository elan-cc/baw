package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 经销商加盟对象 baw_dealers_join
 * 
 * @author ruoyi
 * @date 2021-12-15
 */
public class BawDealersJoin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("province", getProvince())
            .append("city", getCity())
            .append("isDisable", getIsDisable())
            .append("isDelete", getIsDelete())
            .append("addUser", getAddUser())
            .append("addDate", getAddDate())
            .toString();
    }
}
