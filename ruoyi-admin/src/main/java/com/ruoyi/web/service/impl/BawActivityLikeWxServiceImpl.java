package com.ruoyi.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawActivityLikeWxMapper;
import com.ruoyi.web.domain.BawActivityLikeWx;
import com.ruoyi.web.service.IBawActivityLikeWxService;
import com.ruoyi.common.core.text.Convert;

/**
 * 活动点赞记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-18
 */
@Service
public class BawActivityLikeWxServiceImpl implements IBawActivityLikeWxService 
{
    @Autowired
    private BawActivityLikeWxMapper bawActivityLikeWxMapper;

    /**
     * 查询活动点赞记录
     * 
     * @param id 活动点赞记录主键
     * @return 活动点赞记录
     */
    @Override
    public BawActivityLikeWx selectBawActivityLikeWxById(Integer id)
    {
        return bawActivityLikeWxMapper.selectBawActivityLikeWxById(id);
    }

    /**
     * 查询活动点赞记录列表
     * 
     * @param bawActivityLikeWx 活动点赞记录
     * @return 活动点赞记录
     */
    @Override
    public List<BawActivityLikeWx> selectBawActivityLikeWxList(BawActivityLikeWx bawActivityLikeWx)
    {
        return bawActivityLikeWxMapper.selectBawActivityLikeWxList(bawActivityLikeWx);
    }

    /**
     * 新增活动点赞记录
     * 
     * @param bawActivityLikeWx 活动点赞记录
     * @return 结果
     */
    @Override
    public int insertBawActivityLikeWx(BawActivityLikeWx bawActivityLikeWx)
    {
        return bawActivityLikeWxMapper.insertBawActivityLikeWx(bawActivityLikeWx);
    }

    /**
     * 修改活动点赞记录
     * 
     * @param bawActivityLikeWx 活动点赞记录
     * @return 结果
     */
    @Override
    public int updateBawActivityLikeWx(BawActivityLikeWx bawActivityLikeWx)
    {
        return bawActivityLikeWxMapper.updateBawActivityLikeWx(bawActivityLikeWx);
    }

    /**
     * 批量删除活动点赞记录
     * 
     * @param ids 需要删除的活动点赞记录主键
     * @return 结果
     */
    @Override
    public int deleteBawActivityLikeWxByIds(String ids)
    {
        return bawActivityLikeWxMapper.deleteBawActivityLikeWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除活动点赞记录信息
     * 
     * @param id 活动点赞记录主键
     * @return 结果
     */
    @Override
    public int deleteBawActivityLikeWxById(Integer id)
    {
        return bawActivityLikeWxMapper.deleteBawActivityLikeWxById(id);
    }
}
