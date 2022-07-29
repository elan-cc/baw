package com.ruoyi.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawActivityCommentLikeWxMapper;
import com.ruoyi.web.domain.BawActivityCommentLikeWx;
import com.ruoyi.web.service.IBawActivityCommentLikeWxService;
import com.ruoyi.common.core.text.Convert;

/**
 * 评论点赞记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-18
 */
@Service
public class BawActivityCommentLikeWxServiceImpl implements IBawActivityCommentLikeWxService 
{
    @Autowired
    private BawActivityCommentLikeWxMapper bawActivityCommentLikeWxMapper;

    /**
     * 查询评论点赞记录
     * 
     * @param id 评论点赞记录主键
     * @return 评论点赞记录
     */
    @Override
    public BawActivityCommentLikeWx selectBawActivityCommentLikeWxById(Integer id)
    {
        return bawActivityCommentLikeWxMapper.selectBawActivityCommentLikeWxById(id);
    }

    /**
     * 查询评论点赞记录列表
     * 
     * @param bawActivityCommentLikeWx 评论点赞记录
     * @return 评论点赞记录
     */
    @Override
    public List<BawActivityCommentLikeWx> selectBawActivityCommentLikeWxList(BawActivityCommentLikeWx bawActivityCommentLikeWx)
    {
        return bawActivityCommentLikeWxMapper.selectBawActivityCommentLikeWxList(bawActivityCommentLikeWx);
    }

    /**
     * 新增评论点赞记录
     * 
     * @param bawActivityCommentLikeWx 评论点赞记录
     * @return 结果
     */
    @Override
    public int insertBawActivityCommentLikeWx(BawActivityCommentLikeWx bawActivityCommentLikeWx)
    {
        return bawActivityCommentLikeWxMapper.insertBawActivityCommentLikeWx(bawActivityCommentLikeWx);
    }

    /**
     * 修改评论点赞记录
     * 
     * @param bawActivityCommentLikeWx 评论点赞记录
     * @return 结果
     */
    @Override
    public int updateBawActivityCommentLikeWx(BawActivityCommentLikeWx bawActivityCommentLikeWx)
    {
        return bawActivityCommentLikeWxMapper.updateBawActivityCommentLikeWx(bawActivityCommentLikeWx);
    }

    /**
     * 批量删除评论点赞记录
     * 
     * @param ids 需要删除的评论点赞记录主键
     * @return 结果
     */
    @Override
    public int deleteBawActivityCommentLikeWxByIds(String ids)
    {
        return bawActivityCommentLikeWxMapper.deleteBawActivityCommentLikeWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除评论点赞记录信息
     * 
     * @param id 评论点赞记录主键
     * @return 结果
     */
    @Override
    public int deleteBawActivityCommentLikeWxById(Integer id)
    {
        return bawActivityCommentLikeWxMapper.deleteBawActivityCommentLikeWxById(id);
    }
}
