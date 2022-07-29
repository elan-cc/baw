package com.ruoyi.wx.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.web.domain.BawMessageCenterWx;
import com.ruoyi.web.mapper.BawMessageCenterWxMapper;
import com.ruoyi.web.service.IBawMessageCenterWxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;
import org.springframework.ui.ModelMap;

/**
 * 消息中心Service业务层处理
 *
 * @author ruoyi
 * @date 2022-06-10
 */
@Service
public class BawMessageCenterWxServiceImpl implements IBawMessageCenterWxService
{
    @Autowired
    private BawMessageCenterWxMapper bawMessageCenterWxMapper;

    /**
     * 查询消息中心
     *
     * @param id 消息中心主键
     * @return 消息中心
     */
    @Override
    public BawMessageCenterWx selectBawMessageCenterWxById(Integer id)
    {
        return bawMessageCenterWxMapper.selectBawMessageCenterWxById(id);
    }

    /**
     * 查询消息中心列表
     *
     * @param bawMessageCenterWx 消息中心
     * @return 消息中心
     */
    @Override
    public List<BawMessageCenterWx> selectBawMessageCenterWxList(BawMessageCenterWx bawMessageCenterWx)
    {
        return bawMessageCenterWxMapper.selectBawMessageCenterWxList(bawMessageCenterWx);
    }

    /**
     * 新增消息中心
     *
     * @param bawMessageCenterWx 消息中心
     * @return 结果
     */
    @Override
    public int insertBawMessageCenterWx(BawMessageCenterWx bawMessageCenterWx)
    {
        bawMessageCenterWx.setUserId(0);
        bawMessageCenterWx.setCraeteTime(new Date());
        return bawMessageCenterWxMapper.insertBawMessageCenterWx(bawMessageCenterWx);
    }

    /**
     * 修改消息中心
     *
     * @param bawMessageCenterWx 消息中心
     * @return 结果
     */
    @Override
    public int updateBawMessageCenterWx(BawMessageCenterWx bawMessageCenterWx)
    {
        return bawMessageCenterWxMapper.updateBawMessageCenterWx(bawMessageCenterWx);
    }

    /**
     * 批量删除消息中心
     *
     * @param ids 需要删除的消息中心主键
     * @return 结果
     */
    @Override
    public int deleteBawMessageCenterWxByIds(String ids)
    {
        return bawMessageCenterWxMapper.deleteBawMessageCenterWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除消息中心信息
     *
     * @param id 消息中心主键
     * @return 结果
     */
    @Override
    public int deleteBawMessageCenterWxById(Integer id)
    {
        return bawMessageCenterWxMapper.deleteBawMessageCenterWxById(id);
    }

    /**
     * 查询消息中心列表
     * @param userId 用户id
     * @return
     */
    @Override
    public List<ModelMap> slectList(Integer userId) {
        List<ModelMap> modelMaps = bawMessageCenterWxMapper.slectList(userId);
        return modelMaps;
    }
}
