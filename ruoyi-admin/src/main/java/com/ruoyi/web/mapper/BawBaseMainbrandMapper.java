package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.BawBaseMainbrand;

import java.util.List;

/**
 * 车辆品牌信息Mapper接口
 *
 * @author ruoyi
 * @date 2022-01-20
 */
public interface BawBaseMainbrandMapper
{
    /**
     * 查询车辆品牌信息
     *
     * @param id 车辆品牌信息主键
     * @return 车辆品牌信息
     */
    public BawBaseMainbrand selectBawBaseMainbrandById(Integer id);

    /**
     * 查询车辆品牌信息列表
     *
     * @param bawBaseMainbrand 车辆品牌信息
     * @return 车辆品牌信息集合
     */
    public List<BawBaseMainbrand> selectBawBaseMainbrandList(BawBaseMainbrand bawBaseMainbrand);

    /**
     * 新增车辆品牌信息
     *
     * @param bawBaseMainbrand 车辆品牌信息
     * @return 结果
     */
    public int insertBawBaseMainbrand(BawBaseMainbrand bawBaseMainbrand);

    /**
     * 修改车辆品牌信息
     *
     * @param bawBaseMainbrand 车辆品牌信息
     * @return 结果
     */
    public int updateBawBaseMainbrand(BawBaseMainbrand bawBaseMainbrand);

    /**
     * 删除车辆品牌信息
     *
     * @param id 车辆品牌信息主键
     * @return 结果
     */
    public int deleteBawBaseMainbrandById(Integer id);

    /**
     * 批量删除车辆品牌信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawBaseMainbrandByIds(Integer[] ids);
}
