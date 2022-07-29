package com.ruoyi.web.service;

import java.util.List;
import com.ruoyi.web.domain.BawActivityCommentLikeWx;

/**
 * 评论点赞记录Service接口
 *
 * @author ruoyi
 * @date 2022-03-18
 */
public interface IBawActivityCommentLikeWxService
{
    /**
     * 查询评论点赞记录
     *
     * @param id 评论点赞记录主键
     * @return 评论点赞记录
     */
    public BawActivityCommentLikeWx selectBawActivityCommentLikeWxById(Integer id);

    /**
     * 查询评论点赞记录列表
     *
     * @param bawActivityCommentLikeWx 评论点赞记录
     * @return 评论点赞记录集合
     */
    public List<BawActivityCommentLikeWx> selectBawActivityCommentLikeWxList(BawActivityCommentLikeWx bawActivityCommentLikeWx);

    /**
     * 新增评论点赞记录
     *
     * @param bawActivityCommentLikeWx 评论点赞记录
     * @return 结果
     */
    public int insertBawActivityCommentLikeWx(BawActivityCommentLikeWx bawActivityCommentLikeWx);

    /**
     * 修改评论点赞记录
     *
     * @param bawActivityCommentLikeWx 评论点赞记录
     * @return 结果
     */
    public int updateBawActivityCommentLikeWx(BawActivityCommentLikeWx bawActivityCommentLikeWx);

    /**
     * 批量删除评论点赞记录
     *
     * @param ids 需要删除的评论点赞记录主键集合
     * @return 结果
     */
    public int deleteBawActivityCommentLikeWxByIds(String ids);

    /**
     * 删除评论点赞记录信息
     *
     * @param id 评论点赞记录主键
     * @return 结果
     */
    public int deleteBawActivityCommentLikeWxById(Integer id);
    
}
