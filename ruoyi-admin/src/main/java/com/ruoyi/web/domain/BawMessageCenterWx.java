package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消息中心对象 baw_message_center_wx
 *
 * @author ruoyi
 * @date 2022-06-10
 */
public class BawMessageCenterWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;

    /** 提醒内容 */
    @Excel(name = "提醒内容")
    private String reminderContent;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 支付金额（单位为分） */
    @Excel(name = "支付金额", readConverterExp = "单=位为分")
    private Integer amount;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date craeteTime;
    /**用户id*/
    private Integer userId;
    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setReminderContent(String reminderContent)
    {
        this.reminderContent = reminderContent;
    }

    public String getReminderContent()
    {
        return reminderContent;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }

    public Integer getAmount()
    {
        return amount;
    }
    public void setCraeteTime(Date craeteTime)
    {
        this.craeteTime = craeteTime;
    }

    public Date getCraeteTime()
    {
        return craeteTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("reminderContent", getReminderContent())
            .append("name", getName())
            .append("amount", getAmount())
            .append("craeteTime", getCraeteTime())
            .append("userId", getUserId())
            .toString();
    }
}
