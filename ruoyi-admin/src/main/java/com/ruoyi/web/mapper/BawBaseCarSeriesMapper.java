package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawBaseCarSeries;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

/**
 * 车系信息Mapper接口
 *
 * @author ruoyi
 * @date 2022-01-20
 */
public interface BawBaseCarSeriesMapper
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
     * 删除车系信息
     *
     * @param id 车系信息主键
     * @return 结果
     */
    public int deleteBawBaseCarSeriesById(Integer id);

    /**
     * 批量删除车系信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawBaseCarSeriesByIds(Integer[] ids);


    public List<ModelMap> selectBawBaseCarSeriesByCode( );

    public String selectCarSeriesCodeByCode(String code);


}
