package com.ruoyi.web.service.impl;

import java.util.List;

import com.ruoyi.web.domain.BawProductManualLike;
import com.ruoyi.web.mapper.BawProductManualLikeMapper;
import com.ruoyi.web.service.IBawProductManualLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 产品手册点赞Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-11
 */
@Service
public class BawProductManualLikeServiceImpl implements IBawProductManualLikeService
{
    @Autowired
    private BawProductManualLikeMapper bawProductManualLikeMapper;

    /**
     * 查询产品手册点赞
     *
     * @param id 产品手册点赞主键
     * @return 产品手册点赞
     */
    @Override
    public BawProductManualLike selectBawProductManualLikeById(Integer id)
    {
        return bawProductManualLikeMapper.selectBawProductManualLikeById(id);
    }

    /**
     * 查询产品手册点赞列表
     *
     * @param bawProductManualLike 产品手册点赞
     * @return 产品手册点赞
     */
    @Override
    public List<BawProductManualLike> selectBawProductManualLikeList(BawProductManualLike bawProductManualLike)
    {
        return bawProductManualLikeMapper.selectBawProductManualLikeList(bawProductManualLike);
    }

    /**
     * 新增产品手册点赞
     *
     * @param bawProductManualLike 产品手册点赞
     * @return 结果
     */
    @Override
    public int insertBawProductManualLike(BawProductManualLike bawProductManualLike)
    {
        return bawProductManualLikeMapper.insertBawProductManualLike(bawProductManualLike);
    }

    /**
     * 修改产品手册点赞
     *
     * @param bawProductManualLike 产品手册点赞
     * @return 结果
     */
    @Override
    public int updateBawProductManualLike(BawProductManualLike bawProductManualLike)
    {
        return bawProductManualLikeMapper.updateBawProductManualLike(bawProductManualLike);
    }

    /**
     * 批量删除产品手册点赞
     *
     * @param ids 需要删除的产品手册点赞主键
     * @return 结果
     */
    @Override
    public int deleteBawProductManualLikeByIds(String ids)
    {
        return bawProductManualLikeMapper.deleteBawProductManualLikeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品手册点赞信息
     *
     * @param id 产品手册点赞主键
     * @return 结果
     */
    @Override
    public int deleteBawProductManualLikeById(Integer id)
    {
        return bawProductManualLikeMapper.deleteBawProductManualLikeById(id);
    }
}
