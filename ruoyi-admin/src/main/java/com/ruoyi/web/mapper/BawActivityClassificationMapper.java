package com.ruoyi.web.mapper;

import com.ruoyi.web.domain.BawActivityClassification;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * 活动分类Mapper接口
 *
 * @author ruoyi
 * @date 2022-05-25
 */
public interface BawActivityClassificationMapper
{
    /**
     * 查询活动分类
     *
     * @param id 活动分类主键
     * @return 活动分类
     */
    public BawActivityClassification selectBawActivityClassificationById(Integer id);

    /**
     * 查询活动分类列表
     *
     * @param bawActivityClassification 活动分类
     * @return 活动分类集合
     */
    public List<BawActivityClassification> selectBawActivityClassificationList(BawActivityClassification bawActivityClassification);

    /**
     * 新增活动分类
     *
     * @param bawActivityClassification 活动分类
     * @return 结果
     */
    public int insertBawActivityClassification(BawActivityClassification bawActivityClassification);

    /**
     * 修改活动分类
     *
     * @param bawActivityClassification 活动分类
     * @return 结果
     */
    public int updateBawActivityClassification(BawActivityClassification bawActivityClassification);

    /**
     * 删除活动分类
     *
     * @param id 活动分类主键
     * @return 结果
     */
    public int deleteBawActivityClassificationById(Integer id);

    /**
     * 批量删除活动分类
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawActivityClassificationByIds(String[] ids);

    public List<ModelMap> selectBawActivityClassificationByName();

    public List<ModelMap> classIficartionList();





}
