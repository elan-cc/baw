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
import com.ruoyi.web.domain.BawInformationOfficialCommentLikesWx;
import com.ruoyi.web.service.IBawInformationOfficialCommentLikesWxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 官方资讯评论点赞Controller
 * 
 * @author ruoyi
 * @date 2022-04-19
 */
@Controller
@RequestMapping("/wx/baw_information_comLikes_wx")
public class BawInformationOfficialCommentLikesWxController extends BaseController
{
    private String prefix = "wx/baw_information_comLikes_wx";

    @Autowired
    private IBawInformationOfficialCommentLikesWxService bawInformationOfficialCommentLikesWxService;

    @RequiresPermissions("wx:baw_information_comLikes_wx:view")
    @GetMapping()
    public String baw_information_comLikes_wx()
    {
        return prefix + "/baw_information_comLikes_wx";
    }

    /**
     * 查询官方资讯评论点赞列表
     */
    @RequiresPermissions("wx:baw_information_comLikes_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawInformationOfficialCommentLikesWx bawInformationOfficialCommentLikesWx)
    {
        startPage();
        List<BawInformationOfficialCommentLikesWx> list = bawInformationOfficialCommentLikesWxService.selectBawInformationOfficialCommentLikesWxList(bawInformationOfficialCommentLikesWx);
        return getDataTable(list);
    }

    /**
     * 导出官方资讯评论点赞列表
     */
    @RequiresPermissions("wx:baw_information_comLikes_wx:export")
    @Log(title = "官方资讯评论点赞", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawInformationOfficialCommentLikesWx bawInformationOfficialCommentLikesWx)
    {
        List<BawInformationOfficialCommentLikesWx> list = bawInformationOfficialCommentLikesWxService.selectBawInformationOfficialCommentLikesWxList(bawInformationOfficialCommentLikesWx);
        ExcelUtil<BawInformationOfficialCommentLikesWx> util = new ExcelUtil<BawInformationOfficialCommentLikesWx>(BawInformationOfficialCommentLikesWx.class);
        return util.exportExcel(list, "官方资讯评论点赞数据");
    }

    /**
     * 新增官方资讯评论点赞
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存官方资讯评论点赞
     */
    @RequiresPermissions("wx:baw_information_comLikes_wx:add")
    @Log(title = "官方资讯评论点赞", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawInformationOfficialCommentLikesWx bawInformationOfficialCommentLikesWx)
    {
        return toAjax(bawInformationOfficialCommentLikesWxService.insertBawInformationOfficialCommentLikesWx(bawInformationOfficialCommentLikesWx));
    }

    /**
     * 修改官方资讯评论点赞
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawInformationOfficialCommentLikesWx bawInformationOfficialCommentLikesWx = bawInformationOfficialCommentLikesWxService.selectBawInformationOfficialCommentLikesWxById(id);
        mmap.put("bawInformationOfficialCommentLikesWx", bawInformationOfficialCommentLikesWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存官方资讯评论点赞
     */
    @RequiresPermissions("wx:baw_information_comLikes_wx:edit")
    @Log(title = "官方资讯评论点赞", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawInformationOfficialCommentLikesWx bawInformationOfficialCommentLikesWx)
    {
        return toAjax(bawInformationOfficialCommentLikesWxService.updateBawInformationOfficialCommentLikesWx(bawInformationOfficialCommentLikesWx));
    }

    /**
     * 删除官方资讯评论点赞
     */
    @RequiresPermissions("wx:baw_information_comLikes_wx:remove")
    @Log(title = "官方资讯评论点赞", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawInformationOfficialCommentLikesWxService.deleteBawInformationOfficialCommentLikesWxByIds(ids));
    }
}
