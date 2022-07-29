package com.ruoyi.web.controller.wx;

import java.util.Date;
import java.util.List;

import com.ruoyi.web.domain.BawVehicleOrderingWx;
import com.ruoyi.web.service.IBawVehicleOrderingWxService;
import com.ruoyi.web.service.tableDict.SekectTypeDictService;
import com.ruoyi.web.service.tableDict.SeriesDictService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车辆订购管理Controller
 *
 * @author ruoyi
 * @date 2022-06-07
 */
@Controller
@RequestMapping("/wx/baw_vehicle_ordering_wx")
public class BawVehicleOrderingWxController extends BaseController
{
    private String prefix = "wx/baw_vehicle_ordering_wx";

    @Autowired
    private IBawVehicleOrderingWxService bawVehicleOrderingWxService;
    @Autowired
    private SekectTypeDictService sekectTypeDictService;

    @Autowired
    private SeriesDictService seriesDictService;

    @RequiresPermissions("wx:baw_vehicle_ordering_wx:view")
    @GetMapping()
    public String baw_vehicle_ordering_wx()
    {
        return prefix + "/baw_vehicle_ordering_wx";
    }


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
     * 根据一级车系（carSeriesCode）车型配置获取车型配置信息
     * @param serviceCode
     * @return
     */
    @GetMapping("/getSelectCarSeriesCodeApplet")
    @ResponseBody
    public List<ModelMap> selectBawBaseCarTypeConfigurationAppletByCarSeriesCode (String serviceCode) {
        List<ModelMap> modelMaps = sekectTypeDictService.selectBawBaseCarTypeConfigurationAppletByCarSeriesCode(serviceCode);
        return modelMaps;
    }
    /**
     * 查询车辆订购管理列表
     */
    @RequiresPermissions("wx:baw_vehicle_ordering_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawVehicleOrderingWx bawVehicleOrderingWx)
    {
        startPage();
        List<BawVehicleOrderingWx> list = bawVehicleOrderingWxService.selectBawVehicleOrderingWxList(bawVehicleOrderingWx);
        return getDataTable(list);
    }

    /**
     * 导出车辆订购管理列表
     */
    @RequiresPermissions("wx:baw_vehicle_ordering_wx:export")
    @Log(title = "车辆订购管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawVehicleOrderingWx bawVehicleOrderingWx)
    {
        List<BawVehicleOrderingWx> list = bawVehicleOrderingWxService.selectBawVehicleOrderingWxList(bawVehicleOrderingWx);
        ExcelUtil<BawVehicleOrderingWx> util = new ExcelUtil<BawVehicleOrderingWx>(BawVehicleOrderingWx.class);
        return util.exportExcel(list, "车辆订购管理数据");
    }

    /**
     * 新增车辆订购管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存车辆订购管理
     */
    @RequiresPermissions("wx:baw_vehicle_ordering_wx:add")
    @Log(title = "车辆订购管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawVehicleOrderingWx bawVehicleOrderingWx)
    {
        String loginName = getLoginName();
        bawVehicleOrderingWx.setCreateBy(loginName);
        bawVehicleOrderingWx.setCreateTime(new Date());
        return toAjax(bawVehicleOrderingWxService.insertBawVehicleOrderingWx(bawVehicleOrderingWx));
    }

    /**
     * 修改车辆订购管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawVehicleOrderingWx bawVehicleOrderingWx = bawVehicleOrderingWxService.selectBawVehicleOrderingWxById(id);
        mmap.put("bawVehicleOrderingWx", bawVehicleOrderingWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆订购管理
     */
    @RequiresPermissions("wx:baw_vehicle_ordering_wx:edit")
    @Log(title = "车辆订购管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawVehicleOrderingWx bawVehicleOrderingWx)
    {
        String loginName = getLoginName();
        bawVehicleOrderingWx.setUpdateBy(loginName);
        bawVehicleOrderingWx.setUpdateTime(new Date());
        return toAjax(bawVehicleOrderingWxService.updateBawVehicleOrderingWx(bawVehicleOrderingWx));
    }

    /**
     * 删除车辆订购管理
     */
    @RequiresPermissions("wx:baw_vehicle_ordering_wx:remove")
    @Log(title = "车辆订购管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawVehicleOrderingWxService.deleteBawVehicleOrderingWxByIds(ids));
    }
}
