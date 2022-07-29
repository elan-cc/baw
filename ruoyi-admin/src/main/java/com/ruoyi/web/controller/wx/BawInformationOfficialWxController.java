package com.ruoyi.web.controller;

import java.util.List;

import com.ruoyi.web.domain.BawInformationOfficialCommentWx;
import com.ruoyi.web.service.IBawInformationOfficialCommentWxService;
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
import com.ruoyi.web.domain.BawInformationOfficialWx;
import com.ruoyi.web.service.IBawInformationOfficialWxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 官方资讯/精彩推荐Controller
 *
 * @author ruoyi
 * @date 2022-04-19
 */
@Controller
@RequestMapping("/wx/baw_information_wx")
public class BawInformationOfficialWxController extends BaseController
{
    private String prefix = "wx/baw_information_wx";

    @Autowired
    private IBawInformationOfficialWxService bawInformationOfficialWxService;

    @RequiresPermissions("wx:baw_information_wx:view")
    @GetMapping()
    public String baw_information_wx()
    {
        return prefix + "/baw_information_wx";
    }

    /**
     * 查询官方资讯/精彩推荐列表
     */
    @RequiresPermissions("wx:baw_information_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawInformationOfficialWx bawInformationOfficialWx)
    {
        startPage();
        List<BawInformationOfficialWx> list = bawInformationOfficialWxService.selectBawInformationOfficialWxList(bawInformationOfficialWx);
        return getDataTable(list);
    }

    /**
     * 导出官方资讯/精彩推荐列表
     */
    @RequiresPermissions("wx:baw_information_wx:export")
    @Log(title = "官方资讯/精彩推荐", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawInformationOfficialWx bawInformationOfficialWx)
    {
        List<BawInformationOfficialWx> list = bawInformationOfficialWxService.selectBawInformationOfficialWxList(bawInformationOfficialWx);
        ExcelUtil<BawInformationOfficialWx> util = new ExcelUtil<BawInformationOfficialWx>(BawInformationOfficialWx.class);
        return util.exportExcel(list, "官方资讯/精彩推荐数据");
    }

    /**
     * 新增官方资讯/精彩推荐
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存官方资讯/精彩推荐
     */
    @RequiresPermissions("wx:baw_information_wx:add")
    @Log(title = "官方资讯/精彩推荐", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawInformationOfficialWx bawInformationOfficialWx)
    {
        bawInformationOfficialWx.setCreateBy(getLoginName());
        int count = bawInformationOfficialWxService.insertBawInformationOfficialWx(bawInformationOfficialWx);
        switch (count) {
            case 1:
                return toAjax(count);
            case 2:
                return AjaxResult.error("超出焦点数量上限");
            default:
                return toAjax(0);
        }
    }

    /**
     * 修改官方资讯/精彩推荐
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawInformationOfficialWx bawInformationOfficialWx = bawInformationOfficialWxService.selectBawInformationOfficialWxById(id);
        mmap.put("bawInformationOfficialWx", bawInformationOfficialWx);
        return prefix + "/edit";
    }


    /**
     * 查询官方资讯/精彩推荐评论
     */
    @GetMapping("/commentList/{id}")
    public String commentList(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawInformationOfficialCommentWx bawInformationOfficialCommentWx =new BawInformationOfficialCommentWx();
        bawInformationOfficialCommentWx.setInformationId(id);
        mmap.put("bawInformationOfficialCommentWx",bawInformationOfficialCommentWx);
        return "wx/baw_information_comment_wx/baw_information_comment_wx";
    }


    /**
     * 修改保存官方资讯/精彩推荐
     */
    @RequiresPermissions("wx:baw_information_wx:edit")
    @Log(title = "官方资讯/精彩推荐", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawInformationOfficialWx bawInformationOfficialWx)
    {
        bawInformationOfficialWx.setUpdateBy(getLoginName());
        int count = bawInformationOfficialWxService.updateBawInformationOfficialWx(bawInformationOfficialWx);
        switch (count) {
            case 1:
                return toAjax(count);
            case 2:
                return AjaxResult.error("超出焦点数量上限");
            default:
                return toAjax(0);
        }
    }

    /**
     * 删除官方资讯/精彩推荐
     */
    @RequiresPermissions("wx:baw_information_wx:remove")
    @Log(title = "官方资讯/精彩推荐", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(Integer ids)
    {
        return toAjax(bawInformationOfficialWxService.deleteBawInformationOfficialWxById(ids));
    }
}
