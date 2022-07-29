package com.ruoyi.web.service;

import com.ruoyi.web.domain.BawBaseCarTypeConfiguration;

import java.util.List;

/**
 * 车型信息Service接口
 *
 * @author ruoyi
 * @date 2022-01-20
 */
public interface IBawBaseCarTypeConfigurationService
{
    /**
     * 查询车型信息
     *
     * @param id 车型信息主键
     * @return 车型信息
     */
    public BawBaseCarTypeConfiguration selectBawBaseCarTypeConfigurationById(Integer id);

    /**
     * 查询车型信息列表
     *
     * @param bawBaseCarTypeConfiguration 车型信息
     * @return 车型信息集合
     */
    public List<BawBaseCarTypeConfiguration> selectBawBaseCarTypeConfigurationList(BawBaseCarTypeConfiguration bawBaseCarTypeConfiguration);

    /**
     * 新增车型信息
     *
     * @param bawBaseCarTypeConfiguration 车型信息
     * @return 结果
     */
    public int insertBawBaseCarTypeConfiguration(BawBaseCarTypeConfiguration bawBaseCarTypeConfiguration);

    /**
     * 修改车型信息
     *
     * @param bawBaseCarTypeConfiguration 车型信息
     * @return 结果
     */
    public int updateBawBaseCarTypeConfiguration(BawBaseCarTypeConfiguration bawBaseCarTypeConfiguration);

    /**
     * 批量删除车型信息
     *
     * @param ids 需要删除的车型信息主键集合
     * @return 结果
     */
    public int deleteBawBaseCarTypeConfigurationByIds(Integer[] ids);

    /**
     * 删除车型信息信息
     *
     * @param id 车型信息主键
     * @return 结果
     */
    public int deleteBawBaseCarTypeConfigurationById(Integer id);
}
