package com.ruoyi.web.controller.wx;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.web.controller.wx.utils.Utils;
import com.ruoyi.web.controller.wx.utils.WeChatPayUtil;
import com.ruoyi.web.domain.*;
import com.ruoyi.web.service.*;
import com.ruoyi.web.utils.FileTypeUtil;
import com.ruoyi.web.utils.PinYinUtils;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

@Api(tags = "微信小程序接口")
@RestController
@CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET, RequestMethod.POST})//允许跨域
@RequestMapping("/api_wx")
public class ApiWxController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(ApiWxController.class);

    @Autowired
    private IBawTestDriveWxService bawTestDriveWxService;
    @Autowired
    private BawTestDriveCommentWxService bawTestDriveReviewWxService;

    /**经销商*/
    @Autowired
    private IBawDealersJoinService bawDealersJoinService;
    /**车型参数配置*/
    @Autowired
    private IBawBaseCarConfigParamService bawBaseCarConfigParamService;
    /**微信用户*/
    @Autowired
    private IBawUserWxService bawUserWxService;
    /**经销商*/
    @Autowired
    private IBawBaseDealershopService BawBaseDealershopService;
    /**活动*/
    @Autowired
    private IBawActivityWxService bawActivityWxService;
    /**评论点赞记录*/
    @Autowired
    private IBawActivityCommentLikeWxService bawActivityCommentLikeWxService;
    /**活动评论*/
    @Autowired
    private IBawActivityCommentWxService bawActivityCommentWxService;
    /**活动点赞记录*/
    @Autowired
    private IBawActivityLikeWxService bawActivityLikeWxService;
    /**活动报名*/
    @Autowired
    private IBawActivityRegistrationWxService bawActivityRegistrationWxService;
    /**收货地址*/
    @Autowired
    private IBawShippingAddressService bawShippingAddressService;
    /** 预约试驾评价 */
    @Autowired
    private BawTestDriveCommentWxService bawTestDriveCommentWxService;
    /**
     * 官方资讯/精彩推荐
     */
    @Autowired
    private IBawInformationOfficialWxService bawInformationOfficialWxService;
    @Autowired
    private IBawIndexPptWxService bawIndexPptWxService;
    /**订单管理*/
    @Autowired
    private IBawOrderManagementService bawOrderManagementService;
    /**帮助中心*/
    @Autowired
    private IBawHelpCenterWxService bawHelpCenterWxService;
    /**产品手册*/
    @Autowired
    private IBawProductManualService bawProductManualService;
    /**用户反馈*/
    @Autowired
    private IBawUserQuestionsWxService bawUserQuestionsWxService;
    /**活动分类*/
    @Autowired
    private IBawActivityClassificationService bawActivityClassificationService;
    /**产品手册详情*/
    @Autowired
    private IBawProductDetailWxService bawProductDetailWxService;
    /**车辆订购*/
    @Autowired
    private IBawVehicleOrderingWxService bawVehicleOrderingWxService;
    /**消息中心*/
    @Autowired
    private IBawMessageCenterWxService bawMessageCenterWxService;
    /**车主认证*/
    @Autowired
    private IBawOwnerCertificationWxService bawOwnerCertificationWxService;

    @Autowired
    private IBawBaseDealershopService bawBaseDealershopService;
    /**
     * 预约试驾微信
     * @return
     */
    @ApiOperation("预约试驾/维修/保养")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "realname", value = "姓名", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "mobile", value = "手机", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "sex", value = "性别（1：男；2：女）", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "carSeries", value = "车系", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "carSeriesCode", value = "车系编码", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "carType", value = "车型", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "carTypeCode", value = "车型编码", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "province", value = "省份", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "provinceCode", value = "省份编码", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "city", value = "城市", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "cityCode", value = "城市编码", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "dealer", value = "经销商", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "dealerCode", value = "经销商编码", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "dateCode", value = "预约时间 'yyyy-MM-dd HH:mm:ss'", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "appointmentType", value = "预约类型（1：预约试驾；2：预约维修；3：预约保养）", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = true),
    })
    @PostMapping("/commit_test_drive_wx")
    public AjaxResult commitTestDriveWx(@RequestParam(name = "realname", required = true) String realname,
                                      @RequestParam(name = "mobile", required = true) String mobile,
                                      @RequestParam(name = "sex", defaultValue = "1") Integer sex,
                                      @RequestParam(name = "carSeries", required = false) String carSeries,
                                      @RequestParam(name = "carSeriesCode", required = false, defaultValue = "") String carSeriesCode,
                                      @RequestParam(name = "carType", required = false) String carType,
                                      @RequestParam(name = "carTypeCode", required = false, defaultValue = "") String carTypeCode,
                                      @RequestParam(name = "province", required = false) String province,
                                      @RequestParam(name = "provinceCode", required = false, defaultValue = "") String provinceCode,
                                      @RequestParam(name = "city", required = false) String city,
                                      @RequestParam(name = "cityCode", required = false, defaultValue = "") String cityCode,
                                      @RequestParam(name = "dealer", required = false, defaultValue = "") String dealer,
                                      @RequestParam(name = "dealerCode", required = false, defaultValue = "") String dealerCode,
                                      @RequestParam(name = "dateCode", required = true) String dateCode,
                                      @RequestParam(name = "appointmentType", required = true) Integer appointmentType,
                                       HttpServletRequest request){
        String token = request.getHeader("token");
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()){
            return AjaxResult.error("预约失败！");
        }
        if (!Utils.telephone(mobile)){
            return AjaxResult.error("请输入正确的手机号码");
        }
        BawTestDriveWx mobil = bawTestDriveWxService.selectBawTestDriveByMobile(appointmentType, mobile);
        if (StringUtils.isNull(mobil)){
            BawTestDriveWx bawTestDriveWx = new BawTestDriveWx();
            bawTestDriveWx.setRealname(realname);
            bawTestDriveWx.setMobile(mobile);
            bawTestDriveWx.setSex(sex);
            bawTestDriveWx.setCarSeries(carSeries);
            bawTestDriveWx.setCarSeriesCode(carSeriesCode);
            bawTestDriveWx.setCarType(carType);
            bawTestDriveWx.setCarTypeCode(carTypeCode);
            bawTestDriveWx.setProvince(province);
            bawTestDriveWx.setProvinceCode(provinceCode);
            bawTestDriveWx.setCity(city);
            bawTestDriveWx.setCityCode(cityCode);
            bawTestDriveWx.setDealer(dealer);
            bawTestDriveWx.setDealerCode(dealerCode);
            bawTestDriveWx.setIsDelete(0);
            bawTestDriveWx.setAddDate(new Date());
            bawTestDriveWx.setStatus(0);
            Date date = null;
            try {
                date = DateUtils.parseDate(dateCode, "yyyy-MM-dd HH:mm:ss");
            } catch (ParseException e) {
                return AjaxResult.error("时间格式不正确！");
            }
            bawTestDriveWx.setDateCode(date);
            bawTestDriveWx.setAppointmentType(appointmentType);
            bawTestDriveWx.setSourceCode("wx");
            bawTestDriveWx.setUserId(userWx.getId());
            int insertBawTestDriveWx = bawTestDriveWxService.insertBawTestDriveWx(bawTestDriveWx);
            if (insertBawTestDriveWx > 0){
                return AjaxResult.success("提交成功");
            } else {
                return AjaxResult.error("提交失败");
            }
        } else {
            return AjaxResult.error("该手机号已经提交过预约试驾了");
        }
    }

    /**
     * 调取腾讯api，根据传入的地址查询坐标点
     * @param address 地址（注：地址中请包含城市名称，否则会影响解析效果）
     * @return
     */
    /*@ApiOperation("根据传入的地址查询坐标点")
    @ApiImplicitParam(name = "address", value = "地址", paramType = "query", dataType = "String", required = true)
    @ApiResponse(code = 0,message = "")*/
    @PostMapping("/wx/find_coordinates_by_address")
    public AjaxResult findCoordinatesByAddress(@RequestParam(name = "address", required = true) String address){
        Map<String, Double> map = bawDealersJoinService.findCoordinatesByAddress(address);
        if (null == map){
            return AjaxResult.error("查询失败！");
        } else {
            return AjaxResult.success("查询成功！", map);
        }
    }


    /**
     * 调取腾讯api，根据传入的坐标查询地址
     * @param location 经纬度 格式：lat<纬度>,lng<经度>
     * @return
     */
    /*@ApiOperation("根据传入的坐标查询地址")
    @ApiImplicitParam(name = "location", value = "经纬度 格式：lat<纬度>,lng<经度>，例：39.984154,116.307490", paramType = "query", dataType = "String", required = true)
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"address\": \"以行政区划+道路+门牌号等信息组成的标准格式化地址\",\n" +
            "    \"lng\": 纬度,\n" +
            "    \"province\": \"省\",\n" +
            "    \"nation\": \"国家\",\n" +
            "    \"city\": \"市\",\n" +
            "    \"street\": \"街道，可能为空串\",\n" +
            "    \"district\": \"区，可能为空串\",\n" +
            "    \"street_number\": \"门牌，可能为空串\",\n" +
            "    \"recommend\": \"推荐使用的地址描述\",\n" +
            "    \"lat\": 经度,\n" +
            "    \"cityCode\": \"城市编号\"\n" +
            "  }\n" +
            "}")*/
    @PostMapping("/wx/find_address_by_coordinates")
    public AjaxResult findAddressByCoordinates(@RequestParam(name = "location",required = true) String location){
        Map<String, Object> map = bawDealersJoinService.findAddressByCoordinates(location);
        if (null == map){
            return AjaxResult.error("查询失败！");
        } else {
            return AjaxResult.success("查询成功！", map);
        }
    }

    /**
     * 通过车系id查询相关车系所有配置（已弃用）
     *
     * @param carSeriesCode 车系编码
     * @return
     */
    /*@ApiOperation("通过车系id查询相关车系所有配置")
    @ApiImplicitParam(name = "carSeriesCode", value = "车系品牌编码", paramType = "query", dataType = "String", required = true)
    @ApiResponse(code = 0,message = "{ \"msg\": \"查询成功\", \"code\": 0, \"data\": { \"车系编号\": { \"参数名code\": { \"参数名\": \"参数\" } } } }")*/
//    @PostMapping("/wx/query_configuration")
    @Deprecated
    public AjaxResult queryConfiguration(@RequestParam(name = "carSeriesCode", required = true) String carSeriesCode){
        AjaxResult ajaxResult = bawBaseCarConfigParamService.queryBycarSeriesCode(carSeriesCode);
        return ajaxResult;
    }

    /**
     * 微信小程序用户登录
     *
     * @param code 微信小程序临时登录凭证code
     * @return
     */
    /*@ApiOperation("微信小程序用户登录")
    @ApiImplicitParam(name = "code", value = "临时登录凭证code", paramType = "query", dataType = "String", required = true)
    @ApiResponse(code = 0,message = "")*/
    @PostMapping("/wx/login_by_weixin")
    public AjaxResult loginByWeixin(@RequestParam(name = "code",required = true) String code) {
        AjaxResult ajaxResult = bawUserWxService.loginByWeixin(code);
        return ajaxResult;
    }

   @ApiOperation("获取经销商接口")
   @ApiImplicitParams({
           @ApiImplicitParam(name = "pageNum", value = "页码", paramType = "query", dataType = "Integer", required = false),
           @ApiImplicitParam(name = "pageSize", value = "每页显示条数", paramType = "query", dataType = "Integer", required = false),
           @ApiImplicitParam(name = "region", value = "省代码", paramType = "query", dataType = "String", required = false),
           @ApiImplicitParam(name = "cityc", value = "市代码", paramType = "query", dataType = "String", required = false),
           @ApiImplicitParam(name = "isEnable", value = "状态：0-禁用，1-启用", paramType = "query", dataType = "String", required = false),
           @ApiImplicitParam(name = "dlrStatus", value = "建店状态 0-停业 1-营业 2-在建 3-取消 4-整改", paramType = "query", dataType = "String", required = false),
           @ApiImplicitParam(name = "keyword", value = "检索条件，根据经销商名称", paramType = "query", dataType = "String", required = false),
           @ApiImplicitParam(name = "location", value = "经纬度 格式：lat<纬度>,lng<经度>，例：39.984154,116.307490", paramType = "query", dataType = "String", required = true),
           @ApiImplicitParam(name = "storeCar", value = "车系编码", paramType = "query", dataType = "String", required = false)
   })
   @ApiResponse(code = 0,message = "{\n" +
           "    \"msg\": \"操作成功\",\n" +
           "    \"code\": 0,\n" +
           "    \"data\": {\n" +
           "        \"result\": [\n" +
           "            {\n" +
           "                \"searchValue\": null,\n" +
           "               \"createBy\": \"创建人\",\n" +
           "               \"createTime\": \"创建时间\",\n" +
           "               \"updateBy\": 更新人,\n" +
           "               \"updateTime\": 更新时间,\n" +
           "               \"remark\": null,\n" +
           "               \"params\": {},\n" +
           "               \"id\": 主键id,\n" +
           "      \"dlrCode\": \"客户代码\",\n" +
           "      \"kunnr\": \"SAP客户代码\",\n" +
           "      \"buSort1\": \"客户简称\",\n" +
           "      \"nameOrg1\": \"客户全称\",\n" +
           "      \"eikto\": 客户代码,\n" +
           "      \"lng\": 经度,\n" +
           "      \"lat\": 维度,\n" +
           "      \"isEnable\": \"状态：0-禁用，1-启用\",\n" +
           "      \"onlineFlag\": \"上线状态 0-未上线，1-已上线\",\n" +
           "      \"dlrStatus\": \"建店状态 0-停业 1-营业 2-在建 3-取消 4-整改\",\n" +
           "      \"zdlrType\": \"门店类别:A-加盟店,O-直营店\",\n" +
           "      \"orgType\": \"专营店类别:A-服务中心,D-交付中心,W-4S店\",\n" +
           "      \"street\": \"门店地址\",\n" +
           "      \"postCode1\": 邮编,\n" +
           "      \"region\": \"省代码\",\n" +
           "      \"cityc\": \"市代码\",\n" +
           "      \"counc\": \"县代码\",\n" +
           "      \"bzirk\": \"大区\",\n" +
           "      \"vkbur\": \"销售办事处\",\n" +
           "      \"adext\": \"门店联系人\",\n" +
           "      \"mobNumber\": \"门店联系人电话\",\n" +
           "      \"telNumber\": \"门店热线电话\",\n" +
           "      \"smtpAddr\": \"门店邮箱\",\n" +
           "      \"faxNumber\": \"门店传真\",\n" +
           "      \"distance\": 距离，无坐标或查询失败为null,\n" +
           "            }]," +
           "\"count\": 总条数" +
           "}}")
    @PostMapping("/wx/get_baw_receive_store_information_list")
    public AjaxResult selectBawBaseDealershopListForBAW(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize,
                                                        @RequestParam(name = "region", defaultValue = "") String region,
                                                        @RequestParam(name = "cityc" ,defaultValue = "") String cityc,
                                                        @RequestParam(name = "isEnable", defaultValue = "1") String isEnable,
                                                        @RequestParam(name = "dlrStatus", defaultValue = "1") String dlrStatus,
                                                        @RequestParam(name = "keyword", required = false) String keyword,
                                                        @RequestParam(name = "location",required = true) String location,
                                                        @RequestParam(name = "storeCar",required = false) String storeCar) {
        PageHelper.startPage(pageNum, pageSize);
        BawBaseDealershop bawBaseDealershop =new BawBaseDealershop ();
        bawBaseDealershop.setRegion(region);
        bawBaseDealershop.setCityc(cityc);
        bawBaseDealershop.setIsEnable(isEnable);
        bawBaseDealershop.setDlrStatus(dlrStatus);
        bawBaseDealershop.setNameOrg1(keyword);
        if(StringUtils.isNotEmpty(storeCar)){
            logger.info("*********storeCar="+storeCar);
            bawBaseDealershop.setStoreCar(storeCar);
            logger.info("*********bawBaseDealershop="+bawBaseDealershop.toString());
        }else{
            logger.info("*********storeCar="+storeCar);
            bawBaseDealershop.setStoreCar("");
            logger.info("*********bawBaseDealershop="+bawBaseDealershop.toString());
        }

        Map<String, Object> resultMap = BawBaseDealershopService.selectBawBaseDealershopListForBAW(bawBaseDealershop,location);
        return AjaxResult.success(resultMap);
    }

    /**
     * 通过城市code查询活动列表（根据创建时间排序）
     * @param cityCode 城市code
     * @return
     */
    @ApiOperation("通过城市code查询活动列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "cityCode", value = "城市code", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "activityType", value = "分类id", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false),
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"total\": 3,\n" +
            "    \"rows\": [\n" +
            "      {\n" +
            "        \"createBy\": \"创建人\",\n" +
            "        \"createTime\": \"创建时间\",\n" +
            "        \"updateBy\": \"更信任\",\n" +
            "        \"updateTime\": \"更新时间\",\n" +
            "        \"id\": 主键id,\n" +
            "        \"provinceCode\": \"省份编码\",\n" +
            "        \"provinceName\": \"省份名称\",\n" +
            "        \"cityCode\": \"城市编码\",\n" +
            "        \"cityName\": \"城市名称\",\n" +
            "        \"activityTitle\": \"活动标题\",\n" +
            "        \"activityDescribe\": \"活动描述图片url\",\n" +
            "        \"startTime\": \"活动开始时间\",\n" +
            "        \"endTime\": \"活动结束时间\",\n" +
            "        \"isAble\": 是否启用（1.启用，0.禁用）,\n" +
            "        \"activityType\": 活动类型(1.品牌，2.促销，3.车主）,\n" +
            "        \"viewsCount\": 浏览数,\n" +
            "        \"likesCount\": 点赞数,\n" +
            "        \"thumbnail\": \"缩略图url\",\n" +
            "        \"contentCount\": 评论数量,\n" +
            "        \"isLike\": 是都点赞,\n"+
            "        \"activityState\": 活动状态(0:未开始,1:进行中,2:已结束),\n"+
            "      }\n" +
            "    ],\n" +
            "  }\n" +
            "}")
    @PostMapping("/wx/get_activity_list")
    public AjaxResult getActivityList(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize,
                                      @RequestParam(name = "cityCode", required = true) String cityCode,
                                      @RequestParam(name = "activityType", required = true) Integer activityType,
                                      HttpServletRequest request){
        String token = request.getHeader("token");
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()){
            return AjaxResult.error("查询失败！");
        }
        PageHelper.startPage(pageNum, pageSize);
        // startPage();
        List<BawActivityWx> bawActivityWxes = bawActivityWxService.getActivityList(cityCode,userWx.getId(),activityType);
        return AjaxResult.success("查询成功！", getDataTable(bawActivityWxes));
    }


    /**
     * 通过活动id查询活动详情，参与人数（报名人头像，报名总数）,增加浏览量
     * @param activityId 活动id
     * @param count 要查询的报名人头像数量
     * @return
     */
/*    @ApiOperation("通过活动id查询活动详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动id", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "count", value = "要查询的报名人头像数量", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false),
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"result\": {\n" +
            "        \"createBy\": \"创建人\",\n" +
            "        \"createTime\": \"创建时间\",\n" +
            "        \"updateBy\": \"更信任\",\n" +
            "        \"updateTime\": \"更新时间\",\n" +
            "        \"id\": 主键id,\n" +
            "        \"provinceCode\": \"省份编码\",\n" +
            "        \"provinceName\": \"省份名称\",\n" +
            "        \"cityCode\": \"城市编码\",\n" +
            "        \"cityName\": \"城市名称\",\n" +
            "        \"activityTitle\": \"活动标题\",\n" +
            "        \"activityDescribe\": \"活动描述图片url\",\n" +
            "        \"startTime\": \"活动开始时间\",\n" +
            "        \"endTime\": \"活动结束时间\",\n" +
            "        \"isAble\": 是否启用（1.启用，0.禁用）,\n" +
            "        \"activityType\": 活动类型(1.品牌，2.促销，3.车主）,\n" +
            "        \"viewsCount\": 浏览数,\n" +
            "        \"likesCount\": 点赞数,\n" +
            "        \"thumbnail\": \"缩略图url\",\n" +
            "        \"contentCount\": 评论数量,\n" +
            "        \"isLike\": 该用户是否点赞\n" +
            "    },\n" +
            "    \"participantsCount\": 0,\n" +
            "    \"avatars\": []\n" +
            "  }\n" +
            "}")*/
    @PostMapping("/wx/get_activity_by_id")
    public AjaxResult getActivityById(@RequestParam(name = "activityId",required = true) Integer activityId,
                                      @RequestParam(name = "count",required = true,defaultValue = "5") Integer count,
                                      HttpServletRequest request){
        String token = request.getHeader("token");
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()){
            return AjaxResult.error("查询失败！");
        }
        Map<String, Object> resultMap = bawActivityWxService.getActivityById(activityId, count, userWx.getId());
        if (StringUtils.isNotNull(resultMap)){
            return AjaxResult.success("查询成功！", resultMap);
        } else {
            return AjaxResult.error("查询失败");
        }
    }


    /**
     * 活动报名
     * @param email 邮箱
     * @param name 名
     * @param phone 电话号码
     * @param cityCode 城市编码
     * @param cityName 城市名称
     * @param dealerCode 经销商编码
     * @param remarks 备注
     * @param activityId 活动id
     * @param avatar 微信头像url
     * @param wxName 微信名称
     * @return
     */
/*    @ApiOperation("活动报名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "邮箱", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "name", value = "姓名", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "phone", value = "电话号码", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "cityCode", value = "城市编码", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "cityName", value = "城市名称", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "dealerCode", value = "经销商编码", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "remarks", value = "备注", paramType = "query", dataType = "String", required = false),
            @ApiImplicitParam(name = "activityId", value = "活动id", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "avatar", value = "微信头像url", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "wxName", value = "微信名称", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = true),
    })
    @ApiResponse(code = 0,message = "")*/
    @PostMapping("/activity_registration")
    public AjaxResult activityRegistration(@RequestParam(name = "email",required = false) String email,
                                           @RequestParam(name = "name",required = true) String name,
                                           @RequestParam(name = "phone",required = true) String phone,
                                           @RequestParam(name = "cityCode",required = true) String cityCode,
                                           @RequestParam(name = "cityName",required = true) String cityName,
                                           @RequestParam(name = "dealerCode",required = false) String dealerCode,
                                           @RequestParam(name = "remarks",required = false) String remarks,
                                           @RequestParam(name = "activityId",required = true) Integer activityId,
                                           @RequestParam(name = "avatar",required = true) String avatar,
                                           @RequestParam(name = "wxName",required = true) String wxName,
                                           HttpServletRequest request) {
        String token = request.getHeader("token");
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()){
            return AjaxResult.error("报名失败！");
        }
        if (!Utils.telephone(phone)){
            return AjaxResult.error("请输入正确的手机号码");
        }
        BawActivityRegistrationWx bawActivityRegistrationWx = bawActivityRegistrationWxService.selectByPhone(activityId,phone);
        if (StringUtils.isNull(bawActivityRegistrationWx)){
            BawActivityRegistrationWx registrationWx = new BawActivityRegistrationWx();
            registrationWx.setEmail(email);
            registrationWx.setName(name);
            registrationWx.setPhone(phone);
            registrationWx.setCityCode(cityCode);
            registrationWx.setCityName(cityName);
            registrationWx.setDealerCode(dealerCode);
            registrationWx.setRemarks(remarks);
            registrationWx.setActivityId(activityId);
            registrationWx.setAvatar(avatar);
            registrationWx.setWxName(wxName);
            registrationWx.setUserId(userWx.getId());
            registrationWx.setCreateTime(new Date());
            // int i = bawActivityRegistrationWxService.insertBawActivityRegistrationWx(registrationWx);
            return bawActivityRegistrationWxService.insertBawActivityRegistrationWx(registrationWx);
        } else {
            return AjaxResult.error("该手机号已经报名了该活动");
        }
    }

    /**
     * 评论 （活动信息中评论数量+1）
     * @param avatar 微信头像url
     * @param name 用户名
     * @param parentId 父节点id（如果不是回复的已有评论，则填0）
     * @param content 评论内容（如果是回复的已有评论，格式为：回复@XXXX:）
     * @param activityId 活动id
     * @return
     */
/*    @ApiOperation("评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "avatar", value = "微信头像url", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "name", value = "微信用户名", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "parentId", value = "父节点id（如果不是回复的已有评论，则填0）", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "content", value = "评论内容（如果是回复的已有评论，格式为：回复@XXXX:）", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "activityId", value = "活动id", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = true),
    })
    @ApiResponse(code = 0,message = "")*/
    @PostMapping("/activity_comment")
    public AjaxResult activityComment(@RequestParam(name = "avatar",required = true) String avatar,
                                      @RequestParam(name = "name",required = true) String name,
                                      @RequestParam(name = "parentId",required = true, defaultValue = "0") Integer parentId,
                                      @RequestParam(name = "content",required = true) String content,
                                      @RequestParam(name = "activityId",required = true) Integer activityId,
                                      HttpServletRequest request){
        String token = request.getHeader("token");
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()){
            return AjaxResult.error("评论失败！");
        }
        BawActivityCommentWx commentWx = new BawActivityCommentWx();
        commentWx.setAvatar(avatar);
        commentWx.setName(name);
        commentWx.setParentId(parentId);
        commentWx.setContent(content);
        commentWx.setActivityId(activityId);
        commentWx.setUserId(userWx.getId());
        commentWx.setCreatyTime(new Date());
        int i = bawActivityCommentWxService.insertBawActivityCommentWx(commentWx);
        return toAjax(i);
    }

    /**
     * 查询评论列表 和 父级评论回复条数（分页：父级根据点赞数排序，高在上，子级根据评论时间排序）
     * @param activityId 活动id
     * @param parentId 父节点id，传0则查询父级评论
     * @return
     */
/*    @ApiOperation("分页查询评论列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "activityId", value = "活动id", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "parentId", value = "父节点id，传0则查询父级评论", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false),
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"total\": 1,\n" +
            "    \"rows\": [\n" +
            "      {\n" +
            "        \"id\": 主键id,\n" +
            "        \"avatar\": \"微信头像\",\n" +
            "        \"name\": \"微信用户名称\",\n" +
            "        \"likesCount\": 点赞数,\n" +
            "        \"parentId\": 父节点id,\n" +
            "        \"content\": \"评论内容\",\n" +
            "        \"creatyTime\": 评论时间,\n" +
            "        \"activityId\": 活动id,\n" +
            "        \"userId\": ,\n" +
            "        \"replyCount\": 回复数量,\n" +
            "        \"isLike\": 是否点赞\n" +
            "      }\n" +
            "    ],}}")*/
    @PostMapping("/wx/get_activity_comment")
    public AjaxResult getActivityComment(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                         @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize,
                                         @RequestParam(name = "activityId",required = true) Integer activityId,
                                         @RequestParam(name = "parentId",required = true, defaultValue = "0") Integer parentId,
                                         HttpServletRequest request){
        String token = request.getHeader("token");
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()){
            return AjaxResult.error("查询失败！");
        }
        PageHelper.startPage(pageNum, pageSize);
        // startPage();
        log.info("查询评论列表，activityId：{}，parentId：{}，userId：{}",activityId, parentId, userWx.getId());
        List<BawActivityCommentWx> activityComments = bawActivityCommentWxService.getActivityComment(activityId, parentId, userWx.getId());
        return AjaxResult.success("查询成功", getDataTable(activityComments));
    }

    /**
     *  评论点赞/取消点赞
     * @param commentId 评论id
     * @return
     */
/*    @ApiOperation("评论点赞/取消点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commentId", value = "评论id", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false),
    })
    @ApiResponse(code = 0,message = "")*/
    @PostMapping("/wx/comment_like")
    public AjaxResult commentLike(@RequestParam(name = "commentId",required = true) Integer commentId,
                                  HttpServletRequest request){
        String token = request.getHeader("token");
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()){
            return AjaxResult.error("失败！");
        }
        int i = bawActivityCommentWxService.commentLike(commentId, userWx.getId());
        return toAjax(i);
    }

    /**
     * 活动点赞/取消点赞
     * @param activityId 活动id
     * @return
     */
/*    @ApiOperation("活动点赞/取消点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动id", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false),
    })
    @ApiResponse(code = 0,message = "")*/
    @PostMapping("/wx/activity_list")
    public AjaxResult activityList(@RequestParam(name = "activityId",required = true) Integer activityId,
                                   HttpServletRequest request){
        String token = request.getHeader("token");
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()){
            return AjaxResult.error("失败！");
        }
        int i = bawActivityWxService.activityList(activityId, userWx.getId());
        return toAjax(i);
    }

    /** 经销商加盟service */
    @Autowired
    private IBawCitysService bawCitysService;

    /**
     * 查询所有城市并根据首字母排序
     * @return
     */
/*    @ApiOperation("查询所有城市并根据首字母排序")
    @ApiImplicitParam(name = "city", value = "城市名称", paramType = "query", dataType = "String", required = false)
    @ApiResponse(code = 0,message = "")*/
    @PostMapping("/wx/selectCitySort")
    public AjaxResult selectCitySort(@RequestParam(name = "city", required = false) String city){
        List<ModelMap> modelMaps = bawCitysService.selectCitySort(city);
        if (StringUtils.isNotBlank(city)){
            return AjaxResult.success("查询成功！",modelMaps);
        } else {
            Map<String, Object> map = PinYinUtils.screenManufacturer(modelMaps);
            return AjaxResult.success("查询成功！",map);
        }
    }

    /**
     * 根据车系编码查询车型配置
     * @param carSeriesCode 车系编码
     * @return
     */
/*    @ApiOperation("根据车系编码查询车型配置")
    @ApiImplicitParam(name = "carSeriesCode", value = "车系编码", paramType = "query", dataType = "String", required = true)
    @ApiResponse(code = 0,message = "{\n" +
            "    \"msg\": \"查询成功！\",\n" +
            "    \"code\": 0,\n" +
            "    \"data\": [\n" +
            "        {\n" +
            "            \"carParams\": [\n" +
            "                {\n" +
            "                    \"name\": \"车型配置分组名称\",\n" +
            "                    \"params\": [\n" +
            "                        {\n" +
            "                            \"name\": \"车型配置名称\",\n" +
            "                            \"value\": \"车型配置信息\"\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"carConfigCode\": \"车型配置编码（前端可不管）\"\n" +
            "        }\n" +
            "    ]\n" +
            "}")*/
    @PostMapping("/wx/queryConfig")
    public AjaxResult queryConfig(@RequestParam(name = "carSeriesCode", required = true) String carSeriesCode){
        AjaxResult ajaxResult = bawBaseCarConfigParamService.queryConfig(carSeriesCode);
        return ajaxResult;
    }

    /**
     * 我的-用户信息查询接口
     * @param request
     * @return
     */
    @ApiOperation("我的-用户信息查询接口")
    @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false)
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"userInfo\": {\n" +
            "      \"id\": 主键id,\n" +
            "      \"nickName\": \"用户昵称，不用用户昵称可以相同\",\n" +
            "      \"avatar\": \"用户头像\",\n" +
            "      \"userName\": \"用户微信名\",\n" +
            "      \"gender\": \"性别（0男 1女）\",\n" +
            "      \"phoneNumber\": \"手机号码\",\n" +
            "      \"regTime\": \"注册时间\",\n" +
            "    },\n" +
            "    \"addresses\": [\n" +
            "      {\n" +
            "        \"id\": 收货地址主键id,\n" +
            "        \"userId\": 用户id,\n" +
            "        \"receiver\": \"收货人\",\n" +
            "        \"phone\": \"手机号码\",\n" +
            "        \"provinceCode\": \"省份编码\",\n" +
            "        \"provinceName\": \"省份名称\",\n" +
            "        \"cityCode\": \"城市编码\",\n" +
            "        \"cityName\": \"城市名称\",\n" +
            "        \"address\": \"详细地址\",\n" +
            "        \"label\": \"标签\",\n" +
            "        \"isDefault\": 是否默认(0：非默认；1：默认）\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}")
    @PostMapping("/query_user_info")
    public AjaxResult queryUserInfo(HttpServletRequest request){
        Map<String, Object> resultMap = new HashMap<>();
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (StringUtils.isNull(userWx)){
            return AjaxResult.error("未获取到用户信息！");
        }
        // 查询收货地址
        BawShippingAddress bawShippingAddress = new BawShippingAddress();
        bawShippingAddress.setUserId(userWx.getId());
        bawShippingAddress.setIsDefault(1);
        List<BawShippingAddress> bawShippingAddresses;
        bawShippingAddresses = bawShippingAddressService.selectBawShippingAddressList(bawShippingAddress);
        if (StringUtils.isNull(bawShippingAddresses) || bawShippingAddresses.size() == 0){
            // 没有默认显示收货地址，查询列表
            bawShippingAddress.setIsDefault(null);
            bawShippingAddresses = bawShippingAddressService.selectBawShippingAddressList(bawShippingAddress);
        }
        resultMap.put("userInfo", userWx);
        resultMap.put("addresses", bawShippingAddresses);
        return AjaxResult.success("查询成功！", resultMap);
    }

    /**
     * 我的-修改用户信息
     * @param id 用户id
     * @param nickName 昵称
     * @param gender 性别（0男；1女）
     * @param avatar 用户头像
     * @param phoneNumber 手机号码
     * @param request
     * @return
     */
    /*@ApiOperation("我的-修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "nickName", value = "昵称", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "gender", value = "性别（0男；1女）", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "avatar", value = "用户头像", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "phoneNumber", value = "手机号码", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false),
    })
    @ApiResponse(code = 0,message = "{\n" +
			"  \"msg\": \"修改成功！\",\n" +
			"  \"code\": 0\n" +
			"}")*/
    @PostMapping("/update_user_info")
    public AjaxResult updateUserInfo(@RequestParam(name = "id",required = true) Integer id,
                                     @RequestParam(name = "nickName",required = true) String nickName,
                                     @RequestParam(name = "gender",required = true) String gender,
                                     @RequestParam(name = "avatar",required = true) String avatar,
                                     @RequestParam(name = "phoneNumber",required = true) String phoneNumber,
                                     HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (StringUtils.isNull(userWx)){
            return AjaxResult.error("未获取到用户信息！");
        }
        BawUserWx oldUserWx = bawUserWxService.selectBawUserWxById(id);
        if (StringUtils.isNull(oldUserWx)){
            return AjaxResult.error("未获取到用户信息！");
        }
        if (!Utils.telephone(phoneNumber)){
            return AjaxResult.error("请输入正确的手机号码");
        }
        if (userWx.getId().equals(userWx.getId())){
            userWx.setNickName(nickName);
            userWx.setGender(gender);
            userWx.setAvatar(avatar);
            userWx.setPhoneNumber(phoneNumber);
            bawUserWxService.updateBawUserWx(userWx);
            return AjaxResult.success("修改成功！");
        } else {
            return AjaxResult.error("修改失败！");
        }
    }

    /**
     * 根据token查询用户收货地址列表
     * @param request
     * @return
     */
    @ApiOperation("根据token查询用户收货地址列表")
    @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false)
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "        \"id\": 收货地址主键id,\n" +
            "        \"userId\": 用户id,\n" +
            "        \"receiver\": \"收货人\",\n" +
            "        \"phone\": \"手机号码\",\n" +
            "        \"provinceCode\": \"省份编码\",\n" +
            "        \"provinceName\": \"省份名称\",\n" +
            "        \"cityCode\": \"城市编码\",\n" +
            "        \"cityName\": \"城市名称\",\n" +
            "        \"address\": \"详细地址\",\n" +
            "        \"label\": \"标签\",\n" +
            "        \"isDefault\": 是否默认(0：非默认；1：默认）\n" +
            "    }\n" +
            "  ]\n" +
            "}")
    @PostMapping("/query_addresses")
    public AjaxResult queryAddresses(HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (StringUtils.isNull(userWx)){
            return AjaxResult.error("未获取到用户信息！");
        }
        BawShippingAddress bawShippingAddress = new BawShippingAddress();
        bawShippingAddress.setUserId(userWx.getId());
        List<BawShippingAddress> bawShippingAddresses = bawShippingAddressService.selectBawShippingAddressList(bawShippingAddress);
        return AjaxResult.success("查询成功！", bawShippingAddresses);
    }

    /**
     * 我的-新增/修改地址
     * @param id 主键id（为空则新增；不为空则是修改）
     * @param receiver 收货人
     * @param phone 手机号码
     * @param provinceCode 省份编码
     * @param provinceName 省份名称
     * @param cityCode 城市编码
     * @param cityName 城市名称
     * @param address 详细地址
     * @param label 标签
     * @param isDefault 是否默认(0：非默认；1：默认）
     * @return
     */
    @ApiOperation("我的-新增/修改地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "receiver", value = "收货人", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "phone", value = "手机号码", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "provinceCode", value = "省份编码", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "provinceName", value = "省份名称", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "cityCode", value = "城市编码", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "cityName", value = "城市名称", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "address", value = "详细地址", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "label", value = "标签", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "isDefault", value = "是否默认(0：非默认；1：默认）", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false),
    })
    @ApiResponse(code = 0,message = "")
    @PostMapping("/save_address")
    public AjaxResult saveAddress(@RequestParam(name = "id",required = false) Integer id,
                                  @RequestParam(name = "receiver",required = true) String receiver,
                                  @RequestParam(name = "phone",required = true) String phone,
                                  @RequestParam(name = "provinceCode",required = false) String provinceCode,
                                  @RequestParam(name = "provinceName",required = true) String provinceName,
                                  @RequestParam(name = "cityCode",required = false) String cityCode,
                                  @RequestParam(name = "cityName",required = true) String cityName,
                                  @RequestParam(name = "address",required = true) String address,
                                  @RequestParam(name = "label",required = true) String label,
                                  @RequestParam(name = "isDefault",required = true) Integer isDefault,
                                  HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (StringUtils.isNull(userWx)){
            return AjaxResult.error("未获取到用户信息！");
        }
        BawShippingAddress bawShippingAddress = new BawShippingAddress();
        bawShippingAddress.setId(id);
        bawShippingAddress.setUserId(userWx.getId());
        bawShippingAddress.setReceiver(receiver);
        bawShippingAddress.setPhone(phone);
        bawShippingAddress.setProvinceCode(provinceCode);
        bawShippingAddress.setProvinceName(provinceName);
        bawShippingAddress.setCityCode(cityCode);
        bawShippingAddress.setCityName(cityName);
        bawShippingAddress.setAddress(address);
        bawShippingAddress.setLabel(label);
        bawShippingAddress.setIsDefault(isDefault);
        return bawShippingAddressService.saveAddress(bawShippingAddress);
    }

    /**
     * 收货地址切换默认选择
     * @param id 收货地址id
     * @param request
     * @return
     */
    @ApiOperation("收货地址切换默认选择")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = true),
    })
    @ApiResponse(code = 0,message = "")
    @PostMapping("/address_switch_default")
    public AjaxResult addressSwitchDefault(@RequestParam(name = "id",required = true) Integer id,
                                           HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (StringUtils.isNull(userWx)){
            return AjaxResult.error("未获取到用户信息！");
        }

        return bawShippingAddressService.addressSwitchDefault(id, userWx.getId());
    }

    /**
     * 通过id查询用户收货地址
     * @param id 收货地址id
     * @param request
     * @return
     */
    @ApiOperation("通过id查询用户收货地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = true),
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "        \"id\": 收货地址主键id,\n" +
            "        \"userId\": 用户id,\n" +
            "        \"receiver\": \"收货人\",\n" +
            "        \"phone\": \"手机号码\",\n" +
            "        \"provinceCode\": \"省份编码\",\n" +
            "        \"provinceName\": \"省份名称\",\n" +
            "        \"cityCode\": \"城市编码\",\n" +
            "        \"cityName\": \"城市名称\",\n" +
            "        \"address\": \"详细地址\",\n" +
            "        \"label\": \"标签\",\n" +
            "        \"isDefault\": 是否默认(0：非默认；1：默认）\n" +
            "  }\n" +
            "}")
    @PostMapping("/query_address_by_id")
    public AjaxResult queryAddressById(@RequestParam(name = "id",required = true) Integer id,
                                       HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (StringUtils.isNull(userWx)){
            return AjaxResult.error("未获取到用户信息！");
        }
        BawShippingAddress bawShippingAddress = bawShippingAddressService.selectBawShippingAddressById(id);
        return AjaxResult.success("查询成功！", bawShippingAddress);
    }

    /**
     * 我的-我的活动
     * @param activityState 活动状态(1:进行中,2:已结束)
     * @param request
     * @return
     */
    /*@ApiOperation("我的-我的活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityState", value = "活动状态(1:进行中,2:已结束)", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false),
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"createBy\": 创建人,\n" +
            "      \"createTime\": \"创建时间\",\n" +
            "      \"updateBy\": \"修改人\",\n" +
            "      \"updateTime\": \"修改时间\",\n" +
            "      \"id\": 活动主键id,\n" +
            "      \"provinceCode\": \"省份编码\",\n" +
            "      \"provinceName\": \"省份名称\",\n" +
            "      \"cityCode\": \"城市编码\",\n" +
            "      \"cityName\": \"城市名称\",\n" +
            "      \"activityTitle\": \"活动标题\",\n" +
            "      \"activityDescribe\": \"活动描述(正文的图片)\",\n" +
            "      \"startTime\": \"发布时间/创建时间\",\n" +
            "      \"endTime\": \"开始时间\",\n" +
            "      \"isAble\": 是否启用（1.启用，0.禁用）,\n" +
            "      \"activityType\": 活动类型(1.品牌，2.促销，3.车主）,\n" +
            "      \"viewsCount\": 浏览数,\n" +
            "      \"likesCount\": 点赞数,\n" +
            "      \"thumbnail\": \"缩略图\",\n" +
            "      \"contentCount\": 评论数量,\n" +
            "      \"dealershopCode\": \"经销商编码\"\n" +
            "    }\n" +
            "  ]\n" +
            "}")*/
    @PostMapping("/my_activities")
    public AjaxResult myActivities(@RequestParam(name = "activityState",required = true) Integer activityState,
                                   HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (StringUtils.isNull(userWx)){
            return AjaxResult.error("未获取到用户信息！");
        }
        List<BawActivityWx> bawActivityWxes = bawActivityWxService.myActivities(activityState, userWx.getId());
        if (StringUtils.isNull(bawActivityWxes)){
            return AjaxResult.success("查询成功！", new ArrayList<BawActivityWx>());
        } else {
            return AjaxResult.success("查询成功！", bawActivityWxes);
        }
    }

    /**
     * 我的-根据预约类型查询预约记录
     * @param appointmentType 预约类型（1：预约试驾；2：预约维修；3：预约保养）
     * @param request
     * @return
     */
    @ApiOperation("我的-根据预约类型查询预约记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "appointmentType", value = "预约类型（1：预约试驾；2：预约维修；3：预约保养）", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false),
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"id\": \"试驾记录id\",\n" +
            "      \"carSeries\": \"车系\",\n" +
            "      \"dateCode\": \"预约试驾时间\",\n" +
            "      \"buSort1\": \"客户简称\",\n" +
            "      \"street\": \"门店地址\",\n" +
            "      \"lng\": \"经度\",\n" +
            "      \"lat\": \"维度\",\n" +
            "      \"telNumber\": \"门店热线电话\",\n" +
            "      \"status\": 试驾状态（0：待试驾；1：待评价；2：已完成；3：已取消）\n" +
            "    }\n" +
            "}")
    @PostMapping("/test_drive_record")
    public AjaxResult testDriveRecord(@RequestParam(name = "appointmentType",required = true) Integer appointmentType,HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (StringUtils.isNull(userWx)){
            return AjaxResult.error("查询失败，未获取到用户信息！");
        }
        List<ModelMap> modelMaps = bawTestDriveWxService.testDriveRecord(appointmentType,userWx.getId());
        return AjaxResult.success("查询成功！",modelMaps);
    }

    /**
     * 预约试驾评价
     * @param bawTestDriveWxId 预约试驾id
     * @param serviceAttitude 服务态度
     * @param cleanDesktop 桌面整洁
     * @param qualityOfPersonnel 人员素质
     * @param feedbackContent 反馈内容
     * @param request token
     * @return
     */
    /*@ApiOperation("预约试驾评价")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "bawTestDriveWxId", value = "预约试驾id", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "serviceAttitude", value = "服务态度", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "cleanDesktop", value = "桌面整洁", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "qualityOfPersonnel", value = "人员素质", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "feedbackContent", value = "反馈内容", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false),
    })
    @ApiResponse(code = 0,message = "")*/
    @PostMapping("/test_drive_evaluation")
    public AjaxResult testDriveEvaluation(@RequestParam(name = "bawTestDriveWxId",required = true) Integer bawTestDriveWxId,
                                          @RequestParam(name = "serviceAttitude",required = true) Integer serviceAttitude,
                                          @RequestParam(name = "cleanDesktop",required = true) Integer cleanDesktop,
                                          @RequestParam(name = "qualityOfPersonnel",required = true) Integer qualityOfPersonnel,
                                          @RequestParam(name = "feedbackContent",required = true) String feedbackContent,
                                          HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (StringUtils.isNull(userWx)){
            return AjaxResult.error("评价失败，未获取到用户信息！");
        }
        BawTestDriveCommentWx commentWx = new BawTestDriveCommentWx();
        commentWx.setBawTestDriveWxId(bawTestDriveWxId);
        commentWx.setServiceAttitude(serviceAttitude);
        commentWx.setCleanDesktop(cleanDesktop);
        commentWx.setQualityOfPersonnel(qualityOfPersonnel);
        commentWx.setFeedbackContent(feedbackContent);
        commentWx.setCreateBy(userWx.getId());
        commentWx.setCreateTime(new Date());
        return bawTestDriveCommentWxService.testDriveEvaluation(commentWx);
    }

    /**
     * 取消预约试驾
     * @param id 预约试驾记录id
     * @param request
     * @return
     */
    /*@ApiOperation("取消预约试驾")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "预约试驾记录id", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false),
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"取消成功！\",\n" +
            "  \"code\": 0\n" +
            "}")*/
    @PostMapping("/cancel_test_drive")
    public AjaxResult cancelTestDrive(@RequestParam(name = "id",required = true) Integer id, HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (StringUtils.isNull(userWx)){
            return AjaxResult.error("取消失败，未获取到用户信息！");
        }
        return bawTestDriveWxService.cancelTestDrive(id);
    }

    // 测试crm线索留资接口
   /* @RequestMapping("/wx/testCRM")
    public AjaxResult test(HttpServletRequest request){
        JSONObject jsonObject = bawTestDriveWxService.testDriveToCRMtest();
        return AjaxResult.success("成功！",jsonObject);
    }*/

  /*  @GetMapping("/wx/test")
    public void test1(){
        List<BawCitys> bawCitys = bawCitysService.selectBawCitysList(new BawCitys());
        for (BawCitys bawCity : bawCitys) {
            bawCity.setCityPinYin(PinYinUtils.getPinyin(bawCity.getCity()));
            bawCitysService.updateBawCitys(bawCity);
        }
    }*/

    /**
     *查询品牌资讯/精彩推荐列表
     * @param type 类型（0:官方资讯，1:精彩推荐）
     * @param pageNum 页码
     * @param pageSize 每页显示条数
     * @param request
     * @return
     */
    @ApiOperation("查询官方资讯/精彩推荐列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型（0:官方资讯，1:精彩推荐）", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "pageNum", value = "页码", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false),
    })
    @ApiResponse(code = 0, message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"notFocus 普通咨询\": {\n" +
            "      \"total\": 3,\n" +
            "      \"rows\": [\n" +
            "        {\n" +
            "        \"createTime\": \"发布时间\",\n" +
            "        \"id\": id,\n" +
            "        \"infoTitle\": \"标题\",\n" +
            "        \"infoPicture\": \"缩略图\",\n" +
            "        \"infoDescribe\": \"描述\",\n" +
            "        \"infoContent\": \"内容\",\n" +
            "        \"infoFocus\": 焦点,\n" +
            "        \"infoSource\": \"来源\",\n" +
            "        \"infoLikesNumber\": 点赞数,\n" +
            "        \"infoViewsCount\": 浏览数,\n" +
            "        \"infoIsDelete\": 是否删除\n" +
            "        \"isLike\": 是否点赞\n" +
            "        },\n" +
            "      ],\n" +
            "    },\n" +
            "    \"isFocus 焦点咨询\": [\n" +
            "      {\n" +
            "        \"createTime\": \"发布时间\",\n" +
            "        \"id\": id,\n" +
            "        \"infoTitle\": \"标题\",\n" +
            "        \"infoPicture\": \"缩略图\",\n" +
            "        \"infoDescribe\": \"描述\",\n" +
            "        \"infoContent\": \"内容\",\n" +
            "        \"infoFocus\": 焦点,\n" +
            "        \"infoSource\": \"来源\",\n" +
            "        \"infoLikesNumber\": 点赞数,\n" +
            "        \"infoViewsCount\": 浏览数,\n" +
            "        \"infoIsDelete\": 是否删除\n" +
            "        \"isLike\": 是否点赞\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}")
    @PostMapping("/wx/get_infomation_official_list")
    public AjaxResult getInfomationOfficialList(
            @RequestParam(name = "type") Integer type,
            @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        log.info("查询官方资讯/精彩推荐列表，type：{}，token： {}",type, token);
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()) {
            return AjaxResult.error("查询失败,未查询到用户信息！");
        }
        PageHelper.startPage(pageNum, pageSize);
        List<BawInformationOfficialWx> bawInformationOfficialWxNotFocusList = bawInformationOfficialWxService.getInfoOfficialList(userWx.getId(),1,type);
        List<BawInformationOfficialWx> bawInformationOfficialWxIsFocusList = bawInformationOfficialWxService.getInfoOfficialList(userWx.getId(),2,type);
        Map<String ,Object> map =new HashMap<>();
        map.put("notFocus",getDataTable(bawInformationOfficialWxNotFocusList));
        map.put("isFocus",bawInformationOfficialWxIsFocusList);
        return AjaxResult.success("查询成功！", map);
    }


    /*@ApiOperation("通过官方资讯id查询官方资讯详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "InfoOfficalId", value = "咨询id", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false),
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"result\": {\n" +
            "      \"createTime\": \"发布时间\",\n" +
            "        \"id\": id,\n" +
            "        \"infoTitle\": \"标题\",\n" +
            "        \"infoPicture\": \"缩略图\",\n" +
            "        \"infoDescribe\": \"描述\",\n" +
            "        \"infoContent\": \"内容\",\n" +
            "        \"infoFocus\": 焦点,\n" +
            "        \"infoSource\": \"来源\",\n" +
            "        \"infoLikesNumber\": 点赞数,\n" +
            "        \"infoViewsCount\": 浏览数,\n" +
            "        \"infoIsDelete\": 是否删除\n" +
            "      \"isLike\": 此用户是否点赞\n" +
            "    }\n" +
            "  }\n" +
            "}")*/
    @PostMapping("/wx/get_info_offical_by_id")
    public AjaxResult getInfoOfficalById(@RequestParam(name = "InfoOfficalId",required = true) Integer InfoOfficalId,
                                      HttpServletRequest request){
        String token = request.getHeader("token");
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()){
            return AjaxResult.error("查询失败！");
        }
        Map<String, Object> resultMap = bawInformationOfficialWxService.getBawInformationOfficialWxById(InfoOfficalId,userWx.getId());
        if (StringUtils.isNotNull(resultMap)){
            return AjaxResult.success("查询成功！", resultMap);
        } else {
            return AjaxResult.error("查询失败");
        }
    }


    /**
     * 官方资讯点赞/取消点赞
     * @param infoOfficalId 咨询id
     * @return
     */
    @ApiOperation("官方资讯点赞/取消点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "infoOfficalId", value = "咨询id", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false),
    })
    @ApiResponse(code = 0,message = "")
    @PostMapping("/wx/info_offical_list")
    public AjaxResult infoOfficalIdList(@RequestParam(name = "infoOfficalId",required = true) Integer infoOfficalId,
                                   HttpServletRequest request){
        String token = request.getHeader("token");
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()){
            return AjaxResult.error("失败！");
        }
        int i = bawInformationOfficialWxService.infoOfficalIdList(infoOfficalId, userWx.getId());
        return toAjax(i);
    }

    /**
     * 取消预约试驾
     * @param id 预约试驾记录id
     * @param request
     * @return
     */
    /*@ApiOperation("删除预约试驾")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "预约试驾记录id", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false),
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"删除成功！\",\n" +
            "  \"code\": 0\n" +
            "}")*/
    @PostMapping("/delect_test_drive")
    public AjaxResult delectTestDrive(@RequestParam(name = "id",required = true) Integer id, HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (StringUtils.isNull(userWx)){
            return AjaxResult.error("删除失败，未获取到用户信息！");
        }
        int i = bawTestDriveWxService.deleteBawTestDriveWxById(id, userWx.getId());
        return toAjax(i);
    }

    /**
     * 修改用户 微信名，微信头像url，手机号码
     * @param userName 用户微信名称
     * @param avatar 微信头像url
     * @param phoneNumber 手机号码
     * @param request
     * @return
     */
    /*@ApiOperation("修改用户 微信名，微信头像url，手机号码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户微信名", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "avatar", value = "用户头像url", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "phoneNumber", value = "手机号码", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = true)
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"修改成功！\",\n" +
            "  \"code\": 0\n" +
            "}")*/
    @PostMapping("/save_user_info")
    public AjaxResult saveUserInfo(@RequestParam(name = "userName",required = false) String userName,
                                   @RequestParam(name = "avatar",required = false) String avatar,
                                   @RequestParam(name = "phoneNumber",required = false) String phoneNumber,
                                   HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (StringUtils.isNull(userWx)){
            return AjaxResult.error("修改失败，未获取到用户信息！");
        }
        userWx.setUserName(userName);
        userWx.setAvatar(avatar);
        userWx.setPhoneNumber(phoneNumber);
        userWx.setNickName(userName);
        int i = bawUserWxService.saveUserInfo(userWx);
        if (i == 1){
            return AjaxResult.success("修改成功！",userWx);
        } else {
            return AjaxResult.error("修改失败！");
        }

    }

    /*@ApiOperation("手机号获取")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "动态令牌，用于获取手机号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = true)
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"修改成功！\",\n" +
            "  \"code\": 0\n" +
            "}")*/
    @PostMapping("/auth_phone")
    public AjaxResult authPhone(@RequestParam(value = "code", required = false) String code,HttpServletRequest request) {
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (StringUtils.isNull(userWx)){
            return AjaxResult.error("修改失败，未获取到用户信息！");
        }
        AjaxResult ajaxResult = bawUserWxService.authPhone(code, userWx.getId());
        return ajaxResult;
    }

    /**
     * 获取首页轮播图
     * @return
     */
    /*@ApiOperation("获取首页轮播图")
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"id\": 主键id,\n" +
            "      \"picture\": \"图片路径\",\n" +
            "      \"carSeriesCod\": \"车系编号\"\n" +
            "    }\n" +
            "  ]\n" +
            "}")*/
    @PostMapping("/rotation_map")
    public AjaxResult rotationMap(){
        List<BawIndexPptWx> bawIndexPptWxes = bawIndexPptWxService.selectBawIndexPptWxList(null);
        return AjaxResult.success("查询成功！",bawIndexPptWxes);
    }

    // 1 判断后缀名 是png jpg 还有个 jepg
    // 2 从文件头获取文件格式，与后缀名比对，看是否相等，
    /**
     * 生成订单并返回微信支付参数
     * @param carSeriesCode 车系code
     * @param carSeriesName 车系名称
     * @param modelCode 车型code
     * @param modelName 车型名称
     * @param provinceCode 省code
     * @param province 省
     * @param cityCode 市code
     * @param city 市
     * @param countyCode 区县code
     * @param county 区县
     * @param name 姓名
     * @param telephone 电话
     * @param colour 颜色
     * @param img 展示图片路径
     * @param price 支付金额
     * @param request
     * @return
     */
    @ApiOperation("生成订单并返回微信支付参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carSeriesCode", value = "车系code", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "carSeriesName", value = "车系名称", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "modelCode", value = "车型code", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "modelName", value = "车型名称", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "provinceCode", value = "省code", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "province", value = "省", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "cityCode", value = "市code", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "city", value = "市", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "countyCode", value = "区县code", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "county", value = "区县", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "telephone", value = "电话", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "colour", value = "颜色", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "img", value = "展示图片路径", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "price", value = "支付金额", dataType = "Integer", paramType = "query", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", dataType = "String", paramType = "header", required = true)
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"成功\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"timeStamp\": 1651827261,\n" +
            "    \"amount\": \"单位为分\",\n" +
            "    \"package\": \"prepay_id=3\",\n" +
            "    \"paySign\": \"2F954C09084470A96B57E63ABD3A85F7\",\n" +
            "    \"appId\": \"wx06842c4db1fb4cd0\",\n" +
            "    \"signType\": \"MD5\",\n" +
            "    \"id\": 订单id,\n" +
            "    \"nonceStr\": \"eddaa23c96c34453b8f1549a9da51532\"\n" +
            "  }\n" +
            "}")
    @PostMapping("/save_order_and_we_chat_pay")
    public AjaxResult saveOrderAndWeChatPay(@RequestParam(name = "carSeriesCode",required = true) String carSeriesCode,
                                            @RequestParam(name = "carSeriesName",required = true) String carSeriesName,
                                            @RequestParam(name = "modelCode",required = true) String modelCode,
                                            @RequestParam(name = "modelName",required = true) String modelName,
                                            @RequestParam(name = "provinceCode",required = false) String provinceCode,
                                            @RequestParam(name = "province",required = false) String province,
                                            @RequestParam(name = "cityCode",required = false) String cityCode,
                                            @RequestParam(name = "city",required = false) String city,
                                            @RequestParam(name = "countyCode",required = true) String countyCode,
                                            @RequestParam(name = "county",required = true) String county,
                                            @RequestParam(name = "name",required = true) String name,
                                            @RequestParam(name = "telephone",required = true) String telephone,
                                            @RequestParam(name = "img",required = false) String img,
                                            @RequestParam(name = "colour",required = true) String colour,
                                            @RequestParam(name = "dealershopCode",required = false) String dealershopCode,
                                            @RequestParam(name = "documentType",required = false) String documentType,
                                            @RequestParam(name = "idNum",required = false) String idNum,
                                            @RequestParam(name = "price",required = true) Integer price,
                                            @RequestParam(name = "guidancePrice",required = true) Integer guidancePrice,
                                            HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (StringUtils.isNull(userWx)){
            return AjaxResult.error("订单生成失败，未获取到用户信息！");
        }
        logger.info("dealershopCode="+dealershopCode);
        List<BawBaseDealershop> bawBaseDealershops = bawBaseDealershopService.selectBawBaseDealershopByDlrCode(dealershopCode);
        logger.info("bawBaseDealershops="+bawBaseDealershops.toString());
        BawCitys bawCitys=new BawCitys();
        if (null != bawBaseDealershops && bawBaseDealershops.size() > 0){
            if(StringUtils.isNotEmpty(bawBaseDealershops.get(0).getRegion())){
                bawCitys.setProvinceCode(bawBaseDealershops.get(0).getRegion());
                logger.info("ProvinceCode="+bawBaseDealershops.get(0).getRegion());
            }
            if(StringUtils.isNotEmpty(bawBaseDealershops.get(0).getCityc())){
                bawCitys.setCityCode(bawBaseDealershops.get(0).getCityc());
                logger.info("CityCode="+bawBaseDealershops.get(0).getCityc());
            }
            /*if(StringUtils.isNotEmpty(bawBaseDealershops.get(0).getCounc())){
                bawCitys.setCountyCode(bawBaseDealershops.get(0).getCounc());
                logger.info("CountyCode="+bawBaseDealershops.get(0).getCounc());
            }*/
        }
        List<BawCitys> bawCity =bawCitysService.selectBawCitysList(bawCitys);
        logger.info("bawCity="+bawCity.toString());
        BawOrderManagement bawOrderManagement = new BawOrderManagement();
        bawOrderManagement.setCarSeriesCode(carSeriesCode);
        bawOrderManagement.setCarSeriesName(carSeriesName);
        bawOrderManagement.setModelCode(modelCode);
        bawOrderManagement.setModelName(modelName);
        bawOrderManagement.setGuidancePrice(guidancePrice);
        if(StringUtils.isNotEmpty(bawBaseDealershops.get(0).getRegion())){
            bawOrderManagement.setProvinceCode(bawBaseDealershops.get(0).getRegion());
        }else{
            bawOrderManagement.setProvinceCode("");
        }
        if(StringUtils.isNotEmpty(bawCity.get(0).getProvince())){
            bawOrderManagement.setProvince(bawCity.get(0).getProvince());
        }else{
            bawOrderManagement.setProvince("");
        }
        if(StringUtils.isNotEmpty(bawBaseDealershops.get(0).getCityc())){
            bawOrderManagement.setCityCode(bawBaseDealershops.get(0).getCityc());
        }else{
            bawOrderManagement.setCityCode("");
        }
        if(StringUtils.isNotEmpty(bawCity.get(0).getCity())){
            bawOrderManagement.setCity(bawCity.get(0).getCity());
        }else {
            bawOrderManagement.setCity("");
        }
        if(StringUtils.isNotEmpty(bawBaseDealershops.get(0).getCounc())){
            bawOrderManagement.setCountyCode(bawBaseDealershops.get(0).getCounc());
        }else{
            bawOrderManagement.setCountyCode("");
        }
        if(StringUtils.isNotEmpty(bawCity.get(0).getCountyTown())){
            bawOrderManagement.setCounty(bawCity.get(0).getCountyTown());
        }else {
            bawOrderManagement.setCounty("");
        }
        bawOrderManagement.setName(name);
        bawOrderManagement.setTelephone(telephone);
        bawOrderManagement.setColour(colour);
        bawOrderManagement.setImg(img);
        bawOrderManagement.setUserId(userWx.getId());
        bawOrderManagement.setDealershopCode(dealershopCode);
        bawOrderManagement.setDocumentType(documentType);
        bawOrderManagement.setIdNum(idNum);
        bawOrderManagement.setPrice(price);
        logger.info("bawOrderManagement="+bawOrderManagement.toString());
        AjaxResult ajaxResult = bawOrderManagementService.saveOrderAndWeChatPay(bawOrderManagement, userWx.getWxOpenid());
        return ajaxResult;
    }

    /**
     * 通用上传请求（单个）
     */
    @ApiOperation("文件上传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "文件", required = true, paramType = "query"),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = true)
    })
    @ApiResponse(code = 0,message = "{\n" +
            "    \"msg\": \"操作成功\",\n" +
            "    \"code\": 0,\n" +
            "    \"url\": \"url\"\n" +
            "}")
    @PostMapping("/upload_picture")
    public AjaxResult uploadPicture(MultipartFile file, HttpServletRequest request) throws IOException {
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (StringUtils.isNull(userWx)){
            return AjaxResult.error("上传，未获取到用户信息！");
        }
        try
        {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
//            String url = serverConfig.getUrl() + fileName;
            String url = fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 去支付
     * @param amount 价格
     * @param orderId 订单id
     * @param request
     * @return
     */
    @ApiOperation("去支付")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "amount", value = "价格", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "orderId", value = "订单id", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = true)
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"成功\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"timeStamp\": 1651827795,\n" +
            "    \"amount\": \"金额（单位为分）\",\n" +
            "    \"package\": \"prepay_id=4\",\n" +
            "    \"paySign\": \"CC7BC8512B37DDC47AC69F7BE87EE8BE\",\n" +
            "    \"appId\": \"wx06842c4db1fb4cd0\",\n" +
            "    \"signType\": \"MD5\",\n" +
            "    \"id\": 订单id,\n" +
            "    \"nonceStr\": \"4e5e308382b94fc794583f209d7b1ce3\"\n" +
            "  }\n" +
            "}")
    @PostMapping("/we_chat_pay")
    public AjaxResult weChatPay(@RequestParam(name = "amount",required = true) String amount,
                                @RequestParam(name = "orderId",required = true) Integer orderId,
                                HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (StringUtils.isNull(userWx)){
            return AjaxResult.error("支付失败，未获取到用户信息！");
        }
        AjaxResult ajaxResult = bawOrderManagementService.toPay(amount, orderId, userWx.getId(), userWx.getWxOpenid());
        return ajaxResult;
    }

    /**
     * 支付结果返回
     * @param orderId 订单id
     * @param result  结果（0：成功；1：失败）
     * @param request
     * @return
     */
    @ApiOperation("支付结果返回")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "result", value = "结果（0：成功；1：失败）", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "orderId", value = "订单id", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = true)
    })
    @ApiResponse(code = 0,message = "")
    @PostMapping("/pay_result")
    public AjaxResult payResult(@RequestParam(name = "orderId",required = true) Integer orderId,
                                @RequestParam(name = "result",required = true) Integer result,
                                HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (StringUtils.isNull(userWx)){
            return AjaxResult.error("失败，未获取到用户信息！");
        }
        AjaxResult ajaxResult = bawOrderManagementService.payResult(orderId, result, userWx.getId());
        return ajaxResult;
    }

    /**
     * 查询用户订单列表
     * @param orderStatus
     * @param request
     * @return
     */
    @ApiOperation("查询用户订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderStatus", value = "订单状态,为空则是查全部（0：已完成；1：待付款；2：待收货；3：已取消）", dataType = "String", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "页码", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = true)
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"total\": 2,\n" +
            "    \"rows\": [\n" +
            "        \"id\": 主键id,\n" +
            "        \"carSeriesCode\": \"车系code\",\n" +
            "        \"carSeriesName\": \"车系名称\",\n" +
            "        \"modelCode\": \"车型code\",\n" +
            "        \"modelName\": \"车型名称\",\n" +
            "        \"provinceCode\": \"省code\",\n" +
            "        \"province\": \"省\",\n" +
            "        \"cityCode\": \"市code\",\n" +
            "        \"city\": \"市\",\n" +
            "        \"countyCode\": \"区县code\",\n" +
            "        \"county\": \"区县\",\n" +
            "        \"name\": \"姓名\",\n" +
            "        \"telephone\": \"电话\",\n" +
            "        \"colour\": \"颜色\",\n" +
            "        \"img\": \"图片路径\",\n" +
            "        \"price\": \"价格（单位为分）\",\n" +
            "        \"orderNum\": \"订单编号\",\n" +
            "        \"userId\": 用户id,\n" +
            "        \"orderStatus\": \"订单状态（0：已完成；1：待付款；2：待收货；3：已取消）\",\n" +
            "        \"creatyTime\": \"订单生成时间\",\n" +
            "        \"paymentTime\": 订单支付时间,\n" +
            "        \"deleted\": 删除标志，0，未删除，1，已删除\n" +
            "      }\n" +
            "    ],\n" +
            "    \"code\": 0,\n" +
            "    \"msg\": null\n" +
            "  }\n" +
            "}")
    @PostMapping("/query_orders")
    public AjaxResult queryOrders(@RequestParam(name = "orderStatus",required = false) String orderStatus,
                                  @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                  @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize,
                                  HttpServletRequest request) {
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()) {
            return AjaxResult.error("查询失败，未获取到用户信息！");
        }
        BawOrderManagement bawOrderManagement = new BawOrderManagement();
        bawOrderManagement.setOrderStatus(orderStatus);
        bawOrderManagement.setUserId(userWx.getId());
        PageHelper.startPage(pageNum, pageSize);
        List<BawOrderManagement> bawOrderManagements = bawOrderManagementService.selectBawOrderManagementList(bawOrderManagement);
        for (BawOrderManagement orderManagement : bawOrderManagements) {
            String telephone = orderManagement.getTelephone();
            if (telephone != null && telephone.length() == 11){
                telephone = telephone.substring(0,3)+"****"+telephone.substring(7,11);
                orderManagement.setTelephone(telephone);
            }
            if("1".equals(orderManagement.getOrderStatus())){
                // 待付款
                String timeLeft = Utils.calculatingTime(orderManagement.getCreatyTime());// 剩余支付时间
                if (StringUtils.isNotBlank(timeLeft)){
                    orderManagement.setTimeLeft(timeLeft);
                } else {
                    // 设置状态为已取消
                    orderManagement.setOrderStatus("3");
                }

            }
        }
        return AjaxResult.success("查询成功！", getDataTable(bawOrderManagements));
    }

    /**
     * 订单删除
     * @param orderId 订单id
     * @param request
     * @return
     */
    @ApiOperation("订单删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = true)
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"total\": 1,\n" +
            "    \"rows\": [\n" +
            "      {\n" +
            "        \"id\": 主键id,\n" +
            "        \"questionTitle\": \"问题\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"code\": 0,\n" +
            "    \"msg\": null\n" +
            "  }\n" +
            "}")
    @PostMapping("/delete_order")
    public AjaxResult deleteOrder(@RequestParam(name = "orderId",required = true) Integer orderId,
                                  HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()) {
            return AjaxResult.error("删除失败，未获取到用户信息！");
        }
        AjaxResult ajaxResult = bawOrderManagementService.deleteOrder(orderId, userWx.getId());
        return ajaxResult;
    }

    /**
     * 帮助中心列表查询
     * @param type 问题类型（1：账号问题；2：发票问题；3：热门问题）
     * @return
     */
    @ApiOperation("帮助中心列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "问题类型（1：账号问题；2：发票问题；3：热门问题）", dataType = "Integer", required = true, paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "页码", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", paramType = "query", dataType = "Integer", required = false),
    })
    @ApiResponse(code = 0,message = "")
    @PostMapping("/query_help_center")
    public AjaxResult queryHelpCenter(@RequestParam(name = "type") Integer type,
                                      @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<ModelMap> modelMaps = bawHelpCenterWxService.queryHelpCenterList(type);
        return AjaxResult.success("查询成功！", getDataTable(modelMaps));
    }

    /**
     * 通过id查询帮助中心详情
     * @param id 帮助中心id
     * @return
     */
    @ApiOperation("通过id查询帮助中心详情")
    @ApiImplicitParam(name = "id", value = "帮助中心id", dataType = "Integer", required = true, paramType = "query")
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"id\": 主键id,\n" +
            "    \"questionType\": 问题分类（1：账号问题；2：发票问题）,\n" +
            "    \"questionTitle\": \"问题\",\n" +
            "    \"questionSolving\": \"问题解答\",\n" +
            "    \"isHot\": 是否热门（1：普通；2：热门）\n" +
            "  }\n" +
            "}")
    @PostMapping("/query_help_center_by_id")
    public AjaxResult queryHelpCenterById(@RequestParam(name = "id") Integer id) {
        BawHelpCenterWx bawHelpCenterWx = bawHelpCenterWxService.selectBawHelpCenterWxById(id);
        return AjaxResult.success("查询成功！", bawHelpCenterWx);
    }

    /**
     * 咨询分享
     * @param id
     * @return
     */
    @ApiOperation("咨询分享")
    @ApiImplicitParam(name = "id", value = "主键id", dataType = "Integer", required = true, paramType = "query")
    @ApiResponse(code = 0,message = "")
    @PostMapping("/information_share")
    public AjaxResult informationShare(@RequestParam(name = "id") Integer id){

        return bawInformationOfficialWxService.share(id);
    }

    /**
     * 产品手册列表查询
     * @param pageNum 页码
     * @param pageSize 每页显示条数
     * @return
     */
    @ApiOperation("产品手册列表查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", paramType = "query", dataType = "Integer", required = false),
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"total\": 1,\n" +
            "    \"rows\": [\n" +
            "      {\n" +
            "        \"id\": 主键id,\n" +
            "        \"carName\": \"车辆名称\",\n" +
            "        \"picture\": \"图片路径\",\n" +
            "        \"title\": \"标题\",\n" +
            "        \"creatyTime\": \"创建时间\",\n" +
            "        \"content\": \"内容\",\n" +
            "        \"browseQuantity\": 浏览数量,\n" +
            "        \"analysisQuantity\": 分享数量,\n" +
            "        \"likesQuantity\": 点赞数量\n" +
            "      }\n" +
            "    ],\n" +
            "    \"code\": 0,\n" +
            "    \"msg\": null\n" +
            "  }\n" +
            "}")
    @PostMapping("/product_manual_list")
    public AjaxResult productManualList(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                        @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<BawProductManual> bawProductManuals = bawProductManualService.selectBawProductManualList(null);
        return AjaxResult.success("查询成功！", getDataTable(bawProductManuals));
    }

//    /**
//     * 通过id查询产品手册详情
//     * @param id 产品手册id
//     * @param request
//     * @return
//     */
//    @ApiOperation("通过id查询产品手册详情")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "产品手册id", paramType = "query", dataType = "Integer", required = false),
//            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false)
//    })
//    @ApiResponse(code = 0,message = "{\n" +
//            "  \"msg\": \"查询成功！\",\n" +
//            "  \"code\": 0,\n" +
//            "  \"data\": {\n" +
//            "    \"id\": 主键id,\n" +
//            "    \"carName\": \"车辆名称\",\n" +
//            "    \"picture\": \"图片路径\",\n" +
//            "    \"title\": \"标题\",\n" +
//            "    \"creatyTime\": \"创建时间\",\n" +
//            "    \"content\": \"内容\",\n" +
//            "    \"browseQuantity\": 浏览数量,\n" +
//            "    \"analysisQuantity\": 分享数量,\n" +
//            "    \"likesQuantity\": 点赞数量,\n" +
//            "    \"isList\": 是否点赞\n" +
//            "  }\n" +
//            "}")
//    @PostMapping("/product_manual_info")
//    public AjaxResult productManualInfo(@RequestParam(name = "id") Integer id, HttpServletRequest request){
//        String token = request.getHeader("token");
//        Integer userId = null;
//        if (StringUtils.isNotBlank(token)){
//            BawUserWx userWx = bawUserWxService.selectByToken(token);
//            if (StringUtils.isNotNull(userWx) && StringUtils.isNotNull(userWx.getId())){
//                userId = userWx.getId();
//            }
//        }
//        AjaxResult ajaxResult = bawProductManualService.productManualInfo(id, userId);
//        return ajaxResult;
//    }

    /**
     * 产品手册分享
     * @param id 产品手册id
     * @return
     */
    @ApiOperation("产品手册分享")
    @ApiImplicitParam(name = "id", value = "产品手册id", paramType = "query", dataType = "Integer", required = false)
    @ApiResponse(code = 0,message = "")
    @PostMapping("/product_manual_share")
    public AjaxResult productManualShare(@RequestParam(name = "id") Integer id){

        return bawProductManualService.share(id);
    }

    /**
     * 产品手册点赞/取消点赞
     * @param id 产品手册id
     * @param request
     * @return
     */
    @ApiOperation("产品手册点赞/取消点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "产品手册id", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false)
    })
    @ApiResponse(code = 0,message = "")
    @PostMapping("/product_manual_like")
    public AjaxResult productManualLike(@RequestParam(name = "id") Integer id, HttpServletRequest request){
        String token = request.getHeader("token");
        Integer userId = null;
        if (StringUtils.isNotBlank(token)){
            BawUserWx userWx = bawUserWxService.selectByToken(token);
            if (StringUtils.isNotNull(userWx) && StringUtils.isNotNull(userWx.getId())){
                userId = userWx.getId();
            }
        }
        return bawProductManualService.productManualLike(id, userId);
    }

    /**
     * 用户反馈
     * @param feedbackQuestions 反馈问题类型(0:车辆，1:销售，2:售后，3:线上体验)
     * @param content 内容
     * @param picture 图片url
     * @param name 姓名
     * @param telephone 电话
     * @param request
     * @return
     */
    @ApiOperation("用户反馈")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "feedbackQuestions", value = "反馈问题类型(0:车辆，1:销售，2:售后，3:线上体验)", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "content", value = "内容", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "picture", value = "图片url", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "name", value = "姓名", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "telephone", value = "电话", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false)
    })
    @ApiResponse(code = 0,message = "")
    @PostMapping("/user_questions")
    public AjaxResult userQuestions(@RequestParam(name = "feedbackQuestions") Integer feedbackQuestions,
                                    @RequestParam(name = "content") String content,
                                    @RequestParam(name = "picture") String picture,
                                    @RequestParam(name = "name") String name,
                                    @RequestParam(name = "telephone") String telephone,
                                    HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()) {
            return AjaxResult.error("提交反馈失败，未获取到用户信息！");
        }
        if (!Utils.telephone(telephone)){
            return AjaxResult.error("请输入正确的手机号码");
        }
        BawUserQuestionsWx userQuestions = new BawUserQuestionsWx();
        userQuestions.setFeedbackQuestions(feedbackQuestions);
        userQuestions.setContent(content);
        userQuestions.setPicture(picture);
        userQuestions.setName(name);
        userQuestions.setTelephone(telephone);
        userQuestions.setUserId(userWx.getId());
        userQuestions.setCreateTime(new Date());
        return toAjax(bawUserQuestionsWxService.insertBawUserQuestionsWx(userQuestions));
    }

    /**
     * 测试接口（
     *  查询订单状态为未支付，通过订单编号调用微信查询订单状态，如果是 REFUND（转入退款）/SUCCESS（支付成功）
     * ）
     * @param password
     * @return
     */
    @RequestMapping("/query_order_test")
    public AjaxResult queryOrderTest(@RequestParam(name = "password") String password) throws ParseException {
        if (!"QWErty789".equals(password)){
            return AjaxResult.error("失败！");
        }
        return bawOrderManagementService.queryOrderTest();
    }

    /**
     * 去退款
     * @param orderId 订单id
     * @param request
     * @return
     */
    @ApiOperation("去退款")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = false)
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"remainingAmount\": 订单剩余金额,\n" +
            "    \"orderId\": 订单id\n" +
            "  }\n" +
            "}")
    @PostMapping("/to_refund")
    public AjaxResult toRefund(@RequestParam(name = "orderId") Integer orderId,
                               HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()) {
            return AjaxResult.error("申请退款失败，未获取到用户信息！");
        }
        AjaxResult ajaxResult = bawOrderManagementService.toRefund(orderId, userWx.getId());

        return ajaxResult;
    }


    /**
     * 申请退款接口
     * @param orderId 订单id
     * @param refundMoney 退款金额
     * @param cargoStatus 货物状态（1:已收到货；2：未收到货）
     * @param refundReason 退款原因（1：不想要了；2：订单信息拍错（颜色/尺码/规格等）;；3：地址/电话信息填写错误；4：未按照约定时间发货/缺货；5：拍多了；6：没用/少用优惠）
     * @param describe 描述
     * @param pictureUrl 凭证图片url
     * @param request
     * @return
     */
    @ApiOperation("申请退款接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单id", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "refundMoney", value = "退款金额", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "cargoStatus", value = "货物状态（1:已收到货；2：未收到货）", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "refundReason", value = "退款原因（1：不想要了；2：订单信息拍错（颜色/尺码/规格等）;；3：地址/电话信息填写错误；4：未按照约定时间发货/缺货；5：拍多了；6：没用/少用优惠）", paramType = "query", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "describe", value = "描述", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "pictureUrl", value = "凭证图片url", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = true)
    })
    @ApiResponse(code = 0,message = "")
    @PostMapping("/requestARefund")
    public AjaxResult requestARefund(@RequestParam(name = "orderId") Integer orderId,
                                     @RequestParam(name = "refundMoney") Integer refundMoney,
                                     @RequestParam(name = "cargoStatus") Integer cargoStatus,
                                     @RequestParam(name = "refundReason") Integer refundReason,
                                     @RequestParam(name = "describe") String describe,
                                     @RequestParam(name = "pictureUrl") String pictureUrl,
                                     HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()) {
            return AjaxResult.error("申请退款失败，未获取到用户信息！");
        }
        BawManagementRefundWx bawManagementRefundWx = new BawManagementRefundWx();
        bawManagementRefundWx.setManagementId(orderId);
        bawManagementRefundWx.setRefundMoney(refundMoney);
        bawManagementRefundWx.setCargoStatus(cargoStatus);
        bawManagementRefundWx.setRefundReason(refundReason);
        bawManagementRefundWx.setDescribe(describe);
        bawManagementRefundWx.setPictureUrl(pictureUrl);
        bawManagementRefundWx.setUserId(userWx.getId());
        AjaxResult ajaxResult = bawOrderManagementService.requestARefund(bawManagementRefundWx);
        return ajaxResult;
    }


    /**
     * 查看活动分类列表
     * @return
     */
    @ApiOperation("查看活动分类列表")
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"id\": 主键id,\n" +
            "    \"classificationName\": 活动分类,\n" +
            "  }\n" +
            "}")
    @PostMapping("/classification")
    public AjaxResult classificationList(){
        List<ModelMap> modelMaps = bawActivityClassificationService.classIficartionList();
        return AjaxResult.success("查询成功！", getDataTable(modelMaps));
    }

    /**
     * 产品手册详情
     * @param id 产品手册详情id
     * @return
     */
    @ApiOperation("产品手册详情")
    @ApiImplicitParam(name = "id", value = "产品手册详情id", paramType = "query", dataType = "Integer", required = false)
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"id\": 主键id,\n" +
            "    \"tittle\": 标题,\n" +
            "    \"content\": 内容,\n" +
            "    \"orderNum\": 排序,\n" +
            "  }\n" +
            "}")
    @PostMapping("/selectDetail")
    public AjaxResult selectDetail(@RequestParam(name = "id") Integer id){
        List<ModelMap> bawProductDetailWx = bawProductDetailWxService.selectDetailWxById(id);
        return AjaxResult.success(bawProductDetailWx);
    }


    /**
     * 产品手册详情列表
     * @param manualId 产品手册id
     * @return
     */
    @ApiOperation("产品手册详情列表")
    @ApiImplicitParam(name = "manualId", value = "产品手册id", paramType = "query", dataType = "Integer", required = false)
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"modelMaps1\": {\n" +
            "       \"id\": 主键id,\n" +
            "       \"tittle\": 标题,\n" +
            "       \"content\": 内容,\n" +
            "       \"orderNum\": 排序,\n" +
            "       }\n" +
            "    \"bawProductManual\": {\n" +
            "       \"carName\": 车辆名称,\n" +
            "       \"picture\": 图片,\n" +
            "       }\n" +
            "}")
    @PostMapping("/manualDetail")
    public AjaxResult manualDetail(@RequestParam(name = "manualId") Integer manualId){
        List<ModelMap> bawProductManual = bawProductManualService.selectId(manualId);
        List<ModelMap> modelMaps1 = bawProductDetailWxService.selectId(manualId);
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("bawProductManual",bawProductManual);
        hashMap.put("modelMaps1",modelMaps1);
        return AjaxResult.success(hashMap);
    }


    /**
     * 车辆订购管理
     * @param code 车系code
     * @return
     */
    @ApiOperation("车辆订购管理")
    @ApiImplicitParam(name = "code", value = "车系code", paramType = "query", dataType = "Integer", required = false)
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "    \"modelName\": 车系code·,\n" +
            "    \"modelCode\": 车系名称,\n" +
            "    \"carSeriesCode\": 车型code,\n" +
            "    \"carSeriesName\": 车型名称,\n" +
            "   colors\": {\n" +
            "       \"color\": 颜色,\n" +
            "       \"colorValue\": 色值,\n" +
            "       \"price\": 价格,\n" +
            "       \"picture\":图片 ,\n" +
            "       }\n" +
            "  }\n" +
            "}")
    @PostMapping("/ordering")
    public AjaxResult ordering(@RequestParam(name = "code") String code){
        List<Map<String, Object>> maps = bawVehicleOrderingWxService.selectList(code);
        return AjaxResult.success(maps);
    }


    /**
     * 消息中心
     * @param
     * @return
     */
    @ApiOperation("消息中心")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", paramType = "query", dataType = "Integer", required = false),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = true)
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"查询成功！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": {\n" +
            "       \"reminder_content\": 内容,\n" +
            "       \"name\": 标题,\n" +
            "       \"craete_time\":时间 ,\n" +
            "  }\n" +
            "}")
    @PostMapping("/message")
    public AjaxResult message(
            @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize,
            HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()) {
            return AjaxResult.error("未获取到用户信息！");
        }

        PageHelper.startPage(pageNum, pageSize);
        List<ModelMap> modelMaps = bawMessageCenterWxService.slectList(userWx.getId());
        return AjaxResult.success("查询成功",getDataTable(modelMaps));
    }



    /**
     * 车主认证
     * @param
     * @return
     */
    @ApiOperation("车主认证")
    @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = true)
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"已认证！！\",\n" +
            "  \"code\": 0,\n" +
            "}")
    @PostMapping("/certification")
    public AjaxResult certification(
            HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()) {
            return AjaxResult.error("未获取到用户信息！");
        }
        int count = bawOwnerCertificationWxService.selectCount(userWx.getId());
        return AjaxResult.success(count);
    }



    /**
     * 扫码车主认证
     * @param
     * @return
     */
    @ApiOperation("扫码车主认证")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "chassis", value = "底盘号", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "token", value = "token标记", paramType = "header", dataType = "String", required = true)
    })
    @ApiResponse(code = 0,message = "{\n" +
            "  \"msg\": \"已认证！！\",\n" +
            "  \"code\": 0,\n" +
            "  \"data\": 1,\n" +
            "}")
    @PostMapping("/certificationCRM")
    public AjaxResult certificationCRM(
            @RequestParam(name = "chassis") String chassis,
            HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)){
            return AjaxResult.error("token 不可为空！");
        }
        BawUserWx userWx = bawUserWxService.selectByToken(token);
        if (null == userWx || null == userWx.getId()) {
            return AjaxResult.error("未获取到用户信息！");
        }
        AjaxResult ajaxResult = bawOwnerCertificationWxService.certificationCRM(chassis, userWx.getId());
        return ajaxResult;
    }

}
