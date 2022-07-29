package com.ruoyi.web.service;

import java.util.List;
import com.ruoyi.web.domain.BawInformationOfficialLikesWx;

/**
 * 官方资讯/精彩推荐点赞Service接口
 *
 * @author ruoyi
 * @date 2022-04-19
 */
public interface IBawInformationOfficialLikesWxService
{
    /**
     * 查询官方资讯/精彩推荐点赞
     *
     * @param id 官方资讯/精彩推荐点赞主键
     * @return 官方资讯/精彩推荐点赞
     */
    public BawInformationOfficialLikesWx selectBawInformationOfficialLikesWxById(Integer id);

    /**
     * 查询官方资讯/精彩推荐点赞列表
     *
     * @param bawInformationOfficialLikesWx 官方资讯/精彩推荐点赞
     * @return 官方资讯/精彩推荐点赞集合
     */
    public List<BawInformationOfficialLikesWx> selectBawInformationOfficialLikesWxList(BawInformationOfficialLikesWx bawInformationOfficialLikesWx);

    /**
     * 新增官方资讯/精彩推荐点赞
     *
     * @param bawInformationOfficialLikesWx 官方资讯/精彩推荐点赞
     * @return 结果
     */
    public int insertBawInformationOfficialLikesWx(BawInformationOfficialLikesWx bawInformationOfficialLikesWx);

    /**
     * 修改官方资讯/精彩推荐点赞
     *
     * @param bawInformationOfficialLikesWx 官方资讯/精彩推荐点赞
     * @return 结果
     */
    public int updateBawInformationOfficialLikesWx(BawInformationOfficialLikesWx bawInformationOfficialLikesWx);

    /**
     * 批量删除官方资讯/精彩推荐点赞
     *
     * @param ids 需要删除的官方资讯/精彩推荐点赞主键集合
     * @return 结果
     */
    public int deleteBawInformationOfficialLikesWxByIds(String ids);

    /**
     * 删除官方资讯/精彩推荐点赞信息
     *
     * @param id 官方资讯/精彩推荐点赞主键
     * @return 结果
     */
    public int deleteBawInformationOfficialLikesWxById(Integer id);
}
