package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 首页模块1对象 baw_index_model1
 * 
 * @author ruoyi
 * @date 2021-12-09
 */
public class BawIndexModel1 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /** 中文标题 */
    @Excel(name = "中文标题")
    private String titleCh;

    /** 英文标题 */
    @Excel(name = "英文标题")
    private String titleEn;

    /** 图片 */
    @Excel(name = "图片")
    private String pic;

    /** 跳转链接 */
    @Excel(name = "跳转链接")
    private String link;

    /** 跳转链接打开方式 */
    private Integer linkTarget;

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
    public void setTitleCh(String titleCh) 
    {
        this.titleCh = titleCh;
    }

    public String getTitleCh() 
    {
        return titleCh;
    }
    public void setTitleEn(String titleEn) 
    {
        this.titleEn = titleEn;
    }

    public String getTitleEn() 
    {
        return titleEn;
    }
    public void setPic(String pic) 
    {
        this.pic = pic;
    }

    public String getPic() 
    {
        return pic;
    }
    public void setLink(String link) 
    {
        this.link = link;
    }

    public String getLink() 
    {
        return link;
    }
    public void setLinkTarget(Integer linkTarget) 
    {
        this.linkTarget = linkTarget;
    }

    public Integer getLinkTarget() 
    {
        return linkTarget;
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
            .append("titleCh", getTitleCh())
            .append("titleEn", getTitleEn())
            .append("pic", getPic())
            .append("link", getLink())
            .append("linkTarget", getLinkTarget())
            .append("isDisable", getIsDisable())
            .append("isDelete", getIsDelete())
            .append("addUser", getAddUser())
            .append("addDate", getAddDate())
            .toString();
    }
}
