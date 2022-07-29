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
import com.ruoyi.web.domain.BawInformationOfficialLikesWx;
import com.ruoyi.web.service.IBawInformationOfficialLikesWxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 官方资讯点赞Controller
 * 
 * @author ruoyi
 * @date 2022-04-19
 */
@Controller
@RequestMapping("/wx/baw_information_likes_wx")
public class BawInformationOfficialLikesWxController extends BaseController
{
    private String prefix = "wx/baw_information_likes_wx";

    @Autowired
    private IBawInformationOfficialLikesWxService bawInformationOfficialLikesWxService;

    @RequiresPermissions("wx:baw_information_likes_wx:view")
    @GetMapping()
    public String baw_information_likes_wx()
    {
        return prefix + "/baw_information_likes_wx";
    }

    /**
     * 查询官方资讯点赞列表
     */
    @RequiresPermissions("wx:baw_information_likes_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawInformationOfficialLikesWx bawInformationOfficialLikesWx)
    {
        startPage();
        List<BawInformationOfficialLikesWx> list = bawInformationOfficialLikesWxService.selectBawInformationOfficialLikesWxList(bawInformationOfficialLikesWx);
        return getDataTable(list);
    }

    /**
     * 导出官方资讯点赞列表
     */
    @RequiresPermissions("wx:baw_information_likes_wx:export")
    @Log(title = "官方资讯点赞", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawInformationOfficialLikesWx bawInformationOfficialLikesWx)
    {
        List<BawInformationOfficialLikesWx> list = bawInformationOfficialLikesWxService.selectBawInformationOfficialLikesWxList(bawInformationOfficialLikesWx);
        ExcelUtil<BawInformationOfficialLikesWx> util = new ExcelUtil<BawInformationOfficialLikesWx>(BawInformationOfficialLikesWx.class);
        return util.exportExcel(list, "官方资讯点赞数据");
    }

    /**
     * 新增官方资讯点赞
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存官方资讯点赞
     */
    @RequiresPermissions("wx:baw_information_likes_wx:add")
    @Log(title = "官方资讯点赞", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawInformationOfficialLikesWx bawInformationOfficialLikesWx)
    {
        return toAjax(bawInformationOfficialLikesWxService.insertBawInformationOfficialLikesWx(bawInformationOfficialLikesWx));
    }

    /**
     * 修改官方资讯点赞
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawInformationOfficialLikesWx bawInformationOfficialLikesWx = bawInformationOfficialLikesWxService.selectBawInformationOfficialLikesWxById(id);
        mmap.put("bawInformationOfficialLikesWx", bawInformationOfficialLikesWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存官方资讯点赞
     */
    @RequiresPermissions("wx:baw_information_likes_wx:edit")
    @Log(title = "官方资讯点赞", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawInformationOfficialLikesWx bawInformationOfficialLikesWx)
    {
        return toAjax(bawInformationOfficialLikesWxService.updateBawInformationOfficialLikesWx(bawInformationOfficialLikesWx));
    }

    /**
     * 删除官方资讯点赞
     */
    @RequiresPermissions("wx:baw_information_likes_wx:remove")
    @Log(title = "官方资讯点赞", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawInformationOfficialLikesWxService.deleteBawInformationOfficialLikesWxByIds(ids));
    }
}
