package com.ruoyi.web.controller;

import java.util.List;

import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.web.utils.MyDateUtils;
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
import com.ruoyi.web.domain.BawIndexModel1;
import com.ruoyi.web.service.IBawIndexModel1Service;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 首页模块1Controller
 * 
 * @author ruoyi
 * @date 2021-12-09
 */
@Controller
@RequestMapping("/front/baw_index_model1")
public class BawIndexModel1Controller extends BaseController
{
    private String prefix = "front/baw_index_model1";

    @Autowired
    private IBawIndexModel1Service bawIndexModel1Service;

    @RequiresPermissions("front:baw_index_model1:view")
    @GetMapping()
    public String baw_index_model1()
    {
        return prefix + "/baw_index_model1";
    }

    /**
     * 查询首页模块1列表
     */
    @RequiresPermissions("front:baw_index_model1:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawIndexModel1 bawIndexModel1)
    {
        bawIndexModel1.setIsDelete(0);
        startPage();
        List<BawIndexModel1> list = bawIndexModel1Service.selectBawIndexModel1List(bawIndexModel1);
        return getDataTable(list);
    }

    /**
     * 导出首页模块1列表
     */
    @RequiresPermissions("front:baw_index_model1:export")
    @Log(title = "首页模块1", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawIndexModel1 bawIndexModel1)
    {
        bawIndexModel1.setIsDelete(0);
        List<BawIndexModel1> list = bawIndexModel1Service.selectBawIndexModel1List(bawIndexModel1);
        ExcelUtil<BawIndexModel1> util = new ExcelUtil<BawIndexModel1>(BawIndexModel1.class);
        return util.exportExcel(list, "首页模块1数据");
    }

    /**
     * 新增首页模块1
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存首页模块1
     */
    @RequiresPermissions("front:baw_index_model1:add")
    @Log(title = "首页模块1", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawIndexModel1 bawIndexModel1)
    {
        bawIndexModel1.setIsDelete(0);
        bawIndexModel1.setAddUser(ShiroUtils.getSysUser().getLoginName());
        bawIndexModel1.setAddDate(Integer.parseInt(MyDateUtils.getTimeStamp10()));
        return toAjax(bawIndexModel1Service.insertBawIndexModel1(bawIndexModel1));
    }

    /**
     * 修改首页模块1
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawIndexModel1 bawIndexModel1 = bawIndexModel1Service.selectBawIndexModel1ById(id);
        mmap.put("bawIndexModel1", bawIndexModel1);
        return prefix + "/edit";
    }

    /**
     * 修改保存首页模块1
     */
    @RequiresPermissions("front:baw_index_model1:edit")
    @Log(title = "首页模块1", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawIndexModel1 bawIndexModel1)
    {
        return toAjax(bawIndexModel1Service.updateBawIndexModel1(bawIndexModel1));
    }

    /**
     * 删除首页模块1
     */
    @RequiresPermissions("front:baw_index_model1:remove")
    @Log(title = "首页模块1", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawIndexModel1Service.deleteBawIndexModel1ByIds(ids));
    }
}
