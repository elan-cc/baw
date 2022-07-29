package com.ruoyi.web.service;

import java.util.List;
import com.ruoyi.web.domain.BawTechnicalSupportCommentLikesWx;

/**
 * 技术支持评论点赞Service接口
 * 
 * @author ruoyi
 * @date 2022-04-20
 */
public interface IBawTechnicalSupportCommentLikesWxService 
{
    /**
     * 查询技术支持评论点赞
     * 
     * @param id 技术支持评论点赞主键
     * @return 技术支持评论点赞
     */
    public BawTechnicalSupportCommentLikesWx selectBawTechnicalSupportCommentLikesWxById(Integer id);

    /**
     * 查询技术支持评论点赞列表
     * 
     * @param bawTechnicalSupportCommentLikesWx 技术支持评论点赞
     * @return 技术支持评论点赞集合
     */
    public List<BawTechnicalSupportCommentLikesWx> selectBawTechnicalSupportCommentLikesWxList(BawTechnicalSupportCommentLikesWx bawTechnicalSupportCommentLikesWx);

    /**
     * 新增技术支持评论点赞
     * 
     * @param bawTechnicalSupportCommentLikesWx 技术支持评论点赞
     * @return 结果
     */
    public int insertBawTechnicalSupportCommentLikesWx(BawTechnicalSupportCommentLikesWx bawTechnicalSupportCommentLikesWx);

    /**
     * 修改技术支持评论点赞
     * 
     * @param bawTechnicalSupportCommentLikesWx 技术支持评论点赞
     * @return 结果
     */
    public int updateBawTechnicalSupportCommentLikesWx(BawTechnicalSupportCommentLikesWx bawTechnicalSupportCommentLikesWx);

    /**
     * 批量删除技术支持评论点赞
     * 
     * @param ids 需要删除的技术支持评论点赞主键集合
     * @return 结果
     */
    public int deleteBawTechnicalSupportCommentLikesWxByIds(String ids);

    /**
     * 删除技术支持评论点赞信息
     * 
     * @param id 技术支持评论点赞主键
     * @return 结果
     */
    public int deleteBawTechnicalSupportCommentLikesWxById(Integer id);
}
