package com.ruoyi.web.service;


import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.domain.BawTestDriveWx;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * 预约试驾微信端Service接口
 *
 * @author ruoyi
 * @date 2022-03-10
 */
public interface IBawTestDriveWxService
{
    /**
     * 查询预约试驾微信端
     *
     * @param id 预约试驾微信端主键
     * @return 预约试驾微信端
     */
    public BawTestDriveWx selectBawTestDriveWxById(Integer id);

    /**
     * 查询预约试驾微信端列表
     *
     * @param bawTestDriveWx 预约试驾微信端
     * @return 预约试驾微信端集合
     */
    public List<BawTestDriveWx> selectBawTestDriveWxList(BawTestDriveWx bawTestDriveWx);

    /**
     * 新增预约试驾微信端
     *
     * @param bawTestDriveWx 预约试驾微信端
     * @return 结果
     */
    public int insertBawTestDriveWx(BawTestDriveWx bawTestDriveWx);

    /**
     * 修改预约试驾微信端
     *
     * @param bawTestDriveWx 预约试驾微信端
     * @return 结果
     */
    public int updateBawTestDriveWx(BawTestDriveWx bawTestDriveWx);

    /**
     * 批量删除预约试驾微信端
     *
     * @param ids 需要删除的预约试驾微信端主键集合
     * @return 结果
     */
    public int deleteBawTestDriveWxByIds(String ids);

    /**
     * 删除预约试驾微信端信息
     *
     * @param id 预约试驾微信端主键
     * @return 结果
     */
    public int deleteBawTestDriveWxById(Integer id, Integer userId);

    /**
     * 查询预约试驾
     *
     * @param mobile 预约试驾主键
     * @return 预约试驾
     */
    public BawTestDriveWx selectBawTestDriveByMobile(Integer appointmentType, String mobile);
    
    /**
     * 我的-根据预约类型查询预约记录记录
     * @param appointmentType 预约类型（1：预约试驾；2：预约维修；3：预约保养）
     * @param userId 用户id
     * @return
     */
    public List<ModelMap> testDriveRecord(Integer appointmentType, Integer userId);
    
    /**
     * 取消预约试驾
     * @param id 预约试驾记录id
     * @return
     */
    public AjaxResult cancelTestDrive(Integer id);
}
