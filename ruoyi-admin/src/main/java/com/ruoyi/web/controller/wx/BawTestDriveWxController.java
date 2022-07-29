package com.ruoyi.web.controller.wx;

import java.util.List;

import com.ruoyi.web.domain.BawTestDriveCommentWx;
import com.ruoyi.web.domain.BawTestDriveWx;
import com.ruoyi.web.mapper.BawMessageCenterWxMapper;
import com.ruoyi.web.mapper.BawTestDriveWxMapper;
import com.ruoyi.web.service.BawTestDriveCommentWxService;
import com.ruoyi.web.service.IBawTestDriveWxService;
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
 * 预约试驾微信端Controller
 *
 * @author ruoyi
 * @date 2022-03-10
 */
@Controller
@RequestMapping("/wx/baw_test_drive_wx")
public class BawTestDriveWxController extends BaseController
{
    private String prefix = "wx/baw_test_drive_wx";

    @Autowired
    private IBawTestDriveWxService bawTestDriveWxService;
    @Autowired
    private BawTestDriveCommentWxService bawTestDriveCommentWxService;

    @RequiresPermissions("wx:baw_test_drive_wx:view")
    @GetMapping()
    public String baw_test_drive_wx()
    {
        return prefix + "/baw_test_drive_wx";
    }

    /**
     * 查询预约试驾微信端列表
     */
    @RequiresPermissions("wx:baw_test_drive_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawTestDriveWx bawTestDriveWx)
    {
        startPage();
        List<BawTestDriveWx> list = bawTestDriveWxService.selectBawTestDriveWxList(bawTestDriveWx);
        return getDataTable(list);
    }

    /**
     * 导出预约试驾微信端列表
     */
    @RequiresPermissions("wx:baw_test_drive_wx:export")
    @Log(title = "预约试驾微信端", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawTestDriveWx bawTestDriveWx)
    {
        List<BawTestDriveWx> list = bawTestDriveWxService.selectBawTestDriveWxList(bawTestDriveWx);
        ExcelUtil<BawTestDriveWx> util = new ExcelUtil<BawTestDriveWx>(BawTestDriveWx.class);
        return util.exportExcel(list, "预约试驾微信端数据");
    }

    /**
     * 新增预约试驾微信端
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存预约试驾微信端
     */
    @RequiresPermissions("wx:baw_test_drive_wx:add")
    @Log(title = "预约试驾微信端", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawTestDriveWx bawTestDriveWx)
    {
        bawTestDriveWx.setSourceCode("微信小程序");
        return toAjax(bawTestDriveWxService.insertBawTestDriveWx(bawTestDriveWx));
    }

    /**
     * 修改预约试驾微信端
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {

//        BawTestDriveWx bawTestDriveWx = bawTestDriveWxService.selectBawTestDriveWxById(id);
        BawTestDriveCommentWx bawTestDriveCommentWx = bawTestDriveCommentWxService.selectId(id);
        mmap.put("bawTestDriveCommentWx", bawTestDriveCommentWx);
        return prefix + "/comment_edit";
    }

    /**
     * 修改保存预约试驾微信端
     */
    @RequiresPermissions("wx:baw_test_drive_wx:edit")
    @Log(title = "预约试驾微信端", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawTestDriveWx bawTestDriveWx)
    {
        return toAjax(bawTestDriveWxService.updateBawTestDriveWx(bawTestDriveWx));
    }

    /**
     * 删除预约试驾微信端
     */
    @RequiresPermissions("wx:baw_test_drive_wx:remove")
    @Log(title = "预约试驾微信端", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawTestDriveWxService.deleteBawTestDriveWxByIds(ids));
    }
}
