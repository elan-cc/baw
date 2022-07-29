package com.ruoyi.web.controller.wx;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.domain.BawBaseCarConfigParam;
import com.ruoyi.web.domain.BawBaseCarTypeConfigurationApplet;
import com.ruoyi.web.mapper.BawBaseCarConfigGroupMapper;
import com.ruoyi.web.service.IBawBaseCarConfigParamService;
import com.ruoyi.web.service.IBawBaseCarTypeConfigurationAppletService;
import com.ruoyi.web.service.tableDict.ConfigGroupName;
import com.ruoyi.web.service.tableDict.SekectTypeDictService;
import com.ruoyi.web.service.tableDict.SeriesDictService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

/**
 * 小程序车型配置信息Controller
 *
 * @author ruoyi
 * @date 2022-06-20
 */
@Controller
@RequestMapping("/wx/baw_base_car_type_configuration_applet")
public class bawBaseCartypeConfigurationAppletController extends BaseController {
    private String prefix = "wx/baw_base_car_type_configuration_applet";

    @Autowired
    private IBawBaseCarConfigParamService bawBaseCarConfigParamService;

    @Autowired
    private SekectTypeDictService sekectTypeDictService;

    @Autowired
    private SeriesDictService seriesDictService;
    @Autowired
    private IBawBaseCarTypeConfigurationAppletService bawBaseCarTypeConfigurationAppletService;

    /**
     * 根据code获取车型
     *
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
     *
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
     *
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
     *
     * @param config
     * @return
     */
    @GetMapping("/getSelectCodeApplet")
    @ResponseBody
    public List<ModelMap> selectCodeApplet(String config) {
        List<ModelMap> modelMaps = sekectTypeDictService.selectCodeApplet(config);
        return modelMaps;
    }

    @RequiresPermissions("wx:baw_base_car_type_configuration_applet:view")
    @GetMapping()
    public String baw_base_car_type_configuration_applet() {
        return prefix + "/baw_base_car_type_configuration_applet";
    }

    /**
     * 查询车型配置参数列表
     */
    @RequiresPermissions("wx:baw_base_car_type_configuration_applet:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawBaseCarTypeConfigurationApplet bawBaseCarTypeConfigurationApplet) {
        startPage();
        List<BawBaseCarTypeConfigurationApplet> list = bawBaseCarTypeConfigurationAppletService.selectBawBaseCarTypeConfigurationAppletList(bawBaseCarTypeConfigurationApplet);
        TableDataInfo rspData = getDataTable(list);
        return rspData;
    }

    /**
     * 修改车型配置信息参数（启用1、停用0）
     */
    @RequiresPermissions("wx:baw_base_car_type_configuration_applet:edit")
    @Log(title = "车型配置参数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult edit(BawBaseCarTypeConfigurationApplet bawBaseCarTypeConfigurationApplet) {
        int num = bawBaseCarTypeConfigurationAppletService.updateBawBaseCarTypeConfigurationApplet(bawBaseCarTypeConfigurationApplet);
        switch (num) {
            case 0:
                return AjaxResult.error("已有此数据");
            default:
                return toAjax(num);
        }
    }
    /**
     * 修改具体某个数据
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawBaseCarTypeConfigurationApplet bawBaseCarTypeConfigurationApplet = bawBaseCarTypeConfigurationAppletService.selectBawBaseCarTypeConfigurationAppletById(id);
        mmap.put("bawBaseCarTypeConfigurationApplet", bawBaseCarTypeConfigurationApplet);
        return prefix + "/edit";
    }
    /**
     * 删除门店信息
     */
    @RequiresPermissions("wx:baw_base_car_type_configuration_applet:remove")
    @Log(title = "车型配置信息参数", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(int id) {
        return toAjax(bawBaseCarTypeConfigurationAppletService.deleteBawBaseCarTypeConfigurationAppletById(id));
    }
}
