package com.ruoyi.web.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 微信用户对象 baw_user_wx
 *
 * @author ruoyi
 * @date 2022-03-12
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BawUserWx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID，唯一标识 */
    private Integer id;

    /** 用户昵称，不同用户昵称可以相同 */
    @Excel(name = "用户昵称")
    private String nickName;

    /** 用户头像（路径） */
    // @Excel(name = "用户头像")
    private String avatar;

    /** 用户微信名 */
    @Excel(name = "用户微信名")
    private String userName;

    /** 性别（0男 1女） */
    @Excel(name = "性别", readConverterExp = "0=男,1=女")
    private String gender;

    /** 密码 */
    // @Excel(name = "密码")
    private String password;

    /** 盐值 */
    // @Excel(name = "盐值")
    private String salt;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phoneNumber;

    /** 电子邮箱 */
    // @Excel(name = "电子邮箱")
    private String email;

    /** 注册来源IP地址 */
    // @Excel(name = "注册来源IP地址")
    private String regIp;

    /** 注册时间 */
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @Excel(name = "注册时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date regTime;

    /** 注册用客户端小程序的版本号 */
    // @Excel(name = "注册用客户端小程序的版本号")
    private String clientVer;

    /** 帐号状态（0正常 1停用，2注销） */
    // @Excel(name = "帐号状态", readConverterExp = "0=正常,1=停用，2注销")
    private String status;

    /** 删除标志，0，未删除，1，已删除 */
    // @Excel(name = "删除标志，0，未删除，1，已删除")
    private Integer deleted;

    /** 微信授权登录得到的openid */
    // @Excel(name = "微信授权登录得到的openid")
    private String wxOpenid;
    /**登录凭证*/
    private String token;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public String getNickName()
    {
        return nickName;
    }
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getGender()
    {
        return gender;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
    public void setSalt(String salt)
    {
        this.salt = salt;
    }

    public String getSalt()
    {
        return salt;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setRegIp(String regIp)
    {
        this.regIp = regIp;
    }

    public String getRegIp()
    {
        return regIp;
    }
    public void setRegTime(Date regTime)
    {
        this.regTime = regTime;
    }

    public Date getRegTime()
    {
        return regTime;
    }
    public void setClientVer(String clientVer)
    {
        this.clientVer = clientVer;
    }

    public String getClientVer()
    {
        return clientVer;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setDeleted(Integer deleted)
    {
        this.deleted = deleted;
    }

    public Integer getDeleted()
    {
        return deleted;
    }
    public void setWxOpenid(String wxOpenid)
    {
        this.wxOpenid = wxOpenid;
    }

    public String getWxOpenid()
    {
        return wxOpenid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("nickName", getNickName())
            .append("avatar", getAvatar())
            .append("userName", getUserName())
            .append("gender", getGender())
            .append("password", getPassword())
            .append("salt", getSalt())
            .append("phoneNumber", getPhoneNumber())
            .append("email", getEmail())
            .append("regIp", getRegIp())
            .append("regTime", getRegTime())
            .append("clientVer", getClientVer())
            .append("status", getStatus())
            .append("deleted", getDeleted())
            .append("wxOpenid", getWxOpenid())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("token", getToken())
            .toString();
    }
}
