package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawBaseCarConfigGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

/**
 * 车辆配置分组Mapper接口
 *
 * @author ruoyi
 * @date 2022-04-02
 */
public interface BawBaseCarConfigGroupMapper
{
    /**
     * 查询车辆配置分组
     *
     * @param id 车辆配置分组主键
     * @return 车辆配置分组
     */
    public BawBaseCarConfigGroup selectBawBaseCarConfigGroupById(Integer id);

    /**
     * 查询车辆配置分组列表
     *
     * @param bawBaseCarConfigGroup 车辆配置分组
     * @return 车辆配置分组集合
     */
    public List<BawBaseCarConfigGroup> selectBawBaseCarConfigGroupList(BawBaseCarConfigGroup bawBaseCarConfigGroup);

    /**
     * 新增车辆配置分组
     *
     * @param bawBaseCarConfigGroup 车辆配置分组
     * @return 结果
     */
    public int insertBawBaseCarConfigGroup(BawBaseCarConfigGroup bawBaseCarConfigGroup);

    /**
     * 修改车辆配置分组
     *
     * @param bawBaseCarConfigGroup 车辆配置分组
     * @return 结果
     */
    public int updateBawBaseCarConfigGroup(BawBaseCarConfigGroup bawBaseCarConfigGroup);

    /**
     * 删除车辆配置分组
     *
     * @param id 车辆配置分组主键
     * @return 结果
     */
    public int deleteBawBaseCarConfigGroupById(Integer id);

    /**
     * 批量删除车辆配置分组
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawBaseCarConfigGroupByIds(String[] ids);


    /**
     * 查询name
     * @return
     */
    public List<ModelMap> selectBawBaseCarConfigGroupByName();
    /**
     * 查询name
     * @return
     */
    public List<ModelMap> selectBawBaseCarConfigGroupName();

    public BawBaseCarConfigGroup selectBawBaseCarConfigGroupname(String name);
}
