package com.ruoyi.web.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.domain.BawCommodityClassifyWx;
import com.ruoyi.web.mapper.BawCommodityClassifyWxMapper;
import com.ruoyi.web.service.IBawCommodityClassifyWxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 商品分类Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-11
 */
@Service
public class BawCommodityClassifyWxServiceImpl implements IBawCommodityClassifyWxService
{
    @Autowired
    private BawCommodityClassifyWxMapper bawCommodityClassifyWxMapper;

    /**
     * 查询商品分类
     *
     * @param id 商品分类主键
     * @return 商品分类
     */
    @Override
    public BawCommodityClassifyWx selectBawCommodityClassifyWxById(Integer id)
    {
        return bawCommodityClassifyWxMapper.selectBawCommodityClassifyWxById(id);
    }

    /**
     * 查询商品分类列表
     *
     * @param bawCommodityClassifyWx 商品分类
     * @return 商品分类
     */
    @Override
    public List<BawCommodityClassifyWx> selectBawCommodityClassifyWxList(BawCommodityClassifyWx bawCommodityClassifyWx)
    {
        return bawCommodityClassifyWxMapper.selectBawCommodityClassifyWxList(bawCommodityClassifyWx);
    }

    /**
     * 新增商品分类
     *
     * @param bawCommodityClassifyWx 商品分类
     * @return 结果
     */
    @Override
    public int insertBawCommodityClassifyWx(BawCommodityClassifyWx bawCommodityClassifyWx) {

        bawCommodityClassifyWx.setCreateTime(DateUtils.getNowDate());
        bawCommodityClassifyWx.setZero(1);
        int i = bawCommodityClassifyWxMapper.insertBawCommodityClassifyWx(bawCommodityClassifyWx);
        if (i == 0) {
            return 0;
        }
        if (bawCommodityClassifyWx.getParentId() == 0) {
            BawCommodityClassifyWx b = new BawCommodityClassifyWx();
            b.setParentId(bawCommodityClassifyWx.getId());
            b.setZero(0);
            return bawCommodityClassifyWxMapper.insertBawCommodityClassifyWx(b);
        }
        else {
            return 0;
        }
    }

    /**
     * 修改商品分类
     *
     * @param bawCommodityClassifyWx 商品分类
     * @return 结果
     */
    @Override
    public int updateBawCommodityClassifyWx(BawCommodityClassifyWx bawCommodityClassifyWx)
    {
        return bawCommodityClassifyWxMapper.updateBawCommodityClassifyWx(bawCommodityClassifyWx);
    }

    /**
     * 批量删除商品分类
     *
     * @param ids 需要删除的商品分类主键
     * @return 结果
     */
    @Override
    public int deleteBawCommodityClassifyWxByIds(String ids)
    {
        return bawCommodityClassifyWxMapper.deleteBawCommodityClassifyWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品分类信息
     *
     * @param id 商品分类主键
     * @return 结果
     */
    @Override
    public int deleteBawCommodityClassifyWxById(Long id)
    {
        return bawCommodityClassifyWxMapper.deleteBawCommodityClassifyWxById(id);
    }

    @Override
    public BawCommodityClassifyWx selectById(Integer id) {
        return bawCommodityClassifyWxMapper.selectBawCommodityClassifyWxById(id);
    }
}
