package com.ruoyi.web.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.domain.BawActivityRegistrationWx;
import com.ruoyi.web.domain.BawActivityWx;
import com.ruoyi.web.mapper.BawActivityRegistrationWxMapper;
import com.ruoyi.web.mapper.BawActivityWxMapper;
import com.ruoyi.web.service.IBawActivityRegistrationWxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 活动报名Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-17
 */
@Service
public class BawActivityRegistrationWxServiceImpl implements IBawActivityRegistrationWxService
{
    private static final Logger log = LoggerFactory.getLogger(BawActivityRegistrationWxServiceImpl.class);

    @Autowired
    private BawActivityRegistrationWxMapper bawActivityRegistrationWxMapper;
    /**活动mapper*/
    @Autowired
    private BawActivityWxMapper bawActivityWxMapper;
    
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    /**
     * 查询活动报名
     *
     * @param id 活动报名主键
     * @return 活动报名
     */
    @Override
    public BawActivityRegistrationWx selectBawActivityRegistrationWxById(Integer id)
    {
        return bawActivityRegistrationWxMapper.selectBawActivityRegistrationWxById(id);
    }

    /**
     * 查询活动报名列表
     *
     * @param bawActivityRegistrationWx 活动报名
     * @return 活动报名
     */
    @Override
    public List<BawActivityRegistrationWx> selectBawActivityRegistrationWxList(BawActivityRegistrationWx bawActivityRegistrationWx)
    {
        return bawActivityRegistrationWxMapper.selectBawActivityRegistrationWxList(bawActivityRegistrationWx);
    }

    /**
     * 新增活动报名
     *
     * @param bawActivityRegistrationWx 活动报名
     * @return 结果
     */
    @Transactional
    @Override
    public AjaxResult insertBawActivityRegistrationWx(BawActivityRegistrationWx bawActivityRegistrationWx) {
        BawActivityWx bawActivityWx = bawActivityWxMapper.selectBawActivityWxById(bawActivityRegistrationWx.getActivityId());
        if (StringUtils.isNotNull(bawActivityWx)){
            if (0 == bawActivityWx.getIsAble()){
                // 未启用
                return AjaxResult.error("活动报名失败！");
            }
            if (2 == bawActivityWx.getActivityState()){
                return AjaxResult.error("活动已结束，无法报名！");
            }
            if (0 == bawActivityWx.getActivityState()){
                return AjaxResult.error("活动未开始，无法报名！");
            }
            int i = bawActivityRegistrationWxMapper.insertBawActivityRegistrationWx(bawActivityRegistrationWx);
            // 对接活动报名对接crm接口
            // 20220519-由于crm没有活动的信息，所以暂时不传给crm，只保存在后台
            /*try {
                JSONObject jsonObject = toCRM(bawActivityRegistrationWx);
                JSONObject response = jsonObject.getJSONObject("RESPONSE");
                String result = response.getJSONObject("HEAD").getString("RESULT");
                if (StringUtils.isBlank(result) || !"0".equals(result)){
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    i = 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }*/
            if (i == 1){
                return AjaxResult.success("活动报名成功！");
            } else {
                return AjaxResult.error("活动报名失败！");
            }
        } else {
            return AjaxResult.error("活动报名失败！");
        }
    }

    /**
     * 修改活动报名
     *
     * @param bawActivityRegistrationWx 活动报名
     * @return 结果
     */
    @Override
    public int updateBawActivityRegistrationWx(BawActivityRegistrationWx bawActivityRegistrationWx)
    {
        return bawActivityRegistrationWxMapper.updateBawActivityRegistrationWx(bawActivityRegistrationWx);
    }

    /**
     * 批量删除活动报名
     *
     * @param ids 需要删除的活动报名主键
     * @return 结果
     */
    @Override
    public int deleteBawActivityRegistrationWxByIds(String ids)
    {
        return bawActivityRegistrationWxMapper.deleteBawActivityRegistrationWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除活动报名信息
     *
     * @param id 活动报名主键
     * @return 结果
     */
    @Override
    public int deleteBawActivityRegistrationWxById(Integer id)
    {
        return bawActivityRegistrationWxMapper.deleteBawActivityRegistrationWxById(id);
    }
    
    /**
     * 通过活动id和手机号查询活动报名信息
     * @param activityId 活动id
     * @param phone 手机号码
     * @return
     */
    @Override
    public BawActivityRegistrationWx selectByPhone(Integer activityId,String phone) {
        
        return bawActivityRegistrationWxMapper.selectByPhone(activityId, phone);
    }
    
    
    /**
     * 将活动报名信息推送到CRM
     * @param bawActivityRegistrationWx 活动报名信息
     */
    public JSONObject toCRM(BawActivityRegistrationWx bawActivityRegistrationWx) throws Exception{
        String url = "http://219.146.86.62:32880/WP_BAW/APP_OW_SERVICE/Proxy_Services/TA_CRM/OW_E082_ClueInfo_PS";
        //设置请求头
        HttpHeaders header = new HttpHeaders();
        header.set("Accept-Charset", "UTF-8");
        header.set("Content-Type", "application/json; charset=utf-8");
        //设置请求参数，此处设置为json
        JSONObject param = new JSONObject();
        // MultiValueMap<String, Object> param = new LinkedMultiValueMap<String, Object>();
        JSONObject REQUEST = new JSONObject();
        // HEAD
        JSONObject HEAD = new JSONObject();
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timee = sdf.format(new Date());
        HEAD.put("TRANSACTIONID", "BAW_OW_E082_" + timee + "_4528");
        HEAD.put("COUNT", "1");
        HEAD.put("CONSUMER", "SAP");
        HEAD.put("SRVLEVEL", "1");
        HEAD.put("COMPANY", "BAW");
        HEAD.put("ACCOUNT", "");
        HEAD.put("PASSWORD", "");
        REQUEST.put("HEAD", HEAD);
        // DATA
        JSONObject DATA = new JSONObject();
        // ITEM
        JSONArray ITEMS = new JSONArray();
        JSONObject ITEM = new JSONObject();
        // 客户姓名
        ITEM.put("CUST_NAME", bawActivityRegistrationWx.getName());
        // 联系电话
        ITEM.put("CONTACT_TEL", bawActivityRegistrationWx.getPhone());
        // 客户性别 0-女 1-男
        ITEM.put("GENDER", "1");
        // 意向门店编码
        ITEM.put("DLR_CODE", bawActivityRegistrationWx.getDealerCode());
        // 接触方式 1-官网 2-微信后台 3-400电话
        ITEM.put("CANTACT_WAY_CODE", "2");
        // 渠道类型 100-客服咨询  101-预约试驾
        ITEM.put("INFO_CHAN_M_CODE", "101");
        // 计划购车时间 默认写传6-未知
        ITEM.put("BUY_PLAN_CODE", "6");
         // 意向车系编码
        ITEM.put("INTE_SERIES_CODE", "");
        // 客户意向级别 A-一个月内买车 B-三个月内买车 C-三个月后买车 H-7天内买车 默认填写B
        ITEM.put("CLUE_LEVEL_CODE", "B");
        // 省份编码
        ITEM.put("PROVINCE_ID", bawActivityRegistrationWx.getCityCode().substring(0, 2));
        // 城市编码
        ITEM.put("CITY_ID", bawActivityRegistrationWx.getCityCode());
        // 留资时间 格式 yyyy-MM-dd HH:mm:ss
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(new Date());
        ITEM.put("REMAIN_DATA_DATE", time);
        ITEMS.add(ITEM);
        DATA.put("ITEM", ITEMS);
        REQUEST.put("DATA", DATA);
        param.put("REQUEST", REQUEST);
        log.info("请求crm-----：{}", param.toString());
        //entity为请求体，包含请求参数
        HttpEntity entity = new HttpEntity(param.toJSONString(), header);
        // CRM -- 测试
        // RestTemplate restTemplate = restTemplateBuilder.basicAuthentication("ESB_TEST_OW", "owtest@esb").build();
        // CRM -- 正式
        RestTemplate restTemplate = restTemplateBuilder.basicAuthentication("ESB_P_OW", "owpr@esb").build();
        //发送post请求
        JSONObject res = restTemplate.exchange(url, HttpMethod.POST, entity, JSONObject.class).getBody();
        log.info("crm返回值-----：{}", res.toJSONString());
        return res;
    }
}
