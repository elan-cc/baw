package com.ruoyi.web.controller;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.domain.*;
import com.ruoyi.web.service.*;
import com.ruoyi.web.utils.MyDateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.io.File;
@Api(tags = "api接口")
@RestController
@CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET, RequestMethod.POST})//允许跨域
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ServerConfig serverConfig;


    //获取媒体报道列表接口
    @Autowired
    private IBawMediaCoverageService bawMediaCoverageService;

    @PostMapping("/get_baw_media_coverage_list")
    public AjaxResult getBawMediaCoverageList(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                              @RequestParam(name = "pageSize", defaultValue = "9") Integer pageSize,
                                              @RequestParam(name = "year", defaultValue = "0") Integer year,
                                              @RequestParam(name = "month", defaultValue = "0") Integer month,
                                              @RequestParam(name = "keywords", defaultValue = "") String keywords) {
        PageHelper.startPage(pageNum, pageSize, "fabu_date desc");
        List<ModelMap> modelList = bawMediaCoverageService.selectBawMediaCoverageListForApi(0, 0, year, month, keywords);
        for (int i = 0; i < modelList.size(); i++) {
            ModelMap item = modelList.get(i);
            item.put("fabu_date_format", MyDateUtils.timestampToString(Convert.toInt(item.get("fabu_date")), "yyyy-MM-dd"));
            item.put("pic", serverConfig.getUrl() + item.get("pic"));
            item.put("content", item.get("content").toString().replaceAll("/profile/upload/", serverConfig.getUrl() + "/profile/upload/"));
            modelList.set(i, item);
        }
        return AjaxResult.success(modelList);
    }

    //获取媒体报道详情接口
    @PostMapping("/get_baw_media_coverage_by_id")
    public AjaxResult getBawMediaCoverageById(@RequestParam(name = "id", required = true) Integer id) {
        ModelMap model = bawMediaCoverageService.selectBawMediaCoverageByIdForApi(id);
        if (StringUtils.isNotNull(model)) {
            model.put("fabu_date_format", MyDateUtils.timestampToString(Convert.toInt(model.get("fabu_date")), "yyyy-MM-dd"));
            model.put("pic", serverConfig.getUrl() + model.get("pic"));
            model.put("content", model.get("content").toString().replaceAll("/profile/upload/", serverConfig.getUrl() + "/profile/upload/"));
            return AjaxResult.success(model);
        } else {
            return AjaxResult.error("数据不存在");
        }
    }

    //获取媒体中心年月列表接口
    @PostMapping("/get_baw_media_coverage_year_and_month_list")
    public AjaxResult getBawMediaCoverageYearMonthList() {
        List<ModelMap> yearMonthListResult = bawMediaCoverageService.selectBawMediaCoverageYearMonthListForApi();
        List<ModelMap> yearMonthList = new ArrayList<ModelMap>() {
        };

        List<String> yearsList = yearMonthListResult.stream().map(s -> s.get("date_year").toString()).distinct().collect(Collectors.toList());
        for (String years : yearsList) {

            List<ModelMap> monthList = yearMonthListResult.stream().filter(s -> s.get("date_year").toString().equals(years)).collect(Collectors
                    .toList());

            ModelMap add_data = new ModelMap();
            add_data.put("year", years);

            List<ModelMap> months = new ArrayList<>();
            for (ModelMap item : monthList) {
                ModelMap add_month_data = new ModelMap();
                add_month_data.put("month", item.get("date_month").toString());
                months.add(add_month_data);
            }

            add_data.put("months", months);

            yearMonthList.add(add_data);

        }

        ModelMap result_data = new ModelMap();
        result_data.put("years_list", yearMonthList);
        return AjaxResult.success(result_data);
    }


    //获取企业新闻列表接口
    @Autowired
    private IBawCompanyNewsService bawCompanyNewsService;

    @PostMapping("/get_baw_company_news_list")
    public AjaxResult getBawCompanyNewsList(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(name = "pageSize", defaultValue = "9") Integer pageSize,
                                            @RequestParam(name = "year", defaultValue = "0") Integer year,
                                            @RequestParam(name = "month", defaultValue = "0") Integer month,
                                            @RequestParam(name = "keywords", defaultValue = "") String keywords) {
        PageHelper.startPage(pageNum, pageSize, "fabu_date desc");
        List<ModelMap> modelList = bawCompanyNewsService.selectBawCompanyNewsListForApi(0, 0, year, month, keywords);
        for (int i = 0; i < modelList.size(); i++) {
            ModelMap item = modelList.get(i);
            item.put("fabu_date_format", MyDateUtils.timestampToString(Convert.toInt(item.get("fabu_date")), "yyyy-MM-dd"));
            item.put("pic", serverConfig.getUrl() + item.get("pic"));
            item.put("content", item.get("content").toString().replaceAll("/profile/upload/", serverConfig.getUrl() + "/profile/upload/"));
            modelList.set(i, item);
        }
        return AjaxResult.success(modelList);
    }

    //获取企业新闻详情接口
    @PostMapping("/get_baw_company_news_by_id")
    public AjaxResult getBawCompanyNewsById(@RequestParam(name = "id", required = true) Integer id) {
        ModelMap model = bawCompanyNewsService.selectBawCompanyNewsByIdForApi(id);
        if (StringUtils.isNotNull(model)) {
            model.put("fabu_date_format", MyDateUtils.timestampToString(Convert.toInt(model.get("fabu_date")), "yyyy-MM-dd"));
            model.put("pic", serverConfig.getUrl() + model.get("pic"));
            model.put("content", model.get("content").toString().replaceAll("/profile/upload/", serverConfig.getUrl() + "/profile/upload/"));
            return AjaxResult.success(model);
        } else {
            return AjaxResult.error("数据不存在");
        }
    }

    //获取企业新闻年月列表接口
    @PostMapping("/get_baw_company_news_year_and_month_list")
    public AjaxResult getBawCompanyYearMonthList() {
        List<ModelMap> yearMonthListResult = bawCompanyNewsService.selectBawCompanyNewsYearMonthListForApi();
        List<ModelMap> yearMonthList = new ArrayList<ModelMap>() {
        };

        List<String> yearsList = yearMonthListResult.stream().map(s -> s.get("date_year").toString()).distinct().collect(Collectors.toList());
        for (String years : yearsList) {

            List<ModelMap> monthList = yearMonthListResult.stream().filter(s -> s.get("date_year").toString().equals(years)).collect(Collectors
                    .toList());

            ModelMap add_data = new ModelMap();
            add_data.put("year", years);

            List<ModelMap> months = new ArrayList<>();
            for (ModelMap item : monthList) {
                ModelMap add_month_data = new ModelMap();
                add_month_data.put("month", item.get("date_month").toString());
                months.add(add_month_data);
            }

            add_data.put("months", months);

            yearMonthList.add(add_data);

        }

        ModelMap result_data = new ModelMap();
        result_data.put("years_list", yearMonthList);
        return AjaxResult.success(result_data);
    }


    //获取专题活动列表接口
    @Autowired
    private IBawTopicActivityService bawTopicActivityService;

    @PostMapping("/get_baw_topic_activity_list")
    public AjaxResult getBawTopicActivityList(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                              @RequestParam(name = "pageSize", defaultValue = "9") Integer pageSize,
                                              @RequestParam(name = "year", defaultValue = "0") Integer year,
                                              @RequestParam(name = "month", defaultValue = "0") Integer month,
                                              @RequestParam(name = "activityStatus", defaultValue = "0") Integer activityStatus,
                                              @RequestParam(name = "activityType", defaultValue = "0") Integer activityType,
                                              @RequestParam(name = "keywords", defaultValue = "") String keywords) {
        PageHelper.startPage(pageNum, pageSize, "fabu_date desc");
        List<ModelMap> modelList = bawTopicActivityService.selectBawTopicActivityListForApi(0, 0, year, month, activityStatus, activityType,
                keywords);
        for (int i = 0; i < modelList.size(); i++) {
            ModelMap item = modelList.get(i);
            item.put("fabu_date_format", MyDateUtils.timestampToString(Convert.toInt(item.get("fabu_date")), "yyyy-MM-dd"));
            item.put("pic", serverConfig.getUrl() + item.get("pic"));
            item.put("content", item.get("content").toString().replaceAll("/profile/upload/", serverConfig.getUrl() + "/profile/upload/"));
            modelList.set(i, item);
        }
        return AjaxResult.success(modelList);
    }

    //获取专题活动详情接口
    @PostMapping("/get_baw_topic_activity_by_id")
    public AjaxResult getBawTopicActivityById(@RequestParam(name = "id", required = true) Integer id) {
        ModelMap model = bawTopicActivityService.selectBawTopicActivityByIdForApi(id);
        if (StringUtils.isNotNull(model)) {
            model.put("fabu_date_format", MyDateUtils.timestampToString(Convert.toInt(model.get("fabu_date")), "yyyy-MM-dd"));
            model.put("pic", serverConfig.getUrl() + model.get("pic"));
            model.put("content", model.get("content").toString().replaceAll("/profile/upload/", serverConfig.getUrl() + "/profile/upload/"));
            return AjaxResult.success(model);
        } else {
            return AjaxResult.error("数据不存在");
        }
    }

    //获取专题活动年月列表接口
    @PostMapping("/get_baw_topic_activity_year_and_month_list")
    public AjaxResult getBawTopicActivityYearMonthList() {
        List<ModelMap> yearMonthListResult = bawTopicActivityService.selectBawTopicActivityYearMonthListForApi();
        List<ModelMap> yearMonthList = new ArrayList<ModelMap>() {
        };

        List<String> yearsList = yearMonthListResult.stream().map(s -> s.get("date_year").toString()).distinct().collect(Collectors.toList());
        for (String years : yearsList) {

            List<ModelMap> monthList = yearMonthListResult.stream().filter(s -> s.get("date_year").toString().equals(years)).collect(Collectors
                    .toList());

            ModelMap add_data = new ModelMap();
            add_data.put("year", years);

            List<ModelMap> months = new ArrayList<>();
            for (ModelMap item : monthList) {
                ModelMap add_month_data = new ModelMap();
                add_month_data.put("month", item.get("date_month").toString());
                months.add(add_month_data);
            }

            add_data.put("months", months);

            yearMonthList.add(add_data);

        }

        ModelMap result_data = new ModelMap();
        result_data.put("years_list", yearMonthList);
        return AjaxResult.success(result_data);
    }


    //获取媒体中心列表接口
    @Autowired
    private IBawMeidaCenterService bawMeidaCenterService;

    @PostMapping("/get_baw_meida_center_list")
    public AjaxResult getBawMeidaCenterList(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(name = "pageSize", defaultValue = "9") Integer pageSize,
                                            @RequestParam(name = "year", defaultValue = "0") Integer year,
                                            @RequestParam(name = "month", defaultValue = "0") Integer month,
                                            @RequestParam(name = "mediaType", defaultValue = "0") Integer mediaType,
                                            @RequestParam(name = "keywords", defaultValue = "") String keywords) {
        PageHelper.startPage(pageNum, pageSize, "fabu_date desc");
        List<ModelMap> modelList = bawMeidaCenterService.selectBawMeidaCenterListForApi(0, 0, year, month, mediaType, keywords);
        for (int i = 0; i < modelList.size(); i++) {
            ModelMap item = modelList.get(i);
            item.put("fabu_date_format", MyDateUtils.timestampToString(Convert.toInt(item.get("fabu_date")), "yyyy-MM-dd"));
            item.put("pic", serverConfig.getUrl() + item.get("pic"));
            item.put("content", item.get("content").toString().replaceAll("/profile/upload/", serverConfig.getUrl() + "/profile/upload/"));
            modelList.set(i, item);
        }
        return AjaxResult.success(modelList);
    }

    //获取媒体中心详情接口
    @PostMapping("/get_baw_meida_center_by_id")
    public AjaxResult getBawMeidaCenterById(@RequestParam(name = "id", required = true) Integer id) {
        ModelMap model = bawMeidaCenterService.selectBawMeidaCenterByIdForApi(id);
        if (StringUtils.isNotNull(model)) {
            model.put("fabu_date_format", MyDateUtils.timestampToString(Convert.toInt(model.get("fabu_date")), "yyyy-MM-dd"));
            model.put("pic", serverConfig.getUrl() + model.get("pic"));
            model.put("content", model.get("content").toString().replaceAll("/profile/upload/", serverConfig.getUrl() + "/profile/upload/"));
            return AjaxResult.success(model);
        } else {
            return AjaxResult.error("数据不存在");
        }
    }

    //获取媒体中心年月列表接口
    @PostMapping("/get_baw_meida_center_year_and_month_list")
    public AjaxResult getBawMeidaCenterYearMonthList() {
        List<ModelMap> yearMonthListResult = bawMeidaCenterService.selectBawMeidaCenterYearMonthListForApi();
        List<ModelMap> yearMonthList = new ArrayList<ModelMap>() {
        };

        List<String> yearsList = yearMonthListResult.stream().map(s -> s.get("date_year").toString()).distinct().collect(Collectors.toList());
        for (String years : yearsList) {

            List<ModelMap> monthList = yearMonthListResult.stream().filter(s -> s.get("date_year").toString().equals(years)).collect(Collectors
                    .toList());

            ModelMap add_data = new ModelMap();
            add_data.put("year", years);

            List<ModelMap> months = new ArrayList<>();
            for (ModelMap item : monthList) {
                ModelMap add_month_data = new ModelMap();
                add_month_data.put("month", item.get("date_month").toString());
                months.add(add_month_data);
            }

            add_data.put("months", months);

            yearMonthList.add(add_data);

        }

        ModelMap result_data = new ModelMap();
        result_data.put("years_list", yearMonthList);
        return AjaxResult.success(result_data);
    }



    //获取加入我们工作地点列表接口
    @PostMapping("/get_baw_zhaopin_job_place_list")
    public AjaxResult getBawZhaopinJobPlaceList() {
        List<ModelMap> modelList = bawZhaopinService.selectBawZhaopinJobPlaceListForApi();
        return AjaxResult.success(modelList);
    }


    //获取加入我们（招聘）列表接口
    @Autowired
    private IBawZhaopinService bawZhaopinService;

    @PostMapping("/get_baw_zhaopin_list")
    public AjaxResult getBawZhaopinList(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                        @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize,
                                        @RequestParam(name = "jobName", defaultValue = "") String jobName,
                                        @RequestParam(name = "jobType", defaultValue = "") String jobType,
                                        @RequestParam(name = "jobPlace", defaultValue = "") String jobPlace,
                                        @RequestParam(name = "keywords", defaultValue = "") String keywords) {
        PageHelper.startPage(pageNum, pageSize, "id desc");
        List<ModelMap> modelList = bawZhaopinService.selectBawZhaopinListForApi(0, 0,jobName,jobType,jobPlace, keywords);
        for (int i = 0; i < modelList.size(); i++) {
            ModelMap item = modelList.get(i);
            item.put("add_date_format", MyDateUtils.timestampToString(Convert.toInt(item.get("add_date")), "yyyy-MM-dd"));
            modelList.set(i, item);
        }
        return AjaxResult.success(modelList);
    }


    //获取首页顶部KV列表接口
    @Autowired
    private IBawIndexKvService bawIndexKvService;

    @PostMapping("/get_baw_index_kv_list")
    public AjaxResult getBawIndexKvList() {
        List<ModelMap> modelList = bawIndexKvService.selectBawIndexKvListForApi(0, 0);
        for (int i = 0; i < modelList.size(); i++) {
            ModelMap item = modelList.get(i);
            item.put("kv_file", serverConfig.getUrl() + item.get("kv_file"));
            modelList.set(i, item);
        }
        return AjaxResult.success(modelList);
    }


    //获取首页底部模块数据（只会返回一条）接口
    @Autowired
    private IBawIndexModel1Service bawIndexModel1Service;

    @PostMapping("/get_baw_index_model1_list")
    public AjaxResult getBawIndexModel1List() {
        PageHelper.startPage(1, 1, "id desc");
        List<ModelMap> modelList = bawIndexModel1Service.selectBawIndexModel1ListForApi(0, 0);
        for (int i = 0; i < modelList.size(); i++) {
            ModelMap item = modelList.get(i);
            item.put("pic", serverConfig.getUrl() + item.get("pic"));
            modelList.set(i, item);
        }
        return AjaxResult.success(modelList);
    }


    //获取经销商加盟城市列表接口
    @Autowired
    private IBawDealersJoinService bawDealersJoinService;
    
    @ApiOperation("获取经销商加盟城市列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "province", value = "省份", paramType = "query", dataType = "String", required = false),
            @ApiImplicitParam(name = "city", value = "城市", paramType = "query", dataType = "String", required = false),
            @ApiImplicitParam(name = "keywords", value = "根据省份和城市一起检索", paramType = "query", dataType = "String", required = false),
    })
    @ApiResponse(code = 0,message = "{ \"msg\": \"操作成功\", \"code\": 0, \"data\": [ { \"id\": 主键id, \"province\": \"省份\", \"city\": \"城市\" }]}")
    @PostMapping("/get_baw_dealers_join_list")
    public AjaxResult getBawDealersJoinList(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize,
                                            @RequestParam(name = "province", defaultValue = "") String province,
                                            @RequestParam(name = "city", defaultValue = "") String city,
                                            @RequestParam(name = "keywords", defaultValue = "") String keywords) {
        PageHelper.startPage(pageNum, pageSize, "province asc,city asc");
        List<ModelMap> modelList = bawDealersJoinService.selectBawDealersJoinListForApi(0, 0, province, city, keywords);
        return AjaxResult.success(modelList);
    }


    //获取经销商省份列表接口
    @Autowired
    private IBawCitysService bawCitysService;
    
    @ApiOperation("获取经销商省份列表接口")
    @ApiResponse(code = 0,message = "{ \"msg\": \"操作成功\", \"code\": 0, \"data\": [ { \"province\": \"省份\", \"province_code\": \"省份编码\", \"city_code\": \"城市编码\", \"city\": \"城市\" }]}")
    @PostMapping("/get_baw_province_list")
    public AjaxResult getBawProvinceList() {
        PageHelper.orderBy("province asc");
        List<ModelMap> modelList = bawCitysService.selectProvinceForApi(0, 0);
        return AjaxResult.success(modelList);
    }

    //获取经销商城市列表接口
    @ApiOperation("获取经销商城市列表接口")
    @ApiImplicitParam(name = "province", value = "省份", paramType = "query", dataType = "String", required = false)
    @ApiResponse(code = 0,message = "{ \"msg\": \"操作成功\", \"code\": 0, \"data\": [ { \"id\": 主键id, \"province\": \"省份\", \"province_code\": \"省份编码\", \"city\": \"城市\", \"city_code\": \"城市编码\" }]}")
    @PostMapping("/get_baw_city_list")
    public AjaxResult getBawCityList(@RequestParam(name = "province", defaultValue = "") String province) {
        PageHelper.orderBy("province asc,city asc");
        List<ModelMap> modelList = bawCitysService.selectCityForApi(0, 0, province);
        return AjaxResult.success(modelList);
    }


    //提交预约试驾接口
    @Autowired
    private IBawTestDriveService bawTestDriveService;

    @PostMapping("/commit_test_drive")
    public AjaxResult commitTestDrive(@RequestParam(name = "realname", required = true) String realname,
                                      @RequestParam(name = "mobile", required = true) String mobile,
                                      @RequestParam(name = "sex", defaultValue = "1") Integer sex,
                                      @RequestParam(name = "carSeries", required = true) String carSeries,
                                      @RequestParam(name = "carSeriesCode", required = false, defaultValue = "") String carSeriesCode,
                                      @RequestParam(name = "carType", required = true) String carType,
                                      @RequestParam(name = "carTypeCode", required = false, defaultValue = "") String carTypeCode,
                                      @RequestParam(name = "province", required = true) String province,
                                      @RequestParam(name = "provinceCode", required = false, defaultValue = "") String provinceCode,
                                      @RequestParam(name = "city", required = true) String city,
                                      @RequestParam(name = "cityCode", required = false, defaultValue = "") String cityCode,
                                      @RequestParam(name = "dealer", required = false, defaultValue = "") String dealer,
                                      @RequestParam(name = "dealerCode", required = false, defaultValue = "") String dealerCode) {
        BawTestDrive model = bawTestDriveService.selectBawTestDriveByMobile(mobile);
        if (StringUtils.isNull(model)) {
            BawTestDrive add_data = new BawTestDrive();
            add_data.setRealname(realname);
            add_data.setMobile(mobile);
            add_data.setSex(sex);
            add_data.setCarSeries(carSeries);
            add_data.setCarSeriesCode(carSeriesCode);
            add_data.setCarType(carType);
            add_data.setCarTypeCode(carTypeCode);
            add_data.setProvince(province);
            add_data.setProvinceCode(provinceCode);
            add_data.setCity(city);
            add_data.setCityCode(cityCode);
            add_data.setDealer(dealer);
            add_data.setDealerCode(dealerCode);
            add_data.setIsDelete(0);
            add_data.setAddDate(Integer.parseInt(MyDateUtils.getTimeStamp10()));
            int add_result = bawTestDriveService.insertBawTestDrive(add_data);
            if (add_result > 0) {
                return AjaxResult.success("提交成功");
            } else {
                return AjaxResult.error("提交失败");
            }
        } else {
            return AjaxResult.error("该手机号已经提交过预约试驾了");
        }
    }


    //提交大客户业务接口
    @Autowired
    private IBawBigCustomerBusinessService bawBigCustomerBusinessService;

    @PostMapping("/commit_big_customer_business")
    public AjaxResult commitBigCustomerBusiness(@RequestParam(name = "realname", required = true) String realname,
                                                @RequestParam(name = "mobile", required = true) String mobile,
                                                @RequestParam(name = "sex", defaultValue = "1") Integer sex,
                                                @RequestParam(name = "buycarUse", required = true) String buycarUse,
                                                @RequestParam(name = "buycarNum", required = true) Integer buycarNum,
                                                @RequestParam(name = "companyName", required = true) String companyName,
                                                @RequestParam(name = "carSeries", required = true) String carSeries,
                                                @RequestParam(name = "carType", required = true) String carType,
                                                @RequestParam(name = "province", required = true) String province,
                                                @RequestParam(name = "city", required = true) String city) {
        BawBigCustomerBusiness add_data = new BawBigCustomerBusiness();
        add_data.setRealname(realname);
        add_data.setMobile(mobile);
        add_data.setSex(sex);
        add_data.setBuycarUse(buycarUse);
        add_data.setBuycarNum(buycarNum);
        add_data.setCompanyName(companyName);
        add_data.setCarSeries(carSeries);
        add_data.setCarType(carType);
        add_data.setProvince(province);
        add_data.setCity(city);
        add_data.setIsDelete(0);
        add_data.setAddDate(Integer.parseInt(MyDateUtils.getTimeStamp10()));
        int add_result = bawBigCustomerBusinessService.insertBawBigCustomerBusiness(add_data);
        if (add_result > 0) {
            return AjaxResult.success("提交成功");
        } else {
            return AjaxResult.error("提交失败");
        }
    }


    //TODO:经销商查询接口？



    //获取企业环保信息公示接口
    @Autowired
    private IBawInformationEnterpriseService bawInformationEnterpriseService;

    //获取企业环保信息公示接口
    @PostMapping("/get_baw_information_enterprise_list")
    public AjaxResult getBawInformationEnterpriseList(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
        //getFileName();
        PageHelper.orderBy("sort asc,update_time desc");
        BawInformationEnterprise bawInformationEnterprise=new BawInformationEnterprise();
        bawInformationEnterprise.setKeyword(keyword);
        List<BawInformationEnterprise> modelList = bawInformationEnterpriseService.selectBawInformationEnterpriseList(bawInformationEnterprise);
        return AjaxResult.success(modelList);

    }

    //初始化文件信息
    public static void getFileName() {
        String path = "D:/_红掌花/_北汽官网/pdf"; // 路径  D:\_红掌花\_北汽官网\pdf
        File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
            return;
        }

        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory()) {
                System.out.println(fs.getName() + " [目录]");
            } else {
                System.out.println(fs.getName());
            }
        }
    }

    private <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        ModelMap concurrentHashMap = new ModelMap();
        return t -> concurrentHashMap.putIfAbsent((String) keyExtractor.apply(t), Boolean.TRUE) == null;
    }
    //获取经销商接口
    @Autowired
    private IBawBaseDealershopService BawBaseDealershopService;
    
    @PostMapping("/get_baw_receive_store_information_list")
    public AjaxResult selectBawBaseDealershopListForBAW(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize,
                                                        @RequestParam(name = "region", defaultValue = "") String region,
                                                        @RequestParam(name = "cityc" ,defaultValue = "") String cityc,
                                                        @RequestParam(name = "isEnable", defaultValue = "1") String isEnable,
                                                        @RequestParam(name = "dlrStatus", defaultValue = "1") String dlrStatus,
                                                        @RequestParam(name = "keyword", required = false) String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        BawBaseDealershop bawBaseDealershop =new BawBaseDealershop ();
        bawBaseDealershop.setRegion(region);
        bawBaseDealershop.setCityc(cityc);
        bawBaseDealershop.setIsEnable(isEnable);
        bawBaseDealershop.setDlrStatus(dlrStatus);
        bawBaseDealershop.setNameOrg1(keyword);
        List<BawBaseDealershop> modelList = BawBaseDealershopService.selectBawBaseDealershopListForBAW(bawBaseDealershop);
        return AjaxResult.success(modelList);
    }
    //获取品牌接口
    @Autowired
    private IBawBaseMainbrandService bawBaseMainbrandService;
    
    @ApiOperation("获取品牌接口")
    @ApiImplicitParam(name = "isEnable", value = "状态：0-禁用，1-启用", paramType = "query", dataType = "String", required = false)
    @ApiResponse(code = 0,message = "{ \"msg\": \"操作成功\", \"code\": 0, \"data\": [ { \"searchValue\": null, \"createBy\": \"创建人\", \"createTime\": \"创建时间\", \"updateBy\": 更新人, \"updateTime\": 更新时间, \"remark\": null, \"params\": {}, \"id\": 主键id, \"carBrandCode\": \"品牌编码\", \"carBrandEn\": \"品牌英文名称\", \"carBrandCn\": \"品牌中文名称\", \"isEnable\": \"状态：0-禁用，1-启用\" } ] }")
    @PostMapping("/get_baw_receive_mainbrand_list")
    public AjaxResult getBawReceiveMainbrandList(@RequestParam(name = "isEnable", defaultValue = "1") String isEnable) {
        PageHelper.orderBy("create_time desc");
        BawBaseMainbrand bawBaseMainbrand =new BawBaseMainbrand();
        bawBaseMainbrand.setIsEnable(isEnable);
        List<BawBaseMainbrand> modelList = bawBaseMainbrandService.selectBawBaseMainbrandList(bawBaseMainbrand);
        return AjaxResult.success(modelList);

    }
    //获取车系接口
    @Autowired
    private IBawBaseCarSeriesService bawBaseCarSeriesService;
    
    @ApiOperation("获取车系接口")
    @ApiImplicitParam(name = "isEnable", value = "状态：0-禁用，1-启用", paramType = "query", dataType = "String", required = false)
    @ApiResponse(code = 0,message = "{ \"msg\": \"操作成功\", \"code\": 0, \"data\": [ { \"searchValue\": null, \"createBy\": \"创建人\", \"createTime\": \"创建时间\", \"updateBy\": 更新人, \"updateTime\": 更新时间, \"remark\": null, \"params\": {}, \"id\": 主键id, \"carSeriesCode\": \"车系编码\", \"carSeriesEn\": \"车系英文名称\", \"carSeriesCn\": \"车系中文名称\", \"carBrandCode\": \"品牌编码\", \"isEnable\": \"状态：0-禁用，1-启用\" }]}")
    @PostMapping("/get_baw_receive_car_series_list")
    public AjaxResult getBawReceiveCarSeriesList(@RequestParam(name = "isEnable", defaultValue = "1") String isEnable) {
        //getFileName();
        PageHelper.orderBy("create_time desc");
        BawBaseCarSeries  bawBaseCarSeries =new BawBaseCarSeries();
        bawBaseCarSeries.setIsEnable(isEnable);
        List<BawBaseCarSeries> modelList = bawBaseCarSeriesService.selectBawBaseCarSeriesList(bawBaseCarSeries);
        return AjaxResult.success(modelList);

    }
    //获取车型接口
    @Autowired
    private IBawBaseCarTypeService bawBaseCarTypeService;
    
    @ApiOperation("获取车型接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "carSeriesCode", value = "车系编码", paramType = "query", dataType = "String", required = false),
            @ApiImplicitParam(name = "isEnable", value = "状态：0-禁用，1-启用", paramType = "query", dataType = "String", required = false),
    })
    @ApiResponse(code = 0,message = "{ \"msg\": \"操作成功\", \"code\": 0, \"data\": [ { \"searchValue\": null, \"createBy\": \"创建人\", \"createTime\": \"创建时间\", \"updateBy\": 更新人, \"updateTime\": 更新时间, \"remark\": null, \"params\": {}, \"id\": 主键id, \"carTypeCode\": \"车型编码\", \"carTypeEn\": \"车型英文名称\", \"carTypeCn\": \"车型中文名称\", \"carSeriesCode\": \"车系编码\", \"isEnable\": \"状态：0-禁用，1-启用\" }]}")
    @PostMapping("/get_baw_receive_car_model_list")
    public AjaxResult getBawReceiveCarModelList(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                                @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize,
                                                @RequestParam(name = "carSeriesCode", defaultValue = "") String carSeriesCode,
                                                @RequestParam(name = "isEnable", defaultValue = "1") String isEnable) {
        //getFileName();
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("create_time desc");
        BawBaseCarType bawBaseCarType =new BawBaseCarType();
        bawBaseCarType.setCarSeriesCode(carSeriesCode);
        bawBaseCarType.setIsEnable(isEnable);
        List<BawBaseCarType> modelList = bawBaseCarTypeService.selectBawBaseCarTypeList(bawBaseCarType);
        return AjaxResult.success(modelList);

    }
}
