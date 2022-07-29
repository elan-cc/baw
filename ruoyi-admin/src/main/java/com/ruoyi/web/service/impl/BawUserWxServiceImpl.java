package com.ruoyi.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.CacheUtils;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.web.domain.BawUserWx;
import com.ruoyi.web.mapper.BawUserWxMapper;
import com.ruoyi.web.service.IBawUserWxService;
import com.ruoyi.web.utils.CommonUtil;
import com.ruoyi.web.wechat.WxAppletProperties;
import com.ruoyi.common.utils.StringUtils;
import org.aspectj.weaver.loadtime.Aj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * 微信用户Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-12
 */
@Service
public class BawUserWxServiceImpl implements IBawUserWxService
{
    private static final Logger log = LoggerFactory.getLogger(BawUserWxServiceImpl.class);
    
    @Autowired
    private BawUserWxMapper bawUserWxMapper;
    @Autowired
    private SysPasswordService passwordService;
    @Autowired
    private RestTemplate restTemplate;
    

    /**
     * 查询微信用户
     *
     * @param id 微信用户主键
     * @return 微信用户
     */
    @Override
    public BawUserWx selectBawUserWxById(Integer id)
    {
        return bawUserWxMapper.selectBawUserWxById(id);
    }

    /**
     * 查询微信用户列表
     *
     * @param bawUserWx 微信用户
     * @return 微信用户
     */
    @Override
    public List<BawUserWx> selectBawUserWxList(BawUserWx bawUserWx)
    {
        return bawUserWxMapper.selectBawUserWxList(bawUserWx);
    }

    /**
     * 新增微信用户
     *
     * @param bawUserWx 微信用户
     * @return 结果
     */
    @Override
    public int insertBawUserWx(BawUserWx bawUserWx)
    {
        bawUserWx.setCreateTime(DateUtils.getNowDate());
        return bawUserWxMapper.insertBawUserWx(bawUserWx);
    }

    /**
     * 修改微信用户
     *
     * @param bawUserWx 微信用户
     * @return 结果
     */
    @Override
    public int updateBawUserWx(BawUserWx bawUserWx)
    {
        bawUserWx.setUpdateTime(DateUtils.getNowDate());
        return bawUserWxMapper.updateBawUserWx(bawUserWx);
    }

    /**
     * 批量删除微信用户
     *
     * @param ids 需要删除的微信用户主键
     * @return 结果
     */
    @Override
    public int deleteBawUserWxByIds(String ids)
    {
        return bawUserWxMapper.deleteBawUserWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除微信用户信息
     *
     * @param id 微信用户主键
     * @return 结果
     */
    @Override
    public int deleteBawUserWxById(Integer id)
    {
        return bawUserWxMapper.deleteBawUserWxById(id);
    }
    
    /**
     * 微信小程序用户登录
     * @param code
     * @return
     */
    @Override
    public AjaxResult loginByWeixin(String code) {
        Map<String,Object> resultMap = new HashMap<>();
        // 组合小程序登录凭证校验接口
        String requestUrl = this.getWebAccess(code);
        // 调用小程序登录凭证校验接口
        JSONObject sessionData = CommonUtil.httpsRequest(requestUrl, "GET", null);
        if (null == sessionData || StringUtils.isEmpty(sessionData.getString("openid"))) {
            return AjaxResult.error("登录失败！");
        }
        BawUserWx bawUserWx = bawUserWxMapper.queryByOpenId(sessionData.getString("openid"));
        if (null == bawUserWx){
            //注册用户
            BawUserWx userWx = new BawUserWx();
            userWx.setUserName("wxapplet" + getRandomString(12));
            userWx.setSalt(ShiroUtils.randomSalt());
            userWx.setPassword(passwordService.encryptPassword(userWx.getUserName(), "123456", userWx.getSalt()));
            userWx.setNickName(userWx.getUserName());
            userWx.setRegTime(new Date());
            userWx.setStatus("0");
            userWx.setDeleted(0);
            userWx.setToken(IdUtils.fastSimpleUUID());
            userWx.setCreateTime(new Date());
            userWx.setWxOpenid(sessionData.getString("openid"));
            bawUserWxMapper.insertBawUserWx(userWx);
            // 添加到缓存中
            // CacheUtils.put(userWx.getToken(), userWx);
            resultMap.put("token", userWx.getToken());
            resultMap.put("openid", userWx.getWxOpenid());
            return AjaxResult.success("登录成功！",resultMap);
        }
        if (0 != bawUserWx.getDeleted()){
            log.info("用户登录失败，用户已被删除，userId：{}",bawUserWx.getId());
            return AjaxResult.error("登录失败！");
        }
        if (StringUtils.isNotBlank(bawUserWx.getStatus())){
            if ("1".equals(bawUserWx.getStatus())){
                log.info("用户登录失败，账号状态停用，userId：{}",bawUserWx.getId());
                return AjaxResult.error("登录失败！");
            } else if ("2".equals(bawUserWx.getStatus())){
                log.info("用户登录失败，账号状态注销，userId：{}",bawUserWx.getId());
                return AjaxResult.error("登录失败！");
            }
        } else {
            log.info("用户登录失败，账号状态为空，userId：{}",bawUserWx.getId());
            return AjaxResult.error("登录失败！");
        }     // 从缓存中查询用户信息
        // Object object = CacheUtils.get(bawUserWx.getToken());
        // BawUserWx userWx = StringUtils.cast(object);
        // if(StringUtils.isNull(object)){
            // 添加到缓存中
            // CacheUtils.put(bawUserWx.getToken(), bawUserWx);
        // }
        // 返回token 和 openid
        resultMap.put("token", bawUserWx.getToken());
        resultMap.put("openid", bawUserWx.getWxOpenid());
        return AjaxResult.success("登录成功！",resultMap);
    }
    
    @Override
    public BawUserWx selectByToken(String token) {
        if (StringUtils.isBlank(token)){
            return null;
        }
        BawUserWx userWx = bawUserWxMapper.selectByToken(token);
        return userWx;
    }
    
    /**
     * 通过用户id修改 微信名，微信头像url，手机号码
     * @param bawUserWx 微信用户信息
     * @return
     */
    @Override
    public int saveUserInfo(BawUserWx bawUserWx) {
        int i = bawUserWxMapper.saveUserInfo(bawUserWx);
        return i;
    }
    
    /**
     * 微信小程序用户手机号获取
     * @param code 动态令牌，用于获取手机号
     * @param userId 用户id
     * @return
     */
    @Override
    public AjaxResult authPhone(String code, Integer userId) {
        // 获取token
        String token_url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", WxAppletProperties.APP_ID, WxAppletProperties.SECRET);
        JSONObject token = CommonUtil.httpsRequest(token_url, "GET", null);
        // 使用前端code获取手机号码 参数为json格式
        String url = "https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token=" + token.getString("access_token");
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("code", code);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(paramMap, headers);
        // System.out.println(httpEntity);
        JSONObject jsonObject = restTemplate.postForEntity(url, httpEntity, JSONObject.class).getBody();
        System.out.println("获取手机号返回值：" + jsonObject.toJSONString());
        Integer errcode = jsonObject.getInteger("errcode");
        if (0 == errcode){
            JSONObject phone_info = jsonObject.getJSONObject("phone_info");
            String phoneNumber = phone_info.getString("phoneNumber");
            BawUserWx bawUserWx = new BawUserWx();
            bawUserWx.setId(userId);
            bawUserWx.setPhoneNumber(phoneNumber);
            int i = bawUserWxMapper.saveUserInfo(bawUserWx);
            if (i == 1){
                return AjaxResult.success("查询成功！", phoneNumber);
            }else {
                return AjaxResult.error("查询失败！");
            }
        } else {
            return AjaxResult.error("获取手机号失败！");
        }
    }
    
    //替换字符串
    public String getWebAccess(String CODE) {
        
        return String.format(WxAppletProperties.CODE2_SESSION,
                WxAppletProperties.APP_ID,
                WxAppletProperties.SECRET,
                CODE);
    }
    
    /**
     * 获取随机字符串
     *
     * @param num
     * @return
     */
    public static String getRandomString(Integer num) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    
}
