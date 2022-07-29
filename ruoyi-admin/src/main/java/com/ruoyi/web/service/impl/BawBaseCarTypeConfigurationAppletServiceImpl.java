package com.ruoyi.web.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.domain.BawBaseCarTypeConfiguration;
import com.ruoyi.web.domain.BawBaseCarTypeConfigurationApplet;
import com.ruoyi.web.mapper.BawBaseCarTypeConfigurationAppletMapper;
import com.ruoyi.web.service.IBawBaseCarTypeConfigurationAppletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 车型信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-20
 */
@Service
public class BawBaseCarTypeConfigurationAppletServiceImpl implements IBawBaseCarTypeConfigurationAppletService
{
    @Autowired
    private BawBaseCarTypeConfigurationAppletMapper bawBaseCarTypeConfigurationAppletMapper;

    /**
     * 查询车型信息
     *
     * @param id 车型信息主键
     * @return 车型信息
     */
    @Override
    public BawBaseCarTypeConfigurationApplet selectBawBaseCarTypeConfigurationAppletById(Integer id)
    {
        return bawBaseCarTypeConfigurationAppletMapper.selectBawBaseCarTypeConfigurationAppletById(id);
    }

    /**
     * 查询车型信息列表
     *
     * @param bawBaseCarTypeConfigurationApplet 车型信息
     * @return 车型信息
     */
    @Override
    public List<BawBaseCarTypeConfigurationApplet> selectBawBaseCarTypeConfigurationAppletList(BawBaseCarTypeConfigurationApplet bawBaseCarTypeConfigurationApplet)
    {
        return bawBaseCarTypeConfigurationAppletMapper.selectBawBaseCarTypeConfigurationAppletList(bawBaseCarTypeConfigurationApplet);
    }

    /**
     * 新增车型信息
     *
     * @param bawBaseCarTypeConfiguration 车型信息
     * @return 结果
     */
    @Override
    public int insertBawBaseCarTypeConfigurationApplet(BawBaseCarTypeConfiguration bawBaseCarTypeConfiguration)
    {
        bawBaseCarTypeConfiguration.setCreateTime(DateUtils.getNowDate());
        return bawBaseCarTypeConfigurationAppletMapper.insertBawBaseCarTypeConfigurationApplet(bawBaseCarTypeConfiguration);
    }

    /**
     * 修改车型信息
     *
     * @param bawBaseCarTypeConfigurationApplet 车型信息
     * @return 结果
     */
    @Override
    public int updateBawBaseCarTypeConfigurationApplet(BawBaseCarTypeConfigurationApplet bawBaseCarTypeConfigurationApplet)
    {
        bawBaseCarTypeConfigurationApplet.setUpdateTime(DateUtils.getNowDate());
        return bawBaseCarTypeConfigurationAppletMapper.updateBawBaseCarTypeConfigurationApplet(bawBaseCarTypeConfigurationApplet);
    }

    /**
     * 批量删除车型信息
     *
     * @param ids 需要删除的车型信息主键
     * @return 结果
     */
    @Override
    public int deleteBawBaseCarTypeConfigurationAppletByIds(Integer[] ids)
    {
        return bawBaseCarTypeConfigurationAppletMapper.deleteBawBaseCarTypeConfigurationAppletByIds(ids);
    }

    /**
     * 删除车型信息信息
     *
     * @param id 车型信息主键
     * @return 结果
     */
    @Override
    public int deleteBawBaseCarTypeConfigurationAppletById(Integer id)
    {
        return bawBaseCarTypeConfigurationAppletMapper.deleteBawBaseCarTypeConfigurationAppletById(id);
    }
}
