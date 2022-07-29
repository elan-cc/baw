package com.ruoyi.web.controller;

import java.util.List;

import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.web.utils.MyDateUtils;
import com.ruoyi.web.utils.PinYinUtils;
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
import com.ruoyi.web.domain.BawCitys;
import com.ruoyi.web.service.IBawCitysService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 经销商城市Controller
 *
 * @author ruoyi
 * @date 2021-12-15
 */
@Controller
@RequestMapping("/company/baw_citys")
public class BawCitysController extends BaseController
{
    private String prefix = "company/baw_citys";

    @Autowired
    private IBawCitysService bawCitysService;

    @RequiresPermissions("company:baw_citys:view")
    @GetMapping()
    public String baw_citys()
    {
        return prefix + "/baw_citys";
    }

    /**
     * 查询经销商城市列表
     */
    @RequiresPermissions("company:baw_citys:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BawCitys bawCitys)
    {
        bawCitys.setIsDelete(0);
        startPage();
        List<BawCitys> list = bawCitysService.selectBawCitysList(bawCitys);
        return getDataTable(list);
    }

    /**
     * 导出经销商城市列表
     */
    @RequiresPermissions("company:baw_citys:export")
    @Log(title = "经销商城市", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BawCitys bawCitys)
    {
        bawCitys.setIsDelete(0);
        List<BawCitys> list = bawCitysService.selectBawCitysList(bawCitys);
        ExcelUtil<BawCitys> util = new ExcelUtil<BawCitys>(BawCitys.class);
        return util.exportExcel(list, "经销商城市数据");
    }

    /**
     * 新增经销商城市
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存经销商城市
     */
    @RequiresPermissions("company:baw_citys:add")
    @Log(title = "经销商城市", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BawCitys bawCitys)
    {
        bawCitys.setIsDelete(0);
        bawCitys.setAddUser(ShiroUtils.getSysUser().getLoginName());
        bawCitys.setAddDate(Integer.parseInt(MyDateUtils.getTimeStamp10()));
        bawCitys.setCityPinYin(PinYinUtils.getPinyin(bawCitys.getCity()));
        return toAjax(bawCitysService.insertBawCitys(bawCitys));
    }

    /**
     * 修改经销商城市
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        BawCitys bawCitys = bawCitysService.selectBawCitysById(id);
        mmap.put("bawCitys", bawCitys);
        return prefix + "/edit";
    }

    /**
     * 修改保存经销商城市
     */
    @RequiresPermissions("company:baw_citys:edit")
    @Log(title = "经销商城市", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BawCitys bawCitys)
    {
        bawCitys.setCityPinYin(PinYinUtils.getPinyin(bawCitys.getCity()));
        return toAjax(bawCitysService.updateBawCitys(bawCitys));
    }

    /**
     * 删除经销商城市
     */
    @RequiresPermissions("company:baw_citys:remove")
    @Log(title = "经销商城市", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(bawCitysService.deleteBawCitysByIds(ids));
    }
}
