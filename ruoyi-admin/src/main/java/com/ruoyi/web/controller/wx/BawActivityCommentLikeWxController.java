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
import com.ruoyi.web.domain.BawActivityCommentLikeWx;
import com.ruoyi.web.service.IBawActivityCommentLikeWxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评论点赞记录Controller
 * 
 * @author ruoyi
 * @date 2022-03-18
 */
@Controller
@RequestMapping("/wx/baw_activity_comment_like_wx")
public class BawActivityCommentLikeWxController extends BaseController
{
    private String prefix = "wx/baw_activity_comment_like_wx";

    @Autowired
    private IBawActivityCommentLikeWxService bawActivityCommentLikeWxService;

    @RequiresPermissions("wx:baw_activity_comment_like_wx:view")
    @GetMapping()
    public String baw_activity_comment_like_wx()
    {
        return prefix + "/baw_activity_comment_like_wx";
    }

    /**
     * 查询评论点赞记录列表
     */
    @RequiresPermissions("wx:baw_activity_comment_like_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawActivityCommentLikeWx bawActivityCommentLikeWx)
    {
        startPage();
        List<BawActivityCommentLikeWx> list = bawActivityCommentLikeWxService.selectBawActivityCommentLikeWxList(bawActivityCommentLikeWx);
        return getDataTable(list);
    }

    /**
     * 导出评论点赞记录列表
     */
    @RequiresPermissions("wx:baw_activity_comment_like_wx:export")
    @Log(title = "评论点赞记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawActivityCommentLikeWx bawActivityCommentLikeWx)
    {
        List<BawActivityCommentLikeWx> list = bawActivityCommentLikeWxService.selectBawActivityCommentLikeWxList(bawActivityCommentLikeWx);
        ExcelUtil<BawActivityCommentLikeWx> util = new ExcelUtil<BawActivityCommentLikeWx>(BawActivityCommentLikeWx.class);
        return util.exportExcel(list, "评论点赞记录数据");
    }

    /**
     * 新增评论点赞记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存评论点赞记录
     */
    @RequiresPermissions("wx:baw_activity_comment_like_wx:add")
    @Log(title = "评论点赞记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawActivityCommentLikeWx bawActivityCommentLikeWx)
    {
        return toAjax(bawActivityCommentLikeWxService.insertBawActivityCommentLikeWx(bawActivityCommentLikeWx));
    }

    /**
     * 修改评论点赞记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawActivityCommentLikeWx bawActivityCommentLikeWx = bawActivityCommentLikeWxService.selectBawActivityCommentLikeWxById(id);
        mmap.put("bawActivityCommentLikeWx", bawActivityCommentLikeWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存评论点赞记录
     */
    @RequiresPermissions("wx:baw_activity_comment_like_wx:edit")
    @Log(title = "评论点赞记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawActivityCommentLikeWx bawActivityCommentLikeWx)
    {
        return toAjax(bawActivityCommentLikeWxService.updateBawActivityCommentLikeWx(bawActivityCommentLikeWx));
    }

    /**
     * 删除评论点赞记录
     */
    @RequiresPermissions("wx:baw_activity_comment_like_wx:remove")
    @Log(title = "评论点赞记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawActivityCommentLikeWxService.deleteBawActivityCommentLikeWxByIds(ids));
    }
}
