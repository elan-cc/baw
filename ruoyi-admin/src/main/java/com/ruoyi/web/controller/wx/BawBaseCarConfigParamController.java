package com.ruoyi.web.controller.wx;

import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.controller.demo.domain.UserOperateModel;
import com.ruoyi.web.domain.BawBaseCarConfigGroup;
import com.ruoyi.web.domain.BawBaseCarConfigParamDeserialization;
import com.ruoyi.web.domain.BawBaseCarConfigParam;
import com.ruoyi.web.mapper.BawBaseCarConfigGroupMapper;
import com.ruoyi.web.service.IBawBaseCarConfigParamService;
import com.ruoyi.web.service.tableDict.ConfigGroupName;
import com.ruoyi.web.service.tableDict.SekectTypeDictService;
import com.ruoyi.web.service.tableDict.SeriesDictService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 车型配置参数Controller
 *
 * @author ruoyi
 * @date 2022-03-11
 */
@Controller
@RequestMapping("/wx/baw_base_car_config_param")
public class BawBaseCarConfigParamController extends BaseController
{
    private String prefix = "wx/baw_base_car_config_param";

    @Autowired
    private IBawBaseCarConfigParamService bawBaseCarConfigParamService;
    @Autowired
    private ConfigGroupName configGroupName;

    @Autowired
    private BawBaseCarConfigGroupMapper bawBaseCarConfigGroupMapper;

    @Autowired
    private SekectTypeDictService sekectTypeDictService;

    @Autowired
    private SeriesDictService seriesDictService;

    /**
     * 根据code获取车型
     * @param
     * @return
     */
    @GetMapping("/getSerierCode")
    @ResponseBody
    public List<ModelMap> serierCode() {
        List<ModelMap> modelMaps = seriesDictService.getSerierCode();
        return modelMaps;
    }
    /**
     * 根据code获取车型
     * @param serviceCode
     * @return
     */
    @GetMapping("/getSekectType")
    @ResponseBody
    public List<ModelMap> sekectType(String serviceCode) {
        List<ModelMap> modelMaps = sekectTypeDictService.selectType(serviceCode);
        return modelMaps;
    }

    /**
     * 根据code获取车型
     * @param config
     * @return
     */
    @GetMapping("/getSelectCode")
    @ResponseBody
    public List<ModelMap> selectCode(String config) {
        List<ModelMap> modelMaps = sekectTypeDictService.selectCode(config);
        return modelMaps;
    }
    /**
     * 根据code获取车型配置信息（小程序专用）
     * @param config
     * @return
     */
    @GetMapping("/getSelectCodeApplet")
    @ResponseBody
    public List<ModelMap> selectCodeApplet(String config) {
        List<ModelMap> modelMaps = sekectTypeDictService.selectCodeApplet(config);
        return modelMaps;
    }

    @RequiresPermissions("wx:baw_base_car_config_param:view")
    @GetMapping()
    public String baw_base_car_config_param()
    {
        return prefix + "/baw_base_car_config_param";
    }

    /**
     * 查询车型配置参数列表
     */
    @RequiresPermissions("wx:baw_base_car_config_param:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawBaseCarConfigParam bawBaseCarConfigParam)
    {

        startPage();
//        List<BawBaseCarConfigParam> list = bawBaseCarConfigParamService.selectBawBaseCarConfigParamList(bawBaseCarConfigParam);
        List<BawBaseCarConfigParam> list = bawBaseCarConfigParamService.selectBawBaseCarConfigParamList(bawBaseCarConfigParam);
//        int count =bawBaseCarConfigParamService.selectBawBaseCarConfigParamCount(bawBaseCarConfigParam);
        TableDataInfo rspData = getDataTable(list);
//        rspData.setTotal(count);
        return rspData;
    }

    /**
     * 查询车型配置参数列表
     */
    @RequiresPermissions("wx:baw_base_car_config_param:pageList")
    @PostMapping("/pageList")
    @ResponseBody
    public TableDataInfo pageList(BawBaseCarConfigParam bawBaseCarConfigParam)
    {

        startPage();
        List<BawBaseCarConfigParam> list = bawBaseCarConfigParamService.selectBawBaseCarConfigParamPageList(bawBaseCarConfigParam);
//        List<BawBaseCarConfigParamDeserialization> list = bawBaseCarConfigParamService.selectBawBaseCarConfigParamList(bawBaseCarConfigParam);
        int count =bawBaseCarConfigParamService.selectBawBaseCarConfigParamCount(bawBaseCarConfigParam);
        TableDataInfo rspData = getDataTable(list);
        rspData.setTotal(count);
        return rspData;
    }

    /**
     * 导出车型配置参数列表
     */
    @RequiresPermissions("wx:baw_base_car_config_param:export")
    @Log(title = "车型配置参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawBaseCarConfigParam bawBaseCarConfigParam)
    {
        List<BawBaseCarConfigParam> bawBaseCarConfigParams = bawBaseCarConfigParamService.selectBawBaseCarConfigList(bawBaseCarConfigParam);
        for (BawBaseCarConfigParam baseCarConfigParam : bawBaseCarConfigParams) {
            if (StringUtils.isNotNull(baseCarConfigParam.getConfigGroupId()) && baseCarConfigParam.getConfigGroupId() != 0 ){
                BawBaseCarConfigGroup bawBaseCarConfigGroup = bawBaseCarConfigGroupMapper.selectBawBaseCarConfigGroupById(baseCarConfigParam.getConfigGroupId());
                baseCarConfigParam.setConfigGroup(bawBaseCarConfigGroup.getName());
            }
        }
        ExcelUtil<BawBaseCarConfigParam> util = new ExcelUtil<>(BawBaseCarConfigParam.class);
        return util.exportExcel(bawBaseCarConfigParams,"车辆配置信息");
    }

    /**
     * 页面新增车型配置参数
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add1";
    }
    /**
     * 编辑新增车型配置参数
     */
    @GetMapping("/add2/{code}")
    public String add2(@PathVariable("code") String code,ModelMap modelMap) {
        System.out.println(code);
        String[] codes = code.split("@");
        BawBaseCarConfigParam bawBaseCarConfigParam = new BawBaseCarConfigParam();
            bawBaseCarConfigParam.setCarConfigCode(codes[0]);
            bawBaseCarConfigParam.setCarSeriesCode(codes[1]);
            bawBaseCarConfigParam.setCarTypeCode(codes[2]);
        modelMap.put("bawBaseCarConfigParam", bawBaseCarConfigParam);
        return prefix + "/add2";
    }

    /**
     * 新增保存车型配置参数
     */
    @RequiresPermissions("wx:baw_base_car_config_param:add")
    @Log(title = "车型配置参数", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawBaseCarConfigParam bawBaseCarConfigParam)
    {
        if (StringUtils.isBlank(bawBaseCarConfigParam.getParamValue())){
            bawBaseCarConfigParam.setParamValue("0");
        }
        if (StringUtils.isBlank(bawBaseCarConfigParam.getParamName())){
            bawBaseCarConfigParam.setParamName("0");
        }
        if (null == bawBaseCarConfigParam.getConfigGroupId()){
            bawBaseCarConfigParam.setConfigGroupId(0);
        }
        if (null == bawBaseCarConfigParam.getOrderNum()){
            bawBaseCarConfigParam.setOrderNum(0);
        }
        int num = bawBaseCarConfigParamService.insertBawBaseCarConfigParams(bawBaseCarConfigParam);
        System.out.println("+++++++++++++++" + num);
        switch (num){
            case 0:
                return AjaxResult.error("已有此数据");
            case 3:
                return AjaxResult.error("车辆型号不能出现汉字");
            default:
                return toAjax(num);
        }
    }

    /**
     * 修改车型配置参数
     */
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap,Integer pagesize,Integer pagenum)
    {

//        BawBaseCarConfigParam bawBaseCarConfigParam = new BawBaseCarConfigParam();
//        bawBaseCarConfigParam.setCarConfigCode(id);
////        BawBaseCarConfigParam bawBaseCarConfigParam = bawBaseCarConfigParamService.selectBawBaseCarConfigParamById(id);
////        BawBaseCarConfigParamDeserialization bawBaseCarConfigParam = bawBaseCarConfigParamService.selectBawBaseCarConfigParamById(id);
//        List<BawBaseCarConfigParam> list = bawBaseCarConfigParamService.selectBawBaseCarConfigParamPageList(bawBaseCarConfigParam);
        BawBaseCarConfigParam bawBaseCarConfigParam = bawBaseCarConfigParamService.selectById(id);
        mmap.put("bawBaseCarConfigParam", bawBaseCarConfigParam);
        return prefix + "/baw_base_car_config_param_edit";
    }
    /**
     * 修改车型配置参数
     */
    @RequestMapping("/edit2/{id}")
    public String edit2(@PathVariable("id") Integer id, ModelMap mmap,Integer pagesize,Integer pagenum)
    {
        BawBaseCarConfigParam bawBaseCarConfigParam = bawBaseCarConfigParamService.selectById(id);
        mmap.put("bawBaseCarConfigParam", bawBaseCarConfigParam);
        return prefix + "/edit";
    }

    /**
     * 修改车型配置参数
     */
    @RequestMapping("/edit1/{code}")
    @ResponseBody
    public TableDataInfo edit1(BawBaseCarConfigParam bawBaseCarConfigParam,@PathVariable("code") String code)
    {
        startPage();
        bawBaseCarConfigParam.setCarConfigCode(code);
        List<BawBaseCarConfigParam> list = bawBaseCarConfigParamService.selectBawBaseCarConfigParamPageList(bawBaseCarConfigParam);
        return getDataTable(list);
    }

    /**
     * 修改保存车型配置参数
     */
    @RequiresPermissions("wx:baw_base_car_config_param:edit")
    @Log(title = "车型配置参数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawBaseCarConfigParam bawBaseCarConfigParam)
    {
        int num = bawBaseCarConfigParamService.updateBawBaseCarConfigParam(bawBaseCarConfigParam);
        switch (num){
            case 0:
                return AjaxResult.error("已有此数据");
            default:
                return toAjax(num);
        }
    }

    /**
     * 修改保存车型配置参数
     */
    @RequiresPermissions("wx:baw_base_car_config_param:edit1")
    @Log(title = "车型配置参数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit1")
    @ResponseBody
    public AjaxResult editSave1(BawBaseCarConfigParam bawBaseCarConfigParam)
    {
        int num = bawBaseCarConfigParamService.updateBawBaseCarConfig(bawBaseCarConfigParam);
        switch (num){
            case 0:
                return AjaxResult.error("已有此数据");
            default:
                return toAjax(num);
        }
    }

    /**
     * 删除车型配置参数
     */
    @RequiresPermissions("wx:baw_base_car_config_param:remove")
    @Log(title = "车型配置参数", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(Integer ids)
    {
        /*String[] name = ids.split("@");
        if (name[1].equals("paramName")){
            String[] params = name[0].split("&");
            return toAjax(bawBaseCarConfigParamService.deleteBawBaseCarConfigParamByname(params[0],params[1]));
        }
        if (name[1].equals("carConfigCode")){
             return toAjax(bawBaseCarConfigParamService.deleteBawBaseCarConfigParamByIds(name[0]));
            return toAjax(bawBaseCarConfigParamService.deleteBawBaseCarConfigParamByCarConfigCode(name[0]));
        }*/


        return toAjax(bawBaseCarConfigParamService.deleteBawBaseCarConfigParamById(ids));
    }

    /**
     *车型配置参数模板下载
     * @return
     */
    @RequiresPermissions("wx:baw_base_car_config_param:importTemplate")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BawBaseCarConfigParam> util = new ExcelUtil<BawBaseCarConfigParam>(BawBaseCarConfigParam.class);
        return util.importTemplateExcel("车型配置参数");
    }

    /**
     * 车辆配置参数导入
     * @param file
     * @return
     * @throws Exception
     */
    @Log(title = "车辆配置参", businessType = BusinessType.IMPORT)
    @RequiresPermissions("wx:baw_base_car_config_param:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<BawBaseCarConfigParam> util = new ExcelUtil<BawBaseCarConfigParam>(BawBaseCarConfigParam.class);
        List<BawBaseCarConfigParam> bawBaseCarConfigParams = util.importExcel(file.getInputStream());
        String message = bawBaseCarConfigParamService.importBawBaseCarConfigParam(bawBaseCarConfigParams,getLoginName());
        switch (message){
            case "0":
                return AjaxResult.error("请检查配置名称是否有重复");
        }
        return AjaxResult.success(message);
    }
}
