package com.ruoyi.web.controller.wx;

import java.util.List;

import com.ruoyi.web.domain.BawOwnerCertificationWx;
import com.ruoyi.web.service.IBawOwnerCertificationWxService;
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
 * 车主认证Controller
 *
 * @author ruoyi
 * @date 2022-06-13
 */
@Controller
@RequestMapping("/wx/baw_owner_certification_wx")
public class BawOwnerCertificationWxController extends BaseController
{
    private String prefix = "wx/baw_owner_certification_wx";

    @Autowired
    private IBawOwnerCertificationWxService bawOwnerCertificationWxService;

    @RequiresPermissions("wx:baw_owner_certification_wx:view")
    @GetMapping()
    public String baw_owner_certification_wx()
    {
        return prefix + "/baw_owner_certification_wx";
    }

    /**
     * 查询车主认证列表
     */
    @RequiresPermissions("wx:baw_owner_certification_wx:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawOwnerCertificationWx bawOwnerCertificationWx)
    {
        startPage();
        List<BawOwnerCertificationWx> list = bawOwnerCertificationWxService.selectBawOwnerCertificationWxList(bawOwnerCertificationWx);
        return getDataTable(list);
    }

    /**
     * 导出车主认证列表
     */
    @RequiresPermissions("wx:baw_owner_certification_wx:export")
    @Log(title = "车主认证", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawOwnerCertificationWx bawOwnerCertificationWx)
    {
        List<BawOwnerCertificationWx> list = bawOwnerCertificationWxService.selectBawOwnerCertificationWxList(bawOwnerCertificationWx);
        ExcelUtil<BawOwnerCertificationWx> util = new ExcelUtil<BawOwnerCertificationWx>(BawOwnerCertificationWx.class);
        return util.exportExcel(list, "车主认证数据");
    }

    /**
     * 新增车主认证
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存车主认证
     */
    @RequiresPermissions("wx:baw_owner_certification_wx:add")
    @Log(title = "车主认证", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawOwnerCertificationWx bawOwnerCertificationWx)
    {
        return toAjax(bawOwnerCertificationWxService.insertBawOwnerCertificationWx(bawOwnerCertificationWx));
    }

    /**
     * 修改车主认证
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawOwnerCertificationWx bawOwnerCertificationWx = bawOwnerCertificationWxService.selectBawOwnerCertificationWxById(id);
        mmap.put("bawOwnerCertificationWx", bawOwnerCertificationWx);
        return prefix + "/edit";
    }

    /**
     * 修改保存车主认证
     */
    @RequiresPermissions("wx:baw_owner_certification_wx:edit")
    @Log(title = "车主认证", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawOwnerCertificationWx bawOwnerCertificationWx)
    {
        return toAjax(bawOwnerCertificationWxService.updateBawOwnerCertificationWx(bawOwnerCertificationWx));
    }

    /**
     * 删除车主认证
     */
    @RequiresPermissions("wx:baw_owner_certification_wx:remove")
    @Log(title = "车主认证", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawOwnerCertificationWxService.deleteBawOwnerCertificationWxByIds(ids));
    }
}
