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
import com.ruoyi.web.domain.BawZhaopin;
import com.ruoyi.web.service.IBawZhaopinService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 加入我们Controller
 * 
 * @author ruoyi
 * @date 2021-12-09
 */
@Controller
@RequestMapping("/company/baw_zhaopin")
public class BawZhaopinController extends BaseController
{
    private String prefix = "company/baw_zhaopin";

    @Autowired
    private IBawZhaopinService bawZhaopinService;

    @RequiresPermissions("company:baw_zhaopin:view")
    @GetMapping()
    public String baw_zhaopin()
    {
        return prefix + "/baw_zhaopin";
    }

    /**
     * 查询加入我们列表
     */
    @RequiresPermissions("company:baw_zhaopin:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawZhaopin bawZhaopin)
    {
        bawZhaopin.setIsDelete(0);
        startPage();
        List<BawZhaopin> list = bawZhaopinService.selectBawZhaopinList(bawZhaopin);
        return getDataTable(list);
    }

    /**
     * 导出加入我们列表
     */
    @RequiresPermissions("company:baw_zhaopin:export")
    @Log(title = "加入我们", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawZhaopin bawZhaopin)
    {
        bawZhaopin.setIsDelete(0);
        List<BawZhaopin> list = bawZhaopinService.selectBawZhaopinList(bawZhaopin);
        ExcelUtil<BawZhaopin> util = new ExcelUtil<BawZhaopin>(BawZhaopin.class);
        return util.exportExcel(list, "加入我们数据");
    }

    /**
     * 新增加入我们
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存加入我们
     */
    @RequiresPermissions("company:baw_zhaopin:add")
    @Log(title = "加入我们", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawZhaopin bawZhaopin)
    {
        bawZhaopin.setIsDelete(0);
        bawZhaopin.setAddUser(ShiroUtils.getSysUser().getLoginName());
        bawZhaopin.setAddDate(Integer.parseInt(MyDateUtils.getTimeStamp10()));
        return toAjax(bawZhaopinService.insertBawZhaopin(bawZhaopin));
    }

    /**
     * 修改加入我们
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawZhaopin bawZhaopin = bawZhaopinService.selectBawZhaopinById(id);
        mmap.put("bawZhaopin", bawZhaopin);
        return prefix + "/edit";
    }

    /**
     * 修改保存加入我们
     */
    @RequiresPermissions("company:baw_zhaopin:edit")
    @Log(title = "加入我们", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawZhaopin bawZhaopin)
    {
        return toAjax(bawZhaopinService.updateBawZhaopin(bawZhaopin));
    }

    /**
     * 删除加入我们
     */
    @RequiresPermissions("company:baw_zhaopin:remove")
    @Log(title = "加入我们", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawZhaopinService.deleteBawZhaopinByIds(ids));
    }
}
