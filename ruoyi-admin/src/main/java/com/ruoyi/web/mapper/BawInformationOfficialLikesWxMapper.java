package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.BawInformationOfficialLikesWx;
import org.apache.ibatis.annotations.Param;

/**
 * 官方资讯点赞Mapper接口
 * 
 * @author ruoyi
 * @date 2022-04-19
 */
public interface BawInformationOfficialLikesWxMapper 
{
    /**
     * 查询官方资讯点赞
     * 
     * @param id 官方资讯点赞主键
     * @return 官方资讯点赞
     */
    public BawInformationOfficialLikesWx selectBawInformationOfficialLikesWxById(Integer id);

    /**
     * 查询官方资讯点赞列表
     * 
     * @param bawInformationOfficialLikesWx 官方资讯点赞
     * @return 官方资讯点赞集合
     */
    public List<BawInformationOfficialLikesWx> selectBawInformationOfficialLikesWxList(BawInformationOfficialLikesWx bawInformationOfficialLikesWx);

    /**
     * 新增官方资讯点赞
     * 
     * @param bawInformationOfficialLikesWx 官方资讯点赞
     * @return 结果
     */
    public int insertBawInformationOfficialLikesWx(BawInformationOfficialLikesWx bawInformationOfficialLikesWx);

    /**
     * 修改官方资讯点赞
     * 
     * @param bawInformationOfficialLikesWx 官方资讯点赞
     * @return 结果
     */
    public int updateBawInformationOfficialLikesWx(BawInformationOfficialLikesWx bawInformationOfficialLikesWx);

    /**
     * 删除官方资讯点赞
     * 
     * @param id 官方资讯点赞主键
     * @return 结果
     */
    public int deleteBawInformationOfficialLikesWxById(Integer id);

    /**
     * 批量删除官方资讯点赞
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBawInformationOfficialLikesWxByIds(String[] ids);

    /**
     * 查询数量
     * @param infoOfficalId 咨询id
     * @param userId 用户id
     * @return
     */
    int selectCountByInfoOfficalIdAndUserId(@Param("infoOfficalId") Integer infoOfficalId, @Param("userId") Integer userId);
}
