package com.ruoyi.web.controller.wx;

import java.util.List;

import com.ruoyi.web.domain.BawMessageCenterWx;
import com.ruoyi.web.service.IBawMessageCenterWxService;
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
 * 消息中心Controller
 *
 * @author ruoyi
 * @date 2022-06-10
 */
@Controller
@RequestMapping("/wx/baw_message_center_wx")
public class BawMessageCenterWxController extends BaseController
{
    private String prefix = "wx/baw_message_center_wx";

    @Autowired
    private IBawMessageCenterWxService bawMessageCenterWxService;

    @RequiresPermissions("wx:baw_message_center_wx:view")
    @GetMapping()
    public String baw_message_center_wx()
    {
        return prefix + "/baw_message_center_wx";
    }

    /**
     * 查询消息中心列表
     */
    @RequiresPermissions("wx:baw_message_center_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawMessageCenterWx bawMessageCenterWx)
    {
        startPage();
        List<BawMessageCenterWx> list = bawMessageCenterWxService.selectBawMessageCenterWxList(bawMessageCenterWx);
        return getDataTable(list);
    }

    /**
     * 导出消息中心列表
     */
    @RequiresPermissions("wx:baw_message_center_wx:export")
    @Log(title = "消息中心", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawMessageCenterWx bawMessageCenterWx)
    {
        List<BawMessageCenterWx> list = bawMessageCenterWxService.selectBawMessageCenterWxList(bawMessageCenterWx);
        ExcelUtil<BawMessageCenterWx> util = new ExcelUtil<BawMessageCenterWx>(BawMessageCenterWx.class);
        return util.exportExcel(list, "消息中心数据");
    }

    /**
     * 新增消息中心
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存消息中心
     */
    @RequiresPermissions("wx:baw_message_center_wx:add")
    @Log(title = "消息中心", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawMessageCenterWx bawMessageCenterWx)
    {
        return toAjax(bawMessageCenterWxService.insertBawMessageCenterWx(bawMessageCenterWx));
    }

    /**
     * 修改消息中心
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawMessageCenterWx bawMessageCenterWx = bawMessageCenterWxService.selectBawMessageCenterWxById(id);
        mmap.put("bawMessageCenterWx", bawMessageCenterWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存消息中心
     */
    @RequiresPermissions("wx:baw_message_center_wx:edit")
    @Log(title = "消息中心", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawMessageCenterWx bawMessageCenterWx)
    {
        return toAjax(bawMessageCenterWxService.updateBawMessageCenterWx(bawMessageCenterWx));
    }

    /**
     * 删除消息中心
     */
    @RequiresPermissions("wx:baw_message_center_wx:remove")
    @Log(title = "消息中心", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawMessageCenterWxService.deleteBawMessageCenterWxByIds(ids));
    }
}
