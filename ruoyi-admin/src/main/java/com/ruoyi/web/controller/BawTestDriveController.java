package com.ruoyi.web.controller;

import java.util.List;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.ShiroUtils;
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
import com.ruoyi.web.domain.BawTestDrive;
import com.ruoyi.web.service.IBawTestDriveService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 预约试驾Controller
 * 
 * @author ruoyi
 * @date 2021-12-10
 */
@Controller
@RequestMapping("/data/baw_test_drive")
public class BawTestDriveController extends BaseController
{
    private String prefix = "data/baw_test_drive";

    @Autowired
    private IBawTestDriveService bawTestDriveService;

    @RequiresPermissions("data:baw_test_drive:view")
    @GetMapping()
    public String baw_test_drive()
    {
        return prefix + "/baw_test_drive";
    }

    /**
     * 查询预约试驾列表
     */
    @RequiresPermissions("data:baw_test_drive:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawTestDrive bawTestDrive)
    {
        bawTestDrive.setIsDelete(0);
        startPage();
        List<BawTestDrive> list = bawTestDriveService.selectBawTestDriveList(bawTestDrive);
        return getDataTable(list);
    }

    /**
     * 导出预约试驾列表
     */
    @RequiresPermissions("data:baw_test_drive:export")
    @Log(title = "预约试驾", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawTestDrive bawTestDrive)
    {
        bawTestDrive.setIsDelete(0);
        List<BawTestDrive> list = bawTestDriveService.selectBawTestDriveList(bawTestDrive);
        for(int i=0;i<list.size();i++){
            BawTestDrive item = list.get(i);
            item.setAddDateFormat(MyDateUtils.timestampToString(Convert.toInt(item.getAddDate()),"yyyy-MM-dd HH:mm:ss"));
            list.set(i,item);
        }
        ExcelUtil<BawTestDrive> util = new ExcelUtil<BawTestDrive>(BawTestDrive.class);
        return util.exportExcel(list, "预约试驾数据");
    }

    /**
     * 新增预约试驾
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存预约试驾
     */
    @RequiresPermissions("data:baw_test_drive:add")
    @Log(title = "预约试驾", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawTestDrive bawTestDrive)
    {
        bawTestDrive.setIsDelete(0);
        bawTestDrive.setAddDate(Integer.parseInt(MyDateUtils.getTimeStamp10()));
        return toAjax(bawTestDriveService.insertBawTestDrive(bawTestDrive));
    }

    /**
     * 修改预约试驾
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawTestDrive bawTestDrive = bawTestDriveService.selectBawTestDriveById(id);
        mmap.put("bawTestDrive", bawTestDrive);
        return prefix + "/edit";
    }

    /**
     * 修改保存预约试驾
     */
    @RequiresPermissions("data:baw_test_drive:edit")
    @Log(title = "预约试驾", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawTestDrive bawTestDrive)
    {
        return toAjax(bawTestDriveService.updateBawTestDrive(bawTestDrive));
    }

    /**
     * 删除预约试驾
     */
    @RequiresPermissions("data:baw_test_drive:remove")
    @Log(title = "预约试驾", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawTestDriveService.deleteBawTestDriveByIds(ids));
    }
}
