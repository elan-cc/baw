package com.ruoyi.web.controller.wx;

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
import com.ruoyi.web.domain.BawTechnicalSupportCommentWx;
import com.ruoyi.web.service.IBawTechnicalSupportCommentWxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 技术支持评论Controller
 * 
 * @author ruoyi
 * @date 2022-04-20
 */
@Controller
@RequestMapping("/wx/baw_techComment_wx")
public class BawTechnicalSupportCommentWxController extends BaseController
{
    private String prefix = "wx/baw_techComment_wx";

    @Autowired
    private IBawTechnicalSupportCommentWxService bawTechnicalSupportCommentWxService;

    @RequiresPermissions("wx:baw_techComment_wx:view")
    @GetMapping()
    public String baw_techComment_wx()
    {
        return prefix + "/baw_techComment_wx";
    }

    /**
     * 查询技术支持评论列表
     */
    @RequiresPermissions("wx:baw_techComment_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawTechnicalSupportCommentWx bawTechnicalSupportCommentWx)
    {
        startPage();
        List<BawTechnicalSupportCommentWx> list = bawTechnicalSupportCommentWxService.selectBawTechnicalSupportCommentWxList(bawTechnicalSupportCommentWx);
        return getDataTable(list);
    }

    /**
     * 导出技术支持评论列表
     */
    @RequiresPermissions("wx:baw_techComment_wx:export")
    @Log(title = "技术支持评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawTechnicalSupportCommentWx bawTechnicalSupportCommentWx)
    {
        List<BawTechnicalSupportCommentWx> list = bawTechnicalSupportCommentWxService.selectBawTechnicalSupportCommentWxList(bawTechnicalSupportCommentWx);
        ExcelUtil<BawTechnicalSupportCommentWx> util = new ExcelUtil<BawTechnicalSupportCommentWx>(BawTechnicalSupportCommentWx.class);
        return util.exportExcel(list, "技术支持评论数据");
    }

    /**
     * 新增技术支持评论
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存技术支持评论
     */
    @RequiresPermissions("wx:baw_techComment_wx:add")
    @Log(title = "技术支持评论", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawTechnicalSupportCommentWx bawTechnicalSupportCommentWx)
    {
        return toAjax(bawTechnicalSupportCommentWxService.insertBawTechnicalSupportCommentWx(bawTechnicalSupportCommentWx));
    }

    /**
     * 修改技术支持评论
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawTechnicalSupportCommentWx bawTechnicalSupportCommentWx = bawTechnicalSupportCommentWxService.selectBawTechnicalSupportCommentWxById(id);
        mmap.put("bawTechnicalSupportCommentWx", bawTechnicalSupportCommentWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存技术支持评论
     */
    @RequiresPermissions("wx:baw_techComment_wx:edit")
    @Log(title = "技术支持评论", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawTechnicalSupportCommentWx bawTechnicalSupportCommentWx)
    {
        return toAjax(bawTechnicalSupportCommentWxService.updateBawTechnicalSupportCommentWx(bawTechnicalSupportCommentWx));
    }

    /**
     * 删除技术支持评论
     */
    @RequiresPermissions("wx:baw_techComment_wx:remove")
    @Log(title = "技术支持评论", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawTechnicalSupportCommentWxService.deleteBawTechnicalSupportCommentWxByIds(ids));
    }
}
