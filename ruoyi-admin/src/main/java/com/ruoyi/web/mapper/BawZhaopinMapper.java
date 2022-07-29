package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawZhaopin;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

/**
 * 加入我们Mapper接口
 *
 * @author ruoyi
 * @date 2021-12-09
 */
public interface BawZhaopinMapper
{
    /**
     * 查询加入我们
     *
     * @param id 加入我们主键
     * @return 加入我们
     */
    public BawZhaopin selectBawZhaopinById(Integer id);

    /**
     * 查询加入我们列表
     *
     * @param bawZhaopin 加入我们
     * @return 加入我们集合
     */
    public List<BawZhaopin> selectBawZhaopinList(BawZhaopin bawZhaopin);

    /**
     * 查询加入我们列表For API
     *
     * @return 加入我们集合
     */
    public List<ModelMap> selectBawZhaopinListForApi(@Param("isDelete") Integer isDelete, @Param("isDisable") Integer isDisable,@Param("jobName") String jobName, @Param("jobType") String jobType,@Param("jobPlace")String jobPlace, @Param("keywords") String keywords);

    /**
     * 查询我们工作地点列表For API
     *
     * @return 加入我们工作地点集合
     */
    public List<ModelMap> selectBawZhaopinJobPlaceListForApi();

    /**
     * 新增加入我们
     *
     * @param bawZhaopin 加入我们
     * @return 结果
     */
    public int insertBawZhaopin(BawZhaopin bawZhaopin);

    /**
     * 修改加入我们
     *
     * @param bawZhaopin 加入我们
     * @return 结果
     */
    public int updateBawZhaopin(BawZhaopin bawZhaopin);

    /**
     * 删除加入我们
     *
     * @param id 加入我们主键
     * @return 结果
     */
    public int deleteBawZhaopinById(Integer id);

    /**
     * 批量删除加入我们
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawZhaopinByIds(String[] ids);
}
