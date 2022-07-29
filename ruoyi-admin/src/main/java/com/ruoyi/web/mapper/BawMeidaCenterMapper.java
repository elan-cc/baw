package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawMeidaCenter;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

/**
 * 媒体中心Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-06
 */
public interface BawMeidaCenterMapper 
{
    /**
     * 查询媒体中心
     * 
     * @param id 媒体中心主键
     * @return 媒体中心
     */
    public BawMeidaCenter selectBawMeidaCenterById(Integer id);

    /**
     * 查询媒体中心
     *
     * @param id 媒体中心主键
     * @return 媒体中心
     */
    public ModelMap selectBawMeidaCenterByIdForApi(Integer id);

    /**
     * 查询媒体中心列表
     * 
     * @param bawMeidaCenter 媒体中心
     * @return 媒体中心集合
     */
    public List<BawMeidaCenter> selectBawMeidaCenterList(BawMeidaCenter bawMeidaCenter);

    /**
     * 查询媒体中心列表For API
     *
     * @return 媒体中心集合
     */
    public List<ModelMap> selectBawMeidaCenterListForApi(@Param("isDelete") Integer isDelete, @Param("isDisable") Integer isDisable, @Param("year") Integer year, @Param("month") Integer month, @Param("mediaType") Integer mediaType, @Param("keywords") String keywords);

    /**
     * 查询媒体中心年月列表For API
     *
     * @return 媒体中心年月集合
     */
    public List<ModelMap> selectBawMeidaCenterYearMonthListForApi();

    /**
     * 新增媒体中心
     * 
     * @param bawMeidaCenter 媒体中心
     * @return 结果
     */
    public int insertBawMeidaCenter(BawMeidaCenter bawMeidaCenter);

    /**
     * 修改媒体中心
     * 
     * @param bawMeidaCenter 媒体中心
     * @return 结果
     */
    public int updateBawMeidaCenter(BawMeidaCenter bawMeidaCenter);

    /**
     * 删除媒体中心
     * 
     * @param id 媒体中心主键
     * @return 结果
     */
    public int deleteBawMeidaCenterById(Integer id);

    /**
     * 批量删除媒体中心
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawMeidaCenterByIds(String[] ids);
}
