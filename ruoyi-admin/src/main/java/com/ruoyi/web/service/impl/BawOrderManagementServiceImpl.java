package com.ruoyi.web.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.controller.wx.utils.WeChatPayUtil;
import com.ruoyi.web.domain.BawManagementRefundWx;
import com.ruoyi.web.domain.BawMessageCenterWx;
import com.ruoyi.web.mapper.BawManagementRefundWxMapper;
import com.ruoyi.web.mapper.BawMessageCenterWxMapper;
import com.ruoyi.web.mapper.BawOrderManagementMapper;
import com.ruoyi.web.service.IBawOrderManagementService;
import net.sf.jsqlparser.statement.select.Pivot;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.domain.BawOrderManagement;

import com.ruoyi.common.core.text.Convert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 订单管理Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-06
 */
@Service
public class BawOrderManagementServiceImpl implements IBawOrderManagementService
{
    @Autowired
    private BawOrderManagementMapper bawOrderManagementMapper;
    @Autowired
    private BawManagementRefundWxMapper bawManagementRefundWxMapper;
    @Autowired
    private BawMessageCenterWxMapper bawMessageCenterWxMapper;

    /**
     * 查询订单管理
     *
     * @param id 订单管理主键
     * @return 订单管理
     */
    @Override
    public BawOrderManagement selectBawOrderManagementById(Integer id)
    {
        return bawOrderManagementMapper.selectBawOrderManagementById(id);
    }

    /**
     * 查询订单管理列表
     *
     * @param bawOrderManagement 订单管理
     * @return 订单管理
     */
    @Override
    public List<BawOrderManagement> selectBawOrderManagementList(BawOrderManagement bawOrderManagement)
    {
        return bawOrderManagementMapper.selectBawOrderManagementList(bawOrderManagement);
    }

    /**
     * 新增订单管理
     *
     * @param bawOrderManagement 订单管理
     * @return 结果
     */
    @Override
    public int insertBawOrderManagement(BawOrderManagement bawOrderManagement)
    {
        return bawOrderManagementMapper.insertBawOrderManagement(bawOrderManagement);
    }

    /**
     * 修改订单管理
     *
     * @param bawOrderManagement 订单管理
     * @return 结果
     */
    @Override
    public int updateBawOrderManagement(BawOrderManagement bawOrderManagement)
    {
        return bawOrderManagementMapper.updateBawOrderManagement(bawOrderManagement);
    }

    /**
     * 批量删除订单管理
     *
     * @param ids 需要删除的订单管理主键
     * @return 结果
     */
    @Override
    public int deleteBawOrderManagementByIds(String ids)
    {
        return bawOrderManagementMapper.deleteBawOrderManagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单管理信息
     *
     * @param id 订单管理主键
     * @return 结果
     */
    @Override
    public int deleteBawOrderManagementById(Integer id)
    {
        return bawOrderManagementMapper.deleteBawOrderManagementById(id);
    }

    /**
     * 生成订单并返回微信支付参数
     * @param bawOrderManagement 订单信息
     * @return
     */
    @Override
    public AjaxResult saveOrderAndWeChatPay(BawOrderManagement bawOrderManagement, String openId) {
        bawOrderManagement.setOrderStatus("1");
        bawOrderManagement.setCreatyTime(new Date());
        bawOrderManagement.setDeleted(0);
        bawOrderManagement.setOrderNum(WeChatPayUtil.orderNum());
        int i = bawOrderManagementMapper.insertBawOrderManagement(bawOrderManagement);
        if (i == 1){
            // 生成订单成功
            Map<String, Object> stringObjectMap = WeChatPayUtil.WechatCreateInsurance("baw-预定支付", bawOrderManagement.getOrderNum(), bawOrderManagement.getPrice(), openId, bawOrderManagement.getId());
            // Map<String, Object> stringObjectMap = WeChatPayUtil.WechatCreateInsurance("baw-预定支付", WeChatPayUtil.orderNum(), "1", openId, bawOrderManagement.getId());
            bawOrderManagement.setPrepayId((String) stringObjectMap.get("package"));
            bawOrderManagementMapper.updateBawOrderManagement(bawOrderManagement);
            return AjaxResult.success("成功", stringObjectMap);
        } else {
            // 生成订单失败
            return AjaxResult.error("支付失败！");
        }
    }

    /**
     * 去支付
     * @param amount 价格
     * @param orderId 订单id
     * @param userId
     * @return
     */
    @Override
    public AjaxResult toPay(String amount, Integer orderId, Integer userId, String openId) {
        BawOrderManagement bawOrderManagement = bawOrderManagementMapper.selectBawOrderManagementById(orderId);
        Integer price = bawOrderManagement.getPrice();
        if (StringUtils.isNull(bawOrderManagement) || !bawOrderManagement.getUserId().equals(userId)){
            return AjaxResult.error("支付失败，未查询到相关订单");
        } else if(!"1".equals(bawOrderManagement.getOrderStatus())){
            return AjaxResult.error("支付失败，订单状态不是待付款！");
        } else {
            // 查询微信支付订单状态
            Map<String, String> resultMap = WeChatPayUtil.queryPayStatus(bawOrderManagement.getOrderNum());
            if (resultMap.get("return_code").equals("SUCCESS") && resultMap.get("result_code").equals("SUCCESS") ){
                // 查询成功
                if (resultMap.get("trade_state").equals("SUCCESS")){
                    // 支付成功
                    bawOrderManagement.setOrderStatus("0");
                    bawOrderManagementMapper.updateBawOrderManagement(bawOrderManagement);
                    return AjaxResult.error("该订单已支付！");
                } else if (resultMap.get("trade_state").equals("NOTPAY")){
                    // 未支付
                    Map<String, Object> prePayInfo = WeChatPayUtil.getPrePayInfo(bawOrderManagement.getPrepayId(), bawOrderManagement.getId(), "baw-预定支付", price);
                    return AjaxResult.success("成功", prePayInfo);
                }
            } else {
                // 查询失败，创建新的订单
                Map<String, Object> stringObjectMap = WeChatPayUtil.WechatCreateInsurance("baw-预定支付", bawOrderManagement.getOrderNum(), price, openId, bawOrderManagement.getId());
                bawOrderManagement.setPrepayId((String) stringObjectMap.get("package"));
                bawOrderManagementMapper.updateBawOrderManagement(bawOrderManagement);
                return AjaxResult.success("成功", stringObjectMap);
            }

            Map<String, Object> stringObjectMap = WeChatPayUtil.WechatCreateInsurance("baw-预定支付", bawOrderManagement.getOrderNum(), price, openId, bawOrderManagement.getId());
            bawOrderManagement.setPrepayId((String) stringObjectMap.get("package"));
            bawOrderManagementMapper.updateBawOrderManagement(bawOrderManagement);
            // Map<String, Object> stringObjectMap = WeChatPayUtil.WechatCreateInsurance("baw-预定支付", WeChatPayUtil.orderNum(), "1", openId, bawOrderManagement.getId());
            return AjaxResult.success("成功", stringObjectMap);
        }
    }

    /**
     * 支付结果返回
     * @param id 订单id
     * @param result 结果（0：成功；1：失败）
     * @param userId 用户id
     * @return
     */
    @Override
    public AjaxResult payResult(Integer id, Integer result, Integer userId) {
        BawOrderManagement bawOrderManagement = bawOrderManagementMapper.selectBawOrderManagementById(id);
        if (StringUtils.isNull(bawOrderManagement) || !bawOrderManagement.getUserId().equals(userId)){
            return AjaxResult.error("支付失败，未查询到相关订单");
        } else {
            if (result.equals(0)){
                // 支付成功，修改订单状态为完成
                Map<String, String> resultMap = WeChatPayUtil.queryPayStatus(bawOrderManagement.getOrderNum());
                if (resultMap.get("return_code").equals("SUCCESS") && resultMap.get("result_code").equals("SUCCESS") && resultMap.get("trade_state").equals("SUCCESS") ){
                    try {
                        // 支付成功
                        bawOrderManagement.setOrderStatus("0");
                        String time_end = resultMap.get("time_end");
                        SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
                        Date data = yyyyMMddHHmmss.parse(time_end);
                        bawOrderManagement.setPaymentTime(data);
                        bawOrderManagementMapper.updateBawOrderManagement(bawOrderManagement);
                        BawMessageCenterWx bawMessageCenter = new BawMessageCenterWx();
                        bawMessageCenter.setReminderContent("您的订单：" + bawOrderManagement.getCarSeriesName() + "支付成功！");
                        bawMessageCenter.setCraeteTime(new Date());
                        bawMessageCenter.setName("支付成功！");
                        bawMessageCenter.setAmount(bawOrderManagement.getPrice());
                        bawMessageCenter.setUserId(bawOrderManagement.getUserId());
                        bawMessageCenterWxMapper.insertBawMessageCenterWx(bawMessageCenter);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else {
                    BawMessageCenterWx bawMessageCenterWx1 = new BawMessageCenterWx();
                    bawMessageCenterWx1.setReminderContent("您的订单支付失败，请重试！");
                    bawMessageCenterWx1.setName("支付失败！");
                    bawMessageCenterWx1.setCraeteTime(new Date());
                    bawMessageCenterWx1.setAmount(bawOrderManagement.getPrice());
                    bawMessageCenterWx1.setUserId(bawOrderManagement.getUserId());
                    bawMessageCenterWxMapper.insertBawMessageCenterWx(bawMessageCenterWx1);
                    return AjaxResult.error("当前订单未支付成功！");
                }
            } else {
                // 支付失败，不做操作
                BawMessageCenterWx bawMessageCenterWx = new BawMessageCenterWx();
                bawMessageCenterWx.setReminderContent("您的订单支付失败，请重试！");
                bawMessageCenterWx.setName("支付失败！");
                bawMessageCenterWx.setCraeteTime(new Date());
                bawMessageCenterWx.setAmount(bawOrderManagement.getPrice());
                bawMessageCenterWx.setUserId(bawOrderManagement.getUserId());
                bawMessageCenterWxMapper.insertBawMessageCenterWx(bawMessageCenterWx);
            }
        }
        return AjaxResult.success("成功！");
    }

    /**
     * 订单删除
     * @param id 订单id
     * @param userId 用户id
     * @return
     */
    @Override
    public AjaxResult deleteOrder(Integer id, Integer userId) {
        BawOrderManagement bawOrderManagement = bawOrderManagementMapper.selectBawOrderManagementById(id);
        if (StringUtils.isNull(bawOrderManagement) || !bawOrderManagement.getUserId().equals(userId)){
            return AjaxResult.error("删除失败，未查询到相关订单！");
        }
        /*if (!"0".equals(bawOrderManagement.getOrderStatus())){
            return AjaxResult.error("订单未完成，不可删除！");
        }*/
        int i = bawOrderManagementMapper.deleteBawOrderManagementById(id);

        return AjaxResult.success("删除成功！");
    }

    /**
     * 微信支付回调接口
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public void wxPayCallBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            //微信发的xml格式的数据转为Map格式
            Map<String, String> paramMap = new HashMap<String, String>();
            InputStream inputStream = request.getInputStream();
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            Element root = document.getRootElement();
            List<Element> elementList = root.elements();
            for (Element e : elementList) {
                paramMap.put(e.getName(), e.getText());
            }
            inputStream.close();
            inputStream = null;
            System.out.println("微信支付回调 = " + paramMap);
            if("FAIL".equals(paramMap.get("return_code"))){
                throw new RuntimeException("return_code为fail, " + paramMap.get("return_msg"));
            }
            if("FAIL".equals(paramMap.get("result_code"))){
                throw new RuntimeException("result_code为fail, " + paramMap.get("err_code_des"));
            }
            String out_trade_no = paramMap.get("out_trade_no");//商户订单号号
            System.out.println("商户订单号 = " + out_trade_no);
            //...... 业务流程 ......

            //响应给微信的一定是以流的方式
            //告诉微信服务器收到信息了，不要在调用回调action了(回复微信服务器信息用流发送一个xml即可)
            String xml = "<xml><return_code><![CDATA[SUCCESS]]></return_code>"
                    + " <return_msg><![CDATA[OK]]></return_msg></xml>";
            response.getWriter().write(xml);
        } catch (Exception e) {
            e.printStackTrace();
            String xml = "<xml><return_code><![CDATA[FAIL]]></return_code>"
                    +"<return_msg><![CDATA["+e.getMessage() +"]]></return_msg></xml>";
            response.getWriter().write(xml);
        }
    }

    /**
     * 测试：查询订单状态为未支付，通过订单编号调用微信查询订单状态，如果是 REFUND（转入退款）/SUCCESS（支付成功）
     * @return
     */
    @Override
    public AjaxResult queryOrderTest() throws ParseException {
        BawOrderManagement bawOrderManagement = new BawOrderManagement();
        bawOrderManagement.setOrderStatus("1");
        List<BawOrderManagement> orders = bawOrderManagementMapper.selectBawOrderManagementList(bawOrderManagement);
        for (BawOrderManagement order : orders) {
            System.out.println(order.getOrderNum());
            if (StringUtils.isBlank(order.getOrderNum())){
                continue;
            }
            Map<String, String> resultMap = WeChatPayUtil.queryPayStatus(order.getOrderNum());
            System.out.println(resultMap.get("return_code"));
            System.out.println(resultMap.get("result_code"));
            System.out.println(resultMap.get("trade_state"));
            if (resultMap.get("return_code").equals("SUCCESS") && resultMap.get("result_code").equals("SUCCESS") ){
                if (resultMap.get("trade_state").equals("SUCCESS") || resultMap.get("trade_state").equals("REFUND")){
                    // 转入退款 或 支付成功
                    String time_end = resultMap.get("time_end");
                    SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
                    Date data = yyyyMMddHHmmss.parse(time_end);
                    order.setPaymentTime(data);
                    order.setOrderStatus("0");
                    bawOrderManagementMapper.updateBawOrderManagement(order);
                }
            }
        }
        return AjaxResult.success("成功！");
    }

    /**
     * 微信小程序申请退款
     * @param bawManagementRefundWx 退款单信息
     * @return
     */
    @Override
    public AjaxResult requestARefund(BawManagementRefundWx bawManagementRefundWx) {
        Integer managementId = bawManagementRefundWx.getManagementId();
        BawOrderManagement bawOrderManagement = bawOrderManagementMapper.selectBawOrderManagementById(managementId);
        if (StringUtils.isNull(bawOrderManagement)){
            return AjaxResult.error("申请失败，相关订单不存在！");
        }
        Integer price = bawOrderManagement.getPrice();
        Integer remainingAmount = bawOrderManagement.getRemainingAmount();
        if (StringUtils.isNotNull(remainingAmount)){
            if (bawManagementRefundWx.getRefundMoney() > remainingAmount){
                return AjaxResult.error("申请失败，退款金额不可大于订单剩余金额！");
            }
        }else if (bawManagementRefundWx.getRefundMoney() > price){
            return AjaxResult.error("申请失败，退款金额不可大于订单剩余金额！");
        }
        String refundNumber = WeChatPayUtil.orderNum();
        bawManagementRefundWx.setManagementMoney(bawOrderManagement.getPrice());
        bawManagementRefundWx.setManagementNumber(bawOrderManagement.getOrderNum());
        bawManagementRefundWx.setRefundNumber(refundNumber);
        bawManagementRefundWx.setApplyRefundTime(new Date());
        if (bawManagementRefundWx.getRefundMoney().equals(price)) {
            // 全额退款
            bawManagementRefundWx.setRefundType(1);
        } else {
            // 部分退款
            bawManagementRefundWx.setRefundType(2);
        }
        // 申请退款
        bawManagementRefundWx.setRefundStatus(1);
        int i = bawManagementRefundWxMapper.insertBawManagementRefundWx(bawManagementRefundWx);
        if (i == 0){
            return AjaxResult.error("申请失败！");
        } else {
            // 订单状态设置为 申请退款（4）
            bawOrderManagement.setOrderStatus("4");
            bawOrderManagementMapper.updateBawOrderManagement(bawOrderManagement);
            BawMessageCenterWx bawMessageCenterWx = new BawMessageCenterWx();
            bawMessageCenterWx.setReminderContent("您的订单：" + bawOrderManagement.getCarSeriesName() + "申请退款");
            bawMessageCenterWx.setName("申请退款！");
            bawMessageCenterWx.setAmount(bawOrderManagement.getPrice());
            bawMessageCenterWx.setUserId(bawOrderManagement.getUserId());
            bawMessageCenterWx.setCraeteTime(new Date());
            bawMessageCenterWxMapper.insertBawMessageCenterWx(bawMessageCenterWx);
        }
        return AjaxResult.success("申请成功，等待客服审核");
    }

    /**
     * 去退款
     * @param orderId 订单id
     * @param userId 用户id
     * @return
     */
    @Override
    public AjaxResult toRefund(Integer orderId, Integer userId) {
        Map<String, Object> resultMap = new HashMap<>();
        if (StringUtils.isNull(orderId)){
            return AjaxResult.error("订单id不可为空！");
        }
        BawOrderManagement bawOrderManagement = bawOrderManagementMapper.selectBawOrderManagementById(orderId);
        if (StringUtils.isNull(bawOrderManagement) || !bawOrderManagement.getUserId().equals(userId)){
            return AjaxResult.error("相关订单不存在！");
        }
        switch (bawOrderManagement.getOrderStatus()){
            case "1":
                return AjaxResult.error("订单还未支付，不可申请退款！");
            case "3":
                return AjaxResult.error("订单已取消，不可申请退款！");
            case "4":
                return AjaxResult.error("订单已申请退款，不可重复申请！");
        }
        if (StringUtils.isNotNull(bawOrderManagement.getRefundMoney()) && bawOrderManagement.getRefundMoney().equals(bawOrderManagement.getPrice())){
            return AjaxResult.error("当前订单金额已全部退款！");
        }

        Integer remainingAmount = 0;
        if (StringUtils.isNotNull(bawOrderManagement.getRemainingAmount())){
            remainingAmount = bawOrderManagement.getRemainingAmount();
        } else {
            remainingAmount = bawOrderManagement.getPrice();
        }

        // 封装返回值
        resultMap.put("orderId", bawOrderManagement.getId()); // 订单id
        resultMap.put("remainingAmount",remainingAmount); // 订单剩余金额

        return AjaxResult.success("成功！",resultMap);
    }



}
