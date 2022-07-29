package com.ruoyi.web.service;

import java.util.List;
import com.ruoyi.web.domain.BawIndexKv;
import org.springframework.ui.ModelMap;

/**
 * 首页KVService接口
 * 
 * @author ruoyi
 * @date 2021-12-09
 */
public interface IBawIndexKvService 
{
    /**
     * 查询首页KV
     * 
     * @param id 首页KV主键
     * @return 首页KV
     */
    public BawIndexKv selectBawIndexKvById(Integer id);

    /**
     * 查询首页KV列表
     * 
     * @param bawIndexKv 首页KV
     * @return 首页KV集合
     */
    public List<BawIndexKv> selectBawIndexKvList(BawIndexKv bawIndexKv);

    /**
     * 查询首页KV列表For API
     *
     * @return 首页KV集合
     */
    public List<ModelMap> selectBawIndexKvListForApi(Integer isDelete, Integer isDisable);

    /**
     * 新增首页KV
     * 
     * @param bawIndexKv 首页KV
     * @return 结果
     */
    public int insertBawIndexKv(BawIndexKv bawIndexKv);

    /**
     * 修改首页KV
     * 
     * @param bawIndexKv 首页KV
     * @return 结果
     */
    public int updateBawIndexKv(BawIndexKv bawIndexKv);

    /**
     * 批量删除首页KV
     * 
     * @param ids 需要删除的首页KV主键集合
     * @return 结果
     */
    public int deleteBawIndexKvByIds(String ids);

    /**
     * 删除首页KV信息
     * 
     * @param id 首页KV主键
     * @return 结果
     */
    public int deleteBawIndexKvById(Integer id);
}
