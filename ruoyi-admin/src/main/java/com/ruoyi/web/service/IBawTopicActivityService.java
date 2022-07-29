package com.ruoyi.web.service;

import java.util.List;
import com.ruoyi.web.domain.BawTopicActivity;
import org.springframework.ui.ModelMap;

/**
 * 专题活动Service接口
 * 
 * @author ruoyi
 * @date 2021-12-06
 */
public interface IBawTopicActivityService 
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
     * 查询活动列表列表For API
     *
     * @return 活动列表集合
     */
    public List<ModelMap> selectBawTopicActivityListForApi(Integer isDelete, Integer isDisable, Integer year, Integer month, Integer activityStatus, Integer activityType, String keywords);

    /**
     * 查询活动列表年月列表For API
     *
     * @return 活动列表年月集合
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
     * 批量删除专题活动
     * 
     * @param ids 需要删除的专题活动主键集合
     * @return 结果
     */
    public int deleteBawTopicActivityByIds(String ids);

    /**
     * 删除专题活动信息
     * 
     * @param id 专题活动主键
     * @return 结果
     */
    public int deleteBawTopicActivityById(Integer id);
}
