package com.ruoyi.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawMeidaCenterMapper;
import com.ruoyi.web.domain.BawMeidaCenter;
import com.ruoyi.web.service.IBawMeidaCenterService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.ui.ModelMap;

/**
 * 媒体中心Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-06
 */
@Service
public class BawMeidaCenterServiceImpl implements IBawMeidaCenterService 
{
    @Autowired
    private BawMeidaCenterMapper bawMeidaCenterMapper;

    /**
     * 查询媒体中心
     * 
     * @param id 媒体中心主键
     * @return 媒体中心
     */
    @Override
    public BawMeidaCenter selectBawMeidaCenterById(Integer id)
    {
        return bawMeidaCenterMapper.selectBawMeidaCenterById(id);
    }

    /**
     * 查询媒体中心
     *
     * @param id 媒体中心主键
     * @return 媒体中心
     */
    @Override
    public ModelMap selectBawMeidaCenterByIdForApi(Integer id)
    {
        return bawMeidaCenterMapper.selectBawMeidaCenterByIdForApi(id);
    }

    /**
     * 查询媒体中心列表
     * 
     * @param bawMeidaCenter 媒体中心
     * @return 媒体中心
     */
    @Override
    public List<BawMeidaCenter> selectBawMeidaCenterList(BawMeidaCenter bawMeidaCenter)
    {
        return bawMeidaCenterMapper.selectBawMeidaCenterList(bawMeidaCenter);
    }

    /**
     * 查询媒体中心列表For API
     *
     * @return 媒体中心集合
     */
    @Override
    public List<ModelMap> selectBawMeidaCenterListForApi(Integer isDelete, Integer isDisable, Integer year, Integer month, Integer mediaType, String keywords) {
        return bawMeidaCenterMapper.selectBawMeidaCenterListForApi(isDelete, isDisable, year, month, mediaType, keywords);
    }

    /**
     * 查询媒体中心年月列表For API
     *
     * @return 媒体中心年月集合
     */
    @Override
    public List<ModelMap> selectBawMeidaCenterYearMonthListForApi() {
        return bawMeidaCenterMapper.selectBawMeidaCenterYearMonthListForApi();
    }

    /**
     * 新增媒体中心
     * 
     * @param bawMeidaCenter 媒体中心
     * @return 结果
     */
    @Override
    public int insertBawMeidaCenter(BawMeidaCenter bawMeidaCenter)
    {
        return bawMeidaCenterMapper.insertBawMeidaCenter(bawMeidaCenter);
    }

    /**
     * 修改媒体中心
     * 
     * @param bawMeidaCenter 媒体中心
     * @return 结果
     */
    @Override
    public int updateBawMeidaCenter(BawMeidaCenter bawMeidaCenter)
    {
        return bawMeidaCenterMapper.updateBawMeidaCenter(bawMeidaCenter);
    }

    /**
     * 批量删除媒体中心
     * 
     * @param ids 需要删除的媒体中心主键
     * @return 结果
     */
    @Override
    public int deleteBawMeidaCenterByIds(String ids)
    {
        return bawMeidaCenterMapper.deleteBawMeidaCenterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除媒体中心信息
     * 
     * @param id 媒体中心主键
     * @return 结果
     */
    @Override
    public int deleteBawMeidaCenterById(Integer id)
    {
        return bawMeidaCenterMapper.deleteBawMeidaCenterById(id);
    }
}
