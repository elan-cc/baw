package com.ruoyi.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawMediaCoverageMapper;
import com.ruoyi.web.domain.BawMediaCoverage;
import com.ruoyi.web.service.IBawMediaCoverageService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.ui.ModelMap;

/**
 * 媒体报道Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-06
 */
@Service
public class BawMediaCoverageServiceImpl implements IBawMediaCoverageService 
{
    @Autowired
    private BawMediaCoverageMapper bawMediaCoverageMapper;

    /**
     * 查询媒体报道
     * 
     * @param id 媒体报道主键
     * @return 媒体报道
     */
    @Override
    public BawMediaCoverage selectBawMediaCoverageById(Integer id)
    {
        return bawMediaCoverageMapper.selectBawMediaCoverageById(id);
    }

    /**
     * 查询媒体报道
     *
     * @param id 媒体报道主键
     * @return 媒体报道
     */
    @Override
    public ModelMap selectBawMediaCoverageByIdForApi(Integer id)
    {
        return bawMediaCoverageMapper.selectBawMediaCoverageByIdForApi(id);
    }

    /**
     * 查询媒体报道列表
     * 
     * @param bawMediaCoverage 媒体报道
     * @return 媒体报道
     */
    @Override
    public List<BawMediaCoverage> selectBawMediaCoverageList(BawMediaCoverage bawMediaCoverage)
    {
        return bawMediaCoverageMapper.selectBawMediaCoverageList(bawMediaCoverage);
    }

    /**
     * 查询媒体报道列表For API
     *
     * @return 媒体报道集合
     */
    @Override
    public List<ModelMap> selectBawMediaCoverageListForApi(Integer isDelete, Integer isDisable, Integer year, Integer month, String keywords) {
        return bawMediaCoverageMapper.selectBawMediaCoverageListForApi(isDelete, isDisable, year, month, keywords);
    }

    /**
     * 查询媒体报道年月列表For API
     *
     * @return 媒体报道年月集合
     */
    @Override
    public List<ModelMap> selectBawMediaCoverageYearMonthListForApi() {
        return bawMediaCoverageMapper.selectBawMediaCoverageYearMonthListForApi();
    }

    /**
     * 新增媒体报道
     * 
     * @param bawMediaCoverage 媒体报道
     * @return 结果
     */
    @Override
    public int insertBawMediaCoverage(BawMediaCoverage bawMediaCoverage)
    {
        return bawMediaCoverageMapper.insertBawMediaCoverage(bawMediaCoverage);
    }

    /**
     * 修改媒体报道
     * 
     * @param bawMediaCoverage 媒体报道
     * @return 结果
     */
    @Override
    public int updateBawMediaCoverage(BawMediaCoverage bawMediaCoverage)
    {
        return bawMediaCoverageMapper.updateBawMediaCoverage(bawMediaCoverage);
    }

    /**
     * 批量删除媒体报道
     * 
     * @param ids 需要删除的媒体报道主键
     * @return 结果
     */
    @Override
    public int deleteBawMediaCoverageByIds(String ids)
    {
        return bawMediaCoverageMapper.deleteBawMediaCoverageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除媒体报道信息
     * 
     * @param id 媒体报道主键
     * @return 结果
     */
    @Override
    public int deleteBawMediaCoverageById(Integer id)
    {
        return bawMediaCoverageMapper.deleteBawMediaCoverageById(id);
    }
}
