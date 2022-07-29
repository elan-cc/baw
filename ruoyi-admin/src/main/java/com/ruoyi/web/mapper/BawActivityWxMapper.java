package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawActivityWx;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

/**
 * 活动Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-17
 */
public interface BawActivityWxMapper
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
     * 删除活动
     *
     * @param id 活动主键
     * @return 结果
     */
    public int deleteBawActivityWxById(Integer id);

    /**
     * 批量删除活动
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawActivityWxByIds(String[] ids);

    /**
     * 通过城市code查询活动列表（根据创建时间排序）
     * @param cityCode 城市code
     * @return
     */
    public List<BawActivityWx> getActivityList(@Param("cityCode")String cityCode,@Param("activityType")Integer activityType);

    /**
     * 增加浏览量
     * @param activityId 活动id
     */
    public void addViewCount(@Param("activityId") Integer activityId);

    /**
     * 根据表名查询报名/评论活动
     * @param tableName 表名
     * @return
     */
    public List<ModelMap> selectBawActivityWxByName(@Param("tableName") String tableName);

    /**
     * 增加评论数量
     * @param activityId 活动id
     */
    public void addContentCount(@Param("activityId") Integer activityId);

    /**
     * 取消点赞
     * @param activityId 活动id
     */
    public int cancelActivityList(@Param("activityId") Integer activityId);

    /**
     * 点赞
     * @param activityId 活动id
     * @return
     */
    public int activityList(@Param("activityId") Integer activityId);

    /**
     * 查询活动
     *
     * @param id 活动主键
     * @return 活动
     */
    public BawActivityWx selectById(Integer id);

    /**
     * 我的活动
     * @param activityState 活动状态(1:进行中,2:已结束)
     * @param userId 用户id
     * @return
     */
    public List<BawActivityWx> myActivity(@Param("activityState") Integer activityState, @Param("userId") Integer userId);
}
