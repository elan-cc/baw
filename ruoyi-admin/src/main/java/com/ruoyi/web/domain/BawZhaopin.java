package com.ruoyi.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 加入我们对象 baw_zhaopin
 * 
 * @author ruoyi
 * @date 2021-12-09
 */
public class BawZhaopin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /** 岗位名称 */
    @Excel(name = "岗位名称")
    private String jobName;

    /** 岗位类别 */
    @Excel(name = "岗位类型")
    private String jobType;

    /** 招聘人数 */
    private Integer zhaopinNum;

    /** 经验要求 */
    private String workYears;

    /** 所属公司 */
    @Excel(name = "所属公司")
    private String jobCompany;

    /** 工作地点 */
    @Excel(name = "工作地点")
    private String jobPlace;

    /** 学历要求 */
    private String jobEducation;

    /** 技能要求 */
    private String jobSkills;

    /** 岗位职责 */
    private String jobDuty;

    /** 任职资格 */
    private String jobRequire;

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
    public void setJobName(String jobName) 
    {
        this.jobName = jobName;
    }

    public String getJobName() 
    {
        return jobName;
    }
    public void setJobType(String jobType) 
    {
        this.jobType = jobType;
    }

    public String getJobType() 
    {
        return jobType;
    }
    public void setZhaopinNum(Integer zhaopinNum)
    {
        this.zhaopinNum = zhaopinNum;
    }

    public Integer getZhaopinNum()
    {
        return zhaopinNum;
    }
    public void setWorkYears(String workYears)
    {
        this.workYears = workYears;
    }

    public String getWorkYears() 
    {
        return workYears;
    }

    public String getJobCompany() {
        return jobCompany;
    }

    public void setJobCompany(String jobCompany) {
        this.jobCompany = jobCompany;
    }

    public void setJobPlace(String jobPlace) 
    {
        this.jobPlace = jobPlace;
    }

    public String getJobPlace() 
    {
        return jobPlace;
    }
    public void setJobEducation(String jobEducation) 
    {
        this.jobEducation = jobEducation;
    }

    public String getJobEducation() 
    {
        return jobEducation;
    }
    public void setJobSkills(String jobSkills)
    {
        this.jobSkills = jobSkills;
    }

    public String getJobSkills()
    {
        return jobSkills;
    }
    public void setJobDuty(String jobDuty) 
    {
        this.jobDuty = jobDuty;
    }

    public String getJobDuty() 
    {
        return jobDuty;
    }
    public void setJobRequire(String jobRequire) 
    {
        this.jobRequire = jobRequire;
    }

    public String getJobRequire() 
    {
        return jobRequire;
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
            .append("jobName", getJobName())
            .append("jobType", getJobType())
            .append("zhaopinNum", getZhaopinNum())
            .append("workYears", getWorkYears())
            .append("jobCompany", getJobCompany())
            .append("jobPlace", getJobPlace())
            .append("jobEducation", getJobEducation())
            .append("jobSkills", getJobSkills())
            .append("jobDuty", getJobDuty())
            .append("jobRequire", getJobRequire())
            .append("isDisable", getIsDisable())
            .append("isDelete", getIsDelete())
            .append("addUser", getAddUser())
            .append("addDate", getAddDate())
            .toString();
    }
}
