package com.ruoyi.web.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.domain.BawBaseMainbrand;
import com.ruoyi.web.mapper.BawBaseMainbrandMapper;
import com.ruoyi.web.service.IBawBaseMainbrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 车辆品牌信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-20
 */
@Service
public class BawBaseMainbrandServiceImpl implements IBawBaseMainbrandService
{
    @Autowired
    private BawBaseMainbrandMapper bawBaseMainbrandMapper;

    /**
     * 查询车辆品牌信息
     *
     * @param id 车辆品牌信息主键
     * @return 车辆品牌信息
     */
    @Override
    public BawBaseMainbrand selectBawBaseMainbrandById(Integer id)
    {
        return bawBaseMainbrandMapper.selectBawBaseMainbrandById(id);
    }

    /**
     * 查询车辆品牌信息列表
     *
     * @param bawBaseMainbrand 车辆品牌信息
     * @return 车辆品牌信息
     */
    @Override
    public List<BawBaseMainbrand> selectBawBaseMainbrandList(BawBaseMainbrand bawBaseMainbrand)
    {
        return bawBaseMainbrandMapper.selectBawBaseMainbrandList(bawBaseMainbrand);
    }

    /**
     * 新增车辆品牌信息
     *
     * @param bawBaseMainbrand 车辆品牌信息
     * @return 结果
     */
    @Override
    public int insertBawBaseMainbrand(BawBaseMainbrand bawBaseMainbrand)
    {
        bawBaseMainbrand.setCreateTime(DateUtils.getNowDate());
        return bawBaseMainbrandMapper.insertBawBaseMainbrand(bawBaseMainbrand);
    }

    /**
     * 修改车辆品牌信息
     *
     * @param bawBaseMainbrand 车辆品牌信息
     * @return 结果
     */
    @Override
    public int updateBawBaseMainbrand(BawBaseMainbrand bawBaseMainbrand)
    {
        bawBaseMainbrand.setUpdateTime(DateUtils.getNowDate());
        return bawBaseMainbrandMapper.updateBawBaseMainbrand(bawBaseMainbrand);
    }

    /**
     * 批量删除车辆品牌信息
     *
     * @param ids 需要删除的车辆品牌信息主键
     * @return 结果
     */
    @Override
    public int deleteBawBaseMainbrandByIds(Integer[] ids)
    {
        return bawBaseMainbrandMapper.deleteBawBaseMainbrandByIds(ids);
    }

    /**
     * 删除车辆品牌信息信息
     *
     * @param id 车辆品牌信息主键
     * @return 结果
     */
    @Override
    public int deleteBawBaseMainbrandById(Integer id)
    {
        return bawBaseMainbrandMapper.deleteBawBaseMainbrandById(id);
    }
}
