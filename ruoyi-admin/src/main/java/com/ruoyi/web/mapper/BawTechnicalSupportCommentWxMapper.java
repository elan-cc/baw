package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawTechnicalSupportCommentWx;

/**
 * 技术支持评论Mapper接口
 * 
 * @author ruoyi
 * @date 2022-04-20
 */
public interface BawTechnicalSupportCommentWxMapper 
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
     * 删除技术支持评论
     * 
     * @param id 技术支持评论主键
     * @return 结果
     */
    public int deleteBawTechnicalSupportCommentWxById(Integer id);

    /**
     * 批量删除技术支持评论
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawTechnicalSupportCommentWxByIds(String[] ids);
}
