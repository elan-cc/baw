package com.ruoyi.web.controller.wx;

import java.util.List;

import com.ruoyi.web.domain.BawProductManualLike;
import com.ruoyi.web.service.IBawProductManualLikeService;
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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品手册点赞Controller
 *
 * @author ruoyi
 * @date 2022-05-11
 */
@Controller
@RequestMapping("/wx/baw_product_manual_like")
public class BawProductManualLikeController extends BaseController
{
    private String prefix = "wx/baw_product_manual_like";

    @Autowired
    private IBawProductManualLikeService bawProductManualLikeService;

    @RequiresPermissions("wx:baw_product_manual_like:view")
    @GetMapping()
    public String baw_product_manual_like()
    {
        return prefix + "/baw_product_manual_like";
    }

    /**
     * 查询产品手册点赞列表
     */
    @RequiresPermissions("wx:baw_product_manual_like:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawProductManualLike bawProductManualLike)
    {
        startPage();
        List<BawProductManualLike> list = bawProductManualLikeService.selectBawProductManualLikeList(bawProductManualLike);
        return getDataTable(list);
    }

    /**
     * 导出产品手册点赞列表
     */
    @RequiresPermissions("wx:baw_product_manual_like:export")
    @Log(title = "产品手册点赞", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawProductManualLike bawProductManualLike)
    {
        List<BawProductManualLike> list = bawProductManualLikeService.selectBawProductManualLikeList(bawProductManualLike);
        ExcelUtil<BawProductManualLike> util = new ExcelUtil<BawProductManualLike>(BawProductManualLike.class);
        return util.exportExcel(list, "产品手册点赞数据");
    }

    /**
     * 新增产品手册点赞
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产品手册点赞
     */
    @RequiresPermissions("wx:baw_product_manual_like:add")
    @Log(title = "产品手册点赞", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawProductManualLike bawProductManualLike)
    {
        return toAjax(bawProductManualLikeService.insertBawProductManualLike(bawProductManualLike));
    }

    /**
     * 修改产品手册点赞
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawProductManualLike bawProductManualLike = bawProductManualLikeService.selectBawProductManualLikeById(id);
        mmap.put("bawProductManualLike", bawProductManualLike);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品手册点赞
     */
    @RequiresPermissions("wx:baw_product_manual_like:edit")
    @Log(title = "产品手册点赞", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawProductManualLike bawProductManualLike)
    {
        return toAjax(bawProductManualLikeService.updateBawProductManualLike(bawProductManualLike));
    }

    /**
     * 删除产品手册点赞
     */
    @RequiresPermissions("wx:baw_product_manual_like:remove")
    @Log(title = "产品手册点赞", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawProductManualLikeService.deleteBawProductManualLikeByIds(ids));
    }
}
