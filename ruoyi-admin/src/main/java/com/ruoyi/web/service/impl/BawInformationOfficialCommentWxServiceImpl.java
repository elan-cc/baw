package com.ruoyi.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawInformationOfficialCommentWxMapper;
import com.ruoyi.web.domain.BawInformationOfficialCommentWx;
import com.ruoyi.web.service.IBawInformationOfficialCommentWxService;
import com.ruoyi.common.core.text.Convert;

/**
 * 官方资讯评论Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-19
 */
@Service
public class BawInformationOfficialCommentWxServiceImpl implements IBawInformationOfficialCommentWxService 
{
    @Autowired
    private BawInformationOfficialCommentWxMapper bawInformationOfficialCommentWxMapper;

    /**
     * 查询官方资讯评论
     * 
     * @param id 官方资讯评论主键
     * @return 官方资讯评论
     */
    @Override
    public BawInformationOfficialCommentWx selectBawInformationOfficialCommentWxById(Integer id)
    {
        return bawInformationOfficialCommentWxMapper.selectBawInformationOfficialCommentWxById(id);
    }

    /**
     * 查询官方资讯评论列表
     * 
     * @param bawInformationOfficialCommentWx 官方资讯评论
     * @return 官方资讯评论
     */
    @Override
    public List<BawInformationOfficialCommentWx> selectBawInformationOfficialCommentWxList(BawInformationOfficialCommentWx bawInformationOfficialCommentWx)
    {
        return bawInformationOfficialCommentWxMapper.selectBawInformationOfficialCommentWxList(bawInformationOfficialCommentWx);
    }

    /**
     * 新增官方资讯评论
     * 
     * @param bawInformationOfficialCommentWx 官方资讯评论
     * @return 结果
     */
    @Override
    public int insertBawInformationOfficialCommentWx(BawInformationOfficialCommentWx bawInformationOfficialCommentWx)
    {
        return bawInformationOfficialCommentWxMapper.insertBawInformationOfficialCommentWx(bawInformationOfficialCommentWx);
    }

    /**
     * 修改官方资讯评论
     * 
     * @param bawInformationOfficialCommentWx 官方资讯评论
     * @return 结果
     */
    @Override
    public int updateBawInformationOfficialCommentWx(BawInformationOfficialCommentWx bawInformationOfficialCommentWx)
    {
        return bawInformationOfficialCommentWxMapper.updateBawInformationOfficialCommentWx(bawInformationOfficialCommentWx);
    }

    /**
     * 批量删除官方资讯评论
     * 
     * @param ids 需要删除的官方资讯评论主键
     * @return 结果
     */
    @Override
    public int deleteBawInformationOfficialCommentWxByIds(String ids)
    {
        return bawInformationOfficialCommentWxMapper.deleteBawInformationOfficialCommentWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除官方资讯评论信息
     * 
     * @param id 官方资讯评论主键
     * @return 结果
     */
    @Override
    public int deleteBawInformationOfficialCommentWxById(Integer id)
    {
        return bawInformationOfficialCommentWxMapper.deleteBawInformationOfficialCommentWxById(id);
    }
}
