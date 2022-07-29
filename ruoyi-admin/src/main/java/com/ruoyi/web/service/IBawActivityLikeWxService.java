package com.ruoyi.web.service;

import java.util.List;
import com.ruoyi.web.domain.BawActivityLikeWx;

/**
 * 活动点赞记录Service接口
 * 
 * @author ruoyi
 * @date 2022-03-18
 */
public interface IBawActivityLikeWxService 
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
     * 批量删除活动点赞记录
     * 
     * @param ids 需要删除的活动点赞记录主键集合
     * @return 结果
     */
    public int deleteBawActivityLikeWxByIds(String ids);

    /**
     * 删除活动点赞记录信息
     * 
     * @param id 活动点赞记录主键
     * @return 结果
     */
    public int deleteBawActivityLikeWxById(Integer id);
}
