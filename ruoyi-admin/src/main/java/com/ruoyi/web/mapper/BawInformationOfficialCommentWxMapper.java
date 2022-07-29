package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawInformationOfficialCommentWx;

/**
 * 官方资讯/精彩推荐评论Mapper接口
 *
 * @author ruoyi
 * @date 2022-04-19
 */
public interface BawInformationOfficialCommentWxMapper
{
    /**
     * 查询官方资讯/精彩推荐评论
     *
     * @param id 官方资讯/精彩推荐评论主键
     * @return 官方资讯/精彩推荐评论
     */
    public BawInformationOfficialCommentWx selectBawInformationOfficialCommentWxById(Integer id);

    /**
     * 查询官方资讯/精彩推荐评论列表
     *
     * @param bawInformationOfficialCommentWx 官方资讯/精彩推荐评论
     * @return 官方资讯/精彩推荐评论集合
     */
    public List<BawInformationOfficialCommentWx> selectBawInformationOfficialCommentWxList(BawInformationOfficialCommentWx bawInformationOfficialCommentWx);

    /**
     * 新增官方资讯/精彩推荐评论
     *
     * @param bawInformationOfficialCommentWx 官方资讯/精彩推荐评论
     * @return 结果
     */
    public int insertBawInformationOfficialCommentWx(BawInformationOfficialCommentWx bawInformationOfficialCommentWx);

    /**
     * 修改官方资讯/精彩推荐评论
     *
     * @param bawInformationOfficialCommentWx 官方资讯/精彩推荐评论
     * @return 结果
     */
    public int updateBawInformationOfficialCommentWx(BawInformationOfficialCommentWx bawInformationOfficialCommentWx);

    /**
     * 删除官方资讯/精彩推荐评论
     *
     * @param id 官方资讯/精彩推荐评论主键
     * @return 结果
     */
    public int deleteBawInformationOfficialCommentWxById(Integer id);

    /**
     * 批量删除官方资讯/精彩推荐评论
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawInformationOfficialCommentWxByIds(String[] ids);
}
