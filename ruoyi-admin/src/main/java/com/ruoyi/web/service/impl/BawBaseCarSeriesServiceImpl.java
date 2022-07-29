package com.ruoyi.web.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.domain.BawBaseCarSeries;
import com.ruoyi.web.mapper.BawBaseCarSeriesMapper;
import com.ruoyi.web.service.IBawBaseCarSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 车系信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-20
 */
@Service
public class BawBaseCarSeriesServiceImpl implements IBawBaseCarSeriesService
{
    @Autowired
    private BawBaseCarSeriesMapper bawBaseCarSeriesMapper;

    /**
     * 查询车系信息
     *
     * @param id 车系信息主键
     * @return 车系信息
     */
    @Override
    public BawBaseCarSeries selectBawBaseCarSeriesById(Integer id)
    {
        return bawBaseCarSeriesMapper.selectBawBaseCarSeriesById(id);
    }

    /**
     * 查询车系信息列表
     *
     * @param bawBaseCarSeries 车系信息
     * @return 车系信息
     */
    @Override
    public List<BawBaseCarSeries> selectBawBaseCarSeriesList(BawBaseCarSeries bawBaseCarSeries)
    {
        return bawBaseCarSeriesMapper.selectBawBaseCarSeriesList(bawBaseCarSeries);
    }

    /**
     * 新增车系信息
     *
     * @param bawBaseCarSeries 车系信息
     * @return 结果
     */
    @Override
    public int insertBawBaseCarSeries(BawBaseCarSeries bawBaseCarSeries)
    {
        bawBaseCarSeries.setCreateTime(DateUtils.getNowDate());
        return bawBaseCarSeriesMapper.insertBawBaseCarSeries(bawBaseCarSeries);
    }

    /**
     * 修改车系信息
     *
     * @param bawBaseCarSeries 车系信息
     * @return 结果
     */
    @Override
    public int updateBawBaseCarSeries(BawBaseCarSeries bawBaseCarSeries)
    {
        bawBaseCarSeries.setUpdateTime(DateUtils.getNowDate());
        return bawBaseCarSeriesMapper.updateBawBaseCarSeries(bawBaseCarSeries);
    }

    /**
     * 批量删除车系信息
     *
     * @param ids 需要删除的车系信息主键
     * @return 结果
     */
    @Override
    public int deleteBawBaseCarSeriesByIds(Integer[] ids)
    {
        return bawBaseCarSeriesMapper.deleteBawBaseCarSeriesByIds(ids);
    }

    /**
     * 删除车系信息信息
     *
     * @param id 车系信息主键
     * @return 结果
     */
    @Override
    public int deleteBawBaseCarSeriesById(Integer id)
    {
        return bawBaseCarSeriesMapper.deleteBawBaseCarSeriesById(id);
    }
}
