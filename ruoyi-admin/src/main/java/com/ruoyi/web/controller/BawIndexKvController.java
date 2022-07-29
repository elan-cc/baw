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
import com.ruoyi.web.domain.BawIndexKv;
import com.ruoyi.web.service.IBawIndexKvService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 首页KVController
 * 
 * @author ruoyi
 * @date 2021-12-09
 */
@Controller
@RequestMapping("/front/baw_index_kv")
public class BawIndexKvController extends BaseController
{
    private String prefix = "front/baw_index_kv";

    @Autowired
    private IBawIndexKvService bawIndexKvService;

    @RequiresPermissions("front:baw_index_kv:view")
    @GetMapping()
    public String baw_index_kv()
    {
        return prefix + "/baw_index_kv";
    }

    /**
     * 查询首页KV列表
     */
    @RequiresPermissions("front:baw_index_kv:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawIndexKv bawIndexKv)
    {
        bawIndexKv.setIsDelete(0);
        startPage();
        List<BawIndexKv> list = bawIndexKvService.selectBawIndexKvList(bawIndexKv);
        return getDataTable(list);
    }

    /**
     * 导出首页KV列表
     */
    @RequiresPermissions("front:baw_index_kv:export")
    @Log(title = "首页KV", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawIndexKv bawIndexKv)
    {
        bawIndexKv.setIsDelete(0);
        List<BawIndexKv> list = bawIndexKvService.selectBawIndexKvList(bawIndexKv);
        ExcelUtil<BawIndexKv> util = new ExcelUtil<BawIndexKv>(BawIndexKv.class);
        return util.exportExcel(list, "首页KV数据");
    }

    /**
     * 新增首页KV
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存首页KV
     */
    @RequiresPermissions("front:baw_index_kv:add")
    @Log(title = "首页KV", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawIndexKv bawIndexKv)
    {
        bawIndexKv.setIsDelete(0);
        bawIndexKv.setAddUser(ShiroUtils.getSysUser().getLoginName());
        bawIndexKv.setAddDate(Integer.parseInt(MyDateUtils.getTimeStamp10()));
        return toAjax(bawIndexKvService.insertBawIndexKv(bawIndexKv));
    }

    /**
     * 修改首页KV
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawIndexKv bawIndexKv = bawIndexKvService.selectBawIndexKvById(id);
        mmap.put("bawIndexKv", bawIndexKv);
        return prefix + "/edit";
    }

    /**
     * 修改保存首页KV
     */
    @RequiresPermissions("front:baw_index_kv:edit")
    @Log(title = "首页KV", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawIndexKv bawIndexKv)
    {
        return toAjax(bawIndexKvService.updateBawIndexKv(bawIndexKv));
    }

    /**
     * 删除首页KV
     */
    @RequiresPermissions("front:baw_index_kv:remove")
    @Log(title = "首页KV", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawIndexKvService.deleteBawIndexKvByIds(ids));
    }
}
