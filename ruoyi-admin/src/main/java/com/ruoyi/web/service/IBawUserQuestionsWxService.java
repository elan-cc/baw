package com.ruoyi.web.service;

import com.ruoyi.web.domain.BawUserQuestionsWx;

import java.util.List;


/**
 * 用户提问Service接口
 *
 * @author ruoyi
 * @date 2022-04-20
 */
public interface IBawUserQuestionsWxService
{
    /**
     * 查询用户提问
     *
     * @param id 用户提问主键
     * @return 用户提问
     */
    public BawUserQuestionsWx selectBawUserQuestionsWxById(Integer id);

    /**
     * 查询用户提问列表
     *
     * @param bawUserQuestionsWx 用户提问
     * @return 用户提问集合
     */
    public List<BawUserQuestionsWx> selectBawUserQuestionsWxList(BawUserQuestionsWx bawUserQuestionsWx);

    /**
     * 新增用户提问
     *
     * @param bawUserQuestionsWx 用户提问
     * @return 结果
     */
    public int insertBawUserQuestionsWx(BawUserQuestionsWx bawUserQuestionsWx);

    /**
     * 修改用户提问
     *
     * @param bawUserQuestionsWx 用户提问
     * @return 结果
     */
    public int updateBawUserQuestionsWx(BawUserQuestionsWx bawUserQuestionsWx);

    /**
     * 批量删除用户提问
     *
     * @param ids 需要删除的用户提问主键集合
     * @return 结果
     */
    public int deleteBawUserQuestionsWxByIds(String ids);

    /**
     * 删除用户提问信息
     *
     * @param id 用户提问主键
     * @return 结果
     */
    public int deleteBawUserQuestionsWxById(Integer id);
}
