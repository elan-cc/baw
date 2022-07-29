package com.ruoyi.web.controller.wx;

import java.util.List;

import com.ruoyi.web.domain.BawManagementRefundWx;
import com.ruoyi.web.service.IBawManagementRefundWxService;
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

/**
 * 退款单Controller
 *
 * @author ruoyi
 * @date 2022-05-20
 */
@Controller
@RequestMapping("/wx/baw_management_refund_wx")
public class BawManagementRefundWxController extends BaseController
{
    private String prefix = "wx/baw_management_refund_wx";

    @Autowired
    private IBawManagementRefundWxService bawManagementRefundWxService;

    @RequiresPermissions("wx:baw_management_refund_wx:view")
    @GetMapping()
    public String baw_management_refund_wx()
    {
        return prefix + "/baw_management_refund_wx";
    }

    /**
     * 查询退款单列表
     */
    @RequiresPermissions("wx:baw_management_refund_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawManagementRefundWx bawManagementRefundWx)
    {
        startPage();
        List<BawManagementRefundWx> list = bawManagementRefundWxService.selectBawManagementRefundWxList(bawManagementRefundWx);
        return getDataTable(list);
    }

    /**
     * 导出退款单列表
     */
    @RequiresPermissions("wx:baw_management_refund_wx:export")
    @Log(title = "退款单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawManagementRefundWx bawManagementRefundWx)
    {
        List<BawManagementRefundWx> list = bawManagementRefundWxService.selectBawManagementRefundWxList(bawManagementRefundWx);
        ExcelUtil<BawManagementRefundWx> util = new ExcelUtil<BawManagementRefundWx>(BawManagementRefundWx.class);
        return util.exportExcel(list, "退款单数据");
    }

    /**
     * 新增退款单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存退款单
     */
    @RequiresPermissions("wx:baw_management_refund_wx:add")
    @Log(title = "退款单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawManagementRefundWx bawManagementRefundWx)
    {
        return toAjax(bawManagementRefundWxService.insertBawManagementRefundWx(bawManagementRefundWx));
    }

    /**
     * 修改退款单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawManagementRefundWx bawManagementRefundWx = bawManagementRefundWxService.selectBawManagementRefundWxById(id);
        mmap.put("bawManagementRefundWx", bawManagementRefundWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存退款单
     */
    @RequiresPermissions("wx:baw_management_refund_wx:edit")
    @Log(title = "退款单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawManagementRefundWx bawManagementRefundWx)
    {
        return toAjax(bawManagementRefundWxService.updateBawManagementRefundWx(bawManagementRefundWx));
    }

    /**
     * 删除退款单
     */
    @RequiresPermissions("wx:baw_management_refund_wx:remove")
    @Log(title = "退款单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawManagementRefundWxService.deleteBawManagementRefundWxByIds(ids));
    }

    /**
     * 审核退款
     */
    @RequestMapping("/examine/{id}")
    @ResponseBody
    public  AjaxResult examine(@PathVariable("id") Integer id){
        String loginName = getLoginName();
        AjaxResult ajaxResult = bawManagementRefundWxService.examine(id, loginName);
        return ajaxResult;
    }


    /**
     * 驳回退款
     */
    @RequestMapping("/reject/{id}")
    @ResponseBody
    public AjaxResult reject(@PathVariable("id") Integer id){
        String loginName = getLoginName();
        AjaxResult ajaxResult = bawManagementRefundWxService.reject(id, loginName);
        return ajaxResult;
    }
}
