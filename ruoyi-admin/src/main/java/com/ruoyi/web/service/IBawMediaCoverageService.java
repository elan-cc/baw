package com.ruoyi.web.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.web.domain.BawMediaCoverage;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

/**
 * 媒体报道Service接口
 * 
 * @author ruoyi
 * @date 2021-12-06
 */
public interface IBawMediaCoverageService 
{
    /**
     * 查询媒体报道
     * 
     * @param id 媒体报道主键
     * @return 媒体报道
     */
    public BawMediaCoverage selectBawMediaCoverageById(Integer id);

    /**
     * 查询媒体报道
     *
     * @param id 媒体报道主键
     * @return 媒体报道
     */
    public ModelMap selectBawMediaCoverageByIdForApi(Integer id);

    /**
     * 查询媒体报道列表
     * 
     * @param bawMediaCoverage 媒体报道
     * @return 媒体报道集合
     */
    public List<BawMediaCoverage> selectBawMediaCoverageList(BawMediaCoverage bawMediaCoverage);

    /**
     * 查询媒体报道列表For API
     *
     * @return 媒体报道集合
     */
    public List<ModelMap> selectBawMediaCoverageListForApi(Integer isDelete, Integer isDisable, Integer year, Integer month, String keywords);

    /**
     * 查询媒体报道年月列表For API
     *
     * @return 媒体报道年月集合
     */
    public List<ModelMap> selectBawMediaCoverageYearMonthListForApi();

    /**
     * 新增媒体报道
     * 
     * @param bawMediaCoverage 媒体报道
     * @return 结果
     */
    public int insertBawMediaCoverage(BawMediaCoverage bawMediaCoverage);

    /**
     * 修改媒体报道
     * 
     * @param bawMediaCoverage 媒体报道
     * @return 结果
     */
    public int updateBawMediaCoverage(BawMediaCoverage bawMediaCoverage);

    /**
     * 批量删除媒体报道
     * 
     * @param ids 需要删除的媒体报道主键集合
     * @return 结果
     */
    public int deleteBawMediaCoverageByIds(String ids);

    /**
     * 删除媒体报道信息
     * 
     * @param id 媒体报道主键
     * @return 结果
     */
    public int deleteBawMediaCoverageById(Integer id);
}
