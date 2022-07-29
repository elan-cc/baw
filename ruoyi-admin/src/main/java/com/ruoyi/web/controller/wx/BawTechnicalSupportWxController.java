package com.ruoyi.web.controller.wx;

import java.util.List;

import com.ruoyi.web.domain.BawInformationOfficialCommentWx;
import com.ruoyi.web.domain.BawTechnicalSupportCommentWx;
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
import com.ruoyi.web.domain.BawTechnicalSupportWx;
import com.ruoyi.web.service.IBawTechnicalSupportWxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 技术支持Controller
 * 
 * @author ruoyi
 * @date 2022-04-20
 */
@Controller
@RequestMapping("/wx/baw_techSupport_wx")
public class BawTechnicalSupportWxController extends BaseController
{
    private String prefix = "wx/baw_techSupport_wx";

    @Autowired
    private IBawTechnicalSupportWxService bawTechnicalSupportWxService;

    @RequiresPermissions("wx:baw_techSupport_wx:view")
    @GetMapping()
    public String baw_techSupport_wx()
    {
        return prefix + "/baw_techSupport_wx";
    }

    /**
     * 查询技术支持列表
     */
    @RequiresPermissions("wx:baw_techSupport_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawTechnicalSupportWx bawTechnicalSupportWx)
    {
        startPage();
        List<BawTechnicalSupportWx> list = bawTechnicalSupportWxService.selectBawTechnicalSupportWxList(bawTechnicalSupportWx);
        return getDataTable(list);
    }

    /**
     * 导出技术支持列表
     */
    @RequiresPermissions("wx:baw_techSupport_wx:export")
    @Log(title = "技术支持", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawTechnicalSupportWx bawTechnicalSupportWx)
    {
        List<BawTechnicalSupportWx> list = bawTechnicalSupportWxService.selectBawTechnicalSupportWxList(bawTechnicalSupportWx);
        ExcelUtil<BawTechnicalSupportWx> util = new ExcelUtil<BawTechnicalSupportWx>(BawTechnicalSupportWx.class);
        return util.exportExcel(list, "技术支持数据");
    }

    /**
     * 新增技术支持
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存技术支持
     */
    @RequiresPermissions("wx:baw_techSupport_wx:add")
    @Log(title = "技术支持", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawTechnicalSupportWx bawTechnicalSupportWx)
    {
        return toAjax(bawTechnicalSupportWxService.insertBawTechnicalSupportWx(bawTechnicalSupportWx));
    }

    /**
     * 修改技术支持
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawTechnicalSupportWx bawTechnicalSupportWx = bawTechnicalSupportWxService.selectBawTechnicalSupportWxById(id);
        mmap.put("bawTechnicalSupportWx", bawTechnicalSupportWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存技术支持
     */
    @RequiresPermissions("wx:baw_techSupport_wx:edit")
    @Log(title = "技术支持", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawTechnicalSupportWx bawTechnicalSupportWx)
    {
        return toAjax(bawTechnicalSupportWxService.updateBawTechnicalSupportWx(bawTechnicalSupportWx));
    }

    /**
     * 删除技术支持
     */
    @RequiresPermissions("wx:baw_techSupport_wx:remove")
    @Log(title = "技术支持", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(Integer ids)
    {
        return toAjax(bawTechnicalSupportWxService.deleteBawTechnicalSupportWxById(ids));
    }


    /**
     * 查询官方资讯评论
     */
    @GetMapping("/commentList/{id}")
    public String commentList(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawTechnicalSupportCommentWx bawTechnicalSupportCommentWx =new BawTechnicalSupportCommentWx();
        bawTechnicalSupportCommentWx.setTechId(id);
        mmap.put("bawTechnicalSupportCommentWx",bawTechnicalSupportCommentWx);
        return "wx/baw_techComment_wx/baw_techComment_wx";
    }
}
