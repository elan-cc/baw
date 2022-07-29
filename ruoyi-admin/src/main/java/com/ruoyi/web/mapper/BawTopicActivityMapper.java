package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawTopicActivity;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

/**
 * 专题活动Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-06
 */
public interface BawTopicActivityMapper 
{
    /**
     * 查询专题活动
     * 
     * @param id 专题活动主键
     * @return 专题活动
     */
    public BawTopicActivity selectBawTopicActivityById(Integer id);

    /**
     * 查询专题活动
     *
     * @param id 专题活动主键
     * @return 专题活动
     */
    public ModelMap selectBawTopicActivityByIdForApi(Integer id);

    /**
     * 查询专题活动列表
     * 
     * @param bawTopicActivity 专题活动
     * @return 专题活动集合
     */
    public List<BawTopicActivity> selectBawTopicActivityList(BawTopicActivity bawTopicActivity);

    /**
     * 查询专题活动列表For API
     *
     * @return 专题活动集合
     */
    public List<ModelMap> selectBawTopicActivityListForApi(@Param("isDelete") Integer isDelete, @Param("isDisable") Integer isDisable, @Param("year") Integer year, @Param("month") Integer month, @Param("activityStatus") Integer activityStatus, @Param("activityType") Integer activityType, @Param("keywords") String keywords);

    /**
     * 查询专题活动年月列表For API
     *
     * @return 专题活动年月集合
     */
    public List<ModelMap> selectBawTopicActivityYearMonthListForApi();

    /**
     * 新增专题活动
     * 
     * @param bawTopicActivity 专题活动
     * @return 结果
     */
    public int insertBawTopicActivity(BawTopicActivity bawTopicActivity);

    /**
     * 修改专题活动
     * 
     * @param bawTopicActivity 专题活动
     * @return 结果
     */
    public int updateBawTopicActivity(BawTopicActivity bawTopicActivity);

    /**
     * 删除专题活动
     * 
     * @param id 专题活动主键
     * @return 结果
     */
    public int deleteBawTopicActivityById(Integer id);

    /**
     * 批量删除专题活动
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawTopicActivityByIds(String[] ids);
}
