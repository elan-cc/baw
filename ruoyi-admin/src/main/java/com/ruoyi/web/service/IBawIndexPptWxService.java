package com.ruoyi.web.service;

import java.util.List;
import com.ruoyi.web.domain.BawIndexPptWx;

/**
 * 首页轮播图Service接口
 *
 * @author ruoyi
 * @date 2022-04-28
 */
public interface IBawIndexPptWxService
{
    /**
     * 查询首页轮播图
     *
     * @param id 首页轮播图主键
     * @return 首页轮播图
     */
    public BawIndexPptWx selectBawIndexPptWxById(Integer id);

    /**
     * 查询首页轮播图列表
     *
     * @param bawIndexPptWx 首页轮播图
     * @return 首页轮播图集合
     */
    public List<BawIndexPptWx> selectBawIndexPptWxList(BawIndexPptWx bawIndexPptWx);

    /**
     * 新增首页轮播图
     *
     * @param bawIndexPptWx 首页轮播图
     * @return 结果
     */
    public int insertBawIndexPptWx(BawIndexPptWx bawIndexPptWx);

    /**
     * 修改首页轮播图
     *
     * @param bawIndexPptWx 首页轮播图
     * @return 结果
     */
    public int updateBawIndexPptWx(BawIndexPptWx bawIndexPptWx);

    /**
     * 批量删除首页轮播图
     *
     * @param ids 需要删除的首页轮播图主键集合
     * @return 结果
     */
    public int deleteBawIndexPptWxByIds(String ids);

    /**
     * 删除首页轮播图信息
     *
     * @param id 首页轮播图主键
     * @return 结果
     */
    public int deleteBawIndexPptWxById(Integer id);
}
