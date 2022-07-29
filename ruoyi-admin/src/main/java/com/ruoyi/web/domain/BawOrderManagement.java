package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单管理对象 baw_order_management
 *
 * @author ruoyi
 * @date 2022-05-06
 */
public class BawOrderManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Integer id;
    /**订单编号*/
    @Excel(name = "订单编号")
    private String orderNum;
    /** 车系code */
    @Excel(name = "车系code")
    private String carSeriesCode;

    /** 车系名称 */
    @Excel(name = "车系名称")
    private String carSeriesName;

    /** 车型code */
    /*@Excel(name = "车型code")*/
    private String modelCode;

    /** 车型名称 */
    @Excel(name = "车型名称")
    private String modelName;

    /** 省code */
    /*@Excel(name = "省code")*/
    private String provinceCode;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 市code */
    /*@Excel(name = "市code")*/
    private String cityCode;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 区县code */
    /*@Excel(name = "区县code")*/
    private String countyCode;

    /** 区县 */
    @Excel(name = "区县")
    private String county;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 电话 */
    @Excel(name = "电话")
    private String telephone;

    /** 颜色 */
    @Excel(name = "颜色")
    private String colour;

    /** 用户id */
    /*@Excel(name = "用户id")*/
    private Integer userId;

    /** 订单状态（0：已完成；1：待付款；2：待收货；3：已取消;4：申请退款；5：已退款；6：退款失败） */
    @Excel(name = "订单状态", readConverterExp = "0=：已完成；1：待付款；2：待收货；3：已取消；4：申请退款；5：已退款；6：退款失败")
    private String orderStatus;

    /** 订单创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "订单创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatyTime;

    /** 订单支付时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "订单支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date paymentTime;

    /** 删除标志，0，未删除，1，已删除 */
    /*@Excel(name = "删除标志，0，未删除，1，已删除")*/
    private Integer deleted;
    /**价格（单位为分）*/
    private Integer price;
    /**厂家指导价格（单位为分）*/
    private Integer guidancePrice;
    /**展示图片路径*/
    private String img;
    /**微信预支付交易会话标识*/
    private String prepayId;
    /**数量*/
    private Integer quantity;
    /**收货地址*/
    private String receivingAddress;
    /**订单物流号*/
    private String orderLogistics;

    /**退款金额*/
    private Integer refundMoney;
    /**剩余金额*/
    private Integer remainingAmount;
    /**订单剩余支付时间*/
    private String timeLeft;
    /**经销商*/
    private String dealershopCode;

    /**证件类型*/
    private String documentType;

    /**身份证号*/
    private String idNum;
    /** 订单创建开始时间 */
    /*@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")*/
    @Excel(name = "订单创建开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createTimeMin;
    /** 订单创建时间 */
    /*@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")*/
    @Excel(name = "订单创建结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createTimeMax;

    public Integer getGuidancePrice() {
        return guidancePrice;
    }

    public void setGuidancePrice(Integer guidancePrice) {
        this.guidancePrice = guidancePrice;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setCarSeriesCode(String carSeriesCode)
    {
        this.carSeriesCode = carSeriesCode;
    }

    public String getCarSeriesCode()
    {
        return carSeriesCode;
    }
    public void setCarSeriesName(String carSeriesName)
    {
        this.carSeriesName = carSeriesName;
    }

    public String getCarSeriesName()
    {
        return carSeriesName;
    }
    public void setModelCode(String modelCode)
    {
        this.modelCode = modelCode;
    }

    public String getModelCode()
    {
        return modelCode;
    }
    public void setModelName(String modelName)
    {
        this.modelName = modelName;
    }

    public String getModelName()
    {
        return modelName;
    }
    public void setProvinceCode(String provinceCode)
    {
        this.provinceCode = provinceCode;
    }

    public String getProvinceCode()
    {
        return provinceCode;
    }
    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getProvince()
    {
        return province;
    }
    public void setCityCode(String cityCode)
    {
        this.cityCode = cityCode;
    }

    public String getCityCode()
    {
        return cityCode;
    }
    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCity()
    {
        return city;
    }
    public void setCountyCode(String countyCode)
    {
        this.countyCode = countyCode;
    }

    public String getCountyCode()
    {
        return countyCode;
    }
    public void setCounty(String county)
    {
        this.county = county;
    }

    public String getCounty()
    {
        return county;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getTelephone()
    {
        return telephone;
    }
    public void setColour(String colour)
    {
        this.colour = colour;
    }

    public String getColour()
    {
        return colour;
    }
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getUserId()
    {
        return userId;
    }
    public void setOrderStatus(String orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus()
    {
        return orderStatus;
    }
    public void setCreatyTime(Date creatyTime)
    {
        this.creatyTime = creatyTime;
    }

    public Date getCreatyTime()
    {
        return creatyTime;
    }
    public void setPaymentTime(Date paymentTime)
    {
        this.paymentTime = paymentTime;
    }

    public Date getPaymentTime()
    {
        return paymentTime;
    }
    public void setDeleted(Integer deleted)
    {
        this.deleted = deleted;
    }

    public Integer getDeleted()
    {
        return deleted;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getReceivingAddress() {
        return receivingAddress;
    }

    public void setReceivingAddress(String receivingAddress) {
        this.receivingAddress = receivingAddress;
    }

    public String getOrderLogistics() {
        return orderLogistics;
    }

    public void setOrderLogistics(String orderLogistics) {
        this.orderLogistics = orderLogistics;
    }

    public Integer getRefundMoney() {
        return refundMoney;
    }

    public void setRefundMoney(Integer refundMoney) {
        this.refundMoney = refundMoney;
    }

    public Integer getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Integer remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

    public String getDealershopCode() {
        return dealershopCode;
    }

    public void setDealershopCode(String dealershopCode) {
        this.dealershopCode = dealershopCode;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public Date getCreateTimeMin() {
        return createTimeMin;
    }

    public Date getCreateTimeMax() {
        return createTimeMax;
    }

    public void setCreateTimeMin(Date createTimeMin) {
        this.createTimeMin = createTimeMin;
    }

    public void setCreateTimeMax(Date createTimeMax) {
        this.createTimeMax = createTimeMax;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carSeriesCode", getCarSeriesCode())
            .append("carSeriesName", getCarSeriesName())
            .append("modelCode", getModelCode())
            .append("modelName", getModelName())
            .append("provinceCode", getProvinceCode())
            .append("province", getProvince())
            .append("cityCode", getCityCode())
            .append("city", getCity())
            .append("countyCode", getCountyCode())
            .append("county", getCounty())
            .append("name", getName())
            .append("telephone", getTelephone())
            .append("colour", getColour())
            .append("userId", getUserId())
            .append("orderStatus", getOrderStatus())
            .append("creatyTime", getCreatyTime())
            .append("paymentTime", getPaymentTime())
            .append("deleted", getDeleted())
            .append("price", getPrice())
            .append("guidancePrice", getGuidancePrice())
            .append("img", getImg())
            .append("orderNum", getOrderNum())
            .append("prepayId", getPrepayId())
            .append("quantity", getQuantity())
            .append("receivingAddress", getReceivingAddress())
            .append("orderLogistics", getOrderLogistics())
            .append("refundMoney", getRefundMoney())
            .append("remainingAmount", getRemainingAmount())
            .append("timeLeft", getTimeLeft())
            .append("dealershopCode", getDealershopCode())
            .append("documentType", getDocumentType())
            .append("idNum", getIdNum())
            .append("createTimeMin", getCreateTimeMin())
            .append("createTimeMax", getCreateTimeMax())
            .toString();
    }
}
