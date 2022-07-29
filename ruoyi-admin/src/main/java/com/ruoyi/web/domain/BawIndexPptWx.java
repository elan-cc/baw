package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 首页轮播图对象 baw_index_ppt_wx
 * 
 * @author ruoyi
 * @date 2022-04-28
 */
public class BawIndexPptWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer id;

    /** 缩略图 */
    @Excel(name = "缩略图")
    private String picture;

    /** 车系编号(对应baw_base_car_series) */
    @Excel(name = "车系编号(对应baw_base_car_series)")
    private String carSeriesCod;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public String getPicture() 
    {
        return picture;
    }
    public void setCarSeriesCod(String carSeriesCod) 
    {
        this.carSeriesCod = carSeriesCod;
    }

    public String getCarSeriesCod() 
    {
        return carSeriesCod;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("picture", getPicture())
            .append("carSeriesCod", getCarSeriesCod())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
