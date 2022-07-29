package com.ruoyi.web.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.domain.BawMessageCenterWx;
import com.ruoyi.web.domain.BawTestDriveCommentWx;
import com.ruoyi.web.domain.BawTestDriveWx;
import com.ruoyi.web.mapper.BawMessageCenterWxMapper;
import com.ruoyi.web.mapper.BawTestDriveWxMapper;
import com.ruoyi.web.service.IBawTestDriveWxService;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * 预约试驾微信端Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-10
 */
@Service
public class BawTestDriveWxServiceImpl implements IBawTestDriveWxService
{

    private static final Logger log = LoggerFactory.getLogger(BawTestDriveWxServiceImpl.class);
    @Autowired
    private BawTestDriveWxMapper bawTestDriveWxMapper;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    private BawMessageCenterWxMapper bawMessageCenterWxMapper;

    /**
     * 查询预约试驾微信端
     *
     * @param id 预约试驾微信端主键
     * @return 预约试驾微信端
     */
    @Override
    public BawTestDriveWx selectBawTestDriveWxById(Integer id)
    {
        return bawTestDriveWxMapper.selectBawTestDriveWxById(id);
    }


    /**
     * 查询预约试驾微信端列表
     *
     * @param bawTestDriveWx 预约试驾微信端
     * @return 预约试驾微信端
     */
    @Override
    public List<BawTestDriveWx> selectBawTestDriveWxList(BawTestDriveWx bawTestDriveWx)
    {
        return bawTestDriveWxMapper.selectBawTestDriveWxList(bawTestDriveWx);
    }

    /**
     * 新增预约试驾微信端
     *
     * @param bawTestDriveWx 预约试驾微信端
     * @return 结果
     */
    @Transactional
    @Override
    public int insertBawTestDriveWx(BawTestDriveWx bawTestDriveWx)
    {
        int i = bawTestDriveWxMapper.insertBawTestDriveWx(bawTestDriveWx);
        if (bawTestDriveWx.getAppointmentType().equals(1)){
            JSONObject jsonObject = null;
            try {
                jsonObject = testDriveToCRM(bawTestDriveWx);
                JSONObject response = jsonObject.getJSONObject("RESPONSE");
                String result = response.getJSONObject("HEAD").getString("RESULT");
                if (StringUtils.isBlank(result) || !"0".equals(result)){
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    i = 0;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return i;

    }

    /**
     * 修改预约试驾微信端
     *
     * @param bawTestDriveWx 预约试驾微信端
     * @return 结果
     */
    @Override
    public int updateBawTestDriveWx(BawTestDriveWx bawTestDriveWx)
    {
        return bawTestDriveWxMapper.updateBawTestDriveWx(bawTestDriveWx);
    }

    /**
     * 批量删除预约试驾微信端
     *
     * @param ids 需要删除的预约试驾微信端主键
     * @return 结果
     */
    @Override
    public int deleteBawTestDriveWxByIds(String ids)
    {
        return bawTestDriveWxMapper.deleteBawTestDriveWxByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除预约试驾微信端信息
     *
     * @param id 预约试驾微信端主键
     * @return 结果
     */
    @Override
    public int deleteBawTestDriveWxById(Integer id, Integer userId)
    {
        return bawTestDriveWxMapper.deleteBawTestDriveWxById(id,userId);
    }

    /**
     * 查询预约试驾
     *
     * @param mobile 预约试驾主键
     * @return 预约试驾
     */
    @Override
    public BawTestDriveWx selectBawTestDriveByMobile(Integer appointmentType,String mobile)
    {
        if (appointmentType.equals(1)){
            return bawTestDriveWxMapper.selectBawTestDriveWxByMobile(appointmentType, mobile);
        } else {
            return null;
        }
    }

    /**
     * 将预约试驾信息推送到CRM
     * @param bawTestDriveWx 微信预约试驾信息
     */
    public JSONObject testDriveToCRM(BawTestDriveWx bawTestDriveWx) throws Exception{
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
        ITEM.put("CUST_NAME", bawTestDriveWx.getRealname());
        // 联系电话
        ITEM.put("CONTACT_TEL", bawTestDriveWx.getMobile());
        // 客户性别 0-女 1-男
        ITEM.put("GENDER", bawTestDriveWx.getSex().equals("1")?bawTestDriveWx.getSex():"0");
        // 意向门店编码
        ITEM.put("DLR_CODE", bawTestDriveWx.getDealerCode());
        // 接触方式 1-官网 2-微信后台 3-400电话
        ITEM.put("CANTACT_WAY_CODE", "2");
        // 渠道类型 100-客服咨询  101-预约试驾
        ITEM.put("INFO_CHAN_M_CODE", "101");
        // 计划购车时间 默认写传6-未知
        ITEM.put("BUY_PLAN_CODE", "6");
        // 意向车系编码
        ITEM.put("INTE_SERIES_CODE", bawTestDriveWx.getCarSeriesCode());
        // 客户意向级别 A-一个月内买车 B-三个月内买车 C-三个月后买车 H-7天内买车 默认填写B
        ITEM.put("CLUE_LEVEL_CODE", "B");
        // 省份编码
        ITEM.put("PROVINCE_ID", bawTestDriveWx.getProvinceCode());
        // 城市编码
        ITEM.put("CITY_ID", bawTestDriveWx.getCityCode());
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

    /**
     * 我的-根据预约类型查询预约记录记录
     * @param appointmentType 预约类型（1：预约试驾；2：预约维修；3：预约保养）
     * @param userId 用户id
     * @return
     */
    @Override
    public List<ModelMap> testDriveRecord(Integer appointmentType, Integer userId) {
        //todo 新增 预约类型查询条件
        return bawTestDriveWxMapper.testDriveRecord(appointmentType, userId);
    }

    /**
     * 取消预约试驾
     * @param id 预约试驾记录id
     * @return
     */
    @Override
    public AjaxResult cancelTestDrive(Integer id) {
        BawTestDriveWx bawTestDriveWx = bawTestDriveWxMapper.selectBawTestDriveWxById(id);
        if (StringUtils.isNull(bawTestDriveWx)){
            return AjaxResult.error("取消预约失败，未找到相关预约试驾记录！");
        }
        if (2 == bawTestDriveWx.getStatus()){
            return AjaxResult.error("次试驾记录已结束，无法取消！");
        }
        if (3 == bawTestDriveWx.getStatus()){
            return AjaxResult.error("次试驾记录已取消，不可重复提交！");
        }
        if (bawTestDriveWx.getAppointmentType() == 1){
            BawMessageCenterWx bawMessageCenterWx = new BawMessageCenterWx();
            bawMessageCenterWx.setReminderContent("您的试驾：" + bawTestDriveWx.getCarSeriesCode() + "已取消");
            bawMessageCenterWx.setCraeteTime(new Date());
            bawMessageCenterWx.setName("取消预约试驾！");
            bawMessageCenterWx.setUserId(bawTestDriveWx.getUserId());
            bawMessageCenterWxMapper.insertBawMessageCenterWx(bawMessageCenterWx);
        }
        if (bawTestDriveWx.getAppointmentType() == 2){
            BawMessageCenterWx bawMessageCenterWx = new BawMessageCenterWx();
            bawMessageCenterWx.setReminderContent("您的维修：" + bawTestDriveWx.getCarSeriesCode() + "已取消");
            bawMessageCenterWx.setCraeteTime(new Date());
            bawMessageCenterWx.setName("取消维修！");
            bawMessageCenterWx.setUserId(bawTestDriveWx.getUserId());
            bawMessageCenterWxMapper.insertBawMessageCenterWx(bawMessageCenterWx);
        }
        if (bawTestDriveWx.getAppointmentType() == 3){
            BawMessageCenterWx bawMessageCenterWx = new BawMessageCenterWx();
            bawMessageCenterWx.setReminderContent("您的保养：" + bawTestDriveWx.getCarSeriesCode() + "已取消");
            bawMessageCenterWx.setCraeteTime(new Date());
            bawMessageCenterWx.setName("取消保养！");
            bawMessageCenterWx.setUserId(bawTestDriveWx.getUserId());
            bawMessageCenterWxMapper.insertBawMessageCenterWx(bawMessageCenterWx);
        }
        bawTestDriveWx.setStatus(3);
        int i = bawTestDriveWxMapper.updateBawTestDriveWx(bawTestDriveWx);
        if (1 == i){
            return AjaxResult.success("取消成功！");
        } else {
            return AjaxResult.error("取消失败！");
        }
    }
}
