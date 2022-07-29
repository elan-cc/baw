package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawIndexKv;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.ModelMap;

/**
 * 首页KVMapper接口
 * 
 * @author ruoyi
 * @date 2021-12-09
 */
public interface BawIndexKvMapper 
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
    public List<ModelMap> selectBawIndexKvListForApi(@Param("isDelete") Integer isDelete, @Param("isDisable") Integer isDisable);

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
     * 删除首页KV
     * 
     * @param id 首页KV主键
     * @return 结果
     */
    public int deleteBawIndexKvById(Integer id);

    /**
     * 批量删除首页KV
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawIndexKvByIds(String[] ids);
}
