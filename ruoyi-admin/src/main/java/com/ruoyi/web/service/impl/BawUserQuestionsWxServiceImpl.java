package com.ruoyi.web.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.domain.BawUserQuestionsWx;
import com.ruoyi.web.mapper.BawUserQuestionsWxMapper;
import com.ruoyi.web.service.IBawUserQuestionsWxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;


/**
 * 用户提问Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-20
 */
@Service
public class BawUserQuestionsWxServiceImpl implements IBawUserQuestionsWxService
{
    @Autowired
    private BawUserQuestionsWxMapper bawUserQuestionsWxMapper;

    /**
     * 查询用户提问
     *
     * @param id 用户提问主键
     * @return 用户提问
     */
    @Override
    public BawUserQuestionsWx selectBawUserQuestionsWxById(Integer id)
    {
        return bawUserQuestionsWxMapper.selectBawUserQuestionsWxById(id);
    }

    /**
     * 查询用户提问列表
     *
     * @param bawUserQuestionsWx 用户提问
     * @return 用户提问
     */
    @Override
    public List<BawUserQuestionsWx> selectBawUserQuestionsWxList(BawUserQuestionsWx bawUserQuestionsWx)
    {
        return bawUserQuestionsWxMapper.selectBawUserQuestionsWxList(bawUserQuestionsWx);
    }

    /**
     * 新增用户提问
     *
     * @param bawUserQuestionsWx 用户提问
     * @return 结果
     */
    @Override
    public int insertBawUserQuestionsWx(BawUserQuestionsWx bawUserQuestionsWx)
    {
        bawUserQuestionsWx.setCreateTime(DateUtils.getNowDate());
        return bawUserQuestionsWxMapper.insertBawUserQuestionsWx(bawUserQuestionsWx);
    }

    /**
     * 修改用户提问
     *
     * @param bawUserQuestionsWx 用户提问
     * @return 结果
     */
    @Override
    public int updateBawUserQuestionsWx(BawUserQuestionsWx bawUserQuestionsWx)
    {
        return bawUserQuestionsWxMapper.updateBawUserQuestionsWx(bawUserQuestionsWx);
    }

    /**
     * 批量删除用户提问
     *
     * @param ids 需要删除的用户提问主键
     * @return 结果
     */
    @Override
    public int deleteBawUserQuestionsWxByIds(String ids)
    {
        return bawUserQuestionsWxMapper.deleteBawUserQuestionsWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户提问信息
     *
     * @param id 用户提问主键
     * @return 结果
     */
    @Override
    public int deleteBawUserQuestionsWxById(Integer id)
    {
        return bawUserQuestionsWxMapper.deleteBawUserQuestionsWxById(id);
    }
}
