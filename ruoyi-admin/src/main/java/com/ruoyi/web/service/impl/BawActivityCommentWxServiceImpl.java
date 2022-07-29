package com.ruoyi.web.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.domain.BawActivityCommentLikeWx;
import com.ruoyi.web.domain.BawActivityCommentWx;
import com.ruoyi.web.domain.BawActivityWx;
import com.ruoyi.web.mapper.BawActivityCommentLikeWxMapper;
import com.ruoyi.web.mapper.BawActivityCommentWxMapper;
import com.ruoyi.web.mapper.BawActivityWxMapper;
import com.ruoyi.web.service.IBawActivityCommentLikeWxService;
import com.ruoyi.web.service.IBawActivityCommentWxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 活动评论Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-17
 */
@Service
public class BawActivityCommentWxServiceImpl implements IBawActivityCommentWxService
{
    @Autowired
    private BawActivityCommentWxMapper bawActivityCommentWxMapper;
    /**活动*/
    @Autowired
    private BawActivityWxMapper bawActivityWxMapper;
    /**评论点赞记录*/
    @Autowired
    private BawActivityCommentLikeWxMapper bawActivityCommentLikeWxMapper;

    /**
     * 查询活动评论
     *
     * @param id 活动评论主键
     * @return 活动评论
     */
    @Override
    public BawActivityCommentWx selectBawActivityCommentWxById(Integer id)
    {
        return bawActivityCommentWxMapper.selectBawActivityCommentWxById(id);
    }

    /**
     * 查询活动评论列表
     *
     * @param bawActivityCommentWx 活动评论
     * @return 活动评论
     */
    @Override
    public List<BawActivityCommentWx> selectBawActivityCommentWxList(BawActivityCommentWx bawActivityCommentWx)
    {
        return bawActivityCommentWxMapper.selectBawActivityCommentWxList(bawActivityCommentWx);
    }

    /**
     * 新增活动评论
     *
     * @param bawActivityCommentWx 活动评论
     * @return 结果
     */
    @Override
    public int insertBawActivityCommentWx(BawActivityCommentWx bawActivityCommentWx)
    {
        BawActivityWx bawActivityWx = bawActivityWxMapper.selectBawActivityWxById(bawActivityCommentWx.getActivityId());
        if (StringUtils.isNull(bawActivityWx) || 0 == bawActivityWx.getIsAble()){
            return 0;
        } else {
            int i = bawActivityCommentWxMapper.insertBawActivityCommentWx(bawActivityCommentWx);
            // 增加对应活动的评论数量
            bawActivityWxMapper.addContentCount(bawActivityCommentWx.getActivityId());
            if (bawActivityCommentWx.getParentId() != 0){
                // 回复评论，增加父级回复数量
                bawActivityCommentWxMapper.addReplyCount(bawActivityCommentWx.getParentId());
            }
            return i;
        }
    }

    /**
     * 修改活动评论
     *
     * @param bawActivityCommentWx 活动评论
     * @return 结果
     */
    @Override
    public int updateBawActivityCommentWx(BawActivityCommentWx bawActivityCommentWx)
    {
        return bawActivityCommentWxMapper.updateBawActivityCommentWx(bawActivityCommentWx);
    }

    /**
     * 批量删除活动评论
     *
     * @param ids 需要删除的活动评论主键
     * @return 结果
     */
    @Override
    public int deleteBawActivityCommentWxByIds(String ids)
    {
        return bawActivityCommentWxMapper.deleteBawActivityCommentWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除活动评论信息
     *
     * @param id 活动评论主键
     * @return 结果
     */
    @Override
    public int deleteBawActivityCommentWxById(Integer id)
    {
        return bawActivityCommentWxMapper.deleteBawActivityCommentWxById(id);
    }

    /**
     * 查询评论列表 和 父级评论回复条数（分页：父级根据点赞数排序，高在上，子级根据评论时间排序）
     * @param activityId 活动id
     * @param parentId 父节点id，传0则查询父级评论
     * @return
     */
    @Override
    public List<BawActivityCommentWx> getActivityComment(Integer activityId, Integer parentId, Integer userId) {
        List<BawActivityCommentWx> activityComments = bawActivityCommentWxMapper.getActivityComment(activityId, parentId);
        if (null != userId){
            // 查询该用户是否点赞
            for (BawActivityCommentWx commentWx : activityComments) {
                int i = bawActivityCommentLikeWxMapper.selectCount(commentWx.getId(), userId);
                if (0 == i){
                    commentWx.setIsLike(false);
                } else {
                    commentWx.setIsLike(true);
                }
            }
        }
        return activityComments;
    }

    /**
     * 评论点赞/取消点赞
     * @param id 评论id
     * @param userId 用户id
     * @return
     */
    @Override
    public int commentLike(Integer id, Integer userId) {
        // 查询是否已经点赞
        int i = 0;
        if (null != userId){
            BawActivityCommentLikeWx commentLikeWx = new BawActivityCommentLikeWx();
            commentLikeWx.setUserId(userId);
            commentLikeWx.setCommentId(id);
            List<BawActivityCommentLikeWx> commentLikeWxs = bawActivityCommentLikeWxMapper.selectBawActivityCommentLikeWxList(commentLikeWx);
            if (null != commentLikeWxs && commentLikeWxs.size() > 0) {
                // 取消点赞
                i = bawActivityCommentWxMapper.cancelCommentLike(id);
                bawActivityCommentLikeWxMapper.deleteBawActivityCommentLikeWxById(commentLikeWxs.get(0).getId());
                return i;
            }
        }
        // 点赞数+1
        i = bawActivityCommentWxMapper.commentLike(id);
        if (null != userId){
            // 新增评论点赞记录
            BawActivityCommentLikeWx likeWx = new BawActivityCommentLikeWx();
            likeWx.setCommentId(id);
            likeWx.setUserId(userId);
            likeWx.setLikeTime(new Date());
            bawActivityCommentLikeWxMapper.insertBawActivityCommentLikeWx(likeWx);
        }
        return i;
    }

    @Override
    public String updateReplay(Integer id) {
        BawActivityCommentWx commentWx = bawActivityCommentWxMapper.selectBawActivityCommentWxById(id);
        if (commentWx.getParentId() != 0){
            deleteBawActivityCommentWxById(commentWx.getId());
            bawActivityCommentWxMapper.updateReplay(commentWx.getParentId());
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

}
