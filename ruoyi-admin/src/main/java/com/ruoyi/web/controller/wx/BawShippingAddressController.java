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
import com.ruoyi.web.domain.BawShippingAddress;
import com.ruoyi.web.service.IBawShippingAddressService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收货地址Controller
 *
 * @author ruoyi
 * @date 2022-04-18
 */
@Controller
@RequestMapping("/wx/baw_shipping_address")
public class BawShippingAddressController extends BaseController
{
    private String prefix = "wx/baw_shipping_address";

    @Autowired
    private IBawShippingAddressService bawShippingAddressService;

    @RequiresPermissions("wx:baw_shipping_address:view")
    @GetMapping()
    public String baw_shipping_address()
    {
        return prefix + "/baw_shipping_address";
    }

    /**
     * 查询收货地址列表
     */
    @RequiresPermissions("wx:baw_shipping_address:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawShippingAddress bawShippingAddress)
    {
        startPage();
        List<BawShippingAddress> list = bawShippingAddressService.selectBawShippingAddressList(bawShippingAddress);
        return getDataTable(list);
    }

    /**
     * 导出收货地址列表
     */
    @RequiresPermissions("wx:baw_shipping_address:export")
    @Log(title = "收货地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawShippingAddress bawShippingAddress)
    {
        List<BawShippingAddress> list = bawShippingAddressService.selectBawShippingAddressList(bawShippingAddress);
        ExcelUtil<BawShippingAddress> util = new ExcelUtil<BawShippingAddress>(BawShippingAddress.class);
        return util.exportExcel(list, "收货地址数据");
    }

    /**
     * 新增收货地址
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存收货地址
     */
    @RequiresPermissions("wx:baw_shipping_address:add")
    @Log(title = "收货地址", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawShippingAddress bawShippingAddress)
    {
        return toAjax(bawShippingAddressService.insertBawShippingAddress(bawShippingAddress));
    }

    /**
     * 修改收货地址
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawShippingAddress bawShippingAddress = bawShippingAddressService.selectBawShippingAddressById(id);
        mmap.put("bawShippingAddress", bawShippingAddress);
        return prefix + "/edit";
    }

    /**
     * 修改保存收货地址
     */
    @RequiresPermissions("wx:baw_shipping_address:edit")
    @Log(title = "收货地址", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawShippingAddress bawShippingAddress)
    {
        return toAjax(bawShippingAddressService.updateBawShippingAddress(bawShippingAddress));
    }

    /**
     * 删除收货地址
     */
    @RequiresPermissions("wx:baw_shipping_address:remove")
    @Log(title = "收货地址", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawShippingAddressService.deleteBawShippingAddressByIds(ids));
    }
}
