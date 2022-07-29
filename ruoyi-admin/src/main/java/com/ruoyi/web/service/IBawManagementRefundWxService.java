package com.ruoyi.web.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.domain.BawManagementRefundWx;

import java.util.List;

/**
 * 退款单Service接口
 *
 * @author ruoyi
 * @date 2022-05-20
 */
public interface IBawManagementRefundWxService
{
    /**
     * 查询退款单
     *
     * @param id 退款单主键
     * @return 退款单
     */
    public BawManagementRefundWx selectBawManagementRefundWxById(Integer id);

    /**
     * 查询退款单列表
     *
     * @param bawManagementRefundWx 退款单
     * @return 退款单集合
     */
    public List<BawManagementRefundWx> selectBawManagementRefundWxList(BawManagementRefundWx bawManagementRefundWx);

    /**
     * 新增退款单
     *
     * @param bawManagementRefundWx 退款单
     * @return 结果
     */
    public int insertBawManagementRefundWx(BawManagementRefundWx bawManagementRefundWx);

    /**
     * 修改退款单
     *
     * @param bawManagementRefundWx 退款单
     * @return 结果
     */
    public int updateBawManagementRefundWx(BawManagementRefundWx bawManagementRefundWx);

    /**
     * 批量删除退款单
     *
     * @param ids 需要删除的退款单主键集合
     * @return 结果
     */
    public int deleteBawManagementRefundWxByIds(String ids);

    /**
     * 删除退款单信息
     *
     * @param id 退款单主键
     * @return 结果
     */
    public int deleteBawManagementRefundWxById(Integer id);

    /**
     * 审核退款
     * @param id 退款单id
     * @param loginName 用户登录名
     * @return
     */
    public AjaxResult examine(Integer id, String loginName);



    public AjaxResult reject(Integer id,  String loginName);
}
