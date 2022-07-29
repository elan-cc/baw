package com.ruoyi.web.service;

import com.ruoyi.web.domain.BawBaseCarTypeConfiguration;
import com.ruoyi.web.domain.BawBaseCarTypeConfigurationApplet;
import java.util.List;

/**
 * 车型信息Service接口
 *
 * @author ruoyi
 * @date 2022-01-20
 */
public interface IBawBaseCarTypeConfigurationAppletService
{
    /**
     * 查询车型信息
     *
     * @param id 车型信息主键
     * @return 车型信息
     */
    public BawBaseCarTypeConfigurationApplet selectBawBaseCarTypeConfigurationAppletById(Integer id);

    /**
     * 查询车型信息列表
     *
     * @param bawBaseCarTypeConfigurationApplet 车型信息
     * @return 车型信息集合
     */
    public List<BawBaseCarTypeConfigurationApplet> selectBawBaseCarTypeConfigurationAppletList(BawBaseCarTypeConfigurationApplet bawBaseCarTypeConfigurationApplet);

    /**
     * 新增车型信息
     *
     * @param bawBaseCarTypeConfiguration 车型信息
     * @return 结果
     */
    public int insertBawBaseCarTypeConfigurationApplet(BawBaseCarTypeConfiguration bawBaseCarTypeConfiguration);

    /**
     * 修改车型信息
     *
     * @param bawBaseCarTypeConfigurationApplet 车型信息
     * @return 结果
     */
    public int updateBawBaseCarTypeConfigurationApplet(BawBaseCarTypeConfigurationApplet bawBaseCarTypeConfigurationApplet);

    /**
     * 批量删除车型信息
     *
     * @param ids 需要删除的车型信息主键集合
     * @return 结果
     */
    public int deleteBawBaseCarTypeConfigurationAppletByIds(Integer[] ids);

    /**
     * 删除车型信息信息
     *
     * @param id 车型信息主键
     * @return 结果
     */
    public int deleteBawBaseCarTypeConfigurationAppletById(Integer id);
}
