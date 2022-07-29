package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品手册点赞对象 baw_product_manual_like
 *
 * @author ruoyi
 * @date 2022-05-11
 */
public class BawProductManualLike extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /** 用户id */
    @Excel(name = "用户id")
    private Integer userId;

    /** 手册id */
    @Excel(name = "手册id")
    private Integer manuaIdl;

    /** 点赞时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "点赞时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date likesTime;

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
    public void setManuaIdl(Integer manuaIdl)
    {
        this.manuaIdl = manuaIdl;
    }

    public Integer getManuaIdl()
    {
        return manuaIdl;
    }
    public void setLikesTime(Date likesTime)
    {
        this.likesTime = likesTime;
    }

    public Date getLikesTime()
    {
        return likesTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("manuaIdl", getManuaIdl())
            .append("likesTime", getLikesTime())
            .toString();
    }
}
