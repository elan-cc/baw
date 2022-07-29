package com.ruoyi.web.controller;

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
import com.ruoyi.web.domain.BawIndexPptWx;
import com.ruoyi.web.service.IBawIndexPptWxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 首页轮播图Controller
 * 
 * @author ruoyi
 * @date 2022-04-28
 */
@Controller
@RequestMapping("/front/baw_index_ppt_wx")
public class BawIndexPptWxController extends BaseController
{
    private String prefix = "front/baw_index_ppt_wx";

    @Autowired
    private IBawIndexPptWxService bawIndexPptWxService;

    @RequiresPermissions("front:baw_index_ppt_wx:view")
    @GetMapping()
    public String baw_index_ppt_wx()
    {
        return prefix + "/baw_index_ppt_wx";
    }

    /**
     * 查询首页轮播图列表
     */
    @RequiresPermissions("front:baw_index_ppt_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawIndexPptWx bawIndexPptWx)
    {
        startPage();
        List<BawIndexPptWx> list = bawIndexPptWxService.selectBawIndexPptWxList(bawIndexPptWx);
        return getDataTable(list);
    }

    /**
     * 导出首页轮播图列表
     */
    @RequiresPermissions("front:baw_index_ppt_wx:export")
    @Log(title = "首页轮播图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawIndexPptWx bawIndexPptWx)
    {
        List<BawIndexPptWx> list = bawIndexPptWxService.selectBawIndexPptWxList(bawIndexPptWx);
        ExcelUtil<BawIndexPptWx> util = new ExcelUtil<BawIndexPptWx>(BawIndexPptWx.class);
        return util.exportExcel(list, "首页轮播图数据");
    }

    /**
     * 新增首页轮播图
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存首页轮播图
     */
    @RequiresPermissions("front:baw_index_ppt_wx:add")
    @Log(title = "首页轮播图", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawIndexPptWx bawIndexPptWx)
    {
        return toAjax(bawIndexPptWxService.insertBawIndexPptWx(bawIndexPptWx));
    }

    /**
     * 修改首页轮播图
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawIndexPptWx bawIndexPptWx = bawIndexPptWxService.selectBawIndexPptWxById(id);
        mmap.put("bawIndexPptWx", bawIndexPptWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存首页轮播图
     */
    @RequiresPermissions("front:baw_index_ppt_wx:edit")
    @Log(title = "首页轮播图", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawIndexPptWx bawIndexPptWx)
    {
        return toAjax(bawIndexPptWxService.updateBawIndexPptWx(bawIndexPptWx));
    }

    /**
     * 删除首页轮播图
     */
    @RequiresPermissions("front:baw_index_ppt_wx:remove")
    @Log(title = "首页轮播图", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawIndexPptWxService.deleteBawIndexPptWxByIds(ids));
    }
}
