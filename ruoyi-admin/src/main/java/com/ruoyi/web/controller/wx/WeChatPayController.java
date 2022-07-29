package com.ruoyi.web.controller.wx;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.controller.wx.utils.Utils;
import com.ruoyi.web.controller.wx.utils.WeChatPayUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.*;

/**
 * @author ruoyi
 * @date 2022年04月23日10:10
 */
@RestController
@CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET, RequestMethod.POST})//允许跨域
@RequestMapping("/wxPay")
public class WeChatPayController {

    @PostMapping("/weChatPay")
    public AjaxResult weChatPay(){
        Map<String,Object> resultMap = new HashMap<>();
        long timeStamp = new Date().getTime() / 1000;
        String nonceStr = "1598547857895sjtucngikj358945136";
        String stringA="appid=wx06842c4db1fb4cd0&body=test&device_info=1000&mch_id=10000100&nonce_str=ibuaiVcKdpRxkhJA";
        String SignTemp=stringA+"&key=5ef4f91d18127ad24476ddae18ab0bad";
        String paySign= Utils.getMD5(SignTemp);
        resultMap.put("appId","wx06842c4db1fb4cd0");
        resultMap.put("timeStamp",timeStamp);
        resultMap.put("package","prepay_id=1");
        resultMap.put("signType","MD5");
        resultMap.put("nonceStr",nonceStr);
        resultMap.put("paySign",paySign);
        return AjaxResult.success("成功",resultMap);
    }

    @RequestMapping("/wxPayH5")
    public AjaxResult wxPayH5(HttpServletRequest request){
        Map<String, Object> resultMap = WeChatPayUtil.WechatCreateInsuranceH5("baw-预定支付", WeChatPayUtil.orderNum(), "1", "oPdKx5X8Jcs1rqETiYVKICMyndN0", 1112, request);
        return AjaxResult.success("成功",resultMap);
    }
    
    
    
}
