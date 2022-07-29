package com.ruoyi.web.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.domain.BawBaseCarTypeConfiguration;
import com.ruoyi.web.mapper.BawBaseCarTypeConfigurationMapper;
import com.ruoyi.web.service.IBawBaseCarTypeConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 车型信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-20
 */
@Service
public class BawBaseCarTypeConfigurationServiceImpl implements IBawBaseCarTypeConfigurationService
{
    @Autowired
    private BawBaseCarTypeConfigurationMapper bawBaseCarTypeConfigurationMapper;

    /**
     * 查询车型信息
     *
     * @param id 车型信息主键
     * @return 车型信息
     */
    @Override
    public BawBaseCarTypeConfiguration selectBawBaseCarTypeConfigurationById(Integer id)
    {
        return bawBaseCarTypeConfigurationMapper.selectBawBaseCarTypeConfigurationById(id);
    }

    /**
     * 查询车型信息列表
     *
     * @param bawBaseCarTypeConfiguration 车型信息
     * @return 车型信息
     */
    @Override
    public List<BawBaseCarTypeConfiguration> selectBawBaseCarTypeConfigurationList(BawBaseCarTypeConfiguration bawBaseCarTypeConfiguration)
    {
        return bawBaseCarTypeConfigurationMapper.selectBawBaseCarTypeConfigurationList(bawBaseCarTypeConfiguration);
    }

    /**
     * 新增车型信息
     *
     * @param bawBaseCarTypeConfiguration 车型信息
     * @return 结果
     */
    @Override
    public int insertBawBaseCarTypeConfiguration(BawBaseCarTypeConfiguration bawBaseCarTypeConfiguration)
    {
        bawBaseCarTypeConfiguration.setCreateTime(DateUtils.getNowDate());
        return bawBaseCarTypeConfigurationMapper.insertBawBaseCarTypeConfiguration(bawBaseCarTypeConfiguration);
    }

    /**
     * 修改车型信息
     *
     * @param bawBaseCarTypeConfiguration 车型信息
     * @return 结果
     */
    @Override
    public int updateBawBaseCarTypeConfiguration(BawBaseCarTypeConfiguration bawBaseCarTypeConfiguration)
    {
        bawBaseCarTypeConfiguration.setUpdateTime(DateUtils.getNowDate());
        return bawBaseCarTypeConfigurationMapper.updateBawBaseCarTypeConfiguration(bawBaseCarTypeConfiguration);
    }

    /**
     * 批量删除车型信息
     *
     * @param ids 需要删除的车型信息主键
     * @return 结果
     */
    @Override
    public int deleteBawBaseCarTypeConfigurationByIds(Integer[] ids)
    {
        return bawBaseCarTypeConfigurationMapper.deleteBawBaseCarTypeConfigurationByIds(ids);
    }

    /**
     * 删除车型信息信息
     *
     * @param id 车型信息主键
     * @return 结果
     */
    @Override
    public int deleteBawBaseCarTypeConfigurationById(Integer id)
    {
        return bawBaseCarTypeConfigurationMapper.deleteBawBaseCarTypeConfigurationById(id);
    }
}
