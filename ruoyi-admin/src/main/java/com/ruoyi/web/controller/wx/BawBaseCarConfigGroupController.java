package com.ruoyi.web.controller.wx;

import java.util.List;
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
import com.ruoyi.web.domain.BawBaseCarConfigGroup;
import com.ruoyi.web.service.IBawBaseCarConfigGroupService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车辆配置分组Controller
 *
 * @author ruoyi
 * @date 2022-04-02
 */
@Controller
@RequestMapping("/wx/baw_base_car_config_group")
public class BawBaseCarConfigGroupController extends BaseController
{
    private String prefix = "wx/baw_base_car_config_group";

    @Autowired
    private IBawBaseCarConfigGroupService bawBaseCarConfigGroupService;

    @RequiresPermissions("wx:baw_base_car_config_group:view")
    @GetMapping()
    public String baw_base_car_config_group()
    {
        return prefix + "/baw_base_car_config_group";
    }

    /**
     * 查询车辆配置分组列表
     */
    @RequiresPermissions("wx:baw_base_car_config_group:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawBaseCarConfigGroup bawBaseCarConfigGroup)
    {
        startPage();
        List<BawBaseCarConfigGroup> list = bawBaseCarConfigGroupService.selectBawBaseCarConfigGroupList(bawBaseCarConfigGroup);
        return getDataTable(list);
    }

    /**
     * 导出车辆配置分组列表
     */
    @RequiresPermissions("wx:baw_base_car_config_group:export")
    @Log(title = "车辆配置分组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawBaseCarConfigGroup bawBaseCarConfigGroup)
    {
        List<BawBaseCarConfigGroup> list = bawBaseCarConfigGroupService.selectBawBaseCarConfigGroupList(bawBaseCarConfigGroup);
        ExcelUtil<BawBaseCarConfigGroup> util = new ExcelUtil<BawBaseCarConfigGroup>(BawBaseCarConfigGroup.class);
        return util.exportExcel(list, "车辆配置分组数据");
    }

    /**
     * 新增车辆配置分组
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存车辆配置分组
     */
    @RequiresPermissions("wx:baw_base_car_config_group:add")
    @Log(title = "车辆配置分组", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawBaseCarConfigGroup bawBaseCarConfigGroup)
    {
        return toAjax(bawBaseCarConfigGroupService.insertBawBaseCarConfigGroup(bawBaseCarConfigGroup));
    }

    /**
     * 修改车辆配置分组
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawBaseCarConfigGroup bawBaseCarConfigGroup = bawBaseCarConfigGroupService.selectBawBaseCarConfigGroupById(id);
        mmap.put("bawBaseCarConfigGroup", bawBaseCarConfigGroup);
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆配置分组
     */
    @RequiresPermissions("wx:baw_base_car_config_group:edit")
    @Log(title = "车辆配置分组", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawBaseCarConfigGroup bawBaseCarConfigGroup)
    {
        return toAjax(bawBaseCarConfigGroupService.updateBawBaseCarConfigGroup(bawBaseCarConfigGroup));
    }

    /**
     * 删除车辆配置分组
     */
    @RequiresPermissions("wx:baw_base_car_config_group:remove")
    @Log(title = "车辆配置分组", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawBaseCarConfigGroupService.deleteBawBaseCarConfigGroupByIds(ids));
    }
}
