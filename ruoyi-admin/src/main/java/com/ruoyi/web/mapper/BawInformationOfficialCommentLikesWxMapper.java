package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawInformationOfficialCommentLikesWx;

/**
 * 官方资讯评论点赞Mapper接口
 * 
 * @author ruoyi
 * @date 2022-04-19
 */
public interface BawInformationOfficialCommentLikesWxMapper 
{
    /**
     * 查询官方资讯评论点赞
     * 
     * @param id 官方资讯评论点赞主键
     * @return 官方资讯评论点赞
     */
    public BawInformationOfficialCommentLikesWx selectBawInformationOfficialCommentLikesWxById(Integer id);

    /**
     * 查询官方资讯评论点赞列表
     * 
     * @param bawInformationOfficialCommentLikesWx 官方资讯评论点赞
     * @return 官方资讯评论点赞集合
     */
    public List<BawInformationOfficialCommentLikesWx> selectBawInformationOfficialCommentLikesWxList(BawInformationOfficialCommentLikesWx bawInformationOfficialCommentLikesWx);

    /**
     * 新增官方资讯评论点赞
     * 
     * @param bawInformationOfficialCommentLikesWx 官方资讯评论点赞
     * @return 结果
     */
    public int insertBawInformationOfficialCommentLikesWx(BawInformationOfficialCommentLikesWx bawInformationOfficialCommentLikesWx);

    /**
     * 修改官方资讯评论点赞
     * 
     * @param bawInformationOfficialCommentLikesWx 官方资讯评论点赞
     * @return 结果
     */
    public int updateBawInformationOfficialCommentLikesWx(BawInformationOfficialCommentLikesWx bawInformationOfficialCommentLikesWx);

    /**
     * 删除官方资讯评论点赞
     * 
     * @param id 官方资讯评论点赞主键
     * @return 结果
     */
    public int deleteBawInformationOfficialCommentLikesWxById(Integer id);

    /**
     * 批量删除官方资讯评论点赞
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawInformationOfficialCommentLikesWxByIds(String[] ids);
}
