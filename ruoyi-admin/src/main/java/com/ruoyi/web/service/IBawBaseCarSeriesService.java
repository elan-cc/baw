package com.ruoyi.web.service;

import com.ruoyi.web.domain.BawBaseCarSeries;

import java.util.List;

/**
 * 车系信息Service接口
 *
 * @author ruoyi
 * @date 2022-01-20
 */
public interface IBawBaseCarSeriesService
{
    /**
     * 查询车系信息
     *
     * @param id 车系信息主键
     * @return 车系信息
     */
    public BawBaseCarSeries selectBawBaseCarSeriesById(Integer id);

    /**
     * 查询车系信息列表
     *
     * @param bawBaseCarSeries 车系信息
     * @return 车系信息集合
     */
    public List<BawBaseCarSeries> selectBawBaseCarSeriesList(BawBaseCarSeries bawBaseCarSeries);

    /**
     * 新增车系信息
     *
     * @param bawBaseCarSeries 车系信息
     * @return 结果
     */
    public int insertBawBaseCarSeries(BawBaseCarSeries bawBaseCarSeries);

    /**
     * 修改车系信息
     *
     * @param bawBaseCarSeries 车系信息
     * @return 结果
     */
    public int updateBawBaseCarSeries(BawBaseCarSeries bawBaseCarSeries);

    /**
     * 批量删除车系信息
     *
     * @param ids 需要删除的车系信息主键集合
     * @return 结果
     */
    public int deleteBawBaseCarSeriesByIds(Integer[] ids);

    /**
     * 删除车系信息信息
     *
     * @param id 车系信息主键
     * @return 结果
     */
    public int deleteBawBaseCarSeriesById(Integer id);
}
