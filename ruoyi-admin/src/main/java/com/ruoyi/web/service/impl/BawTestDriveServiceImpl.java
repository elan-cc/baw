package com.ruoyi.web.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.BawTestDriveMapper;
import com.ruoyi.web.domain.BawTestDrive;
import com.ruoyi.web.service.IBawTestDriveService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.client.RestTemplate;

/**
 * 预约试驾Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-10
 */
@Service
public class BawTestDriveServiceImpl implements IBawTestDriveService
{
    private static final Logger log = LoggerFactory.getLogger(BawTestDriveServiceImpl.class);
    @Autowired
    private BawTestDriveMapper bawTestDriveMapper;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    /**
     * 查询预约试驾
     *
     * @param id 预约试驾主键
     * @return 预约试驾
     */
    @Override
    public BawTestDrive selectBawTestDriveById(Integer id)
    {
        return bawTestDriveMapper.selectBawTestDriveById(id);
    }

    /**
     * 查询预约试驾
     *
     * @param mobile 预约试驾主键
     * @return 预约试驾
     */
    @Override
    public BawTestDrive selectBawTestDriveByMobile(String mobile)
    {
        return bawTestDriveMapper.selectBawTestDriveByMobile(mobile);
    }

    /**
     * 查询预约试驾列表
     *
     * @param bawTestDrive 预约试驾
     * @return 预约试驾
     */
    @Override
    public List<BawTestDrive> selectBawTestDriveList(BawTestDrive bawTestDrive)
    {
        return bawTestDriveMapper.selectBawTestDriveList(bawTestDrive);
    }

    /**
     * 新增预约试驾
     *
     * @param bawTestDrive 预约试驾
     * @return 结果
     */
    @Override
    public int insertBawTestDrive(BawTestDrive bawTestDrive)
    {

        bawTestDrive.setReceivingTime(new Date());
        int i = bawTestDriveMapper.insertBawTestDrive(bawTestDrive);
        log.info("请求insertBawTestDrive-----新增官网试驾信息进来了：{}="+bawTestDrive.toString());
        JSONObject jsonObject = null;
        try {
            jsonObject = testDriveToCRM(bawTestDrive);
            JSONObject response = jsonObject.getJSONObject("RESPONSE");
            String result = response.getJSONObject("HEAD").getString("RESULT");
            if (StringUtils.isBlank(result) || !"0".equals(result)){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                i = 0;
            }
            return i;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 修改预约试驾
     *
     * @param bawTestDrive 预约试驾
     * @return 结果
     */
    @Override
    public int updateBawTestDrive(BawTestDrive bawTestDrive)
    {
        return bawTestDriveMapper.updateBawTestDrive(bawTestDrive);
    }

    /**
     * 批量删除预约试驾
     *
     * @param ids 需要删除的预约试驾主键
     * @return 结果
     */
    @Override
    public int deleteBawTestDriveByIds(String ids)
    {
        return bawTestDriveMapper.deleteBawTestDriveByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除预约试驾信息
     *
     * @param id 预约试驾主键
     * @return 结果
     */
    @Override
    public int deleteBawTestDriveById(Integer id)
    {
        return bawTestDriveMapper.deleteBawTestDriveById(id);
    }
    /**
     * 将预约试驾信息推送到CRM
     * @param bawTestDrive 官网预约试驾信息
     */
    public JSONObject testDriveToCRM(BawTestDrive bawTestDrive) throws Exception{
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
        int x;//定义两变量
        Random ne=new Random();//实例化一个random的对象ne
        x=ne.nextInt(9999-1000+1)+1000;//为变量赋随机值1000-9999
        String key = String.valueOf(x);
        log.info("**生成四位随机数字**key="+key);
        HEAD.put("TRANSACTIONID", "BAW_OW_E082_" + timee +"_"+key);
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
        ITEM.put("CUST_NAME", bawTestDrive.getRealname());
        // 联系电话
        ITEM.put("CONTACT_TEL", bawTestDrive.getMobile());
        // 客户性别 0-女 1-男
        ITEM.put("GENDER", bawTestDrive.getSex().equals("1")?bawTestDrive.getSex():"0");
        // 意向门店编码
        ITEM.put("DLR_CODE", bawTestDrive.getDealerCode());
        // 接触方式 1-官网 2-微信后台 3-400电话
        ITEM.put("CANTACT_WAY_CODE", "1");
        // 渠道类型 100-客服咨询  101-预约试驾
        ITEM.put("INFO_CHAN_M_CODE", "101");
        // 计划购车时间 默认写传6-未知
        ITEM.put("BUY_PLAN_CODE", "6");
        // 意向车系编码
        ITEM.put("INTE_SERIES_CODE", bawTestDrive.getCarSeriesCode());
        // 客户意向级别 A-一个月内买车 B-三个月内买车 C-三个月后买车 H-7天内买车 默认填写B
        ITEM.put("CLUE_LEVEL_CODE", "B");
        // 省份编码
        ITEM.put("PROVINCE_ID", bawTestDrive.getProvinceCode());
        // 城市编码
        ITEM.put("CITY_ID", bawTestDrive.getCityCode());
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
        RestTemplate restTemplate = restTemplateBuilder.basicAuthentication("ESB_P_OW", "owpr@esb").build();
        //发送post请求
        JSONObject res = restTemplate.exchange(url, HttpMethod.POST, entity, JSONObject.class).getBody();
        log.info("crm返回值-----：{}", res.toJSONString());
        return res;
    }

}
