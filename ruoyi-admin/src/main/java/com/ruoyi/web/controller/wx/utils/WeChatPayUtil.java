package com.ruoyi.web.controller.wx.utils;

import com.github.binarywang.wxpay.constant.WxPayConstants;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.ruoyi.web.wechat.HttpRequest;
import com.ruoyi.web.wechat.WxAppletProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author zhuhe
 * @date 2022年05月06日 14:46
 */
public class WeChatPayUtil {
	
	private static final Logger log = LoggerFactory.getLogger(WeChatPayUtil.class);

	public static Map<String, Object> getPrePayInfo(String prepay_id, Integer orderId, String body, Integer price) {
		try {
			Map<String, String> result = new HashMap<>();
			String timeStamp = System.currentTimeMillis() / 1000 + "";
			String nonceStr = WXPayUtil.generateNonceStr();
			result.put("appId", WxAppletProperties.APP_ID);
			result.put("timeStamp", timeStamp);
			result.put("package", prepay_id);
			result.put("signType", "MD5");
			result.put("nonceStr", nonceStr);

			String paySign = WXPayUtil.generateSignature(result, WxAppletProperties.PAY_SIGN_KEY);

			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("appId", WxAppletProperties.APP_ID);
			resultMap.put("timeStamp", timeStamp);
			resultMap.put("package", prepay_id);
			resultMap.put("signType", "MD5");
			resultMap.put("nonceStr", nonceStr);
			resultMap.put("paySign", paySign);
			resultMap.put("id", orderId);
			resultMap.put("amount", String.valueOf(price));
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * 微信支付生成订单,返回个小程序支付需要信息
	 *
	 * @param body       商品描述或所支付的名称
	 * @param outTradeNo 自己后台提供的唯一的订单号
	 * @param price      支付金额，默认单位为分
	 * @param openId     支付人的微信公众号对应的唯一标识
	 * @param orderId    订单id
	 * @return
	 */
	public static Map<String, Object> WechatCreateInsurance(String body, String outTradeNo, Integer price, String openId, Integer orderId) {
		// 创建返回值
		Map<String, Object> resultMap = new HashMap<>();
		String paternerKey = WxAppletProperties.PAY_SIGN_KEY;
		try {
			//创建微信下单请求参数
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("appid", WxAppletProperties.APP_ID);  //公众账号ID
			paramMap.put("mch_id", WxAppletProperties.MCH_ID); //商户号
			paramMap.put("nonce_str", WXPayUtil.generateNonceStr()); //随机字符串
			paramMap.put("body", body); //商品描述或所支付的名称
			paramMap.put("out_trade_no", outTradeNo);  //自己后台提供的唯一的订单号
			paramMap.put("total_fee", String.valueOf(price)); //支付金额，默认单位为分
			paramMap.put("spbill_create_ip", "127.0.0.1"); //终端IP
			paramMap.put("notify_url", "http://wx.baw.com.cn/api_wx/wxPayCallBack");//微信支付回调地址
			paramMap.put("trade_type", "JSAPI"); //支付类型
			paramMap.put("openid", openId); //支付人的微信公众号对应的唯一标识
			paramMap.put("sign_type", WxPayConstants.SignType.MD5); //支付人的微信公众号对应的唯一标识
			//其他10个必须参数和API秘钥，用generateSignature方法获取sign
			// String sign = WXPayUtil.generateSignature(paramMap, "5ef4f91d18127ad24476ddae18ab0baa");
			String sign = WXPayUtil.generateSignature(paramMap, paternerKey);
			System.out.println(sign);
			paramMap.put("sign", sign); //记得将sign放在map中凑齐11个参数
			String requestXmlString = WXPayUtil.mapToXml(paramMap);  //转为xml字符串
			System.out.println(requestXmlString);
			// String unifiedorder = "https://api.mch.weixin.qq.com/pay/unifiedorder"; //微信统一下单接口
			String unifiedorder = WxAppletProperties.ORDER_URL; //微信统一下单接口
			String xmlStr = HttpRequest.sendPost(unifiedorder, requestXmlString);
			Map<String, String> map = WXPayUtil.xmlToMap(xmlStr);
			System.out.println(map);
			if (xmlStr.indexOf("SUCCESS") <= 0) {
				throw new RuntimeException("调用微信统一下单接口报错！");
			}
			Map<String, String> result = new HashMap<>();
			String prepay_id = (String) map.get("prepay_id");
			String timeStamp = System.currentTimeMillis() / 1000 + "";
			String nonceStr = WXPayUtil.generateNonceStr();
			result.put("appId", WxAppletProperties.APP_ID);
			result.put("timeStamp", timeStamp);
			result.put("package",  "prepay_id=" + prepay_id);
			result.put("signType", "MD5");
			result.put("nonceStr", nonceStr);
			// String paySign = WXPayUtil.generateSignature(result,"5ef4f91d18127ad24476ddae18ab0baa");
			String paySign = WXPayUtil.generateSignature(result,paternerKey);
			resultMap.put("appId", WxAppletProperties.APP_ID);
			resultMap.put("timeStamp", timeStamp);
			resultMap.put("package",  "prepay_id=" + prepay_id);
			resultMap.put("signType", "MD5");
			resultMap.put("nonceStr", nonceStr);
			resultMap.put("paySign", paySign);
			resultMap.put("id", orderId);
			resultMap.put("amount", price);
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * H5微信支付生成订单
	 *
	 * @param body       商品描述或所支付的名称
	 * @param outTradeNo 自己后台提供的唯一的订单号
	 * @param price      支付金额，默认单位为分
	 * @param openId     支付人的微信公众号对应的唯一标识
	 * @param orderId    订单id
	 * @return
	 */
	public static Map<String, Object> WechatCreateInsuranceH5(String body, String outTradeNo, String price, String openId, Integer orderId, HttpServletRequest request) {
		// 创建返回值
		Map<String, Object> resultMap = new HashMap<>();
		String paternerKey = WxAppletProperties.PAY_SIGN_KEY;
		try {
			//创建微信下单请求参数
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("appid", WxAppletProperties.APP_ID);  //公众账号ID
			paramMap.put("mch_id", WxAppletProperties.MCH_ID); //商户号
			paramMap.put("nonce_str", WXPayUtil.generateNonceStr()); //随机字符串
			paramMap.put("body", body); //商品描述或所支付的名称
			paramMap.put("out_trade_no", outTradeNo);  //自己后台提供的唯一的订单号
			paramMap.put("total_fee", price); //支付金额，默认单位为分
			paramMap.put("spbill_create_ip", getIp(request)); //终端IP
			paramMap.put("notify_url", "http://27.128.200.160:18081/api_wx/test");//微信支付回调地址(具体实现看第五章)
			paramMap.put("trade_type", "MWEB"); //支付类型
			paramMap.put("openid", openId); //支付人的微信公众号对应的唯一标识
			paramMap.put("sign_type", WxPayConstants.SignType.MD5); //支付人的微信公众号对应的唯一标识
			//其他10个必须参数和API秘钥，用generateSignature方法获取sign
			// String sign = WXPayUtil.generateSignature(paramMap, "5ef4f91d18127ad24476ddae18ab0baa");
			String sign = WXPayUtil.generateSignature(paramMap, paternerKey);
			System.out.println(sign);
			paramMap.put("sign", sign); //记得将sign放在map中凑齐11个参数
			String requestXmlString = WXPayUtil.mapToXml(paramMap);  //转为xml字符串
			System.out.println("转xml格式" + requestXmlString);
			// String unifiedorder = "https://api.mch.weixin.qq.com/pay/unifiedorder"; //微信统一下单接口
			String unifiedorder = WxAppletProperties.ORDER_URL; //微信统一下单接口
			String xmlStr = HttpRequest.sendPost(unifiedorder, requestXmlString);
			Map<String, String> map = WXPayUtil.xmlToMap(xmlStr);
			System.out.println("统一下单返回值:" + map);
			if (xmlStr.indexOf("SUCCESS") <= 0) {
				throw new RuntimeException("调用微信统一下单接口报错！");
			}
			resultMap.put("mweb_url", map.get("mweb_url"));
			resultMap.put("amount", orderId);
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 查询微信支付订单状态
	 * @param orderNum 订单编号
	 * @return 注：return_code为（SUCCESS）查询成功，
	 */
	public static Map<String,String> queryPayStatus(String orderNum){
		try {
			// 创建请求参数
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("appid", WxAppletProperties.APP_ID);  //公众账号ID
			paramMap.put("mch_id", WxAppletProperties.MCH_ID); //商户号
			paramMap.put("out_trade_no", orderNum);    // 订单号
			paramMap.put("nonce_str", WXPayUtil.generateNonceStr()); //随机字符串
			paramMap.put("sign_type", WxPayConstants.SignType.MD5); //支付人的微信公众号对应的唯一标识
			String sign = WXPayUtil.generateSignature(paramMap, WxAppletProperties.PAY_SIGN_KEY);
			paramMap.put("sign", sign);
			String requestXmlString = WXPayUtil.mapToXml(paramMap);  //转为xml字符串
			// System.out.println(requestXmlString);
			String xmlStr = HttpRequest.sendPost(WxAppletProperties.ORDERQUERY, requestXmlString);
			Map<String, String> map = WXPayUtil.xmlToMap(xmlStr);
			System.out.println(map);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getIp(HttpServletRequest request){
		// 获取请求ip地址
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.indexOf(",") != -1) {
			String[] ips = ip.split(",");
			ip = ips[0].trim();
		}
		return ip;
	}

	/**
	 * 微信支付申请退款
	 * @param out_trade_no 商户订单号
	 * @param out_refund_no 商户退款单号
	 * @param total_fee 订单总金额，单位分
	 * @param refund_fee 需要退款的金额，单位分
	 */
	public Map<String, String> wxRefund(String out_trade_no, String out_refund_no, Integer total_fee, Integer refund_fee){
		String paternerKey = WxAppletProperties.PAY_SIGN_KEY;
		Map<String, String> refund = new HashMap<>();
		try {
			HashMap<String, String> map = new LinkedHashMap<>();
			map.put("appid", WxAppletProperties.APP_ID); // 应用appid
			map.put("mch_id", WxAppletProperties.MCH_ID); // 商户号
			map.put("nonce_str", Long.toString(System.currentTimeMillis() / 1000));  // 随机字符串
			map.put("out_trade_no", out_trade_no);  //商户订单号
			map.put("out_refund_no", out_refund_no);   // 商户退款单号
			map.put("total_fee", String.valueOf(total_fee));  // 订单总金额，单位分
			map.put("refund_fee", String.valueOf(refund_fee));  // 需要退款的金额，单位分
			// map.put("refund_desc", );  // 退款描述
			// map.put("refund_account", "REFUND_SOURCE_RECHARGE_FUNDS");// 规定退款方式，可用余额退款
			// map.put("sign", PayUtils.getSign(map, mchSecret));   // 构造签名，构造签名的方法已经在微信支付踩坑记录一说明过了
			String sign = WXPayUtil.generateSignature(map, WxAppletProperties.PAY_SIGN_KEY);
			map.put("sign",sign);
			String requestXmlString = WXPayUtil.mapToXml(map);  //转为xml字符串
			// System.out.println(requestXmlString);
			log.info(requestXmlString);
			MyConfig myConfig = new MyConfig();
			WXPay wxPay = new WXPay(myConfig);
			refund = wxPay.refund(map);
			System.out.println("退款返回 ------ " + refund);
			return refund;
		} catch (Exception e) {
			e.printStackTrace();
			return refund;
		}
	}

	/**
	 * 微信支付退款查询
	 * @param out_trade_no 商户订单号
	 */
	public Map<String, String> refundQuery(String out_trade_no){
		Map<String, String> resp = new HashMap<>();
		try {
			Map<String, String> data = new HashMap<String, String>();
			data.put("out_trade_no", out_trade_no);

			MyConfig myConfig = new MyConfig();
			WXPay wxpay = new WXPay(myConfig);
			resp = wxpay.refundQuery(data);
			return resp;
		} catch (Exception e) {
			e.printStackTrace();
			return resp;
		}
	}

	public static String orderNum() {
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat time = new SimpleDateFormat("HHmmss");
		String tradeDate = date.format(new Date());
		String tradeTime = time.format(new Date());

		String no = tradeDate + tradeTime;
		//生成一个6位随机数
		int radom = new Random().nextInt(999999);
		if (radom < 100000) {
			radom += 100000;
		}
		String str = "BAW" + no + radom;
		System.out.println(str);
		return str;
	}

	public static void main(String[] args) {
		// Map<String, Object> stringObjectMap = WeChatPayUtil.WechatCreateInsurance("baw-预定支付", "BAW20220509102749483331", "1", "oPdKx5X8Jcs1rqETiYVKICMyndN0", 111);
		// WeChatPayUtil.WechatCreateInsuranceH5("baw-预定支付", orderNum(), "1", "oPdKx5X8Jcs1rqETiYVKICMyndN0", 1112);
		// System.err.println("统一下单返回值:" + stringObjectMap);
		// queryPayStatus("BAW20220517142445627498");
		// Map<String, Object> prePayInfo = getPrePayInfo("prepay_id=wx0915543772002453096965bbd9c8660000", 111, "baw-预定支付", "1");
		// System.out.println(prePayInfo);
		/**退款*/
		// String out_refund_no = orderNum();//退款单号
		// System.out.println("out_refund_no : " + out_refund_no);
		// new WeChatPayUtil().wxRefund("BAW20220519194150181506", out_refund_no, 518,518);
		/**退款查询*/
		// new WeChatPayUtil().refundQuery("BAW20220518160947660786");
		
	}

	public String path(){
		String path = this.getClass().getClassLoader().getResource("apiclient_cert.p12").getPath();
		return path;
	}

}
