package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.BawCompanyNews;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * 企业新闻Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-06
 */
public interface BawCompanyNewsMapper 
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
    public List<ModelMap> selectBawCompanyNewsListForApi(@Param("isDelete") Integer isDelete, @Param("isDisable") Integer isDisable, @Param("year") Integer year, @Param("month") Integer month, @Param("keywords") String keywords);

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
     * 删除企业新闻
     * 
     * @param id 企业新闻主键
     * @return 结果
     */
    public int deleteBawCompanyNewsById(Integer id);

    /**
     * 批量删除企业新闻
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawCompanyNewsByIds(String[] ids);
}
