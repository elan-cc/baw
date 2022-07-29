package com.ruoyi.wx.controller;

import java.util.List;

import com.ruoyi.web.controller.wx.utils.Utils;
import com.ruoyi.web.domain.BawBaseCarConfigParamDeserialization;
import com.ruoyi.web.domain.BawBaseDealershop;
import com.ruoyi.web.service.IBawBaseDealershopService;
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
import org.springframework.web.multipart.MultipartFile;

/**
 * 门店信息Controller
 *
 * @author ruoyi
 * @date 2022-03-15
 */
@Controller
@RequestMapping("/wx/baw_base_dealershop")
public class BawBaseDealershopController extends BaseController
{
    private String prefix = "wx/baw_base_dealershop";

    @Autowired
    private IBawBaseDealershopService bawBaseDealershopService;

    @RequiresPermissions("wx:baw_base_dealershop:view")
    @GetMapping()
    public String baw_base_dealershop()
    {
        return prefix + "/baw_base_dealershop";
    }

    /**
     * 查询门店信息列表
     */
    @RequiresPermissions("wx:baw_base_dealershop:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawBaseDealershop bawBaseDealershop)
    {
        startPage();
        List<BawBaseDealershop> list = bawBaseDealershopService.selectBawBaseDealershopList(bawBaseDealershop);
        return getDataTable(list);
    }

    /**
     * 导出门店信息列表
     */
    @RequiresPermissions("wx:baw_base_dealershop:export")
    @Log(title = "门店信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawBaseDealershop bawBaseDealershop)
    {
        List<BawBaseDealershop> list = bawBaseDealershopService.selectBawBaseDealershopList(bawBaseDealershop);
        ExcelUtil<BawBaseDealershop> util = new ExcelUtil<BawBaseDealershop>(BawBaseDealershop.class);
        return util.exportExcel(list, "门店信息数据");
    }

    /**
     * 新增门店信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存门店信息
     */
    @RequiresPermissions("wx:baw_base_dealershop:add")
    @Log(title = "门店信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawBaseDealershop bawBaseDealershop)
    {
        return toAjax(bawBaseDealershopService.insertBawBaseDealershop(bawBaseDealershop));
    }

    /**
     * 修改门店信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawBaseDealershop bawBaseDealershop = bawBaseDealershopService.selectBawBaseDealershopById(id);
        mmap.put("bawBaseDealershop", bawBaseDealershop);
        return prefix + "/edit";
    }

    /**
     * 修改保存门店信息
     */
    @RequiresPermissions("wx:baw_base_dealershop:edit")
    @Log(title = "门店信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawBaseDealershop bawBaseDealershop)
    {
        if (!Utils.positiveInteger(String.valueOf(bawBaseDealershop.getLat()))){
            return AjaxResult.error("请输入正确的纬度");
        }
        if (!Utils.positives(String.valueOf(bawBaseDealershop.getLng()))){
            return AjaxResult.error("请输入正确的经度");
        }
        return toAjax(bawBaseDealershopService.updateBawBaseDealershop(bawBaseDealershop));
    }

    /**
     * 删除门店信息
     */
    @RequiresPermissions("wx:baw_base_dealershop:remove")
    @Log(title = "门店信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
        public AjaxResult remove(Integer[] ids)
    {
        return toAjax(bawBaseDealershopService.deleteBawBaseDealershopByIds(ids));
    }

    /**
     * 经销商配置参数导入
     * @param file
     * @param updateSupport
     * @return
     * @throws Exception
     */
    @Log(title = "经销商管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("wx:baw_base_dealershop:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BawBaseDealershop> util = new ExcelUtil<BawBaseDealershop>(BawBaseDealershop.class);
        List<BawBaseDealershop> bawBaseDealershopList = util.importExcel(file.getInputStream());
        String message = bawBaseDealershopService.importBawBaseDealershop(bawBaseDealershopList, getLoginName());
        return AjaxResult.success(message);
    }

    /**
     *车型配置参数模板下载
     * @return
     */
    @RequiresPermissions("wx:baw_base_dealershop:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BawBaseDealershop> util = new ExcelUtil<BawBaseDealershop>(BawBaseDealershop.class);
        return util.importTemplateExcel("经销商参数");
    }

}
