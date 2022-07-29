package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * baw_information_enterprise对象 baw_information_enterprise
 * 
 * @author ruoyi
 * @date 2022-01-17
 */
public class BawInformationEnterprise extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 文件显示名称 */
    @Excel(name = "文件显示名称")
    private String showName;

    /** 搜索关键词 */
    @Excel(name = "搜索关键词")
    private String keyword;

    /** 文件说明 */
    @Excel(name = "文件说明")
    private String content;

    /** 文件完整路径 */
    @Excel(name = "文件完整路径")
    private String url;

    /** 显示时间 */
    @Excel(name = "显示时间")
    private String showTime;

    /** 排序：从小到大 */
    @Excel(name = "排序：从小到大")
    private Long sort;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setShowName(String showName) 
    {
        this.showName = showName;
    }

    public String getShowName() 
    {
        return showName;
    }
    public void setKeyword(String keyword) 
    {
        this.keyword = keyword;
    }

    public String getKeyword() 
    {
        return keyword;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setShowTime(String showTime) 
    {
        this.showTime = showTime;
    }

    public String getShowTime() 
    {
        return showTime;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("showName", getShowName())
            .append("keyword", getKeyword())
            .append("content", getContent())
            .append("url", getUrl())
            .append("showTime", getShowTime())
            .append("sort", getSort())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
