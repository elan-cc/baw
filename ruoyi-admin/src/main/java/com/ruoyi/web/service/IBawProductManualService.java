package com.ruoyi.web.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.domain.BawProductManual;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * 产品手册Service接口
 *
 * @author ruoyi
 * @date 2022-05-10
 */
public interface IBawProductManualService
{
    /**
     * 查询产品手册
     *
     * @param id 产品手册主键
     * @return 产品手册
     */
    public BawProductManual selectBawProductManualById(Integer id);

    /**
     * 查询产品手册列表
     *
     * @param bawProductManual 产品手册
     * @return 产品手册集合
     */
    public List<BawProductManual> selectBawProductManualList(BawProductManual bawProductManual);

    /**
     * 新增产品手册
     *
     * @param bawProductManual 产品手册
     * @return 结果
     */
    public int insertBawProductManual(BawProductManual bawProductManual);

    /**
     * 修改产品手册
     *
     * @param bawProductManual 产品手册
     * @return 结果
     */
    public int updateBawProductManual(BawProductManual bawProductManual);

    /**
     * 批量删除产品手册
     *
     * @param ids 需要删除的产品手册主键集合
     * @return 结果
     */
    public int deleteBawProductManualByIds(String ids);

    /**
     * 删除产品手册信息
     *
     * @param id 产品手册主键
     * @return 结果
     */
    public int deleteBawProductManualById(Integer id);

    /**
     * 通过id查询产品手册详情
     * @param id 产品手册id
     * @param userId 用户id
     * @return
     */
    public AjaxResult productManualInfo(Integer id, Integer userId);

    /**
     * 产品手册分享
     * @param id 产品手册id
     * @return
     */
    public AjaxResult share(Integer id);

    /**
     * 产品手册点赞
     * @param id 产品手册id
     * @param userId 用户id
     * @return
     */
    public AjaxResult productManualLike(Integer id, Integer userId);


    public List<ModelMap> selectId(Integer id);
}
