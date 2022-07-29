package com.ruoyi.web.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.controller.wx.utils.WeChatPayUtil;
import com.ruoyi.web.domain.BawManagementRefundWx;
import com.ruoyi.web.domain.BawMessageCenterWx;
import com.ruoyi.web.domain.BawOrderManagement;
import com.ruoyi.web.mapper.BawManagementRefundWxMapper;
import com.ruoyi.web.mapper.BawMessageCenterWxMapper;
import com.ruoyi.web.mapper.BawOrderManagementMapper;
import com.ruoyi.web.service.IBawManagementRefundWxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 退款单Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-20
 */
@Service
public class BawManagementRefundWxServiceImpl implements IBawManagementRefundWxService
{

    private static final Logger log = LoggerFactory.getLogger(BawManagementRefundWxServiceImpl.class);
    @Autowired
    private BawManagementRefundWxMapper bawManagementRefundWxMapper;
    @Autowired
    private BawOrderManagementMapper bawOrderManagementMapper;
    @Autowired
    private BawMessageCenterWxMapper bawMessageCenterWxMapper;

    /**
     * 查询退款单
     *
     * @param id 退款单主键
     * @return 退款单
     */
    @Override
    public BawManagementRefundWx selectBawManagementRefundWxById(Integer id)
    {
        return bawManagementRefundWxMapper.selectBawManagementRefundWxById(id);
    }

    /**
     * 查询退款单列表
     *
     * @param bawManagementRefundWx 退款单
     * @return 退款单
     */
    @Override
    public List<BawManagementRefundWx> selectBawManagementRefundWxList(BawManagementRefundWx bawManagementRefundWx)
    {
        return bawManagementRefundWxMapper.selectBawManagementRefundWxList(bawManagementRefundWx);
    }

    /**
     * 新增退款单
     *
     * @param bawManagementRefundWx 退款单
     * @return 结果
     */
    @Override
    public int insertBawManagementRefundWx(BawManagementRefundWx bawManagementRefundWx)
    {
        return bawManagementRefundWxMapper.insertBawManagementRefundWx(bawManagementRefundWx);
    }

    /**
     * 修改退款单
     *
     * @param bawManagementRefundWx 退款单
     * @return 结果
     */
    @Override
    public int updateBawManagementRefundWx(BawManagementRefundWx bawManagementRefundWx)
    {
        return bawManagementRefundWxMapper.updateBawManagementRefundWx(bawManagementRefundWx);
    }

    /**
     * 批量删除退款单
     *
     * @param ids 需要删除的退款单主键
     * @return 结果
     */
    @Override
    public int deleteBawManagementRefundWxByIds(String ids)
    {
        return bawManagementRefundWxMapper.deleteBawManagementRefundWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除退款单信息
     *
     * @param id 退款单主键
     * @return 结果
     */
    @Override
    public int deleteBawManagementRefundWxById(Integer id)
    {
        return bawManagementRefundWxMapper.deleteBawManagementRefundWxById(id);
    }

    /**
     * 审核退款单
     * @param id 退款单id
     * @param loginName 用户登录名
     * @return
     */
    @Override
    public AjaxResult examine(Integer id, String loginName) {
        BawManagementRefundWx bawManagementRefundWx = bawManagementRefundWxMapper.selectBawManagementRefundWxById(id);
        bawManagementRefundWx.setReviewer(loginName);
        bawManagementRefundWx.setApprovalTime(new Date());
        if (StringUtils.isNull(bawManagementRefundWx)){
            return AjaxResult.error("退款单不存在！");
        }
        BawOrderManagement bawOrderManagement = bawOrderManagementMapper.selectBawOrderManagementById(bawManagementRefundWx.getManagementId());
        if (StringUtils.isNull(bawOrderManagement)){
            return AjaxResult.error("相关订单信息不存在！");
        }
        if (bawManagementRefundWx.getRefundStatus().equals(1) || bawManagementRefundWx.getRefundStatus().equals(3)){
            // 调用微信支付退款接口
            WeChatPayUtil weChatPayUtil = new WeChatPayUtil();
            Map<String, String> wxRefund = weChatPayUtil.wxRefund(bawManagementRefundWx.getManagementNumber(), bawManagementRefundWx.getRefundNumber(), bawManagementRefundWx.getManagementMoney(), bawManagementRefundWx.getRefundMoney());
            log.info("微信退款返回 ：" + wxRefund);
            String return_code = wxRefund.get("return_code");
            if (return_code.equals("SUCCESS")){
                String result_code = wxRefund.get("result_code");
                if (result_code.equals("SUCCESS")) {
                    // 查询微信退款
                    Map<String, String> refundQuery = weChatPayUtil.refundQuery(bawManagementRefundWx.getManagementNumber());
                    log.info("微信退款查询返回 ：" + refundQuery);
                    if (StringUtils.isNotBlank(refundQuery.get("return_code"))){
                        if ("SUCCESS".equals(refundQuery.get("return_code"))){
                            if ("SUCCESS".equals(refundQuery.get("result_code"))){
                                // 成功 设置退款单状态
                                bawManagementRefundWx.setRefundStatus(2);
                                bawManagementRefundWxMapper.updateBawManagementRefundWx(bawManagementRefundWx);
                                // 设置 通过订单id查询订单信息，修改订单状态为已退款(5)、退款金额、剩余金额
                                bawOrderManagement.setOrderStatus("5");
                                Integer refundMoney = StringUtils.isNotNull(bawOrderManagement.getRefundMoney()) ? bawOrderManagement.getRefundMoney() : 0;
                                bawOrderManagement.setRefundMoney(refundMoney + bawManagementRefundWx.getRefundMoney());
                                Integer remainingAmount = StringUtils.isNotNull(bawOrderManagement.getRemainingAmount()) ?  bawOrderManagement.getRemainingAmount():bawOrderManagement.getPrice();
                                remainingAmount = remainingAmount - refundMoney;
                                bawOrderManagement.setRemainingAmount(remainingAmount);
                                bawOrderManagementMapper.updateBawOrderManagement(bawOrderManagement);
                                BawMessageCenterWx bawMessageCenterWx = new BawMessageCenterWx();
                                bawMessageCenterWx.setReminderContent("您的订单：" + bawOrderManagement.getCarSeriesName() + "退款成功！");
                                bawMessageCenterWx.setUserId(bawOrderManagement.getUserId());
                                bawMessageCenterWx.setCraeteTime(new Date());
                                bawMessageCenterWx.setAmount(bawOrderManagement.getPrice());
                                bawMessageCenterWx.setName("退款成功！");
                                bawMessageCenterWxMapper.insertBawMessageCenterWx(bawMessageCenterWx);
                                return AjaxResult.success("退款成功！");
                            }else if (StringUtils.isNotBlank(refundQuery.get("err_code"))){
                                return AjaxResult.error("失败，请重试！");
                            }
                        } else {
                            return AjaxResult.error("失败，请重试！");
                        }
                    } else {
                        return AjaxResult.error("失败，请重试！");
                    }

                } else if (StringUtils.isNotBlank(wxRefund.get("err_code"))){
                    // 失败，封装失败原因
                    String errorMsg = refundFailed(wxRefund.get("err_code"));
                    bawManagementRefundWx.setRefundStatus(3);
                    bawManagementRefundWx.setFailureReason(errorMsg);
                    bawManagementRefundWxMapper.updateBawManagementRefundWx(bawManagementRefundWx);
                    return AjaxResult.error("失败！");
                }
            } else {
                // 失败 封装失败原因
                bawManagementRefundWx.setRefundStatus(3);
                bawManagementRefundWx.setFailureReason(wxRefund.get("return_msg"));
                bawManagementRefundWxMapper.updateBawManagementRefundWx(bawManagementRefundWx);
                return AjaxResult.error("失败！");
            }
        } else {
            return AjaxResult.error("当前退款单状态不是【申请退款】或【退款失败】");
        }
       return AjaxResult.error("失败，请重试！");
    }

    /**
     * 退款单驳回
     * @param id 退款单id
     * @param loginName 用户登录名
     * @return
     */
    @Override
    public AjaxResult reject(Integer id,String loginName) {
        BawManagementRefundWx bawManagementRefundWx = bawManagementRefundWxMapper.selectBawManagementRefundWxById(id);
        bawManagementRefundWx.setRefundStatus(4);
        bawManagementRefundWx.setReviewer(loginName);
        bawManagementRefundWx.setApprovalTime(new Date());
        bawManagementRefundWxMapper.updateBawManagementRefundWx(bawManagementRefundWx);
        if (bawManagementRefundWx.getRefundStatus() == 4){
            BawOrderManagement bawOrderManagement = bawOrderManagementMapper.selectBawOrderManagementById(bawManagementRefundWx.getManagementId());
            bawOrderManagement.setOrderStatus("6");
            bawOrderManagementMapper.updateBawOrderManagement(bawOrderManagement);
            BawMessageCenterWx bawMessageCenterWx = new BawMessageCenterWx();
            bawMessageCenterWx.setReminderContent("您的订单：" +bawOrderManagement.getCarSeriesName() + "退款失败");
            bawMessageCenterWx.setName("退款失败！");
            bawMessageCenterWx.setAmount(bawOrderManagement.getPrice());
            bawMessageCenterWx.setCraeteTime(new Date());
            bawMessageCenterWx.setUserId(bawOrderManagement.getUserId());
            bawMessageCenterWxMapper.insertBawMessageCenterWx(bawMessageCenterWx);
        }
        return AjaxResult.success("驳回成功");
    }


    public static String refundFailed(String err_code){
        switch (err_code){
            case "SYSTEMERROR":
                return String.format("描述：%s；原因：%s；解决方案：%s", "接口返回错误", "系统超时等", "请重新审核退款单。");
            case "BIZERR_NEED_RETRY":
                return String.format("描述：%s；原因：%s；解决方案：%s", "退款业务流程错误，需要触发重试来解决", "并发情况下，业务被拒绝，重试即可解决", "请重新审核退款单。");
            case "TRADE_OVERDUE":
                return String.format("描述：%s；原因：%s；解决方案：%s", "订单已经超过退款期限", "订单已经超过可退款的最大期限(支付后一年内可退款)", "请选择其他方式自行退款。");
            case "ERROR":
                return String.format("描述：%s；原因：%s；解决方案：%s", "业务错误", "申请退款业务发生错误", "该错误都会返回具体的错误原因，请根据实际返回做相应处理。");
            case "USER_ACCOUNT_ABNORMAL":
                return String.format("描述：%s；原因：%s；解决方案：%s", "退款请求失败", "用户账号注销", "此状态代表退款申请失败，商户可自行处理退款。");
            case "INVALID_REQ_TOO_MUCH":
                return String.format("描述：%s；原因：%s；解决方案：%s", "无效请求过多", "连续错误请求数过多被系统短暂屏蔽", "请检查业务是否正常，确认业务正常后请在1分钟后再来重试。");
            case "NOTENOUGH":
                return String.format("描述：%s；原因：%s；解决方案：%s", "余额不足", "商户可用退款余额不足", "此状态代表退款申请失败，商户可根据具体的错误提示做相应的处理。");
            case "FREQUENCY_LIMITED":
                return String.format("描述：%s；原因：%s；解决方案：%s", "频率限制", "1个月之前的订单申请退款有频率限制", "该笔退款未受理，请降低频率后重试。");
            case "CERT_ERROR":
                return String.format("描述：%s；原因：%s；解决方案：%s", "证书校验错误", "请检查证书是否正确，证书是否过期或作废。", "请检查证书是否正确，证书是否过期或作废。。");
            case "REFUND_FEE_MISMATCH":
                return String.format("描述：%s；原因：%s；解决方案：%s", "订单金额或退款金额与之前请求不一致，请核实后再试", "订单金额或退款金额与之前请求不一致，请核实后再试", "订单金额或退款金额与之前请求不一致，请核实后再试。");
            case "ORDER_NOT_READY":
                return String.format("描述：%s；原因：%s；解决方案：%s", "订单处理中，暂时无法退款，请稍后再试", "订单处理中，暂时无法退款，请稍后再试  ", "订单处理中，暂时无法退款，请稍后再试。");
        }
        return null;
    }
}
