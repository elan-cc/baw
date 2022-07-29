package com.ruoyi.web.service;

import com.ruoyi.web.domain.BawProductManualLike;

import java.util.List;

/**
 * 产品手册点赞Service接口
 *
 * @author ruoyi
 * @date 2022-05-11
 */
public interface IBawProductManualLikeService
{
    /**
     * 查询产品手册点赞
     *
     * @param id 产品手册点赞主键
     * @return 产品手册点赞
     */
    public BawProductManualLike selectBawProductManualLikeById(Integer id);

    /**
     * 查询产品手册点赞列表
     *
     * @param bawProductManualLike 产品手册点赞
     * @return 产品手册点赞集合
     */
    public List<BawProductManualLike> selectBawProductManualLikeList(BawProductManualLike bawProductManualLike);

    /**
     * 新增产品手册点赞
     *
     * @param bawProductManualLike 产品手册点赞
     * @return 结果
     */
    public int insertBawProductManualLike(BawProductManualLike bawProductManualLike);

    /**
     * 修改产品手册点赞
     *
     * @param bawProductManualLike 产品手册点赞
     * @return 结果
     */
    public int updateBawProductManualLike(BawProductManualLike bawProductManualLike);

    /**
     * 批量删除产品手册点赞
     *
     * @param ids 需要删除的产品手册点赞主键集合
     * @return 结果
     */
    public int deleteBawProductManualLikeByIds(String ids);

    /**
     * 删除产品手册点赞信息
     *
     * @param id 产品手册点赞主键
     * @return 结果
     */
    public int deleteBawProductManualLikeById(Integer id);
}
