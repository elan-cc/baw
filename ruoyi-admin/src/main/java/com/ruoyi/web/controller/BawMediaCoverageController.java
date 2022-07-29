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
import com.ruoyi.web.domain.BawMediaCoverage;
import com.ruoyi.web.service.IBawMediaCoverageService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 媒体报道Controller
 * 
 * @author ruoyi
 * @date 2021-12-06
 */
@Controller
@RequestMapping("/news/baw_media_coverage")
public class BawMediaCoverageController extends BaseController
{
    private String prefix = "news/baw_media_coverage";

    @Autowired
    private IBawMediaCoverageService bawMediaCoverageService;

    @RequiresPermissions("news:baw_media_coverage:view")
    @GetMapping()
    public String baw_media_coverage()
    {
        return prefix + "/baw_media_coverage";
    }

    /**
     * 查询媒体报道列表
     */
    @RequiresPermissions("news:baw_media_coverage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawMediaCoverage bawMediaCoverage)
    {
        bawMediaCoverage.setIsDelete(0);
        startPage();
        List<BawMediaCoverage> list = bawMediaCoverageService.selectBawMediaCoverageList(bawMediaCoverage);
        return getDataTable(list);
    }

    /**
     * 导出媒体报道列表
     */
    @RequiresPermissions("news:baw_media_coverage:export")
    @Log(title = "媒体报道", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawMediaCoverage bawMediaCoverage)
    {
        bawMediaCoverage.setIsDelete(0);
        List<BawMediaCoverage> list = bawMediaCoverageService.selectBawMediaCoverageList(bawMediaCoverage);
        ExcelUtil<BawMediaCoverage> util = new ExcelUtil<BawMediaCoverage>(BawMediaCoverage.class);
        return util.exportExcel(list, "媒体报道数据");
    }

    /**
     * 新增媒体报道
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存媒体报道
     */
    @RequiresPermissions("news:baw_media_coverage:add")
    @Log(title = "媒体报道", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawMediaCoverage bawMediaCoverage)
    {
        if(bawMediaCoverage.getFabuDate() == null || "".equals(bawMediaCoverage.getFabuDate()))
        {
            bawMediaCoverage.setFabuDate(MyDateUtils.getTimeStamp10());
        }
        else
        {
            bawMediaCoverage.setFabuDate(MyDateUtils.StringToTimestamp(bawMediaCoverage.getFabuDate()+" 00:00:00")+"");
        }
        bawMediaCoverage.setIsDelete(0);
        bawMediaCoverage.setAddUser(ShiroUtils.getSysUser().getLoginName());
        bawMediaCoverage.setAddDate(Integer.parseInt(MyDateUtils.getTimeStamp10()));
        return toAjax(bawMediaCoverageService.insertBawMediaCoverage(bawMediaCoverage));
    }

    /**
     * 修改媒体报道
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawMediaCoverage bawMediaCoverage = bawMediaCoverageService.selectBawMediaCoverageById(id);
        bawMediaCoverage.setFabuDate(MyDateUtils.timestampToString(Convert.toInt(bawMediaCoverage.getFabuDate()),"yyyy-MM-dd"));
        mmap.put("bawMediaCoverage", bawMediaCoverage);
        return prefix + "/edit";
    }

    /**
     * 修改保存媒体报道
     */
    @RequiresPermissions("news:baw_media_coverage:edit")
    @Log(title = "媒体报道", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawMediaCoverage bawMediaCoverage)
    {
        if(bawMediaCoverage.getFabuDate() == null || "".equals(bawMediaCoverage.getFabuDate()))
        {
            bawMediaCoverage.setFabuDate(MyDateUtils.getTimeStamp10());
        }
        else
        {
            bawMediaCoverage.setFabuDate(MyDateUtils.StringToTimestamp(bawMediaCoverage.getFabuDate()+" 00:00:00")+"");
        }
        return toAjax(bawMediaCoverageService.updateBawMediaCoverage(bawMediaCoverage));
    }

    /**
     * 删除媒体报道
     */
    @RequiresPermissions("news:baw_media_coverage:remove")
    @Log(title = "媒体报道", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawMediaCoverageService.deleteBawMediaCoverageByIds(ids));
    }
}
