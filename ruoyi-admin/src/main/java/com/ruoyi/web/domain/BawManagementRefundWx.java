package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 退款单对象 baw_management_refund_wx
 *
 * @author ruoyi
 * @date 2022-05-20
 */
public class BawManagementRefundWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /** 订单id */
    @Excel(name = "订单id")
    private Integer managementId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String  managementNumber;

    /** 订单金额（单位为分） */
    @Excel(name = "订单金额", readConverterExp = "单位为分")
    private Integer managementMoney;

    /** 退款金额（单位为分） */
    @Excel(name = "退款金额", readConverterExp = "单=位为分")
    private Integer refundMoney;

    /** 货物状态（0:已收到货；1：未收到货） */
    @Excel(name = "货物状态", readConverterExp = "0=:已收到货；1：未收到货")
    private Integer cargoStatus;

    /** 退款原因（0：不想要了；1：订单信息拍错（颜色/尺码/规格等）;；2：地址/电话信息填写错误；3：未按照约定时间发货/缺货；4：拍多了；5：没用/少用优惠） */
    @Excel(name = "退款原因", readConverterExp = "1=：不想要了；2：订单信息拍错（颜色/尺码/规格等")
    private Integer refundReason;

    /** 描述 */
    @Excel(name = "描述")
    private String describe;

    /** 凭证图片url */
    @Excel(name = "凭证图片url")
    private String pictureUrl;

    /** 退款编号 */
    @Excel(name = "退款编号")
    private String refundNumber;

    /** 申请退款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "申请退款时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date applyRefundTime;

    /** 退款类型（1：全额退款，2：部分退款） */
    @Excel(name = "退款类型", readConverterExp = "1=：全额退款，2：部分退款")
    private Integer refundType;

    /** 退款状态（（1：申请退款；2：退款成功；3：退款失败；4：退款驳回）） */
    @Excel(name = "退款状态", readConverterExp = "1=：申请退款；2：退款成功；3：退款失败；4退款驳回")
    private Integer refundStatus;

    /** 用户id */
    @Excel(name = "用户id")
    private Integer userId;

    /** 审核人 */
    @Excel(name = "审核人")
    private String reviewer;


    /** 审核通过时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date approvalTime;

    /** 失败原因*/
    private String failureReason;
    /** 客户姓名*/
    private String name;
    /** 客户手机号*/
    private String telephone;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setManagementId(Integer managementId)
    {
        this.managementId = managementId;
    }

    public Integer getManagementId()
    {
        return managementId;
    }
    public void setManagementNumber(String managementNumber)
    {
        this.managementNumber = managementNumber;
    }

    public String getManagementNumber()
    {
        return managementNumber;
    }
    public void setManagementMoney(Integer managementMoney)
    {
        this.managementMoney = managementMoney;
    }

    public Integer getManagementMoney()
    {
        return managementMoney;
    }
    public void setRefundMoney(Integer refundMoney)
    {
        this.refundMoney = refundMoney;
    }

    public Integer getRefundMoney()
    {
        return refundMoney;
    }
    public void setCargoStatus(Integer cargoStatus)
    {
        this.cargoStatus = cargoStatus;
    }

    public Integer getCargoStatus()
    {
        return cargoStatus;
    }
    public void setRefundReason(Integer refundReason)
    {
        this.refundReason = refundReason;
    }

    public Integer getRefundReason()
    {
        return refundReason;
    }
    public void setDescribe(String describe)
    {
        this.describe = describe;
    }

    public String getDescribe()
    {
        return describe;
    }
    public void setPictureUrl(String pictureUrl)
    {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureUrl()
    {
        return pictureUrl;
    }
    public void setRefundNumber(String refundNumber)
    {
        this.refundNumber = refundNumber;
    }

    public String getRefundNumber()
    {
        return refundNumber;
    }
    public void setApplyRefundTime(Date applyRefundTime)
    {
        this.applyRefundTime = applyRefundTime;
    }

    public Date getApplyRefundTime()
    {
        return applyRefundTime;
    }
    public void setRefundType(Integer refundType)
    {
        this.refundType = refundType;
    }

    public Integer getRefundType()
    {
        return refundType;
    }
    public void setRefundStatus(Integer refundStatus)
    {
        this.refundStatus = refundStatus;
    }

    public Integer getRefundStatus()
    {
        return refundStatus;
    }
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getUserId()
    {
        return userId;
    }
    public void setReviewer(String reviewer)
    {
        this.reviewer = reviewer;
    }

    public String getReviewer()
    {
        return reviewer;
    }
    public void setApprovalTime(Date approvalTime)
    {
        this.approvalTime = approvalTime;
    }

    public Date getApprovalTime()
    {
        return approvalTime;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("managementId", getManagementId())
            .append("managementNumber", getManagementNumber())
            .append("managementMoney", getManagementMoney())
            .append("refundMoney", getRefundMoney())
            .append("cargoStatus", getCargoStatus())
            .append("refundReason", getRefundReason())
            .append("describe", getDescribe())
            .append("pictureUrl", getPictureUrl())
            .append("refundNumber", getRefundNumber())
            .append("applyRefundTime", getApplyRefundTime())
            .append("refundType", getRefundType())
            .append("refundStatus", getRefundStatus())
            .append("userId", getUserId())
            .append("reviewer", getReviewer())
            .append("approvalTime", getApprovalTime())
            .append("failureReason", getFailureReason())
            .append("name", getName())
            .append("telephone", getTelephone())
            .toString();
    }
}
