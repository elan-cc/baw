package com.ruoyi.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawTechnicalSupportCommentWxMapper;
import com.ruoyi.web.domain.BawTechnicalSupportCommentWx;
import com.ruoyi.web.service.IBawTechnicalSupportCommentWxService;
import com.ruoyi.common.core.text.Convert;

/**
 * 技术支持评论Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-04-20
 */
@Service
public class BawTechnicalSupportCommentWxServiceImpl implements IBawTechnicalSupportCommentWxService 
{
    @Autowired
    private BawTechnicalSupportCommentWxMapper bawTechnicalSupportCommentWxMapper;

    /**
     * 查询技术支持评论
     * 
     * @param id 技术支持评论主键
     * @return 技术支持评论
     */
    @Override
    public BawTechnicalSupportCommentWx selectBawTechnicalSupportCommentWxById(Integer id)
    {
        return bawTechnicalSupportCommentWxMapper.selectBawTechnicalSupportCommentWxById(id);
    }

    /**
     * 查询技术支持评论列表
     * 
     * @param bawTechnicalSupportCommentWx 技术支持评论
     * @return 技术支持评论
     */
    @Override
    public List<BawTechnicalSupportCommentWx> selectBawTechnicalSupportCommentWxList(BawTechnicalSupportCommentWx bawTechnicalSupportCommentWx)
    {
        return bawTechnicalSupportCommentWxMapper.selectBawTechnicalSupportCommentWxList(bawTechnicalSupportCommentWx);
    }

    /**
     * 新增技术支持评论
     * 
     * @param bawTechnicalSupportCommentWx 技术支持评论
     * @return 结果
     */
    @Override
    public int insertBawTechnicalSupportCommentWx(BawTechnicalSupportCommentWx bawTechnicalSupportCommentWx)
    {
        return bawTechnicalSupportCommentWxMapper.insertBawTechnicalSupportCommentWx(bawTechnicalSupportCommentWx);
    }

    /**
     * 修改技术支持评论
     * 
     * @param bawTechnicalSupportCommentWx 技术支持评论
     * @return 结果
     */
    @Override
    public int updateBawTechnicalSupportCommentWx(BawTechnicalSupportCommentWx bawTechnicalSupportCommentWx)
    {
        return bawTechnicalSupportCommentWxMapper.updateBawTechnicalSupportCommentWx(bawTechnicalSupportCommentWx);
    }

    /**
     * 批量删除技术支持评论
     * 
     * @param ids 需要删除的技术支持评论主键
     * @return 结果
     */
    @Override
    public int deleteBawTechnicalSupportCommentWxByIds(String ids)
    {
        return bawTechnicalSupportCommentWxMapper.deleteBawTechnicalSupportCommentWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除技术支持评论信息
     * 
     * @param id 技术支持评论主键
     * @return 结果
     */
    @Override
    public int deleteBawTechnicalSupportCommentWxById(Integer id)
    {
        return bawTechnicalSupportCommentWxMapper.deleteBawTechnicalSupportCommentWxById(id);
    }
}
