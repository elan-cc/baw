package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 首页KV对象 baw_index_kv
 * 
 * @author ruoyi
 * @date 2021-12-09
 */
public class BawIndexKv extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** KV类型 */
    private Integer kvType;

    /** KV文件 */
    @Excel(name = "KV文件")
    private String kvFile;

    /** KV跳转链接 */
    @Excel(name = "KV跳转链接")
    private String kvLink;

    /** KV跳转链接打开方式 */
    private Integer kvLinkTarget;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

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
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setKvType(Integer kvType) 
    {
        this.kvType = kvType;
    }

    public Integer getKvType() 
    {
        return kvType;
    }
    public void setKvFile(String kvFile) 
    {
        this.kvFile = kvFile;
    }

    public String getKvFile() 
    {
        return kvFile;
    }
    public void setKvLink(String kvLink) 
    {
        this.kvLink = kvLink;
    }

    public String getKvLink() 
    {
        return kvLink;
    }
    public void setKvLinkTarget(Integer kvLinkTarget) 
    {
        this.kvLinkTarget = kvLinkTarget;
    }

    public Integer getKvLinkTarget() 
    {
        return kvLinkTarget;
    }
    public void setSort(Integer sort) 
    {
        this.sort = sort;
    }

    public Integer getSort() 
    {
        return sort;
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
            .append("title", getTitle())
            .append("kvType", getKvType())
            .append("kvFile", getKvFile())
            .append("kvLink", getKvLink())
            .append("kvLinkTarget", getKvLinkTarget())
            .append("sort", getSort())
            .append("isDisable", getIsDisable())
            .append("isDelete", getIsDelete())
            .append("addUser", getAddUser())
            .append("addDate", getAddDate())
            .toString();
    }
}
