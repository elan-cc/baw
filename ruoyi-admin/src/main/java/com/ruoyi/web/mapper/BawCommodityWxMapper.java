package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.BawCommodityWx;

import java.util.List;

/**
 * 商品Mapper接口
 *
 * @author ruoyi
 * @date 2022-05-19
 */
public interface BawCommodityWxMapper
{
    /**
     * 查询商品
     *
     * @param id 商品主键
     * @return 商品
     */
    public BawCommodityWx selectBawCommodityWxById(Integer id);

    /**
     * 查询商品列表
     *
     * @param bawCommodityWx 商品
     * @return 商品集合
     */
    public List<BawCommodityWx> selectBawCommodityWxList(BawCommodityWx bawCommodityWx);

    /**
     * 新增商品
     *
     * @param bawCommodityWx 商品
     * @return 结果
     */
    public int insertBawCommodityWx(BawCommodityWx bawCommodityWx);

    /**
     * 修改商品
     *
     * @param bawCommodityWx 商品
     * @return 结果
     */
    public int updateBawCommodityWx(BawCommodityWx bawCommodityWx);

    /**
     * 删除商品
     *
     * @param id 商品主键
     * @return 结果
     */
    public int deleteBawCommodityWxById(Integer id);

    /**
     * 批量删除商品
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawCommodityWxByIds(String[] ids);
}
