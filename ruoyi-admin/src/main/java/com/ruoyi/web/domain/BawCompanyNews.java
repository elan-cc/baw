package com.ruoyi.web.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 企业新闻对象 baw_media_coverage
 * 
 * @author ruoyi
 * @date 2021-12-06
 */
public class BawCompanyNews extends MyBaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 副标题 */
    private String subTitle;

    /** 简单描述 */
    private String description;

    /** 介绍图片 */
    @Excel(name = "介绍图片")
    private String pic;

    /** 内容 */
    private String content;

    /** 发布时间 */
    @Excel(name = "发布时间")
    private String fabuDate;

    /** 禁用 */
    @Excel(name = "禁用")
    private Integer isDisable;

    /** 删除 */
    private Integer isDelete;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

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
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setSubTitle(String subTitle) 
    {
        this.subTitle = subTitle;
    }

    public String getSubTitle() 
    {
        return subTitle;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setPic(String pic) 
    {
        this.pic = pic;
    }

    public String getPic() 
    {
        return pic;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setFabuDate(String fabuDate)
    {
        this.fabuDate = fabuDate;
    }

    public String getFabuDate()
    {
        return fabuDate;
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
    public void setSort(Integer sort) 
    {
        this.sort = sort;
    }

    public Integer getSort() 
    {
        return sort;
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
            .append("title", getTitle())
            .append("subTitle", getSubTitle())
            .append("description", getDescription())
            .append("pic", getPic())
            .append("content", getContent())
            .append("fabuDate", getFabuDate())
            .append("isDisable", getIsDisable())
            .append("isDelete", getIsDelete())
            .append("sort", getSort())
            .append("addUser", getAddUser())
            .append("addDate", getAddDate())
            .toString();
    }
}
