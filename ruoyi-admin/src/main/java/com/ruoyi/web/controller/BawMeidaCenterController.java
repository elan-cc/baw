package com.ruoyi.web.controller;

import java.util.List;

import com.ruoyi.common.core.text.Convert;
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
import com.ruoyi.web.domain.BawMeidaCenter;
import com.ruoyi.web.service.IBawMeidaCenterService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 媒体中心Controller
 * 
 * @author ruoyi
 * @date 2021-12-06
 */
@Controller
@RequestMapping("/news/baw_meida_center")
public class BawMeidaCenterController extends BaseController
{
    private String prefix = "news/baw_meida_center";

    @Autowired
    private IBawMeidaCenterService bawMeidaCenterService;

    @RequiresPermissions("news:baw_meida_center:view")
    @GetMapping()
    public String baw_meida_center()
    {
        return prefix + "/baw_meida_center";
    }

    /**
     * 查询媒体中心列表
     */
    @RequiresPermissions("news:baw_meida_center:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawMeidaCenter bawMeidaCenter)
    {
        bawMeidaCenter.setIsDelete(0);
        startPage();
        List<BawMeidaCenter> list = bawMeidaCenterService.selectBawMeidaCenterList(bawMeidaCenter);
        return getDataTable(list);
    }

    /**
     * 导出媒体中心列表
     */
    @RequiresPermissions("news:baw_meida_center:export")
    @Log(title = "媒体中心", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawMeidaCenter bawMeidaCenter)
    {
        bawMeidaCenter.setIsDelete(0);
        List<BawMeidaCenter> list = bawMeidaCenterService.selectBawMeidaCenterList(bawMeidaCenter);
        ExcelUtil<BawMeidaCenter> util = new ExcelUtil<BawMeidaCenter>(BawMeidaCenter.class);
        return util.exportExcel(list, "媒体中心数据");
    }

    /**
     * 新增媒体中心
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存媒体中心
     */
    @RequiresPermissions("news:baw_meida_center:add")
    @Log(title = "媒体中心", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawMeidaCenter bawMeidaCenter)
    {
        if(bawMeidaCenter.getFabuDate() == null || "".equals(bawMeidaCenter.getFabuDate()))
        {
            bawMeidaCenter.setFabuDate(MyDateUtils.getTimeStamp10());
        }
        else
        {
            bawMeidaCenter.setFabuDate(MyDateUtils.StringToTimestamp(bawMeidaCenter.getFabuDate()+" 00:00:00")+"");
        }
        bawMeidaCenter.setIsDelete(0);
        bawMeidaCenter.setAddUser(ShiroUtils.getSysUser().getLoginName());
        bawMeidaCenter.setAddDate(Integer.parseInt(MyDateUtils.getTimeStamp10()));
        return toAjax(bawMeidaCenterService.insertBawMeidaCenter(bawMeidaCenter));
    }

    /**
     * 修改媒体中心
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawMeidaCenter bawMeidaCenter = bawMeidaCenterService.selectBawMeidaCenterById(id);
        bawMeidaCenter.setFabuDate(MyDateUtils.timestampToString(Convert.toInt(bawMeidaCenter.getFabuDate()),"yyyy-MM-dd"));
        mmap.put("bawMeidaCenter", bawMeidaCenter);
        return prefix + "/edit";
    }

    /**
     * 修改保存媒体中心
     */
    @RequiresPermissions("news:baw_meida_center:edit")
    @Log(title = "媒体中心", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawMeidaCenter bawMeidaCenter)
    {
        if(bawMeidaCenter.getFabuDate() == null || "".equals(bawMeidaCenter.getFabuDate()))
        {
            bawMeidaCenter.setFabuDate(MyDateUtils.getTimeStamp10());
        }
        else
        {
            bawMeidaCenter.setFabuDate(MyDateUtils.StringToTimestamp(bawMeidaCenter.getFabuDate()+" 00:00:00")+"");
        }
        return toAjax(bawMeidaCenterService.updateBawMeidaCenter(bawMeidaCenter));
    }

    /**
     * 删除媒体中心
     */
    @RequiresPermissions("news:baw_meida_center:remove")
    @Log(title = "媒体中心", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawMeidaCenterService.deleteBawMeidaCenterByIds(ids));
    }
}
