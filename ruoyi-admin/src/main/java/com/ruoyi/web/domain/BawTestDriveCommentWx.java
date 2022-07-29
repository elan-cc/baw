package com.ruoyi.web.domain;

import com.ruoyi.common.annotation.Excel;

import java.util.Date;
import java.util.StringJoiner;

/**
 * @author ruoyi
 * @date 2022年03月09日12:54
 */
public class BawTestDriveCommentWx {

    private static final long serialVersionUID = 1L;


    /**
     *
     */
    private Integer id;

    /**
     * 预约试驾id
     */

    @Excel(name = "预约试驾id")
    private Integer bawTestDriveWxId;
    
    /**
     * 服务态度
     */
    private Integer serviceAttitude;
    
    /**
     * 桌面整洁
     */
    private Integer cleanDesktop;
    
    /**
     * 人员素质
     */
    private Integer qualityOfPersonnel;
    
    /**
     *反馈内容
     */
    @Excel(name = "反馈内容")
    private String feedbackContent;

    /**
     * 创建时间
     */
    @Excel(name = "创建时间")
    private Date createTime;

    /**
     * 创建人
     */
    @Excel(name = "创建人")
    private Integer createBy;

    /**
     * 删除
     */
    @Excel(name = "删除")
    private Integer deleted;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getBawTestDriveWxId() {
        return bawTestDriveWxId;
    }
    
    public void setBawTestDriveWxId(Integer bawTestDriveWxId) {
        this.bawTestDriveWxId = bawTestDriveWxId;
    }
    
    public Integer getServiceAttitude() {
        return serviceAttitude;
    }
    
    public void setServiceAttitude(Integer serviceAttitude) {
        this.serviceAttitude = serviceAttitude;
    }
    
    public Integer getCleanDesktop() {
        return cleanDesktop;
    }
    
    public void setCleanDesktop(Integer cleanDesktop) {
        this.cleanDesktop = cleanDesktop;
    }
    
    public Integer getQualityOfPersonnel() {
        return qualityOfPersonnel;
    }
    
    public void setQualityOfPersonnel(Integer qualityOfPersonnel) {
        this.qualityOfPersonnel = qualityOfPersonnel;
    }
    
    public String getFeedbackContent() {
        return feedbackContent;
    }
    
    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Integer getCreateBy() {
        return createBy;
    }
    
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }
    
    public Integer getDeleted() {
        return deleted;
    }
    
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
    
    @Override
    public String toString() {
        return new StringJoiner(", ", BawTestDriveCommentWx.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("bawTestDriveWxId=" + bawTestDriveWxId)
                .add("serviceAttitude=" + serviceAttitude)
                .add("cleanDesktop=" + cleanDesktop)
                .add("qualityOfPersonnel=" + qualityOfPersonnel)
                .add("feedbackContent='" + feedbackContent + "'")
                .add("createTime=" + createTime)
                .add("createBy='" + createBy + "'")
                .add("deleted=" + deleted)
                .toString();
    }
}
