package com.ruoyi.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawIndexKvMapper;
import com.ruoyi.web.domain.BawIndexKv;
import com.ruoyi.web.service.IBawIndexKvService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.ui.ModelMap;

/**
 * 首页KVService业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-09
 */
@Service
public class BawIndexKvServiceImpl implements IBawIndexKvService 
{
    @Autowired
    private BawIndexKvMapper bawIndexKvMapper;

    /**
     * 查询首页KV
     * 
     * @param id 首页KV主键
     * @return 首页KV
     */
    @Override
    public BawIndexKv selectBawIndexKvById(Integer id)
    {
        return bawIndexKvMapper.selectBawIndexKvById(id);
    }

    /**
     * 查询首页KV列表
     * 
     * @param bawIndexKv 首页KV
     * @return 首页KV
     */
    @Override
    public List<BawIndexKv> selectBawIndexKvList(BawIndexKv bawIndexKv)
    {
        return bawIndexKvMapper.selectBawIndexKvList(bawIndexKv);
    }

    /**
     * 查询首页KV列表For API
     *
     * @return 首页KV集合
     */
    @Override
    public List<ModelMap> selectBawIndexKvListForApi(Integer isDelete, Integer isDisable) {
        return bawIndexKvMapper.selectBawIndexKvListForApi(isDelete, isDisable);
    }

    /**
     * 新增首页KV
     * 
     * @param bawIndexKv 首页KV
     * @return 结果
     */
    @Override
    public int insertBawIndexKv(BawIndexKv bawIndexKv)
    {
        return bawIndexKvMapper.insertBawIndexKv(bawIndexKv);
    }

    /**
     * 修改首页KV
     * 
     * @param bawIndexKv 首页KV
     * @return 结果
     */
    @Override
    public int updateBawIndexKv(BawIndexKv bawIndexKv)
    {
        return bawIndexKvMapper.updateBawIndexKv(bawIndexKv);
    }

    /**
     * 批量删除首页KV
     * 
     * @param ids 需要删除的首页KV主键
     * @return 结果
     */
    @Override
    public int deleteBawIndexKvByIds(String ids)
    {
        return bawIndexKvMapper.deleteBawIndexKvByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除首页KV信息
     * 
     * @param id 首页KV主键
     * @return 结果
     */
    @Override
    public int deleteBawIndexKvById(Integer id)
    {
        return bawIndexKvMapper.deleteBawIndexKvById(id);
    }
}
