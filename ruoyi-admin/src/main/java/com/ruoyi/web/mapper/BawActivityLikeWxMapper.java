package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawActivityLikeWx;
import org.apache.ibatis.annotations.Param;

/**
 * 活动点赞记录Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-18
 */
public interface BawActivityLikeWxMapper
{
    /**
     * 查询活动点赞记录
     *
     * @param id 活动点赞记录主键
     * @return 活动点赞记录
     */
    public BawActivityLikeWx selectBawActivityLikeWxById(Integer id);

    /**
     * 查询活动点赞记录列表
     *
     * @param bawActivityLikeWx 活动点赞记录
     * @return 活动点赞记录集合
     */
    public List<BawActivityLikeWx> selectBawActivityLikeWxList(BawActivityLikeWx bawActivityLikeWx);

    /**
     * 新增活动点赞记录
     *
     * @param bawActivityLikeWx 活动点赞记录
     * @return 结果
     */
    public int insertBawActivityLikeWx(BawActivityLikeWx bawActivityLikeWx);

    /**
     * 修改活动点赞记录
     *
     * @param bawActivityLikeWx 活动点赞记录
     * @return 结果
     */
    public int updateBawActivityLikeWx(BawActivityLikeWx bawActivityLikeWx);

    /**
     * 删除活动点赞记录
     *
     * @param id 活动点赞记录主键
     * @return 结果
     */
    public int deleteBawActivityLikeWxById(Integer id);

    /**
     * 批量删除活动点赞记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawActivityLikeWxByIds(String[] ids);
    
    /**
     * 查询数量
     * @param activityId 活动id
     * @param userId 用户id
     * @return
     */
    public int selectCountByActivityIdAndUserId(@Param("activityId") Integer activityId, @Param("userId") Integer userId);
}
