package com.ruoyi.web.controller.wx;

import java.util.List;

import com.ruoyi.web.domain.BawOrderManagement;
import com.ruoyi.web.service.IBawOrderManagementService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * 订单管理Controller
 *
 * @author ruoyi
 * @date 2022-05-06
 */
@Controller
@RequestMapping("/wx/baw_order_management")
public class BawOrderManagementController extends BaseController
{
    private String prefix = "wx/baw_order_management";
    private static final Logger log = LoggerFactory.getLogger(BawOrderManagementController.class);

    @Autowired
    private IBawOrderManagementService bawOrderManagementService;

    @RequiresPermissions("wx:baw_order_management:view")
    @GetMapping()
    public String baw_order_management()
    {
        return prefix + "/baw_order_management";
    }

    /**
     * 查询订单管理列表
     */
    @RequiresPermissions("wx:baw_order_management:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawOrderManagement bawOrderManagement)

    {
        logger.info("********bawOrderManagement="+bawOrderManagement);
        startPage();
        List<BawOrderManagement> list = bawOrderManagementService.selectBawOrderManagementList(bawOrderManagement);
        return getDataTable(list);
    }

    /**
     * 导出订单管理列表
     */
    @RequiresPermissions("wx:baw_order_management:export")
    @Log(title = "订单管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawOrderManagement bawOrderManagement)
    {
        List<BawOrderManagement> list = bawOrderManagementService.selectBawOrderManagementList(bawOrderManagement);
        ExcelUtil<BawOrderManagement> util = new ExcelUtil<BawOrderManagement>(BawOrderManagement.class);
        return util.exportExcel(list, "订单管理数据");
    }

    /**
     * 新增订单管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单管理
     */
    @RequiresPermissions("wx:baw_order_management:add")
    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawOrderManagement bawOrderManagement)
    {
        return toAjax(bawOrderManagementService.insertBawOrderManagement(bawOrderManagement));
    }

    /**
     * 修改订单管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawOrderManagement bawOrderManagement = bawOrderManagementService.selectBawOrderManagementById(id);
        mmap.put("bawOrderManagement", bawOrderManagement);
        return prefix + "/edit";
    }
    /**
     * 修改订单管理
     */
    @GetMapping("/edit1/{id}")
    public String edit1(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawOrderManagement bawOrderManagement = bawOrderManagementService.selectBawOrderManagementById(id);
        mmap.put("bawOrderManagement", bawOrderManagement);
        return prefix + "/edit1";
    }

    /**
     * 修改保存订单管理
     */
    @RequiresPermissions("wx:baw_order_management:edit")
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawOrderManagement bawOrderManagement)
    {
        return toAjax(bawOrderManagementService.updateBawOrderManagement(bawOrderManagement));
    }

    /**
     * 删除订单管理
     */
    @RequiresPermissions("wx:baw_order_management:remove")
    @Log(title = "订单管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawOrderManagementService.deleteBawOrderManagementByIds(ids));
    }
}
