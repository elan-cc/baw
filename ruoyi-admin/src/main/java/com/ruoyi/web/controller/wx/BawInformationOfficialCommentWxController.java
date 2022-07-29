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
import com.ruoyi.web.domain.BawInformationOfficialCommentWx;
import com.ruoyi.web.service.IBawInformationOfficialCommentWxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 *官方资讯/精彩推荐评论Controller
 *
 * @author ruoyi
 * @date 2022-04-19
 */
@Controller
@RequestMapping("/wx/baw_information_comment_wx")
public class BawInformationOfficialCommentWxController extends BaseController
{
    private String prefix = "wx/baw_information_comment_wx";

    @Autowired
    private IBawInformationOfficialCommentWxService bawInformationOfficialCommentWxService;

    @RequiresPermissions("wx:baw_information_comment_wx:view")
    @GetMapping()
    public String baw_information_comment_wx()
    {
        return prefix + "/baw_information_comment_wx";
    }

    /**
     * 查询官方资讯/精彩推荐评论列表
     */
    @RequiresPermissions("wx:baw_information_comment_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawInformationOfficialCommentWx bawInformationOfficialCommentWx)
    {
        startPage();
        List<BawInformationOfficialCommentWx> list = bawInformationOfficialCommentWxService.selectBawInformationOfficialCommentWxList(bawInformationOfficialCommentWx);
        return getDataTable(list);
    }

    /**
     * 导出官方资讯/精彩推荐评论列表
     */
    @RequiresPermissions("wx:baw_information_comment_wx:export")
    @Log(title = "官方资讯/精彩推荐评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawInformationOfficialCommentWx bawInformationOfficialCommentWx)
    {
        List<BawInformationOfficialCommentWx> list = bawInformationOfficialCommentWxService.selectBawInformationOfficialCommentWxList(bawInformationOfficialCommentWx);
        ExcelUtil<BawInformationOfficialCommentWx> util = new ExcelUtil<BawInformationOfficialCommentWx>(BawInformationOfficialCommentWx.class);
        return util.exportExcel(list, "官方资讯/精彩推荐评论数据");
    }

    /**
     * 新增官方资讯/精彩推荐评论
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存官方资讯/精彩推荐评论
     */
    @RequiresPermissions("wx:baw_information_comment_wx:add")
    @Log(title = "官方资讯/精彩推荐评论", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawInformationOfficialCommentWx bawInformationOfficialCommentWx)
    {
        return toAjax(bawInformationOfficialCommentWxService.insertBawInformationOfficialCommentWx(bawInformationOfficialCommentWx));
    }

    /**
     * 修改官方资讯/精彩推荐评论
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawInformationOfficialCommentWx bawInformationOfficialCommentWx = bawInformationOfficialCommentWxService.selectBawInformationOfficialCommentWxById(id);
        mmap.put("bawInformationOfficialCommentWx", bawInformationOfficialCommentWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存官方资讯/精彩推荐评论
     */
    @RequiresPermissions("wx:baw_information_comment_wx:edit")
    @Log(title = "官方资讯/精彩推荐评论", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawInformationOfficialCommentWx bawInformationOfficialCommentWx)
    {
        return toAjax(bawInformationOfficialCommentWxService.updateBawInformationOfficialCommentWx(bawInformationOfficialCommentWx));
    }

    /**
     * 删除官方资讯/精彩推荐评论
     */
    @RequiresPermissions("wx:baw_information_comment_wx:remove")
    @Log(title = "官方资讯/精彩推荐评论", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawInformationOfficialCommentWxService.deleteBawInformationOfficialCommentWxByIds(ids));
    }
}
