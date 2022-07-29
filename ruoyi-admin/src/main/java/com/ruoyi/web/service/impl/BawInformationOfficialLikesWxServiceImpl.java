package com.ruoyi.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawInformationOfficialLikesWxMapper;
import com.ruoyi.web.domain.BawInformationOfficialLikesWx;
import com.ruoyi.web.service.IBawInformationOfficialLikesWxService;
import com.ruoyi.common.core.text.Convert;

/**
 * 官方资讯/精彩推荐点赞Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-19
 */
@Service
public class BawInformationOfficialLikesWxServiceImpl implements IBawInformationOfficialLikesWxService
{
    @Autowired
    private BawInformationOfficialLikesWxMapper bawInformationOfficialLikesWxMapper;

    /**
     * 查询官方资讯/精彩推荐点赞
     *
     * @param id 官方资讯/精彩推荐点赞主键
     * @return 官方资讯/精彩推荐点赞
     */
    @Override
    public BawInformationOfficialLikesWx selectBawInformationOfficialLikesWxById(Integer id)
    {
        return bawInformationOfficialLikesWxMapper.selectBawInformationOfficialLikesWxById(id);
    }

    /**
     * 查询官方资讯/精彩推荐点赞列表
     *
     * @param bawInformationOfficialLikesWx 官方资讯/精彩推荐点赞
     * @return 官方资讯/精彩推荐点赞
     */
    @Override
    public List<BawInformationOfficialLikesWx> selectBawInformationOfficialLikesWxList(BawInformationOfficialLikesWx bawInformationOfficialLikesWx)
    {
        return bawInformationOfficialLikesWxMapper.selectBawInformationOfficialLikesWxList(bawInformationOfficialLikesWx);
    }

    /**
     * 新增官方资讯/精彩推荐点赞
     *
     * @param bawInformationOfficialLikesWx 官方资讯/精彩推荐点赞
     * @return 结果
     */
    @Override
    public int insertBawInformationOfficialLikesWx(BawInformationOfficialLikesWx bawInformationOfficialLikesWx)
    {
        return bawInformationOfficialLikesWxMapper.insertBawInformationOfficialLikesWx(bawInformationOfficialLikesWx);
    }

    /**
     * 修改官方资讯/精彩推荐点赞
     *
     * @param bawInformationOfficialLikesWx 官方资讯/精彩推荐点赞
     * @return 结果
     */
    @Override
    public int updateBawInformationOfficialLikesWx(BawInformationOfficialLikesWx bawInformationOfficialLikesWx)
    {
        return bawInformationOfficialLikesWxMapper.updateBawInformationOfficialLikesWx(bawInformationOfficialLikesWx);
    }

    /**
     * 批量删除官方资讯/精彩推荐点赞
     *
     * @param ids 需要删除的官方资讯/精彩推荐点赞主键
     * @return 结果
     */
    @Override
    public int deleteBawInformationOfficialLikesWxByIds(String ids)
    {
        return bawInformationOfficialLikesWxMapper.deleteBawInformationOfficialLikesWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除官方资讯/精彩推荐点赞信息
     *
     * @param id 官方资讯/精彩推荐点赞主键
     * @return 结果
     */
    @Override
    public int deleteBawInformationOfficialLikesWxById(Integer id)
    {
        return bawInformationOfficialLikesWxMapper.deleteBawInformationOfficialLikesWxById(id);
    }
}
