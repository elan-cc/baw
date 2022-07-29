package com.ruoyi.web.service;

import java.util.List;
import com.ruoyi.web.domain.BawActivityCommentWx;

/**
 * 活动评论Service接口
 *
 * @author ruoyi
 * @date 2022-03-17
 */
public interface IBawActivityCommentWxService
{
    /**
     * 查询活动评论
     *
     * @param id 活动评论主键
     * @return 活动评论
     */
    public BawActivityCommentWx selectBawActivityCommentWxById(Integer id);

    /**
     * 查询活动评论列表
     *
     * @param bawActivityCommentWx 活动评论
     * @return 活动评论集合
     */
    public List<BawActivityCommentWx> selectBawActivityCommentWxList(BawActivityCommentWx bawActivityCommentWx);

    /**
     * 新增活动评论
     *
     * @param bawActivityCommentWx 活动评论
     * @return 结果
     */
    public int insertBawActivityCommentWx(BawActivityCommentWx bawActivityCommentWx);

    /**
     * 修改活动评论
     *
     * @param bawActivityCommentWx 活动评论
     * @return 结果
     */
    public int updateBawActivityCommentWx(BawActivityCommentWx bawActivityCommentWx);

    /**
     * 批量删除活动评论
     *
     * @param ids 需要删除的活动评论主键集合
     * @return 结果
     */
    public int deleteBawActivityCommentWxByIds(String ids);

    /**
     * 删除活动评论信息
     *
     * @param id 活动评论主键
     * @return 结果
     */
    public int deleteBawActivityCommentWxById(Integer id);

    /**
     * 查询评论列表 和 父级评论回复条数（分页：父级根据点赞数排序，高在上，子级根据评论时间排序）
     * @param activityId 活动id
     * @param parentId 父节点id，传0则查询父级评论
     * @param userId 用户id
     * @return
     */
    public List<BawActivityCommentWx> getActivityComment(Integer activityId, Integer parentId, Integer userId);

    /**
     * 评论点赞
     * @param id 评论id
     * @param userId 用户id
     * @return
     */
    public int commentLike(Integer id, Integer userId);

    String updateReplay(Integer id);
}
