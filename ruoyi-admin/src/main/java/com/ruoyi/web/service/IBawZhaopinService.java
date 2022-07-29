package com.ruoyi.web.service;

import java.util.List;
import com.ruoyi.web.domain.BawZhaopin;
import org.springframework.ui.ModelMap;

/**
 * 加入我们Service接口
 *
 * @author ruoyi
 * @date 2021-12-09
 */
public interface IBawZhaopinService
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
    public List<ModelMap> selectBawZhaopinListForApi(Integer isDelete, Integer isDisable,String jobName, String jobType,String jobPlace,String keywords);

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
     * 批量删除加入我们
     *
     * @param ids 需要删除的加入我们主键集合
     * @return 结果
     */
    public int deleteBawZhaopinByIds(String ids);

    /**
     * 删除加入我们信息
     *
     * @param id 加入我们主键
     * @return 结果
     */
    public int deleteBawZhaopinById(Integer id);
}
