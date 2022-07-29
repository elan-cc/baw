package com.ruoyi.web.service;

import com.ruoyi.web.domain.BawCompanyNews;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * 企业新闻Service接口
 * 
 * @author ruoyi
 * @date 2021-12-06
 */
public interface IBawCompanyNewsService 
{
    /**
     * 查询企业新闻
     * 
     * @param id 企业新闻主键
     * @return 企业新闻
     */
    public BawCompanyNews selectBawCompanyNewsById(Integer id);

    /**
     * 查询企业新闻
     *
     * @param id 企业新闻主键
     * @return 企业新闻
     */
    public ModelMap selectBawCompanyNewsByIdForApi(Integer id);

    /**
     * 查询企业新闻列表
     * 
     * @param bawCompanyNews 企业新闻
     * @return 企业新闻集合
     */
    public List<BawCompanyNews> selectBawCompanyNewsList(BawCompanyNews bawCompanyNews);

    /**
     * 查询企业新闻列表For API
     *
     * @return 企业新闻集合
     */
    public List<ModelMap> selectBawCompanyNewsListForApi(Integer isDelete, Integer isDisable, Integer year, Integer month, String keywords);

    /**
     * 查询企业新闻年月列表For API
     *
     * @return 企业新闻年月集合
     */
    public List<ModelMap> selectBawCompanyNewsYearMonthListForApi();

    /**
     * 新增企业新闻
     * 
     * @param bawCompanyNews 企业新闻
     * @return 结果
     */
    public int insertBawCompanyNews(BawCompanyNews bawCompanyNews);

    /**
     * 修改企业新闻
     * 
     * @param bawCompanyNews 企业新闻
     * @return 结果
     */
    public int updateBawCompanyNews(BawCompanyNews bawCompanyNews);

    /**
     * 批量删除企业新闻
     * 
     * @param ids 需要删除的企业新闻主键集合
     * @return 结果
     */
    public int deleteBawCompanyNewsByIds(String ids);

    /**
     * 删除企业新闻信息
     * 
     * @param id 企业新闻主键
     * @return 结果
     */
    public int deleteBawCompanyNewsById(Integer id);
}
