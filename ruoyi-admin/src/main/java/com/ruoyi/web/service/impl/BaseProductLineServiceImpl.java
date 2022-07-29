package com.ruoyi.web.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.domain.BawBaseProductLine;
import com.ruoyi.web.mapper.BaseProductLineMapper;
import com.ruoyi.web.service.IBawBaseProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 产品线信息Service业务层处理
 *
 * @author ruoyi
 * @date 2022-01-20
 */
@Service
public class BaseProductLineServiceImpl implements IBawBaseProductLineService
{
    @Autowired
    private BaseProductLineMapper baseProductLineMapper;

    /**
     * 查询产品线信息
     *
     * @param id 产品线信息主键
     * @return 产品线信息
     */
    @Override
    public BawBaseProductLine selectbawBaseProductLineById(Integer id)
    {
        return baseProductLineMapper.selectbawBaseProductLineById(id);
    }

    /**
     * 查询产品线信息列表
     *
     * @param bawBaseProductLine 产品线信息
     * @return 产品线信息
     */
    @Override
    public List<BawBaseProductLine> selectbawBaseProductLineList(BawBaseProductLine bawBaseProductLine)
    {
        return baseProductLineMapper.selectbawBaseProductLineList(bawBaseProductLine);
    }

    /**
     * 新增产品线信息
     *
     * @param bawBaseProductLine 产品线信息
     * @return 结果
     */
    @Override
    public int insertbawBaseProductLine(BawBaseProductLine bawBaseProductLine)
    {
        bawBaseProductLine.setCreateTime(DateUtils.getNowDate());
        return baseProductLineMapper.insertbawBaseProductLine(bawBaseProductLine);
    }

    /**
     * 修改产品线信息
     *
     * @param bawBaseProductLine 产品线信息
     * @return 结果
     */
    @Override
    public int updatebawBaseProductLine(BawBaseProductLine bawBaseProductLine)
    {
        bawBaseProductLine.setUpdateTime(DateUtils.getNowDate());
        return baseProductLineMapper.updatebawBaseProductLine(bawBaseProductLine);
    }

    /**
     * 批量删除产品线信息
     *
     * @param ids 需要删除的产品线信息主键
     * @return 结果
     */
    @Override
    public int deletebawBaseProductLineByIds(Integer[] ids)
    {
        return baseProductLineMapper.deletebawBaseProductLineByIds(ids);
    }

    /**
     * 删除产品线信息信息
     *
     * @param id 产品线信息主键
     * @return 结果
     */
    @Override
    public int deletebawBaseProductLineById(Integer id)
    {
        return baseProductLineMapper.deletebawBaseProductLineById(id);
    }
}
