package com.ruoyi.web.controller.wx;

import java.util.List;

import io.swagger.models.auth.In;
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
import com.ruoyi.web.domain.BawActivityCommentWx;
import com.ruoyi.web.service.IBawActivityCommentWxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动评论Controller
 *
 * @author ruoyi
 * @date 2022-03-17
 */
@Controller
@RequestMapping("/wx/baw_activity_comment_wx")
public class BawActivityCommentWxController extends BaseController
{
    private String prefix = "wx/baw_activity_comment_wx";

    @Autowired
    private IBawActivityCommentWxService bawActivityCommentWxService;

    @RequiresPermissions("wx:baw_activity_comment_wx:view")
    @GetMapping()
    public String baw_activity_comment_wx()
    {
        return prefix + "/baw_activity_comment_wx";
    }

    /**
     * 查询活动评论列表
     */
    @RequiresPermissions("wx:baw_activity_comment_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawActivityCommentWx bawActivityCommentWx)
    {
        startPage();
        List<BawActivityCommentWx> list = bawActivityCommentWxService.selectBawActivityCommentWxList(bawActivityCommentWx);
        return getDataTable(list);
    }

    /**
     * 导出活动评论列表
     */
    @RequiresPermissions("wx:baw_activity_comment_wx:export")
    @Log(title = "活动评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawActivityCommentWx bawActivityCommentWx)
    {
        List<BawActivityCommentWx> list = bawActivityCommentWxService.selectBawActivityCommentWxList(bawActivityCommentWx);
        ExcelUtil<BawActivityCommentWx> util = new ExcelUtil<BawActivityCommentWx>(BawActivityCommentWx.class);
        return util.exportExcel(list, "活动评论数据");
    }

    /**
     * 新增活动评论
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存活动评论
     */
    @RequiresPermissions("wx:baw_activity_comment_wx:add")
    @Log(title = "活动评论", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawActivityCommentWx bawActivityCommentWx)
    {
        return toAjax(bawActivityCommentWxService.insertBawActivityCommentWx(bawActivityCommentWx));
    }

    /**
     * 修改活动评论
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawActivityCommentWx bawActivityCommentWx = bawActivityCommentWxService.selectBawActivityCommentWxById(id);
        mmap.put("bawActivityCommentWx", bawActivityCommentWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存活动评论
     */
    @RequiresPermissions("wx:baw_activity_comment_wx:edit")
    @Log(title = "活动评论", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawActivityCommentWx bawActivityCommentWx)
    {
        return toAjax(bawActivityCommentWxService.updateBawActivityCommentWx(bawActivityCommentWx));
    }

    /**
     * 删除活动评论
     */
    @RequiresPermissions("wx:baw_activity_comment_wx:remove")
    @Log(title = "活动评论", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(Integer ids)
    {
        String s = bawActivityCommentWxService.updateReplay(ids);
//        return toAjax(bawActivityCommentWxService.deleteBawActivityCommentWxByIds(ids));
        return AjaxResult.success();
    }
}
