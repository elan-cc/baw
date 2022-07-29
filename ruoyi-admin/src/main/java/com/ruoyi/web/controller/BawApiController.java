package com.ruoyi.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.domain.*;
import com.ruoyi.web.service.*;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET, RequestMethod.POST})//允许跨域
@RequestMapping("/bawApi")
public class BawApiController {
    private static final Logger logger = LoggerFactory.getLogger(BawApiController.class);
    @Autowired
    private ServerConfig serverConfig;
    //接收车辆品牌信息同步接口
    @Autowired
    private IBawBaseMainbrandService bawBaseMainbrandService;
    @PostMapping("/baw_receive_mainbrand")
    public ReceiveMainbrandResponse receivingbrand(@RequestBody String requestJson) {
        logger.info("**baw_receive_mainbrand**requestJson="+requestJson.toString());
        //全局变量
        String transactionid=null;
        String carBrandCode=null;
        if (StringUtils.isBlank(requestJson)) {
            logger.info("接收车辆品牌信息同步接口请求数据为空");
            return null;
        }
        InItem inItem;
        InHead inHead;
        try {
            JSONObject jsonObject = JSONObject.parseObject(requestJson);
            String head = jsonObject.getJSONObject("REQUEST").getString("HEAD");
            if(head!=null &&head.length()>0){
                logger.info("***head***="+head);
            }
            //获取HEAD头部字段
            JSONObject headJsonObject= JSON.parseObject(head);
            transactionid=headJsonObject.getString("TRANSACTIONID");
            logger.info("****transactionid***="+transactionid);
            String count=headJsonObject.getString("COUNT");
            String consumer=headJsonObject.getString("CONSUMER");
            String srvlevel=headJsonObject.getString("SRVLEVEL");
            logger.info("****srvlevel***="+srvlevel);
            String account=headJsonObject.getString("ACCOUNT");
            String password=headJsonObject.getString("PASSWORD");
            String company=headJsonObject.getString("COMPANY");
            logger.info("****company***="+company);
            //获取REQUEST中data数据
            String data = jsonObject.getJSONObject("REQUEST").getString("DATA");
            if(data!=null &&data.length()>0){
                logger.info("***data***="+data);
            }
            JSONObject itemJsonObject= JSON.parseObject(data);
            JSONArray jsonArray = null;
            jsonArray = itemJsonObject.getJSONArray("ITEM");//获取数组
            if(jsonArray.size()<=1){
                carBrandCode= (String) jsonArray.getJSONObject(0).get("CAR_BRAND_CODE");
                String carBrandEn =(String) jsonArray.getJSONObject(0).get("CAR_BRAND_EN");
                String carBrandCn =(String) jsonArray.getJSONObject(0).get("CAR_BRAND_CN");
                String isEnable =(String) jsonArray.getJSONObject(0).get("IS_ENABLE");
                BawBaseMainbrand bawBaseMainbrand =new BawBaseMainbrand();
                bawBaseMainbrand.setCarBrandCode(carBrandCode);
                bawBaseMainbrand.setCarBrandEn(carBrandEn);
                bawBaseMainbrand.setCarBrandCn(carBrandCn);
                bawBaseMainbrand.setIsEnable(isEnable);
                bawBaseMainbrand.setCreateBy("BAW");
                // 主库数据信息
                List<BawBaseMainbrand> bawBaseMainbrandInfo = bawBaseMainbrandService.selectBawBaseMainbrandList(new BawBaseMainbrand());
                if (CollectionUtils.isNotEmpty(bawBaseMainbrandInfo)) {
                    // 删除库中所有的数据
                    List<Integer> idList = bawBaseMainbrandInfo.stream().map(BawBaseMainbrand::getId).collect(Collectors.toList());
                    bawBaseMainbrandService.deleteBawBaseMainbrandByIds(idList.toArray(new Integer[idList.size()]));
                }
                int add_result = bawBaseMainbrandService.insertBawBaseMainbrand(bawBaseMainbrand);
                if (add_result > 0) {
                    logger.info("***接收车辆品牌信息保存成功***=");
                } else {
                    logger.info("***接收车辆品牌信息保存失败***=");
                }
            }else{
                String str;
                // 主库数据信息
                List<BawBaseMainbrand> bawBaseMainbrandInfo = bawBaseMainbrandService.selectBawBaseMainbrandList(new BawBaseMainbrand());
                if (CollectionUtils.isNotEmpty(bawBaseMainbrandInfo)) {
                    // 删除库中所有的数据
                    List<Integer> idList = bawBaseMainbrandInfo.stream().map(BawBaseMainbrand::getId).collect(Collectors.toList());
                    bawBaseMainbrandService.deleteBawBaseMainbrandByIds(idList.toArray(new Integer[idList.size()]));
                }
                for(int i = 0; i < jsonArray.size(); i++){
                    Object obj = jsonArray.get(i);
                    str = obj.toString();
                    JSONObject JsonObject= JSON.parseObject(str);
                    carBrandCode=JsonObject.getString("CAR_BRAND_CODE");
                    String carBrandEn=JsonObject.getString("CAR_BRAND_EN");
                    String carBrandCn=JsonObject.getString("CAR_BRAND_CN");
                    String isEnable=JsonObject.getString("IS_ENABLE");
                    BawBaseMainbrand bawBaseMainbrand =new BawBaseMainbrand();
                    bawBaseMainbrand.setCarBrandCode(carBrandCode);
                    bawBaseMainbrand.setCarBrandEn(carBrandEn);
                    bawBaseMainbrand.setCarBrandCn(carBrandCn);
                    bawBaseMainbrand.setIsEnable(isEnable);
                    bawBaseMainbrand.setCreateBy("BAW");
                    int add_result = bawBaseMainbrandService.insertBawBaseMainbrand(bawBaseMainbrand);
                    if (add_result > 0) {
                        logger.info("***接收车辆品牌信息保存成功***="+jsonArray.get(i));
                    } else {
                        logger.info("***接收车辆品牌信息保存失败***="+jsonArray.get(i));
                    }

                }
            }

        } catch (JSONException e) {
            logger.error("数据格式异常,无法转为JSON数据");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "数据格式异常,无法转为JSON数据");
        }
        ReceiveMainbrandResponse receiveMainbrandResponse=new ReceiveMainbrandResponse();
        HEAD outHead= new HEAD();
        outHead.setERRORINFO("");
        outHead.setERRORCODE("");
        outHead.setCOMMENTS("");
        outHead.setSUCCESSCOUNT("1");
        outHead.setTRANSACTIONID(transactionid);
        outHead.setRESULT("0");

        DATA outData =new DATA();
        ITEM outItem =new ITEM();
        DATA outDatas =new DATA();
        outItem.setZMMCX(carBrandCode);
        outItem.setZSTATUSRE("S");
        outItem.setZSTATUSTXT("成功");
        outData.setItem(outItem);
        RESPONSE response =new RESPONSE();
        response.setHead(outHead);
        response.setData(outData);
        receiveMainbrandResponse.setResponse(response);
        return receiveMainbrandResponse;
    }

    //车系信息同步接口
    @Autowired
    private IBawBaseCarSeriesService bawBaseCarSeriesService;
    @PostMapping("/baw_receive_car_series")
    public ReceiveMainbrandResponse receivingCarSeries(@RequestBody String requestJson) {
        logger.info("**baw_receive_car_series**requestJson="+requestJson.toString());
        //全局变量
        String transactionid=null;
        String carSeriesCode=null;
        if (StringUtils.isBlank(requestJson)) {
            logger.info("车系信息接口请求数据为空");
            return null;
        }
        InItem inItem;
        InHead inHead;
        try {
            JSONObject jsonObject = JSONObject.parseObject(requestJson);
            String head = jsonObject.getJSONObject("REQUEST").getString("HEAD");
            if(head!=null &&head.length()>0){
                logger.info("***head***="+head);
            }
            //获取HEAD头部字段
            JSONObject headJsonObject= JSON.parseObject(head);
            transactionid=headJsonObject.getString("TRANSACTIONID");
            logger.info("****transactionid***="+transactionid);
            String count=headJsonObject.getString("COUNT");
            String consumer=headJsonObject.getString("CONSUMER");
            String srvlevel=headJsonObject.getString("SRVLEVEL");
            logger.info("****srvlevel***="+srvlevel);
            String account=headJsonObject.getString("ACCOUNT");
            String password=headJsonObject.getString("PASSWORD");
            String company=headJsonObject.getString("COMPANY");
            logger.info("****company***="+company);
            //获取REQUEST中data数据
            String data = jsonObject.getJSONObject("REQUEST").getString("DATA");
            if(data!=null &&data.length()>0){
                logger.info("***data***="+data);
            }
            JSONObject itemJsonObject= JSON.parseObject(data);
            JSONArray jsonArray = null;
            jsonArray = itemJsonObject.getJSONArray("ITEM");//获取数组
            if(jsonArray.size()<=1){
                carSeriesCode= (String) jsonArray.getJSONObject(0).get("CAR_SERIES_CODE");
                String carSeriesEn =(String) jsonArray.getJSONObject(0).get("CAR_SERIES_EN");
                String carSeriesCn =(String) jsonArray.getJSONObject(0).get("CAR_SERIES_CN");
                String isEnable =(String) jsonArray.getJSONObject(0).get("IS_ENABLE");
                String carBrandCode =(String) jsonArray.getJSONObject(0).get("CAR_BRAND_CODE");
                BawBaseCarSeries  bawBaseCarSeries =new BawBaseCarSeries();
                bawBaseCarSeries.setCarSeriesCode(carSeriesCode);
                bawBaseCarSeries.setCarSeriesEn(carSeriesEn);
                bawBaseCarSeries.setCarSeriesCn(carSeriesCn);
                bawBaseCarSeries.setCarBrandCode(carBrandCode);
                bawBaseCarSeries.setIsEnable(isEnable);
                bawBaseCarSeries.setCreateBy("BAW");
                // 主库数据信息
                List<BawBaseCarSeries> bawBaseCarSeriesInfo = bawBaseCarSeriesService.selectBawBaseCarSeriesList(new BawBaseCarSeries());
                if (CollectionUtils.isNotEmpty(bawBaseCarSeriesInfo)) {
                    // 删除库中所有的数据
                    List<Integer> idList = bawBaseCarSeriesInfo.stream().map(BawBaseCarSeries::getId).collect(Collectors.toList());
                    bawBaseCarSeriesService.deleteBawBaseCarSeriesByIds(idList.toArray(new Integer[idList.size()]));
                }
                int add_result = bawBaseCarSeriesService.insertBawBaseCarSeries(bawBaseCarSeries);
                if (add_result > 0) {
                    logger.info("***接收车系信息保存成功***=");
                } else {
                    logger.info("***接收车系信息保存失败***=");
                }
            }else{
                String str;
                // 主库数据信息
                List<BawBaseCarSeries> bawBaseCarSeriesInfo = bawBaseCarSeriesService.selectBawBaseCarSeriesList(new BawBaseCarSeries());
                if (CollectionUtils.isNotEmpty(bawBaseCarSeriesInfo)) {
                    // 删除库中所有的数据
                    List<Integer> idList = bawBaseCarSeriesInfo.stream().map(BawBaseCarSeries::getId).collect(Collectors.toList());
                    bawBaseCarSeriesService.deleteBawBaseCarSeriesByIds(idList.toArray(new Integer[idList.size()]));
                }
                for(int i = 0; i < jsonArray.size(); i++){
                    Object obj = jsonArray.get(i);
                    str = obj.toString();
                    JSONObject JsonObject= JSON.parseObject(str);
                    carSeriesCode= JsonObject.getString("CAR_SERIES_CODE");
                    String carSeriesEn =JsonObject.getString("CAR_SERIES_EN");
                    String carSeriesCn =JsonObject.getString("CAR_SERIES_CN");
                    String isEnable =JsonObject.getString("IS_ENABLE");
                    String carBrandCode =JsonObject.getString("CAR_BRAND_CODE");
                    BawBaseCarSeries  bawBaseCarSeries =new BawBaseCarSeries();
                    bawBaseCarSeries.setCarSeriesCode(carSeriesCode);
                    bawBaseCarSeries.setCarSeriesEn(carSeriesEn);
                    bawBaseCarSeries.setCarSeriesCn(carSeriesCn);
                    bawBaseCarSeries.setCarBrandCode(carBrandCode);
                    bawBaseCarSeries.setIsEnable(isEnable);
                    bawBaseCarSeries.setCreateBy("BAW");
                    int add_result = bawBaseCarSeriesService.insertBawBaseCarSeries(bawBaseCarSeries);
                    System.out.println(bawBaseCarSeries);
                    if (add_result > 0) {
                        logger.info("***接收车系信息保存成功***="+jsonArray.get(i));
                    } else {
                        logger.info("***接收车系信息保存失败***="+jsonArray.get(i));
                    }

                }
            }

        } catch (JSONException e) {
            logger.error("数据格式异常,无法转为JSON数据");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "数据格式异常,无法转为JSON数据");
        }
        ReceiveMainbrandResponse receiveMainbrandResponse=new ReceiveMainbrandResponse();
        HEAD outHead= new HEAD();
        outHead.setERRORINFO("");
        outHead.setERRORCODE("");
        outHead.setCOMMENTS("");
        outHead.setSUCCESSCOUNT("1");
        outHead.setTRANSACTIONID(transactionid);
        outHead.setRESULT("0");

        DATA outData =new DATA();
        ITEM outItem =new ITEM();
        DATA outDatas =new DATA();
        outItem.setZMMCX(carSeriesCode);
        outItem.setZSTATUSRE("S");
        outItem.setZSTATUSTXT("成功");
        outData.setItem(outItem);
        RESPONSE response =new RESPONSE();
        response.setHead(outHead);
        response.setData(outData);
        receiveMainbrandResponse.setResponse(response);
        return receiveMainbrandResponse;
    }

    //车型信息同步接口
    @Autowired
    private IBawBaseCarTypeService bawBaseCarTypeService;
    @PostMapping("/baw_receive_car_model")
    public ReceiveMainbrandResponse receivingCarModel(@RequestBody String requestJson) {
        logger.info("**baw_receive_car_model**requestJson="+requestJson.toString());
        //全局变量
        String transactionid=null;
        String carTypeCode=null;
        if (StringUtils.isBlank(requestJson)) {
            logger.info("车型信息同步接口请求数据为空");
            return null;
        }
        InItem inItem;
        InHead inHead;
        try {
            JSONObject jsonObject = JSONObject.parseObject(requestJson);
            String head = jsonObject.getJSONObject("REQUEST").getString("HEAD");
            if(head!=null &&head.length()>0){
                logger.info("***head***="+head);
            }
            //获取HEAD头部字段
            JSONObject headJsonObject= JSON.parseObject(head);
            transactionid=headJsonObject.getString("TRANSACTIONID");
            logger.info("****transactionid***="+transactionid);
            String count=headJsonObject.getString("COUNT");
            String consumer=headJsonObject.getString("CONSUMER");
            String srvlevel=headJsonObject.getString("SRVLEVEL");
            logger.info("****srvlevel***="+srvlevel);
            String account=headJsonObject.getString("ACCOUNT");
            String password=headJsonObject.getString("PASSWORD");
            String company=headJsonObject.getString("COMPANY");
            logger.info("****company***="+company);
            //获取REQUEST中data数据
            String data = jsonObject.getJSONObject("REQUEST").getString("DATA");
            if(data!=null &&data.length()>0){
                logger.info("***data***="+data);
            }
            JSONObject itemJsonObject= JSON.parseObject(data);
            JSONArray jsonArray = null;
            jsonArray = itemJsonObject.getJSONArray("ITEM");//获取数组
            if(jsonArray.size()<=1){
                carTypeCode= (String) jsonArray.getJSONObject(0).get("CAR_TYPE_CODE");
                String carTypeEn =(String) jsonArray.getJSONObject(0).get("CAR_TYPE_EN");
                String carTypeCn  =(String) jsonArray.getJSONObject(0).get("CAR_TYPE_CN");
                String carSeriesCode  =(String) jsonArray.getJSONObject(0).get("CAR_SERIES_CODE");
                String isEnable =(String) jsonArray.getJSONObject(0).get("IS_ENABLE");
                BawBaseCarType bawBaseCarType =new BawBaseCarType();
                bawBaseCarType.setCarTypeCode(carTypeCode);
                bawBaseCarType.setCarTypeEn(carTypeEn);
                bawBaseCarType.setCarTypeCn(carTypeCn);
                bawBaseCarType.setCarSeriesCode(carSeriesCode);
                bawBaseCarType.setIsEnable(isEnable);
                bawBaseCarType.setCreateBy("BAW");
                // 主库数据信息
                List<BawBaseCarType> bawBaseCarTypeInfo = bawBaseCarTypeService.selectBawBaseCarTypeList(new BawBaseCarType());
                if (CollectionUtils.isNotEmpty(bawBaseCarTypeInfo)) {
                    // 删除库中所有的数据
                    List<Integer> idList = bawBaseCarTypeInfo.stream().map(BawBaseCarType::getId).collect(Collectors.toList());
                    bawBaseCarTypeService.deleteBawBaseCarTypeByIds(idList.toArray(new Integer[idList.size()]));
                }
                int add_result = bawBaseCarTypeService.insertBawBaseCarType(bawBaseCarType);
                if (add_result > 0) {
                    logger.info("***接收车型信息保存成功***=");
                } else {
                    logger.info("***接收车型信息保存失败***=");
                }
            }else{
                String str;
                // 主库数据信息
                List<BawBaseCarType> bawBaseCarTypeInfo = bawBaseCarTypeService.selectBawBaseCarTypeList(new BawBaseCarType());
                if (CollectionUtils.isNotEmpty(bawBaseCarTypeInfo)) {
                    // 删除库中所有的数据
                    List<Integer> idList = bawBaseCarTypeInfo.stream().map(BawBaseCarType::getId).collect(Collectors.toList());
                    bawBaseCarTypeService.deleteBawBaseCarTypeByIds(idList.toArray(new Integer[idList.size()]));
                }
                for(int i = 0; i < jsonArray.size(); i++){
                    Object obj = jsonArray.get(i);
                    str = obj.toString();
                    JSONObject JsonObject= JSON.parseObject(str);
                    carTypeCode=JsonObject.getString("CAR_TYPE_CODE");
                    String carTypeEn=JsonObject.getString("CAR_TYPE_EN");
                    String carTypeCn=JsonObject.getString("CAR_TYPE_CN");
                    String carSeriesCode=JsonObject.getString("CAR_SERIES_CODE");
                    String isEnable=JsonObject.getString("IS_ENABLE");
                    BawBaseCarType bawBaseCarType =new BawBaseCarType();
                    bawBaseCarType.setCarTypeCode(carTypeCode);
                    bawBaseCarType.setCarTypeEn(carTypeEn);
                    bawBaseCarType.setCarTypeCn(carTypeCn);
                    bawBaseCarType.setCarSeriesCode(carSeriesCode);
                    bawBaseCarType.setIsEnable(isEnable);
                    bawBaseCarType.setCreateBy("BAW");
                    int add_result = bawBaseCarTypeService.insertBawBaseCarType(bawBaseCarType);
                    System.out.println(bawBaseCarType);
                    if (add_result > 0) {
                        logger.info("***接收车型信息保存成功***="+jsonArray.get(i));
                    } else {
                        logger.info("***接收车型信息保存失败***="+jsonArray.get(i));
                    }

                }
            }
        } catch (JSONException e) {
            logger.error("数据格式异常,无法转为JSON数据");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "数据格式异常,无法转为JSON数据");
        }
        ReceiveMainbrandResponse receiveMainbrandResponse=new ReceiveMainbrandResponse();
        HEAD outHead= new HEAD();
        outHead.setERRORINFO("");
        outHead.setERRORCODE("");
        outHead.setCOMMENTS("");
        outHead.setSUCCESSCOUNT("1");
        outHead.setTRANSACTIONID(transactionid);
        outHead.setRESULT("0");

        DATA outData =new DATA();
        ITEM outItem =new ITEM();
        DATA outDatas =new DATA();
        outItem.setZMMCX(carTypeCode);
        outItem.setZSTATUSRE("S");
        outItem.setZSTATUSTXT("成功");
        outData.setItem(outItem);
        RESPONSE response =new RESPONSE();
        response.setHead(outHead);
        response.setData(outData);
        receiveMainbrandResponse.setResponse(response);
        return receiveMainbrandResponse;
    }

    //车型配置信息同步接口
    @Autowired
    private IBawBaseCarTypeConfigurationService bawBaseCarTypeConfigurationService;
    @Autowired
    private IBawBaseCarTypeConfigurationAppletService bawBaseCarTypeConfigurationAppletService;
    @PostMapping("/baw_receive_configuration")
    public ReceiveMainbrandResponse receivingConfiguration(@RequestBody String requestJson) {
        logger.info("**baw_receive_configuration**requestJson="+requestJson.toString());
        //全局变量
        String transactionid=null;
        String carConfigCode=null;
        if (StringUtils.isBlank(requestJson)) {
            logger.info("车型配置信息同步接口请求数据为空");
            return null;
        }
        InItem inItem;
        InHead inHead;
        try {
            JSONObject jsonObject = JSONObject.parseObject(requestJson);
            String head = jsonObject.getJSONObject("REQUEST").getString("HEAD");
            if(head!=null &&head.length()>0){
                logger.info("***head***="+head);
            }
            //获取HEAD头部字段
            JSONObject headJsonObject= JSON.parseObject(head);
            transactionid=headJsonObject.getString("TRANSACTIONID");
            logger.info("****transactionid***="+transactionid);
            String count=headJsonObject.getString("COUNT");
            String consumer=headJsonObject.getString("CONSUMER");
            String srvlevel=headJsonObject.getString("SRVLEVEL");
            logger.info("****srvlevel***="+srvlevel);
            String account=headJsonObject.getString("ACCOUNT");
            String password=headJsonObject.getString("PASSWORD");
            String company=headJsonObject.getString("COMPANY");
            logger.info("****company***="+company);
            //获取REQUEST中data数据
            String data = jsonObject.getJSONObject("REQUEST").getString("DATA");
            if(data!=null &&data.length()>0){
                logger.info("***data***="+data);
            }
            JSONObject itemJsonObject= JSON.parseObject(data);
            JSONArray jsonArray = null;
            jsonArray = itemJsonObject.getJSONArray("ITEM");//获取数组
            if(jsonArray.size()<=1){
                carConfigCode= (String) jsonArray.getJSONObject(0).get("MATNR");
                String carConfigCn =(String) jsonArray.getJSONObject(0).get("MAKTX");
                String carBrandCode =(String) jsonArray.getJSONObject(0).get("CAR_BRAND_CODE");
                String carTypeCode =(String) jsonArray.getJSONObject(0).get("CAR_TYPE_CODE");
                String carColorCode =(String) jsonArray.getJSONObject(0).get("CAR_COLOR_CODE");
                String carIncolorCode =(String) jsonArray.getJSONObject(0).get("CAR_INCOLOR_CODE");
                String isEnable =(String) jsonArray.getJSONObject(0).get("LVORM");
                BawBaseCarTypeConfiguration bawBaseCarTypeConfiguration= new BawBaseCarTypeConfiguration();
                bawBaseCarTypeConfiguration.setCarConfigCode(carConfigCode);
                bawBaseCarTypeConfiguration.setCarConfigCn(carConfigCn);
                bawBaseCarTypeConfiguration.setCarBrandCode(carBrandCode);
                bawBaseCarTypeConfiguration.setCarTypeCode(carTypeCode);
                bawBaseCarTypeConfiguration.setCarColorCode(carColorCode);
                bawBaseCarTypeConfiguration.setCarIncolorCode(carIncolorCode);
                bawBaseCarTypeConfiguration.setIsEnable(isEnable);
                bawBaseCarTypeConfiguration.setCreateBy("BAW");
                // 主库数据信息
                List<BawBaseCarTypeConfiguration> bawBaseCarTypeConfigurationInfo = bawBaseCarTypeConfigurationService.selectBawBaseCarTypeConfigurationList(new BawBaseCarTypeConfiguration());
                if (CollectionUtils.isNotEmpty(bawBaseCarTypeConfigurationInfo)) {
                    // 删除库中所有的数据
                    List<Integer> idList = bawBaseCarTypeConfigurationInfo.stream().map(BawBaseCarTypeConfiguration::getId).collect(Collectors.toList());
                    bawBaseCarTypeConfigurationService.deleteBawBaseCarTypeConfigurationByIds(idList.toArray(new Integer[idList.size()]));
                }
                //主表车型配置信息主表（baw_base_car_type_configuration_applet）
                int add_result = bawBaseCarTypeConfigurationService.insertBawBaseCarTypeConfiguration(bawBaseCarTypeConfiguration);
                if (add_result > 0) {
                    logger.info("***接收车型配置信息保存成功***=");
                } else {
                    logger.info("***接收车型配置信息保存失败***=");
                }
                //小程序专用车型配置信息表（baw_base_car_type_configuration_applet）
                int add_result_applet = bawBaseCarTypeConfigurationAppletService.insertBawBaseCarTypeConfigurationApplet(bawBaseCarTypeConfiguration);
                if (add_result_applet > 0) {
                    logger.info("***接收小程序车型配置信息保存成功***=");
                } else {
                    logger.info("***接收小程序车型配置信息保存失败***=");
                }
            }else{
                String str;
                // 主库数据信息
                List<BawBaseCarTypeConfiguration> bawBaseCarTypeConfigurationInfo = bawBaseCarTypeConfigurationService.selectBawBaseCarTypeConfigurationList(new BawBaseCarTypeConfiguration());
                if (CollectionUtils.isNotEmpty(bawBaseCarTypeConfigurationInfo)) {
                    // 删除库中所有的数据
                    List<Integer> idList = bawBaseCarTypeConfigurationInfo.stream().map(BawBaseCarTypeConfiguration::getId).collect(Collectors.toList());
                    bawBaseCarTypeConfigurationService.deleteBawBaseCarTypeConfigurationByIds(idList.toArray(new Integer[idList.size()]));
                }
                for(int i = 0; i < jsonArray.size(); i++){
                    Object obj = jsonArray.get(i);
                    str = obj.toString();
                    JSONObject JsonObject= JSON.parseObject(str);
                    carConfigCode= JsonObject.getString("MATNR");
                    String carConfigCn =JsonObject.getString("MAKTX");
                    String carBrandCode =JsonObject.getString("CAR_BRAND_CODE");
                    String carTypeCode =JsonObject.getString("CAR_TYPE_CODE");
                    String carColorCode =JsonObject.getString("CAR_COLOR_CODE");
                    String carIncolorCode =JsonObject.getString("CAR_INCOLOR_CODE");
                    String isEnable =JsonObject.getString("LVORM");
                    BawBaseCarTypeConfiguration bawBaseCarTypeConfiguration= new BawBaseCarTypeConfiguration();
                    bawBaseCarTypeConfiguration.setCarConfigCode(carConfigCode);
                    bawBaseCarTypeConfiguration.setCarConfigCn(carConfigCn);
                    bawBaseCarTypeConfiguration.setCarBrandCode(carBrandCode);
                    bawBaseCarTypeConfiguration.setCarTypeCode(carTypeCode);
                    bawBaseCarTypeConfiguration.setCarColorCode(carColorCode);
                    bawBaseCarTypeConfiguration.setCarIncolorCode(carIncolorCode);
                    bawBaseCarTypeConfiguration.setIsEnable(isEnable);
                    bawBaseCarTypeConfiguration.setCreateBy("BAW");
                    //主表车型配置信息主表（baw_base_car_type_configuration）
                    int add_result = bawBaseCarTypeConfigurationService.insertBawBaseCarTypeConfiguration(bawBaseCarTypeConfiguration);
                    if (add_result > 0) {
                        logger.info("***接收车型配置信息保存成功***=");
                    } else {
                        logger.info("***接收车型配置信息保存失败***=");
                    }
                    //小程序专用车型配置信息表（baw_base_car_type_configuration_applet）
                    int add_result_applet = bawBaseCarTypeConfigurationAppletService.insertBawBaseCarTypeConfigurationApplet(bawBaseCarTypeConfiguration);
                    if (add_result_applet > 0) {
                        logger.info("***接收小程序车型配置信息保存成功***=");
                    } else {
                        logger.info("***接收小程序车型配置信息保存失败***=");
                    }

                }
            }
        } catch (JSONException e) {
            logger.error("数据格式异常,无法转为JSON数据");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "数据格式异常,无法转为JSON数据");
        }
        ReceiveMainbrandResponse receiveMainbrandResponse=new ReceiveMainbrandResponse();
        HEAD outHead= new HEAD();
        outHead.setERRORINFO("");
        outHead.setERRORCODE("");
        outHead.setCOMMENTS("");
        outHead.setSUCCESSCOUNT("1");
        outHead.setTRANSACTIONID(transactionid);
        outHead.setRESULT("0");

        DATA outData =new DATA();
        ITEM outItem =new ITEM();
        DATA outDatas =new DATA();
        outItem.setZMMCX(carConfigCode);
        outItem.setZSTATUSRE("S");
        outItem.setZSTATUSTXT("成功");
        outData.setItem(outItem);
        RESPONSE response =new RESPONSE();
        response.setHead(outHead);
        response.setData(outData);
        receiveMainbrandResponse.setResponse(response);
        return receiveMainbrandResponse;
    }

    //门店信息同步接口
    @Autowired
    private IBawBaseDealershopService BawBaseDealershopService;
    @PostMapping("/baw_receive_store_information")
    public ReceiveMainbrandResponse receivingStoreInformation(@RequestBody String requestJson) {
        logger.info("**baw_receive_store_information**requestJson="+requestJson.toString());
        //全局变量
        String transactionid=null;
        if (StringUtils.isBlank(requestJson)) {
            logger.info("门店信息同步接口请求数据为空");
            return null;
        }
        InItem inItem;
        InHead inHead;
        try {
            JSONObject jsonObject = JSONObject.parseObject(requestJson);
            String head = jsonObject.getJSONObject("REQUEST").getString("HEAD");
            if(head!=null &&head.length()>0){
                logger.info("***head***="+head);
            }
            //获取HEAD头部字段
            JSONObject headJsonObject= JSON.parseObject(head);
            transactionid=headJsonObject.getString("TRANSACTIONID");
            logger.info("****transactionid***="+transactionid);
            String count=headJsonObject.getString("COUNT");
            String consumer=headJsonObject.getString("CONSUMER");
            String srvlevel=headJsonObject.getString("SRVLEVEL");
            logger.info("****srvlevel***="+srvlevel);
            //String account=headJsonObject.getString("ACCOUNT");
            //String password=headJsonObject.getString("PASSWORD");
            String company=headJsonObject.getString("COMPANY");
            logger.info("****company***="+company);
            //获取REQUEST中data数据
            String data = jsonObject.getJSONObject("REQUEST").getString("DATA");
            if(data!=null &&data.length()>0){
                logger.info("***data***="+data);
            }
            JSONObject itemJsonObject= JSON.parseObject(data);
            JSONArray jsonArray = null;
            jsonArray = itemJsonObject.getJSONArray("ITEM");//获取数组
            String dlrCode= (String) jsonArray.getJSONObject(0).get("DLR_CODE");//crm客户代码
            String buSort1 =(String) jsonArray.getJSONObject(0).get("BU_SORT1");//客户简称
            String nameOrg1 =(String) jsonArray.getJSONObject(0).get("NAME_ORG1");//客户全称
            String zdlrType =(String) jsonArray.getJSONObject(0).get("ZDLR_TYPE");//门店类别
            String orgType= (String) jsonArray.getJSONObject(0).get("ORG_TYPE");//专营店类别
            String street =(String) jsonArray.getJSONObject(0).get("STREET");//门店地址
            String postCode1 =(String) jsonArray.getJSONObject(0).get("POST_CODE1");//邮编
            String region =(String) jsonArray.getJSONObject(0).get("REGION");//省代码
            String cityc= (String) jsonArray.getJSONObject(0).get("CITYC");//市代码
            String counc =(String) jsonArray.getJSONObject(0).get("COUNC");//县代码
            String bzirk =(String) jsonArray.getJSONObject(0).get("BZIRK");//大区
            String vkbur =(String) jsonArray.getJSONObject(0).get("VKBUR");//销售办事处
            String adext =(String) jsonArray.getJSONObject(0).get("ADEXT");
            String isEnable =(String) jsonArray.getJSONObject(0).get("IS_ENABLE");
            String mobNumber =(String) jsonArray.getJSONObject(0).get("MOB_NUMBER");
            String telNumber =(String) jsonArray.getJSONObject(0).get("TEL_NUMBER");
            String smtpAddr =(String) jsonArray.getJSONObject(0).get("SMTP_ADDR");
            String faxNumber =(String) jsonArray.getJSONObject(0).get("FAX_NUMBER");
            String storeCar =(String) jsonArray.getJSONObject(0).get("ZREVS3");
            logger.info("**门店信息同步接口**storeCar***="+storeCar);
            String kunnr =(String) jsonArray.getJSONObject(0).get("KUNNR");
            String lng =(String) jsonArray.getJSONObject(0).get("LNG");
            String lat =(String) jsonArray.getJSONObject(0).get("LAT");
            String onlineFlag =(String) jsonArray.getJSONObject(0).get("ONLINE_FLAG");
            String dlrStatus =(String) jsonArray.getJSONObject(0).get("DLR_STATUS");
            //VITEM
            JSONArray jsonArray1 = null;
            jsonArray1  = itemJsonObject.getJSONArray("ITEM").getJSONObject(0).getJSONArray("VITEM");
            String eikto= (String) jsonArray.getJSONObject(0).get("EIKTO");//客户代码
            BawBaseDealershop bawBaseDealershop =new BawBaseDealershop();
            bawBaseDealershop.setDlrCode(dlrCode);
            bawBaseDealershop.setKunnr(kunnr);
            bawBaseDealershop.setBuSort1(buSort1);
            bawBaseDealershop.setNameOrg1(nameOrg1);
            bawBaseDealershop.setZdlrType(zdlrType);
            bawBaseDealershop.setEikto(eikto);
            bawBaseDealershop.setOrgType(orgType);
            bawBaseDealershop.setStreet(street);
            bawBaseDealershop.setPostCode1(postCode1);
            bawBaseDealershop.setRegion(region);
            bawBaseDealershop.setCityc(cityc);
            bawBaseDealershop.setCounc(counc);
            bawBaseDealershop.setBzirk(bzirk);
            bawBaseDealershop.setVkbur(vkbur);
            bawBaseDealershop.setAdext(adext);
            bawBaseDealershop.setLat(lat);
            bawBaseDealershop.setLng(lng);
            bawBaseDealershop.setOnlineFlag(onlineFlag);
            bawBaseDealershop.setDlrStatus(dlrStatus);
            bawBaseDealershop.setIsEnable(isEnable);
            bawBaseDealershop.setMobNumber(mobNumber);
            bawBaseDealershop.setTelNumber(telNumber);
            bawBaseDealershop.setSmtpAddr(smtpAddr);
            bawBaseDealershop.setFaxNumber(faxNumber);
            bawBaseDealershop.setStoreCar(storeCar);
            bawBaseDealershop.setCreateBy("BAW");
            List<BawBaseDealershop> modelList = BawBaseDealershopService.selectBawBaseDealershopByDlrCode(dlrCode);
            if(null == modelList || modelList.size() ==0 ){
                int add_result = BawBaseDealershopService.insertBawBaseDealershop(bawBaseDealershop);
                if (add_result > 0) {
                    logger.info("***接收门店信息保存成功***");
                } else {
                    logger.info("***接收门店信息保存失败***");
                }
            }else{
                bawBaseDealershop.setId(modelList.get(0).getId());
                Date date = new Date();
                bawBaseDealershop.setUpdateTime(date);
                int update_result = BawBaseDealershopService.updateBawBaseDealershop(bawBaseDealershop);
                if (update_result > 0) {
                    logger.info("***接收门店信息修改成功***");
                } else {
                    logger.info("***接收门店信息修改失败***");
                }
            }
           /* //VITEM
            JSONArray jsonArray1 = null;
            jsonArray1  = itemJsonObject.getJSONArray("ITEM").getJSONObject(0).getJSONArray("VITEM");
            String eikto= (String) jsonArray.getJSONObject(0).get("EIKTO");//客户代码
            String nameOrg2 =(String) jsonArray.getJSONObject(0).get("NAME_ORG1");//客户全称
            String postCode2 =(String) jsonArray.getJSONObject(0).get("POST_CODE1");//邮编
            String region2 =(String) jsonArray.getJSONObject(0).get("REGION");//省代码
            String cityc2= (String) jsonArray.getJSONObject(0).get("CITYC");//市代码
            String counc2 =(String) jsonArray.getJSONObject(0).get("COUNC");//县代码
            String street2 =(String) jsonArray.getJSONObject(0).get("STREET");//门店地址
            String adext2 =(String) jsonArray.getJSONObject(0).get("ADEXT");
            String telNumber2 =(String) jsonArray.getJSONObject(0).get("TEL_NUMBER");
            String faxNumber2 =(String) jsonArray.getJSONObject(0).get("FAX_NUMBER");
            int add_result = bawBaseCarTypeConfigurationService.insertBawBaseCarTypeConfiguration(bawBaseCarTypeConfiguration);
            if (add_result > 0) {
                logger.info("***接收车型配置信息保存成功***=");
            } else {
                logger.info("***接收车型配置信息保存失败***=");
            }
            //PITEM
            jsonArray1  = itemJsonObject.getJSONArray("ITEM").getJSONObject(0).getJSONArray("PITEM");
            String eikto3= (String) jsonArray.getJSONObject(0).get("EIKTO");//客户代码
            String nameOrg3 =(String) jsonArray.getJSONObject(0).get("NAME_ORG1");//客户全称
            String postCode3 =(String) jsonArray.getJSONObject(0).get("POST_CODE1");//邮编
            String region3 =(String) jsonArray.getJSONObject(0).get("REGION");//省代码
            String cityc3= (String) jsonArray.getJSONObject(0).get("CITYC");//市代码
            String counc3 =(String) jsonArray.getJSONObject(0).get("COUNC");//县代码
            String street3 =(String) jsonArray.getJSONObject(0).get("STREET");//门店地址
            String adext3 =(String) jsonArray.getJSONObject(0).get("ADEXT");
            String telNumber3 =(String) jsonArray.getJSONObject(0).get("TEL_NUMBER");
            String faxNumber3 =(String) jsonArray.getJSONObject(0).get("FAX_NUMBER");

            //ZBANK
            jsonArray1  = itemJsonObject.getJSONArray("ITEM").getJSONObject(0).getJSONArray("ZBANK");
            String bankl= (String) jsonArray.getJSONObject(0).get("BANKL");
            String bankn =(String) jsonArray.getJSONObject(0).get("BANKN");
            String banka =(String) jsonArray.getJSONObject(0).get("BANKA");
            logger.info("***jsonArray1***="+jsonArray1);
            String eIKTO= (String) jsonArray.getJSONObject(0).get("EIKTO");
            logger.info("***eIKTO***="+eIKTO);*/
        } catch (JSONException e) {
            logger.error("数据格式异常,无法转为JSON数据");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "数据格式异常,无法转为JSON数据");
        }
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateNowStr = sdf.format(d);
        logger.info("***格式化后的日期=dateNowStr***="+dateNowStr);
        ReceiveMainbrandResponse receiveMainbrandResponse=new ReceiveMainbrandResponse();
        HEAD outHead= new HEAD();
        outHead.setERRORINFO("");
        outHead.setERRORCODE("");
        outHead.setCOMMENTS("");
        outHead.setSUCCESSCOUNT("1");
        outHead.setTRANSACTIONID(transactionid);
        outHead.setRESULT("0");

        DATA outData =new DATA();
        ITEM outItem =new ITEM();
        DATA outDatas =new DATA();
        outItem.setDLR_CODE("CRMCT00001");
        outItem.setKUNNR("0006000233");
        outItem.setZTYPE("S");
        outItem.setZMESSAGE("客户创建成功");
        outItem.setZDATE(dateNowStr);
        outItem.setZTIME("110656");
        outData.setItem(outItem);
        RESPONSE response =new RESPONSE();
        response.setHead(outHead);
        response.setData(outData);
        receiveMainbrandResponse.setResponse(response);
        return receiveMainbrandResponse;
    }


    //产品线信息同步接口
    @Autowired
    private IBawBaseProductLineService bawBaseProductLineService;
    @PostMapping("/baw_base_product_line")
    public ReceiveMainbrandResponse receivingBawBaseProductLine(@RequestBody String requestJson) {
        logger.info("**baw_receive_baw_base_product_line**requestJson="+requestJson.toString());
        //全局变量
        Date date = new Date();
        String transactionid=null;
        String carCatagoriesCode=null;
        if (StringUtils.isBlank(requestJson)) {
            logger.info("产品线信息同步接口请求数据为空");
            return null;
        }
        InItem inItem;
        InHead inHead;
        try {
            JSONObject jsonObject = JSONObject.parseObject(requestJson);
            String head = jsonObject.getJSONObject("REQUEST").getString("HEAD");
            if(head!=null &&head.length()>0){
                logger.info("***head***="+head);
            }
            //获取HEAD头部字段
            JSONObject headJsonObject= JSON.parseObject(head);
            transactionid=headJsonObject.getString("TRANSACTIONID");
            logger.info("****transactionid***="+transactionid);
            String count=headJsonObject.getString("COUNT");
            String consumer=headJsonObject.getString("CONSUMER");
            String srvlevel=headJsonObject.getString("SRVLEVEL");
            logger.info("****srvlevel***="+srvlevel);
            String account=headJsonObject.getString("ACCOUNT");
            String password=headJsonObject.getString("PASSWORD");
            String company=headJsonObject.getString("COMPANY");
            logger.info("****company***="+company);
            //获取REQUEST中data数据
            String data = jsonObject.getJSONObject("REQUEST").getString("DATA");
            if(data!=null &&data.length()>0){
                logger.info("***data***="+data);
            }
            JSONObject itemJsonObject= JSON.parseObject(data);
            JSONArray jsonArray = null;
            jsonArray = itemJsonObject.getJSONArray("ITEM");//获取数组
            if(jsonArray.size()<=1){
                carCatagoriesCode= (String) jsonArray.getJSONObject(0).get("CAR_CATAGORIES_CODE");
                String carCatagoriesEn =(String) jsonArray.getJSONObject(0).get("CAR_CATAGORIES_EN");
                String carCatagoriesCn =(String) jsonArray.getJSONObject(0).get("CAR_CATAGORIES_CN");
                String carBrandCode =(String) jsonArray.getJSONObject(0).get("CAR_BRAND_CODE");
                String isEnable =(String) jsonArray.getJSONObject(0).get("IS_ENABLE");
                BawBaseProductLine bawBaseProductLine= new BawBaseProductLine();
                bawBaseProductLine.setCarCatagoriesEn(carCatagoriesEn);
                bawBaseProductLine.setCarCatagoriesCn(carCatagoriesCn);
                bawBaseProductLine.setCarBrandCode(carBrandCode);
                bawBaseProductLine.setCarCatagoriesCode(carCatagoriesCode);
                bawBaseProductLine.setCreateTime(date);
                bawBaseProductLine.setIsEnable(isEnable);
                bawBaseProductLine.setCreateBy("BAW");
                // 主库数据信息
                List<BawBaseProductLine> bawBaseProductLineInfo = bawBaseProductLineService.selectbawBaseProductLineList(new BawBaseProductLine());
                if (CollectionUtils.isNotEmpty(bawBaseProductLineInfo)) {
                    // 删除库中所有的数据
                    List<Integer> idList = bawBaseProductLineInfo.stream().map(BawBaseProductLine::getId).collect(Collectors.toList());
                    bawBaseProductLineService.deletebawBaseProductLineByIds(idList.toArray(new Integer[idList.size()]));
                }
                int add_result = bawBaseProductLineService.insertbawBaseProductLine(bawBaseProductLine);
                if (add_result > 0) {
                    logger.info("****接收产品线信息保存成功****=");
                } else {
                    logger.info("***接收产品线信息保存失败***=");
                }
            }else{
                String str;
                // 主库数据信息
                List<BawBaseProductLine> bawBaseProductLineInfo = bawBaseProductLineService.selectbawBaseProductLineList(new BawBaseProductLine());
                if (CollectionUtils.isNotEmpty(bawBaseProductLineInfo)) {
                    // 删除库中所有的数据
                    List<Integer> idList = bawBaseProductLineInfo.stream().map(BawBaseProductLine::getId).collect(Collectors.toList());
                    bawBaseProductLineService.deletebawBaseProductLineByIds(idList.toArray(new Integer[idList.size()]));
                }
                for(int i = 0; i < jsonArray.size(); i++){
                    Object obj = jsonArray.get(i);
                    str = obj.toString();
                    JSONObject JsonObject= JSON.parseObject(str);
                    carCatagoriesCode= JsonObject.getString("CAR_CATAGORIES_CODE");
                    String carCatagoriesEn =JsonObject.getString("CAR_CATAGORIES_EN");
                    String carCatagoriesCn =JsonObject.getString("CAR_CATAGORIES_CN");
                    String carBrandCode =JsonObject.getString("CAR_BRAND_CODE");
                    String isEnable =JsonObject.getString("IS_ENABLE");
                    BawBaseProductLine bawBaseProductLine= new BawBaseProductLine();
                    bawBaseProductLine.setCarCatagoriesEn(carCatagoriesEn);
                    bawBaseProductLine.setCarCatagoriesCn(carCatagoriesCn);
                    bawBaseProductLine.setCarBrandCode(carBrandCode);
                    bawBaseProductLine.setCarCatagoriesCode(carCatagoriesCode);
                    bawBaseProductLine.setCreateTime(date);
                    bawBaseProductLine.setIsEnable(isEnable);
                    bawBaseProductLine.setCreateBy("BAW");
                    int add_result = bawBaseProductLineService.insertbawBaseProductLine(bawBaseProductLine);
                    if (add_result > 0) {
                        logger.info("***接收产品线信息保存成功***=");
                    } else {
                        logger.info("***接收产品线信息保存失败***=");
                    }

                }
            }
        } catch (JSONException e) {
            logger.error("数据格式异常,无法转为JSON数据");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "数据格式异常,无法转为JSON数据");
        }
        ReceiveMainbrandResponse receiveMainbrandResponse=new ReceiveMainbrandResponse();
        HEAD outHead= new HEAD();
        outHead.setERRORINFO("");
        outHead.setERRORCODE("");
        outHead.setCOMMENTS("");
        outHead.setSUCCESSCOUNT("1");
        outHead.setTRANSACTIONID(transactionid);
        outHead.setRESULT("0");

        DATA outData =new DATA();
        ITEM outItem =new ITEM();
        DATA outDatas =new DATA();
        outItem.setZMMCX(carCatagoriesCode);
        outItem.setZSTATUSRE("S");
        outItem.setZSTATUSTXT("成功");
        outData.setItem(outItem);
        RESPONSE response =new RESPONSE();
        response.setHead(outHead);
        response.setData(outData);
        receiveMainbrandResponse.setResponse(response);
        return receiveMainbrandResponse;
    }

}
