package com.ruoyi.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawBaseCarConfigGroupMapper;
import com.ruoyi.web.domain.BawBaseCarConfigGroup;
import com.ruoyi.web.service.IBawBaseCarConfigGroupService;
import com.ruoyi.common.core.text.Convert;

/**
 * 车辆配置分组Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-02
 */
@Service
public class BawBaseCarConfigGroupServiceImpl implements IBawBaseCarConfigGroupService 
{
    @Autowired
    private BawBaseCarConfigGroupMapper bawBaseCarConfigGroupMapper;

    /**
     * 查询车辆配置分组
     * 
     * @param id 车辆配置分组主键
     * @return 车辆配置分组
     */
    @Override
    public BawBaseCarConfigGroup selectBawBaseCarConfigGroupById(Integer id)
    {
        return bawBaseCarConfigGroupMapper.selectBawBaseCarConfigGroupById(id);
    }

    /**
     * 查询车辆配置分组列表
     * 
     * @param bawBaseCarConfigGroup 车辆配置分组
     * @return 车辆配置分组
     */
    @Override
    public List<BawBaseCarConfigGroup> selectBawBaseCarConfigGroupList(BawBaseCarConfigGroup bawBaseCarConfigGroup)
    {
        return bawBaseCarConfigGroupMapper.selectBawBaseCarConfigGroupList(bawBaseCarConfigGroup);
    }

    /**
     * 新增车辆配置分组
     * 
     * @param bawBaseCarConfigGroup 车辆配置分组
     * @return 结果
     */
    @Override
    public int insertBawBaseCarConfigGroup(BawBaseCarConfigGroup bawBaseCarConfigGroup)
    {
        return bawBaseCarConfigGroupMapper.insertBawBaseCarConfigGroup(bawBaseCarConfigGroup);
    }

    /**
     * 修改车辆配置分组
     * 
     * @param bawBaseCarConfigGroup 车辆配置分组
     * @return 结果
     */
    @Override
    public int updateBawBaseCarConfigGroup(BawBaseCarConfigGroup bawBaseCarConfigGroup)
    {
        return bawBaseCarConfigGroupMapper.updateBawBaseCarConfigGroup(bawBaseCarConfigGroup);
    }

    /**
     * 批量删除车辆配置分组
     * 
     * @param ids 需要删除的车辆配置分组主键
     * @return 结果
     */
    @Override
    public int deleteBawBaseCarConfigGroupByIds(String ids)
    {
        return bawBaseCarConfigGroupMapper.deleteBawBaseCarConfigGroupByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆配置分组信息
     * 
     * @param id 车辆配置分组主键
     * @return 结果
     */
    @Override
    public int deleteBawBaseCarConfigGroupById(Integer id)
    {
        return bawBaseCarConfigGroupMapper.deleteBawBaseCarConfigGroupById(id);
    }
}
