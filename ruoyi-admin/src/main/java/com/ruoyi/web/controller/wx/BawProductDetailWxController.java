package com.ruoyi.web.controller.wx;

import java.util.List;

import com.ruoyi.web.domain.BawBaseCarConfigParam;
import com.ruoyi.web.domain.BawProductDetailWx;
import com.ruoyi.web.service.IBawProductDetailWxService;
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
 * 产品手册详情Controller
 *
 * @author ruoyi
 * @date 2022-05-27
 */
@Controller
@RequestMapping("/wx/baw_product_detail_wx")
public class BawProductDetailWxController extends BaseController
{
    private String prefix = "wx/baw_product_detail_wx";

    @Autowired
    private IBawProductDetailWxService bawProductDetailWxService;

    @RequiresPermissions("wx:baw_product_detail_wx:view")
    @GetMapping()
    public String baw_product_detail_wx()
    {
        return prefix + "/baw_product_detail_wx";
    }

    /**
     * 查询产品手册详情列表
     */
    @RequiresPermissions("wx:baw_product_detail_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawProductDetailWx bawProductDetailWx)
    {
        startPage();
        List<BawProductDetailWx> list = bawProductDetailWxService.selectBawProductDetailWxList(bawProductDetailWx);
        return getDataTable(list);
    }

    /**
     * 导出产品手册详情列表
     */
    @RequiresPermissions("wx:baw_product_detail_wx:export")
    @Log(title = "产品手册详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawProductDetailWx bawProductDetailWx)
    {
        List<BawProductDetailWx> list = bawProductDetailWxService.selectBawProductDetailWxList(bawProductDetailWx);
        ExcelUtil<BawProductDetailWx> util = new ExcelUtil<BawProductDetailWx>(BawProductDetailWx.class);
        return util.exportExcel(list, "产品手册详情数据");
    }

    /**
     * 新增产品手册详情
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增产品手册详情
     */
    @GetMapping("/add1/{manualId}")
    public String add1(@PathVariable("manualId") Integer manualId,ModelMap modelMap)
    {
        BawProductDetailWx bawProductDetailWx = new BawProductDetailWx();
        bawProductDetailWx.setManualId(manualId);
        modelMap.put("bawProductDetailWx",bawProductDetailWx);
        return prefix + "/add1";
    }

    /**
     * 新增保存产品手册详情
     */
    @RequiresPermissions("wx:baw_product_manual:add1")
    @Log(title = "产品手册详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawProductDetailWx bawProductDetailWx)
    {
        String logName = getLoginName();
        bawProductDetailWx.setCreateBy(logName);
        return toAjax(bawProductDetailWxService.insertBawProductDetailWx(bawProductDetailWx));
    }


    /**
     * 修改产品手册详情
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawProductDetailWx bawProductDetailWx = bawProductDetailWxService.selectBawProductDetailWxById(id);
        mmap.put("bawProductDetailWx", bawProductDetailWx);
        return prefix + "/edit";
    }


    /**
     * 修改保存产品手册详情
     */
    @RequiresPermissions("wx:baw_product_detail_wx:edit")
    @Log(title = "产品手册详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawProductDetailWx bawProductDetailWx)
    {
        String logName = getLoginName();
        bawProductDetailWx.setUpdateBy(logName);
        return toAjax(bawProductDetailWxService.updateBawProductDetailWx(bawProductDetailWx));
    }

    /**
     * 删除产品手册详情
     */
    @RequiresPermissions("wx:baw_product_detail_wx:remove")
    @Log(title = "产品手册详情", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawProductDetailWxService.deleteBawProductDetailWxByIds(ids));
    }




    /**
     * 修改车型配置参数
     */
    @RequestMapping("/detailList/{manualId}")
    @ResponseBody
    public TableDataInfo detailList(BawProductDetailWx bawProductDetailWx, @PathVariable("manualId") Integer manualId)
    {
        startPage();
        bawProductDetailWx.setManualId(manualId);
        List<BawProductDetailWx> list = bawProductDetailWxService.selectBawProductDetailWxList(bawProductDetailWx);
        return getDataTable(list);
    }
}
