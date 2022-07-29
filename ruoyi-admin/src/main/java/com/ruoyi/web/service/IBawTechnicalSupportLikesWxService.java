package com.ruoyi.web.service;

import java.util.List;
import com.ruoyi.web.domain.BawTechnicalSupportLikesWx;

/**
 * 技术支持点赞Service接口
 * 
 * @author ruoyi
 * @date 2022-04-20
 */
public interface IBawTechnicalSupportLikesWxService 
{
    /**
     * 查询技术支持点赞
     * 
     * @param id 技术支持点赞主键
     * @return 技术支持点赞
     */
    public BawTechnicalSupportLikesWx selectBawTechnicalSupportLikesWxById(Integer id);

    /**
     * 查询技术支持点赞列表
     * 
     * @param bawTechnicalSupportLikesWx 技术支持点赞
     * @return 技术支持点赞集合
     */
    public List<BawTechnicalSupportLikesWx> selectBawTechnicalSupportLikesWxList(BawTechnicalSupportLikesWx bawTechnicalSupportLikesWx);

    /**
     * 新增技术支持点赞
     * 
     * @param bawTechnicalSupportLikesWx 技术支持点赞
     * @return 结果
     */
    public int insertBawTechnicalSupportLikesWx(BawTechnicalSupportLikesWx bawTechnicalSupportLikesWx);

    /**
     * 修改技术支持点赞
     * 
     * @param bawTechnicalSupportLikesWx 技术支持点赞
     * @return 结果
     */
    public int updateBawTechnicalSupportLikesWx(BawTechnicalSupportLikesWx bawTechnicalSupportLikesWx);

    /**
     * 批量删除技术支持点赞
     * 
     * @param ids 需要删除的技术支持点赞主键集合
     * @return 结果
     */
    public int deleteBawTechnicalSupportLikesWxByIds(String ids);

    /**
     * 删除技术支持点赞信息
     * 
     * @param id 技术支持点赞主键
     * @return 结果
     */
    public int deleteBawTechnicalSupportLikesWxById(Integer id);
}
