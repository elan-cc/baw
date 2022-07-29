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
import com.ruoyi.web.domain.BawHelpCenterWx;
import com.ruoyi.web.service.IBawHelpCenterWxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 帮助中心Controller
 * 
 * @author ruoyi
 * @date 2022-04-22
 */
@Controller
@RequestMapping("/wx/baw_help_center_wx")
public class BawHelpCenterWxController extends BaseController
{
    private String prefix = "wx/baw_help_center_wx";

    @Autowired
    private IBawHelpCenterWxService bawHelpCenterWxService;

    @RequiresPermissions("wx:baw_help_center_wx:view")
    @GetMapping()
    public String baw_help_center_wx()
    {
        return prefix + "/baw_help_center_wx";
    }

    /**
     * 查询帮助中心列表
     */
    @RequiresPermissions("wx:baw_help_center_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawHelpCenterWx bawHelpCenterWx)
    {
        startPage();
        List<BawHelpCenterWx> list = bawHelpCenterWxService.selectBawHelpCenterWxList(bawHelpCenterWx);
        return getDataTable(list);
    }

    /**
     * 导出帮助中心列表
     */
    @RequiresPermissions("wx:baw_help_center_wx:export")
    @Log(title = "帮助中心", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawHelpCenterWx bawHelpCenterWx)
    {
        List<BawHelpCenterWx> list = bawHelpCenterWxService.selectBawHelpCenterWxList(bawHelpCenterWx);
        ExcelUtil<BawHelpCenterWx> util = new ExcelUtil<BawHelpCenterWx>(BawHelpCenterWx.class);
        return util.exportExcel(list, "帮助中心数据");
    }

    /**
     * 新增帮助中心
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存帮助中心
     */
    @RequiresPermissions("wx:baw_help_center_wx:add")
    @Log(title = "帮助中心", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawHelpCenterWx bawHelpCenterWx)
    {
        return toAjax(bawHelpCenterWxService.insertBawHelpCenterWx(bawHelpCenterWx));
    }

    /**
     * 修改帮助中心
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawHelpCenterWx bawHelpCenterWx = bawHelpCenterWxService.selectBawHelpCenterWxById(id);
        mmap.put("bawHelpCenterWx", bawHelpCenterWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存帮助中心
     */
    @RequiresPermissions("wx:baw_help_center_wx:edit")
    @Log(title = "帮助中心", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawHelpCenterWx bawHelpCenterWx)
    {
        return toAjax(bawHelpCenterWxService.updateBawHelpCenterWx(bawHelpCenterWx));
    }

    /**
     * 删除帮助中心
     */
    @RequiresPermissions("wx:baw_help_center_wx:remove")
    @Log(title = "帮助中心", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawHelpCenterWxService.deleteBawHelpCenterWxByIds(ids));
    }


}
