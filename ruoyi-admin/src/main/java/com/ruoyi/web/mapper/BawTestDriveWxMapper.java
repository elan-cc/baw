package com.ruoyi.web.mapper;


import com.ruoyi.web.domain.BawTestDriveCommentWx;
import com.ruoyi.web.domain.BawTestDriveWx;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * 预约试驾微信端Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-10
 */
public interface BawTestDriveWxMapper
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
     * 删除预约试驾微信端
     *
     * @param id 预约试驾微信端主键
     * @return 结果
     */
    public int deleteBawTestDriveWxById(@Param("id") Integer id,@Param("userId") Integer userId);

    /**
     * 批量删除预约试驾微信端
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawTestDriveWxByIds(String[] ids);

    /**
     * 查询预约试驾
     *
     * @param mobile 预约试驾主键
     * @return 预约试驾
     */
    public BawTestDriveWx selectBawTestDriveWxByMobile(@Param("appointmentType") Integer appointmentType,@Param("mobile") String mobile);

    /**
     * 预约记录
     * @param appointmentType 预约类型（1：预约试驾；2：预约维修；3：预约保养）
     * @param userId 用户id
     * @return
     */
    public List<ModelMap> testDriveRecord(@Param("appointmentType") Integer appointmentType, @Param("userId") Integer userId);
}
