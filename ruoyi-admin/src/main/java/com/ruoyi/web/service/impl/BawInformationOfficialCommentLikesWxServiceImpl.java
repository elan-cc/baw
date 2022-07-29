package com.ruoyi.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawInformationOfficialCommentLikesWxMapper;
import com.ruoyi.web.domain.BawInformationOfficialCommentLikesWx;
import com.ruoyi.web.service.IBawInformationOfficialCommentLikesWxService;
import com.ruoyi.common.core.text.Convert;

/**
 * 官方资讯评论点赞Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-19
 */
@Service
public class BawInformationOfficialCommentLikesWxServiceImpl implements IBawInformationOfficialCommentLikesWxService 
{
    @Autowired
    private BawInformationOfficialCommentLikesWxMapper bawInformationOfficialCommentLikesWxMapper;

    /**
     * 查询官方资讯评论点赞
     * 
     * @param id 官方资讯评论点赞主键
     * @return 官方资讯评论点赞
     */
    @Override
    public BawInformationOfficialCommentLikesWx selectBawInformationOfficialCommentLikesWxById(Integer id)
    {
        return bawInformationOfficialCommentLikesWxMapper.selectBawInformationOfficialCommentLikesWxById(id);
    }

    /**
     * 查询官方资讯评论点赞列表
     * 
     * @param bawInformationOfficialCommentLikesWx 官方资讯评论点赞
     * @return 官方资讯评论点赞
     */
    @Override
    public List<BawInformationOfficialCommentLikesWx> selectBawInformationOfficialCommentLikesWxList(BawInformationOfficialCommentLikesWx bawInformationOfficialCommentLikesWx)
    {
        return bawInformationOfficialCommentLikesWxMapper.selectBawInformationOfficialCommentLikesWxList(bawInformationOfficialCommentLikesWx);
    }

    /**
     * 新增官方资讯评论点赞
     * 
     * @param bawInformationOfficialCommentLikesWx 官方资讯评论点赞
     * @return 结果
     */
    @Override
    public int insertBawInformationOfficialCommentLikesWx(BawInformationOfficialCommentLikesWx bawInformationOfficialCommentLikesWx)
    {
        return bawInformationOfficialCommentLikesWxMapper.insertBawInformationOfficialCommentLikesWx(bawInformationOfficialCommentLikesWx);
    }

    /**
     * 修改官方资讯评论点赞
     * 
     * @param bawInformationOfficialCommentLikesWx 官方资讯评论点赞
     * @return 结果
     */
    @Override
    public int updateBawInformationOfficialCommentLikesWx(BawInformationOfficialCommentLikesWx bawInformationOfficialCommentLikesWx)
    {
        return bawInformationOfficialCommentLikesWxMapper.updateBawInformationOfficialCommentLikesWx(bawInformationOfficialCommentLikesWx);
    }

    /**
     * 批量删除官方资讯评论点赞
     * 
     * @param ids 需要删除的官方资讯评论点赞主键
     * @return 结果
     */
    @Override
    public int deleteBawInformationOfficialCommentLikesWxByIds(String ids)
    {
        return bawInformationOfficialCommentLikesWxMapper.deleteBawInformationOfficialCommentLikesWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除官方资讯评论点赞信息
     * 
     * @param id 官方资讯评论点赞主键
     * @return 结果
     */
    @Override
    public int deleteBawInformationOfficialCommentLikesWxById(Integer id)
    {
        return bawInformationOfficialCommentLikesWxMapper.deleteBawInformationOfficialCommentLikesWxById(id);
    }
}
