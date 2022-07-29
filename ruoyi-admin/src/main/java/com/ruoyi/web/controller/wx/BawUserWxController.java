package com.ruoyi.web.controller.wx;

import java.util.List;

import com.ruoyi.web.domain.BawUserWx;
import com.ruoyi.web.service.IBawUserWxService;
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
 * 微信用户Controller
 *
 * @author ruoyi
 * @date 2022-03-12
 */
@Controller
@RequestMapping("/wx/baw_user_wx")
public class BawUserWxController extends BaseController
{
    private String prefix = "wx/baw_user_wx";

    @Autowired
    private IBawUserWxService bawUserWxService;

    @RequiresPermissions("wx:baw_user_wx:view")
    @GetMapping()
    public String baw_user_wx()
    {
        return prefix + "/baw_user_wx";
    }

    /**
     * 查询微信用户列表
     */
    @RequiresPermissions("wx:baw_user_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawUserWx bawUserWx)
    {
        startPage();
        List<BawUserWx> list = bawUserWxService.selectBawUserWxList(bawUserWx);
        return getDataTable(list);
    }

    /**
     * 导出微信用户列表
     */
    @RequiresPermissions("wx:baw_user_wx:export")
    @Log(title = "微信用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawUserWx bawUserWx)
    {
        List<BawUserWx> list = bawUserWxService.selectBawUserWxList(bawUserWx);
        ExcelUtil<BawUserWx> util = new ExcelUtil<BawUserWx>(BawUserWx.class);
        return util.exportExcel(list, "微信用户数据");
    }

    /**
     * 新增微信用户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存微信用户
     */
    @RequiresPermissions("wx:baw_user_wx:add")
    @Log(title = "微信用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawUserWx bawUserWx)
    {
        return toAjax(bawUserWxService.insertBawUserWx(bawUserWx));
    }

    /**
     * 修改微信用户
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawUserWx bawUserWx = bawUserWxService.selectBawUserWxById(id);
        mmap.put("bawUserWx", bawUserWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存微信用户
     */
    @RequiresPermissions("wx:baw_user_wx:edit")
    @Log(title = "微信用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawUserWx bawUserWx)
    {
        return toAjax(bawUserWxService.updateBawUserWx(bawUserWx));
    }

    /**
     * 删除微信用户
     */
    @RequiresPermissions("wx:baw_user_wx:remove")
    @Log(title = "微信用户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawUserWxService.deleteBawUserWxByIds(ids));
    }
}
