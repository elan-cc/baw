package com.ruoyi.web.service.impl;

import java.util.List;

import com.ruoyi.web.domain.BawCommodityWx;
import com.ruoyi.web.mapper.BawCommodityWxMapper;
import com.ruoyi.web.service.IBawCommodityWxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-19
 */
@Service
public class BawCommodityWxServiceImpl implements IBawCommodityWxService
{
    @Autowired
    private BawCommodityWxMapper bawCommodityWxMapper;

    /**
     * 查询商品
     *
     * @param id 商品主键
     * @return 商品
     */
    @Override
    public BawCommodityWx selectBawCommodityWxById(Integer id)
    {
        return bawCommodityWxMapper.selectBawCommodityWxById(id);
    }

    /**
     * 查询商品列表
     *
     * @param bawCommodityWx 商品
     * @return 商品
     */
    @Override
    public List<BawCommodityWx> selectBawCommodityWxList(BawCommodityWx bawCommodityWx)
    {
        return bawCommodityWxMapper.selectBawCommodityWxList(bawCommodityWx);
    }

    /**
     * 新增商品
     *
     * @param bawCommodityWx 商品
     * @return 结果
     */
    @Override
    public int insertBawCommodityWx(BawCommodityWx bawCommodityWx)
    {
        return bawCommodityWxMapper.insertBawCommodityWx(bawCommodityWx);
    }

    /**
     * 修改商品
     *
     * @param bawCommodityWx 商品
     * @return 结果
     */
    @Override
    public int updateBawCommodityWx(BawCommodityWx bawCommodityWx)
    {
        return bawCommodityWxMapper.updateBawCommodityWx(bawCommodityWx);
    }

    /**
     * 批量删除商品
     *
     * @param ids 需要删除的商品主键
     * @return 结果
     */
    @Override
    public int deleteBawCommodityWxByIds(String ids)
    {
        return bawCommodityWxMapper.deleteBawCommodityWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品信息
     *
     * @param id 商品主键
     * @return 结果
     */
    @Override
    public int deleteBawCommodityWxById(Integer id)
    {
        return bawCommodityWxMapper.deleteBawCommodityWxById(id);
    }
}
