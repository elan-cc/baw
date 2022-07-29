package com.ruoyi.web.service;

import java.text.ParseException;
import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.domain.BawManagementRefundWx;
import com.ruoyi.web.domain.BawOrderManagement;
import org.aspectj.weaver.loadtime.Aj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 订单管理Service接口
 *
 * @author ruoyi
 * @date 2022-05-06
 */
public interface IBawOrderManagementService
{
    /**
     * 查询订单管理
     *
     * @param id 订单管理主键
     * @return 订单管理
     */
    public BawOrderManagement selectBawOrderManagementById(Integer id);

    /**
     * 查询订单管理列表
     *
     * @param bawOrderManagement 订单管理
     * @return 订单管理集合
     */
    public List<BawOrderManagement> selectBawOrderManagementList(BawOrderManagement bawOrderManagement);

    /**
     * 新增订单管理
     *
     * @param bawOrderManagement 订单管理
     * @return 结果
     */
    public int insertBawOrderManagement(BawOrderManagement bawOrderManagement);

    /**
     * 修改订单管理
     *
     * @param bawOrderManagement 订单管理
     * @return 结果
     */
    public int updateBawOrderManagement(BawOrderManagement bawOrderManagement);

    /**
     * 批量删除订单管理
     *
     * @param ids 需要删除的订单管理主键集合
     * @return 结果
     */
    public int deleteBawOrderManagementByIds(String ids);

    /**
     * 删除订单管理信息
     *
     * @param id 订单管理主键
     * @return 结果
     */
    public int deleteBawOrderManagementById(Integer id);
    
    /**
     * 生成订单并返回微信支付参数
     * @param bawOrderManagement 订单信息
     * @return
     */
    public AjaxResult saveOrderAndWeChatPay(BawOrderManagement bawOrderManagement, String openId);
    
    /**
     * 支付
     * @param amount 价格
     * @param orderId 订单id
     * @param userId
     * @return
     */
    public AjaxResult toPay(String amount, Integer orderId, Integer userId, String openId);
    
    /**
     * 支付结果返回
     * @param id 订单id
     * @param result 结果（0：成功；1：失败）
     * @param userId 用户id
     * @return
     */
    public AjaxResult payResult(Integer id, Integer result, Integer userId);
    
    /**
     * 订单删除
     * @param id 订单id
     * @param userId 用户id
     * @return
     */
    public AjaxResult deleteOrder(Integer id, Integer userId);
    
    /**
     * 微信支付回调
     * @param request
     * @param response
     */
    public void wxPayCallBack(HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    /**
     * 测试：查询订单状态为未支付，通过订单编号调用微信查询订单状态，如果是 REFUND（转入退款）/SUCCESS（支付成功）
     * @return
     */
    public AjaxResult queryOrderTest() throws ParseException;
    
    /**
     * 小程序用户申请退款
     * @param bawManagementRefundWx 退款单信息
     * @return
     */
    public AjaxResult requestARefund(BawManagementRefundWx bawManagementRefundWx);
    
    /**
     * 去退款
     * @param orderId 订单id
     * @param userId 用户id
     * @return
     */
    public  AjaxResult toRefund(Integer orderId, Integer userId);
}
