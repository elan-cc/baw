package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawIndexModel1;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

/**
 * 首页模块1Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-09
 */
public interface BawIndexModel1Mapper 
{
    /**
     * 查询首页模块1
     * 
     * @param id 首页模块1主键
     * @return 首页模块1
     */
    public BawIndexModel1 selectBawIndexModel1ById(Integer id);

    /**
     * 查询首页模块1列表
     * 
     * @param bawIndexModel1 首页模块1
     * @return 首页模块1集合
     */
    public List<BawIndexModel1> selectBawIndexModel1List(BawIndexModel1 bawIndexModel1);

    /**
     * 查询首页模块1列表For API
     *
     * @return 首页模块1集合
     */
    public List<ModelMap> selectBawIndexModel1ListForApi(@Param("isDelete") Integer isDelete, @Param("isDisable") Integer isDisable);

    /**
     * 新增首页模块1
     * 
     * @param bawIndexModel1 首页模块1
     * @return 结果
     */
    public int insertBawIndexModel1(BawIndexModel1 bawIndexModel1);

    /**
     * 修改首页模块1
     * 
     * @param bawIndexModel1 首页模块1
     * @return 结果
     */
    public int updateBawIndexModel1(BawIndexModel1 bawIndexModel1);

    /**
     * 删除首页模块1
     * 
     * @param id 首页模块1主键
     * @return 结果
     */
    public int deleteBawIndexModel1ById(Integer id);

    /**
     * 批量删除首页模块1
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawIndexModel1ByIds(String[] ids);
}
