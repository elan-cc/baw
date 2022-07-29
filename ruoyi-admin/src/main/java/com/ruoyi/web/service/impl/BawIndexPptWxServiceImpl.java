package com.ruoyi.web.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawIndexPptWxMapper;
import com.ruoyi.web.domain.BawIndexPptWx;
import com.ruoyi.web.service.IBawIndexPptWxService;
import com.ruoyi.common.core.text.Convert;

/**
 * 首页轮播图Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-28
 */
@Service
public class BawIndexPptWxServiceImpl implements IBawIndexPptWxService 
{
    @Autowired
    private BawIndexPptWxMapper bawIndexPptWxMapper;

    /**
     * 查询首页轮播图
     * 
     * @param id 首页轮播图主键
     * @return 首页轮播图
     */
    @Override
    public BawIndexPptWx selectBawIndexPptWxById(Integer id)
    {
        return bawIndexPptWxMapper.selectBawIndexPptWxById(id);
    }

    /**
     * 查询首页轮播图列表
     * 
     * @param bawIndexPptWx 首页轮播图
     * @return 首页轮播图
     */
    @Override
    public List<BawIndexPptWx> selectBawIndexPptWxList(BawIndexPptWx bawIndexPptWx)
    {
        return bawIndexPptWxMapper.selectBawIndexPptWxList(bawIndexPptWx);
    }

    /**
     * 新增首页轮播图
     * 
     * @param bawIndexPptWx 首页轮播图
     * @return 结果
     */
    @Override
    public int insertBawIndexPptWx(BawIndexPptWx bawIndexPptWx)
    {
        bawIndexPptWx.setCreateTime(DateUtils.getNowDate());
        return bawIndexPptWxMapper.insertBawIndexPptWx(bawIndexPptWx);
    }

    /**
     * 修改首页轮播图
     * 
     * @param bawIndexPptWx 首页轮播图
     * @return 结果
     */
    @Override
    public int updateBawIndexPptWx(BawIndexPptWx bawIndexPptWx)
    {
        bawIndexPptWx.setUpdateTime(DateUtils.getNowDate());
        return bawIndexPptWxMapper.updateBawIndexPptWx(bawIndexPptWx);
    }

    /**
     * 批量删除首页轮播图
     * 
     * @param ids 需要删除的首页轮播图主键
     * @return 结果
     */
    @Override
    public int deleteBawIndexPptWxByIds(String ids)
    {
        return bawIndexPptWxMapper.deleteBawIndexPptWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除首页轮播图信息
     * 
     * @param id 首页轮播图主键
     * @return 结果
     */
    @Override
    public int deleteBawIndexPptWxById(Integer id)
    {
        return bawIndexPptWxMapper.deleteBawIndexPptWxById(id);
    }
}
