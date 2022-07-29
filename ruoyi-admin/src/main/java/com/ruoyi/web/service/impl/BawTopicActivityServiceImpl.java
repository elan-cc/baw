package com.ruoyi.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawTopicActivityMapper;
import com.ruoyi.web.domain.BawTopicActivity;
import com.ruoyi.web.service.IBawTopicActivityService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.ui.ModelMap;

/**
 * 专题活动Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-06
 */
@Service
public class BawTopicActivityServiceImpl implements IBawTopicActivityService 
{
    @Autowired
    private BawTopicActivityMapper bawTopicActivityMapper;

    /**
     * 查询专题活动
     * 
     * @param id 专题活动主键
     * @return 专题活动
     */
    @Override
    public BawTopicActivity selectBawTopicActivityById(Integer id)
    {
        return bawTopicActivityMapper.selectBawTopicActivityById(id);
    }

    /**
     * 查询专题活动
     *
     * @param id 专题活动主键
     * @return 专题活动
     */
    @Override
    public ModelMap selectBawTopicActivityByIdForApi(Integer id)
    {
        return bawTopicActivityMapper.selectBawTopicActivityByIdForApi(id);
    }

    /**
     * 查询专题活动列表
     * 
     * @param bawTopicActivity 专题活动
     * @return 专题活动
     */
    @Override
    public List<BawTopicActivity> selectBawTopicActivityList(BawTopicActivity bawTopicActivity)
    {
        return bawTopicActivityMapper.selectBawTopicActivityList(bawTopicActivity);
    }

    /**
     * 查询专题活动列表For API
     *
     * @return 专题活动集合
     */
    @Override
    public List<ModelMap> selectBawTopicActivityListForApi(Integer isDelete, Integer isDisable, Integer year, Integer month, Integer activityStatus, Integer activityType, String keywords) {
        return bawTopicActivityMapper.selectBawTopicActivityListForApi(isDelete, isDisable, year, month, activityStatus, activityType, keywords);
    }

    /**
     * 查询专题活动年月列表For API
     *
     * @return 专题活动年月集合
     */
    @Override
    public List<ModelMap> selectBawTopicActivityYearMonthListForApi() {
        return bawTopicActivityMapper.selectBawTopicActivityYearMonthListForApi();
    }

    /**
     * 新增专题活动
     * 
     * @param bawTopicActivity 专题活动
     * @return 结果
     */
    @Override
    public int insertBawTopicActivity(BawTopicActivity bawTopicActivity)
    {
        return bawTopicActivityMapper.insertBawTopicActivity(bawTopicActivity);
    }

    /**
     * 修改专题活动
     * 
     * @param bawTopicActivity 专题活动
     * @return 结果
     */
    @Override
    public int updateBawTopicActivity(BawTopicActivity bawTopicActivity)
    {
        return bawTopicActivityMapper.updateBawTopicActivity(bawTopicActivity);
    }

    /**
     * 批量删除专题活动
     * 
     * @param ids 需要删除的专题活动主键
     * @return 结果
     */
    @Override
    public int deleteBawTopicActivityByIds(String ids)
    {
        return bawTopicActivityMapper.deleteBawTopicActivityByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专题活动信息
     * 
     * @param id 专题活动主键
     * @return 结果
     */
    @Override
    public int deleteBawTopicActivityById(Integer id)
    {
        return bawTopicActivityMapper.deleteBawTopicActivityById(id);
    }
}
