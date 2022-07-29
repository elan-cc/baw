package com.ruoyi.web.controller;

import java.util.List;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.web.domain.BawTestDrive;
import com.ruoyi.web.utils.MyDateUtils;
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
import com.ruoyi.web.domain.BawBigCustomerBusiness;
import com.ruoyi.web.service.IBawBigCustomerBusinessService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 大客户业务Controller
 * 
 * @author ruoyi
 * @date 2021-12-10
 */
@Controller
@RequestMapping("/data/baw_big_customer_business")
public class BawBigCustomerBusinessController extends BaseController
{
    private String prefix = "data/baw_big_customer_business";

    @Autowired
    private IBawBigCustomerBusinessService bawBigCustomerBusinessService;

    @RequiresPermissions("data:baw_big_customer_business:view")
    @GetMapping()
    public String baw_big_customer_business()
    {
        return prefix + "/baw_big_customer_business";
    }

    /**
     * 查询大客户业务列表
     */
    @RequiresPermissions("data:baw_big_customer_business:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawBigCustomerBusiness bawBigCustomerBusiness)
    {
        bawBigCustomerBusiness.setIsDelete(0);
        startPage();
        List<BawBigCustomerBusiness> list = bawBigCustomerBusinessService.selectBawBigCustomerBusinessList(bawBigCustomerBusiness);
        return getDataTable(list);
    }

    /**
     * 导出大客户业务列表
     */
    @RequiresPermissions("data:baw_big_customer_business:export")
    @Log(title = "大客户业务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawBigCustomerBusiness bawBigCustomerBusiness)
    {
        bawBigCustomerBusiness.setIsDelete(0);
        List<BawBigCustomerBusiness> list = bawBigCustomerBusinessService.selectBawBigCustomerBusinessList(bawBigCustomerBusiness);
        for(int i=0;i<list.size();i++){
            BawBigCustomerBusiness item = list.get(i);
            item.setAddDateFormat(MyDateUtils.timestampToString(Convert.toInt(item.getAddDate()),"yyyy-MM-dd HH:mm:ss"));
            list.set(i,item);
        }
        ExcelUtil<BawBigCustomerBusiness> util = new ExcelUtil<BawBigCustomerBusiness>(BawBigCustomerBusiness.class);
        return util.exportExcel(list, "大客户业务数据");
    }

    /**
     * 新增大客户业务
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存大客户业务
     */
    @RequiresPermissions("data:baw_big_customer_business:add")
    @Log(title = "大客户业务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawBigCustomerBusiness bawBigCustomerBusiness)
    {
        bawBigCustomerBusiness.setIsDelete(0);
        bawBigCustomerBusiness.setAddDate(Integer.parseInt(MyDateUtils.getTimeStamp10()));
        return toAjax(bawBigCustomerBusinessService.insertBawBigCustomerBusiness(bawBigCustomerBusiness));
    }

    /**
     * 修改大客户业务
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawBigCustomerBusiness bawBigCustomerBusiness = bawBigCustomerBusinessService.selectBawBigCustomerBusinessById(id);
        mmap.put("bawBigCustomerBusiness", bawBigCustomerBusiness);
        return prefix + "/edit";
    }

    /**
     * 修改保存大客户业务
     */
    @RequiresPermissions("data:baw_big_customer_business:edit")
    @Log(title = "大客户业务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawBigCustomerBusiness bawBigCustomerBusiness)
    {
        return toAjax(bawBigCustomerBusinessService.updateBawBigCustomerBusiness(bawBigCustomerBusiness));
    }

    /**
     * 删除大客户业务
     */
    @RequiresPermissions("data:baw_big_customer_business:remove")
    @Log(title = "大客户业务", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawBigCustomerBusinessService.deleteBawBigCustomerBusinessByIds(ids));
    }
}
