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
import com.ruoyi.web.domain.BawActivityLikeWx;
import com.ruoyi.web.service.IBawActivityLikeWxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动点赞记录Controller
 * 
 * @author ruoyi
 * @date 2022-03-18
 */
@Controller
@RequestMapping("/wx/baw_activity_like_wx")
public class BawActivityLikeWxController extends BaseController
{
    private String prefix = "wx/baw_activity_like_wx";

    @Autowired
    private IBawActivityLikeWxService bawActivityLikeWxService;

    @RequiresPermissions("wx:baw_activity_like_wx:view")
    @GetMapping()
    public String baw_activity_like_wx()
    {
        return prefix + "/baw_activity_like_wx";
    }

    /**
     * 查询活动点赞记录列表
     */
    @RequiresPermissions("wx:baw_activity_like_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawActivityLikeWx bawActivityLikeWx)
    {
        startPage();
        List<BawActivityLikeWx> list = bawActivityLikeWxService.selectBawActivityLikeWxList(bawActivityLikeWx);
        return getDataTable(list);
    }

    /**
     * 导出活动点赞记录列表
     */
    @RequiresPermissions("wx:baw_activity_like_wx:export")
    @Log(title = "活动点赞记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawActivityLikeWx bawActivityLikeWx)
    {
        List<BawActivityLikeWx> list = bawActivityLikeWxService.selectBawActivityLikeWxList(bawActivityLikeWx);
        ExcelUtil<BawActivityLikeWx> util = new ExcelUtil<BawActivityLikeWx>(BawActivityLikeWx.class);
        return util.exportExcel(list, "活动点赞记录数据");
    }

    /**
     * 新增活动点赞记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存活动点赞记录
     */
    @RequiresPermissions("wx:baw_activity_like_wx:add")
    @Log(title = "活动点赞记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawActivityLikeWx bawActivityLikeWx)
    {
        return toAjax(bawActivityLikeWxService.insertBawActivityLikeWx(bawActivityLikeWx));
    }

    /**
     * 修改活动点赞记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawActivityLikeWx bawActivityLikeWx = bawActivityLikeWxService.selectBawActivityLikeWxById(id);
        mmap.put("bawActivityLikeWx", bawActivityLikeWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存活动点赞记录
     */
    @RequiresPermissions("wx:baw_activity_like_wx:edit")
    @Log(title = "活动点赞记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawActivityLikeWx bawActivityLikeWx)
    {
        return toAjax(bawActivityLikeWxService.updateBawActivityLikeWx(bawActivityLikeWx));
    }

    /**
     * 删除活动点赞记录
     */
    @RequiresPermissions("wx:baw_activity_like_wx:remove")
    @Log(title = "活动点赞记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawActivityLikeWxService.deleteBawActivityLikeWxByIds(ids));
    }
}
