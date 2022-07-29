package com.ruoyi.web.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.web.domain.BawActivityWx;

/**
 * 活动Service接口
 *
 * @author ruoyi
 * @date 2022-03-17
 */
public interface IBawActivityWxService
{
    /**
     * 查询活动
     *
     * @param id 活动主键
     * @return 活动
     */
    public BawActivityWx selectBawActivityWxById(Integer id);

    /**
     * 查询活动列表
     *
     * @param bawActivityWx 活动
     * @return 活动集合
     */
    public List<BawActivityWx> selectBawActivityWxList(BawActivityWx bawActivityWx);

    /**
     * 新增活动
     *
     * @param bawActivityWx 活动
     * @return 结果
     */
    public int insertBawActivityWx(BawActivityWx bawActivityWx);

    /**
     * 修改活动
     *
     * @param bawActivityWx 活动
     * @return 结果
     */
    public int updateBawActivityWx(BawActivityWx bawActivityWx);

    /**
     * 批量删除活动
     *
     * @param ids 需要删除的活动主键集合
     * @return 结果
     */
    public int deleteBawActivityWxByIds(String ids);

    /**
     * 删除活动信息
     *
     * @param id 活动主键
     * @return 结果
     */
    public int deleteBawActivityWxById(Integer id);

    /**
     * 通过城市code查询活动列表（根据创建时间排序）
     * @param cityCode 城市code
     * @param userId 用户id
     * @return 活动分页列表
     */
    public List<BawActivityWx> getActivityList(String cityCode, Integer userId,Integer activityType);

    /**
     * 通过活动id查询活动详情，参与人数（报名人头像，报名总数）
     * @param activityId 活动id
     * @param count 要查询的报名人头像数量
     * @param userId 用户id
     * @return 活动详情
     */
    public Map<String, Object> getActivityById(Integer activityId, Integer count, Integer userId);

    /**
     * 活动点赞/取消点赞
     * @param id 活动id
     * @param userId 用户id
     * @return
     */
    public int activityList(Integer id, Integer userId);

    /**
     * 我的活动
     * @param activityState 活动状态(1:进行中,2:已结束)
     * @param userId 用户id
     * @return
     */
    public List<BawActivityWx> myActivities(Integer activityState, Integer userId);
}
