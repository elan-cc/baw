package com.ruoyi.web.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

public class BawBaseProductLine  extends BaseEntity {
    /**主键 */
    private Integer id;

    /** 产品线配置编码 */
    @Excel(name = "产品线配置编码")
    private String carCatagoriesCode;

    /** 产品线配置中文名称 */
    @Excel(name = "产品线配置中文名称")
    private String carCatagoriesEn;

    /** 产品线编码 */
    @Excel(name = "产品线编码")
    private String carCatagoriesCn;

    /** 车型编码 */
    @Excel(name = "车型编码")
    private String carBrandCode;

    /** 状态：0-禁用，1-启用 */
    @Excel(name = "状态：0-禁用，1-启用")
    private String isEnable;
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createTime;
    /** 创建人 */
    @Excel(name = "创建人")
    private String createBy;
    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updateTime;
    /** 更新人 */
    @Excel(name = "更新人")
    private String updateBy;

    public Integer getId() {
        return id;
    }

    public String getCarCatagoriesCode() {
        return carCatagoriesCode;
    }

    public String getCarCatagoriesEn() {
        return carCatagoriesEn;
    }

    public String getCarCatagoriesCn() {
        return carCatagoriesCn;
    }

    public String getCarBrandCode() {
        return carBrandCode;
    }

    public String getIsEnable() {
        return isEnable;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public String getUpdateBy() {
        return updateBy;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCarCatagoriesCode(String carCatagoriesCode) {
        this.carCatagoriesCode = carCatagoriesCode;
    }

    public void setCarCatagoriesEn(String carCatagoriesEn) {
        this.carCatagoriesEn = carCatagoriesEn;
    }

    public void setCarCatagoriesCn(String carCatagoriesCn) {
        this.carCatagoriesCn = carCatagoriesCn;
    }

    public void setCarBrandCode(String carBrandCode) {
        this.carBrandCode = carBrandCode;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "BawBaseProductLine{" +
                "id=" + id +
                ", carCatagoriesCode='" + carCatagoriesCode + '\'' +
                ", carCatagoriesEn='" + carCatagoriesEn + '\'' +
                ", carCatagoriesCn='" + carCatagoriesCn + '\'' +
                ", carBrandCode='" + carBrandCode + '\'' +
                ", isEnable='" + isEnable + '\'' +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", updateTime=" + updateTime +
                ", updateBy='" + updateBy + '\'' +
                '}';
    }
}
