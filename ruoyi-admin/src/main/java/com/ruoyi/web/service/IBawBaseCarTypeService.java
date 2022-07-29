package com.ruoyi.web.service;

import com.ruoyi.web.domain.BawBaseCarType;

import java.util.List;

/**
 * 车型信息Service接口
 *
 * @author ruoyi
 * @date 2022-01-20
 */
public interface IBawBaseCarTypeService
{
    /**
     * 查询车型信息
     *
     * @param id 车型信息主键
     * @return 车型信息
     */
    public BawBaseCarType selectBawBaseCarTypeById(Integer id);

    /**
     * 查询车型信息列表
     *
     * @param bawBaseCarType 车型信息
     * @return 车型信息集合
     */
    public List<BawBaseCarType> selectBawBaseCarTypeList(BawBaseCarType bawBaseCarType);

    /**
     * 新增车型信息
     *
     * @param bawBaseCarType 车型信息
     * @return 结果
     */
    public int insertBawBaseCarType(BawBaseCarType bawBaseCarType);

    /**
     * 修改车型信息
     *
     * @param bawBaseCarType 车型信息
     * @return 结果
     */
    public int updateBawBaseCarType(BawBaseCarType bawBaseCarType);

    /**
     * 批量删除车型信息
     *
     * @param ids 需要删除的车型信息主键集合
     * @return 结果
     */
    public int deleteBawBaseCarTypeByIds(Integer[] ids);

    /**
     * 删除车型信息信息
     *
     * @param id 车型信息主键
     * @return 结果
     */
    public int deleteBawBaseCarTypeById(Integer id);
}
