package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawTestDrive;

/**
 * 预约试驾Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-10
 */
public interface BawTestDriveMapper 
{
    /**
     * 查询预约试驾
     * 
     * @param id 预约试驾主键
     * @return 预约试驾
     */
    public BawTestDrive selectBawTestDriveById(Integer id);

    /**
     * 查询预约试驾
     *
     * @param mobile 预约试驾主键
     * @return 预约试驾
     */
    public BawTestDrive selectBawTestDriveByMobile(String mobile);

    /**
     * 查询预约试驾列表
     * 
     * @param bawTestDrive 预约试驾
     * @return 预约试驾集合
     */
    public List<BawTestDrive> selectBawTestDriveList(BawTestDrive bawTestDrive);

    /**
     * 新增预约试驾
     * 
     * @param bawTestDrive 预约试驾
     * @return 结果
     */
    public int insertBawTestDrive(BawTestDrive bawTestDrive);

    /**
     * 修改预约试驾
     * 
     * @param bawTestDrive 预约试驾
     * @return 结果
     */
    public int updateBawTestDrive(BawTestDrive bawTestDrive);

    /**
     * 删除预约试驾
     * 
     * @param id 预约试驾主键
     * @return 结果
     */
    public int deleteBawTestDriveById(Integer id);

    /**
     * 批量删除预约试驾
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawTestDriveByIds(String[] ids);
}
