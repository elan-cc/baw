package com.ruoyi.web.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.domain.BawActivityRegistrationWx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 活动报名Service接口
 *
 * @author ruoyi
 * @date 2022-03-17
 */
public interface IBawActivityRegistrationWxService
{
    /**
     * 查询活动报名
     *
     * @param id 活动报名主键
     * @return 活动报名
     */
    public BawActivityRegistrationWx selectBawActivityRegistrationWxById(Integer id);

    /**
     * 查询活动报名列表
     *
     * @param bawActivityRegistrationWx 活动报名
     * @return 活动报名集合
     */
    public List<BawActivityRegistrationWx> selectBawActivityRegistrationWxList(BawActivityRegistrationWx bawActivityRegistrationWx);

    /**
     * 新增活动报名
     *
     * @param bawActivityRegistrationWx 活动报名
     * @return 结果
     */
    public AjaxResult insertBawActivityRegistrationWx(BawActivityRegistrationWx bawActivityRegistrationWx);

    /**
     * 修改活动报名
     *
     * @param bawActivityRegistrationWx 活动报名
     * @return 结果
     */
    public int updateBawActivityRegistrationWx(BawActivityRegistrationWx bawActivityRegistrationWx);

    /**
     * 批量删除活动报名
     *
     * @param ids 需要删除的活动报名主键集合
     * @return 结果
     */
    public int deleteBawActivityRegistrationWxByIds(String ids);

    /**
     * 删除活动报名信息
     *
     * @param id 活动报名主键
     * @return 结果
     */
    public int deleteBawActivityRegistrationWxById(Integer id);
    
    /**
     * 通过活动id和手机号查询活动报名信息
     * @param activityId 活动id
     * @param phone 手机号码
     * @return
     */
    public BawActivityRegistrationWx selectByPhone(Integer activityId, String phone);
}
