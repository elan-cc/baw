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
import com.ruoyi.web.domain.BawTechnicalSupportLikesWx;
import com.ruoyi.web.service.IBawTechnicalSupportLikesWxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 技术支持点赞Controller
 * 
 * @author ruoyi
 * @date 2022-04-20
 */
@Controller
@RequestMapping("/wx/baw_techSupport_likes_wx")
public class BawTechnicalSupportLikesWxController extends BaseController
{
    private String prefix = "wx/baw_techSupport_likes_wx";

    @Autowired
    private IBawTechnicalSupportLikesWxService bawTechnicalSupportLikesWxService;

    @RequiresPermissions("wx:baw_techSupport_likes_wx:view")
    @GetMapping()
    public String baw_techSupport_likes_wx()
    {
        return prefix + "/baw_techSupport_likes_wx";
    }

    /**
     * 查询技术支持点赞列表
     */
    @RequiresPermissions("wx:baw_techSupport_likes_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawTechnicalSupportLikesWx bawTechnicalSupportLikesWx)
    {
        startPage();
        List<BawTechnicalSupportLikesWx> list = bawTechnicalSupportLikesWxService.selectBawTechnicalSupportLikesWxList(bawTechnicalSupportLikesWx);
        return getDataTable(list);
    }

    /**
     * 导出技术支持点赞列表
     */
    @RequiresPermissions("wx:baw_techSupport_likes_wx:export")
    @Log(title = "技术支持点赞", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawTechnicalSupportLikesWx bawTechnicalSupportLikesWx)
    {
        List<BawTechnicalSupportLikesWx> list = bawTechnicalSupportLikesWxService.selectBawTechnicalSupportLikesWxList(bawTechnicalSupportLikesWx);
        ExcelUtil<BawTechnicalSupportLikesWx> util = new ExcelUtil<BawTechnicalSupportLikesWx>(BawTechnicalSupportLikesWx.class);
        return util.exportExcel(list, "技术支持点赞数据");
    }

    /**
     * 新增技术支持点赞
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存技术支持点赞
     */
    @RequiresPermissions("wx:baw_techSupport_likes_wx:add")
    @Log(title = "技术支持点赞", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawTechnicalSupportLikesWx bawTechnicalSupportLikesWx)
    {
        return toAjax(bawTechnicalSupportLikesWxService.insertBawTechnicalSupportLikesWx(bawTechnicalSupportLikesWx));
    }

    /**
     * 修改技术支持点赞
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawTechnicalSupportLikesWx bawTechnicalSupportLikesWx = bawTechnicalSupportLikesWxService.selectBawTechnicalSupportLikesWxById(id);
        mmap.put("bawTechnicalSupportLikesWx", bawTechnicalSupportLikesWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存技术支持点赞
     */
    @RequiresPermissions("wx:baw_techSupport_likes_wx:edit")
    @Log(title = "技术支持点赞", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawTechnicalSupportLikesWx bawTechnicalSupportLikesWx)
    {
        return toAjax(bawTechnicalSupportLikesWxService.updateBawTechnicalSupportLikesWx(bawTechnicalSupportLikesWx));
    }

    /**
     * 删除技术支持点赞
     */
    @RequiresPermissions("wx:baw_techSupport_likes_wx:remove")
    @Log(title = "技术支持点赞", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawTechnicalSupportLikesWxService.deleteBawTechnicalSupportLikesWxByIds(ids));
    }
}
