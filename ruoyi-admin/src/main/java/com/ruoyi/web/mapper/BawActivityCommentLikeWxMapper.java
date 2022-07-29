package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawActivityCommentLikeWx;
import org.apache.ibatis.annotations.Param;

/**
 * 评论点赞记录Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-18
 */
public interface BawActivityCommentLikeWxMapper
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
     * 删除评论点赞记录
     *
     * @param id 评论点赞记录主键
     * @return 结果
     */
    public int deleteBawActivityCommentLikeWxById(Integer id);

    /**
     * 批量删除评论点赞记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawActivityCommentLikeWxByIds(String[] ids);
    
    /**
     * 通过评论id和用户id查看点在记录数量
     * @param commentId
     * @param userId
     * @return
     */
    public int selectCount(@Param("commentId") Integer commentId, @Param("userId") Integer userId);
}
