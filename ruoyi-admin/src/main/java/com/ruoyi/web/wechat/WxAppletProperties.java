package com.ruoyi.web.wechat;



public class WxAppletProperties {

    public static final String SECRET = "223dce50b2ffba6fd10724530a9e72bc";
    public static final String APP_ID = "wx06842c4db1fb4cd0";
    // 商户号
    public static final String MCH_ID = "1623979811";
    // api密钥
    public static final String PAY_SIGN_KEY = "5ef4f91d18127ad24476ddae18ab0baa";
    // 商户证书
    public static final String MCH_SERIAL_NO = "4747DBA518D6DF7F3ED8EDDA73648AEDDDA9A881";
    
    public static final String API_KEY = "BAWAPPxiaofeipingtaiduijie1951AB";
    
    public static final String CERT_NAME = "/cert/apiclient_cert.p12";
    public static final String GET_CODE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=STAT#wechat_redirect";
    public static final String NOTIFY_URL = "http://localhost:8085/api/pay/notify";
    public static final String ORDERQUERY = "https://api.mch.weixin.qq.com/pay/orderquery";
    public static final String REFUNDQUERY_URL = "https://api.mch.weixin.qq.com/pay/refundquery";
    public static final String TRADE_TYPE = "JSAPI";
    public static final String UNIFORMORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    public static final String USER_MESSAGE = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";
    public static final String CODE2_SESSION = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    public static final String TEMPLATE_ID = "nAt_DYLLwYXkIhtDb5nyEm0ynrt98OK3Z3MmeUooPz4";
    public static final String ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    public static final String TRANSACTIONS = "https://api.mch.weixin.qq.com/v3/pay/transactions/jsapi";
    //微信统一下单接口
    public final static String ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    //微信退款接口
    public final static String REFUND_URL = "https://api.mch.weixin.qq.com/secapi/pay/refund";
    //微信查询订单
    public final static String QUERY_ORDER_STATUS = "https://api.mch.weixin.qq.com/pay/orderquery";
    


}
