package com.ruoyi.web.controller.wx;

import java.util.List;

import com.ruoyi.web.domain.BawProductDetailWx;
import com.ruoyi.web.domain.BawProductManual;
import com.ruoyi.web.domain.BawTechnicalSupportCommentWx;
import com.ruoyi.web.service.IBawProductDetailWxService;
import com.ruoyi.web.service.IBawProductManualService;
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
 * 产品手册Controller
 *
 * @author ruoyi
 * @date 2022-05-10
 */
@Controller
@RequestMapping("/wx/baw_product_manual")
public class BawProductManualController extends BaseController
{
    private String prefix = "wx/baw_product_manual";

    @Autowired
    private IBawProductManualService bawProductManualService;
    @Autowired
    private IBawProductDetailWxService bawProductDetailWxService;

    @RequiresPermissions("wx:baw_product_manual:view")
    @GetMapping()
    public String baw_product_manual()
    {
        return prefix + "/baw_product_manual";
    }

    /**
     * 查询产品手册列表
     */
    @RequiresPermissions("wx:baw_product_manual:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawProductManual bawProductManual)
    {
        startPage();
        List<BawProductManual> list = bawProductManualService.selectBawProductManualList(bawProductManual);
        return getDataTable(list);
    }

    /**
     * 导出产品手册列表
     */
    @RequiresPermissions("wx:baw_product_manual:export")
    @Log(title = "产品手册", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawProductManual bawProductManual)
    {
        List<BawProductManual> list = bawProductManualService.selectBawProductManualList(bawProductManual);
        ExcelUtil<BawProductManual> util = new ExcelUtil<BawProductManual>(BawProductManual.class);
        return util.exportExcel(list, "产品手册数据");
    }

    /**
     * 新增产品手册
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产品手册
     */
    @RequiresPermissions("wx:baw_product_manual:add")
    @Log(title = "产品手册", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawProductManual bawProductManual)
    {
        return toAjax(bawProductManualService.insertBawProductManual(bawProductManual));
    }

    /**
     * 修改产品手册
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawProductManual bawProductManual = bawProductManualService.selectBawProductManualById(id);
        mmap.put("bawProductManual", bawProductManual);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品手册
     */
    @RequiresPermissions("wx:baw_product_manual:edit")
    @Log(title = "产品手册", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawProductManual bawProductManual)
    {
        return toAjax(bawProductManualService.updateBawProductManual(bawProductManual));
    }

    /**
     * 删除产品手册
     */
    @RequiresPermissions("wx:baw_product_manual:remove")
    @Log(title = "产品手册", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawProductManualService.deleteBawProductManualByIds(ids));
    }


    /**
     * 查询产品手册详情
     */
    @GetMapping("/commentList/{id}")
    public String commentList(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawProductDetailWx bawProductDetailWx =new BawProductDetailWx();
        bawProductDetailWx.setManualId(id);
        mmap.put("bawProductDetailWx",bawProductDetailWx);
        return "wx/baw_product_detail_wx/baw_product_detail_wx1";
    }
}
