package com.ruoyi.web.service;

import com.ruoyi.web.domain.BawBaseProductLine;

import java.util.List;

/**
 * 产品线信息Service接口
 *
 * @author ruoyi
 * @date 2022-01-20
 */
public interface IBawBaseProductLineService
{
    /**
     * 查询产品线信息
     *
     * @param id 产品线信息主键
     * @return 产品线信息
     */
    public BawBaseProductLine selectbawBaseProductLineById(Integer id);

    /**
     * 查询产品线信息列表
     *
     * @param bawBaseProductLine 产品线信息
     * @return 产品线信息集合
     */
    public List<BawBaseProductLine> selectbawBaseProductLineList(BawBaseProductLine bawBaseProductLine);

    /**
     * 新增产品线信息
     *
     * @param bawBaseProductLine 产品线信息
     * @return 结果
     */
    public int insertbawBaseProductLine(BawBaseProductLine bawBaseProductLine);

    /**
     * 修改产品线信息
     *
     * @param bawBaseProductLine 产品线信息
     * @return 结果
     */
    public int updatebawBaseProductLine(BawBaseProductLine bawBaseProductLine);

    /**
     * 批量删除产品线信息
     *
     * @param ids 需要删除的产品线信息主键集合
     * @return 结果
     */
    public int deletebawBaseProductLineByIds(Integer[] ids);

    /**
     * 删除车型信息信息
     *
     * @param id 产品线信息主键
     * @return 结果
     */
    public int deletebawBaseProductLineById(Integer id);
}
