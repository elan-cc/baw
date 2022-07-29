package com.ruoyi.web.service;

import com.ruoyi.web.domain.BawBaseCarConfigParam;
import com.ruoyi.web.domain.BawCommodityClassifyWx;

import java.util.List;

/**
 * 商品分类Service接口
 *
 * @author ruoyi
 * @date 2022-05-11
 */
public interface IBawCommodityClassifyWxService
{
    /**
     * 查询商品分类
     *
     * @param id 商品分类主键
     * @return 商品分类
     */
    public BawCommodityClassifyWx selectBawCommodityClassifyWxById(Integer id);

    /**
     * 查询商品分类列表
     *
     * @param bawCommodityClassifyWx 商品分类
     * @return 商品分类集合
     */
    public List<BawCommodityClassifyWx> selectBawCommodityClassifyWxList(BawCommodityClassifyWx bawCommodityClassifyWx);

    /**
     * 新增商品分类
     *
     * @param bawCommodityClassifyWx 商品分类
     * @return 结果
     */
    public int insertBawCommodityClassifyWx(BawCommodityClassifyWx bawCommodityClassifyWx);

    /**
     * 修改商品分类
     *
     * @param bawCommodityClassifyWx 商品分类
     * @return 结果
     */
    public int updateBawCommodityClassifyWx(BawCommodityClassifyWx bawCommodityClassifyWx);

    /**
     * 批量删除商品分类
     *
     * @param ids 需要删除的商品分类主键集合
     * @return 结果
     */
    public int deleteBawCommodityClassifyWxByIds(String ids);

    /**
     * 删除商品分类信息
     *
     * @param id 商品分类主键
     * @return 结果
     */
    public int deleteBawCommodityClassifyWxById(Long id);


    public BawCommodityClassifyWx selectById(Integer id);

}
