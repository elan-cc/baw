package com.ruoyi.web.controller.wx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.web.domain.BawVehicleOrderingWx;
import com.ruoyi.web.service.tableDict.CityDictService;
import com.ruoyi.web.service.tableDict.DeakerShopNameDictService;
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
import com.ruoyi.web.domain.BawActivityWx;
import com.ruoyi.web.service.IBawActivityWxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动Controller
 *
 * @author ruoyi
 * @date 2022-03-17
 */
@Controller
@RequestMapping("/wx/baw_activity_wx")
public class BawActivityWxController extends BaseController
{
    private String prefix = "wx/baw_activity_wx";

    @Autowired
    private IBawActivityWxService bawActivityWxService;

    @Autowired
    private CityDictService cityDictService;
    @Autowired
    private DeakerShopNameDictService deakerShopNameDictService;

    /**
     * 根据省份获取城市
     * @param province
     * @return
     */
    @GetMapping("/getCityName")
    @ResponseBody
    public List<ModelMap> getCityName(String province) {
        List<ModelMap> bawCitysList = cityDictService.getCityName(province);
        return bawCitysList;
    }

    /**
     * 根据城市获取经销商
     * @param city
     * @return
     */
    @GetMapping("/getDeakerShopCity")
    @ResponseBody
    public List<ModelMap> getDeakerShopCity(String city) {
        List<ModelMap> bawShopList = deakerShopNameDictService.getDeakerShopCity(city);
        return bawShopList;
    }



    /**
     * 查询活动列表
     */
    @RequiresPermissions("wx:baw_activity_wx:view")
    @GetMapping()
    public String baw_activity_wx()
    {
        return prefix + "/baw_activity_wx";
    }

    /**
     * 查询活动列表
     */
    @RequiresPermissions("wx:baw_activity_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawActivityWx bawActivityWx)
    {

        startPage();
        List<BawActivityWx> list = bawActivityWxService.selectBawActivityWxList(bawActivityWx);
        return getDataTable(list);
    }

    /**
     * 导出活动列表
     */
    @RequiresPermissions("wx:baw_activity_wx:export")
    @Log(title = "活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawActivityWx bawActivityWx)
    {
        List<BawActivityWx> list = bawActivityWxService.selectBawActivityWxList(bawActivityWx);
        ExcelUtil<BawActivityWx> util = new ExcelUtil<BawActivityWx>(BawActivityWx.class);
        return util.exportExcel(list, "活动数据");
    }

    /**
     * 新增活动
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存活动
     */
    @RequiresPermissions("wx:baw_activity_wx:add")
    @Log(title = "活动", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawActivityWx bawActivityWx) {
        bawActivityWx.setCreateBy(getLoginName());
        int num = bawActivityWxService.insertBawActivityWx(bawActivityWx);
        switch (num) {
            case 10:
                return AjaxResult.error("操作失败，请选择正确的开始和结束时间");
            case 20:
                return AjaxResult.error("缩略图上传失败，请上传缩略图或检查图片格式");
            case 30:
                return AjaxResult.error("活动描述上传失败，请上传活动描述图片或检查图片格式");
            default:
                return toAjax(num);
        }
    }

    /**
     * 修改活动
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {

        BawActivityWx bawActivityWx = bawActivityWxService.selectBawActivityWxById(id);
        mmap.put("bawActivityWx", bawActivityWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存活动
     */
    @RequiresPermissions("wx:baw_activity_wx:edit")
    @Log(title = "活动", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawActivityWx bawActivityWx)
    {
        bawActivityWx.setUpdateBy(getLoginName());
        int num = bawActivityWxService.updateBawActivityWx(bawActivityWx);
        switch (num) {
            case 10:
                return AjaxResult.error("操作失败，请选择正确的开始和结束时间");
            case 20:
                return AjaxResult.error("修改失败，请上传缩略图或检查图片格式");
            case 30:
                return AjaxResult.error("修改失败，请上传活动描述图片或检查图片格式");
            default:
                return toAjax(num);
        }
    }

    /**
     * 删除活动
     */
    @RequiresPermissions("wx:baw_activity_wx:remove")
    @Log(title = "活动", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(Integer ids) {
        int num = bawActivityWxService.deleteBawActivityWxById(ids);
        switch (num) {
            case 10:
                return AjaxResult.error("操作失败，该活动已被报名");
            default:
                return toAjax(num);
        }

    }
}
