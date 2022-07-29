package com.ruoyi.web.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.web.domain.BawCompanyNews;
import com.ruoyi.web.mapper.BawCompanyNewsMapper;
import com.ruoyi.web.service.IBawCompanyNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * 企业新闻Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-06
 */
@Service
public class BawCompanyNewsServiceImpl implements IBawCompanyNewsService 
{
    @Autowired
    private BawCompanyNewsMapper bawCompanyNewsMapper;

    /**
     * 查询企业新闻
     * 
     * @param id 企业新闻主键
     * @return 企业新闻
     */
    @Override
    public BawCompanyNews selectBawCompanyNewsById(Integer id)
    {
        return bawCompanyNewsMapper.selectBawCompanyNewsById(id);
    }

    /**
     * 查询企业新闻
     *
     * @param id 企业新闻主键
     * @return 企业新闻
     */
    @Override
    public ModelMap selectBawCompanyNewsByIdForApi(Integer id)
    {
        return bawCompanyNewsMapper.selectBawCompanyNewsByIdForApi(id);
    }

    /**
     * 查询企业新闻列表
     * 
     * @param bawCompanyNews 企业新闻
     * @return 企业新闻
     */
    @Override
    public List<BawCompanyNews> selectBawCompanyNewsList(BawCompanyNews bawCompanyNews)
    {
        return bawCompanyNewsMapper.selectBawCompanyNewsList(bawCompanyNews);
    }

    /**
     * 查询企业新闻列表For API
     *
     * @return 企业新闻集合
     */
    @Override
    public List<ModelMap> selectBawCompanyNewsListForApi(Integer isDelete, Integer isDisable, Integer year, Integer month, String keywords) {
        return bawCompanyNewsMapper.selectBawCompanyNewsListForApi(isDelete, isDisable, year, month, keywords);
    }

    /**
     * 查询企业新闻年月列表For API
     *
     * @return 企业新闻年月集合
     */
    @Override
    public List<ModelMap> selectBawCompanyNewsYearMonthListForApi() {
        return bawCompanyNewsMapper.selectBawCompanyNewsYearMonthListForApi();
    }

    /**
     * 新增企业新闻
     * 
     * @param bawCompanyNews 企业新闻
     * @return 结果
     */
    @Override
    public int insertBawCompanyNews(BawCompanyNews bawCompanyNews)
    {
        return bawCompanyNewsMapper.insertBawCompanyNews(bawCompanyNews);
    }

    /**
     * 修改企业新闻
     * 
     * @param bawCompanyNews 企业新闻
     * @return 结果
     */
    @Override
    public int updateBawCompanyNews(BawCompanyNews bawCompanyNews)
    {
        return bawCompanyNewsMapper.updateBawCompanyNews(bawCompanyNews);
    }

    /**
     * 批量删除企业新闻
     * 
     * @param ids 需要删除的企业新闻主键
     * @return 结果
     */
    @Override
    public int deleteBawCompanyNewsByIds(String ids)
    {
        return bawCompanyNewsMapper.deleteBawCompanyNewsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除企业新闻信息
     * 
     * @param id 企业新闻主键
     * @return 结果
     */
    @Override
    public int deleteBawCompanyNewsById(Integer id)
    {
        return bawCompanyNewsMapper.deleteBawCompanyNewsById(id);
    }
}
