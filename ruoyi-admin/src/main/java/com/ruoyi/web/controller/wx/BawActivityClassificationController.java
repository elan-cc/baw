package com.ruoyi.web.controller.wx;

import java.util.List;

import com.ruoyi.web.domain.BawActivityClassification;
import com.ruoyi.web.service.IBawActivityClassificationService;
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
 * 活动分类Controller
 *
 * @author ruoyi
 * @date 2022-05-25
 */
@Controller
@RequestMapping("/wx/baw_activity_classification")
public class BawActivityClassificationController extends BaseController
{
    private String prefix = "wx/baw_activity_classification";

    @Autowired
    private IBawActivityClassificationService bawActivityClassificationService;

    @RequiresPermissions("wx:baw_activity_classification:view")
    @GetMapping()
    public String baw_activity_classification()
    {
        return prefix + "/baw_activity_classification";
    }

    /**
     * 查询活动分类列表
     */
    @RequiresPermissions("wx:baw_activity_classification:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawActivityClassification bawActivityClassification)
    {
        startPage();
        List<BawActivityClassification> list = bawActivityClassificationService.selectBawActivityClassificationList(bawActivityClassification);
        return getDataTable(list);
    }

    /**
     * 导出活动分类列表
     */
    @RequiresPermissions("wx:baw_activity_classification:export")
    @Log(title = "活动分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawActivityClassification bawActivityClassification)
    {
        List<BawActivityClassification> list = bawActivityClassificationService.selectBawActivityClassificationList(bawActivityClassification);
        ExcelUtil<BawActivityClassification> util = new ExcelUtil<BawActivityClassification>(BawActivityClassification.class);
        return util.exportExcel(list, "活动分类数据");
    }

    /**
     * 新增活动分类
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存活动分类
     */
    @RequiresPermissions("wx:baw_activity_classification:add")
    @Log(title = "活动分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawActivityClassification bawActivityClassification)
    {
        String loginName = getLoginName();
        bawActivityClassification.setCreateBy(loginName);
        return toAjax(bawActivityClassificationService.insertBawActivityClassification(bawActivityClassification));
    }

    /**
     * 修改活动分类
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawActivityClassification bawActivityClassification = bawActivityClassificationService.selectBawActivityClassificationById(id);
        mmap.put("bawActivityClassification", bawActivityClassification);
        return prefix + "/edit";
    }

    /**
     * 修改保存活动分类
     */
    @RequiresPermissions("wx:baw_activity_classification:edit")
    @Log(title = "活动分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawActivityClassification bawActivityClassification)
    {
        String loginName = getLoginName();
        bawActivityClassification.setUpdateBy(loginName);
        return toAjax(bawActivityClassificationService.updateBawActivityClassification(bawActivityClassification));
    }

    /**
     * 删除活动分类
     */
    @RequiresPermissions("wx:baw_activity_classification:remove")
    @Log(title = "活动分类", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawActivityClassificationService.deleteBawActivityClassificationByIds(ids));
    }
}
