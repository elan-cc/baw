package com.ruoyi.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawZhaopinMapper;
import com.ruoyi.web.domain.BawZhaopin;
import com.ruoyi.web.service.IBawZhaopinService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.ui.ModelMap;

/**
 * 加入我们Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-09
 */
@Service
public class BawZhaopinServiceImpl implements IBawZhaopinService
{
    @Autowired
    private BawZhaopinMapper bawZhaopinMapper;

    /**
     * 查询加入我们
     *
     * @param id 加入我们主键
     * @return 加入我们
     */
    @Override
    public BawZhaopin selectBawZhaopinById(Integer id)
    {
        return bawZhaopinMapper.selectBawZhaopinById(id);
    }

    /**
     * 查询加入我们列表
     *
     * @param bawZhaopin 加入我们
     * @return 加入我们
     */
    @Override
    public List<BawZhaopin> selectBawZhaopinList(BawZhaopin bawZhaopin)
    {
        return bawZhaopinMapper.selectBawZhaopinList(bawZhaopin);
    }

    /**
     * 查询加入我们列表For API
     *
     * @return 加入我们集合
     */
    @Override
    public List<ModelMap> selectBawZhaopinListForApi(Integer isDelete, Integer isDisable,String jobName, String jobType,String jobPlace, String keywords) {
        return bawZhaopinMapper.selectBawZhaopinListForApi(isDelete, isDisable, jobName, jobType,jobPlace, keywords);
    }

    /**
     * 查询我们工作地点列表For API
     *
     * @return 加入我们工作地点集合
     */
    @Override
    public List<ModelMap> selectBawZhaopinJobPlaceListForApi() {
        return bawZhaopinMapper.selectBawZhaopinJobPlaceListForApi();
    }

    /**
     * 新增加入我们
     *
     * @param bawZhaopin 加入我们
     * @return 结果
     */
    @Override
    public int insertBawZhaopin(BawZhaopin bawZhaopin)
    {
        return bawZhaopinMapper.insertBawZhaopin(bawZhaopin);
    }

    /**
     * 修改加入我们
     *
     * @param bawZhaopin 加入我们
     * @return 结果
     */
    @Override
    public int updateBawZhaopin(BawZhaopin bawZhaopin)
    {
        return bawZhaopinMapper.updateBawZhaopin(bawZhaopin);
    }

    /**
     * 批量删除加入我们
     *
     * @param ids 需要删除的加入我们主键
     * @return 结果
     */
    @Override
    public int deleteBawZhaopinByIds(String ids)
    {
        return bawZhaopinMapper.deleteBawZhaopinByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除加入我们信息
     *
     * @param id 加入我们主键
     * @return 结果
     */
    @Override
    public int deleteBawZhaopinById(Integer id)
    {
        return bawZhaopinMapper.deleteBawZhaopinById(id);
    }
}
