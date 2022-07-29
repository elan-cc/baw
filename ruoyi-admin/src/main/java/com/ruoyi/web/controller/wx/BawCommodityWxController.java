package com.ruoyi.web.controller.wx;

import java.util.List;

import com.ruoyi.web.domain.BawCommodityWx;
import com.ruoyi.web.service.IBawCommodityWxService;
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
 * 商品Controller
 *
 * @author ruoyi
 * @date 2022-05-19
 */
@Controller
@RequestMapping("/wx/baw_commodity_wx")
public class BawCommodityWxController extends BaseController
{
    private String prefix = "wx/baw_commodity_wx";

    @Autowired
    private IBawCommodityWxService bawCommodityWxService;

    @RequiresPermissions("wx:baw_commodity_wx:view")
    @GetMapping()
    public String baw_commodity_wx()
    {
        return prefix + "/baw_commodity_wx";
    }

    /**
     * 查询商品列表
     */
    @RequiresPermissions("wx:baw_commodity_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawCommodityWx bawCommodityWx)
    {
        startPage();
        List<BawCommodityWx> list = bawCommodityWxService.selectBawCommodityWxList(bawCommodityWx);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @RequiresPermissions("wx:baw_commodity_wx:export")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawCommodityWx bawCommodityWx)
    {
        List<BawCommodityWx> list = bawCommodityWxService.selectBawCommodityWxList(bawCommodityWx);
        ExcelUtil<BawCommodityWx> util = new ExcelUtil<BawCommodityWx>(BawCommodityWx.class);
        return util.exportExcel(list, "商品数据");
    }

    /**
     * 新增商品
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品
     */
    @RequiresPermissions("wx:baw_commodity_wx:add")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawCommodityWx bawCommodityWx)
    {
        return toAjax(bawCommodityWxService.insertBawCommodityWx(bawCommodityWx));
    }

    /**
     * 修改商品
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawCommodityWx bawCommodityWx = bawCommodityWxService.selectBawCommodityWxById(id);
        mmap.put("bawCommodityWx", bawCommodityWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品
     */
    @RequiresPermissions("wx:baw_commodity_wx:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawCommodityWx bawCommodityWx)
    {
        return toAjax(bawCommodityWxService.updateBawCommodityWx(bawCommodityWx));
    }

    /**
     * 删除商品
     */
    @RequiresPermissions("wx:baw_commodity_wx:remove")
    @Log(title = "商品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawCommodityWxService.deleteBawCommodityWxByIds(ids));
    }
}
