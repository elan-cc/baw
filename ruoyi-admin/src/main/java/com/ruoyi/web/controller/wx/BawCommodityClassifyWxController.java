package com.ruoyi.web.controller.wx;

import java.util.List;

import com.ruoyi.web.domain.BawCommodityClassifyWx;
import com.ruoyi.web.service.IBawCommodityClassifyWxService;
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
 * 商品分类Controller
 *
 * @author ruoyi
 * @date 2022-05-11
 */
@Controller
@RequestMapping("/wx/baw_commodity_classify_wx")
public class BawCommodityClassifyWxController extends BaseController
{
    private String prefix = "wx/baw_commodity_classify_wx";

    @Autowired
    private IBawCommodityClassifyWxService bawCommodityClassifyWxService;

    @RequiresPermissions("wx:baw_commodity_classify_wx:view")
    @GetMapping()
    public String baw_commodity_classify_wx()
    {
        return prefix + "/baw_commodity_classify_wx";
    }

    /**
     * 查询商品分类列表
     */
    @RequiresPermissions("wx:baw_commodity_classify_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawCommodityClassifyWx bawCommodityClassifyWx)
    {
        startPage();
        bawCommodityClassifyWx.setParentId(0);
        List<BawCommodityClassifyWx> list = bawCommodityClassifyWxService.selectBawCommodityClassifyWxList(bawCommodityClassifyWx);
        TableDataInfo reData = getDataTable(list);
        return reData;
    }

    /**
     * 导出商品分类列表
     */
    @RequiresPermissions("wx:baw_commodity_classify_wx:export")
    @Log(title = "商品分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawCommodityClassifyWx bawCommodityClassifyWx)
    {
        List<BawCommodityClassifyWx> list = bawCommodityClassifyWxService.selectBawCommodityClassifyWxList(bawCommodityClassifyWx);
        ExcelUtil<BawCommodityClassifyWx> util = new ExcelUtil<BawCommodityClassifyWx>(BawCommodityClassifyWx.class);
        return util.exportExcel(list, "商品分类数据");
    }

    /**
     * 新增商品分类
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
    /**
     * 新增商品分类
     */
    @GetMapping("/add1/{parentid}")
    public String add1(@PathVariable("parentid") Integer parentid,ModelMap modelMap)
    {
        BawCommodityClassifyWx bawCommodityClassifyWx = new BawCommodityClassifyWx();
        bawCommodityClassifyWx.setParentId(parentid);
        modelMap.put("bawCommodityClassifyWx",bawCommodityClassifyWx);
        return prefix + "/add1";
    }

    /**
     * 新增保存商品分类
     */
    @RequiresPermissions("wx:baw_commodity_classify_wx:add")
    @Log(title = "商品分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawCommodityClassifyWx bawCommodityClassifyWx)
    {
        return toAjax(bawCommodityClassifyWxService.insertBawCommodityClassifyWx(bawCommodityClassifyWx));
    }

    /**
     * 修改商品分类
     */
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
//        BawCommodityClassifyWx bawCommodityClassifyWx = bawCommodityClassifyWxService.selectBawCommodityClassifyWxById(id);
//        mmap.put("bawCommodityClassifyWx", bawCommodityClassifyWx);
        BawCommodityClassifyWx bawCommodityClassifyWx = bawCommodityClassifyWxService.selectById(id);
        mmap.put("bawCommodityClassifyWx",bawCommodityClassifyWx);
        return prefix + "/baw_commodity_classify_wx_edit";
    }

    /**
     * 修改商品分类
     */
    @RequestMapping("/edit2/{id}")
    public String edit2(@PathVariable("id") Integer id, ModelMap mmap)
    {
//        BawCommodityClassifyWx bawCommodityClassifyWx = bawCommodityClassifyWxService.selectBawCommodityClassifyWxById(id);
//        mmap.put("bawCommodityClassifyWx", bawCommodityClassifyWx);
        BawCommodityClassifyWx bawCommodityClassifyWx = bawCommodityClassifyWxService.selectById(id);
        mmap.put("bawCommodityClassifyWx",bawCommodityClassifyWx);
        return prefix + "/edit";
    }


    /**
     * 修改商品分类
     */
    @RequestMapping("/edit1/{parentid}")
    @ResponseBody
    public TableDataInfo edit1(BawCommodityClassifyWx bawCommodityClassifyWx,@PathVariable("parentid") Integer parentid)
    {
        startPage();
        bawCommodityClassifyWx.setParentId(parentid);
        List<BawCommodityClassifyWx> list = bawCommodityClassifyWxService.selectBawCommodityClassifyWxList(bawCommodityClassifyWx);
        return getDataTable(list);
    }




    /**
     * 修改保存商品分类
     */
    @RequiresPermissions("wx:baw_commodity_classify_wx:edit")
    @Log(title = "商品分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawCommodityClassifyWx bawCommodityClassifyWx)
    {
        return toAjax(bawCommodityClassifyWxService.updateBawCommodityClassifyWx(bawCommodityClassifyWx));
    }

    /**
     * 删除商品分类
     */
    @RequiresPermissions("wx:baw_commodity_classify_wx:remove")
    @Log(title = "商品分类", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawCommodityClassifyWxService.deleteBawCommodityClassifyWxByIds(ids));
    }
}
