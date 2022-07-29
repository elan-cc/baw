package com.ruoyi.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawTechnicalSupportCommentLikesWxMapper;
import com.ruoyi.web.domain.BawTechnicalSupportCommentLikesWx;
import com.ruoyi.web.service.IBawTechnicalSupportCommentLikesWxService;
import com.ruoyi.common.core.text.Convert;

/**
 * 技术支持评论点赞Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-20
 */
@Service
public class BawTechnicalSupportCommentLikesWxServiceImpl implements IBawTechnicalSupportCommentLikesWxService 
{
    @Autowired
    private BawTechnicalSupportCommentLikesWxMapper bawTechnicalSupportCommentLikesWxMapper;

    /**
     * 查询技术支持评论点赞
     * 
     * @param id 技术支持评论点赞主键
     * @return 技术支持评论点赞
     */
    @Override
    public BawTechnicalSupportCommentLikesWx selectBawTechnicalSupportCommentLikesWxById(Integer id)
    {
        return bawTechnicalSupportCommentLikesWxMapper.selectBawTechnicalSupportCommentLikesWxById(id);
    }

    /**
     * 查询技术支持评论点赞列表
     * 
     * @param bawTechnicalSupportCommentLikesWx 技术支持评论点赞
     * @return 技术支持评论点赞
     */
    @Override
    public List<BawTechnicalSupportCommentLikesWx> selectBawTechnicalSupportCommentLikesWxList(BawTechnicalSupportCommentLikesWx bawTechnicalSupportCommentLikesWx)
    {
        return bawTechnicalSupportCommentLikesWxMapper.selectBawTechnicalSupportCommentLikesWxList(bawTechnicalSupportCommentLikesWx);
    }

    /**
     * 新增技术支持评论点赞
     * 
     * @param bawTechnicalSupportCommentLikesWx 技术支持评论点赞
     * @return 结果
     */
    @Override
    public int insertBawTechnicalSupportCommentLikesWx(BawTechnicalSupportCommentLikesWx bawTechnicalSupportCommentLikesWx)
    {
        return bawTechnicalSupportCommentLikesWxMapper.insertBawTechnicalSupportCommentLikesWx(bawTechnicalSupportCommentLikesWx);
    }

    /**
     * 修改技术支持评论点赞
     * 
     * @param bawTechnicalSupportCommentLikesWx 技术支持评论点赞
     * @return 结果
     */
    @Override
    public int updateBawTechnicalSupportCommentLikesWx(BawTechnicalSupportCommentLikesWx bawTechnicalSupportCommentLikesWx)
    {
        return bawTechnicalSupportCommentLikesWxMapper.updateBawTechnicalSupportCommentLikesWx(bawTechnicalSupportCommentLikesWx);
    }

    /**
     * 批量删除技术支持评论点赞
     * 
     * @param ids 需要删除的技术支持评论点赞主键
     * @return 结果
     */
    @Override
    public int deleteBawTechnicalSupportCommentLikesWxByIds(String ids)
    {
        return bawTechnicalSupportCommentLikesWxMapper.deleteBawTechnicalSupportCommentLikesWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除技术支持评论点赞信息
     * 
     * @param id 技术支持评论点赞主键
     * @return 结果
     */
    @Override
    public int deleteBawTechnicalSupportCommentLikesWxById(Integer id)
    {
        return bawTechnicalSupportCommentLikesWxMapper.deleteBawTechnicalSupportCommentLikesWxById(id);
    }
}
