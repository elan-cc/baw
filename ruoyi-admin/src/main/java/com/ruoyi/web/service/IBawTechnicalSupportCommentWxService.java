package com.ruoyi.web.service;

import java.util.List;
import com.ruoyi.web.domain.BawTechnicalSupportCommentWx;

/**
 * 技术支持评论Service接口
 * 
 * @author ruoyi
 * @date 2022-04-20
 */
public interface IBawTechnicalSupportCommentWxService 
{
    /**
     * 查询技术支持评论
     * 
     * @param id 技术支持评论主键
     * @return 技术支持评论
     */
    public BawTechnicalSupportCommentWx selectBawTechnicalSupportCommentWxById(Integer id);

    /**
     * 查询技术支持评论列表
     * 
     * @param bawTechnicalSupportCommentWx 技术支持评论
     * @return 技术支持评论集合
     */
    public List<BawTechnicalSupportCommentWx> selectBawTechnicalSupportCommentWxList(BawTechnicalSupportCommentWx bawTechnicalSupportCommentWx);

    /**
     * 新增技术支持评论
     * 
     * @param bawTechnicalSupportCommentWx 技术支持评论
     * @return 结果
     */
    public int insertBawTechnicalSupportCommentWx(BawTechnicalSupportCommentWx bawTechnicalSupportCommentWx);

    /**
     * 修改技术支持评论
     * 
     * @param bawTechnicalSupportCommentWx 技术支持评论
     * @return 结果
     */
    public int updateBawTechnicalSupportCommentWx(BawTechnicalSupportCommentWx bawTechnicalSupportCommentWx);

    /**
     * 批量删除技术支持评论
     * 
     * @param ids 需要删除的技术支持评论主键集合
     * @return 结果
     */
    public int deleteBawTechnicalSupportCommentWxByIds(String ids);

    /**
     * 删除技术支持评论信息
     * 
     * @param id 技术支持评论主键
     * @return 结果
     */
    public int deleteBawTechnicalSupportCommentWxById(Integer id);
}
