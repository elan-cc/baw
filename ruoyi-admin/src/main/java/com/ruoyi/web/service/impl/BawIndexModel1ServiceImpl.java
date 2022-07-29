package com.ruoyi.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawIndexModel1Mapper;
import com.ruoyi.web.domain.BawIndexModel1;
import com.ruoyi.web.service.IBawIndexModel1Service;
import com.ruoyi.common.core.text.Convert;
import org.springframework.ui.ModelMap;

/**
 * 首页模块1Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-09
 */
@Service
public class BawIndexModel1ServiceImpl implements IBawIndexModel1Service 
{
    @Autowired
    private BawIndexModel1Mapper bawIndexModel1Mapper;

    /**
     * 查询首页模块1
     * 
     * @param id 首页模块1主键
     * @return 首页模块1
     */
    @Override
    public BawIndexModel1 selectBawIndexModel1ById(Integer id)
    {
        return bawIndexModel1Mapper.selectBawIndexModel1ById(id);
    }

    /**
     * 查询首页模块1列表
     * 
     * @param bawIndexModel1 首页模块1
     * @return 首页模块1
     */
    @Override
    public List<BawIndexModel1> selectBawIndexModel1List(BawIndexModel1 bawIndexModel1)
    {
        return bawIndexModel1Mapper.selectBawIndexModel1List(bawIndexModel1);
    }

    /**
     * 查询首页模块1列表For API
     *
     * @return 首页模块1集合
     */
    @Override
    public List<ModelMap> selectBawIndexModel1ListForApi(Integer isDelete, Integer isDisable) {
        return bawIndexModel1Mapper.selectBawIndexModel1ListForApi(isDelete, isDisable);
    }

    /**
     * 新增首页模块1
     * 
     * @param bawIndexModel1 首页模块1
     * @return 结果
     */
    @Override
    public int insertBawIndexModel1(BawIndexModel1 bawIndexModel1)
    {
        return bawIndexModel1Mapper.insertBawIndexModel1(bawIndexModel1);
    }

    /**
     * 修改首页模块1
     * 
     * @param bawIndexModel1 首页模块1
     * @return 结果
     */
    @Override
    public int updateBawIndexModel1(BawIndexModel1 bawIndexModel1)
    {
        return bawIndexModel1Mapper.updateBawIndexModel1(bawIndexModel1);
    }

    /**
     * 批量删除首页模块1
     * 
     * @param ids 需要删除的首页模块1主键
     * @return 结果
     */
    @Override
    public int deleteBawIndexModel1ByIds(String ids)
    {
        return bawIndexModel1Mapper.deleteBawIndexModel1ByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除首页模块1信息
     * 
     * @param id 首页模块1主键
     * @return 结果
     */
    @Override
    public int deleteBawIndexModel1ById(Integer id)
    {
        return bawIndexModel1Mapper.deleteBawIndexModel1ById(id);
    }
}
