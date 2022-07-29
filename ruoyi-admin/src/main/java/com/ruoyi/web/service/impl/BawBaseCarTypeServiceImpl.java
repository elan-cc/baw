package com.ruoyi.web.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.domain.BawBaseCarType;
import com.ruoyi.web.mapper.BawBaseCarTypeMapper;
import com.ruoyi.web.service.IBawBaseCarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 车型信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-20
 */
@Service
public class BawBaseCarTypeServiceImpl implements IBawBaseCarTypeService
{
    @Autowired
    private BawBaseCarTypeMapper bawBaseCarTypeMapper;

    /**
     * 查询车型信息
     *
     * @param id 车型信息主键
     * @return 车型信息
     */
    @Override
    public BawBaseCarType selectBawBaseCarTypeById(Integer id)
    {
        return bawBaseCarTypeMapper.selectBawBaseCarTypeById(id);
    }

    /**
     * 查询车型信息列表
     *
     * @param bawBaseCarType 车型信息
     * @return 车型信息
     */
    @Override
    public List<BawBaseCarType> selectBawBaseCarTypeList(BawBaseCarType bawBaseCarType)
    {
        return bawBaseCarTypeMapper.selectBawBaseCarTypeList(bawBaseCarType);
    }

    /**
     * 新增车型信息
     *
     * @param bawBaseCarType 车型信息
     * @return 结果
     */
    @Override
    public int insertBawBaseCarType(BawBaseCarType bawBaseCarType)
    {
        bawBaseCarType.setCreateTime(DateUtils.getNowDate());
        return bawBaseCarTypeMapper.insertBawBaseCarType(bawBaseCarType);
    }

    /**
     * 修改车型信息
     *
     * @param bawBaseCarType 车型信息
     * @return 结果
     */
    @Override
    public int updateBawBaseCarType(BawBaseCarType bawBaseCarType)
    {
        bawBaseCarType.setUpdateTime(DateUtils.getNowDate());
        return bawBaseCarTypeMapper.updateBawBaseCarType(bawBaseCarType);
    }

    /**
     * 批量删除车型信息
     *
     * @param ids 需要删除的车型信息主键
     * @return 结果
     */
    @Override
    public int deleteBawBaseCarTypeByIds(Integer[] ids)
    {
        return bawBaseCarTypeMapper.deleteBawBaseCarTypeByIds(ids);
    }

    /**
     * 删除车型信息信息
     *
     * @param id 车型信息主键
     * @return 结果
     */
    @Override
    public int deleteBawBaseCarTypeById(Integer id)
    {
        return bawBaseCarTypeMapper.deleteBawBaseCarTypeById(id);
    }
}
